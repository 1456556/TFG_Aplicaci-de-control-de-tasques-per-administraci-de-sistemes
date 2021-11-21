/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesNotificacio;
import Model.ConsultesTasques;
import Model.Tasques;
import Vista.JFPrincipal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.Notificacio;

/**
 *
 * @author Victor
 */
public class ControladorNotificacio   {
    
   public Notificacio mod;
    public ConsultesNotificacio modC;
    public JFPrincipal vis;
    
    public DefaultTableModel modelTasques;
      
    
    public ControladorNotificacio(Notificacio mod, ConsultesNotificacio modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
        
    }
    
    
    public void Notificacio(Date date){
    
    
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");            
        String d = formatter.format(date);
        
        mod.setData(d);
        
        switch (modC.Notificacio(mod)) {                     
                       
                case 0:                                                
                    break;                
                case 1:
                    String[] botones = {"Veure Tasca", "Posposar 5min"};
                    int ventana = JOptionPane.showOptionDialog(null, mod.getTitol(), "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            botones, botones[0]);
                    if (ventana == 0) {
                        System.out.println("Veure Tasca");
                        modC.ActualitzaNotificacio(mod);
                        Tasques modTasques = new Tasques();
                        ConsultesTasques modCTasques = new ConsultesTasques();
                        //JFPrincipal vistPrincipal = new JFPrincipal(); 
                        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis); 
                        con.NotificacioTasca(mod.getIdTasca());
                    }else{
                        long timeInSecs = date.getTime();
                        Date afterAdding10Mins = new Date((1 * 60 * 1000) + timeInSecs);
                        //String d = data.substring(14,16);
                        System.out.println("Posposar 5min");
                        DateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        String data = formatter2.format(afterAdding10Mins);
                        System.out.println("DATAAAAAAAAA:" + data);
                        mod.setData(data);
                        modC.Posposar(mod);
                        Tasques modTasques = new Tasques();
                        ConsultesTasques modCTasques = new ConsultesTasques();
                        //JFPrincipal vistPrincipal = new JFPrincipal(); 
                        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis); 
                        con.MostrarTaula(vis.jTable_Tasques);
                        
                    
                    }
                    break;               
                default:
                    break;                 
                    
            }
    
    
    
    }
       
    
    
}
