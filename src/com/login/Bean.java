/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login;

/**
 *
 * @author hp
 */
public class Bean {
    private String email ;
     private String cin ;
      private String mdp ;
      
   private String telephone  ;
    public Bean(String email, String cin, String mdp, String telephone) {
        this.email = email;
        this.cin = cin;
        this.mdp = mdp;
        this.telephone = telephone;
    }
    

    public String getEmail() {
        return email;
    }

    public String getCin() {
        return cin;
    }

    public String getMdp() {
        return mdp;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
       
       
    
}
