/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Victor
 */
public class Notificacio {
    
    int idTasca;
    String titol;
    String data;
    String usuari;
    String mail;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getIdTasca() {
        return idTasca;
    }

    public void setIdTasca(int idTasca) {
        this.idTasca = idTasca;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

   
    
   
    
}
