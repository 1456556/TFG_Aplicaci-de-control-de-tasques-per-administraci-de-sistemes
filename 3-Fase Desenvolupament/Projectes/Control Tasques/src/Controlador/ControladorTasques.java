/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Model.ConsultesTasques;
import Model.Tasques;
import Vista.JFPrincipal;
import clases.Conexio;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Victor
 */
public class ControladorTasques extends JFPrincipal implements ActionListener, MouseListener, KeyListener  {
    
    public Tasques mod;
    public ConsultesTasques modC;
    public JFPrincipal vis;
    
    public DefaultTableModel modelTasques;
      
    
    public ControladorTasques(Tasques mod, ConsultesTasques modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
       
        
        this.vis.jButtonNovaTasca.addActionListener(this);
        this.vis.jButtonRegistarTasca.addActionListener(this);
        this.vis.jButtonEditarTasca.addActionListener(this);
        this.vis.jButtonEliminarTasca.addActionListener(this); 
        this.vis.jTable_Tasques.addMouseListener(this);        
        this.vis.txtBuscadorTasques.addKeyListener(this);
        
            
    }
    
    public ControladorTasques(Tasques mod, ConsultesTasques modC){
    
        this.mod = mod;
        this.modC = modC;
    
    }
   
     
    public void inicialitzar(){
                   
    
    }


    
     public void NotificacioTasca(int id){
    
    
       mod.setId(id);
       System.out.println("ID + Not:" + id);
      if (modC.informacioTasca(mod) == 1){
      
             vis.txt_titolTasc2.setText(mod.getTitol());
             vis.txt_usuariTasc2.setText(mod.getUsuariAssignat());
             vis.txt_descripcioTasc2.setText(mod.getDescripcio());

             String d = mod.getData();
             String date = d.substring(0, 10);
             String time = d.substring(11, 16);
             String data = date.replace("-", "/");

             System.out.println("DATAASAAAAAAAA:" + d);
             System.out.println("sSubCadena:" + date);
             System.out.println("sSubCadena:" + data);
             System.out.println("sSubCadena:" + time);

             DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
             DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

             //convert String to LocalDate
             LocalDate localDate = LocalDate.parse(data, formatter);
             LocalTime localTime = LocalTime.parse(time, formatter2);

             //ControladorMenu cn = new ControladorMenu(vis);
             //cn.notificacio();
             
             vis.dateTimePicker1.datePicker.setDate(localDate);
             vis.dateTimePicker1.timePicker.setTime(localTime);
             vis.ComboPrioritatTasc2.setSelectedItem(mod.getPrioritat());
             vis.ComboEstatTasc2.setSelectedItem(mod.getEstat());
             vis.txt_titolTasc2.setText(mod.getTitol());
             vis.DashInfoTasca.setVisible(true);
             vis.DashTasques.setVisible(false);
             
              //vis.DashTasques.setVisible(true);        
            vis.DashInfoUsuari.setVisible(false);
            //vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashElements.setVisible(false);
            vis.DashInfoElement.setVisible(false);

         } else {

             JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

         }


      
      }
    
      
     
     @Override
    public void actionPerformed(ActionEvent e){       
        
        
        if (e.getSource() == vis.jButtonNovaTasca){
            
            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(true);
        }
        
        if (e.getSource() == vis.jButtonRegistarTasca){
            
            System.out.println("HOlA");
            String prioritat_string = null, estat_string = null;
            mod.setTitol(vis.txt_titolTasc.getText().trim());
            mod.setUsuariAssignat(vis.txt_usuariassignatTasc.getText().trim());
            mod.setData(vis.dateTimePicker.getDatePicker().toString());
            mod.setDescripcio(vis.txt_descripcioTasc.getText().trim());
            mod.setHora(vis.dateTimePicker.getTimePicker().toString());
            int estat = vis.ComboEstatTasc2.getSelectedIndex() + 1;            
            int prioritat = vis.ComboPrioritatTasc.getSelectedIndex() + 1;   

            
            if (estat == 1) {

                estat_string = "Nova";
            }

            if (estat == 2) {

                estat_string = "En espera";

            }
            if (estat == 3) {

                estat_string = "En procés";

            }
            if (estat == 4) {

                estat_string = "Finalitzada";

            }
            
            if (prioritat == 1){
            
                prioritat_string = "Baixa";
            }
            if (prioritat == 2){
            
                prioritat_string = "Mitja";
            }
            if (prioritat == 3){
            
                prioritat_string = "Alta";
                
            }if (prioritat == 4){
            
                prioritat_string = "Urgent";
            }
            if (prioritat == 5){
            
                prioritat_string = "Prioritaria";
            }
                        
            mod.setEstat(estat_string);
            mod.setPrioritat(prioritat_string);
            
            
            
            switch (modC.NovaTasca(mod)) {     
                 
                       
                case 1:
                    JOptionPane.showMessageDialog(null, "Tasca Creada Correctament!");           
                    natejar();                   
                    vis.DashNovaTasca.setVisible(false);
                    vis.DashTasques.setVisible(true);
                    MostrarTaula(vis.jTable_Tasques);                                
                    break;                
                case 2:
                    JOptionPane.showMessageDialog(null,"Error al crear la tasca. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");                    
                    break;
                default:
                    break;                 
                    
            }
            
                               
                 
            
        }
        
        if (e.getSource() == vis.jButtonEditarTasca) {

            int prioritat, estat;
            String prioritat_string = null, estat_string = null;

            mod.setTitol(vis.txt_titolTasc2.getText().trim());
            mod.setUsuariAssignat(vis.txt_usuariTasc2.getText().trim());            
            mod.setData(vis.dateTimePicker1.getDatePicker().toString());            
            mod.setHora(vis.dateTimePicker1.getTimePicker().toString());            
            estat = vis.ComboEstatTasc2.getSelectedIndex() + 1;
            prioritat = vis.ComboPrioritatTasc2.getSelectedIndex() + 1;

            if (estat == 1) {

                estat_string = "Nova";
            }

            if (estat == 2) {

                estat_string = "En espera";

            }
            if (estat == 3) {

                estat_string = "En procés";

            }
            if (estat == 4) {

                estat_string = "Finalitzada";

            }

            if (prioritat == 1) {

                prioritat_string = "Baixa";
            }
            if (prioritat == 2) {

                prioritat_string = "Mitja";
            }
            if (prioritat == 3) {

                prioritat_string = "Alta";

            }
            if (prioritat == 4) {

                prioritat_string = "Urgent";
            }
            if (prioritat == 5) {

                prioritat_string = "Prioritaria";
            }

            mod.setEstat(estat_string);
            mod.setPrioritat(prioritat_string);

            switch (modC.EditarTasca(mod)) {

                case 0:
                    JOptionPane.showMessageDialog(null, "Titol de tasca no disponible");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "Tasca Modificada!");
                    natejar();
                    vis.DashInfoTasca.setVisible(false);
                    vis.DashTasques.setVisible(true);
                    MostrarTaula(vis.jTable_Tasques);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al modificar la tasca. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                    break;
                default:
                    break;

            }

        }
        
        
         if (e.getSource() == vis.jButtonEliminarTasca) {

             for (int i = 0; i < vis.jTable_Tasques.getRowCount(); i++) {

                 Boolean checked = Boolean.valueOf(vis.jTable_Tasques.getValueAt(i, 0).toString());

                 //DISPLAY
                 if (checked) {

                     int id  = (int) modelTasques.getValueAt(i,6);
                     mod.setId(id);
                     if (modC.EliminarTasca(mod) == false){
                     
                         JOptionPane.showMessageDialog(null, "Error al eliminar la tasca, contacti amb l'administrador");
                     
                     }
                 }
             }
             
             MostrarTaula(vis.jTable_Tasques);

         }

    }
    
    
    
    
    public void MostrarTaula(JTable JTable_Tasques){
    
        
        
         DefaultTableModel model_tasques = new DefaultTableModel();
         
         
         model_tasques.addColumn("Sleccionar");
         model_tasques.addColumn("Titol");
         model_tasques.addColumn("Prioritat");
         model_tasques.addColumn("Usuari assignat");
         model_tasques.addColumn("Data");
         model_tasques.addColumn("Estat");
         model_tasques.addColumn("ID");
         
         Object [] columna = new Object[7];
         
         int numRegistres = modC.MostrarTasques().size();
         System.out.println("Num: " + numRegistres);
        // int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();
         
         for (int i = 0; i < numRegistres; i++){
         
             
             columna[1] = modC.MostrarTasques().get(i).getTitol();
             columna[2] = modC.MostrarTasques().get(i).getPrioritat();
             columna[3] = modC.MostrarTasques().get(i).getUsuariAssignat();
             columna[4] = modC.MostrarTasques().get(i).getData();
             columna[5] = modC.MostrarTasques().get(i).getEstat();
             columna[6] = modC.MostrarTasques().get(i).getId();
             model_tasques.addRow(columna);
             
             
             mod.setId(modC.MostrarTasques().get(i).getId());
             modC.GuardarId(mod);
            
         }
         
         for (int i = 0; i < numRegistres; i++) {

            model_tasques.setValueAt(false, i, 0);

        }
         
            vis.jTable_Tasques.setModel(model_tasques);            
            modelTasques = model_tasques;
            addCheckBox(0, vis.jTable_Tasques);  
            vis.jTable_Tasques.removeColumn(vis.jTable_Tasques.getColumnModel().getColumn(6));
             
             
    
     }    
    
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {

        

            DefaultTableModel model_tasques = new DefaultTableModel();     
            
            
            model_tasques.addColumn("Sleccionar");
            model_tasques.addColumn("Titol");
            model_tasques.addColumn("Prioritat");
            model_tasques.addColumn("Usuari assignat");
            model_tasques.addColumn("Data");
            model_tasques.addColumn("Estat");
            model_tasques.addColumn("ID");
            

            Object[] columna = new Object[7];
            
            System.out.print("Buscador" + vis.txtBuscadorTasques.getText());
            System.out.println("Titol" + mod.getTitol());
            
            int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();

            for (int i = 0; i < numRegistres; i++) {

                columna[1] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getTitol();
                columna[2] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getPrioritat();
                columna[3] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getUsuariAssignat();
                columna[4] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getData();
                columna[5] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getEstat();
                columna[6] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getId();
                model_tasques.addRow(columna);
                System.out.println("Titol" + mod.getTitol());
                mod.setId(modC.MostrarTasques().get(i).getId());
                modC.GuardarId(mod);
            }
            
            for (int i = 0; i < numRegistres; i++) {

            model_tasques.setValueAt(false, i, 0);

            }

            
            vis.jTable_Tasques.setModel(model_tasques);
            
            modelTasques = model_tasques;
             addCheckBox(0, vis.jTable_Tasques);                      
            vis.jTable_Tasques.removeColumn(vis.jTable_Tasques.getColumnModel().getColumn(6));
            
            
    

    }
    
    
    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));       

    }
     
     public void natejar() {       
        
        mod.setTitol("");
        mod.setData("");
        mod.setHora("");
        mod.setPrioritat("");
        mod.setEstat("");
        mod.setId(0);
        mod.setDescripcio("");
        mod.setUsuariAssignat("");
        
        vis.txt_titolTasc.setText("");
        vis.txt_usuariassignatTasc.setText("");        
        vis.dateTimePicker.datePicker.setDateToToday();
        vis.dateTimePicker.timePicker.setTimeToNow();
        vis.txt_descripcioTasc.setText("");
        vis.ComboEstatElem3.setSelectedIndex(0);
        vis.ComboPrioritatTasc.setSelectedIndex(0);
        
        vis.txt_descripcioTasc2.setText("");
        vis.txt_usuariTasc2.setText("");
        vis.txt_titolTasc2.setText("");
        vis.txt_descripcioTasc2.setText("");
        vis.ComboEstatTasc2.setSelectedIndex(0);
        vis.ComboPrioritatTasc2.setSelectedIndex(0);
        
        
      
      }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vis.jTable_Tasques) {

            DefaultTableModel model_tasques2 = new DefaultTableModel();
            model_tasques2 = (DefaultTableModel) vis.jTable_Tasques.getModel();

            int fila_point = vis.jTable_Tasques.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Tasques.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Tasques.repaint();
            vis.jTable_Tasques.updateUI();

            if (fila_point > -1 && columna_point > 0) {

                
                String titol = model_tasques2.getValueAt(fila_point, columna).toString();
                mod.setTitol(titol);
                int id  = (int) modelTasques.getValueAt(fila_point,6);
                mod.setId(id);
                System.out.println("INT_ID: " + mod.getId());
                
                if (modC.informacioTasca(mod) == 1) {                    
                    
                    vis.txt_titolTasc2.setText(mod.getTitol());
                    vis.txt_usuariTasc2.setText(mod.getUsuariAssignat());
                    vis.txt_descripcioTasc2.setText(mod.getDescripcio());

                    String d = mod.getData();
                    String date = d.substring(0, 10);
                    String time = d.substring(11, 16);
                    String data = date.replace("-", "/");

                    System.out.println("DATAASAAAAAAAA:" + d);
                    System.out.println("sSubCadena:" + date);
                    System.out.println("sSubCadena:" + data);
                    System.out.println("sSubCadena:" + time);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

                    //convert String to LocalDate
                    LocalDate localDate = LocalDate.parse(data, formatter);
                    LocalTime localTime = LocalTime.parse(time, formatter2);

                    vis.dateTimePicker1.datePicker.setDate(localDate);
                    vis.dateTimePicker1.timePicker.setTime(localTime);
                    vis.ComboPrioritatTasc2.setSelectedItem(mod.getPrioritat());
                    vis.ComboEstatTasc2.setSelectedItem(mod.getEstat());
                    vis.txt_titolTasc2.setText(mod.getTitol());
                    vis.DashInfoTasca.setVisible(true);
                    vis.DashTasques.setVisible(false);

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

    

    
    
}
