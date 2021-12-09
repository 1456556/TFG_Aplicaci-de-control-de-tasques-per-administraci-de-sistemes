/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.JFPrincipal;
import static Vista.JFPrincipal.tasca_update;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Victor
 */
public class ConsultesTasques extends Conexio {
    
    String tasques;
    public static String tasca_update = "";
    
       
    
    
    
    public ArrayList<Tasques> MostrarGrups(Tasques tas){
        
        ArrayList llistaTasques = new ArrayList();
        int id_grup = 0;
        
        try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select id_grup from Grups where nom = '"+tas.getGrupAfectat()+"'");
                ResultSet rs = pst.executeQuery();
             
                
             if (rs.next()) {
                    
                   id_grup = rs.getInt(1);
                    
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
            System.err.println(e + "Error al buscar el id del grup per mostrar la taula a infotasques");
        
        }
        
       
         try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select nomUsuari, id_usuari from GrupsUsuaris where id_grup = '"+id_grup+"'");
                ResultSet rs = pst.executeQuery();
             
                
             while (rs.next()) {
                    
                    tas = new Tasques();
                    tas.setNom(rs.getString(1));
                    tas.setIdGrup(rs.getInt(2));           
                    llistaTasques.add(tas);
                    
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
              System.err.println(e + "Error al mostrar la taula de grups a infotasques");
        
        }
        
        return llistaTasques;
    
    
    }
        
        
        
        
    
   
    
    
    public ArrayList<Tasques> MostrarTasques(){
    
        ArrayList llistaTasques = new ArrayList();
        Tasques tas;
        
        try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select titol, prioritat, usuari, data, estat, id_tasca from Tasques");
                ResultSet rs = pst.executeQuery();
             
                
             while (rs.next()) {
                    
                    tas = new Tasques();
                    tas.setTitol(rs.getString(1));
                    tas.setPrioritat(rs.getString(2));
                    tas.setUsuariAssignat(rs.getString(3));
                    tas.setData(rs.getString(4));
                    tas.setEstat(rs.getString(5));
                    tas.setId(rs.getInt(6));
                    llistaTasques.add(tas);
                    
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
        
        
        }
        
        return llistaTasques;
    
    
    }
    
    
        
    public ArrayList<Tasques> BuscarTasques(String buscarTasc){  

        
              ArrayList llistaTasques = new ArrayList();
              Tasques tas;   

        try {

                                 
                Connection cn = getConexio();
                PreparedStatement pst = cn.prepareStatement("select * from Tasques where titol like '%" + buscarTasc + "%' or prioritat like '%" + buscarTasc + "%'"
                        + "or usuari like '%" + buscarTasc + "%' or data like '%" + buscarTasc + "%' or estat like '%" + buscarTasc + "%'");
                ResultSet rs = pst.executeQuery();               
                
                
                
                while (rs.next()) {
                    
                    tas = new Tasques();
                    tas.setTitol(rs.getString(2));
                    tas.setPrioritat(rs.getString(3));
                    tas.setUsuariAssignat(rs.getString(4));
                    tas.setData(rs.getString(5));
                    tas.setEstat(rs.getString(6));
                    tas.setId(rs.getInt(1));
                    llistaTasques.add(tas);
                    
                }
                
                cn.close();
                
            
            
             

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
        
        return llistaTasques;
    }
    
    
    public void GrupAfectat(JFPrincipal vis, int i) {

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Grups");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                if (i == 1){
                //vis.ComboGrupAfectat.addItem("---");
                vis.ComboGrupAfectat.addItem(rs.getString("nom"));
               
                }else{
                
                vis.ComboGrupAfectat1.addItem(rs.getString("nom"));
                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al carregar el grupAfectat");
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

    }
    
    
    
    public void UsuariAssignat(JFPrincipal vis, int i) {

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                
                if (i == 1){

                vis.ComboUsuariAssignat2.addItem(rs.getString("usuari"));
                }else{
                
                vis.ComboUsuariAssignat.addItem(rs.getString("usuari"));
                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al carregar el usuariAssignat");
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

    }
    
    public void UsuariAssignat1(JFPrincipal vis, int i) {

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                
                if (i == 1){

                vis.ComboUsuariAssignat3.addItem(rs.getString("usuari"));
                }
                if (i == 0){
                
                vis.ComboUsuariAssignat1.addItem(rs.getString("usuari"));
                }
                if (i == 2){
                
                vis.jComboBoxDashTasquesUsuari.addItem(rs.getString("usuari"));
                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al carregar el usuariAssignat");
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

    }
    
    
    
    public void GuardarIdSubtasca(Tasques tas) {

        int id = 0;

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("SELECT MAX(id_tasca) AS id_tasca FROM Tasques");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                id = rs.getInt("id_tasca");

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al carregar el usuariAssignat");
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        try {

            Connection cn2 = getConexio();
            PreparedStatement pst2 = cn2.prepareStatement("update Tasques set idSubtasca=? where id_tasca = '" + id + "'");

            pst2.setInt(1, id);
            pst2.executeUpdate();
            cn2.close();

        } catch (SQLException e) {

            System.err.println("Error al crear el idseubtasca" + e);

        }

    }

    
    public int EditarTascaRepeticio(Tasques tas){
    
        int novaTasca = 0;
        int validacio = 0;
        int repeticio = 0;
        String dataInici, horaInici, dataFinal, horaFinal, data, dataF, tipus, diesSetmana = "";

        dataInici = tas.getData();
        horaInici = tas.getHora();
        dataFinal = tas.getDataFinal();
        horaFinal = tas.getHoraFinal();
        repeticio = tas.getRepeticio();
        tipus = tas.getTipus();
        diesSetmana = tas.getDiesSetmana();
        
        
       
        String titol,descripcio, usuari, estat, prioritat;
        boolean notificacio;
        
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        System.out.print("ESTAT: " + estat);
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();       
        notificacio = tas.getNotificacio();
        
        
        
        if (titol.equals("")) {
            
            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }        
       
        if (descripcio.equals("")) {
            
            validacio++;
        }

        if (dataInici.equals("")) {

            validacio++;

        }
        if (horaInici.equals("")) {

            validacio++;

        }
        if (dataFinal.equals("")) {

            validacio++;

        }
        if (horaFinal.equals("")) {

            validacio++;

        }

        if (validacio == 0) {

            if (repeticio > 0) {              
               
                 LocalDate localDateInici = String2LocalDate(dataInici, horaInici);
                 LocalDate localDateFinal = String2LocalDate(dataFinal, horaFinal);
                 int result = localDateInici.compareTo(localDateFinal);

                if (result < 0) {

                    
                    try {

                        Connection cn2 = clases.Conexio.conectar();
                        PreparedStatement pst2 = cn2.prepareStatement("Select idSubtasca from Tasques where id_tasca = '" + tas.getId() + "'");
                        ResultSet rs = pst2.executeQuery();

                        if (rs.next()) {

                            //recurrent = rs.getBoolean(1);
                            tas.setIdSubtasca(rs.getInt(1));
                           // System.out.println(recurrent);
                            System.out.println("Id subtasca" + tas.getIdSubtasca());

                        }
                        cn2.close();
                        Connection cn3 = clases.Conexio.conectar();
                        PreparedStatement pst3 = cn3.prepareStatement("DELETE from Tasques WHERE idSubtasca ='" + tas.getIdSubtasca() + "' AND id_tasca >  '"+tas.getId()+"'");
                        pst3.executeUpdate();
                        
                    } catch (SQLException e) {

                        System.err.println("Error al eeliminar tasca al editar la tascarecurrent" + e);
                       // return false;
                    }
                    
                    
                    
                    
                    
                    try {

                        String day1 = dataInici.substring(8, 10);
                        String month1 = dataInici.substring(5, 7);
                        String year1 = dataInici.substring(0, 4);

                        System.out.println("DAY" + day1 + "MONTH" + month1 + "YEAR" + year1);
                        dataInici = day1 + "-" + month1 + "-" + year1;
                        data = dataInici + " " + horaInici;

                        String dayFinal1 = dataFinal.substring(8, 10);
                        String monthFinal1 = dataFinal.substring(5, 7);
                        String yearFinal1 = dataFinal.substring(0, 4);

                        System.out.println("DAY" + dayFinal1 + "MONTH" + monthFinal1 + "YEAR" + yearFinal1);
                        dataFinal = dayFinal1 + "-" + monthFinal1 + "-" + yearFinal1;
                        dataF = dataFinal + " " + horaFinal;
                        
                       
                        Connection cn2 = getConexio();
                        PreparedStatement pst2 = cn2.prepareStatement("Update Tasques set titol=?, prioritat=?, usuari=?, data=?, estat=?, descripcio=?, setNotificacio=?, repeticioInici=?, dataFinal=?, recurrent=?, tipus=?, diesSetmana=? where id_tasca = '" + tas.getId() + "'");

                        pst2.setString(1, titol);
                        pst2.setString(2, prioritat);
                        pst2.setString(3, usuari);
                        pst2.setString(4, data);
                        pst2.setString(5, estat);
                        pst2.setString(6, descripcio);
                        pst2.setBoolean(7, notificacio);
                        pst2.setInt(8, repeticio);
                        pst2.setString(9, dataF);
                        pst2.setBoolean(10, true);
                        pst2.setString(11, tipus);
                        pst2.setString(12, diesSetmana);
                        pst2.executeUpdate();

                        cn2.close();

                        System.err.println("Tasca Repeticio Editada correctament");
                        novaTasca = 1;

                    } catch (SQLException e) {
                        novaTasca = 2;
                        System.err.println("Error al crear la tasca" + e);

                    }

                } else {

                    novaTasca = 3;
                    System.err.println("La data d'inici ha de ser mes petita a la data final");

                }

            } else {

                novaTasca = 4;
                System.err.println("Els dies no poden ser iguals o menors a 0");

            }

        } else {

            novaTasca = 5;
            System.err.println("Has d'omplir tots els camps");

        }

       return novaTasca;
    }
    
    public int NovaTascaRepeticio(Tasques tas){
    
        int novaTasca = 0;
        int validacio = 0;
        int repeticio = 0;
        String dataInici, horaInici, dataFinal, horaFinal, data, dataF, tipus, diesSetmana = "";

        dataInici = tas.getData();
        horaInici = tas.getHora();
        dataFinal = tas.getDataFinal();
        horaFinal = tas.getHoraFinal();
        repeticio = tas.getRepeticio();
        tipus = tas.getTipus();
        diesSetmana = tas.getDiesSetmana();
        
        
       
        String titol,descripcio, usuari, estat, prioritat;
        boolean notificacio;
        
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        System.out.print("ESTAT: " + estat);
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();       
        notificacio = tas.getNotificacio();
        
        
        
        if (titol.equals("")) {
            
            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }        
       
        if (descripcio.equals("")) {
            
            validacio++;
        }

        if (dataInici.equals("")) {

            validacio++;

        }
        if (horaInici.equals("")) {

            validacio++;

        }
        if (dataFinal.equals("")) {

            validacio++;

        }
        if (horaFinal.equals("")) {

            validacio++;

        }

        if (validacio == 0) {

            if (repeticio > 0) {              
               
                 LocalDate localDateInici = String2LocalDate(dataInici, horaInici);
                 LocalDate localDateFinal = String2LocalDate(dataFinal, horaFinal);
                 int result = localDateInici.compareTo(localDateFinal);

                if (result < 0) {

                    try {

                        String day1 = dataInici.substring(8, 10);
                        String month1 = dataInici.substring(5, 7);
                        String year1 = dataInici.substring(0, 4);

                        System.out.println("DAY" + day1 + "MONTH" + month1 + "YEAR" + year1);
                        dataInici = day1 + "-" + month1 + "-" + year1;
                        data = dataInici + " " + horaInici;

                        String dayFinal1 = dataFinal.substring(8, 10);
                        String monthFinal1 = dataFinal.substring(5, 7);
                        String yearFinal1 = dataFinal.substring(0, 4);

                        System.out.println("DAY" + dayFinal1 + "MONTH" + monthFinal1 + "YEAR" + yearFinal1);
                        dataFinal = dayFinal1 + "-" + monthFinal1 + "-" + yearFinal1;
                        dataF = dataFinal + " " + horaFinal;

                        Connection cn2 = getConexio();
                        PreparedStatement pst2 = cn2.prepareStatement("insert into Tasques (titol, prioritat, usuari, data, estat, descripcio, setNotificacio, repeticioInici, dataFinal, recurrent, tipus, diesSetmana) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                                
                        
                        pst2.setString(1, titol);
                        pst2.setString(2, prioritat);
                        pst2.setString(3, usuari);
                        pst2.setString(4, data);
                        pst2.setString(5, estat);
                        pst2.setString(6, descripcio);                       
                        pst2.setBoolean(7, notificacio);
                        pst2.setInt(8, repeticio);
                        pst2.setString(9, dataF);
                        pst2.setBoolean(10, true);
                        pst2.setString(11, tipus);
                        pst2.setString(12, diesSetmana);
                        pst2.executeUpdate();

                        cn2.close();

                        System.err.println("Tasca Repeticio creada correctament");
                        novaTasca = 1;

                    } catch (SQLException e) {
                        novaTasca = 2;
                        System.err.println("Error al crear la tasca" + e);

                    }

                } else {

                    novaTasca = 3;
                    System.err.println("La data d'inici ha de ser mes petita a la data final");

                }

            } else {

                novaTasca = 4;
                System.err.println("Els dies no poden ser iguals o menors a 0");

            }

        } else {

            novaTasca = 5;
            System.err.println("Has d'omplir tots els camps");

        }

       return novaTasca;
    }
    
    
    
     public LocalDate String2LocalDate(String d, String h){
    
         String day = d.substring(8, 10);
         String month = d.substring(5, 7);
         String year = d.substring(0, 4);

         System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
         String date = day + "-" + month + "-" + year;
         String data = date + " " + h;

         String date2 = data.substring(0, 10);
         String time2 = data.substring(11, 16);
         String data2 = date2.replace("-", "/");

         System.out.println("sSubCadena:" + date2);
         System.out.println("sSubCadena:" + data2);
         System.out.println("sSubCadena:" + time2);

         DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("d/MM/yyyy");
         DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("HH:mm");

         //convert String to LocalDate
         LocalDate localDate1 = LocalDate.parse(data2, formatter3);
         LocalTime localTime1 = LocalTime.parse(time2, formatter4);       
       
            
        return localDate1;       
    
     }
     
     
     public LocalTime String2LocalTime(String d, String h){
    
         String day = d.substring(8, 10);
         String month = d.substring(5, 7);
         String year = d.substring(0, 4);

         System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
         d = day + "-" + month + "-" + year;
         String data = d + " " + h;
         
         DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

         //convert String to LocalTime         
         LocalTime localTime = LocalTime.parse(data, formatter2);

               
        return localTime;
    
     }
    
    
    
    public int NovaTasca(Tasques tas) {
        
        int novaTasca, validacio=0;
        String titol,descripcio, data, usuari, estat, prioritat,date, time, grup;
        boolean notificacio;
        
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        System.out.print("ESTAT: " + estat);
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();
        date = tas.getData();
        time = tas.getHora();
        notificacio = tas.getNotificacio();
        grup = tas.getGrupAfectat();
        
        
         if (titol.equals("")) {
            
            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }        
        if (date.equals("")) {
            
            validacio++;
        }
        if (time.equals("")) {
            
            validacio++;
        }
        if (descripcio.equals("")) {
            
            validacio++;
        }
        
        
        if (validacio == 0) {
        
            try {

                String day = date.substring(8, 10);
                String month = date.substring(5, 7);
                String year = date.substring(0, 4);

                System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                date = day + "-" + month + "-" + year;
                data = date + " " + time;

                Connection cn2 = getConexio();
                PreparedStatement pst2 = cn2.prepareStatement("insert into Tasques (titol, prioritat, usuari, data, estat, descripcio, notificacio,  setNotificacio, grup) values (?,?,?,?,?,?,?,?,?)");
                
                pst2.setString(1, titol);
                pst2.setString(2, prioritat);
                pst2.setString(3, usuari);
                pst2.setString(4, data);
                pst2.setString(5, estat);
                pst2.setString(6, descripcio);
                pst2.setInt(7, 0);
                pst2.setBoolean(8, notificacio);
                pst2.setString(9, grup);
                pst2.executeUpdate();
                                                
                cn2.close();

                System.err.println("Tasca creada correctament");
                novaTasca = 1;

            } catch (SQLException e) {
                novaTasca = 2;
                System.err.println("Error al crear la tasca" + e);

            }

            

        } else {
            novaTasca = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return novaTasca;

    }
    

    public void contadorTasques(Tasques tas) {

        

        try {

            Connection cn2 = clases.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("SELECT count(id_tasca) FROM Tasques");
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {

                tas.setTasquesTotals(rs.getInt(1));

            }

           cn2.close();

        } catch (SQLException e) {
            
            System.err.println("Error al contar les tasques totals" + e);

        }
        
        try {

            Connection cn2 = clases.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("SELECT count(id_tasca) FROM Tasques WHERE usuari = '" + Login.usuari  +  "'");
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {

                tas.setTasquesAssingades(rs.getInt(1));

            }

           cn2.close();

        } catch (SQLException e) {
            
            System.err.println("Error al contar les tasques assignades" + e);

        }
        
        try {
            String proces = "En procés", espera = "En espera";
            Connection cn2 = clases.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("SELECT count(id_tasca) FROM Tasques WHERE usuari = '" + Login.usuari  + "' AND estat = '" + proces + "' OR estat = '" + espera  + "'");
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {

                tas.setTasquesPendents(rs.getInt(1));

            }

           cn2.close();

        } catch (SQLException e) {
            
            System.err.println("Error al contar les tasques pendents" + e);

        }
        

    }
    
    
    
    public void FinalitzarTasca(Tasques tas) {

        int editarTasca, id, validacio = 0;
        String titol, descripcio, data, usuari, estat, prioritat, date, time;
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();
        date = tas.getData();
        time = tas.getHora();
        id = tas.getId();
        System.out.println("IDTASCA " + id);

        if (titol.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (date.equals("")) {

            validacio++;
        }
        if (time.equals("")) {

            validacio++;
        }
        if (descripcio.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                Connection cn2 = clases.Conexio.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("update Tasques set titol=?, prioritat=?, usuari=?, data=?, estat=?, descripcio=? where id_tasca = '" + tas.getId() + "'");

                String day = date.substring(8, 10);
                String month = date.substring(5, 7);
                String year = date.substring(0, 4);

                System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                date = day + "-" + month + "-" + year;
                data = date + " " + time;

                pst2.setString(1, titol);
                pst2.setString(2, prioritat);
                pst2.setString(3, usuari);
                pst2.setString(4, data);
                pst2.setString(5, estat);
                pst2.setString(6, descripcio);
                pst2.executeUpdate();

                cn2.close();
                System.err.println("Tasca modificada");

            } catch (SQLException e) {

                System.err.println("Error al modificar la tasca" + e);

            }

        } else {

            System.err.println("Has d'omplir tots els camps");

        }

    }
    
    
    public int EditarTasca(Tasques tas) {

        int editarTasca,id, validacio = 0;
        String titol, descripcio, data, usuari, estat, prioritat, date, time;
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();
        date = tas.getData();
        time = tas.getHora();
        id = tas.getId();
        System.out.println("IDTASCA " + id);
        

        if (titol.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (date.equals("")) {

            validacio++;
        }
        if (time.equals("")) {

            validacio++;
        }
        if (descripcio.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                
                    Connection cn2 = clases.Conexio.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update Tasques set titol=?, prioritat=?, usuari=?, data=?, estat=?, descripcio=? where id_tasca = '" + tas.getId()  + "'");

                    String day = date.substring(8, 10);
                    String month = date.substring(5, 7);
                    String year = date.substring(0, 4);

                    System.out.println("DAY" + day + "MONTH" + month + "YEAR" + year);
                    date = day + "-" + month + "-" + year;
                    data = date + " " + time;

                    pst2.setString(1, titol);
                    pst2.setString(2, prioritat);
                    pst2.setString(3, usuari);
                    pst2.setString(4, data);
                    pst2.setString(5, estat);
                    pst2.setString(6, descripcio);
                    pst2.executeUpdate();
                    editarTasca = 1;
                    cn2.close();
                    System.err.println("Tasca modificada");

                

            } catch (SQLException e) {
                editarTasca = 2;
                System.err.println("Error al modificar la tasca" + e);

            }

        } else {

            editarTasca = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return editarTasca;
    }

    
    
    public void GuardarId(Tasques tas){
    
        String tasca = tas.getTitol();
        System.out.print("TITOL" + tasca);
        System.out.println("ID" + tas.getId());
        
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_tasca from Tasques where id_tasca = '" + tas.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                tas.setId(rs.getInt(1));

            }

            System.out.println("ID" + tas.getId());
            cn.close();

        } catch (SQLException e) {

           System.err.println("Error al crear el id de la tasca" + e);

        }
    }

     public int Notificacio(Tasques tas){
        
        int notificacio=0;
        String d = tas.getData();
    
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_tasca, notificacio, titol, data from Tasques where data = '" + d + "'");
            ResultSet rs = pst.executeQuery();
            
            
            if (rs.next()) {
               
                if(rs.getInt("notificacio")==0){
                
                    tas.id = rs.getInt("id_tasca");
                    tas.data = rs.getString("data");
                    tas.titol = rs.getString("titol");  
                    notificacio = 1;
                    /*id_tasca = rs.getInt("id_tasca");
                    String titol = rs.getString("titol");
                    String data = rs.getString("data");
                    recordatori(titol, date);*/
                
                
                }      
              
               
            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }    
    
        return notificacio;
    
    
    
    
    }
    
    
    public void ActualitzaNotificacio(Tasques tas){
    
    
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("update Tasques set notificacio=? where id_tasca = '" + tas.getId() + "'");
            pst.setInt(1, 1);
            pst.executeUpdate();
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al modificar la notificacio" + e);

        }

    }
    
    
    public void GenerarTascaRecurrent(Tasques tas){
    
        
        
        int repeticio, idSubtasca;      
        String titol,descripcio, usuari, estat, prioritat, data, dataFinal, dataProgres, tipus, diaSetmana;
        boolean notificacio;
        
        tipus = tas.getTipus();
        dataProgres = tas.getDataProgres();
        repeticio = tas.getRepeticio(); 
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        System.out.print("ESTAT: " + estat);
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();       
        idSubtasca = tas.getIdSubtasca();
        data = tas.getData();
        dataFinal = tas.getDataFinal();
        diaSetmana = tas.getDiesSetmana();
        
        
        
       
            
        
            try {
                Connection cn = getConexio();
               
                PreparedStatement pst = cn.prepareStatement("insert into Tasques (titol, prioritat, usuari, dataProgres, estat, descripcio, setNotificacio, repeticioInici, recurrent, tipus, data, dataFinal, diesSetmana, idSubtasca) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
               
              
                
                
                pst.setString(1, titol);
                pst.setString(2, prioritat);
                pst.setString(3, usuari);
                pst.setString(4, dataProgres);
                pst.setString(5, estat);
                pst.setString(6, descripcio);
                pst.setBoolean(7, true);
                pst.setInt(8, repeticio);              
                pst.setBoolean(9, true);
                pst.setString(10, tipus);
                pst.setString(11, data);
                pst.setString(12, dataFinal);
                pst.setString(13, diaSetmana);
                pst.setInt(14, idSubtasca);
                



                
                pst.executeUpdate();
               
                
                cn.close();

            } catch (SQLException e) {

                System.err.println("Error al modificar la notificacio" + e);

            }      
        
        
        
    
    }
    
    
    public int informacioTasca(Tasques tas) {

        
         System.out.println("ID" + tas.getId());  
        int informacioTasca = 0;
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Tasques where id_tasca = '" + tas.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {              
               
                tas.setTitol(rs.getString(2));
                tas.setPrioritat(rs.getString(3));
                tas.setUsuariAssignat(rs.getString(4));
                tas.setData(rs.getString(5));
                tas.setEstat(rs.getString(6));
                tas.setDescripcio(rs.getString(7));
                tas.setRecurrent(rs.getBoolean(13));
                tas.setRepeticio(rs.getInt(10));
                tas.setDataFinal(rs.getString(12));
                tas.setTipus(rs.getString(14));
                tas.setDataProgres(rs.getString(15));
                tas.setDiesSetmana(rs.getString(16));
                tas.setIdSubtasca(rs.getInt(17));
                tas.setGrupAfectat(rs.getString(18));
               
                            

            }
            if (tas.isRecurrent() == true){
            
                informacioTasca = 2;
            
            }else{
                
                informacioTasca = 1;   
            
            }

             System.out.println("ID" + tas.getId());
             
            System.out.println("TITOL" +tas.getTitol());
            
             System.out.println("Usuari" +tas.getUsuariAssignat());
             
              System.out.println("Data" +tas.getData());
              
               System.out.print("Descripcio" +tas.getDescripcio());
               
                System.out.print("Estat" +tas.getEstat());
                
                 System.out.print("Prioritat" +tas.getPrioritat());
                 
                 
               System.out.print("Repeticio" +tas.getRepeticio());
               
               
             cn.close();

        } catch (SQLException e) {
            
            informacioTasca = 2;
            System.err.println("Error al solicitar les dades" + e);
            

        }
        
        return informacioTasca;
    }
    
    
    
    
    
    
    
    public boolean EliminarTasca(Tasques tas) {

        System.out.println(tas.getId());
        Boolean recurrent = false;

        try {

            Connection cn2 = clases.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("Select recurrent,idSubtasca from Tasques where id_tasca = '" + tas.getId() + "'");
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {

                recurrent = rs.getBoolean(1);
                tas.setIdSubtasca(rs.getInt(2));
                System.out.println(recurrent);
                System.out.println("Id subtasca" + tas.getIdSubtasca());

            }

           
        } catch (SQLException e) {

            System.err.println("Error al eeliminar tasca" + e);
            return false;
        }

        try {

            Connection cn2 = clases.Conexio.conectar();
            int j;

            if (!recurrent) {
                PreparedStatement pst3 = cn2.prepareStatement("delete from Tasques where id_tasca='" + tas.getId() + "'");
                j = pst3.executeUpdate();
                recurrent = true;
            } else {
                String[] botones = {"Aceptar", "Cancelar"};
                int ventana = JOptionPane.showOptionDialog(null, "Si eleimines aquesta tasca recurrent, eliminaras totes les programades", "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        botones, botones[0]);
                if (ventana == 0) {
                    System.out.println(tas.getIdSubtasca());
                    PreparedStatement pst = cn2.prepareStatement("DELETE from Tasques WHERE idSubtasca ='" + tas.getIdSubtasca() + "'");
                    j = pst.executeUpdate();
                    if (j != 0) {

                        recurrent = true;

                    } else {

                        recurrent = false;
                    }
                }
            }

           

        } catch (SQLException e) {

            System.err.println("Error al eliminar tasca recurrent" + e);
            return false;
        }

        
        return recurrent;
    }
        

    
    
}
