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
import Vista.JFContrasenya;
import Vista.JFLogin;
import Vista.JFPrincipal;
import Vista.JFRegistre;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;




/**
 *
 * @author Victor
 */
public class ControladorLogin  extends JFPrincipal implements ActionListener {
    
    private JFContrasenya contrasenya;    
    private Login mod;
    private ConsultesLogin modC;
    private JFLogin vis;
    private JFPrincipal principal;
    private  JFileChooser jf;
    
    public ControladorLogin(Login mod, ConsultesLogin modC, JFLogin vis, JFPrincipal principal, JFContrasenya contrasenya,  JFileChooser jf){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        this.principal = principal;        
        this.contrasenya = contrasenya;
        this.jf = jf;
        this.vis.btnEntrar.addActionListener(this);
        this.vis.btnRegistre.addActionListener(this);
    
    }
    
    
    public void inicialitzar(){
    
    
    
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("HOlA");
        if (e.getSource() == vis.btnEntrar){
            System.out.println("HOlA");
            mod.setUsuari(vis.txtUsuari.getText().trim());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()).trim());  
            
            //Login exitós
            if (modC.login(mod) == 0){
                
                
                JOptionPane.showMessageDialog(null, "Inici de Sessió Correcte");
                natejar();
                vis.dispose();      
                    
                ControladorMenu con = new ControladorMenu(principal, contrasenya, jf);               
                con.inicialitzar();
               
                
                
                
             
                
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
                ControladorRegistre con = new ControladorRegistre(modRegistre, modCRegistre, vistRegistre, principal,contrasenya, jf);               
                con.inicialitzar();
                vistRegistre.setVisible(true);            
             
         }
        
    
    }
    
    
    public void natejar(){
    
        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);  
    
    }

    public void btn_ElementsMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
        // DashElements();
    }
    
}
