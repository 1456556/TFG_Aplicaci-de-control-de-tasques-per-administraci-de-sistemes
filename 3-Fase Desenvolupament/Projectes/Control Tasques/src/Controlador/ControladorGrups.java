/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesGrups;
import Model.ConsultesUsuaris;
import Model.Grups;
import Model.Usuaris;
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Victor
 */
public class ControladorGrups implements ActionListener, MouseListener, KeyListener  {
    
    private Grups mod;
    private ConsultesGrups modC;
    private JFPrincipal vis;
    
    public DefaultTableModel  modelGrupsUsuaris;
    public DefaultTableModel  modelGrups;
      
    
    public ControladorGrups(Grups mod, ConsultesGrups modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
        this.vis.jButtonNouGrup.addActionListener(this);
        this.vis.jButtonEliminarGrup.addActionListener(this);
        this.vis.jButtonRegistarGrup.addActionListener(this);
        this.vis.jTable_Grups.addMouseListener(this);
        this.vis.jButtonAfegir.addActionListener(this);
        
        //this.vis.jButtonEditarUsuari.addActionListener(this);
        //this.vis.txtBuscadorUsuaris.addKeyListener(this);
    }

      
    
    
    
    
    
      public void MostrarTaulaGrupsUsuaris(){    
        
        
         DefaultTableModel model_grups = new DefaultTableModel();
         
         
         model_grups.addColumn("Seleccionar");
         model_grups.addColumn("Nom");
         model_grups.addColumn("Cognom");
         model_grups.addColumn("Usuari");
         model_grups.addColumn("ID");
        
         
         Object [] columna = new Object[5];
         
         int numRegistres = modC.MostrarGrupsUsuaris().size();
         System.out.println("Num: " + numRegistres);
        
         
         for (int i = 0; i < numRegistres; i++){
         
             
             columna[1] = modC.MostrarGrupsUsuaris().get(i).getNomUsuari();
             columna[2] = modC.MostrarGrupsUsuaris().get(i).getCognom();
             columna[3] = modC.MostrarGrupsUsuaris().get(i).getUsuari();
             columna[4] = modC.MostrarGrupsUsuaris().get(i).getIdUsuari();
             
             model_grups.addRow(columna);
             
             
             mod.setId(modC.MostrarGrupsUsuaris().get(i).getId());
             modC.GuardarIdUsuari(mod);
            
         }
         
         for (int i = 0; i < numRegistres; i++) {

            model_grups.setValueAt(false, i, 0);

        }
         
            vis.jTableCrearGrupsUsuaris.setModel(model_grups);            
            modelGrupsUsuaris = model_grups;
            addCheckBox(0, vis.jTableCrearGrupsUsuaris);  
            vis.jTableCrearGrupsUsuaris.removeColumn(vis.jTableCrearGrupsUsuaris.getColumnModel().getColumn(4));
             
             
    
     }    
    
    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));       

    }
    
    
    public void inicialitzar(){    
       
    
    }
    
    public boolean IsSelected(int fila, int columna, JTable taula) {

        Boolean checked = Boolean.valueOf(taula.getValueAt(fila, columna).toString());
        System.out.print(checked);
        return checked;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
         if (e.getSource() == vis.jButtonNouGrup){
            
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(true);
            MostrarTaulaGrupsUsuaris();
        }
         
         if (e.getSource() == vis.jButtonAfegir) {

            int numRegistres = modC.MostrarGrupsUsuaris().size();
            System.out.println("Num: " + numRegistres);
            String array[];
            array = new String[numRegistres];
            int j = 0;
            String line = "";
            for (int i = 0; i < numRegistres; i++) {

                if (IsSelected(i, 0, vis.jTableCrearGrupsUsuaris)) {
                    
                    
                    DefaultTableModel model_grupsusuaris2 = new DefaultTableModel();
                    model_grupsusuaris2 = (DefaultTableModel) vis.jTableCrearGrupsUsuaris.getModel();
                    String titol = model_grupsusuaris2.getValueAt(i, 3).toString();
                    line += titol;
                    line += "\n";
                    array[i] = titol;
                    mod.setGrupUsuaris(array);

                }
                    
            }
           
            vis.jTextGrupUsuaris.setText(line);

        }

              
    
         
         
         if (e.getSource() == vis.jButtonRegistarGrup){
            
            mod.setNom(vis.txt_nomGrup.getText().trim());
            
           switch (modC.NouGrup(mod)) {     
                 
                       
                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");           
                    //natejar();                   
                    //vis.DashNouElement.setVisible(false);
                    //vis.DashElements.setVisible(true);
                    //MostrarTaula();                                
                    break;                
                case 2:
                    JOptionPane.showMessageDialog(null,"Error al crear l'element. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");                    
                    break;
                default:
                    break;                 
                    
            }
            
            
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
       
    }
    
}
