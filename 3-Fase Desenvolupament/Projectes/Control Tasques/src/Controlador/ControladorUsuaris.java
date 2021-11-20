/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesTasques;
import Model.ConsultesUsuaris;
import Model.Tasques;
import Model.Usuaris;
import Vista.JFPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Victor
 */
public class ControladorUsuaris implements ActionListener, MouseListener, KeyListener  {
    
    private Usuaris mod;
    private ConsultesUsuaris modC;
    private JFPrincipal vis;
    
    public DefaultTableModel  modelUsuaris;
      
    
    public ControladorUsuaris(Usuaris mod, ConsultesUsuaris modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
        this.vis.jButtonNouUsuari.addActionListener(this);
        this.vis.jButtonEliminarUsuari.addActionListener(this);
        this.vis.jButtonRegistarUsuari.addActionListener(this);
        this.vis.jTable_Usuaris.addMouseListener(this);  
        this.vis.jButtonEditarUsuari.addActionListener(this);
        this.vis.txtBuscadorUsuaris.addKeyListener(this);
    }
    
    
    
    public void inicialitzar(){
                  
        MostrarTaula();
    
    }
    
    
    public void MostrarTaula(){
    
        
        
         DefaultTableModel model_usuaris = new DefaultTableModel();
         
         
         model_usuaris.addColumn("Seleccionar");
         model_usuaris.addColumn("Nom");
         model_usuaris.addColumn("Cognom");
         model_usuaris.addColumn("Usari");
         model_usuaris.addColumn("Nivell");
         model_usuaris.addColumn("Estat");
         model_usuaris.addColumn("ID");
         
         Object [] columna = new Object[7];
         
         int numRegistres = modC.MostrarUsuaris().size();
         System.out.println("Num: " + numRegistres);
        // int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();
         
         for (int i = 0; i < numRegistres; i++){
         
             
             columna[1] = modC.MostrarUsuaris().get(i).getNom();
             columna[2] = modC.MostrarUsuaris().get(i).getCognom();
             columna[3] = modC.MostrarUsuaris().get(i).getUsuari();
             columna[4] = modC.MostrarUsuaris().get(i).getNivell();
             columna[5] = modC.MostrarUsuaris().get(i).getEstat();
             columna[6] = modC.MostrarUsuaris().get(i).getId();
             model_usuaris.addRow(columna);
             
             
             mod.setId(modC.MostrarUsuaris().get(i).getId());
             modC.GuardarId(mod);
            
         }
         
         for (int i = 0; i < numRegistres; i++) {

            model_usuaris.setValueAt(false, i, 0);

        }
         
            vis.jTable_Usuaris.setModel(model_usuaris);            
            modelUsuaris = model_usuaris;
            addCheckBox(0, vis.jTable_Usuaris);  
            vis.jTable_Usuaris.removeColumn(vis.jTable_Usuaris.getColumnModel().getColumn(6));
             
             
    
     }    
    
    
    
      public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));       

    }
    
    
    
    
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
         if (e.getSource() == vis.jButtonNouUsuari){
            
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(true);
        }
        
        if (e.getSource() == vis.jButtonRegistarUsuari){
            
            System.out.println("HOlA");
            String nivell_string = null, estat_string = null;
            mod.setNom(vis.txt_nom1.getText().trim());
            mod.setCognom(vis.txt_cognom1.getText().trim());
            mod.setTelefon(vis.txt_telefon1.getText().trim());
            mod.setUsuari(vis.txt_usuari1.getText().trim());     
            mod.setMail(vis.txt_mail1.getText().trim());
            //mod.setContrasenya(vis.txt_.getText().trim());
            int estat = vis.ComboEstat1.getSelectedIndex() + 1;            
            int nivell = vis.ComboNivell1.getSelectedIndex() + 1;
            
            
           if (nivell == 1) {

                nivell_string = "Administrador";

            }
            if (nivell == 2) {

                nivell_string = "Oficinista";
            }
            if (nivell == 3) {

                nivell_string = "Operari";

            }

            if (estat == 1) {

                estat_string = "Actiu";
            }

            if (estat == 2) {

                estat_string = "No Actiu";

            }
            
            mod.setEstat(estat_string);
            mod.setNivell(nivell_string);
            
            
            
            switch (modC.NouUsuari(mod)) {     
                 
                       
                case 1:
                    JOptionPane.showMessageDialog(null, "Usuari Creat Correctament!");           
                    natejar();                   
                    vis.DashNouUsuari.setVisible(false);
                    vis.DashUsuaris.setVisible(true);
                    MostrarTaula();                                
                    break;                
                case 2:
                    JOptionPane.showMessageDialog(null,"Error al crear l'usuari. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");                    
                    break;
                default:
                    break;                 
                    
            }
        
         
            
            
            
        }
        
        if (e.getSource() == vis.jButtonEditarUsuari){
            
            System.out.println("HOlA");
            String nivell_string = null, estat_string = null;
            mod.setNom(vis.txt_nom.getText().trim());
            mod.setCognom(vis.txt_cognom.getText().trim());
            mod.setTelefon(vis.txt_telefon.getText().trim());
            mod.setUsuari(vis.txt_usuari.getText().trim());     
            mod.setMail(vis.txt_email.getText().trim());
            //mod.setContrasenya(vis.txt_.getText().trim());
            int estat = vis.ComboEstat.getSelectedIndex() + 1;            
            int nivell = vis.ComboNivell.getSelectedIndex() + 1;
            
            
           if (nivell == 1) {

                nivell_string = "Administrador";

            }
            if (nivell == 2) {

                nivell_string = "Oficinista";
            }
            if (nivell == 3) {

                nivell_string = "Operari";

            }

            if (estat == 1) {

                estat_string = "Actiu";
            }

            if (estat == 2) {

                estat_string = "No Actiu";

            }
            
            mod.setEstat(estat_string);
            mod.setNivell(nivell_string);
            
            
            switch (modC.EditarUsuari(mod)) {

                
                case 1:
                    JOptionPane.showMessageDialog(null, "Usuari Modificat!");
                    natejar();
                    vis.DashInfoUsuari.setVisible(false);
                    vis.DashUsuaris.setVisible(true);
                    MostrarTaula();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al modificar l'usuari. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                    break;
                default:
                    break;

            }
            
            
            
        }
        
        
        if (e.getSource() == vis.jButtonEliminarUsuari) {

             for (int i = 0; i < vis.jTable_Usuaris.getRowCount(); i++) {

                 Boolean checked = Boolean.valueOf(vis.jTable_Usuaris.getValueAt(i, 0).toString());

                 //DISPLAY
                 if (checked) {

                     int id  = (int) modelUsuaris.getValueAt(i,6);
                     mod.setId(id);
                     if (modC.EliminarUsuari(mod)==false){
                         
                        JOptionPane.showMessageDialog(null, "Error al eliminar, contacti amb l'administrador");
                     
                     }
                 }
             }
             MostrarTaula();

         }
        
        
        
        
        
    }
    
    
     public void natejar() {       
        
        mod.setNom("");
        mod.setCognom("");
        mod.setUsuari("");
        mod.setTelefon("");
        mod.setMail("");
        mod.setContrasenya("");
        mod.setNivell("");
        mod.setEstat(""); 
        
        vis.txt_nom.setText("");
        vis.txt_cognom.setText(""); 
        vis.txt_telefon.setText("");
        vis.ComboEstat.setSelectedIndex(0);
        vis.ComboNivell.setSelectedIndex(0);
        //vis.txt_contrasenya.setText("");
        vis.txt_email.setText("");
        vis.txt_usuari.setText("");
        
        vis.txt_nom1.setText("");
        vis.txt_cognom1.setText(""); 
        vis.txt_telefon1.setText("");
        vis.ComboEstat1.setSelectedIndex(0);
        vis.ComboNivell1.setSelectedIndex(0);
        //vis.txt_contrasenya.setText("");
        vis.txt_mail1.setText("");
        vis.txt_usuari1.setText("");
        
        
      
      }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vis.jTable_Usuaris) {

            DefaultTableModel model_usuaris2 = new DefaultTableModel();
            model_usuaris2 = (DefaultTableModel) vis.jTable_Usuaris.getModel();

            int fila_point = vis.jTable_Usuaris.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Usuaris.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Usuaris.repaint();
            vis.jTable_Usuaris.updateUI();

            if (fila_point > -1 && columna_point > 0) {

                
                String titol = model_usuaris2.getValueAt(fila_point, columna).toString();
                mod.setNom(titol);
                int id  = (int) modelUsuaris.getValueAt(fila_point,6);
                mod.setId(id);
                System.out.println("INT_ID: " + mod.getId());
                
                if (modC.informacioUsuari(mod) == 1) {                    
                    
                    vis.txt_nom.setText(mod.getNom());
                    vis.txt_cognom.setText(mod.getCognom());
                    vis.txt_usuari.setText(mod.getUsuari());                  
                    vis.ComboNivell.setSelectedItem(mod.getNivell());
                    vis.ComboEstat.setSelectedItem(mod.getEstat());
                    vis.txt_telefon.setText(mod.getTelefon());
                    vis.txt_email.setText(mod.getMail());
                   // vis.txt_contrasenya.setText(mod.getContrasenya());
                    vis.DashInfoUsuari.setVisible(true);
                    vis.DashUsuaris.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }

            }

        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
         DefaultTableModel model_usuaris = new DefaultTableModel();     
            
            
         model_usuaris.addColumn("Seleccionar");
         model_usuaris.addColumn("Nom");
         model_usuaris.addColumn("Cognom");
         model_usuaris.addColumn("Usari");
         model_usuaris.addColumn("Nivell");
         model_usuaris.addColumn("Estat");
         model_usuaris.addColumn("ID");
            

            Object[] columna = new Object[7];
            
            System.out.print("Buscador" + vis.txtBuscadorUsuaris.getText());
            System.out.println("Nom" + mod.getNom());
            
            int numRegistres = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).size();

            for (int i = 0; i < numRegistres; i++) {

                columna[1] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getNom();
                columna[2] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getCognom();
                columna[3] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getUsuari();
                columna[4] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getNivell();
                columna[5] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getEstat();
                columna[6] = modC.BuscarUsuaris(vis.txtBuscadorUsuaris.getText()).get(i).getId();
                model_usuaris.addRow(columna);
                System.out.println("Titol" + mod.getNom());
                mod.setId(modC.MostrarUsuaris().get(i).getId());
                modC.GuardarId(mod);
            }
            
            for (int i = 0; i < numRegistres; i++) {

             model_usuaris.setValueAt(false, i, 0);

            }

            
            vis.jTable_Usuaris.setModel(model_usuaris);
            
            modelUsuaris = model_usuaris;
             addCheckBox(0, vis.jTable_Usuaris);                      
            vis.jTable_Usuaris.removeColumn(vis.jTable_Usuaris.getColumnModel().getColumn(6));
                 
        
        
    }
    
    
    
    
    
    
}
