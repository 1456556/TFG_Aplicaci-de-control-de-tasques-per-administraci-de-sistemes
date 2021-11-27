/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class ConsultesGrups extends Conexio {

    
    
    
    
    public ArrayList<Grups> MostrarGrups(){
    
        ArrayList llistaGrups = new ArrayList();
        Grups gru;
        
        try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select nom, id_grup from Grups");
                ResultSet rs = pst.executeQuery();
             
                
             while (rs.next()) {
                    
                    gru = new Grups();
                    gru.setNom(rs.getString(1));                                   
                    gru.setId(rs.getInt(2));
                    llistaGrups.add(gru);                   
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
        
        
        }
        
        return llistaGrups;
    
    
    }
    
    
    
    public ArrayList<Grups> MostrarGrupsUsuaris(){
    
        ArrayList llistaGrups = new ArrayList();
        Grups gru;
        
        try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select nom, cognom, usuari, id_usuari from Usuaris");
                ResultSet rs = pst.executeQuery();
             
                
             while (rs.next()) {
                    
                    gru = new Grups();
                    gru.setNomUsuari(rs.getString(1));
                    gru.setCognom(rs.getString(2));
                    gru.setUsuari(rs.getString(3));                    
                    gru.setIdUsuari(rs.getInt(4));
                    llistaGrups.add(gru);                   
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
        
        
        }
        
        return llistaGrups;
   
    
    
    }
    
    public ArrayList<Grups> MostrarGrupsElements(){
    
        ArrayList llistaGrupsElements = new ArrayList();
        Grups gru;
        
        try{
        
            Connection cn = getConexio();
             PreparedStatement pst = cn.prepareStatement("select nom, usuari, tipus, id_element from Elements");
                ResultSet rs = pst.executeQuery();
             
                
             while (rs.next()) {
                    
                    gru = new Grups();
                    gru.setNomElement(rs.getString(1));
                    gru.setUsuariElement(rs.getString(2));
                    gru.setTipusElement(rs.getString(3));                    
                    gru.setIdElement(rs.getInt(4));
                    llistaGrupsElements.add(gru);                   
                    
                }
                 
        
        cn.close();
        
        }catch(SQLException e){
        
        
        
        }
        
        return llistaGrupsElements;
    
    
    }
    
    public void GuardarIdUsuari(Grups gru){
    
        String nom = gru.getNomUsuari();
        System.out.print("TITOL" + nom);
        System.out.println("ID" + gru.getIdUsuari());
        
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_usuari from Usuaris where id_usuari = '" + gru.getIdUsuari() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                gru.setIdUsuari(rs.getInt(1));

            }

            System.out.println("ID" + gru.getIdUsuari());
            cn.close();

        } catch (SQLException e) {

           System.err.println("Error al crear el id de l'usuari" + e);

        }
    }
    
    
    
    
     public void GuardarId(Grups gru){
    
        String nom = gru.getNomUsuari();
        System.out.print("TITOL" + nom);
        System.out.println("ID" + gru.getIdUsuari());
        
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_grup from Grups where id_grup = '" + gru.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                gru.setId(rs.getInt(1));

            }

            System.out.println("ID" + gru.getId());
            cn.close();

        } catch (SQLException e) {

           System.err.println("Error al crear el id del grup" + e);

        }
    }
     
     public void GuardarIdElement(Grups gru){
    
        String nom = gru.getNomElement();
        System.out.print("TITOL" + nom);
        System.out.println("ID" + gru.getIdElement());
        
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_grup from Grups where id_grup = '" + gru.getIdElement() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                gru.setIdElement(rs.getInt(1));

            }

            System.out.println("ID" + gru.getIdElement());
            cn.close();

        } catch (SQLException e) {

           System.err.println("Error al crear el id del grup" + e);

        }
    }
    
    
    
    
    public int NouGrup(Grups gru){
        
        int nouGrup = 0;
    
        try {
            Connection cn3 = getConexio();
            PreparedStatement pst3 = cn3.prepareStatement("select id_grup from Grups where nom = '" + gru.getNom() + "'");
            ResultSet rs = pst3.executeQuery();

            if (rs.next()) {

                gru.setId(rs.getInt(1));

            }
            cn3.close();
            System.out.println("ID GRUP" + gru.getId());
            Connection cn4 = getConexio();
            PreparedStatement pst4 = cn4.prepareStatement("update GrupsUsuaris set id_grup=? where nomGrup = '" + gru.getNom()  + "'");
            
                pst4.setInt(1, gru.getId());

            pst4.executeUpdate();
            cn4.close();            
            System.err.println("Grup d'usuaris creat correctament");
            nouGrup = 1;

        } catch (SQLException e) {
            nouGrup = 2;
            System.err.println("Error al crear el grup d'usuaris" + e);

        }

        return nouGrup;

    }
    
    
  
    public int NouUserGrup(Grups gru) {
        
        int nouGrup=0, validacio=0;
        String nom;
        nom = gru.getNom();
        
        
         if (nom.equals("")) {
            
            validacio++;
        }
      
        
        
        if (validacio == 0) {
            
            
        
            try {
                
                for (int i = 0; i < gru.getGrupUsuaris().length; i++) {
                    String[] array = gru.getGrupUsuaris();
                    int[] arrayID = gru.getIdUsuaris();
                    System.out.println(gru.getGrupUsuaris().length);
                    System.out.println("NOM:" + array[i]);
                    System.out.println("ID:" + arrayID[i]);

                    Connection cn = getConexio();
                    PreparedStatement pst = cn.prepareStatement("insert into GrupsUsuaris values (?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setInt(2, arrayID[i]);
                    pst.setString(3, nom);
                    pst.setString(4, array[i]);

                    pst.executeUpdate();
                    cn.close();

                }

                System.err.println("Element creat correctament");
                

                Connection cn1 = getConexio();
                PreparedStatement pst1 = cn1.prepareStatement("insert into Grups values (?,?)");
                pst1.setInt(1, 0);
                pst1.setString(2, gru.getNom());
                pst1.executeUpdate();
                cn1.close();

                System.err.println("Element creat correctament");
                

               
               
                nouGrup = 1;
                  

            } catch (SQLException e) {
                nouGrup = 2;
                System.err.println("Error al crear el grup d'usuaris" + e);

            }
            
            

            

        } else {
            nouGrup = 3;
            System.err.println("Has d'omplir tots els camps");

        }
        
        

        return nouGrup;

    }
    
    
    public int NouElementGrup(Grups gru) {
        
        int nouGrup=0, validacio=0;
        String nom;
        nom = gru.getNom();
        
        
         if (nom.equals("")) {
            
            validacio++;
        }
      
        
        
        if (validacio == 0) {
            
            
        
            try {
                
                for (int i = 0; i < gru.getGrupElements().length; i++) {
                    String[] array = gru.getGrupElements();
                    int[] arrayID = gru.getIdElements();
                    System.out.println(gru.getGrupElements().length);
                    System.out.println("NOM:" + array[i]);
                    System.out.println("ID:" + arrayID[i]);

                    Connection cn = getConexio();
                    PreparedStatement pst = cn.prepareStatement("insert into GrupsElements values (?,?,?,?)");

                    pst.setInt(1, 0);
                    pst.setInt(2, arrayID[i]);
                    pst.setString(3, nom);
                    pst.setString(4, array[i]);

                    pst.executeUpdate();
                    cn.close();

                }

                System.err.println("Element creat correctament");
                

                Connection cn1 = getConexio();
                PreparedStatement pst1 = cn1.prepareStatement("insert into Grups values (?,?)");
                pst1.setInt(1, 0);
                pst1.setString(2, gru.getNom());
                pst1.executeUpdate();
                cn1.close();

                System.err.println("Element creat correctament");
                

               
               
                nouGrup = 1;
                  

            } catch (SQLException e) {
                nouGrup = 2;
                System.err.println("Error al crear el grup d'usuaris" + e);

            }
            
            

            

        } else {
            nouGrup = 3;
            System.err.println("Has d'omplir tots els camps");

        }
        
        

        return nouGrup;

    }
}
    

