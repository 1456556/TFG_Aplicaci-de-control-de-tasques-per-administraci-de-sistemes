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
    
    public int NouGrup(Grups gru) {
        
        int nouGrup=0, validacio=0;
        String nom;
        nom = gru.getNom();
        
        
         if (nom.equals("")) {
            
            validacio++;
        }
      
        
        
        if (validacio == 0) {
            
            for (int i = 0; i< gru.getGrupUsuaris().length; i++){
                String[] array = gru.getGrupUsuaris();
        
            try {

                Connection cn = getConexio();              
                PreparedStatement pst2 = cn.prepareStatement("insert into GrupsUsuaris values (?,?,?,?)");
                pst2.setInt(1, 0);
                pst2.setInt(2, 0);
                pst2.setString(3, nom);
                pst2.setString(4, array[i]);
                

                pst2.executeUpdate();
                cn.close();

                System.err.println("Element creat correctament");
                nouGrup = 1;

            } catch (SQLException e) {
                nouGrup = 2;
                System.err.println("Error al crear l'element" + e);

            }
            
            }

            

        } else {
            nouGrup = 3;
            System.err.println("Has d'omplir tots els camps");

        }
        
        

        return nouGrup;

    }
}
    

