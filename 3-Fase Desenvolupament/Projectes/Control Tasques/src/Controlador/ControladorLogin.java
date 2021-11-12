/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesLogin;
import Model.ConsultesRegistre;
import Model.ConsultesTasques;
import Model.Login;
import Model.Registre;
import Model.Tasques;
import Vista.JFLogin;
import Vista.JFPrincipal;
import Vista.JFRegistre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;




/**
 *
 * @author Victor
 */
public class ControladorLogin implements ActionListener {
    
    private Login mod;
    private ConsultesLogin modC;
    private JFLogin vis;
    
    public ControladorLogin(Login mod, ConsultesLogin modC, JFLogin vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        this.vis.btnEntrar.addActionListener(this);
        this.vis.btnRegistre.addActionListener(this);
    
    }
    
    
    public void inicialitzar(){
    
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
    
        if (e.getSource() == vis.btnEntrar){
        
            mod.setUsuari(vis.txtUsuari.getText().trim());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()).trim());  
            
            //Login exitós
            if (modC.login(mod) == 0){
                
                
                JOptionPane.showMessageDialog(null, "Inici de Sessió Correcte");
                natejar();
                vis.dispose();
                /*Tasques modTasques = new Tasques();
                ConsultesTasques modCTasques = new ConsultesTasques();
                JFPrincipal vistPrincipal = new JFPrincipal();
                ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vistPrincipal);               
                con.inicialitzar();
                vistPrincipal.setVisible(true);*/
                
                JFPrincipal vistPrincipal = new JFPrincipal();              
                ControladorMenu con = new ControladorMenu(vistPrincipal);               
                con.inicialitzar();
                vistPrincipal.setVisible(true);
                vistPrincipal.DashTasques.setVisible(true);
                 vistPrincipal.DashInfoUsuari.setVisible(false);
                 vistPrincipal.DashInfoTasca.setVisible(false);
                 vistPrincipal.DashNovaTasca.setVisible(false);
                 vistPrincipal.DashConfiguracio.setVisible(false);
                 vistPrincipal.DashTasques.setVisible(true);
                 vistPrincipal.DashNouUsuari.setVisible(false);
                 vistPrincipal.DashNouElement.setVisible(false);
                 vistPrincipal.DashUsuaris.setVisible(false);
                 vistPrincipal.DashElements.setVisible(false);
                 vistPrincipal.DashInfoElement.setVisible(false);
                
                
            //Login no exitós
            }else{
                
                switch (modC.login(mod)) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Dades d'inici de sessió incorrectes");
                        natejar();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Error d'inici de sessió. Contacta amb l'administrador");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                        break;
                    default:
                        break;
                }               
                
            }
        
        }
        
        
         if (e.getSource() == vis.btnRegistre){                 
                
                vis.dispose();                
                Registre modRegistre = new Registre();
                ConsultesRegistre modCRegistre = new ConsultesRegistre();
                JFRegistre vistRegistre = new JFRegistre();
                ControladorRegistre con = new ControladorRegistre(modRegistre, modCRegistre, vistRegistre);               
                con.inicialitzar();
                vistRegistre.setVisible(true);            
             
         }
        
    
    }
    
    
    public void natejar(){
    
        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);  
    
    }
    
}
