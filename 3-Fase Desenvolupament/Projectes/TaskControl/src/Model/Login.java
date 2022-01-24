/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Victor
 */
public class Login {

    public static String usuari;
    String contrasenya;
    Boolean dobleFactor;
    int Tel;

    public int getTel() {
        return Tel;
    }

    public void setTel(int Tel) {
        this.Tel = Tel;
    }

    public Boolean getDobleFactor() {
        return dobleFactor;
    }

    public void setDobleFactor(Boolean dobleFactor) {
        this.dobleFactor = dobleFactor;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

}
