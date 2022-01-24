
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
import Vista.JFLogin2;
import Vista.JFPrincipal2;
import java.awt.Image;
import java.awt.Toolkit;
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

        JFPrincipal2 principal = new JFPrincipal2();

        Login mod = new Login();
        ConsultesLogin modC = new ConsultesLogin();
        JFLogin2 vist = new JFLogin2();
        ControladorLogin con = new ControladorLogin(mod, modC, vist, principal, contrasenya, jf);
        con.inicialitzar();
        vist.setVisible(true);
        Image icono = Toolkit.getDefaultToolkit().getImage("src/images/ezgif.com-gif-maker.png");

        // Define el icono
        vist.setIconImage(icono);

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
