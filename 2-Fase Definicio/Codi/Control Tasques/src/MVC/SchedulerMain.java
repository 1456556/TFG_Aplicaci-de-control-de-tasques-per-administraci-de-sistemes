
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import Controlador.ControladorLogin;
import Model.ConsultesLogin;
import Model.Login;
import Vista.JFContrasenya;
import Vista.JFLogin;
import Vista.JFPrincipal;
import java.util.Timer;
import javax.swing.JFileChooser;

/**
 *
 * @author Victor
 */
//Main class
public class SchedulerMain {

    public static void main(String args[]) throws InterruptedException {

        JFileChooser jf = new JFileChooser();
        JFContrasenya contrasenya = new JFContrasenya();

        JFPrincipal principal = new JFPrincipal();
        Login mod = new Login();
        ConsultesLogin modC = new ConsultesLogin();
        JFLogin vist = new JFLogin();
        ControladorLogin con = new ControladorLogin(mod, modC, vist, principal, contrasenya, jf);
        con.inicialitzar();
        vist.setVisible(true);

        //Principal principal = new Principal();
        //principal.setVisible(true);
        Timer time = new Timer(); // Instantiate Timer Object
        ScheduledTask st = new ScheduledTask(principal); // Instantiate SheduledTask class
        time.schedule(st, 0, 1000); // Create Repetitively task for every 1 secs

        //for demo only.
        for (int i = 0; i <= 1000; i++) {
            System.out.println("Execution in Main Thread...." + i);
            Thread.sleep(2000);
            if (i == 1000) {
                System.out.println("Application Terminates");
                System.exit(0);
            }
        }

    }

}
