/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesLogin;
import Model.ConsultesRegistre;
import Model.Login;
import Model.Registre;
import Vista.JFContrasenya;
import Vista.JFLogin2;
import Vista.JFPrincipal2;
import Vista.JFRegistre2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ControladorRegistre implements ActionListener, MouseListener {

    private Registre mod;
    private ConsultesRegistre modC;
    private JFRegistre2 vis;
    private JFPrincipal2 principal;
    private JFContrasenya contrasenya;
    private JFileChooser jf;

    public ControladorRegistre(Registre mod, ConsultesRegistre modC, JFRegistre2 vis, JFPrincipal2 principal, JFContrasenya contrasenya, JFileChooser jf) {

        this.mod = mod;
        this.contrasenya = contrasenya;
        this.modC = modC;
        this.vis = vis;
        this.principal = principal;
        this.vis.btnRegistrar.addActionListener(this);
        this.vis.jLabelFletxa.addMouseListener((MouseListener) this);
        this.jf = jf;

    }

    public void inicialitzar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.btnRegistrar) {

            mod.setNom(vis.txtNom.getText().trim());
            mod.setCognom(vis.txtCognom.getText().trim());
            mod.setTelefon(vis.txtTelefon.getText().trim());
            mod.setCorreu(vis.txtCorreu.getText().trim());
            mod.setUsuari(vis.txtUsuari.getText().trim());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()).trim());
            mod.setConfirmarContrasenya(String.valueOf(vis.txtContrasenya1.getPassword()).trim());

            try {
                switch (modC.registre(mod)) {

                    case 0:
                        JOptionPane.showMessageDialog(null, "Registre Correcte");
                        natejar();
                        vis.dispose();
                        EnviarCorreu();
                        Login modLogin = new Login();
                        ConsultesLogin modCLogin = new ConsultesLogin();
                        JFLogin2 vistLogin = new JFLogin2();
                        ControladorLogin con = new ControladorLogin(modLogin, modCLogin, vistLogin, principal, contrasenya, jf);
                        con.inicialitzar();
                        vistLogin.setVisible(true);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Nom d'usuari no disponible");

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Error al registar. Contacta amb l'administrador");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps per registrar-te");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Correu incorrecte");
                        vis.txtCorreu.setText(null);
                        break;
                    case 5:
                        String telfon = "<html><body width='%1s'><h1>Telèfon Incorrecte</h1>"
                                + "<p> Ha de contenir com a miním:<br><br>"
                                + "> 9 Dígits <br>"
                                + "> El primer dígit ha de ser (6,7,8,9)<br><br>";
                        JOptionPane.showMessageDialog(null, String.format(telfon, 300, 300));
                        vis.txtTelefon.setText(null);
                        break;
                    case 6:
                        String contrasenya = "<html><body width='%1s'><h1>Contrasenya Incorrecte</h1>"
                                + "<p> Ha de contenir com a miním:<br><br>"
                                + "> 1 Majuscula <br>"
                                + "> 1 Numero <br>"
                                + "> 1 Caràcter especial <br>"
                                + "> 8 Caràcters de longitud <br><br><p>";
                        JOptionPane.showMessageDialog(null, String.format(contrasenya, 300, 300));
                        vis.txtContrasenya.setText(null);
                        vis.txtContrasenya1.setText(null);
                        break;
                    case 7:
                        String contrasenya2 = "<html><body width='%1s'><h1>Les contrasenyes han de concidir</h1>"
                                + "<p> Ha de contenir com a miním:<br><br>"
                                + "> 1 Majuscula <br>"
                                + "> 1 Numero <br>"
                                + "> 1 Caràcter especial <br>"
                                + "> 8 Caràcters de longitud <br><br><p>";
                        JOptionPane.showMessageDialog(null, String.format(contrasenya2, 300, 300));
                        vis.txtContrasenya.setText(null);
                        vis.txtContrasenya1.setText(null);
                        break;
                    default:
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistre.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(ControladorRegistre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void EnviarCorreu() throws AddressException, MessagingException {

        // Get a Properties object
        Properties p = System.getProperties();
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smpt.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.port", "correo");
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);

        MimeMessage msg = new MimeMessage(s);

        try {

            msg.setFrom(new InternetAddress("controltasques@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mod.getCorreu()));
            msg.setSubject("Benvingut a ControlTasques!");
            msg.setText("                Registre correcte          \n"
                    + "                                           \n"
                    + "Nom:   " + mod.getNom() + "                \n"
                    + "Cognom:  " + mod.getCognom() + "               \n"
                    + "Usuari:  " + mod.getUsuari() + "         \n"
                    + "A partir d'ara ja pots utilitzar l'aplicació." + "\n");

            msg.setSentDate(new Date());

            Transport t = s.getTransport("smtp");
            t.connect("victor98calvo@gmail.com", "teylxccdwafmfsgh");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();

            System.out.println("Message sent!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!e.");
        } catch (AddressException ex) {

            System.err.println(ex + "Error al enviar el correu");

        }
    }

    public void natejar() {

        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);
        vis.txtNom.setText(null);
        vis.txtCorreu.setText(null);
        vis.txtTelefon.setText(null);
        vis.txtCognom.setText(null);
        vis.txtContrasenya1.setText(null);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vis.jLabelFletxa) {

            vis.dispose();
            Login mod = new Login();
            ConsultesLogin modC = new ConsultesLogin();
            JFLogin2 vist = new JFLogin2();
            ControladorLogin con = new ControladorLogin(mod, modC, vist, principal, contrasenya, jf);
            con.inicialitzar();
            vist.setVisible(true);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
