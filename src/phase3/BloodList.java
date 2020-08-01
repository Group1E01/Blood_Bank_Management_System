/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class BloodList extends javax.swing.JFrame {
    Connection myConn;
    Statement myStat;
    int cmpID;
    
    public BloodList() {
        initComponents();
    }
    
    public BloodList(int id) {
        initComponents();
        Toolkit toolkit = getToolkit(); //center jFrame
        Dimension size = toolkit.getScreenSize(); //center jFrame
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2); //center jFrame
        this.cmpID = id;
        txtDonorGuestCampaignID.setText(String.valueOf(cmpID));
        txtDonorGuestCampaignID.setEditable(false);
        displayTableA();
        displayTableB();
        displayTableAB();
        displayTableO();
    }

    public void displayTableA(){ //display all donor info based on campaign id
        ArrayList<Donor> donorlist = new ArrayList<>();
        String id = txtDonorGuestCampaignID.getText();
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
            myStat = myConn.createStatement();
            String sql = "SELECT * FROM donor WHERE DonBType = 'A' && CampaignID = " + id;
            ResultSet rs = myStat.executeQuery(sql);
            Donor donor;
            while(rs.next()){
                donor = new Donor(rs.getString("DonIC"), rs.getString("DonName"), rs.getString("DonGender"), rs.getString("DonBType"), rs.getInt("DonAge"), rs.getInt("DonBAMount"));
                donorlist.add(donor);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        DefaultTableModel model = (DefaultTableModel)jTable_BloodTableA.getModel();
        Object[] row = new Object[6];
        for(int i=0; i<donorlist.size();i++){
            row[0] = donorlist.get(i).getDonorIC();
            row[1] = donorlist.get(i).getDonorName();
            row[2] = donorlist.get(i).getDonorGender();
            row[3] = donorlist.get(i).getDonorAge();
            row[4] = donorlist.get(i).getDonorBloodType();
            row[5] = donorlist.get(i).getDonorDonatedAmount();
            model.addRow(row);
        }
        int count = donorlist.size();
        jLabelTotalNumDonorViewA.setText(String.valueOf(count)); //total num of donor
        int sum = 0;
        for(int i=0; i<donorlist.size();i++){
            sum = sum + Integer.parseInt(jTable_BloodTableA.getValueAt(i,5).toString());
        }
        jLabelTotalBloodAmountViewA.setText(String.valueOf(sum)); //total blood amount

    }
    
    public void displayTableB(){ 
        ArrayList<Donor> donorlist = new ArrayList<>();
        String id = txtDonorGuestCampaignID.getText();
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
            myStat = myConn.createStatement();
            String sql = "SELECT * FROM donor WHERE DonBType = 'B' && CampaignID = " + id;
            ResultSet rs = myStat.executeQuery(sql);
            Donor donor;
            while(rs.next()){
                donor = new Donor(rs.getString("DonIC"), rs.getString("DonName"), rs.getString("DonGender"), rs.getString("DonBType"), rs.getInt("DonAge"), rs.getInt("DonBAMount"));
                donorlist.add(donor);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        DefaultTableModel model = (DefaultTableModel)jTable_BloodTableB.getModel();
        Object[] row = new Object[6];
        for(int i=0; i<donorlist.size();i++){
            row[0] = donorlist.get(i).getDonorIC();
            row[1] = donorlist.get(i).getDonorName();
            row[2] = donorlist.get(i).getDonorGender();
            row[3] = donorlist.get(i).getDonorAge();
            row[4] = donorlist.get(i).getDonorBloodType();
            row[5] = donorlist.get(i).getDonorDonatedAmount();
            model.addRow(row);
        }
        int count = donorlist.size();
        jLabelTotalNumDonorViewB.setText(String.valueOf(count));
        int sum = 0;
        for(int i=0; i<donorlist.size();i++){
            sum = sum + Integer.parseInt(jTable_BloodTableB.getValueAt(i,5).toString());
        }
        jLabelTotalBloodAmountViewB.setText(String.valueOf(sum));
    }
    
    public void displayTableAB(){
        ArrayList<Donor> donorlist = new ArrayList<>();
        String id = txtDonorGuestCampaignID.getText();
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
            myStat = myConn.createStatement();
            String sql = "SELECT * FROM donor WHERE DonBType = 'AB' && CampaignID = " + id;
            ResultSet rs = myStat.executeQuery(sql);
            Donor donor;
            while(rs.next()){
                donor = new Donor(rs.getString("DonIC"), rs.getString("DonName"), rs.getString("DonGender"), rs.getString("DonBType"), rs.getInt("DonAge"), rs.getInt("DonBAMount"));
                donorlist.add(donor);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        DefaultTableModel model = (DefaultTableModel)jTable_BloodTableAB.getModel();
        Object[] row = new Object[6];
        for(int i=0; i<donorlist.size();i++){
            row[0] = donorlist.get(i).getDonorIC();
            row[1] = donorlist.get(i).getDonorName();
            row[2] = donorlist.get(i).getDonorGender();
            row[3] = donorlist.get(i).getDonorAge();
            row[4] = donorlist.get(i).getDonorBloodType();
            row[5] = donorlist.get(i).getDonorDonatedAmount();
            model.addRow(row);
        }
        int count = donorlist.size();
        jLabelTotalNumDonorViewAB.setText(String.valueOf(count));
        int sum = 0;
        for(int i=0; i<donorlist.size();i++){
            sum = sum + Integer.parseInt(jTable_BloodTableAB.getValueAt(i,5).toString());
        }
        jLabelTotalBloodAmountViewAB.setText(String.valueOf(sum));
    }
    
    public void displayTableO(){ 
        ArrayList<Donor> donorlist = new ArrayList<>();
        String id = txtDonorGuestCampaignID.getText();
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/phase3", "root", "");
            myStat = myConn.createStatement();
            String sql = "SELECT * FROM donor WHERE DonBType = 'O' && CampaignID = " + id;
            ResultSet rs = myStat.executeQuery(sql);
            Donor donor;
            while(rs.next()){
                donor = new Donor(rs.getString("DonIC"), rs.getString("DonName"), rs.getString("DonGender"), rs.getString("DonBType"), rs.getInt("DonAge"), rs.getInt("DonBAMount"));
                donorlist.add(donor);
            }
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

        DefaultTableModel model = (DefaultTableModel)jTable_BloodTableO.getModel();
        Object[] row = new Object[6];
        for(int i=0; i<donorlist.size();i++){
            row[0] = donorlist.get(i).getDonorIC();
            row[1] = donorlist.get(i).getDonorName();
            row[2] = donorlist.get(i).getDonorGender();
            row[3] = donorlist.get(i).getDonorAge();
            row[4] = donorlist.get(i).getDonorBloodType();
            row[5] = donorlist.get(i).getDonorDonatedAmount();
            model.addRow(row);
        }
        int count = donorlist.size();
        jLabelTotalNumDonorViewO.setText(String.valueOf(count));
        int sum = 0;
        for(int i=0; i<donorlist.size();i++){
            sum = sum + Integer.parseInt(jTable_BloodTableO.getValueAt(i,5).toString());
        }
        jLabelTotalBloodAmountViewO.setText(String.valueOf(sum));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDonorHeader = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_BloodTableB = new javax.swing.JTable();
        btnDonorGuestBackButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtDonorGuestCampaignID = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_BloodTableA = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabelTotalBloodAmountA = new javax.swing.JLabel();
        jLabelTotalNumDonorA = new javax.swing.JLabel();
        jLabelTotalBloodAmountViewA = new javax.swing.JLabel();
        jLabelTotalNumDonorViewA = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotalBloodAmountB = new javax.swing.JLabel();
        jLabelTotalBloodAmountViewB = new javax.swing.JLabel();
        jLabelTotalNumDonorViewB = new javax.swing.JLabel();
        jLabelTotalNumDonorB = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_BloodTableAB = new javax.swing.JTable();
        jLabelTotalNumDonorViewAB = new javax.swing.JLabel();
        jLabelTotalNumDonorAB = new javax.swing.JLabel();
        jLabelTotalBloodAmountViewAB = new javax.swing.JLabel();
        jLabelTotalBloodAmountAB = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable_BloodTableO = new javax.swing.JTable();
        jLabelTotalNumDonorViewO = new javax.swing.JLabel();
        jLabelTotalNumDonorO = new javax.swing.JLabel();
        jLabelTotalBloodAmountO = new javax.swing.JLabel();
        jLabelTotalBloodAmountViewO = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDonorHeader.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblDonorHeader.setText("Blood List");

        jTable_BloodTableB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC Num", "Name", "Gender", "Age", "Blood Type", "Donated Amount"
            }
        ));
        jScrollPane4.setViewportView(jTable_BloodTableB);

        btnDonorGuestBackButton1.setText("Back");
        btnDonorGuestBackButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonorGuestBackButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Campaign ID:");

        txtDonorGuestCampaignID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonorGuestCampaignIDActionPerformed(evt);
            }
        });

        jTable_BloodTableA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC Num", "Name", "Gender", "Age", "Blood Type", "Donated Amount"
            }
        ));
        jTable_BloodTableA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_BloodTableAMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTable_BloodTableA);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Blood Type: A");

        jLabelTotalBloodAmountA.setText("Total Amount of Blood Received:");

        jLabelTotalNumDonorA.setText("Total Number of Donor:");

        jLabelTotalBloodAmountViewA.setText("jLabel5");

        jLabelTotalNumDonorViewA.setText("jLabel6");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Blood Type: B");

        jLabelTotalBloodAmountB.setText("Total Amount of Blood Received:");

        jLabelTotalBloodAmountViewB.setText("jLabel5");

        jLabelTotalNumDonorViewB.setText("jLabel6");

        jLabelTotalNumDonorB.setText("Total Number of Donor:");

        jTable_BloodTableAB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC Num", "Name", "Gender", "Age", "Blood Type", "Donated Amount"
            }
        ));
        jScrollPane8.setViewportView(jTable_BloodTableAB);

        jLabelTotalNumDonorViewAB.setText("jLabel6");

        jLabelTotalNumDonorAB.setText("Total Number of Donor:");

        jLabelTotalBloodAmountViewAB.setText("jLabel5");

        jLabelTotalBloodAmountAB.setText("Total Amount of Blood Received:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Blood Type: AB");

        jTable_BloodTableO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IC Num", "Name", "Gender", "Age", "Blood Type", "Donated Amount"
            }
        ));
        jScrollPane9.setViewportView(jTable_BloodTableO);

        jLabelTotalNumDonorViewO.setText("jLabel6");

        jLabelTotalNumDonorO.setText("Total Number of Donor:");

        jLabelTotalBloodAmountO.setText("Total Amount of Blood Received:");

        jLabelTotalBloodAmountViewO.setText("jLabel5");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Blood Type: O");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDonorHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDonorGuestBackButton1)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalBloodAmountA)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalBloodAmountViewA))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalNumDonorA)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalNumDonorViewA))
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalBloodAmountB)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalBloodAmountViewB))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalNumDonorB)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalNumDonorViewB))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalNumDonorAB)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalNumDonorViewAB))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalBloodAmountAB)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalBloodAmountViewAB))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalNumDonorO)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalNumDonorViewO))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelTotalBloodAmountO)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTotalBloodAmountViewO))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtDonorGuestCampaignID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDonorGuestBackButton1)
                        .addGap(46, 46, 46)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalBloodAmountAB)
                            .addComponent(jLabelTotalBloodAmountViewAB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalNumDonorAB)
                            .addComponent(jLabelTotalNumDonorViewAB))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalBloodAmountO)
                            .addComponent(jLabelTotalBloodAmountViewO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalNumDonorO)
                            .addComponent(jLabelTotalNumDonorViewO))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDonorHeader)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDonorGuestCampaignID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalBloodAmountA)
                            .addComponent(jLabelTotalBloodAmountViewA))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalNumDonorA)
                            .addComponent(jLabelTotalNumDonorViewA))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalBloodAmountB)
                            .addComponent(jLabelTotalBloodAmountViewB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalNumDonorB)
                            .addComponent(jLabelTotalNumDonorViewB))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDonorGuestBackButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonorGuestBackButton1ActionPerformed
        this.toBack();
        Cmp leaveInfo = new Cmp();
        leaveInfo.setVisible(false);
        leaveInfo.toFront(); //go to campaign interface
    }//GEN-LAST:event_btnDonorGuestBackButton1ActionPerformed

    private void txtDonorGuestCampaignIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonorGuestCampaignIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonorGuestCampaignIDActionPerformed

    private void jTable_BloodTableAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_BloodTableAMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_BloodTableAMouseClicked

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
            java.util.logging.Logger.getLogger(BloodList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BloodList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BloodList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BloodList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BloodList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDonorGuestBackButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelTotalBloodAmountA;
    private javax.swing.JLabel jLabelTotalBloodAmountAB;
    private javax.swing.JLabel jLabelTotalBloodAmountB;
    private javax.swing.JLabel jLabelTotalBloodAmountO;
    private javax.swing.JLabel jLabelTotalBloodAmountViewA;
    private javax.swing.JLabel jLabelTotalBloodAmountViewAB;
    private javax.swing.JLabel jLabelTotalBloodAmountViewB;
    private javax.swing.JLabel jLabelTotalBloodAmountViewO;
    private javax.swing.JLabel jLabelTotalNumDonorA;
    private javax.swing.JLabel jLabelTotalNumDonorAB;
    private javax.swing.JLabel jLabelTotalNumDonorB;
    private javax.swing.JLabel jLabelTotalNumDonorO;
    private javax.swing.JLabel jLabelTotalNumDonorViewA;
    private javax.swing.JLabel jLabelTotalNumDonorViewAB;
    private javax.swing.JLabel jLabelTotalNumDonorViewB;
    private javax.swing.JLabel jLabelTotalNumDonorViewO;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable_BloodTableA;
    private javax.swing.JTable jTable_BloodTableAB;
    private javax.swing.JTable jTable_BloodTableB;
    private javax.swing.JTable jTable_BloodTableO;
    private javax.swing.JLabel lblDonorHeader;
    private javax.swing.JTextField txtDonorGuestCampaignID;
    // End of variables declaration//GEN-END:variables
}
