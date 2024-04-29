/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class DB {
    public static Connection con = null;
    public static void Loadconnection(){
        String url = "jdbc:mysql://localhost:3306/jeeprojet";
        String user = "root";
        String mdp = "";
        try{
            con = DriverManager.getConnection(url ,user,mdp);
            if(con != null){
                 JOptionPane.showMessageDialog(null,"Connexion réussie! ");  
            }
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
                    }
    }
}
