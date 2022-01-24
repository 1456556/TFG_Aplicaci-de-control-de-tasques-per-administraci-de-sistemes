/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ConsultesGrafiques extends Conexio {

    public DefaultTableModel agruparPrioritats() {

        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Prioritats", "Quantitat"};
            String dts[] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Prioritat, count(Prioritat) from Tasques group by Prioritat";
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("Prioritat");
                dts[1] = rs.getString("count(Prioritat)");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public DefaultTableModel agruparEstat() {

        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Estat", "Quantitat"};
            String dts[] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Estat, count(Estat) from Tasques group by Estat";
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("Estat");
                dts[1] = rs.getString("count(Estat)");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public DefaultTableModel agruparTipus() {

        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Tipus", "Quantitat"};
            String dts[] = new String[2];
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Recurrent, count(Recurrent) from Tasques group by Recurrent";
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                dts[0] = rs.getString("Recurrent");
                dts[1] = rs.getString("count(Recurrent)");
                miModelo.addRow(dts);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

    public DefaultTableModel agruparUsuaris() {

        DefaultTableModel miModelo = null;
        try {
            String titulos[] = {"Usuari", "Quantitat"};

            ArrayList<String> datos = new ArrayList();
            ArrayList<String> usuariIndividual = new ArrayList();
            ArrayList<String> dts = new ArrayList();
            ArrayList<Integer> dtsCount = new ArrayList<Integer>();
            miModelo = new DefaultTableModel(null, titulos);
            String sql = "select Usuari from Tasques";
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            int i = 0;
            while (rs.next()) {

                datos.add(rs.getString("Usuari"));
                System.out.println("Datos arrray list" + datos.get(i));
                i++;

            }
            for (int j = 0; j < datos.size(); j++) {

                String[] aux = datos.get(j).split("\\s+");
                for (int k = 0; k < aux.length; k++) {

                    System.out.println("Separats1 " + aux[k]);
                    usuariIndividual.add(aux[k]);
                }

            }

            for (int j = 0; j < usuariIndividual.size(); j++) {

                String valor = usuariIndividual.get(j);
                int countA = Collections.frequency(usuariIndividual, valor);
                System.out.println(usuariIndividual.get(j) + countA);

                if (!dts.contains(valor)) {

                    dts.add(valor);
                    dtsCount.add(countA);

                }

            }

            String dtsFinal[] = new String[2];
            for (int j = 0; j < dts.size(); j++) {

                System.out.println("DTS " + dts.get(j));
                dtsFinal[0] = dts.get(j);
                dtsFinal[1] = dtsCount.get(j).toString();
                miModelo.addRow(dtsFinal);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return miModelo;
    }

}
