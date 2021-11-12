/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import static java.awt.PageAttributes.MediaType.A;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.text.html.HTML.Tag.S;


/**
 *
 * @author Victor
 */
public class ConsultesRegistre extends Conexio {
    
        private int registre;   
        
    
    
    
     public int registre(Registre reg) throws SQLException {                                                 
        // TODO add your handling code here:
        int validacio = 0;
        String nom = reg.getNom();
        String cognom = reg.getCognom();
        String telefon = reg.getTelefon();
        String correu = reg.getCorreu();
        String usuari = reg.getUsuari();
        String contrasenya = reg.getContrasenya();
        reg.setNivell("Administrador");
        reg.setEstat("Actiu");
        String estat = reg.getEstat();
        String nivell = reg.getNivell();
        
       
        if (correu.equals("")){
           
            validacio++;
        }
        if (nom.equals("")){
           
            validacio++;
        }
        if (cognom.equals("")){
           
            validacio++;
        }
        if (telefon.equals("")){

           validacio++;
        }
        if (usuari.equals("")){
            
            validacio++;
        }
        if (contrasenya.equals("")){
           
            validacio++;
        }
        
        
        
       
            
        try{

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select usuari from Usuaris where usuari = '" + usuari + "'" );
            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                
                cn.close();
                registre = 1;             
                               
                
            }  
            
            else{
                
                cn.close();
                if (validacio == 0){
                    try{

                    
                    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                    Matcher mather = pattern.matcher(correu);
                    
                    Pattern pattern2 =  Pattern.compile("^[6-7-8-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]$");                    
                    Matcher matcher2 = pattern2.matcher(telefon);
                    
                    Pattern pattern3 = Pattern.compile("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$");
                    Matcher matcher3 = pattern3.matcher(contrasenya);
  
                    
                
                    if (mather.find() == false) {
             
                        registre = 4;
                        
                    }else if ((telefon.length() != 9) || (!matcher2.matches())){
                    
                        registre = 5;
                    
                    
                    }else if(!matcher3.matches()){
                    
                        registre = 6;
                    
                    }else{ 
                           
                        
                        Connection cn2 = getConexio();
                        PreparedStatement pst2 = cn2.prepareStatement("insert into Usuaris values (?,?,?,?,?,?,?,?,?)");
                        pst2.setInt(1,0);
                        pst2.setString(2,nom);
                        pst2.setString(3,cognom);
                        pst2.setString(4,telefon);
                        pst2.setString(5,correu);
                        pst2.setString(6,usuari);
                        pst2.setString(7,contrasenya);
                        pst2.setString(8,nivell);
                        pst2.setString(9,estat);

                        pst2.executeUpdate();
                        cn2.close();
                        
                        
                        
                        registre = 0;
                        
                    }
                        
                        
                        
                        

                    }catch (SQLException e){
                        
                        System.err.println("Error en Registrar l'Usuari" + e);
                        registre = 2;                      
                        
                    }

                    
                    
                }else{             
                    
                        return registre = 3;                  

                }
                

                
                
            }

        }catch (SQLException e){
            
            System.err.println("Error en validar el nom d'usuari" + e);
            return registre = 2;
            
            
        }
        
        
        

        return registre;
        
    } 
    
}
