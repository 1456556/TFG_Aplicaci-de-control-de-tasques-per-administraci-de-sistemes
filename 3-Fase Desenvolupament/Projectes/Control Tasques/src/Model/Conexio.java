/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Conexio {
    
    private Connection cn = null;
    
    public Connection getConexio(){
    
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb","user","mypassword");
            //JOptionPane.showMessageDialog(null,"Conexion exitosa","Conexion",JOptionPane.INFORMATION_MESSAGE);
           
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null,"Conexion Fallida"+ e ,"Conexion",JOptionPane.ERROR_MESSAGE);
        
        }catch(ClassNotFoundException ex){
        
            JOptionPane.showMessageDialog(null,"Conexion Fallida"+ ex ,"Conexion",JOptionPane.ERROR_MESSAGE);
        }
     
         return cn;
    }  
    
}
