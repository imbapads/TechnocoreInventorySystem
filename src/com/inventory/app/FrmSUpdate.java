/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.app;

import java.awt.Color;

/**
 *
 * @author Pads
 */
public class FrmSUpdate extends javax.swing.JFrame {

    /**
     * Creates new form FrmUAdd
     */
    public FrmSUpdate() {
        initComponents();
           this.getContentPane().setBackground(Color.black);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtCon = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("UPDATE SUPPLIER");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("SUPPLIER ID");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("SUPPLIER NAME");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("CONTACT NO");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("ADDRESS");

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 51, 51));
        btnUpdate.setText("UPDATE");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 51, 51));
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 51, 51));
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 51, 51));
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtID)
                            .addComponent(txtCon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnReset)
                    .addComponent(btnCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         if(SQLiteSupplier.openDB()){
           String SupplierID = this.txtID.getText();
            String SupplierName = this.txtName.getText();
            String con = this.txtCon.getText();
            String address = this.txtAddress.getText();
            String set = "SupplierName="+"'"+SupplierName+"'"+","+"ContactNo="+"'"+con+"'"+","+"Address="+"'"+address+"'";
             
            if(SQLiteSupplier.update("Supplier",set,SupplierID)){
                javax.swing.JOptionPane.showMessageDialog(null, "Supplier has been updated!");
            }
            else{
               
                javax.swing.JOptionPane.showMessageDialog(null, "Error!");
            }
            SQLiteSupplier.closeDB();
        }
//           this.dispose();
//        FrmBrand main = new FrmBrand();
//        main.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String id = txtID.getText();
        
        if(SQLiteSupplier.openDB()){
            String[][] records = SQLiteSupplier.read("Supplier");
            boolean result = false;
            int foundRecord = 0;
            for(int i=0;i<records.length;i++){
                if(records[i][0].equals(id)){
                    result = true;
                    foundRecord = i;
                    break;
                }
            }
            if(result){
                //auto fill here

                txtName.setText(records[foundRecord][1]);
                 txtCon.setText(records[foundRecord][2]);
                txtAddress.setText(records[foundRecord][3]);
               
                
              btnUpdate.setEnabled(true);
                
                javax.swing.JOptionPane.showMessageDialog(null, "Supplier ID found");
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(null, "Supplier ID not found");
            }
            SQLiteSupplier.closeDB();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
        FrmSupplier supplier = new FrmSupplier();
        supplier.setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtID.setText("");
        txtName.setText("");
        txtCon.setText("");
        txtAddress.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSUpdate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSUpdate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCon;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}