/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesLogin;
import Model.ConsultesTasques;
import Model.Login;
import Model.Tasques;
import Vista.JFLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.JFPrincipal;
import java.awt.event.MouseListener;

/**
 *
 * @author Victor
 */
public class ControladorMenu implements ActionListener {
    
    
    private JFPrincipal vis;

    
    public ControladorMenu(JFPrincipal vis){
    
      
        this.vis = vis;
        //this.vis.btnTasques.addMouseListener((MouseListener) this);
    
    }
    
    
    public void inicialitzar(){
    
        this.vis.DashTasques.setVisible(true);
    
    }
    
    
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == vis.btnTasques){
            
                Tasques modTasques = new Tasques();
                ConsultesTasques modCTasques = new ConsultesTasques();
                JFPrincipal vistPrincipal = new JFPrincipal();
                ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vistPrincipal);               
                con.inicialitzar();
                vistPrincipal.DashTasques.setVisible(true);
        
        }
        
    }
    
}
