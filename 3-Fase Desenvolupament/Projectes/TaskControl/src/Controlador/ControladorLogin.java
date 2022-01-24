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
import Vista.JFLogin2;
import Vista.JFPrincipal;
import Vista.JFPrincipal2;
import Vista.JFR2FA;
import Vista.JFRegistre2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ControladorLogin extends JFPrincipal implements ActionListener {
    
    private JFContrasenya contrasenya;
    private Login mod;
    private ConsultesLogin modC;
    private JFLogin2 vis;
    private JFPrincipal2 principal;
    private JFileChooser jf;
    int opt;
    
    public ControladorLogin(Login mod, ConsultesLogin modC, JFLogin2 vis, JFPrincipal2 principal, JFContrasenya contrasenya, JFileChooser jf) {
        
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        this.principal = principal;
        this.contrasenya = contrasenya;
        this.jf = jf;
        this.vis.btnEntrar.addActionListener(this);
        this.vis.btnRegistre.addActionListener(this);
        
    }
    
    public void inicialitzar() {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HOlA");
        if (e.getSource() == vis.btnEntrar) {
            System.out.println("HOlA");
            mod.setUsuari(vis.txtUsuari.getText().trim());
            mod.setContrasenya(String.valueOf(vis.txtContrasenya.getPassword()).trim());

            //Login exitós
            if (modC.login(mod) == 0) {
                String nom = vis.txtUsuari.getText().trim();
                
                natejar();
                vis.dispose();
                modC.isdobleFactor(mod);
                
                if (mod.getDobleFactor()) {
                    
                    modC.tel(mod);
                    int tel = mod.getTel();
                    System.out.print("ssdsd" + tel);
                    JFR2FA fa = new JFR2FA();
                    Controlador2FA con2fa = new Controlador2FA(principal, contrasenya, jf, fa, nom, tel);
                    con2fa.inicialitzar();
                    fa.setVisible(true);
                    
                } else {
                    
                    ControladorMenu menu = new ControladorMenu(principal, contrasenya, jf);
                    menu.inicialitzar();
                    
                }

                //Login no exitós
            } else {
                
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
        
        if (e.getSource() == vis.btnRegistre) {
            
            vis.dispose();
            Registre modRegistre = new Registre();
            ConsultesRegistre modCRegistre = new ConsultesRegistre();
            JFRegistre2 vistRegistre = new JFRegistre2();
            ControladorRegistre con = new ControladorRegistre(modRegistre, modCRegistre, vistRegistre, principal, contrasenya, jf);
            con.inicialitzar();
            vistRegistre.setVisible(true);
            
        }
        
    }
    
    public void natejar() {
        
        vis.txtUsuari.setText(null);
        vis.txtContrasenya.setText(null);
        
    }
    
    public void btn_ElementsMouseClicked(MouseEvent evt) {
        // TODO add your handling code here:
        // DashElements();
    }
    
}
