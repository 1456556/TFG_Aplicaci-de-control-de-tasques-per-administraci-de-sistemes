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

    public void so(int so) {

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("Update Usuaris so=? where usuari = '" + Login.usuari + "'");
            if (so == 1) {
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

    public boolean isSo(Configuracio con) {

        boolean so = false;

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("select so from Usuaris where usuari = '" + Login.usuari + "'");
            ResultSet rs = pst2.executeQuery();
            so = rs.getBoolean(1);
            System.out.println("SOOO" + so);
            cn2.close();

        } catch (SQLException e) {

            System.err.println("Error al guardar el so" + e);

        }

        return so;
    }

}
