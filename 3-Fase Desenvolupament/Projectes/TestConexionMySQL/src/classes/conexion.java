/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Victor
 */
public class conexion {
    
    Connection conectar=null;
    
    public Connection conectar(){
    
        try{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testdb","user","mypassword");
            JOptionPane.showMessageDialog(null,"Conexion exitosa","Conexion",JOptionPane.INFORMATION_MESSAGE);
            
        }catch(ClassNotFoundException | SQLException e){
            
            JOptionPane.showMessageDialog(null,"Conexion Fallida"+ e ,"Conexion",JOptionPane.ERROR_MESSAGE);
        
        }
     
        return (null);
    }  
    
    
}
