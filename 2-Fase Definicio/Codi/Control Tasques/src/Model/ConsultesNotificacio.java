/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public class ConsultesNotificacio extends Conexio {

    public int Notificacio(Notificacio not) {

        int notificacio = 0;
        String d = not.getData();

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Tasques where data = '" + d + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

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

                } else {

                    if (rs.getBoolean("SetNotificacio") == true && rs.getBoolean("recurrent") == false) {

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
