/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Model.ConsultesRepeticio;
import Model.ConsultesTasques;
import Model.Login;
import Model.Tasques;
import Vista.JFPrincipal;
import Vista.JFRepeticio;
import clases.Conexio;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.firstInMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.autocomplete.ObjectToStringConverter;

/**
 *
 * @author Victor
 */
public class ControladorTasques extends JFPrincipal implements ActionListener, MouseListener, KeyListener  {
    
    public Tasques mod;
    public ConsultesTasques modC;
    public JFPrincipal vis;
    public JFRepeticio repeticio;

    public DefaultTableModel modelTasques;
      
    
    public ControladorTasques(Tasques mod, ConsultesTasques modC, JFPrincipal vis, JFRepeticio repeticio ){
    
        
        this.mod = mod;
        this.modC = modC;
        this.vis = vis;
        
         this.repeticio = repeticio;
        
        this.vis.jButtonNovaTasca.addActionListener(this);
        this.vis.jButtonRepeticio.addActionListener(this);
         this.vis.jButtonRegistarTasca.addActionListener(this);
        this.vis.jButtonEditarTasca.addActionListener(this);
        this.vis.jButtonEliminarTasca.addActionListener(this);
        this.vis.jButtonRepeticio.addActionListener(this);        
        this.vis.jTable_Tasques.addMouseListener(this);        
        this.vis.txtBuscadorTasques.addKeyListener(this);
        this.vis.jButtonTascaNormal.addActionListener(this);
        this.vis.jButtonTascaRepetio.addActionListener(this);
        
        
        this.vis.jButtonAceptar.addActionListener(this);
        this.vis.jButtonCancelar.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(this.vis.jRadioButtonDiari);
        group.add(this.vis.jRadioButtonSetmanal);
        group.add(this.vis.jRadioButtonMensual);
        group.add(this.vis.jRadioButtonAnual);
        
        
        ButtonGroup group3 = new ButtonGroup();
        group3.add(this.vis.jRadioButtonDiari1);
        group3.add(this.vis.jRadioButtonSetmanal1);
        group3.add(this.vis.jRadioButtonMensual1);
        group3.add(this.vis.jRadioButtonAnual1);
        
        
        ButtonGroup group2 = new ButtonGroup();
        group2.add(this.vis.jRadioButtonDataFinal);
        group2.add(this.vis.jRadioButtonAcabar);
        
         ButtonGroup group4 = new ButtonGroup();
        group4.add(this.vis.jRadioButtonDataFinal1);
        group4.add(this.vis.jRadioButtonAcabar1);
        
        this.vis.jRadioButtonDataFinal.setSelected(true);
        this.vis.dateTimePickerRepeticioFinal.setEnabled(true);
        this.vis.jRadioButtonDiari.setSelected(true);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        this.vis.jRadioButtonMensual.addActionListener(this);
        this.vis.jRadioButtonAcabar.addActionListener(this);
        this.vis.jRadioButtonDiari.addActionListener(this);
        this.vis.jRadioButtonSetmanal.addActionListener(this);
        this.vis.jRadioButtonAnual.addActionListener(this);
        this.vis.jRadioButtonEl.addActionListener(this);
        
        this.vis.jRadioButtonDiari1.addActionListener(this);
        this.vis.jRadioButtonSetmanal1.addActionListener(this);
        this.vis.jRadioButtonMensual1.addActionListener(this);
        this.vis.jRadioButtonAcabar1.addActionListener(this);
        this.vis.jRadioButtonDiari1.addActionListener(this);
        this.vis.jRadioButtonSetmanal1.addActionListener(this);
        this.vis.jRadioButtonAnual1.addActionListener(this);
        
       
        vis.ComboMes.setVisible(false);
        vis.jRadioButtonEl.setVisible(false);
        vis.ComboMesNumero.setVisible(false);
        vis.ComboMesDia.setVisible(false);
        vis.jLabelMesos.setVisible(false);
        vis.jLabelAnys.setVisible(false);
        vis.jLabelSetmanes.setVisible(false);
        vis.jCheckBoxDijous.setVisible(false);
        vis.jCheckBoxDimecres.setVisible(false);
        vis.jCheckBoxDivendres.setVisible(false);
        vis.jCheckBoxDissabte.setVisible(false);
        vis.jCheckBoxDiumenge.setVisible(false);
        vis.jCheckBoxDilluns.setVisible(false);
        vis.jCheckBoxDimarts.setVisible(false);
        
        vis.jLabelMesos1.setVisible(false);
        vis.jLabelAnys1.setVisible(false);
        vis.jLabelSetmanes1.setVisible(false);
        vis.jCheckBoxDijous1.setVisible(false);
        vis.jCheckBoxDimecres1.setVisible(false);
        vis.jCheckBoxDivendres1.setVisible(false);
        vis.jCheckBoxDissabte1.setVisible(false);
        vis.jCheckBoxDiumenge1.setVisible(false);
        vis.jCheckBoxDilluns1.setVisible(false);
        vis.jCheckBoxDimarts1.setVisible(false);
        
        
        vis.ComboMesDia.setEnabled(false);
        vis.ComboMesNumero.setEnabled(false);
        vis.ComboMes.setEnabled(false);
        
       
        
            
    }
    
    public ControladorTasques(Tasques mod, ConsultesTasques modC, JFPrincipal vis){
    
        this.mod = mod;
        this.modC = modC;
       
        this.vis = vis;
    
    }
   
     
    public void inicialitzar(){
        
        
        
                   
    
    }


    
     public void NotificacioTasca(int id){
    
    
       mod.setId(id);
       System.out.println("ID + Not:" + id);
       
       switch (modC.informacioTasca(mod)){
                
                    case 0:
                         JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");
                         break;
                     case 1:
                         vis.txt_titolTasc2.setText(mod.getTitol());
                         vis.ComboUsuariAssignat.removeAll();
                         modC.UsuariAssignat(vis, 1);
                         AutoCompleteDecorator.decorate(ComboUsuariAssignat);
                         vis.txt_descripcioTasc2.setText(mod.getDescripcio());

                         String d = mod.getData();
                         String date = d.substring(0, 10);
                         String time = d.substring(11, 16);
                         String data = date.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d);
                         System.out.println("sSubCadena:" + date);
                         System.out.println("sSubCadena:" + data);
                         System.out.println("sSubCadena:" + time);

                         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate = LocalDate.parse(data, formatter);
                         LocalTime localTime = LocalTime.parse(time, formatter2);

                         //ControladorMenu cn = new ControladorMenu(vis);
                         //cn.notificacio();
                         vis.dateTimePicker1.datePicker.setDate(localDate);
                         vis.dateTimePicker1.timePicker.setTime(localTime);
                         vis.ComboPrioritatTasc2.setSelectedItem(mod.getPrioritat());
                         vis.ComboEstatTasc2.setSelectedItem(mod.getEstat());
                         vis.txt_titolTasc2.setText(mod.getTitol());
                         vis.DashInfoTasca.setVisible(true);
                         vis.DashTasques.setVisible(false);

                         vis.DashInfoUsuari.setVisible(false);
                         //vis.DashInfoTasca.setVisible(false);
                         vis.DashNovaTasca.setVisible(false);
                         vis.DashConfiguracio.setVisible(false);
                         vis.DashNouUsuari.setVisible(false);
                         vis.DashNouElement.setVisible(false);
                         vis.DashUsuaris.setVisible(false);
                         vis.DashElements.setVisible(false);
                         vis.DashInfoElement.setVisible(false);
                         break;
                     case 2:
                         vis.ComboUsuariAssignat3.removeAll();
                         modC.UsuariAssignat1(vis, 1);
                         AutoCompleteDecorator.decorate(ComboUsuariAssignat3);

                         vis.txt_titolTasc3.setText(mod.getTitol());
                         vis.ComboUsuariAssignat3.setSelectedItem(mod.getUsuariAssignat());
                         vis.txt_descripcioTasc3.setText(mod.getDescripcio());

                         String d2 = mod.getData();
                         String date2 = d2.substring(0, 10);
                         String time2 = d2.substring(11, 16);
                         String data2 = date2.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d2);
                         System.out.println("sSubCadena:" + date2);
                         System.out.println("sSubCadena:" + data2);
                         System.out.println("sSubCadena:" + time2);

                         DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate1 = LocalDate.parse(data2, formatter3);
                         LocalTime localTime1 = LocalTime.parse(time2, formatter4);
                         
                         String d3 = mod.getDataFinal();
                         String date3 = d3.substring(0, 10);
                         String time3 = d3.substring(11, 16);
                         String data3 = date3.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d3);
                         System.out.println("sSubCadena:" + date3);
                         System.out.println("sSubCadena:" + data3);
                         System.out.println("sSubCadena:" + time3);

                         DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate2 = LocalDate.parse(data3, formatter5);
                         LocalTime localTime2 = LocalTime.parse(time3, formatter6);
                         
                         
                         vis.dateTimePickerRepeticio1.datePicker.setDate(localDate1);
                         vis.dateTimePickerRepeticio1.timePicker.setTime(localTime1);
                        vis.dateTimePickerRepeticioFinal1.datePicker.setDate(localDate2);
                         vis.dateTimePickerRepeticioFinal1.timePicker.setTime(localTime2);
                         vis.ComboPrioritatTasc4.setSelectedItem(mod.getPrioritat());
                         vis.ComboEstatTasc3.setSelectedItem(mod.getEstat());
                         vis.txt_titolTasc3.setText(mod.getTitol());
                         vis.jSpinner1.setValue(mod.getRepeticio());                        
                         vis.DashInfoTascaRepeticio.setVisible(true);
                         vis.DashTasques.setVisible(false);
                         
                         if (mod.getTipus().equals("Diari")){
                             
                            vis.jRadioButtonDiari1.setSelected(true);
                            vis.jLabelSetmanes2.setVisible(false);
                            vis.jLabelMesos1.setVisible(false);
                            vis.jLabelAnys1.setVisible(false);  
                         }
                                
                               
                                
                                
                           
                         
                         
                         
                          if (mod.getDataFinal() != ""){
                         
                             vis.dateTimePickerRepeticioFinal1.setEnabled(true);
                             vis.jRadioButtonDataFinal1.setSelected(true);
                             vis.jSpinnerAcabar1.setEnabled(false);
                             vis.jRadioButtonAcabar1.setSelected(false);
                         
                         }else{
                         
                             vis.dateTimePickerRepeticioFinal1.setEnabled(false);
                             vis.jRadioButtonDataFinal1.setSelected(false);
                             vis.jSpinnerAcabar1.setEnabled(true);
                             vis.jRadioButtonAcabar1.setSelected(true);
                         
                         }
                         
                         
                         
                         
                         
                         
                         
                         break;
                     
                     default:
                         break;
                         
           



      
      }
       
     }
     
     
     public void Recurrent(int id){
         
         mod.setId(id);
         System.out.println("ID + Not:" + id);
     
         switch (modC.informacioTasca(mod)) {

             case 0:
                 break;

             case 1:

                 break;

             case 2:
              
                     
                     String d2, d3;
                     
                     if (mod.getDataProgres().isEmpty()) {

                           d2 = mod.getData();
                           d3 = mod.getDataFinal();

                     } else {

                          d2 = mod.getDataProgres();
                           d3 = mod.getDataFinal();
                     }

                     
                    
                     String date2 = d2.substring(0, 10);
                     String time2 = d2.substring(11, 16);
                     String data2 = date2.replace("-", "/");
                     
                     String date3 = d3.substring(0, 10);
                     String time3 = d3.substring(11, 16);
                     String data3 = date3.replace("-", "/");

                     System.out.println("REcurrent DATAASAAAAAAAA:" + d2);
                     System.out.println("REcurrent sSubCadena:" + date2);
                     System.out.println("REcurrent sSubCadena:" + data2);
                     System.out.println("REcurrent sSubCadena:" + time2);

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

                     if (mod.getTipus().equals("Diari")){
                     
                          localDate1 = localDate1.plusDays(mod.getRepeticio());

                         System.out.println("Data progresssss:" + localDate1);
                         int result = localDate1.compareTo(localDate2);
                         int result2 = localTime1.compareTo(localTime2);

                         if ((result < 0) || (result == 0 && result2 <= 0)) {

                             if (!mod.getDataProgres().isEmpty()) {

                                 localDate1 = localDate1.plusDays(mod.getRepeticio());

                             }

                            
                             System.out.println("Data progress:" + localDate1);
                             String timeProgres = localTime1.toString();
                             String dataProgres = localDate1.toString();

                             String day = dataProgres.substring(8, 10);
                             String month = dataProgres.substring(5, 7);
                             String year = dataProgres.substring(0, 4);

                             System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                             dataProgres = day + "-" + month + "-" + year;
                             dataProgres = dataProgres + " " + timeProgres;
                             System.out.println(dataProgres);

                             Tasques tas = new Tasques();

                             tas.setDataProgres(dataProgres);
                             tas.setRepeticio(mod.getRepeticio());
                             System.out.println("REPETICIO" + mod.getRepeticio());
                             System.out.println("REPETICIO" + tas.getRepeticio());
                             tas.setTitol(mod.getTitol());
                             tas.setPrioritat(mod.getPrioritat());
                             tas.setUsuariAssignat(mod.getUsuariAssignat());
                             tas.setData(mod.getData());
                             tas.setEstat(mod.getEstat());
                             tas.setDescripcio(mod.getDescripcio());
                             // tas.setNotificacio(mod.getNotificacio());
                             tas.setDataFinal(mod.getDataFinal());
                             tas.setRecurrent(mod.isRecurrent());
                             tas.setTipus(mod.getTipus());

                             modC.GenerarTascaRecurrent(tas);
                         } else {

                             //S'ha finalitzat la tasca recurrent.
                         }
                     
                     }
                     if (mod.getTipus().equals("Setmanal")) {
                         
                        // if (mod.getDataProgres().isEmpty()) {
                             
                             System.out.println("Entra a Setmanal");
                             localDate1 = localDate1.plusWeeks(mod.getRepeticio());
                             String diesSetmana = mod.getDiesSetmana();
                             int longitud = diesSetmana.length();

                             for (int i = 0; i < longitud; i++) {

                                 char dia = diesSetmana.charAt(i);
                                 String d = String.valueOf(dia);
                                 if (d.equals("L")) {

                                     localDate1 = localDate1.with(DayOfWeek.MONDAY);
                                     System.out.println("Dilluns:" + localDate1.with(DayOfWeek.MONDAY));
                                     System.out.println("Dilluns:" + localDate1);

                                 }
                                 if (d.equals("M")) {

                                     localDate1 = localDate1.with(DayOfWeek.TUESDAY);
                                     System.out.println("Dimarts:" + localDate1.with(DayOfWeek.TUESDAY));
                                     System.out.println("Dimarts:" + localDate1);

                                 }
                                 if (d.equals("X")) {

                                     localDate1 = localDate1.with(DayOfWeek.WEDNESDAY);
                                     System.out.println("Dimecres:" + localDate1.with(DayOfWeek.WEDNESDAY));
                                     System.out.println("Dimecres:" + localDate1);

                                 }
                                 if (d.equals("J")) {

                                     localDate1 = localDate1.with(DayOfWeek.THURSDAY);
                                     System.out.println("Dijous:" + localDate1.with(DayOfWeek.THURSDAY));
                                     System.out.println("Dijous:" + localDate1);

                                 }
                                 if (d.equals("V")) {

                                     localDate1 = localDate1.with(DayOfWeek.FRIDAY);
                                     System.out.println("Divendres:" + localDate1.with(DayOfWeek.FRIDAY));
                                     System.out.println("Divendres:" + localDate1);

                                 }
                                 if (d.equals("S")) {

                                     localDate1 = localDate1.with(DayOfWeek.SATURDAY);
                                     System.out.println("Dissabte:" + localDate1.with(DayOfWeek.SATURDAY));
                                     System.out.println("Dissabte:" + localDate1);

                                 }
                                 if (d.equals("D")) {

                                     localDate1 = localDate1.with(DayOfWeek.SUNDAY);
                                     System.out.println("Diumenge:" + localDate1.with(DayOfWeek.SUNDAY));
                                     System.out.println("Diumenge:" + localDate1);

                                 }

                                 int result = localDate1.compareTo(localDate2);
                                 int result2 = localTime1.compareTo(localTime2);

                                 if ((result < 0) || (result == 0 && result2 <= 0)) {

                                     System.out.println("Data progress:" + localDate1);
                                     String timeProgres = localTime1.toString();
                                     String dataProgres = localDate1.toString();

                                     String day = dataProgres.substring(8, 10);
                                     String month = dataProgres.substring(5, 7);
                                     String year = dataProgres.substring(0, 4);

                                     System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                                     dataProgres = day + "-" + month + "-" + year;
                                     dataProgres = dataProgres + " " + timeProgres;
                                     System.out.println(dataProgres);

                                     String di = localDate1.getDayOfWeek().toString();
                                     di = diadelaSetmana(di);

                                     Tasques tas = new Tasques();

                                     tas.setDiesSetmana(di);
                                     tas.setDataProgres(dataProgres);
                                     tas.setRepeticio(mod.getRepeticio());
                                     System.out.println("REPETICIO" + mod.getRepeticio());
                                     System.out.println("REPETICIO" + tas.getRepeticio());
                                     tas.setTitol(mod.getTitol());
                                     tas.setPrioritat(mod.getPrioritat());
                                     tas.setUsuariAssignat(mod.getUsuariAssignat());
                                     tas.setData(mod.getData());
                                     tas.setEstat(mod.getEstat());
                                     tas.setDescripcio(mod.getDescripcio());
                                     // tas.setNotificacio(mod.getNotificacio());
                                     tas.setDataFinal(mod.getDataFinal());
                                     tas.setRecurrent(mod.isRecurrent());
                                     tas.setTipus(mod.getTipus());

                                     modC.GenerarTascaRecurrent(tas);

                                 }

                             }

                        // }
                         
                          
                         
                     }else{
                         
                         //Fin tasca
                     
                     } 
                     
                     if (mod.getTipus().equals("Mensual")){
                         
                         LocalDate start = localDate1.with(firstDayOfMonth());
                         LocalDate end = localDate1.with(lastDayOfMonth());
                         LocalDate S = localDate1.with(firstInMonth(DayOfWeek.MONDAY));                         
                         LocalDate dsad = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.MONDAY));
                         System.out.println(dsad);
                         localDate1 = localDate1.plusMonths(mod.getRepeticio());
                         
                         String diesSetmana = mod.getDiesSetmana();                         
                         String[] textoSeparado = diesSetmana.split(" ");
                         int longitud = diesSetmana.length();
                         
                         if (longitud > 0){
                         
                         String numeros = textoSeparado[0];
                         String dia = textoSeparado[1];
                         int numeroInt=0;
                         
                         if (numeros.equals("Primer")){
                         
                             numeroInt = 1;
                             
                         }
                         if (numeros.equals("Segon")){
                         
                             numeroInt = 2;
                             
                         }
                         if (numeros.equals("Tercer")){
                         
                             numeroInt = 3;
                             
                         }
                         if (numeros.equals("Cuart")){
                         
                             numeroInt = 4;
                             
                         }
                         if (numeros.equals("Últim")){
                         
                             numeroInt = 5;
                             
                         }
                         if (dia.equals("Dilluns")){
                         
                            localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.MONDAY));
                             
                         }
                         if (dia.equals("Dimarts")){
                         
                            localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.TUESDAY));
                             
                         }
                         if (dia.equals("Dimecres")){
                         
                            localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.WEDNESDAY));
                             
                         }
                         if (dia.equals("Dijous")){
                         
                            localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.THURSDAY));
                             
                         }
                         if (dia.equals("Divendres")){
                         
                             localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.FRIDAY));
                             
                         }
                         if (dia.equals("Dissabte")){
                         
                             localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.SATURDAY));
                             
                         }
                         if (dia.equals("Diumenge")){
                         
                            localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.SUNDAY));
                             
                         }
                         
                         }


                     System.out.println("Data progresssss:" + localDate1);
                     int result = localDate1.compareTo(localDate2);
                     int result2 = localTime1.compareTo(localTime2);

                     if ((result < 0) || (result == 0 && result2 <= 0)) {

                         /* if (!mod.getDataProgres().isEmpty()) {

                                 localDate1 = localDate1.plusMonths(mod.getRepeticio());

                             }*/
                         System.out.println("Data progress:" + localDate1);
                         String timeProgres = localTime1.toString();
                         String dataProgres = localDate1.toString();

                         String day = dataProgres.substring(8, 10);
                         String month = dataProgres.substring(5, 7);
                         String year = dataProgres.substring(0, 4);

                         System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                         dataProgres = day + "-" + month + "-" + year;
                         dataProgres = dataProgres + " " + timeProgres;
                         System.out.println(dataProgres);

                         Tasques tas = new Tasques();

                         tas.setDiesSetmana(diesSetmana);
                         tas.setDataProgres(dataProgres);
                         tas.setRepeticio(mod.getRepeticio());
                         System.out.println("REPETICIO" + mod.getRepeticio());
                         System.out.println("REPETICIO" + tas.getRepeticio());
                         tas.setTitol(mod.getTitol());
                         tas.setPrioritat(mod.getPrioritat());
                         tas.setUsuariAssignat(mod.getUsuariAssignat());
                         tas.setData(mod.getData());
                         tas.setEstat(mod.getEstat());
                         tas.setDescripcio(mod.getDescripcio());
                         // tas.setNotificacio(mod.getNotificacio());
                         tas.setDataFinal(mod.getDataFinal());
                         tas.setRecurrent(mod.isRecurrent());
                         tas.setTipus(mod.getTipus());

                         modC.GenerarTascaRecurrent(tas);

                     }

                 } else {

                     //Fi de la tasca reccurent Menusal
                 }

                 if (mod.getTipus().equals("Anual")) {

                     localDate1 = localDate1.plusYears(mod.getRepeticio());
                     System.out.println("dies Setmanas" + mod.getDiesSetmana());
                     String diesSetmana = "";
                     if (!mod.getDiesSetmana().equals(" ")) {
                         diesSetmana = mod.getDiesSetmana();
                         String[] textoSeparado = diesSetmana.split(" ");
                         int longitud = diesSetmana.length();

                         String numeros = textoSeparado[0];
                         String dia = textoSeparado[1];
                         String mes = textoSeparado[2];
                         int numeroInt = 0;
                         
                         if (mes.equals("Gener")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.JANUARY, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Febrer")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.FEBRUARY, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Març")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.MARCH, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Abril")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.APRIL, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Maig")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.MAY, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Juny")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.JUNE, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Juliol")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.JULY, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Agost")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.AUGUST, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Setembre")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.SEPTEMBER, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Octubre")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.OCTOBER, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Novembre")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.NOVEMBER, localDate1.getDayOfMonth());

                             }
                             if (mes.equals("Desembre")) {

                                 localDate1 = localDate1.of(localDate1.getYear(), Month.DECEMBER, localDate1.getDayOfMonth());

                             }

                         if (numeros.equals("Primer")) {

                             numeroInt = 1;

                         }
                         if (numeros.equals("Segon")) {

                             numeroInt = 2;

                         }
                         if (numeros.equals("Tercer")) {

                             numeroInt = 3;

                         }
                         if (numeros.equals("Cuart")) {

                             numeroInt = 4;

                         }
                         if (numeros.equals("Últim")) {

                             numeroInt = 5;

                         }
                         if (dia.equals("Dilluns")) {

                             localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.MONDAY));

                         }
                         if (dia.equals("Dimarts")) {

                             localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.TUESDAY));

                         }
                             if (dia.equals("Dimecres")) {

                                 localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.WEDNESDAY));

                             }
                             if (dia.equals("Dijous")) {

                                 localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.THURSDAY));

                             }
                             if (dia.equals("Divendres")) {

                                 localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.FRIDAY));

                             }
                             if (dia.equals("Dissabte")) {

                                 localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.SATURDAY));

                             }
                             if (dia.equals("Diumenge")) {

                                 localDate1 = localDate1.with(TemporalAdjusters.dayOfWeekInMonth(numeroInt, DayOfWeek.SUNDAY));

                             }
                             
                             System.out.println("Dia " + localDate1);
                             
                             
                             
                              System.out.println("Mes " + localDate1);
                          
                         }
                         
                         
                         

                         System.out.println("Data progresssss:" + localDate1);
                         int result = localDate1.compareTo(localDate2);
                         int result2 = localTime1.compareTo(localTime2);

                         if ((result < 0) || (result == 0 && result2 <= 0)) {

                            /* if (!mod.getDataProgres().isEmpty()) {

                                 localDate1 = localDate1.plusMonths(mod.getRepeticio());

                             }*/

                            
                             System.out.println("Data progress:" + localDate1);
                             String timeProgres = localTime1.toString();
                             String dataProgres = localDate1.toString();

                             String day = dataProgres.substring(8, 10);
                             String month = dataProgres.substring(5, 7);
                             String year = dataProgres.substring(0, 4);

                             System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                             dataProgres = day + "-" + month + "-" + year;
                             dataProgres = dataProgres + " " + timeProgres;
                             System.out.println(dataProgres);

                             Tasques tas = new Tasques();
                             
                             tas.setDiesSetmana(diesSetmana);
                             tas.setDataProgres(dataProgres);
                             tas.setRepeticio(mod.getRepeticio());
                             System.out.println("REPETICIO" + mod.getRepeticio());
                             System.out.println("REPETICIO" + tas.getRepeticio());
                             tas.setTitol(mod.getTitol());
                             tas.setPrioritat(mod.getPrioritat());
                             tas.setUsuariAssignat(mod.getUsuariAssignat());
                             tas.setData(mod.getData());
                             tas.setEstat(mod.getEstat());
                             tas.setDescripcio(mod.getDescripcio());
                             // tas.setNotificacio(mod.getNotificacio());
                             tas.setDataFinal(mod.getDataFinal());
                             tas.setRecurrent(mod.isRecurrent());
                             tas.setTipus(mod.getTipus());

                             modC.GenerarTascaRecurrent(tas);
                         
                         
                         }     
                         
                          
                          
                      }else{
                          
                           //Fi de la tasca recurrent Anual
                      
                      }
                    

                     

                     
                     break;

         
         
     
     
         }
     
     
     
     }
    
     
     public String diadelaSetmana(String dia){
         
         String letraD="";
         
         if (dia.equals("MONDAY")){
         
             letraD = "L";
         }
         if (dia.equals("TUESDAY")){
         
             letraD = "M";
         }
         if (dia.equals("WEDNESDAY")){
         
             letraD = "X";
         }
         if (dia.equals("THURSDAY")){
         
             letraD = "J";
         }
         if (dia.equals("FRIDAY")){
         
             letraD = "V";
         }
         if (dia.equals("SATURDAY")){
         
             letraD = "S";
         }if (dia.equals("SUNDAY")){
         
             letraD = "D";
         }
        
         

        return letraD;  
     
     }
      
     
     @Override
    public void actionPerformed(ActionEvent e){
        
       
        if (e.getSource() == vis.jRadioButtonEl){
            
            if (vis.jRadioButtonMensual.isSelected()){
        
            if(vis.jRadioButtonEl.isSelected()){
            
                vis.ComboMesNumero.setEnabled(true);
                vis.ComboMesDia.setEnabled(true);
            
            
            }else{
                
                 vis.ComboMesNumero.setEnabled(false);
                vis.ComboMesDia.setEnabled(false);
            
            
            }
        }
            
             if (vis.jRadioButtonAnual.isSelected()){
        
            if(vis.jRadioButtonEl.isSelected()){
            
                vis.ComboMesNumero.setEnabled(true);
                vis.ComboMesDia.setEnabled(true);
                vis.ComboMes.setEnabled(true);
            
            
            }else{
                
                vis.ComboMesNumero.setEnabled(false);
                vis.ComboMesDia.setEnabled(false);
                vis.ComboMes.setEnabled(false);
            
            
            }
        }
            
            
        
        
        
        
        }
        
        
        if (e.getSource() == vis.jButtonRepeticio){
             
            
           
             repeticio.setVisible(true);            
             ControladorRepeticio cr = new ControladorRepeticio(repeticio, mod);
             cr.inicialitza();
             
        }
        
        if (e.getSource() == vis.jButtonTascaNormal){
        
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(true);
            DefaultComboBoxModel mdl = new DefaultComboBoxModel();
            mdl.removeAllElements();
            vis.ComboUsuariAssignat.setModel(mdl);
            vis.ComboUsuariAssignat.setSelectedItem(Login.usuari);
            modC.UsuariAssignat(vis,0);
            AutoCompleteDecorator.decorate(vis.ComboUsuariAssignat);            
            natejar();
        
        
        }
        
        if (e.getSource() == vis.jButtonTascaRepetio){
        
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(true);
            DefaultComboBoxModel mdl = new DefaultComboBoxModel();
            mdl.removeAllElements();
            vis.ComboUsuariAssignat1.setModel(mdl);
            vis.ComboUsuariAssignat1.setSelectedItem(Login.usuari);
            modC.UsuariAssignat1(vis,0);
            AutoCompleteDecorator.decorate(vis.ComboUsuariAssignat1);            
            natejar();
        
        
        }
        
         if (e.getSource() == vis.jButtonNovaTasca) {

             vis.DashTasques.setVisible(false);
             vis.DashTriaTasca.setVisible(true);
             vis.dateTimePickerRepeticio.datePicker.setDateToToday();
             vis.dateTimePickerRepeticio.timePicker.setTimeToNow();
             vis.dateTimePickerRepeticioFinal.datePicker.setDateToToday();
             vis.dateTimePickerRepeticioFinal.timePicker.setTimeToNow();

         }

         if (e.getSource() == vis.jButtonAceptar) {
             
             String prioritat_string = null, estat_string = null, aux = " ";
             mod.setTitol(vis.txt_titolTasc1.getText().trim());
             mod.setUsuariAssignat(vis.ComboUsuariAssignat1.getSelectedItem().toString());
             mod.setDescripcio(vis.txt_descripcioTasc1.getText().trim());
             int estat = vis.ComboEstatTasc1.getSelectedIndex() + 1;
             int prioritat = vis.ComboPrioritatTasc3.getSelectedIndex() + 1;
             mod.setRepeticio((Integer) vis.jSpinner.getValue());
             boolean notificacio = false;

            
            if  (vis.jCheckBoxNotificacio1.isSelected()){
            
                notificacio = true;
            }
            
            if (vis.jRadioButtonDiari.isSelected()){
        
               mod.setTipus("Diari");
        
            }
            if (vis.jRadioButtonSetmanal.isSelected()){
        
               mod.setTipus("Setmanal");
        
            }
            if (vis.jRadioButtonMensual.isSelected()){
        
               mod.setTipus("Mensual");
        
            }
            if (vis.jRadioButtonAnual.isSelected()){
        
               mod.setTipus("Anual");
        
            }
            
            if (vis.jCheckBoxDilluns.isSelected()){
        
               String l = "L";
               aux = l;
               
            }
            if (vis.jCheckBoxDimarts.isSelected()){
        
               String m = "M";
               aux = aux + m;
               
            }
            if (vis.jCheckBoxDimecres.isSelected()){
        
               String x = "X";
               aux = aux + x;
               
            }
            if (vis.jCheckBoxDijous.isSelected()){
        
               String j = "J";
               aux = aux + j;
               
            }
            if (vis.jCheckBoxDivendres.isSelected()){
        
               String v = "V";
               aux = aux + v;
               
            }
            if (vis.jCheckBoxDissabte.isSelected()){
        
               String s = "S";
               aux = aux + s;
               
            }
            if (vis.jCheckBoxDimarts.isSelected()){
        
               String d = "D";
               aux = aux + d;
               
            }
            
            if (vis.jRadioButtonEl.isSelected()){
                
                if (vis.jRadioButtonMensual.isSelected()){
            
                aux = (String) vis.ComboMesNumero.getSelectedItem();
                aux = aux + " " + vis.ComboMesDia.getSelectedItem();
                
                }
                
               if (vis.jRadioButtonAnual.isSelected()){
            
                aux = (String) vis.ComboMesNumero.getSelectedItem();
                aux = aux + " " + vis.ComboMesDia.getSelectedItem();
                aux = aux + " " + vis.ComboMes.getSelectedItem();
                
                }
            
            
            }
            
            
        
               mod.setDiesSetmana(aux);
               
            
            

            
            if (estat == 1) {

                estat_string = "Nova";
            }

             if (estat == 2) {

                 estat_string = "En espera";

             }
             if (estat == 3) {

                 estat_string = "En procés";

             }

             if (prioritat == 1) {

                 prioritat_string = "Baixa";
             }
             if (prioritat == 2) {

                 prioritat_string = "Mitja";
             }
             if (prioritat == 3) {

                 prioritat_string = "Alta";

             }
             if (prioritat == 4) {

                 prioritat_string = "Urgent";
             }
             if (prioritat == 5) {

                 prioritat_string = "Prioritaria";
             }

             mod.setEstat(estat_string);
             mod.setPrioritat(prioritat_string);
             mod.setNotificacio(notificacio);

             mod.setData(vis.dateTimePickerRepeticio.getDatePicker().toString());
             mod.setHora(vis.dateTimePickerRepeticio.getTimePicker().toString());
             mod.setDataFinal(vis.dateTimePickerRepeticioFinal.getDatePicker().toString());
             mod.setHoraFinal(vis.dateTimePickerRepeticioFinal.getTimePicker().toString());

             switch (modC.NovaTascaRepeticio(mod)) {

                 case 1:
                     JOptionPane.showMessageDialog(null, "Repeticio guardada correctament");
                     natejar();
                     vis.DashNovaTascaRepeticio.setVisible(false);
                     vis.DashTasques.setVisible(true);
                     MostrarTaula(vis.jTable_Tasques);
                     break;
                 case 2:
                     JOptionPane.showMessageDialog(null, "Error al crear la tasca. Contacti amb l'administrador");
                     break;
                 case 3:
                     JOptionPane.showMessageDialog(null, "La data d'inici ha de ser mes petita a la data final");
                     break;
                 case 4:
                     JOptionPane.showMessageDialog(null, "Els dies no poden ser iguals o menors a 0");

                 case 5:
                     JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                 default:
                     break;

             }

         }
         
         
              
        
             if (e.getSource() == vis.jRadioButtonDataFinal){
                 
                 vis.dateTimePickerRepeticioFinal.setEnabled(true);
                  vis.jSpinnerAcabar.setEnabled(false);
             }
             
             if (e.getSource() == vis.jRadioButtonDataFinal1){
                 
                 vis.dateTimePickerRepeticioFinal1.setEnabled(true);
                  vis.jSpinnerAcabar1.setEnabled(false);
             }
             
             
             if (e.getSource() == vis.jRadioButtonAcabar){
                 
                 vis.jSpinnerAcabar.setEnabled(true);
                 vis.dateTimePickerRepeticioFinal.setEnabled(false);
             }
             
              if (e.getSource() == vis.jRadioButtonAcabar1){
                 
                 vis.jSpinnerAcabar1.setEnabled(true);
                 vis.dateTimePickerRepeticioFinal1.setEnabled(false);
             }
            
                     
          
            
            
            
            
            if (e.getSource() == this.vis.jRadioButtonDiari){
            
                
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(false);
                vis.jLabelDias.setVisible(true);               
                vis.jLabelSetmanes.setVisible(false);
                vis.jCheckBoxDijous.setVisible(false);
                vis.jCheckBoxDimecres.setVisible(false);
                vis.jCheckBoxDivendres.setVisible(false);
                vis.jCheckBoxDissabte.setVisible(false);
                vis.jCheckBoxDiumenge.setVisible(false);
                vis.jCheckBoxDilluns.setVisible(false);
                vis.jCheckBoxDimarts.setVisible(false);
                vis.ComboMesNumero.setVisible(false);
                vis.ComboMesDia.setVisible(false);
                vis.jRadioButtonEl.setVisible(false);
                vis.ComboMes.setVisible(false);

            
            
            
            
            
            }
            
            if (e.getSource() == this.vis.jRadioButtonDiari1){
            
                
                vis.jLabelMesos1.setVisible(false);
                vis.jLabelAnys1.setVisible(false);
                vis.jLabelDias1.setVisible(true);               
                vis.jLabelSetmanes1.setVisible(false);
                vis.jCheckBoxDijous1.setVisible(false);
                vis.jCheckBoxDimecres1.setVisible(false);
                vis.jCheckBoxDivendres1.setVisible(false);
                vis.jCheckBoxDissabte1.setVisible(false);
                vis.jCheckBoxDiumenge1.setVisible(false);
                vis.jCheckBoxDilluns1.setVisible(false);
                vis.jCheckBoxDimarts1.setVisible(false);
                vis.ComboMes.setVisible(false);
                
            
            
            
            
            
            }
            
            if (e.getSource() == this.vis.jRadioButtonSetmanal){
                
               
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(false);
                vis.jLabelDias.setVisible(false);
                vis.jLabelSetmanes.setVisible(true);
                vis.jCheckBoxDijous.setVisible(true);
                vis.jCheckBoxDimecres.setVisible(true);
                vis.jCheckBoxDivendres.setVisible(true);
                vis.jCheckBoxDissabte.setVisible(true);
                vis.jCheckBoxDiumenge.setVisible(true);
                vis.jCheckBoxDilluns.setVisible(true);
                vis.jCheckBoxDimarts.setVisible(true);
                vis.jLabelDias.setVisible(false);
                vis.ComboMesNumero.setVisible(false);
                vis.ComboMesDia.setVisible(false);
                vis.jRadioButtonEl.setVisible(false);
                vis.ComboMes.setVisible(false);
               
                
                
                
            }
            
            if (e.getSource() == this.vis.jRadioButtonSetmanal1){
                
               
                vis.jLabelMesos1.setVisible(false);
                vis.jLabelAnys1.setVisible(false);
                vis.jLabelDias1.setVisible(false);
                vis.jLabelSetmanes1.setVisible(true);
                vis.jCheckBoxDijous1.setVisible(true);
                vis.jCheckBoxDimecres1.setVisible(true);
                vis.jCheckBoxDivendres1.setVisible(true);
                vis.jCheckBoxDissabte1.setVisible(true);
                vis.jCheckBoxDiumenge1.setVisible(true);
                vis.jCheckBoxDilluns1.setVisible(true);
                vis.jCheckBoxDimarts1.setVisible(true);
                vis.jLabelDias1.setVisible(false);
               
             
                
                
            }
            
         if (e.getSource() == this.vis.jRadioButtonMensual) {

             vis.jLabelMesos.setVisible(true);
             vis.jLabelAnys.setVisible(false);
             vis.jLabelDias.setVisible(false);
             vis.jLabelSetmanes.setVisible(false);
             vis.jCheckBoxDijous.setVisible(false);
             vis.jCheckBoxDimecres.setVisible(false);
             vis.jCheckBoxDivendres.setVisible(false);
             vis.jCheckBoxDissabte.setVisible(false);
             vis.jCheckBoxDiumenge.setVisible(false);
             vis.jCheckBoxDilluns.setVisible(false);
             vis.jCheckBoxDimarts.setVisible(false);
             vis.ComboMesNumero.setVisible(true);
             vis.ComboMesDia.setVisible(true);
             vis.jRadioButtonEl.setVisible(true);
             vis.ComboMes.setVisible(false);

         }
             
             if (e.getSource() == this.vis.jRadioButtonMensual1){
                 
                 vis.jLabelMesos1.setVisible(true);
                vis.jLabelAnys1.setVisible(false);
                vis.jLabelDias1.setVisible(false);               
                vis.jLabelSetmanes1.setVisible(false);
                vis.jCheckBoxDijous1.setVisible(false);
                vis.jCheckBoxDimecres1.setVisible(false);
                vis.jCheckBoxDivendres1.setVisible(false);
                vis.jCheckBoxDissabte1.setVisible(false);
                vis.jCheckBoxDiumenge1.setVisible(false);
                vis.jCheckBoxDilluns1.setVisible(false);
                vis.jCheckBoxDimarts1.setVisible(false);
                 
                 
                 
             }
             
             
              if (e.getSource() == this.vis.jRadioButtonAnual){
                 
                vis.jLabelMesos.setVisible(false);
                vis.jLabelAnys.setVisible(true);
                vis.jLabelDias.setVisible(false);                
                vis.jLabelSetmanes.setVisible(false);
                vis.jCheckBoxDijous.setVisible(false);
                vis.jCheckBoxDimecres.setVisible(false);
                vis.jCheckBoxDivendres.setVisible(false);
                vis.jCheckBoxDissabte.setVisible(false);
                vis.jCheckBoxDiumenge.setVisible(false);
                vis.jCheckBoxDilluns.setVisible(false);
                vis.jCheckBoxDimarts.setVisible(false);
                vis.ComboMesNumero.setVisible(true);
                vis.ComboMesDia.setVisible(true);
                vis.jRadioButtonEl.setVisible(true);
                vis.ComboMes.setVisible(true);
                
                
                 
                 
                 
             }
              
                if (e.getSource() == this.vis.jRadioButtonAnual1){
                 
                vis.jLabelMesos1.setVisible(false);
                vis.jLabelAnys1.setVisible(true);
                vis.jLabelDias1.setVisible(false);                
                vis.jLabelSetmanes1.setVisible(false);
                vis.jCheckBoxDijous1.setVisible(false);
                vis.jCheckBoxDimecres1.setVisible(false);
                vis.jCheckBoxDivendres1.setVisible(false);
                vis.jCheckBoxDissabte1.setVisible(false);
                vis.jCheckBoxDiumenge1.setVisible(false);
                vis.jCheckBoxDilluns1.setVisible(false);
                vis.jCheckBoxDimarts1.setVisible(false);
                 
                 
                 
             }
            
        
        if (e.getSource() == vis.jButtonRegistarTasca){
            
            System.out.println("HOlA");
            String prioritat_string = null, estat_string = null;
            mod.setTitol(vis.txt_titolTasc.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignat.getSelectedItem().toString());
            mod.setData(vis.dateTimePicker.getDatePicker().toString());
            mod.setDescripcio(vis.txt_descripcioTasc.getText().trim());
            mod.setHora(vis.dateTimePicker.getTimePicker().toString());
            int estat = vis.ComboEstatTasc.getSelectedIndex() + 1;            
            int prioritat = vis.ComboUsuariAssignat.getSelectedIndex() + 1;
            boolean notificacio = false;

            
            if  (vis.jCheckBoxNotificacio.isSelected()){
            
                notificacio = true;
            }

            
            if (estat == 1) {

                estat_string = "Nova";
            }

            if (estat == 2) {

                estat_string = "En espera";

            }
            if (estat == 3) {

                estat_string = "En procés";

            }
            
            if (prioritat == 1){
            
                prioritat_string = "Baixa";
            }
            if (prioritat == 2){
            
                prioritat_string = "Mitja";
            }
            if (prioritat == 3){
            
                prioritat_string = "Alta";
                
            }if (prioritat == 4){
            
                prioritat_string = "Urgent";
            }
            if (prioritat == 5){
            
                prioritat_string = "Prioritaria";
            }
                        
            mod.setEstat(estat_string);
            mod.setPrioritat(prioritat_string);
            mod.setNotificacio(notificacio);
            
            
            
            switch (modC.NovaTasca(mod)) {     
                 
                       
                case 1:
                    JOptionPane.showMessageDialog(null, "Tasca Creada Correctament!");           
                    natejar();                   
                    vis.DashNovaTasca.setVisible(false);
                    vis.DashTasques.setVisible(true);                    
                    MostrarTaula(vis.jTable_Tasques);                                
                    break;                
                case 2:
                    JOptionPane.showMessageDialog(null,"Error al crear la tasca. Contacti amb l'administrador");
                    break;
                case 3:
                   // JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");                    
                    break;
                default:
                    break;                 
                    
            }
            
                               
                 
            
        }
        
        if (e.getSource() == vis.jButtonEditarTasca) {

            int prioritat, estat;
            String prioritat_string = null, estat_string = null;

            mod.setTitol(vis.txt_titolTasc2.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignat2.getSelectedItem().toString());            
            mod.setData(vis.dateTimePicker1.getDatePicker().toString());            
            mod.setHora(vis.dateTimePicker1.getTimePicker().toString());            
            estat = vis.ComboEstatTasc2.getSelectedIndex() +1;
            prioritat = vis.ComboPrioritatTasc2.getSelectedIndex() + 1;
            
            
            
            
            

            if (estat == 1) {

                estat_string = "Nova";
            }

            if (estat == 2) {

                estat_string = "En espera";

            }
            if (estat == 3) {

                estat_string = "En procés";

            }
            
            if (estat == 4) {

                estat_string = "Finalitzada";

            }
            

            if (prioritat == 1) {

                prioritat_string = "Baixa";
            }
            if (prioritat == 2) {

                prioritat_string = "Mitja";
            }
            if (prioritat == 3) {

                prioritat_string = "Alta";

            }
            if (prioritat == 4) {

                prioritat_string = "Urgent";
            }
             if (prioritat == 5) {

                 prioritat_string = "Prioritaria";
             }

             mod.setEstat(estat_string);
             mod.setPrioritat(prioritat_string);

             if (estat_string == "Finalitzada") {

                 Object[] options = {"Aceptar", "Cancelar"};
                 int n = JOptionPane.showOptionDialog(vis.DashInfoTasca, "Esteu segurs que voleu donada per finalitzada la tasca?", "",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.INFORMATION_MESSAGE,
                         null,
                         options,
                         options[0]);

                 if (n == JOptionPane.YES_OPTION) {

                     modC.FinalitzarTasca(mod);
                     natejar();
                     vis.DashInfoTasca.setVisible(false);
                     vis.DashTasques.setVisible(true);
                     MostrarTaula(vis.jTable_Tasques);

                 }

             } else {

                 switch (modC.EditarTasca(mod)) {

                     case 0:
                         JOptionPane.showMessageDialog(null, "Titol de tasca no disponible");
                         break;
                     case 1:
                         JOptionPane.showMessageDialog(null, "Tasca Modificada!");
                         natejar();
                         vis.DashInfoTasca.setVisible(false);
                         vis.DashTasques.setVisible(true);
                         MostrarTaula(vis.jTable_Tasques);
                         break;
                     case 2:
                         JOptionPane.showMessageDialog(null, "Error al modificar la tasca. Contacti amb l'administrador");
                         break;
                     case 3:
                         JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                         break;
                     default:
                         break;

                 }

             }

         }
       
         if (e.getSource() == vis.jButtonEliminarTasca) {
             
             

             TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
             trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Tasques.getRowSorter();
             DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Tasques.getModel();

            
             int rows = trs.getViewRowCount();
             System.out.print("ROOOWS " + rows);

             for (int i = 0; i< rows; i++) {

                 Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                  System.out.print("Boolean " + checked);
                 //DISPLAY
                 if (checked) {
                     System.out.print("ROW COUNT" + vis.jTable_Tasques.getRowCount());
                     int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 6);
                     mod.setId(id);
                     model_tasques3.removeRow(i);
                     if (modC.EliminarTasca(mod) == false) {

                         JOptionPane.showMessageDialog(null, "Error al eliminar la tasca, contacti amb l'administrador");

                     }
                 }
             }
             System.out.print("ROW COUNT TRS " + trs.getModelRowCount());
             MostrarTaula(vis.jTable_Tasques);

         }

    }
    
    
   
    
    
    public void MostrarTaula(JTable JTable_Tasques){
        
        
        modC.contadorTasques(mod);
        vis.jTextFieldTasquesTotals.setText(String.valueOf(mod.getTasquesTotals()));
        vis.jTextFieldTasquesTotals.setEditable(false);
        vis.jTextFieldTasquesAssignades.setText(String.valueOf(mod.getTasquesAssingades()));
        vis.jTextFieldTasquesAssignades.setEditable(false);
        vis.jTextFieldTasquesPendents.setText(String.valueOf(mod.getTasquesPendents()));
        vis.jTextFieldTasquesPendents.setEditable(false);
    
        
        
         DefaultTableModel model_tasques = new DefaultTableModel();
         
        
         model_tasques.addColumn("Sleccionar");
         model_tasques.addColumn("Titol");
         model_tasques.addColumn("Prioritat");
         model_tasques.addColumn("Usuari assignat");
         model_tasques.addColumn("Data");
         model_tasques.addColumn("Estat");
         model_tasques.addColumn("ID");
         
         Object [] columna = new Object[7];
         
         int numRegistres = modC.MostrarTasques().size();
         System.out.println("Num: " + numRegistres);
        // int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();
         
         for (int i = 0; i < numRegistres; i++){
         
             
             columna[1] = modC.MostrarTasques().get(i).getTitol();
             columna[2] = modC.MostrarTasques().get(i).getPrioritat();
             columna[3] = modC.MostrarTasques().get(i).getUsuariAssignat();
             columna[4] = modC.MostrarTasques().get(i).getData();
             columna[5] = modC.MostrarTasques().get(i).getEstat();
             columna[6] = modC.MostrarTasques().get(i).getId();
             model_tasques.addRow(columna);
             
             
             mod.setId(modC.MostrarTasques().get(i).getId());
             modC.GuardarId(mod);
            
         }
         
            
         
         for (int i = 0; i < numRegistres; i++) {

            model_tasques.setValueAt(false, i, 0);

        }
         
            vis.jTable_Tasques.setModel(model_tasques);            
            modelTasques = model_tasques;
            addCheckBox(0, vis.jTable_Tasques);  
            vis.jTable_Tasques.removeColumn(vis.jTable_Tasques.getColumnModel().getColumn(6));
            
             TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Tasques.getModel()));
            //sorter.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorTasques.getText()));
            vis.jTable_Tasques.setRowSorter(sorter);
            vis.jTable_Tasques.getRowSorter().toggleSortOrder(4);
           
          
             
    
     }    
    
    
    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {

        

          /*  DefaultTableModel model_tasques = new DefaultTableModel();     
            
            
            model_tasques.addColumn("Sleccionar");
            model_tasques.addColumn("Titol");
            model_tasques.addColumn("Prioritat");
            model_tasques.addColumn("Usuari assignat");
            model_tasques.addColumn("Data");
            model_tasques.addColumn("Estat");
            model_tasques.addColumn("ID");
            

            Object[] columna = new Object[7];
            
            System.out.print("Buscador" + vis.txtBuscadorTasques.getText());
            System.out.println("Titol" + mod.getTitol());
            
            int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();

            for (int i = 0; i < numRegistres; i++) {

                columna[1] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getTitol();
                columna[2] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getPrioritat();
                columna[3] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getUsuariAssignat();
                columna[4] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getData();
                columna[5] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getEstat();
                columna[6] = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).get(i).getId();
                model_tasques.addRow(columna);
                System.out.println("Titol" + mod.getTitol());
                mod.setId(modC.MostrarTasques().get(i).getId());
                modC.GuardarId(mod);
            }
            
            for (int i = 0; i < numRegistres; i++) {

            model_tasques.setValueAt(false, i, 0);

            }

            
            vis.jTable_Tasques.setModel(model_tasques);
            
            modelTasques = model_tasques;
             addCheckBox(0, vis.jTable_Tasques);                      
            vis.jTable_Tasques.removeColumn(vis.jTable_Tasques.getColumnModel().getColumn(6));*/
            
             TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Tasques.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorTasques.getText()));
            vis.jTable_Tasques.setRowSorter(sorter);
    

    }
    
    
    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));       

    }
     
     public void natejar() {       
        
        mod.setTitol("");
        mod.setData("");
        mod.setHora("");
        mod.setPrioritat("");
        mod.setEstat("");
        mod.setId(0);
        mod.setDescripcio("");
        mod.setUsuariAssignat("");
        
        vis.txt_titolTasc.setText("");
        //vis.txt_usuariassignatTasc.setText("");        
        vis.dateTimePicker.datePicker.setDateToToday();
        vis.dateTimePicker.timePicker.setTimeToNow();
        vis.txt_descripcioTasc.setText("");
        vis.ComboEstatTasc.setSelectedIndex(0);
       // vis.ComboUsuariAssignat.setSelectedIndex(0);
        vis.jCheckBoxNotificacio.setSelected(false);
        
        vis.txt_descripcioTasc2.setText("");
        //vis.txt_usuariTasc2.setText("");
        vis.txt_titolTasc2.setText("");
       
        vis.ComboEstatTasc2.setSelectedIndex(0);
        vis.ComboPrioritatTasc2.setSelectedIndex(0);
        vis.ComboMesNumero.setSelectedIndex(0);
        vis.ComboMes.setSelectedIndex(0);
        vis.ComboMesDia.setSelectedIndex(0);
        
        
        vis.txt_descripcioTasc1.setText("");
        vis.txt_titolTasc1.setText("");
        vis.ComboEstatTasc1.setSelectedIndex(0);
        vis.ComboPrioritatTasc3.setSelectedIndex(0);
        vis.dateTimePickerRepeticio.datePicker.setDateToToday();
        vis.dateTimePickerRepeticioFinal.timePicker.setTimeToNow();
        vis.jSpinner.setValue(0);
        vis.jCheckBoxNotificacio1.setSelected(false);
        
        
      
      }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == vis.jTable_Tasques) {

            
            
           //TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Tasques.getModel()));
            //sorter.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorTasques.getText()));
           // vis.jTable_Tasques.setRowSorter(sorter);
            
            int fila_point = vis.jTable_Tasques.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Tasques.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Tasques.repaint();
            vis.jTable_Tasques.updateUI();

            if (fila_point > -1 && columna_point > 0) {
                
               // DefaultTableModel model_tasques2 = new DefaultTableModel(((TableRowSorter) vis.jTable_Tasques.getModel()));
               // DefaultTableModel model_tasques2 = new DefaultTableModel();
               // model_tasques2 = (DefaultTableModel) vis.jTable_Tasques.getModel();
                
                
                TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
                trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Tasques.getRowSorter();               
                DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Tasques.getModel();
                
                //System.out.println("SOORTER" + sorter.convertRowIndexToView(fila_point));
                String titol = String.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), columna));
                System.out.println("Titol" + titol);
                //String titol = model_tasques2.getValueAt(fila_point, columna).toString();
                mod.setTitol(titol);
                //int id  = (int) .getValueAt(fila_point,6);
                int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), 6);
                mod.setId(id);
                System.out.println("INT_ID: " + mod.getId());
               // NotificacioTasca(id);
                
                
                switch (modC.informacioTasca(mod)){
                
                    case 0:
                         JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");
                         break;
                     case 1:
                         vis.ComboUsuariAssignat2.removeAll();
                         modC.UsuariAssignat(vis, 1);
                         AutoCompleteDecorator.decorate(ComboUsuariAssignat2);

                         vis.txt_titolTasc2.setText(mod.getTitol());
                         vis.ComboUsuariAssignat2.setSelectedItem(mod.getUsuariAssignat());
                         vis.txt_descripcioTasc2.setText(mod.getDescripcio());

                         String d = mod.getData();
                         String date = d.substring(0, 10);
                         String time = d.substring(11, 16);
                         String data = date.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d);
                         System.out.println("sSubCadena:" + date);
                         System.out.println("sSubCadena:" + data);
                         System.out.println("sSubCadena:" + time);

                         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate = LocalDate.parse(data, formatter);
                         LocalTime localTime = LocalTime.parse(time, formatter2);
                         
                         
                         

                         vis.dateTimePicker1.datePicker.setDate(localDate);
                         vis.dateTimePicker1.timePicker.setTime(localTime);
                         vis.ComboPrioritatTasc2.setSelectedItem(mod.getPrioritat());
                         vis.ComboEstatTasc2.setSelectedItem(mod.getEstat());
                         vis.txt_titolTasc2.setText(mod.getTitol());
                         vis.DashInfoTasca.setVisible(true);
                         vis.DashTasques.setVisible(false);
                         break;
                     case 2:
                         vis.ComboUsuariAssignat3.removeAll();
                         modC.UsuariAssignat1(vis, 1);
                         AutoCompleteDecorator.decorate(ComboUsuariAssignat3);

                         vis.txt_titolTasc3.setText(mod.getTitol());
                         vis.ComboUsuariAssignat3.setSelectedItem(mod.getUsuariAssignat());
                         vis.txt_descripcioTasc3.setText(mod.getDescripcio());

                         String d2 = mod.getData();
                         String date2 = d2.substring(0, 10);
                         String time2 = d2.substring(11, 16);
                         String data2 = date2.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d2);
                         System.out.println("sSubCadena:" + date2);
                         System.out.println("sSubCadena:" + data2);
                         System.out.println("sSubCadena:" + time2);

                         DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate1 = LocalDate.parse(data2, formatter3);
                         LocalTime localTime1 = LocalTime.parse(time2, formatter4);
                         
                         String d3 = mod.getDataFinal();
                         String date3 = d3.substring(0, 10);
                         String time3 = d3.substring(11, 16);
                         String data3 = date3.replace("-", "/");

                         System.out.println("DATAASAAAAAAAA:" + d3);
                         System.out.println("sSubCadena:" + date3);
                         System.out.println("sSubCadena:" + data3);
                         System.out.println("sSubCadena:" + time3);

                         DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("d/MM/yyyy");
                         DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("HH:mm");

                         //convert String to LocalDate
                         LocalDate localDate2 = LocalDate.parse(data3, formatter5);
                         LocalTime localTime2 = LocalTime.parse(time3, formatter6);
                         
                         //If de dies, setmanes, messos, anys
                         vis.jRadioButtonDiari1.setSelected(true);
                         vis.jLabelSetmanes2.setVisible(false);
                         vis.jLabelMesos1.setVisible(false);
                         vis.jLabelAnys1.setVisible(false);
                         
                         
                         if (mod.getDataFinal() != ""){
                         
                             vis.dateTimePickerRepeticioFinal1.setEnabled(true);
                             vis.jRadioButtonDataFinal1.setSelected(true);
                             vis.jSpinnerAcabar1.setEnabled(false);
                             vis.jRadioButtonAcabar1.setSelected(false);
                         
                         }else{
                         
                             vis.dateTimePickerRepeticioFinal1.setEnabled(false);
                             vis.jRadioButtonDataFinal1.setSelected(false);
                             vis.jSpinnerAcabar1.setEnabled(true);
                             vis.jRadioButtonAcabar1.setSelected(true);
                         
                         }
                         
                         
                         vis.dateTimePickerRepeticio1.datePicker.setDate(localDate1);
                         vis.dateTimePickerRepeticio1.timePicker.setTime(localTime1);
                        vis.dateTimePickerRepeticioFinal1.datePicker.setDate(localDate2);
                         vis.dateTimePickerRepeticioFinal1.timePicker.setTime(localTime2);
                         vis.ComboPrioritatTasc4.setSelectedItem(mod.getPrioritat());
                         vis.ComboEstatTasc3.setSelectedItem(mod.getEstat());
                         vis.txt_titolTasc3.setText(mod.getTitol());
                         vis.jSpinner1.setValue(mod.getRepeticio());
                         
                         
                         
                         
                         vis.DashInfoTascaRepeticio.setVisible(true);
                         vis.DashTasques.setVisible(false);
                         
                         break;
                     
                     default:
                         break;
                
                
                
                
                
                } 
                    
                    

             

            }

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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    

    
    
}
