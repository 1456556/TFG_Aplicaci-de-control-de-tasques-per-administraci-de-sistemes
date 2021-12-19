/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Grups {

    String nomUsuari;
    String nomElement;
    int idElement;
    String usuariElement;
    String tipusElement;
    String[] GrupElements;
    int[] IdElements;
    String nom;
    int id;
    int idUsuari;
    String[] GrupUsuaris;
    int[] IdUsuaris;
    Boolean tipusGrup;
    ArrayList<String> UsuariArrayList;
    ArrayList<Integer> idArrayList;
    ArrayList<String> ElementArrayList;
    ArrayList<Integer> idElementArrayList;

    public ArrayList<String> getElementArrayList() {
        return ElementArrayList;
    }

    public void setElementArrayList(ArrayList<String> ElementArrayList) {
        this.ElementArrayList = ElementArrayList;
    }

    public ArrayList<Integer> getIdElementArrayList() {
        return idElementArrayList;
    }

    public void setIdElementArrayList(ArrayList<Integer> idElementArrayList) {
        this.idElementArrayList = idElementArrayList;
    }

    public ArrayList<String> getUsuariArrayList() {
        return UsuariArrayList;
    }

    public void setUsuariArrayList(ArrayList<String> UsuariArrayList) {
        this.UsuariArrayList = UsuariArrayList;
    }

    public ArrayList<Integer> getIdArrayList() {
        return idArrayList;
    }

    public void setIdArrayList(ArrayList<Integer> idArrayList) {
        this.idArrayList = idArrayList;
    }

    public Boolean getTipusGrup() {
        return tipusGrup;
    }

    public void setTipusGrup(Boolean tipusGrup) {
        this.tipusGrup = tipusGrup;
    }

    public String getUsuariElement() {
        return usuariElement;
    }

    public void setUsuariElement(String usuariElement) {
        this.usuariElement = usuariElement;
    }

    public String getNomElement() {
        return nomElement;
    }

    public void setNomElement(String nomElement) {
        this.nomElement = nomElement;
    }

    public int getIdElement() {
        return idElement;
    }

    public void setIdElement(int idElement) {
        this.idElement = idElement;
    }

    public String getTipusElement() {
        return tipusElement;
    }

    public void setTipusElement(String tipusElement) {
        this.tipusElement = tipusElement;
    }

    public String[] getGrupElements() {
        return GrupElements;
    }

    public void setGrupElements(String[] GrupElements) {
        this.GrupElements = GrupElements;
    }

    public int[] getIdElements() {
        return IdElements;
    }

    public void setIdElements(int[] IdElements) {
        this.IdElements = IdElements;
    }

    public int[] getIdUsuaris() {
        return IdUsuaris;
    }

    public void setIdUsuaris(int[] IdUsuaris) {
        this.IdUsuaris = IdUsuaris;
    }

    public String[] getGrupUsuaris() {
        return GrupUsuaris;
    }

    public void setGrupUsuaris(String[] GrupUsuaris) {
        this.GrupUsuaris = GrupUsuaris;
    }

    String cognom;
    String usuari;

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }

    public String getNomUsuari() {
        return nomUsuari;
    }

    public void setNomUsuari(String nomUsuari) {
        this.nomUsuari = nomUsuari;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

}
