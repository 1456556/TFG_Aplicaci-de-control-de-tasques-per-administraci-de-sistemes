/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class Tasques {
    
   String titol;
   String prioritat;
   String usuariAssignat;
   String data;
   String dataFinal;
   String horaFinal;   
   String estat;
   String descripcio;
   String hora;
   Boolean notificacio;
   int tasquesTotals;
   int tasquesAssingades;
   int tasquesPendents;
   int repeticio;
   boolean recurrent;
   String tipus;

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
   

    public boolean isRecurrent() {
        return recurrent;
    }

    public void setRecurrent(boolean recurrent) {
        this.recurrent = recurrent;
    }
   
   public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public int getRepeticio() {
        return repeticio;
    }

    public void setRepeticio(int repeticio) {
        this.repeticio = repeticio;
    }

    public int getTasquesTotals() {
        return tasquesTotals;
    }

    public void setTasquesTotals(int tasquesTotals) {
        this.tasquesTotals = tasquesTotals;
    }

    public int getTasquesAssingades() {
        return tasquesAssingades;
    }

    public void setTasquesAssingades(int tasquesAssingades) {
        this.tasquesAssingades = tasquesAssingades;
    }

    public int getTasquesPendents() {
        return tasquesPendents;
    }

    public void setTasquesPendents(int tasquesPendents) {
        this.tasquesPendents = tasquesPendents;
    }
   

    public Boolean getNotificacio() {
        return notificacio;
    }

    public void setNotificacio(Boolean notificacio) {
        this.notificacio = notificacio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
   

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
   
   int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getPrioritat() {
        return prioritat;
    }

    public void setPrioritat(String prioritat) {
        this.prioritat = prioritat;
    }

    public String getUsuariAssignat() {
        return usuariAssignat;
    }

    public void setUsuariAssignat(String usuariAssignat) {
        this.usuariAssignat = usuariAssignat;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }
    
    
    
    
}
