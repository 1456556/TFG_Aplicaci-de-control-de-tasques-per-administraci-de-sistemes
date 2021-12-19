/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;



import Controlador.ControladorNotificacio;
import Controlador.ControladorTasques;
import Model.ConsultesNotificacio;

import Model.Notificacio;
import Vista.JFPrincipal;
import Vista.JFLogin;

import java.text.ParseException;
import java.util.TimerTask;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
/**
 * 
 * @author Victor.
 */
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {
    private JFPrincipal principal;
 
	Date now; // to display current time
        public ScheduledTask(JFPrincipal principal){
        
            this.principal = principal;
        
        }
	// Add your task here
        @Override
	public void run() {
		now = new Date(); // initialize date               
                System.out.println("Time is :" + now);       // Display current time
                
                
                //JFPrincipal principal = new JFPrincipal();
                Notificacio not = new Notificacio();
                ConsultesNotificacio con = new ConsultesNotificacio();
                ControladorNotificacio cn = new ControladorNotificacio(not, con, principal);
                
        try {
            cn.Notificacio(now);
            //principal.inicialitzarNotificacio(now);
            
            // principal.recordatori(now);
            //principal.Notificacio(now);
        } catch (MessagingException ex) {
            Logger.getLogger(ScheduledTask.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}