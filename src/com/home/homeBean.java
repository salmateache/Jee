/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;

import java.util.Date;

/**
 *
 * @author USER
 */
public class homeBean {
    private String texte;
    private Date date ;
    private int id_utilisateurs ;
    private String chemin_img;
     private int id_poste ;

    public homeBean(String texte, Date date, int id_utilisateurs, String chemin_img) {
        this.texte = texte;
        this.date = date;
        this.id_utilisateurs = id_utilisateurs;
        this.chemin_img = chemin_img;
        this.id_poste = id_poste;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_utilisateurs() {
        return id_utilisateurs;
    }

    public void setId_utilisateurs(int id_utilisateurs) {
        this.id_utilisateurs = id_utilisateurs;
    }

    public String getChemin_img() {
        return chemin_img;
    }

    public void setChemin_img(String chemin_img) {
        this.chemin_img = chemin_img;
    }

    public int getId_poste() {
        return id_poste;
    }

    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }

   
    
    
}
