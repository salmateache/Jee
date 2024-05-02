/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.home;

import com.login.Bal;
import com.login.Bean;
import com.login.loginframe;
import com.sun.jdi.connect.spi.Connection;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import com.database.DB;
import static com.database.DB.con;
import com.login.Bean;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



/**
 *
 * @author hp
 */
public class homeframe extends javax.swing.JFrame {

    /**
     * Creates new form homeframe
     */
    public homeframe() {
        initComponents();
        load();
    }

  public void loadtable(List<homeBean> list) {
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.setRowCount(0);
      String url = "jdbc:mysql://localhost:3307/jeeprojet";
        String user = "root";
        String mdp = "";
        try{
            con = DriverManager.getConnection(url ,user,mdp);
            String sql = "SELECT email FROM utilisateurs WHERE id = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                for (homeBean bean : list) {
                    Vector v = new Vector();
                    v.add(bean.getId_poste());
                    v.add(bean.getTexte());
                    v.add(bean.getDate());
                    
                    // Récupération de l'e-mail de l'utilisateur correspondant à id_utilisateurs
                    statement.setInt(1, bean.getId_utilisateurs());
                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            String emailUtilisateur = resultSet.getString("email");
                            v.add(emailUtilisateur);
                        } else {
                            v.add(""); // Si aucun e-mail n'est trouvé, vous pouvez ajouter une chaîne vide ou gérer autrement
                        }
                    }

                    v.add(bean.getChemin_img());
                    dm.addRow(v);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   

    
   public void load(){
       homeBal bal = new homeBal();
       List list = bal.Afficher();
       loadtable(list);
   } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imprimer = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        update = new javax.swing.JButton();
        fileimg = new javax.swing.JTextField();
        btnSelect = new java.awt.Button();
        jLabel7 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        Voir = new java.awt.Button();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Exporter = new javax.swing.JButton();
        Importer1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 73, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BLOG_FSA");

        imprimer.setBackground(new java.awt.Color(0, 153, 255));
        imprimer.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        imprimer.setForeground(new java.awt.Color(255, 255, 255));
        imprimer.setText("print");
        imprimer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(479, 479, 479)
                .addComponent(jLabel1)
                .addGap(171, 171, 171)
                .addComponent(imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(imprimer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BLOG_FSA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 12), new java.awt.Color(0, 153, 255))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("Texte : ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 255));
        jLabel9.setText("Date: ");

        text.setColumns(20);
        text.setRows(5);
        text.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));
        jScrollPane5.setViewportView(text);

        delete.setBackground(new java.awt.Color(0, 153, 255));
        delete.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 153, 255));
        add.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("ADD");
        add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(0, 153, 255));
        clear.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        clear.setForeground(new java.awt.Color(255, 255, 255));
        clear.setText("CLEAR");
        clear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(0, 153, 255));
        update.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("UPDATE");
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        btnSelect.setLabel("Select");
        btnSelect.setName(""); // NOI18N
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setText("file : ");

        Voir.setLabel("voir");
        Voir.setName(""); // NOI18N
        Voir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Voir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                    .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(fileimg, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Voir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fileimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7)))
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(add))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clear)
                    .addComponent(update))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "texte", "date", "utilisateur", "image"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        Exporter.setBackground(new java.awt.Color(0, 153, 255));
        Exporter.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Exporter.setForeground(new java.awt.Color(255, 255, 255));
        Exporter.setText("Exporter");
        Exporter.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Exporter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExporterActionPerformed(evt);
            }
        });

        Importer1.setBackground(new java.awt.Color(0, 153, 255));
        Importer1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Importer1.setForeground(new java.awt.Color(255, 255, 255));
        Importer1.setText("Importer");
        Importer1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Importer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Importer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(Exporter, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(716, Short.MAX_VALUE)
                    .addComponent(Importer1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(168, 168, 168)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(Exporter)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(330, Short.MAX_VALUE)
                    .addComponent(Importer1)
                    .addGap(190, 190, 190)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 520));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
       
        String texte=text.getText(); 
        String file=fileimg.getText();
        Date temps=date.getDate();
       
        
       homeBean h=new homeBean(0,texte,temps,1,file);
       homeBal B=new homeBal();
       B.delete(h);
       load();
    }//GEN-LAST:event_deleteActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
                                 
   
    String texte = text.getText(); 
    String file = fileimg.getText();
    Date temps = date.getDate();
    homeBal B = new homeBal();
    
    // Récupérer l'utilisateur connecté
    Bean utilisateurConnecte = B.getUtilisateurConnecte(); // Supposons que cette méthode récupère l'utilisateur connecté
    
    // Vérifier si un utilisateur est connecté

        homeBean h = new homeBean(1, texte, temps, 1, file);
        
        // Insérer le homeBean dans la base de données
        B.insert(h);
        load();
   

    }//GEN-LAST:event_addActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
       int row = jTable1.getSelectedRow();
      if(row<0){
      JOptionPane.showMessageDialog(null,"please select a row from the table");
      }
      else{
          int id = (int) jTable1.getValueAt(row,0);
          homeBal Home=new homeBal();
    String texte = text.getText(); 
    String file = fileimg.getText();
    Date temps = date.getDate();
    homeBal B = new homeBal();
    homeBean bean = new homeBean(id,texte,temps,0,file);
    homeBal bal= new homeBal();
    bal.clear(bean);
    load();}

    }//GEN-LAST:event_clearActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
      int row = jTable1.getSelectedRow();
      if(row<0){
      JOptionPane.showMessageDialog(null,"please select a row from the table");
      }
      else{
          int id = (int) jTable1.getValueAt(row,0);
          homeBal Home=new homeBal();
    String texte = text.getText(); 
    String file = fileimg.getText();
    Date temps = date.getDate();
    homeBal B = new homeBal();
    homeBean bean = new homeBean(id,texte,temps,0,file);
    homeBal bal= new homeBal();
    bal.update(bean);
    load();
      }


    }//GEN-LAST:event_updateActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
JFileChooser fo = new JFileChooser();  
        fo.showOpenDialog(fo);
        File imgfile=fo.getSelectedFile();
        String filepath=imgfile.getAbsolutePath();
        fileimg.setText(filepath);
    }//GEN-LAST:event_btnSelectActionPerformed

    private void ExporterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExporterActionPerformed
       try {
        homeBean bean = new homeBean(1,"Texte de l'objet", new Date(), 123, "chemin/image.jpg");
        FileOutputStream fos = new FileOutputStream(new File("./fichier.xml"));
      XMLEncoder encoder = new XMLEncoder(fos);
      encoder.writeObject(bean);
      fos.close();
        // Afficher un message de succès
        JOptionPane.showMessageDialog(this, "Objet exporté avec succès en XML.");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors de l'exportation de l'objet en XML.");
    }        // TODO add your handling code here:
 
 
       

    }//GEN-LAST:event_ExporterActionPerformed

    private void Importer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Importer1ActionPerformed
          JFileChooser fileChooser = new JFileChooser();
    int choix = fileChooser.showOpenDialog(this);

    if (choix == JFileChooser.APPROVE_OPTION) {
        File fichierXML = fileChooser.getSelectedFile();

        try {
            // Création du contexte JAXB
            JAXBContext context = JAXBContext.newInstance(homeBean.class);

            // Création du parseur JAXB
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Lecture du fichier XML et transformation en objets Java
            homeBean homeBean = (homeBean) unmarshaller.unmarshal(fichierXML);

           
                JOptionPane.showMessageDialog(this, "Données enregistrées avec succès.");
  } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement des données.");
        }
    }
      try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(System.getProperty("user.home") + "/Pile.ser"))) {
        homeBean bean = (homeBean) ois.readObject();
        // Utilisez l'objet désérialisé comme nécessaire
        System.out.println("Texte: " + bean.getTexte());
        System.out.println("Date: " + bean.getDate());
        System.out.println("ID Utilisateurs: " + bean.getId_utilisateurs());
        System.out.println("Chemin Image: " + bean.getChemin_img());
        System.out.println("ID Poste: " + bean.getId_poste());

        // Affichez un message de succès
        JOptionPane.showMessageDialog(this, "Objet importé avec succès depuis le fichier.");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Erreur lors de l'importation de l'objet depuis le fichier.");
    }

    }//GEN-LAST:event_Importer1ActionPerformed

    private void imprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimerActionPerformed
      PrinterJob job = PrinterJob.getPrinterJob();

    // Définir le composant à imprimer (dans ce cas, c'est votre JFrame)
    job.setPrintable(new Printable() {
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            if (pageIndex > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            // Obtenez la taille de la fenêtre à imprimer
            Dimension dim = getSize();
            double scaleX = pageFormat.getImageableWidth() / dim.getWidth();
            double scaleY = pageFormat.getImageableHeight() / dim.getHeight();

            // Mettez à l'échelle le composant pour tenir sur la page
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            g2d.scale(scaleX, scaleY);

            // Imprimez le composant
            printAll(graphics);

            return Printable.PAGE_EXISTS;
        }
    });

    // Afficher la boîte de dialogue d'impression et imprimer si l'utilisateur le souhaite
    if (job.printDialog()) {
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'impression.");
        }
    }       
    }//GEN-LAST:event_imprimerActionPerformed

    private void VoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoirActionPerformed
       String cheminImage = fileimg.getText();

        // Créez un objet File à partir du chemin du fichier
        File fichierImage = new File(cheminImage);

        // Vérifiez si le fichier existe
        if (fichierImage.exists()) {
            // Créer une nouvelle fenêtre pour afficher l'image
            JFrame imageFrame = new JFrame("Image");
            JLabel labelImage = new JLabel();

            // Chargez l'image à partir du fichier
            ImageIcon imageIcon = new ImageIcon(cheminImage);

            // Configurez la taille de l'image à afficher
            int width = 200; // Largeur souhaitée
            int height = 200; // Hauteur souhaitée
            Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);

            // Affichez l'image dans un JLabel
            labelImage.setIcon(new ImageIcon(image));

            // Ajouter le labelImage à la fenêtre imageFrame
            imageFrame.getContentPane().add(labelImage);
 // Définir les propriétés de la fenêtre imageFrame
            imageFrame.pack();
            imageFrame.setLocationRelativeTo(this); // Centrer la fenêtre par rapport à la fenêtre principale
            imageFrame.setVisible(true); // Afficher la fenêtre
        } else {
            JOptionPane.showMessageDialog(this, "Fichier image non trouvé : " + cheminImage);
        }


    }//GEN-LAST:event_VoirActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
         int row = jTable1.getSelectedRow();
      if(row<0){
      JOptionPane.showMessageDialog(null,"please select a row from the table");
      }
      else{
          int id = (int) jTable1.getValueAt(row,0);
          homeBal Home=new homeBal();
          
          homeBean Bean=Home.returnRow(id);
          text.setText(Bean.getTexte());
          date.setDate(Bean.getDate());
          fileimg.setText(Bean.getChemin_img());
      }

    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(homeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(homeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(homeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(homeframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new homeframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exporter;
    private javax.swing.JButton Importer1;
    private java.awt.Button Voir;
    private javax.swing.JButton add;
    private java.awt.Button btnSelect;
    private javax.swing.JButton clear;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JButton delete;
    private javax.swing.JTextField fileimg;
    private javax.swing.JButton imprimer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextArea text;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
