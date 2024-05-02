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
         
            String query = "DELETE FROM poste WHERE id_poste = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,B.getId_poste());
            preparedStatement.executeUpdate();

          
           JOptionPane.showMessageDialog(null,"Le poste est supprimé");
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
    }
 }
 
 public static void update(homeBean B) {
    try {
        String query = "UPDATE poste SET texte = ?, date = ?, id_utilisateur = null, chemin_image = ? WHERE id_poste = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        
        // Remplacer les paramètres "?" dans la requête SQL par les valeurs de l'objet homeBean B
        preparedStatement.setString(1, B.getTexte());
        preparedStatement.setDate(2, new java.sql.Date(B.getDate().getTime())); // Convertir la date en java.sql.Date
       
        preparedStatement.setString(3, B.getChemin_img());
        preparedStatement.setInt(4, B.getId_poste());

        // Exécuter la requête SQL
        preparedStatement.executeUpdate();

        JOptionPane.showMessageDialog(null, "Le poste est mis à jour avec succès");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erreur lors de la mise à jour du poste : " + e.getMessage());
    }
}

    public homeBean  returnRow(int id){
  
  homeBean bean = null; // Initialisation à null
    
    try {
        String query = "SELECT * FROM poste WHERE id_poste = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, id); // Remplacer le premier paramètre par le paramètre id
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            int postId = resultSet.getInt("id_poste");
            String text = resultSet.getString("texte");
            Date date = resultSet.getDate("date");
            int userId = resultSet.getInt("id_utilisateur");
            String imagePath = resultSet.getString("chemin_image");
            
            // Créer un nouvel objet homeBean avec les données de la ligne
            bean = new homeBean(postId, text, date, userId, imagePath);
        }

        // Fermer les ressources JDBC
        resultSet.close();
        preparedStatement.close();
    } catch (SQLException ex) {
        ex.printStackTrace(); // Afficher l'erreur
        // Gérer l'exception, par exemple, en affichant un message à l'utilisateur ou en lançant une exception
    }
    
    return bean;
    }
    
    

private static Bean utilisateurConnecte; // Variable statique pour stocker l'utilisateur connecté

    // Méthode pour définir l'utilisateur connecté
    public static void setUtilisateurConnecte(Bean utilisateur) {
        utilisateurConnecte = utilisateur;
    }
    
    
    
public static void clear(homeBean B){
                try{
         
            String query = "UPDATE poste SET texte = NULL, date = NULL, id_utilisateur = NULL, chemin_image = NULL WHERE id_poste = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,B.getId_poste());
            preparedStatement.executeUpdate();

          
           JOptionPane.showMessageDialog(null,"Le poste est vidé");
        }
    
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
        /* */}
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

