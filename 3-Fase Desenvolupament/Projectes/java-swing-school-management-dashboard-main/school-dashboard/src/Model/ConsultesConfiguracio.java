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
public class ConsultesConfiguracio {

    public void so(Configuracio con) {

        boolean so = con.getSo();

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("Update Usuaris set so=? where usuari = '" + Login.usuari + "'");

            if (so) {
                pst2.setBoolean(1, true);

            } else {
                pst2.setBoolean(1, false);
            }
            pst2.executeUpdate();
            cn2.close();
            System.err.println("So Modificat");

        } catch (SQLException e) {

            System.err.println("Error al modificar el so" + e);

        }

    }

    public void isSo(Configuracio con) {

        boolean so = false;

        try {

            Connection cn = MVC.Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select so from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                so = rs.getBoolean(1);
                con.setSo(so);
                System.out.println("SOOO" + so);
            }
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al guardar el so" + e);

        }

    }

    public void enviarCorreu(Configuracio con) {

        boolean enviarCorreu = con.getEnviarCorreu();

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("Update Usuaris set enviarCorreu=? where usuari = '" + Login.usuari + "'");

            if (enviarCorreu) {
                pst2.setBoolean(1, true);

            } else {
                pst2.setBoolean(1, false);
            }
            pst2.executeUpdate();
            cn2.close();
            System.err.println("enviarCorreu Modificat");

        } catch (SQLException e) {

            System.err.println("Error al modificar enviarCorreu" + e);

        }

    }

    public void isEnviarCorreu(Configuracio con) {

        boolean enviarCorreu = false;

        try {

            Connection cn = MVC.Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select enviarCorreu from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                enviarCorreu = rs.getBoolean(1);
                con.setEnviarCorreu(enviarCorreu);
                System.out.println("SOOO" + enviarCorreu);
            }
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al guardar el enviarCorreu" + e);

        }

    }

}
