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
public class ConsultesLogin extends Conexio {

    private int login;

    public int login(Login log) {

        String usuari = log.getUsuari();
        String contrasenya = log.getContrasenya();

        if (!usuari.equals("") || !contrasenya.equals("")) {

            try {
                Connection cn = getConexio();
                PreparedStatement pst = cn.prepareStatement(
                        "select nivell from Usuaris where usuari = '" + usuari + " ' and contrassenya = '" + contrasenya + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    String nivell = rs.getString("nivell");
                    if (nivell.equalsIgnoreCase("Administrador")) {

                        login = 0;
                    }

                } else {

                    login = 1;
                }

            } catch (SQLException e) {

                System.err.println("Error en el boto ENTRAR" + e);
                login = 2;

            }

        } else {

            login = 3;

        }

        return login;
    }

    public void isdobleFactor(Login mod) {

        boolean dobleFactor = false;

        try {

            Connection cn = MVC.Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select dobleFactor from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                dobleFactor = rs.getBoolean(1);
                mod.setDobleFactor(dobleFactor);
                System.out.println("dobleFactor" + dobleFactor);
            }
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al guardar el dobleFactor" + e);

        }

    }

    public void tel(Login mod) {

        int tel;

        try {

            Connection cn = MVC.Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select telefon from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                tel = rs.getInt(1);
                mod.setTel(tel);
                System.out.println("Telefon" + tel);
            }
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al guardar el telefon" + e);

        }

    }

}
