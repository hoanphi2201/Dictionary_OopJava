package com.module;

import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * @author phixuanhoan
 */
public class formProcess extends javax.swing.JFrame {
    private String type;
    private String idUpdate;
    private String word;
    /**
     * Creates new form formAdd
     * @param title
     * @param type
     */
    public formProcess(String title, String type) {
        initComponents();
        this.type = type;
        this.setLocationRelativeTo(null);

        areaExplain.setLineWrap(true);
        areaExplain.setWrapStyleWord(true);

        areaExplain.setLineWrap(true);
        areaExplain.setWrapStyleWord(true);
        lblTitle.setText(title);
        if (type.equals("edit")) {
            ArrayList<String> temp = formMain.myConnect.getInfoWordBySpelling(formMain.selectedWordEdit);
            idUpdate = temp.get(0);
            txtTarget.setText(temp.get(1));
            word = temp.get(1);
            areaExplain.setText(temp.get(2));
        }
        
        //border
        
        lblTitle.setBorder(formMain.brdr_s);
        jLabel5.setBorder(formMain.brdr_s);
        jLabel9.setBorder(formMain.brdr_s);
        txtTarget.setBorder(formMain.brdr_s);
        areaExplain.setBorder(formMain.brdr_b);
        

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTarget = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        btnAddWord = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        areaExplain = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Process");
        setBackground(new java.awt.Color(204, 204, 204));
        setLocation(new java.awt.Point(100, 100));
        setResizable(false);

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("   Từ");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.setName(""); // NOI18N
        jLabel5.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 204, 204));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("   Nghĩa của từ");
        jLabel9.setToolTipText("");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.setOpaque(true);

        txtTarget.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTitle.setBackground(new java.awt.Color(255, 204, 204));
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 153));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Thêm từ mới");
        lblTitle.setToolTipText("");
        lblTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        lblTitle.setOpaque(true);

        btnAddWord.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/save.png"))); // NOI18N
        btnAddWord.setText("Lưu từ");
        btnAddWord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWordActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/images/cancel.png"))); // NOI18N
        btnExit.setText("Cancel");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        areaExplain.setColumns(20);
        areaExplain.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        areaExplain.setRows(10);
        areaExplain.setAutoscrolls(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(btnAddWord, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(areaExplain, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                            .addComponent(txtTarget))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTarget, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(areaExplain, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAddWord, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWordActionPerformed
        String textTarget = txtTarget.getText();
        String textExplain = areaExplain.getText();

        boolean flagAdd = true;
        String Message = "";
        //Validate dữ liệu hợp lệ
        if (textTarget.equals("")) {
            Message += "Từ không được rỗng ! \n";
            flagAdd = false;
        }
        if (textExplain.equals("")) {
            Message += "Nghĩa câu ví dụ không được rỗng! \n";
            flagAdd = false;
        }
        
        if (flagAdd == false) {
            JOptionPane.showMessageDialog(null, Message);
        } else {
            ArrayList checkExistWord = formMain.myConnect.getInfoWordBySpelling(textTarget.trim());
            if (checkExistWord.size() > 0) {
                JOptionPane.showMessageDialog(null, "Từ này đã tồn tại !");
                checkExistWord.clear();
            } else {
                if (type.equals("add")) {
                    JOptionPane.showMessageDialog(null, "Thêm thành công !");
                    formMain.myConnect.insertData(textTarget, textExplain);   //insert vào database
                    formMain.timer.start();
                } else if (type.equals("edit")) {
                    JOptionPane.showMessageDialog(null, "Sửa từ thành công !");
                    formMain.myConnect.updateData(word,textTarget,textExplain);
                    formMain.selectedWordEdit = txtTarget.getText();
                    formMain.timer.start();
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnAddWordActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaExplain;
    private javax.swing.JButton btnAddWord;
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtTarget;
    // End of variables declaration//GEN-END:variables

    /**
     * @param lblTitle the lblTitle to set
     */
    public void setLblTitle(javax.swing.JLabel lblTitle) {
        this.lblTitle = lblTitle;
    }

}
