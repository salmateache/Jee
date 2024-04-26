/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database;
import com.sun.jdi.connect.spi.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class DB {
    public static Connection con = null;
    public static void Loadconnection(){
        String url = "jdbc:mysql://localhost:3307/jeeprojet";
        String user = "root";
        String mdp = "root";
        try{
            con = (Connection) DriverManager.getConnection(url ,user ,mdp);
            if(con != null){
                  JOptionPane.showMessageDialog(null,"erreur");   
            }
        }
        catch (Exception e ){
            JOptionPane.showMessageDialog(null,"erreur"+e);
                    }
    }
}
