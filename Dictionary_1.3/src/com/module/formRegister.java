package com.module;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author phixuanhoan
 */
public class formRegister extends javax.swing.JFrame {
    /**
     * Creates new form formRegister
     */
    public formRegister() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblTitle.setBorder(formMain.brdr_s);
        txtEmail.setBorder(formMain.brdr_s);
        txtFullname.setBorder(formMain.brdr_s);
        txtPassword.setBorder(formMain.brdr_s);
        txtUsername.setBorder(formMain.brdr_s);
        lblTitle1.setBorder(formMain.brdr_s);
        lblTitle2.setBorder(formMain.brdr_s);
        lblTitle5.setBorder(formMain.brdr_s);
        lblTitle4.setBorder(formMain.brdr_s);


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblTitle1 = new javax.swing.JLabel();
        lblTitle2 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblTitle4 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblTitle5 = new javax.swing.JLabel();
        lblFullname = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register form");

        lblTitle.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Đăng kí tài khoản");
        lblTitle.setToolTipText("");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle.setOpaque(true);

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.setToolTipText("");

        lblTitle1.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle1.setFont(new java.awt.Font("ITF Devanagari Marathi", 0, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("Username");
        lblTitle1.setToolTipText("");
        lblTitle1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle1.setOpaque(true);

        lblTitle2.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle2.setFont(new java.awt.Font("ITF Devanagari", 0, 18)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("Password");
        lblTitle2.setToolTipText("");
        lblTitle2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle2.setOpaque(true);

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setToolTipText("");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.setToolTipText("");

        lblTitle4.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle4.setFont(new java.awt.Font("ITF Devanagari", 0, 18)); // NOI18N
        lblTitle4.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle4.setText("Fullname");
        lblTitle4.setToolTipText("");
        lblTitle4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle4.setOpaque(true);

        txtFullname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFullname.setToolTipText("");

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Đăng kí");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblUser.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 0, 0));
        lblUser.setText("Username có ít nhất 6 kí tự");

        lblEmail.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 0, 0));

        lblPass.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblPass.setForeground(new java.awt.Color(255, 0, 0));
        lblPass.setText("Password chứa 6-8 kí tự(ít nhất 1 ký tự in hoa, 1 kí tự đặc biệt)");

        lblTitle5.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle5.setFont(new java.awt.Font("ITF Devanagari", 0, 18)); // NOI18N
        lblTitle5.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle5.setText("Email");
        lblTitle5.setToolTipText("");
        lblTitle5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle5.setOpaque(true);

        lblFullname.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblFullname.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(12, 12, 12)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPass, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean checkUser = true, checkPass = true, checkEmail = true, checkFullname = true;
        if (txtUsername.getText().equals("")) {
            lblUser.setText("Username không được rỗng");
            checkUser = false;
        } else {
            if (txtUsername.getText().length() < 6) {
                lblUser.setText("Username có ít nhất 6 ký tự");
                checkUser = false;
                txtUsername.setText("");
            } else {
                lblUser.setText("");
            }
        }
        if (txtPassword.getText().equals("")) {
            lblPass.setText("Password không được rỗng");
            checkPass = false;
        } else {
            String pattern = "^(?=.*\\d)(?=.*[A-Z])(?=.*\\W).{6,8}$";
            if (txtPassword.getText().matches(pattern) == false) {
                lblPass.setText("Password không hợp lệ");
                checkPass = false;
                txtPassword.setText("");
            } else {
                lblPass.setText("");
            }
        }
        if (txtFullname.getText().equals("")) {
            lblFullname.setText("Fullname không được rỗng");
            checkFullname = false;
        }
        if (txtEmail.getText().equals("")) {
            lblEmail.setText("Email không được rỗng");
            checkEmail = false;
        } else {
            String pattern = "^[a-z][a-z0-9_\\.]{4,31}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
            if (txtEmail.getText().matches(pattern) == false) {
                lblEmail.setText("Email chưa nhập đúng định dạng");
                checkPass = false;
                txtEmail.setText("");
            } else {
                lblEmail.setText("");
            }
        }
        if (checkEmail == true && checkFullname == true && checkPass == true && checkUser == true) {
            if (!formLogin.myconnect.getInfoUser(txtUsername.getText()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tên đăng nhập này đã tồn tại vui lòng chọn tên đăng nhập khác");
                txtUsername.setText("");
                txtUsername.setFocusable(true);
            } else {
                formLogin.myconnect.insertUser(txtUsername.getText(), txtPassword.getText(), txtFullname.getText(), txtEmail.getText());
                JOptionPane.showMessageDialog(null, "Đăng kí tài khoản thành công");
                this.dispose();
                SwingUtilities.invokeLater(() -> {
                    JFrame formlogin = new formLogin();
                    formlogin.setVisible(true); //hiện giao diện 
                });
            }

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullname;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblTitle4;
    private javax.swing.JLabel lblTitle5;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
