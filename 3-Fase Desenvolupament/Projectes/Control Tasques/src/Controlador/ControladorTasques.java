/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesRegistre;
import Model.ConsultesTasques;
import Model.Registre;
import Model.Tasques;
import Vista.JFPrincipal;
import Vista.JFRegistre;
import java.awt.event.ActionEvent;

/**
 *
 * @author Victor
 */
public class ControladorTasques {
    
    private Tasques mod;
    private ConsultesTasques modC;
    private JFPrincipal vis;
    
    public ControladorTasques(Tasques mod, ConsultesTasques modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        inicialitzar();
        //this.vis.btnRegistrar.addActionListener(this);
        
        
    }
    
    
    public void inicialitzar(){    
    
        this.modC.MostrarTasques();
    
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
        
        
        
    }
    
}
