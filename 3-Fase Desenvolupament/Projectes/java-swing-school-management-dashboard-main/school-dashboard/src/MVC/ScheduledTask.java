/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import com.raven.main.Main;
import java.util.Date;
import java.util.TimerTask;

/**
 *
 * @author Victor.
 */
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {

    private Main main;

    Date now; // to display current time

    public ScheduledTask() {

        this.main = main;
    }
    // Add your task here

    @Override
    public void run() {
        now = new Date(); // initialize date               
        System.out.println("Time is :" + now);       // Display current time

        /* Notificacio not = new Notificacio();
        ConsultesNotificacio con = new ConsultesNotificacio();
        //ControladorNotificacio cn = new ControladorNotificacio(not, con, principal);

        try {
            cn.Notificacio(now);

        } catch (MessagingException ex) {
            Logger.getLogger(ScheduledTask.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
