/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client._chat;

import java.sql.*;

/**
 *
 * @author Go
 */
public class db {

    private Connection cn = null;

    public Connection getConexio() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb", "user", "mypassword");
            //JOptionPane.showMessageDialog(null,"Conexion exitosa","Conexion",JOptionPane.INFORMATION_MESSAGE);
            return cn;
        } catch (ClassNotFoundException | SQLException e) {

            //JOptionPane.showMessageDialog(null,"Conexion Fallida"+ e ,"Conexion",JOptionPane.ERROR_MESSAGE);
        }

        return (null);

    }
}
