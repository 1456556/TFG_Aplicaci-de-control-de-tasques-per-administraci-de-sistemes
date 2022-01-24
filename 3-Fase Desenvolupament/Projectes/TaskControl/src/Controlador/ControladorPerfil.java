/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesPerfil;
import Model.Perfil;
import Vista.JFContrasenya;
import Vista.JFPrincipal2;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ControladorPerfil implements ActionListener {

    public JFContrasenya contrasenya;
    public Perfil mod;
    public ConsultesPerfil modC;
    public JFPrincipal2 vis;
    public boolean valid = true;
    public DefaultTableModel modelTasques;
    public JFileChooser jf;
    public File file, ruta;

    public ControladorPerfil(Perfil mod, ConsultesPerfil modC, JFPrincipal2 vis, JFContrasenya contrasenya, JFileChooser jf) {

        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        this.contrasenya = contrasenya;
        this.jf = jf;
        this.vis.jButtonCanviarContrasenya.addActionListener(this);
        this.contrasenya.GuardarContrasenya.addActionListener(this);
        this.vis.jButtonCanviarFoto.addActionListener(this);
        this.vis.jButtonGuardarFoto.addActionListener(this);
        this.vis.txtNomImatge.setVisible(false);

        this.jf.setFileFilter(new FileNameExtensionFilter("Formatos de archivos JPEG (*.JPG,*.JPEG)", "jpg", "jpeg"));
        this.jf.setDialogTitle("Abrir archiu");
        File ruta = new File("C:/Users/Víctor/Desktop");

    }

    public void inicialitzar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jButtonCanviarContrasenya) {

            contrasenya.setVisible(true);

        }

        if (e.getSource() == vis.jButtonCanviarFoto) {

            this.jf.setCurrentDirectory(ruta);
            int respuesta = this.jf.showOpenDialog(null);

            if (respuesta == JFileChooser.APPROVE_OPTION) {

                file = this.jf.getSelectedFile();
                vis.txtNomImatge.setText(String.valueOf(file));
                Image foto = Toolkit.getDefaultToolkit().getImage(vis.txtNomImatge.getText().trim());
                foto = foto.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
                vis.cLabelFoto.setIcon(new ImageIcon(foto));

                // JOptionPane.showMessageDialog(null, "Foto de perfil canviada correctament");
            }

        }

        if (e.getSource() == vis.jButtonGuardarFoto) {

            modC.GuardarFoto(vis);
            modC.CargarImatge(vis);

        }

        if (e.getSource() == contrasenya.GuardarContrasenya) {

            mod.setContrasenya1(contrasenya.jPasswordField1.getText().trim());
            mod.setContrasenya2(contrasenya.jPasswordField2.getText().trim());
            modC.CanviarContrasenya(mod);

            switch (modC.CanviarContrasenya(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Contrasenya canviada correctament");
                    contrasenya.jPasswordField1.setText("");
                    contrasenya.jPasswordField2.setText("");
                    contrasenya.setVisible(false);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al canviar la contrasenya. Contacta amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Les contrasenyes no concideixen");
                case 4:
                    JOptionPane.showMessageDialog(null, "Les contrasenyes no puden ser buides");
                case 5:
                    String contra = "<html><body width='%1s'><h1>Contrasenya Incorrecte</h1>"
                            + "<p> Ha de contenir com a miním:<br><br>"
                            + "> 1 Majuscula <br>"
                            + "> 1 Numero <br>"
                            + "> 1 Caràcter especial <br>"
                            + "> 8 Caràcters de longitud <br><br><p>";
                    JOptionPane.showMessageDialog(null, String.format(contra, 300, 300));
                    contrasenya.jPasswordField1.setText("");
                    contrasenya.jPasswordField2.setText("");
                    break;
                default:
                    break;

            }

        }

    }

}
