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
import javax.swing.JOptionPane;
import static ventanas.JFLogin.usuari;
import ventanas.Principal;

/**
 *
 * @author Victor
 */
public class ConsultasLogin extends Conexio {
    
    private boolean login;

    
    public boolean login(Login log){
    
        String usuari = log.getUsuari();
        String contrasenya = log.getContrasenya();

        if (!usuari.equals("") || !contrasenya.equals("")){

      
      
            try{
                Connection cn = getConexio();
                PreparedStatement pst = cn.prepareStatement(
                    "select nivell from Usuaris where usuari = '" + usuari + " ' and contrassenya = '" + contrasenya + "'");
                ResultSet rs = pst.executeQuery();
                

                if (rs.next()){

                    String nivell = rs.getString("nivell");
                    if (nivell.equalsIgnoreCase("Administrador")){
                        
                        login = true;
                       // this.dispose();
                       // Principal s = new Principal();
                        //s.DashTasques();
                       // s.setVisible(true);
                    }          
                    
                      
                }else{
                    
                    login = false;
                   // txt_usuari.setText("");
                    //txt_contraseña.setText("");

                }

            }catch(SQLException e){
                System.err.println("Error en el boto ENTRAR" + e);
                JOptionPane.showMessageDialog(null, "Error d'inici de sessió. Contacta amb l'administrador");
                //login = false;
            }

        }else{
            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
            //login = false;
        }
        
        return login;
    
    
    }
    
}
    
    
    
    

