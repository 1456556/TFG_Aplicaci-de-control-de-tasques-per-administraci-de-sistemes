/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controlador.ControladorNotificacio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Victor
 */
public class ConsultesNotificacio extends Conexio {

    public void ControladorXat() {

        // int controlador = 0;
        String controlador = "";

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select xat from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                controlador = rs.getString(1);

                String[] aux = controlador.split("\n");

                for (int i = 0; i < aux.length; i++) {

                    ControladorNotificacio.resultados.add(i, aux[i]);
                    System.out.println("Notificacio XAT " + ControladorNotificacio.resultados.get(i));
                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println(e + "Error al buscar el id del grup per mostrar la taula a infotasques");

        }

    }

    public String TitolTasca(int id) {

        String titol = "";

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select titol from Tasques where id_tasca = '" + id + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                titol = rs.getString(1);

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println(e + "Error al buscar el id del grup per mostrar la taula a infotasques");

        }

        return titol;

    }

    public String MSGTasca(int id) {
        Conexio d = new Conexio();

        String miss = "";

        try {

            Connection cn = d.getConexio();
            PreparedStatement pst = cn.prepareStatement("SELECT msg FROM Tasques WHERE id_tasca='" + id + "'");
            ResultSet rs = pst.executeQuery();
            String missatge = "";
            while (rs.next()) {
                DefaultListModel cm = new DefaultListModel();
                java.sql.Blob ablob = rs.getBlob(1);
                missatge = new String(ablob.getBytes(1l, (int) ablob.length()));

                System.out.println("missatge" + missatge);
                String[] parts = missatge.split(";");
                System.out.println(parts.toString());
                for (int i = 0; i < parts.length; i++) {

                    cm.addElement(parts[i].toString());

                }

                miss = parts[parts.length - 1].toString();
            }

        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }
        return miss;
    }

    public void DeleteControladorXat(ArrayList<String> resultados) {

        for (int i = 0; i < resultados.size(); i++) {

            ControladorNotificacio.resultados.remove(i);

        }
        Conexio d = new Conexio();
        /* for (int i = 0; i < resultados.size(); i++) {

            if (Integer.valueOf((String) resultados.get(i)) == idTasca) {

                String su = String.valueOf(idTasca);
                resultados.remove(i);

                for (int j = 0; j < resultados.size(); j++) {

                    String aux = (String) resultados.get(j);

                    //if (j == resultados.size() - 1) {
                    if (j == 0) {

                        idxat = idxat + aux;
                    } else {
                        idxat = idxat + aux + "\n";
                    }

                    //}else{
                    // idxat = aux
                }*/

        try {

            Connection cn = d.getConexio();

            PreparedStatement s = cn.prepareStatement("Update Usuaris SET xat=? WHERE usuari='" + Login.usuari + "'");

            s.setString(1, "0");

            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

    }

    public int Notificacio(Notificacio not) {

        int notificacio = 0;
        String d = not.getData();

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Tasques where data = '" + d + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                if (rs.getBoolean("SetNotificacio")) {

                    if (rs.getBoolean("recurrent") == true && rs.getString("dataProgres").equals("") && rs.getBoolean("notificacio") == false) {

                        not.setIdTasca(rs.getInt("id_tasca"));
                        not.setData(rs.getString("data"));
                        not.titol = rs.getString("titol");
                        not.usuari = rs.getString("usuari");
                        not.descripcio = rs.getString("descripcio");
                        not.estat = rs.getString("estat");
                        not.prioritat = rs.getString("prioritat");
                        not.setData_final(rs.getString("dataFinal"));
                        not.setDataProgres(rs.getString("dataProgres"));
                        not.repeticio = rs.getInt("repeticioInici");
                        not.setRecurrent(rs.getBoolean("recurrent"));
                        notificacio = 1;

                    }

                    if (rs.getBoolean("recurrent") == false && rs.getBoolean("notificacio") == false) {

                        not.setIdTasca(rs.getInt("id_tasca"));
                        not.setData(rs.getString("data"));
                        not.titol = rs.getString("titol");
                        not.usuari = rs.getString("usuari");
                        not.descripcio = rs.getString("descripcio");
                        not.estat = rs.getString("estat");
                        not.prioritat = rs.getString("prioritat");
                        not.setRecurrent(rs.getBoolean("recurrent"));
                        notificacio = 2;

                    }

                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Tasques where dataProgres = '" + d + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                if (rs.getBoolean("setNotificacio") == true && rs.getBoolean("notificacio") == false) {

                    if (rs.getBoolean("recurrent") == true && !rs.getString("dataProgres").equals("")) {

                        not.setIdTasca(rs.getInt("id_tasca"));
                        not.setData(rs.getString("data"));
                        not.titol = rs.getString("titol");
                        not.usuari = rs.getString("usuari");
                        not.descripcio = rs.getString("descripcio");
                        not.estat = rs.getString("estat");
                        not.prioritat = rs.getString("prioritat");
                        not.setData_final(rs.getString("dataFinal"));
                        not.setDataProgres(rs.getString("dataProgres"));
                        not.repeticio = rs.getInt("repeticioInici");
                        not.setRecurrent(rs.getBoolean("recurrent"));
                        not.dataProgres = rs.getString("dataProgres");
                        notificacio = 1;

                    }

                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select email from Usuaris where usuari = '" + not.getUsuari() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                not.mail = rs.getString("email");

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar el mail per enviar el correu" + e);
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        return notificacio;

    }

    public void ActualitzaNotificacio(Notificacio tas) {

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("update Tasques set notificacio=? where id_tasca = '" + tas.getIdTasca() + "'");
            pst.setInt(1, 1);
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al modificar la notificacio" + e);

        }

    }

    public void Posposar(Notificacio not) {

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("update Tasques set data=? where id_tasca = '" + not.getIdTasca() + "'");

            pst.setString(1, not.getData());
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al modificar la notificacio" + e);

        }

    }

}
