/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesTasques;
import Model.Tasques;
import Vista.JFPrincipal;
import Vista.JFRepeticio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ControladorRepeticio implements ActionListener{
    
    
  
    public JFRepeticio vis;
    public Tasques mod;
    
      
    
    public ControladorRepeticio(JFRepeticio vis, Tasques mod){
        
        
        this.mod = mod;
        this.vis = vis;

        this.vis.jButtonAceptar.addActionListener(this);
        this.vis.jButtonCancelar.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(this.vis.jRadioButtonDiari);
        group.add(this.vis.jRadioButtonSetmanal);
        group.add(this.vis.jRadioButtonMensual);
        group.add(this.vis.jRadioButtonAnual);
        
        this.vis.jRadioButtonDiari.setSelected(true);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        this.vis.jRadioButtonMensual.addActionListener(this);
        this.vis.jRadioButtonAnual.addActionListener(this);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        
        

        
            
    }
    
    public void inicialitza(){
    
    
        vis.setVisible(true);
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         if (e.getSource() == vis.jButtonCancelar){
            
            
             vis.setVisible(false);
            
        }
        
        if (e.getSource() == vis.jButtonAceptar){
            
            if (vis.jRadioButtonDiari.isSelected()){
                
                if ( vis.jSpinnerDiari.getValue() != null || vis.dateTimePickerRepeticio.getDatePicker() != null || 
                        vis.dateTimePickerRepeticio.getTimePicker() != null){
                
                int repeticio = (Integer) vis.jSpinnerDiari.getValue();
                if (repeticio > 0){
                
                    mod.setRepeticio(repeticio);
                    mod.setData(vis.dateTimePickerRepeticio.getDatePicker().toString());            
                    mod.setHora(vis.dateTimePickerRepeticio.getTimePicker().toString());
                    vis.setVisible(false);
                
                
                
                }else{
                
                    JOptionPane.showMessageDialog(null, "Els dies no poden ser iguals o menors a 0");    
                }
                
                
                
            }else{
                    
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");    
                    
                    
                }
            
            }
             
            
        }
        
        
            
            
                     
          
            
            
            
            
            if (e.getSource() == this.vis.jRadioButtonDiari){
            
                
                
            this.vis.jSpinnerSetmanal.setVisible(false);
        this.vis.jLabelSetmanes.setVisible(false);
        this.vis.jCheckBoxDijous.setVisible(false);
        this.vis.jCheckBoxDimecres.setVisible(false);
        this.vis.jCheckBoxDivendres.setVisible(false);
        this.vis.jCheckBoxDissabte.setVisible(false);
        this.vis.jCheckBoxDiumenge.setVisible(false);
        this.vis.jCheckBoxDilluns.setVisible(false);
        this.vis.jCheckBoxDimarts.setVisible(false);
            
            
            
            
            
            
            }
            
            if (e.getSource() == this.vis.jRadioButtonSetmanal){
                
                this.vis.jSpinnerSetmanal.setVisible(true);
                this.vis.jLabelSetmanes.setVisible(true);
                this.vis.jCheckBoxDijous.setVisible(true);
                this.vis.jCheckBoxDimecres.setVisible(true);
                this.vis.jCheckBoxDivendres.setVisible(true);
                this.vis.jCheckBoxDissabte.setVisible(true);
                this.vis.jCheckBoxDiumenge.setVisible(true);
                this.vis.jCheckBoxDilluns.setVisible(true);
                this.vis.jCheckBoxDimarts.setVisible(true);
                this.vis.jLabelDias.setVisible(false);
                this.vis.jSpinnerDiari.setVisible(false);
                
                
                
                
            }
            
           
        
        
        
        
    }
    
}
