/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesElements;
import Model.ConsultesLogin;
import Model.ConsultesTasques;
import Model.ConsultesUsuaris;
import Model.Elements;
import Model.Login;
import Model.Tasques;
import Model.Usuaris;
import Vista.JFLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Vista.JFPrincipal;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.Color;
import java.awt.*;  
import java.awt.event.*;

/**
 *
 * @author Victor
 */
public class ControladorMenu implements MouseListener  {
    
    
    private JFPrincipal vis;
    String newLine = System.getProperty("line.separator");
    
    public ControladorMenu(JFPrincipal vis){
    
      
        this.vis = vis;
        addMouseListener(this);
        this.vis.setVisible(true);        
        this.vis.btnTasques.addMouseListener(this);
        this.vis.btn_Tasques.addMouseListener( this);
        this.vis.btnElements.addMouseListener( this);
        this.vis.btn_Elements.addMouseListener(this);
        this.vis.btnUsuaris.addMouseListener( this);
        this.vis.btn_Usuaris.addMouseListener(this);
       
        
    
    }
    
  
    
    
    
    public void inicialitzar(){
        
        
        Tasques modTasques = new Tasques();
        ConsultesTasques modCTasques = new ConsultesTasques();        
        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);       
        con.inicialitzar();
        con.MostrarTaula(vis.jTable_Tasques);
        
        vis.DashTasques.setVisible(true);        
        vis.DashInfoUsuari.setVisible(false);
        vis.DashInfoTasca.setVisible(false);
        vis.DashNovaTasca.setVisible(false);
        vis.DashConfiguracio.setVisible(false);         
        vis.DashNouUsuari.setVisible(false);
        vis.DashNouElement.setVisible(false);
        vis.DashUsuaris.setVisible(false);
        vis.DashElements.setVisible(false);
        vis.DashInfoElement.setVisible(false);
       
        
    }
    
        
    @Override
    public void mouseClicked(MouseEvent e){
        
       
        
        if (e.getSource() == vis.btnTasques){
            
            Tasques modTasques = new Tasques();
            ConsultesTasques modCTasques = new ConsultesTasques();            
            ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);               
            con.inicialitzar();
               
            vis.DashTasques.setVisible(true);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashElements.setVisible(false);
            vis.DashInfoElement.setVisible(false);
        
        }
        
        if (e.getSource() ==  vis.btn_Tasques){
         
            vis.DashTasques.setVisible(true);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashElements.setVisible(false);
            vis.DashInfoElement.setVisible(false);
            
            
        
        
        }
        
        if (e.getSource() ==  vis.btn_Elements){
            
            
            Elements modElements = new Elements();
            ConsultesElements modCElements = new ConsultesElements();            
            ControladorElements con = new ControladorElements(modElements, modCElements, vis);               
            con.inicialitzar();
         
            vis.DashTasques.setVisible(false);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashElements.setVisible(true);
            vis.DashInfoElement.setVisible(false);
            
            
        
        
        }
        
        if (e.getSource() ==  vis.btnElements){
            
            Elements modElements = new Elements();
            ConsultesElements modCElements = new ConsultesElements();            
            ControladorElements con = new ControladorElements(modElements, modCElements, vis);               
            con.inicialitzar();
         
            vis.DashTasques.setVisible(false);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashElements.setVisible(true);
            vis.DashInfoElement.setVisible(false);
            
            
        
        
        }
        
        if (e.getSource() ==  vis.btn_Usuaris){
            
            Usuaris modUsuaris = new Usuaris();
            ConsultesUsuaris modCUsuaris = new ConsultesUsuaris();            
            ControladorUsuaris con = new ControladorUsuaris(modUsuaris, modCUsuaris, vis);               
            con.inicialitzar();
         
            vis.DashTasques.setVisible(false);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(true);
            vis.DashElements.setVisible(false);
            vis.DashInfoElement.setVisible(false);
            
            
        
        
        }
        
        if (e.getSource() ==  vis.btnUsuaris){
            
             Usuaris modUsuaris = new Usuaris();
            ConsultesUsuaris modCUsuaris = new ConsultesUsuaris();            
            ControladorUsuaris con = new ControladorUsuaris(modUsuaris, modCUsuaris, vis);               
            con.inicialitzar();
         
            vis.DashTasques.setVisible(false);        
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);         
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouElement.setVisible(false);
            vis.DashUsuaris.setVisible(true);
            vis.DashElements.setVisible(false);
            vis.DashInfoElement.setVisible(false);
            
            
        
        
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

        
        

   

    
    
}
