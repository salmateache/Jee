/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;
import com.database.DB;
import static com.database.DB.con;
import java.awt.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class homeBal {

    /**
     *
     * @return
     */
    public List<homeBean> Afficher(){
        List<homeBean> L=new ArrayList<homeBean>();
              try{
         
            String query = "SELECT * FROM poste";
            PreparedStatement preparedStatement = con.prepareStatement(query);


            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("poste inséré avec succès !");
            while(resultSet.next()){
                String text = resultSet.getTexte("text");
                Date temps = resultSet.getDate("date");
                int id = resultSet.getId_utilisateurs("id_utilisateur");
                String file = resultSet.getChemin_image("chemin_image");
                homeBean TT=new homeBean(text,temps,id,file);
                L.add(TT);

                
            }
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
        return L;
    }
    public static void insert(homeBean B){
        try{
         
            String query = "INSERT INTO poste VALUES (null ,?, ?, ? ,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,B.getTexte());
             preparedStatement.setObject(2,B.getDate());
            preparedStatement.setInt(3,B.getId_utilisateurs());
            preparedStatement.setString(4,B.getChemin_img());

            preparedStatement.executeUpdate();
            System.out.println("poste inséré avec succès !");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
    }
    
    public static void delete(homeBean B){
                try{
         
            String query = "DELETE FROM poste WHERE texte = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,B.getTexte());
            preparedStatement.executeUpdate();

          
            System.out.println("poste supprimé avec succès !");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
    }

