
package com.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import com.model.myConnect;
import java.io.IOException;

/**
 *
 * @author phixuanhoan
 */
public class formLogin extends javax.swing.JFrame {
    private String username;                            
    char[] password;
    private String typeUser;
    public static myConnect myconnect = new myConnect();
    ArrayList infoUserDB              = new ArrayList();
    String filePath                   = "public/username.txt";
    String fullname;
    /**
     * Creates new form formLogin
     */
    public formLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        File file1 = new File(filePath);
        if(file1.exists()){
            try {
                String text = "";
                BufferedReader stdin = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf8"));
                while (stdin.ready()) {
                    text = stdin.readLine();
                }
                String[] temp = text.split(":");
                typeUser=temp[2].trim();
                fullname=temp[3].trim();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Tồn tại tập tin nhưng không đọc được !");
            }
                 
            SwingUtilities.invokeLater(() -> {
                JFrame formMain = new formMain(typeUser, fullname);
                formMain.setVisible(true); //hiện giao diện
                formLogin.super.dispose();
            });
        }
        
        //Border
        txtPassword.setBorder(formMain.brdr_s);
        txtUsername.setBorder(formMain.brdr_s);
        lblTitle.setBorder(formMain.brdr_s);
        lblTitle1.setBorder(formMain.brdr_s);
        lblTitle4.setBorder(formMain.brdr_s);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSaveLogin = new javax.swing.JCheckBox();
        lblCheckUsername = new javax.swing.JLabel();
        lblCheckPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        lblTitle.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Đăng nhập vào hệ thống");
        lblTitle.setToolTipText("");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTitle.setOpaque(true);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        lblRegister.setForeground(new java.awt.Color(255, 0, 0));
        lblRegister.setText("Tạo tài khoản");
        lblRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/man key.png"))); // NOI18N

        cbSaveLogin.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        cbSaveLogin.setText("ghi nhớ tài khoản");
        cbSaveLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblCheckUsername.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblCheckUsername.setForeground(new java.awt.Color(255, 51, 0));

        lblCheckPassword.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblCheckPassword.setForeground(new java.awt.Color(255, 51, 0));

        lblTitle1.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle1.setFont(new java.awt.Font("ITF Devanagari Marathi", 0, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Username");
        lblTitle1.setToolTipText("");
        lblTitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTitle1.setOpaque(true);

        lblTitle4.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle4.setFont(new java.awt.Font("ITF Devanagari Marathi", 0, 18)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle4.setText("Password");
        lblTitle4.setToolTipText("");
        lblTitle4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTitle4.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbSaveLogin))
                            .addComponent(txtPassword)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                            .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCheckUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCheckPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(32, 32, 32)
                        .addComponent(lblCheckUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCheckPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbSaveLogin)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGap(26, 26, 26)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    * FUNCTION click login
    */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        boolean checkUser = true;
        boolean checkPass = true;
        if(txtUsername.getText().equals("")){
            lblCheckUsername.setText("Username không được rỗng");
            checkUser = false;
        }else{
            lblCheckUsername.setText("");
            checkUser = true;
        }
        if(txtPassword.getPassword().length == 0){
            lblCheckPassword.setText("Password không được rỗng");
            checkPass = false;
        }else{
            lblCheckPassword.setText("");
            checkPass = true;
        }
        if(checkUser == true && checkPass == true){
                infoUserDB.clear();
                infoUserDB = myconnect.getInfoUser(txtUsername.getText().trim());
                if(infoUserDB.isEmpty()){
                lblCheckUsername.setText("username hoặc password không tồn tại !");
                txtUsername.setText("");
                txtPassword.setText("");
                txtUsername.setFocusable(true);
                checkPass = false;
                checkUser = false;
            }else{
                username = infoUserDB.get(1).toString();
                String passwordDB = infoUserDB.get(2).toString();
                password = passwordDB.toCharArray();
                typeUser = infoUserDB.get(3).toString();
                fullname = infoUserDB.get(4).toString();
                if(txtUsername.getText().equals(username) && Arrays.equals(txtPassword.getPassword(),password)){
                    JOptionPane.showMessageDialog(null,"Xin chào: " + fullname);
                    if(cbSaveLogin.isSelected() == true){
                        try {
                            File file = new File(filePath);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            Writer writer = new java.io.OutputStreamWriter(fileOutputStream, "utf8");
                            BufferedWriter bw = new BufferedWriter(writer);
                            bw.write(username + ":"); bw.write(passwordDB + ":");
                            bw.write(typeUser + ":"); bw.write(fullname);
                            bw.close();
                        } catch (IOException e) {
                            JOptionPane.showMessageDialog(null, "Ghi file thất bại");
                        }
                    }
                    this.setVisible(false);
                    SwingUtilities.invokeLater(() -> {
                        JFrame formMain = new formMain(typeUser,fullname);
                        formMain.setVisible(true); //hiện giao diện 
                    });
                }else{
                    lblCheckUsername.setText("username hoặc password không tồn tại !");
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtUsername.setFocusable(true);
                    checkPass   = false;
                    checkUser   = false;
                }
            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        this.dispose();
        SwingUtilities.invokeLater(() -> {
            JFrame formregister  = new formRegister();
            formregister.setVisible(true); //hiện giao diện 
        });
    }//GEN-LAST:event_lblRegisterMouseClicked

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
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new formLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cbSaveLogin;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCheckPassword;
    private javax.swing.JLabel lblCheckUsername;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
