/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;


import java.text.ParseException;
import java.util.TimerTask;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author Victor.
 */
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {

	Date now; // to display current time

	// Add your task here
        @Override
	public void run() {
		now = new Date(); // initialize date               
                System.out.println("Time is :" + now);       // Display current time
                Principal principal = new Principal();
                JFLogin login = new JFLogin();
            try {
                
                principal.recordatori(now);
            } catch (InterruptedException | ParseException ex) {
                Logger.getLogger(ScheduledTask.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}