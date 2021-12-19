/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Model.Configuracio;
import Model.ConsultesConfiguracio;
import Vista.JFExportar;
import Vista.JFImportar;
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class ControladorConfiguracio implements ActionListener{
    
    private Configuracio con; 
    private ConsultesConfiguracio modC;
     private JFPrincipal vis;
     public static Boolean so = false;
    
     public ControladorConfiguracio(JFPrincipal vis, ConsultesConfiguracio modC, Configuracio con) {
        
        this.vis = vis;
        this.modC = modC;
        this.con = con;
        this.vis.jButtonExportar.addActionListener(this);
        this.vis.jButtonImportar.addActionListener(this);
        this.vis.jCheckBoxSo.addActionListener(this);
        
     }
     
     public void inicialitzar(){
     
     
     
     if (modC.isSo(con) == true){
     
     vis.jCheckBoxSo.setSelected(true);
     
     }else{
     vis.jCheckBoxSo.setSelected(false);
     
     }
     
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == vis.jButtonImportar){
        
            new JFImportar().setVisible(true);
        
        
        }
        
        
        if (e.getSource() == vis.jButtonExportar){
        
        
            new JFExportar().setVisible(true);
        
        }
 
        if (e.getSource() == vis.jCheckBoxSo) {

            if (vis.jCheckBoxSo.isSelected()) {

                modC.so(1);
                

            } else {
                modC.so(0);
                

            }

        }
        
        
        
    }
    
}
