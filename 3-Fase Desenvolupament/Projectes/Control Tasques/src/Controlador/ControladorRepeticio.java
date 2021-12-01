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
        
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(this.vis.jRadioButtonDataFinal);
        group2.add(this.vis.jRadioButtonAcabar);
        
        this.vis.jRadioButtonDataFinal.setSelected(true);
        this.vis.dateTimePickerRepeticioFinal.setEnabled(true);
        this.vis.jRadioButtonDiari.setSelected(true);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        this.vis.jRadioButtonMensual.addActionListener(this);
        this.vis.jRadioButtonAcabar.addActionListener(this);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        this.vis.jRadioButtonAnual.addActionListener(this);
        
       
        vis.jLabelMesos.setVisible(false);
        vis.jLabelAnys.setVisible(false);
        vis.jLabelSetmanes.setVisible(false);
        vis.jCheckBoxDijous.setVisible(false);
        vis.jCheckBoxDimecres.setVisible(false);
        vis.jCheckBoxDivendres.setVisible(false);
        vis.jCheckBoxDissabte.setVisible(false);
        vis.jCheckBoxDiumenge.setVisible(false);
        vis.jCheckBoxDilluns.setVisible(false);
        vis.jCheckBoxDimarts.setVisible(false);
        
        
       
        
            
    }
    
    public void inicialitza(){
    
    
       
    
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
         if (e.getSource() == vis.jButtonCancelar){
            
            
             vis.setVisible(false);
            
        }
        
        if (e.getSource() == vis.jButtonAceptar){
            
            if (vis.jRadioButtonDiari.isSelected()){
                
                if ( vis.jSpinner.getValue() != null || vis.dateTimePickerRepeticioFinal.getDatePicker() != null || 
                        vis.dateTimePickerRepeticioFinal.getTimePicker() != null){
                
                int repeticio = (Integer) vis.jSpinner.getValue();
                if (repeticio > 0){
                
                    mod.setRepeticio(repeticio);
                    mod.setData(vis.dateTimePickerRepeticioFinal.getDatePicker().toString());            
                    mod.setHora(vis.dateTimePickerRepeticioFinal.getTimePicker().toString());
                    vis.setVisible(false);
                
                
                
                }else{
                
                    JOptionPane.showMessageDialog(null, "Els dies no poden ser iguals o menors a 0");    
                }
                
                
                
            }else{
                    
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");    
                    
                    
                }
            
            }
             
            
        }
        
        
             if (e.getSource() == vis.jRadioButtonDataFinal){
                 
                 vis.dateTimePickerRepeticioFinal.setEnabled(true);
                  vis.jSpinnerAcabar.setEnabled(false);
             }
             
             
             if (e.getSource() == vis.jRadioButtonAcabar){
                 
                 vis.jSpinnerAcabar.setEnabled(true);
                 vis.dateTimePickerRepeticioFinal.setEnabled(false);
             }
            
                     
          
            
            
            
            
            if (e.getSource() == this.vis.jRadioButtonDiari){
            
                
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(false);
                vis.jLabelDias.setVisible(true);               
                vis.jLabelSetmanes.setVisible(false);
                vis.jCheckBoxDijous.setVisible(false);
                vis.jCheckBoxDimecres.setVisible(false);
                vis.jCheckBoxDivendres.setVisible(false);
                vis.jCheckBoxDissabte.setVisible(false);
                vis.jCheckBoxDiumenge.setVisible(false);
                vis.jCheckBoxDilluns.setVisible(false);
                vis.jCheckBoxDimarts.setVisible(false);

            
            
            
            
            
            }
            
            if (e.getSource() == this.vis.jRadioButtonSetmanal){
                
               
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(false);
                vis.jLabelDias.setVisible(false);
                vis.jLabelSetmanes.setVisible(true);
                vis.jCheckBoxDijous.setVisible(true);
                vis.jCheckBoxDimecres.setVisible(true);
                vis.jCheckBoxDivendres.setVisible(true);
                vis.jCheckBoxDissabte.setVisible(true);
                vis.jCheckBoxDiumenge.setVisible(true);
                vis.jCheckBoxDilluns.setVisible(true);
                vis.jCheckBoxDimarts.setVisible(true);
                vis.jLabelDias.setVisible(false);
               
                
                
                
            }
            
             if (e.getSource() == this.vis.jRadioButtonMensual){
                 
                 vis.jLabelMesos.setVisible(true);
                vis.jLabelAnys.setVisible(false);
                vis.jLabelDias.setVisible(false);               
                vis.jLabelSetmanes.setVisible(false);
                vis.jCheckBoxDijous.setVisible(false);
                vis.jCheckBoxDimecres.setVisible(false);
                vis.jCheckBoxDivendres.setVisible(false);
                vis.jCheckBoxDissabte.setVisible(false);
                vis.jCheckBoxDiumenge.setVisible(false);
                vis.jCheckBoxDilluns.setVisible(false);
                vis.jCheckBoxDimarts.setVisible(false);
                 
                 
                 
             }
             
             
              if (e.getSource() == this.vis.jRadioButtonAnual){
                 
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(true);
                vis.jLabelDias.setVisible(false);                
                vis.jLabelSetmanes.setVisible(false);
                vis.jCheckBoxDijous.setVisible(false);
                vis.jCheckBoxDimecres.setVisible(false);
                vis.jCheckBoxDivendres.setVisible(false);
                vis.jCheckBoxDissabte.setVisible(false);
                vis.jCheckBoxDiumenge.setVisible(false);
                vis.jCheckBoxDilluns.setVisible(false);
                vis.jCheckBoxDimarts.setVisible(false);
                 
                 
                 
             }
            
            
            
           
        
        
        
        
    }
    
}
