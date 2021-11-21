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
    
    public int NovaTasca(Tasques tas) {
        
        int novaTasca, validacio=0;
        String titol,descripcio, data, usuari, estat, prioritat,date, time;
        titol = tas.getTitol();
        descripcio = tas.getDescripcio();
        estat = tas.getEstat();
        prioritat = tas.getPrioritat();
        usuari = tas.getUsuariAssignat();
        date = tas.getData();
        time = tas.getHora();
        
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
                PreparedStatement pst2 = cn2.prepareStatement("insert into Tasques values (?,?,?,?,?,?,?,?)");
                pst2.setInt(1, 0);
                pst2.setString(2, titol);
                pst2.setString(3, prioritat);
                pst2.setString(4, usuari);
                pst2.setString(5, data);
                pst2.setString(6, estat);
                pst2.setString(7, descripcio);
                pst2.setInt(8, 0);
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
                informacioTasca = 1;               

            }

             System.out.println("ID" + tas.getId());
             
            System.out.println("TITOL" +tas.getTitol());
            
             System.out.println("Usuari" +tas.getUsuariAssignat());
             
              System.out.println("Data" +tas.getData());
              
               System.out.print("Descripcio" +tas.getDescripcio());
               
                System.out.print("Estat" +tas.getEstat());
                
                 System.out.print("Prioritat" +tas.getPrioritat());
             cn.close();

        } catch (SQLException e) {
            
            informacioTasca = 2;
            System.err.println("Error al solicitar les dades" + e);
            

        }
        
        return informacioTasca;
    }
    
    
    
    
    
    
    
    public boolean EliminarTasca(Tasques tas) {

        System.out.println(tas.getId());
        
        try {    

            Connection cn2 = clases.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Tasques where id_tasca='" + tas.getId() + "'");            
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar tasca" + e);            
            return false;
        }

    }
    
}
