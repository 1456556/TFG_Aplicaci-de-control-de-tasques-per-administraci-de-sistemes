/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Enrique
 */
public class DGraficar {
    
    Connection cn = DConexion.getConnection();
    
    public DefaultTableModel mostrarPersona(){
        
        DefaultTableModel miModelo = null;
        try{
            String titulos []= {"Id","Nombre"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select * from Persona";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("IdP");
               dts[1] = rs.getString("Nombre");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }
    
    public DefaultTableModel agruparPersona(){
        
        DefaultTableModel miModelo = null;
        try{
            String titulos []= {"Nombres","Cuantas personas"};
            String dts [] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Nombre, count(Nombre) from Persona group by Nombre";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("Nombre");
               dts[1] = rs.getString("count(Nombre)");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }   
    
    public DefaultTableModel mostrarGenero(){
        
        DefaultTableModel miModelo = null;
        try{
            String titulos []= {"Cantidad","Genero","Dia"};
            String dts [] = new String[3];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Cantidad, Genero, Dia from Cuantos";
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
               dts[0] = rs.getString("Cantidad");
               dts[1] = rs.getString("Genero");
               dts[2] = rs.getString("Dia");
               miModelo.addRow(dts);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return miModelo;
    }       
    
    
}
