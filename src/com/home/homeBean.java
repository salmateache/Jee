/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@XmlRootElement(name = "homeBean")
public class homeBean implements Serializable {
    private String texte;
    private Date date ;
    private int id_utilisateurs ;
    private String chemin_img;
     private int id_poste ;

    public homeBean(int id_poste,String texte, Date date, int id_utilisateurs, String chemin_img) {
        this.texte = texte;
        this.date = date;
        this.id_utilisateurs = id_utilisateurs;
        this.chemin_img = chemin_img;
        this.id_poste = id_poste;
    }
      public homeBean() {
 
    }
    @XmlElement

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
    @XmlElement

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    @XmlElement

    public int getId_utilisateurs() {
        return id_utilisateurs;
    }

    public void setId_utilisateurs(int id_utilisateurs) {
        this.id_utilisateurs = id_utilisateurs;
    }
    @XmlElement

    public String getChemin_img() {
        return chemin_img;
    }

    public void setChemin_img(String chemin_img) {
        this.chemin_img = chemin_img;
    }
    @XmlElement

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

   
    
    
}
