/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {

    private static String us = "user";
    private static String pas = "mypassword";
    private static String bd = "testdb";
    private static String url = "jdbc:mysql://127.0.0.1:3306/"+bd;

    public static String getUs() {
        return us;
    }

    public static String getPas() {
        return pas;
    }

    public static String getBd() {
        return bd;
    }

    private Connection con = null;
    
    public Conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, us,pas);
            
            if(con!=null){
                System.out.println("Conexion en Linea");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public Connection getConectar(){
        return con;
    }
    public void desconectar(){
        con = null;
    }

    public static void main(String[] args) {
        Conectar c = new Conectar();
        c.getConectar();
    }
    
}
