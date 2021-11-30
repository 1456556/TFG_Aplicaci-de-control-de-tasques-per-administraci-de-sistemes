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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        this.vis.jButtonGuardarFoto.addActionListener(this);
        this.vis.txtNomImatge.setVisible(false);
        
      /*  contra = new JFContrasenya();
        contra.GuardarContrasneya.addActionListener(this);
        contra.Cancelar.addActionListener(this);*/
        
    }
    
    
    
    public void inicialitzar(){
    
        
    
    
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e){       
  
        if (e.getSource() == vis.jButtonCanviarContrasenya) {
            
            contra.setVisible(true);

        }
        
/*        if (e.getSource() == contra.Cancelar) {
            
            contra.setVisible(false);

        }*/
        //System.out.println("Count of listeners: " + (((this.vis.jButtonCanviarFoto) e.getSource()).getActionListeners().length);
         if (e.getSource() == vis.jButtonCanviarFoto) {
                           

            File file;    
            JFileChooser jf = new JFileChooser();
            jf.setFileFilter(new FileNameExtensionFilter("Formatos de archivos JPEG (*.JPG,*.JPEG)", "jpg", "jpeg"));
            jf.setDialogTitle("Abrir archiu");
            File ruta = new File("C:/Users/Víctor/Desktop");
            jf.setCurrentDirectory(ruta);
            int respuesta  = jf.showOpenDialog(null);       
           
            
            if (respuesta == JFileChooser.APPROVE_OPTION){
                
                file = jf.getSelectedFile();
                vis.txtNomImatge.setText(String.valueOf(file));
                Image foto = Toolkit.getDefaultToolkit().getImage(vis.txtNomImatge.getText().trim());              
                foto = foto.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                vis.cLabelFoto.setIcon(new ImageIcon(foto));
                
                
            
            }
                
        }
        
        
        
        
        if (e.getSource() == vis.jButtonGuardarFoto) {
            
           
                modC.GuardarFoto(vis);
                modC.CargarImatge(vis);
           
        }

       /* if (e.getSource() == contra.GuardarContrasneya) {

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

        }*/

    }

  

}
    

