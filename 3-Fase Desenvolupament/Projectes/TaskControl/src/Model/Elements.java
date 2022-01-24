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
public class Elements {

    String nom;
    String usuariAssignat;
    String tipus;
    String marca;
    String model;
    String numeroSerie;
    String estat;
    String observacions;
    String adquisicio;
    int numeroTel;
    String element;
    String depertament;
    String sistemaOperatiu;
    String ubicacio;

    public String getSistemaOperatiu() {
        return sistemaOperatiu;
    }

    public void setSistemaOperatiu(String sistemaOperatiu) {
        this.sistemaOperatiu = sistemaOperatiu;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public String getDepertament() {
        return depertament;
    }

    public void setDepertament(String depertament) {
        this.depertament = depertament;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(int numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getAdquisicio() {
        return adquisicio;
    }

    public void setAdquisicio(String adquisicio) {
        this.adquisicio = adquisicio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    String data;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsuariAssignat() {
        return usuariAssignat;
    }

    public void setUsuariAssignat(String usuariAssignat) {
        this.usuariAssignat = usuariAssignat;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
    }

    public String getObservacions() {
        return observacions;
    }

    public void setObservacions(String observacions) {
        this.observacions = observacions;
    }

}
