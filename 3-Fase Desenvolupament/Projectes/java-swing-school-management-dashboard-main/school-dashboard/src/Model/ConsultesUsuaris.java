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
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ConsultesUsuaris extends Conexio {

    public ArrayList<Usuaris> MostrarUsuaris() {

        ArrayList llistaUsuaris = new ArrayList();
        Usuaris usu;

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select nom, cognom, usuari, nivell, estat, id_usuari from Usuaris");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                usu = new Usuaris();
                usu.setNom(rs.getString(1));
                usu.setCognom(rs.getString(2));
                usu.setUsuari(rs.getString(3));
                usu.setNivell(rs.getString(4));
                usu.setEstat(rs.getString(5));
                usu.setId(rs.getInt(6));
                llistaUsuaris.add(usu);

            }

            cn.close();

        } catch (SQLException e) {

        }

        return llistaUsuaris;

    }

    public int informacioUsuari(Usuaris usu) {

        String tasca = usu.getNom();
        System.out.print("TITOL" + tasca);
        System.out.println("ID" + usu.getId());
        int informacioUsuari = 0;
        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris where id_usuari = '" + usu.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                usu.setNom(rs.getString(2));
                usu.setCognom(rs.getString(3));
                usu.setTelefon(rs.getString(4));
                usu.setMail(rs.getString(5));
                usu.setUsuari(rs.getString(6));
                usu.setContrasenya(rs.getString(7));
                usu.setNivell(rs.getString(8));
                usu.setEstat(rs.getString(9));
                informacioUsuari = 1;

            }

            System.out.println("ID" + usu.getId());
            cn.close();

        } catch (SQLException e) {

            informacioUsuari = 2;
            System.err.println("Error al solicitar les dades" + e);

        }

        return informacioUsuari;
    }

    public int EditarUsuari(Usuaris usu) {

        int editarUsuari, validacio = 0;
        String nom, cognom, usuari, telefon, mail, contrasenya, nivell, estat;
        nom = usu.getNom();
        cognom = usu.getCognom();
        usuari = usu.getUsuari();
        telefon = usu.getTelefon();
        mail = usu.getMail();
        contrasenya = " ";
        nivell = usu.getNivell();
        estat = usu.getEstat();

        System.out.print("OOUT" + nom + cognom + usuari + telefon + mail + nivell + estat);

        if (mail.equals("")) {

            validacio++;
        }
        if (nom.equals("")) {

            validacio++;
        }
        if (cognom.equals("")) {

            validacio++;
        }
        if (telefon.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (nivell.equals("")) {

            validacio++;
        }
        if (estat.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                Connection cn2 = MVC.Conexio.conectar();
                PreparedStatement pst2 = cn2.prepareStatement("update Usuaris set nom=?, cognom=?, telefon=?, email=?, usuari=?, contrassenya=?, nivell=?, estat=? where id_usuari = '" + usu.getId() + "'");

                pst2.setString(1, nom);
                pst2.setString(2, cognom);
                pst2.setString(3, telefon);
                pst2.setString(4, mail);
                pst2.setString(5, usuari);
                pst2.setString(6, contrasenya);
                pst2.setString(7, nivell);
                pst2.setString(8, estat);
                pst2.executeUpdate();
                cn2.close();

                System.err.println("Usuari modificat");

                Connection cn3 = MVC.Conexio.conectar();
                PreparedStatement pst3 = cn3.prepareStatement("update GrupsUsuaris set nomUsuari=? where id_usuari = '" + usu.getId() + "'");
                pst3.setString(1, usuari);
                pst3.executeUpdate();
                cn3.close();

                editarUsuari = 1;

            } catch (SQLException e) {
                editarUsuari = 2;
                System.err.println("Error al modificar l'usuari" + e);

            }

        } else {

            editarUsuari = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return editarUsuari;
    }

    public int NouUsuari(Usuaris usu) {

        int nouUsuari, validacio = 0;
        String nom, cognom, usuari, telefon, mail, contrasenya, nivell, estat;
        nom = usu.getNom();
        cognom = usu.getCognom();
        usuari = usu.getUsuari();
        telefon = usu.getTelefon();
        mail = usu.getMail();
        contrasenya = " ";
        nivell = usu.getNivell();
        estat = usu.getEstat();

        System.out.print("OOUT" + nom + cognom + usuari + telefon + mail + nivell + estat);

        if (mail.equals("")) {

            validacio++;
        }
        if (nom.equals("")) {

            validacio++;
        }
        if (cognom.equals("")) {

            validacio++;
        }
        if (telefon.equals("")) {

            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (nivell.equals("")) {

            validacio++;
        }
        if (estat.equals("")) {

            validacio++;
        }

        if (validacio == 0) {

            try {

                Connection cn = getConexio();
                PreparedStatement pst2 = cn.prepareStatement("insert into Usuaris (nom, cognom, telefon, email, usuari, nivell, estat) values (?,?,?,?,?,?,?)");

                pst2.setString(1, nom);
                pst2.setString(2, cognom);
                pst2.setString(3, telefon);
                pst2.setString(4, mail);
                pst2.setString(5, usuari);
                pst2.setString(6, nivell);
                pst2.setString(7, estat);

                pst2.executeUpdate();
                cn.close();

                System.err.println("Usuari creat correctament");
                nouUsuari = 1;

            } catch (SQLException e) {
                nouUsuari = 2;
                System.err.println("Error al crear l'usuari" + e);

            }

        } else {
            nouUsuari = 3;
            System.err.println("Has d'omplir tots els camps");

        }

        return nouUsuari;

    }

    public boolean EliminarUsuari(Usuaris usu) {

        System.out.println(usu.getId());

        try {

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Usuaris where id_usuari='" + usu.getId() + "'");
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar l'usuari" + e);
            return false;
        }

    }

    public ArrayList<Usuaris> BuscarUsuaris(String buscarUsu) {

        ArrayList llistaUsuaris = new ArrayList();
        Usuaris usu;

        try {

            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris where nom like '%" + buscarUsu + "%' or cognom like '%" + buscarUsu + "%'"
                    + "or usuari like '%" + buscarUsu + "%' or nivell like '%" + buscarUsu + "%' or estat like '%" + buscarUsu + "%'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                usu = new Usuaris();
                usu.setNom(rs.getString(2));
                usu.setCognom(rs.getString(3));
                usu.setUsuari(rs.getString(6));
                usu.setNivell(rs.getString(8));
                usu.setEstat(rs.getString(9));
                usu.setId(rs.getInt(1));

                llistaUsuaris.add(usu);

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informmmmacio, contacti amb l'administrador");

        }

        return llistaUsuaris;
    }

    public void GuardarId(Usuaris usu) {

        String nom = usu.getNom();
        System.out.print("TITOL" + nom);
        System.out.println("ID" + usu.getId());

        try {
            Connection cn = getConexio();
            PreparedStatement pst = cn.prepareStatement("select id_usuari from Usuaris where id_usuari = '" + usu.getId() + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                usu.setId(rs.getInt(1));

            }

            System.out.println("ID" + usu.getId());
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al crear el id de l'usuari" + e);

        }
    }

    public void contadorTasques(Tasques tas) {

        try {

            Connection cn2 = MVC.Conexio.conectar();
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

            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("SELECT count(id_tasca) FROM Tasques WHERE usuari = '" + Login.usuari + "'");
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
            Connection cn2 = MVC.Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("SELECT count(id_tasca) FROM Tasques WHERE usuari = '" + Login.usuari + "' AND estat = '" + proces + "' OR estat = '" + espera + "'");
            ResultSet rs = pst2.executeQuery();

            if (rs.next()) {

                tas.setTasquesPendents(rs.getInt(1));

            }

            cn2.close();

        } catch (SQLException e) {

            System.err.println("Error al contar les tasques pendents" + e);

        }

    }

}
