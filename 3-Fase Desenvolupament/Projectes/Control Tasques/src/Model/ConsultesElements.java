/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.JFPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ConsultesElements extends Conexio {

    public int NouElement(Elements elm) {

        int nouElement, validacio = 0;
        String nom, observacions, usuari, estat, tipus, marca, model, numeroSerie, data, adquisicio, element;
        nom = elm.getNom();
        observacions = elm.getObservacions();
        estat = elm.getEstat();
        tipus = elm.getTipus();
        usuari = elm.getUsuariAssignat();
        marca = elm.getMarca();
        numeroSerie = elm.getNumeroSerie();
        model = elm.getModel();
        data = elm.getData();
        adquisicio = elm.getAdquisicio();
        element = "Ordinador";

        if (adquisicio.equals("")) {

            validacio++;
        }

        if (data.equals("")) {

            validacio++;
        }

        if (nom.equals("")) {

            validacio++;
        }
        if (observacions.equals("")) {

            validacio++;
        }
        if (estat.equals("")) {

            validacio++;
        }
        if (tipus.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (marca.equals("")) {

            validacio++;
        }
        if (numeroSerie.equals("")) {

            validacio++;
        }
        if (model.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                Connection cn = getConexio();
                PreparedStatement pst2 = cn.prepareStatement("insert into Elements (nom,usuari,tipus,marca,model,numero_serie,estat,observacions,adquisicio,data_ingres,element) values (?,?,?,?,?,?,?,?,?,?,?)");

                pst2.setString(1, nom);
                pst2.setString(2, usuari);
                pst2.setString(3, tipus);
                pst2.setString(4, marca);
                pst2.setString(5, model);
                pst2.setString(6, numeroSerie);
                pst2.setString(7, estat);
                pst2.setString(8, observacions);
                pst2.setString(9, adquisicio);
                pst2.setString(10, data);
                pst2.setString(11, element);

                pst2.executeUpdate();
                cn.close();

                System.err.println("Element creat correctament");
                nouElement = 1;

            } catch (SQLException e) {
                nouElement = 2;
                System.err.println("Error al crear l'element" + e);

            }

        } else {
            nouElement = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return nouElement;

    }

    public int EditarElement(Elements elm) {

        int editarElement, validacio = 0;
        String nom, observacions, usuari, estat, tipus, marca, model, numeroSerie;
        nom = elm.getNom();
        observacions = elm.getObservacions();
        estat = elm.getEstat();
        tipus = elm.getTipus();
        usuari = elm.getUsuariAssignat();
        marca = elm.getMarca();
        numeroSerie = elm.getNumeroSerie();
        model = elm.getModel();

        if (nom.equals("")) {

            validacio++;
        }
        if (observacions.equals("")) {

            validacio++;
        }
        if (estat.equals("")) {

            validacio++;
        }
        if (tipus.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (marca.equals("")) {

            validacio++;
        }
        if (numeroSerie.equals("")) {

            validacio++;
        }
        if (model.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                Connection cn2 = MVC.Conexio.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("update Elements set nom=?, usuari=?, tipus=?, marca=?, model=?, numero_serie=?, estat=?, observacions=? where id_element = '" + elm.getId() + "'");

                pst2.setString(1, nom);
                pst2.setString(2, usuari);
                pst2.setString(3, tipus);
                pst2.setString(4, marca);
                pst2.setString(5, model);
                pst2.setString(6, numeroSerie);
                pst2.setString(7, estat);
                pst2.setString(8, observacions);
                pst2.executeUpdate();
                cn2.close();
                editarElement = 1;
                System.err.println("Element modificat");

            } catch (SQLException e) {
                editarElement = 2;
                System.err.println("Error al modificar l'element" + e);

            }

        } else {

            editarElement = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return editarElement;
    }

    public void UsuariAssignat(JFPrincipal vis) {

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                vis.ComboUsuariAssignatOrdinador.addItem(rs.getString("usuari"));

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al carregar el usuariAssignat");

        }

    }

    public boolean EliminarElement(Elements elm) {

        System.out.println(elm.getId());

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Elements where id_element='" + elm.getId() + "'");
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar l'element" + e);
            return false;
        }

    }

    public ArrayList<Elements> MostrarElements() {

        ArrayList llistaElements = new ArrayList();
        Elements elm;

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select nom, usuari, tipus, marca, estat, id_element from Elements");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                elm = new Elements();
                elm.setNom(rs.getString(1));
                elm.setUsuariAssignat(rs.getString(2));
                elm.setTipus(rs.getString(3));
                elm.setMarca(rs.getString(4));
                elm.setEstat(rs.getString(5));
                elm.setId(rs.getInt(6));
                llistaElements.add(elm);

            }

            cn.close();

        } catch (SQLException e) {

        }

        return llistaElements;

    }

    public ArrayList<Elements> BuscarElements(String buscarElem) {

        ArrayList llistaElements = new ArrayList();
        Elements elm;

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Elements where nom like '%" + buscarElem + "%' or usuari like '%" + buscarElem + "%'"
                    + "or tipus like '%" + buscarElem + "%' or marca like '%" + buscarElem + "%' or estat like '%" + buscarElem + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                elm = new Elements();
                elm.setNom(rs.getString(2));
                elm.setUsuariAssignat(rs.getString(3));
                elm.setTipus(rs.getString(4));
                elm.setMarca(rs.getString(5));
                elm.setEstat(rs.getString(8));
                elm.setId(rs.getInt(1));

                llistaElements.add(elm);

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informmmmacio, contacti amb l'administrador");

        }

        return llistaElements;
    }

    public int informacioElement(Elements elm) {

        String tasca = elm.getNom();
        System.out.print("TITOL" + tasca);
        System.out.println("ID" + elm.getId());
        int informacioElement = 0;
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Elements where id_element = '" + elm.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                elm.setNom(rs.getString(2));
                elm.setUsuariAssignat(rs.getString(3));
                elm.setTipus(rs.getString(4));
                elm.setMarca(rs.getString(5));
                elm.setEstat(rs.getString(6));
                elm.setModel(rs.getString(7));
                elm.setNumeroSerie(rs.getString(8));
                elm.setObservacions(rs.getString(9));
                informacioElement = 1;

            }

            System.out.println("ID" + elm.getId());
            cn.close();

        } catch (SQLException e) {

            informacioElement = 2;
            System.err.println("Error al solicitar les dades" + e);

        }

        return informacioElement;
    }

    public void GuardarId(Elements elm) {

        String nom = elm.getNom();
        System.out.print("TITOL" + nom);
        System.out.println("ID" + elm.getId());

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_element from Elements where id_element = '" + elm.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                elm.setId(rs.getInt(1));

            }

            System.out.println("ID" + elm.getId());
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al crear el id de l'element" + e);

        }
    }

}
