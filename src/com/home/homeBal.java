/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;
import com.database.DB;
import static com.database.DB.con;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;



/**
 *
 * @author USER
 */
public class homeBal {

    public List<homeBean> Afficher(){
        List<homeBean> L =new ArrayList<homeBean>();
              try{
         
            String query = "SELECT * FROM poste";
            PreparedStatement preparedStatement = con.prepareStatement(query);
         
            ResultSet resultSet = preparedStatement.executeQuery();
          
            while(resultSet.next()){
                String text = resultSet.getString("texte");
                Date temps = resultSet.getDate("date");
                int id = resultSet.getInt("id_utilisateur");
                String file = resultSet.getString("chemin_image");
                int id_poste =resultSet.getInt("id_poste");
                homeBean TT=new homeBean(id_poste,text,temps,id,file);
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
    }}

