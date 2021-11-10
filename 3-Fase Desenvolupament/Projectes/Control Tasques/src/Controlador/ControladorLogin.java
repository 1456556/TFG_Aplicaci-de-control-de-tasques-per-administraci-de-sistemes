/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultasLogin;
import Model.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import ventanas.JFLogin;

/**
 *
 * @author Victor
 */
public class ControladorLogin implements ActionListener {
    
    private Login mod;
    private ConsultasLogin modC;
    private JFLogin vis;
    
    public ControladorLogin(Login mod, ConsultasLogin modC, JFLogin vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        this.vis.btnEntrar.addActionListener(this);
    
    }
    
    
    public void inicialitzar(){
    
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if (e.getSource() == vis.btnEntrar){
        
            mod.setUsuari(vis.txtUsuari.getText());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()));  
            
            if (modC.login(mod)){
            
                JOptionPane.showMessageDialog(null, "Inici de Sessió Correcte");
                natejar();
            
            }else{
            
                JOptionPane.showMessageDialog(null, "Dades d'inici de sessió incorrectes");
                natejar();
                
            }
        
        }
    
    }
    
    
    public void natejar(){
    
        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);  
    
    }
    
}
