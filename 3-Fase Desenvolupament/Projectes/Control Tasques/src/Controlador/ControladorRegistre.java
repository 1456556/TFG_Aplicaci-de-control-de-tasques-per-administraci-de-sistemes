/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesLogin;
import Model.ConsultesRegistre;
import Model.Login;
import Model.Registre;
import Vista.JFContrasenya;
import Vista.JFLogin;
import Vista.JFPrincipal;
import Vista.JFRegistre;
import Vista.JFRepeticio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author Victor
 */
public class ControladorRegistre implements ActionListener{
    
    private Registre mod;
    private ConsultesRegistre modC;
    private JFRegistre vis;
    private JFPrincipal principal;
    private JFRepeticio repeticio;
    private JFContrasenya contrasenya;
    private  JFileChooser jf;
    
    public ControladorRegistre(Registre mod, ConsultesRegistre modC, JFRegistre vis, JFPrincipal principal, JFRepeticio repeticio, JFContrasenya contrasenya,  JFileChooser jf){
    
        this.mod = mod;
        this.repeticio = repeticio;
        this.contrasenya = contrasenya;
        this.modC = modC;
        this.vis = vis;
        this.principal = principal;
        this.vis.btnRegistrar.addActionListener(this);
        this.jf = jf;
        
    }
    
    
    public void inicialitzar(){    
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == vis.btnRegistrar){
            
            mod.setNom(vis.txtNom.getText().trim());
            mod.setCognom(vis.txtCognom.getText().trim());
            mod.setTelefon(vis.txtTelefon.getText().trim());
            mod.setCorreu(vis.txtCorreu.getText().trim());            
            mod.setUsuari(vis.txtUsuari.getText().trim());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()).trim());            
                        
            try {
                switch (modC.registre(mod)) {
                    
                    case 0:
                        JOptionPane.showMessageDialog(null, "Registre Correcte");
                        natejar();
                        vis.dispose();
                        Login modLogin = new Login();
                        ConsultesLogin modCLogin = new ConsultesLogin();
                        JFLogin vistLogin = new JFLogin();
                        ControladorLogin con = new ControladorLogin(modLogin, modCLogin, vistLogin, principal, repeticio, contrasenya, jf);
                        con.inicialitzar();
                        vistLogin.setVisible(true);
                        break;                        
                    case 1:
                        JOptionPane.showMessageDialog(null, "Nom d'usuari no disponible");
                        
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Error al registar. Contacta amb l'administrador");                        
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps per registrar-te");
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Correu incorrecte");
                        vis.txtCorreu.setText(null);
                        break;
                    case 5:
                        String telfon = "<html><body width='%1s'><h1>Telèfon Incorrecte</h1>"
                        + "<p> Ha de contenir com a miním:<br><br>"                       
                        + "> 9 Dígits <br>"
                        + "> El primer dígit ha de ser (6,7,8,9)<br><br>";                                      
                        JOptionPane.showMessageDialog(null, String.format(telfon, 300, 300));
                        vis.txtTelefon.setText(null);
                        break;
                    case 6:
                       String contrasenya = "<html><body width='%1s'><h1>Contrasenya Incorrecte</h1>"
                        + "<p> Ha de contenir com a miním:<br><br>"                       
                        + "> 1 Majuscula <br>"
                        + "> 1 Numero <br>"
                        + "> 1 Caràcter especial <br>"
                        + "> 8 Caràcters de longitud <br><br><p>";                
                        JOptionPane.showMessageDialog(null, String.format(contrasenya, 300, 300));
                        vis.txtContrasenya.setText(null);
                        break;
                    default:
                        break;              
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorRegistre.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }              
        
        }
        
     
     public void natejar(){
    
        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);
        vis.txtNom.setText(null);
        vis.txtCorreu.setText(null);
        vis.txtTelefon.setText(null);
        vis.txtCognom.setText(null);
    
    }
    
}
