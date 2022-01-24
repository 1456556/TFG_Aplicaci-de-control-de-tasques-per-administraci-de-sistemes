/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.JFContrasenya;
import Vista.JFPrincipal;
import Vista.JFPrincipal2;
import Vista.JFR2FA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Victor
 */
public class Controlador2FA extends JFPrincipal implements ActionListener {

    private JFContrasenya contrasenya;
    private JFR2FA vis;
    private JFPrincipal2 principal;
    private JFileChooser jf;
    String nom;
    int tel;
    int opt;

    public Controlador2FA(JFPrincipal2 principal, JFContrasenya contrasenya, JFileChooser jf, JFR2FA vis, String nom, int tel) {

        this.vis = vis;
        this.principal = principal;
        this.contrasenya = contrasenya;
        this.jf = jf;
        this.vis.btnEntrar1.addActionListener(this);
        this.nom = nom;
        this.tel = tel;

    }

    public void inicialitzar() {

        Random rand = new Random();
        opt = rand.nextInt(999999);

        //Se fija el tiempo m�ximo de espera para conectar con el servidor (5000)
        //Se fija el tiempo m�ximo de espera de la respuesta del servidor (60000)
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(5000)
                .setSocketTimeout(60000)
                .build();

        //Se inicia el objeto HTTP
        HttpClientBuilder builder = HttpClientBuilder.create();
        builder.setDefaultRequestConfig(config);
        CloseableHttpClient httpClient = builder.build();

        //Se fija la URL sobre la que enviar la petici�n POST
        HttpPost post = new HttpPost("http://www.altiria.net/api/http");

        //Se crea la lista de par�metros a enviar en la petici�n POST
        List<NameValuePair> parametersList = new ArrayList<NameValuePair>();
        //XX, YY y ZZ se corresponden con los valores de identificaci�n del
        //usuario en el sistema.
        parametersList.add(new BasicNameValuePair("cmd", "sendsms"));
        //domainId solo es necesario si el login no es un email
        //parametersList.add(new BasicNameValuePair("domainId", "XX"));
        parametersList.add(new BasicNameValuePair("login", "controltasques@gmail.com"));
        parametersList.add(new BasicNameValuePair("passwd", "pbdnmdgy"));
        parametersList.add(new BasicNameValuePair("dest", "34" + tel));
        parametersList.add(new BasicNameValuePair("msg", nom + " aquest es el teu codi de verificacio " + opt));
        //No es posible utilizar el remitente en Am�rica pero s� en Espa�a y Europa
        //Descomentar la l�nea solo si se cuenta con un remitente autorizado por Altiria
        //parametersList.add(new BasicNameValuePair("senderId", "remitente"));

        try {
            //Se fija la codificacion de caracteres de la peticion POST
            post.setEntity(new UrlEncodedFormEntity(parametersList, "UTF-8"));
        } catch (UnsupportedEncodingException uex) {
            System.out.println("ERROR: codificaci�n de caracteres no soportada");
        }

        CloseableHttpResponse response = null;

        try {
            System.out.println("Enviando petici�n");
            //Se env�a la petici�n
            response = httpClient.execute(post);
            //Se consigue la respuesta
            String resp = EntityUtils.toString(response.getEntity());

            //Error en la respuesta del servidor
            if (response.getStatusLine().getStatusCode() != 200) {
                System.out.println("ERROR: C�digo de error HTTP:  " + response.getStatusLine().getStatusCode());
                System.out.println("Compruebe que ha configurado correctamente la direccion/url ");
                System.out.println("suministrada por Altiria");
                return;
            } else {
                //Se procesa la respuesta capturada en la cadena 'response'
                if (resp.startsWith("ERROR")) {
                    System.out.println(resp);
                    System.out.println("C�digo de error de Altiria. Compruebe las especificaciones");
                } else {
                    System.out.println(resp);
                }
            }
        } catch (Exception r) {
            System.out.println("Excepci�n");
            r.printStackTrace();
            return;
        } finally {
            //En cualquier caso se cierra la conexi�n
            post.releaseConnection();
            if (response != null) {
                try {
                    response.close();
                } catch (IOException ioe) {
                    System.out.println("ERROR cerrando recursos");
                }
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.btnEntrar1) {

            if (Integer.parseInt(vis.txtVer.getText()) == opt) {

                //JOptionPane.showConfirmDialog(null, "Login Successfully");
                vis.dispose();
                ControladorMenu menu = new ControladorMenu(principal, contrasenya, jf);
                menu.inicialitzar();
            } else {

                JOptionPane.showMessageDialog(null, "Codi de verificacio incorrecte");

            }

        }

    }

}
