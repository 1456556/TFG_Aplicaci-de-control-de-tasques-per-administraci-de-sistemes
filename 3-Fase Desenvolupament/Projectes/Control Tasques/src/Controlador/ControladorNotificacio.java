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
import Vista.JFRepeticio;
import java.util.Date;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



/**
 *
 * @author Victor
 */
public class ControladorNotificacio   {
    
   public Notificacio mod;
    public ConsultesNotificacio modC;
    public JFPrincipal vis;
    public JFRepeticio repeticio;
    public DefaultTableModel modelTasques;
      
    
    public ControladorNotificacio(Notificacio mod, ConsultesNotificacio modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
        
        
    }
    
    
    public void Notificacio(Date date) throws MessagingException{
    
    
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");            
        String d = formatter.format(date);
        
        mod.setData(d);
        
        switch (modC.Notificacio(mod)) {                     
                       
                case 0:                                                
                    break;                
                case 1:
                    EnviarCorreu();
                    String[] botones = {"Veure Tasca", "Posposar 5min"};
                    int ventana = JOptionPane.showOptionDialog(null, mod.getTitol(), "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                            botones, botones[0]);                    
                    if (ventana == 0) {
                        System.out.println("Veure Tasca");
                        modC.ActualitzaNotificacio(mod);
                        Tasques modTasques = new Tasques();
                        ConsultesTasques modCTasques = new ConsultesTasques();                        
                        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis, repeticio); 
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
                        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis, repeticio); 
                        con.MostrarTaula(vis.jTable_Tasques);
                        
                    
                    }
                    break;               
                default:
                    break;                 
                    
            }
    
    
    
    }
    
    
    public void EnviarCorreu() throws AddressException, MessagingException{
    
    
      
      
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
        
        try{
            
       
        msg.setFrom(new InternetAddress("controltasques@gmail.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mod.getMail()));
        msg.setSubject("Tasca nova!");
        msg.setText("                Control Tasques          \n"
                + "                                           \n"
                + "Titol:   "+mod.getTitol()+"                \n"
                
                + "Usuari:  "+mod.getUsuari()+"               \n"
               
                + "Data Venicment:  "+mod.getData()+"         \n"
               
                + "Prioritat:  "+mod.getPrioritat()+"         \n"
               
                + "Estat:  "+mod.getEstat()+"                 \n"
               
                + "Descripció:  "+mod.getDescripcio()+"       \n");
        
        msg.setSentDate(new Date());

        Transport t = s.getTransport("smtp");
        t.connect("victor98calvo@gmail.com", "teylxccdwafmfsgh");
        t.sendMessage(msg, msg.getAllRecipients());
        t.close();

        System.out.println("Message sent!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!e.");
        }catch(AddressException ex){
        
            System.err.println(ex + "Error al enviar el correu");
        
        }
    }


}
