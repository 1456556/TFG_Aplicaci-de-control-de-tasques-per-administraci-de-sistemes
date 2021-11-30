/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.JFPrincipal;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;

/**
 *
 * @author Victor
 */
public class ConsultesPerfil extends Conexio {
    
    
    
    public int CanviarContrasenya(Perfil per) {

        int validacio = 0;
        String password = per.getContrasenya1();
        String password_confirmacio = per.getContrasenya2();
        
        Pattern pattern3 = Pattern.compile("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$");
        Matcher matcher3 = pattern3.matcher(password);
        
        if (matcher3.matches()){

        if (!password.equals("") && !password_confirmacio.equals("")) {

            if (password.equals(password_confirmacio)) {

                try {

                    Connection cn = getConexio();
                    PreparedStatement pst = cn.prepareStatement("Update Usuaris set contrassenya=? where usuari = '" + Login.usuari + "'");
                    pst.setString(1, password);
                    pst.executeUpdate();                    
                    validacio = 1;
                    cn.close();

               } catch (SQLException e) {

                    System.err.println("Error al canviar la contrasenya" + e);
                    validacio = 2;

                }

            } else {

                System.err.println("Les contrasenyes no concideixen");
                validacio = 3;

            }

        } else {

            System.err.println("Les contrasenyes son buides");
            validacio = 4;

        }
        
        }else{
            
            System.err.println("Les contrasenyes no compleixen les normes");
            validacio = 5;
        
        }

        return validacio;

    }
    
    public void GuardarFoto(JFPrincipal vis) {
    
            
        
        try {
                    FileInputStream foto;
                    Connection cn = getConexio();
                    PreparedStatement pst = cn.prepareStatement("Update Usuaris set nomImatge=?, imatge=? where usuari = '" + Login.usuari + "'");
                    pst.setString(1, vis.txtNomImatge.getText());
                    foto = new FileInputStream(vis.txtNomImatge.getText());
                    pst.setBinaryStream(2, foto);
                    pst.executeUpdate();                    
                   
                    cn.close();

               } catch (SQLException e) {

                    System.err.println("Error al canviar la foto" + e);
                    

                } catch (FileNotFoundException ex) {
            Logger.getLogger(ConsultesPerfil.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    
    
    public void CargarImatge(JFPrincipal vis) {
    
            
        
        try {
                    
                    
                    Connection cn = getConexio();
                    PreparedStatement pst = cn.prepareStatement("Select nomImatge,imatge  from Usuaris  where usuari = '" + Login.usuari + "'");
                    ResultSet rs = pst.executeQuery();

            if (rs.next()) {              
               
                ImageIcon MyImage = new ImageIcon(rs.getBytes(2));
                Image img = MyImage.getImage();
                Image newImg = img.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(newImg);
                vis.txt_fotoUsuari.setIcon(image);
               
                
                         

            }
                    
                            
                   
                    cn.close();

               } catch (SQLException e) {

                    System.err.println("Error al canviar la foto" + e);
                    

               
    
               }
    
    }
    
    
    
    

}
