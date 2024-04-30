/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home;
import com.database.DB;
import static com.database.DB.con;
import com.login.Bean;
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
         
            String query = "DELETE FROM poste WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,B.getId_poste());
            preparedStatement.executeUpdate();

          
            System.out.println("poste supprimé avec succès !");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
    }
    public static void Update(homeBean bean){
        
            try  {
String sql = "UPDATE poste SET id_poste = ? , texte = ?, date = ?, chemin_image = ? WHERE id_poste = ?";

PreparedStatement preparedStatement = con.prepareStatement(sql);
                // Remplacez les paramètres de la requête par les valeurs de l'objet homeBean
                preparedStatement.setInt(1,bean.getId_poste());
              preparedStatement.setString(2,bean.getTexte());
             preparedStatement.setObject(3,bean.getDate());
            preparedStatement.setString(4,bean.getChemin_img());
            preparedStatement.setInt(5,bean.getId_poste());

                
                // Exécutez la requête SQL
              preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null,"poste est  modifié avec succés");
             
            
        }        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}           
        
    }
    public static homeBean returnRow(int id) {
    homeBean bean=null;
                        try{
                            String query = "SELECT * FROM poste WHERE id_poste= "+id;
                            PreparedStatement preparedStatement = con.prepareStatement(query);
                               ResultSet resultSet = preparedStatement.executeQuery();
                                        while(resultSet.next()){
                                       
                                        String text = resultSet.getString("texte");
                                        Date temps = resultSet.getDate("date");
                                        int ID= resultSet.getInt("id_utilisateur");
                                        String file = resultSet.getString("chemin_image");
                                        int id_poste =resultSet.getInt("id_poste");
                                        homeBean TT=new homeBean(id_poste,text,temps,ID,file);
                                        return TT;
                                        }
                                }
                    catch (Exception e ){
                            JOptionPane.showMessageDialog(null,"erreur"+e);
                }
                        return bean;
}

private static Bean utilisateurConnecte; // Variable statique pour stocker l'utilisateur connecté

    // Méthode pour définir l'utilisateur connecté
    public static void setUtilisateurConnecte(Bean utilisateur) {
        utilisateurConnecte = utilisateur;
    }

    // Méthode pour récupérer l'utilisateur connecté
    public static Bean getUtilisateurConnecte() {
        return utilisateurConnecte;
    }
    public static int Emailgetter(Bean B){
        try{
         
            String query = "SELECT id FROM utilisateurs  WHERE id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,B.getId());
           
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                  
                    if (resultSet.next()) {
                      
                        return resultSet.getInt("id_utilisateurs");
                    } else {
                      return 0;
                    }
                }
            }
            
     
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
       return 0;
    }



}

