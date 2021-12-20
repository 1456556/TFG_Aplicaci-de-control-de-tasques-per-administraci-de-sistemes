/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesNotificacio;
import Model.ConsultesTasques;
import Model.Notificacio;
import Model.Tasques;
import Vista.JFPrincipal;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ControladorNotificacio {

    public Notificacio mod;
    public ConsultesNotificacio modC;
    public JFPrincipal vis;
    public DefaultTableModel modelTasques;

    public ControladorNotificacio(Notificacio mod, ConsultesNotificacio modC, JFPrincipal vis) {

        this.mod = mod;
        this.modC = modC;
        this.vis = vis;

    }

    public void Notificacio(Date date) throws MessagingException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String d = formatter.format(date);

        mod.setData(d);

        switch (modC.Notificacio(mod)) {

            case 0:
                break;
            case 1:
                System.out.println("DATA:");
                String d2,
                 d3;

                if (mod.getDataProgres().isEmpty()) {

                    d2 = mod.getData();
                    d3 = mod.getData_final();

                } else {

                    d2 = mod.getDataProgres();
                    d3 = mod.getData_final();
                }

                String date2 = d2.substring(0, 10);
                String time2 = d2.substring(11, 16);
                String data2 = date2.replace("-", "/");

                String date3 = d3.substring(0, 10);
                String time3 = d3.substring(11, 16);
                String data3 = date3.replace("-", "/");

                System.out.println("DATAASAAAAAAAA:" + d2);
                System.out.println("sSubCadena:" + date2);
                System.out.println("sSubCadena:" + data2);
                System.out.println("sSubCadena:" + time2);

                DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm");

                DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("HH:mm");

                //convert String to LocalDate
                LocalDate localDate1 = LocalDate.parse(data2, formatter3);
                LocalTime localTime1 = LocalTime.parse(time2, formatter4);

                //convert String to LocalDate
                LocalDate localDate2 = LocalDate.parse(data3, formatter5);
                LocalTime localTime2 = LocalTime.parse(time3, formatter6);

                int result = localDate1.compareTo(localDate2);
                int result2 = localTime1.compareTo(localTime2);

                if ((result < 0) || (result == 0 && result2 <= 0)) {
                    Tasques modTasques = new Tasques();
                    ConsultesTasques modCTasques = new ConsultesTasques();
                    ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);
                    con.Recurrent(mod.getIdTasca());
                    if (ControladorConfiguracio.enviarCorreu == true) {
                        EnviarCorreu();
                    }
                    if (ControladorConfiguracio.so == true) {
                        ReproduirSoroll();
                    }
                    String[] botones = {"Veure Tasca", "Posposar 5min"};
                    int ventana = JOptionPane.showOptionDialog(null, mod.getTitol(), "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            botones, botones[0]);
                    if (ventana == 0) {
                        System.out.println("Veure Tasca");
                        modC.ActualitzaNotificacio(mod);
                        con.NotificacioTasca(mod.getIdTasca());
                    } else {
                        long timeInSecs = date.getTime();
                        Date afterAdding10Mins = new Date((1 * 60 * 1000) + timeInSecs);
                        //String d = data.substring(14,16);
                        System.out.println("Posposar 5min");
                        DateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                        String data = formatter2.format(afterAdding10Mins);
                        System.out.println("DATAAAAAAAAA:" + data);
                        mod.setData(data);
                        modC.Posposar(mod);
                        Tasques modTasques1 = new Tasques();
                        ConsultesTasques modCTasques1 = new ConsultesTasques();
                        //JFPrincipal vistPrincipal = new JFPrincipal(); 
                        ControladorTasques con1 = new ControladorTasques(modTasques1, modCTasques1, vis);
                        con1.MostrarTaula(vis.jTable_Tasques);

                    }

                }
                Natejar(mod);
                break;

            case 2:
                Tasques modTasques2 = new Tasques();
                ConsultesTasques modCTasques2 = new ConsultesTasques();
                ControladorTasques con2 = new ControladorTasques(modTasques2, modCTasques2, vis);
                if (ControladorConfiguracio.enviarCorreu == true) {
                    EnviarCorreu();
                }
                if (ControladorConfiguracio.so == true) {
                    ReproduirSoroll();
                }
                String[] botones = {"Veure Tasca", "Posposar 5min"};
                int ventana = JOptionPane.showOptionDialog(null, mod.getTitol(), "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        botones, botones[0]);
                if (ventana == 0) {
                    System.out.println("Veure Tasca");
                    modC.ActualitzaNotificacio(mod);
                    con2.NotificacioTasca(mod.getIdTasca());
                } else {
                    long timeInSecs = date.getTime();
                    Date afterAdding10Mins = new Date((1 * 60 * 1000) + timeInSecs);
                    //String d = data.substring(14,16);
                    System.out.println("Posposar 5min");
                    DateFormat formatter2 = new SimpleDateFormat("dd-MM-yyyy HH:mm");
                    String data = formatter2.format(afterAdding10Mins);
                    System.out.println("DATAAAAAAAAA:" + data);
                    mod.setData(data);
                    modC.Posposar(mod);
                    Tasques modTasques1 = new Tasques();
                    ConsultesTasques modCTasques1 = new ConsultesTasques();
                    //JFPrincipal vistPrincipal = new JFPrincipal(); 
                    ControladorTasques con1 = new ControladorTasques(modTasques1, modCTasques1, vis);
                    con1.MostrarTaula(vis.jTable_Tasques);

                }

                Natejar(mod);
                break;

            default:
                break;

        }

    }

    public void Natejar(Notificacio not) {

        not.setRecurrent(false);

    }

    public void ReproduirSoroll() {

        String nombreSonido = "alert.wav";
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }
    }

    public void EnviarCorreu() throws AddressException, MessagingException {

        // Get a Properties object
        Properties p = System.getProperties();
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smpt.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.port", "587");
        p.setProperty("mail.smtp.port", "correo");
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);

        MimeMessage msg = new MimeMessage(s);

        try {

            msg.setFrom(new InternetAddress("controltasques@gmail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mod.getMail()));
            msg.setSubject("Tasca nova!");
            msg.setText("                Control Tasques          \n"
                    + "                                           \n"
                    + "Titol:   " + mod.getTitol() + "                \n"
                    + "Usuari:  " + mod.getUsuari() + "               \n"
                    + "Data Venicment:  " + mod.getData() + "         \n"
                    + "Prioritat:  " + mod.getPrioritat() + "         \n"
                    + "Estat:  " + mod.getEstat() + "                 \n"
                    + "Descripció:  " + mod.getDescripcio() + "       \n");

            msg.setSentDate(new Date());

            Transport t = s.getTransport("smtp");
            t.connect("victor98calvo@gmail.com", "teylxccdwafmfsgh");
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();

            System.out.println("Message sent!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!e.");
        } catch (AddressException ex) {

            System.err.println(ex + "Error al enviar el correu");

        }
    }

}
