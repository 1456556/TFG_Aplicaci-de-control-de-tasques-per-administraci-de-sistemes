/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Enrique
 */
public class DConexion {
    
    static Connection con = null;
    public static Connection getConnection(){
        
        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBGraficas","root","");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return con;
    }
    
}
