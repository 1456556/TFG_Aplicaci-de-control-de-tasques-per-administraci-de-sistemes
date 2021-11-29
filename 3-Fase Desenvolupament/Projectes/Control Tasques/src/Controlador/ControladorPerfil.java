/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesNotificacio;
import Model.ConsultesPerfil;
import Model.ConsultesTasques;
import Model.Notificacio;
import Model.Perfil;
import Model.Tasques;
import Vista.JFContrasenya;
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ControladorPerfil implements ActionListener {
    
    
    public Perfil mod;
    public ConsultesPerfil modC;
    public JFPrincipal vis;
    public JFContrasenya contra;
    public DefaultTableModel modelTasques;
      
    
    public ControladorPerfil(Perfil mod, ConsultesPerfil modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
        this.vis.jButtonCanviarContrasenya.addActionListener(this);
        this.vis.jButtonCanviarFoto.addActionListener(this);
        
        
        contra.GuardarContrasneya.addActionListener(this);
        contra.Cancelar.addActionListener(this);
        
    }
    
    
    
    public void inicialitzar(){
    
        
    
    
    }
    
    
    public void actionPerformed(ActionEvent e){       
  
        if (e.getSource() == vis.jButtonCanviarContrasenya) {
            contra = new JFContrasenya();
            contra.setVisible(true);

        }
        
        if (e.getSource() == contra.Cancelar) {
            
            contra.setVisible(false);

        }
        
        if (e.getSource() == vis.jButtonCanviarFoto) {
            
            JFileChooser jf = new JFileChooser();
            jf.setMultiSelectionEnabled(false);
            if (jf.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            
                rsdragdropfiles.RSDragDropFiles.setCopiar(jf.getSelectedFile().toString(), "src/images/icons8-user-32.png");
                vis.cLabelFoto.setIcon(new ImageIcon(jf.getSelectedFile().toString()));
            
            }

        }

        if (e.getSource() == contra.GuardarContrasneya) {

            mod.setContrasenya1(contra.jPasswordField1.getText().trim());
            mod.setContrasenya2(contra.jPasswordField2.getText().trim());
            modC.CanviarContrasenya(mod);

            switch (modC.CanviarContrasenya(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Contrasenya canviada correctament");
                    contra.jPasswordField1.setText("");
                    contra.jPasswordField2.setText("");
                    contra.setVisible(false);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al canviar la contrasenya. Contacta amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Les contrasenyes no concideixen");
                case 4:
                    JOptionPane.showMessageDialog(null, "Les contrasenyes no puden ser buides");
                case 5:
                    String contrasenya = "<html><body width='%1s'><h1>Contrasenya Incorrecte</h1>"
                            + "<p> Ha de contenir com a miním:<br><br>"
                            + "> 1 Majuscula <br>"
                            + "> 1 Numero <br>"
                            + "> 1 Caràcter especial <br>"
                            + "> 8 Caràcters de longitud <br><br><p>";
                    JOptionPane.showMessageDialog(null, String.format(contrasenya, 300, 300));
                    contra.jPasswordField1.setText("");
                    contra.jPasswordField2.setText("");
                    break;
                default:
                    break;

            }

        }

    }

}
    

