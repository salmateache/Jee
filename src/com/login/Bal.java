/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login;

import com.database.DB;
import static com.database.DB.con;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 *
 * @author hp
 */
public class Bal {
    public static void insertdatasignup(Bean obj ){
        
        try{
         
            String query = "INSERT INTO utilisateurS VALUES (null ,?, ?, ? ,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,obj.getCin());
             preparedStatement.setString(2,obj.getTelephone());
            preparedStatement.setString(3,obj.getEmail());
            preparedStatement.setString(4,obj.getMdp());

            preparedStatement.executeUpdate();
            System.out.println("Utilisateur inséré avec succès !");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
                    }
    }
    
    
    
    public static boolean checklogin(String email , String mdp){
        boolean b = false ; 
        try{
            String query = "SELECT * FROM utilisateurs WHERE email = '"+email+"' AND mot_de_passe = '"+mdp+"'";
            PreparedStatement preparedStatement = con.prepareStatement(query);
   

         ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 
                b= true;
                 System.out.println("vous login avec succès !");
            }else{
                    JOptionPane.showMessageDialog(null,"login ou mot de passe incorrecte"); 
             }
           
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"login ou mot de passe incorrecte"+e);
                    }
        return b;
        
        
    }
}
