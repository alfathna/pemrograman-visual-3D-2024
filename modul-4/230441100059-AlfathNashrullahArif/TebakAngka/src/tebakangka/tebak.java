/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tebakangka;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class tebak extends javax.swing.JFrame {
    int kesempatan = 10;
    Random angkaTebakan = new Random();
    int tebakan = angkaTebakan.nextInt(100) + 1; 
    
    /**
     * Creates new form tebak
     */
    public tebak() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtScore.setEditable(false);
        txtJawaban.setEditable(false);   
    }
    
    private void resetGame() {
        btnTebak.setEnabled(true);
        kesempatan = 10;
        tebakan = angkaTebakan.nextInt(100) + 1; 
        btnTebak.setText("Tebak (" + kesempatan + ")");
        txtTebak.setText("");
        txtJawaban.setText(""); 
        txtScore.setText("0"); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPane = new javax.swing.JTabbedPane();
        Game = new javax.swing.JPanel();
        ptop = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pCenter = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTebak = new javax.swing.JTextField();
        txtJawaban = new javax.swing.JTextField();
        txtScore = new javax.swing.JTextField();
        btnTebak = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        pBottom = new javax.swing.JPanel();
        btnKeluar1 = new javax.swing.JButton();
        Score = new javax.swing.JPanel();
        pTop = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnKeluar2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        scoreList = new java.awt.List();
        resetList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Game.setLayout(new java.awt.BorderLayout());

        ptop.setBackground(new java.awt.Color(0, 60, 67));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakangka/mouse.png"))); // NOI18N
        ptop.add(jLabel2);

        jLabel1.setFont(new java.awt.Font("Schadow BT", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(227, 254, 247));
        jLabel1.setText("TEBAK ANGKA");
        ptop.add(jLabel1);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakangka/game.png"))); // NOI18N
        ptop.add(jLabel3);

        Game.add(ptop, java.awt.BorderLayout.PAGE_START);

        pCenter.setBackground(new java.awt.Color(119, 176, 170));

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText("Tebak Angka 1 - 100");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel5.setText("Tebak Angka");

        jLabel6.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel6.setText("Jawaban");

        jLabel7.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jLabel7.setText("Score");

        txtScore.setText("0");

        btnTebak.setBackground(new java.awt.Color(51, 51, 255));
        btnTebak.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        btnTebak.setText("Tebak (10)");
        btnTebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTebakActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(51, 51, 255));
        btnReset.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pCenterLayout = new javax.swing.GroupLayout(pCenter);
        pCenter.setLayout(pCenterLayout);
        pCenterLayout.setHorizontalGroup(
            pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCenterLayout.createSequentialGroup()
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pCenterLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4))
                    .addGroup(pCenterLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(51, 51, 51)
                        .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJawaban, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTebak, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pCenterLayout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnTebak)
                        .addGap(42, 42, 42)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        pCenterLayout.setVerticalGroup(
            pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pCenterLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTebak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtJawaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtScore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTebak)
                    .addComponent(btnReset))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        Game.add(pCenter, java.awt.BorderLayout.CENTER);

        pBottom.setBackground(new java.awt.Color(19, 93, 102));
        pBottom.setMinimumSize(new java.awt.Dimension(412, 38));
        pBottom.setPreferredSize(new java.awt.Dimension(445, 48));
        pBottom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKeluar1.setBackground(new java.awt.Color(255, 0, 0));
        btnKeluar1.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        btnKeluar1.setText("Exit");
        btnKeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluar1ActionPerformed(evt);
            }
        });
        pBottom.add(btnKeluar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        Game.add(pBottom, java.awt.BorderLayout.PAGE_END);

        TabbedPane.addTab("Game", Game);

        Score.setLayout(new java.awt.BorderLayout());

        pTop.setBackground(new java.awt.Color(0, 60, 67));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakangka/mouse.png"))); // NOI18N
        pTop.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Schadow BT", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(227, 254, 247));
        jLabel10.setText("SCORE");
        pTop.add(jLabel10);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tebakangka/game.png"))); // NOI18N
        pTop.add(jLabel11);

        Score.add(pTop, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(19, 93, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(445, 48));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKeluar2.setBackground(new java.awt.Color(255, 0, 0));
        btnKeluar2.setFont(new java.awt.Font("Segoe UI Historic", 0, 13)); // NOI18N
        btnKeluar2.setText("Exit");
        btnKeluar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnKeluar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        Score.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(119, 176, 170));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setViewportView(scoreList);

        resetList.setBackground(new java.awt.Color(51, 51, 255));
        resetList.setText("Delete List");
        resetList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(resetList)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(resetList)
                .addGap(29, 29, 29))
        );

        Score.add(jPanel2, java.awt.BorderLayout.CENTER);

        TabbedPane.addTab("Score", Score);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTebakActionPerformed
        // TODO add your handling code here:
        System.out.println(tebakan);
        try {
            if (txtTebak.getText().isEmpty()) {
                ImageIcon icon = new ImageIcon(tebak.class.getResource("Swindah.gif").getFile());
                JOptionPane.showMessageDialog(null, "MASUKKAN TEBAKAN TERLEBIH DAHULU",
                        "INFORMATIONS",JOptionPane.INFORMATION_MESSAGE, icon);
            return; 
            }
            
            int inputTebak = Integer.parseInt(txtTebak.getText());
            
            if (inputTebak < 1 || inputTebak > 100) {
                JOptionPane.showMessageDialog(null, "TEBAKAN HARUS BERADA DI ANTARA 1 DAN 100");
                return; 
            }

            if (tebakan > inputTebak) {
                kesempatan--;
                txtJawaban.setText("Angka Tebakan Lebih Besar");
            } else if (tebakan < inputTebak) {
                kesempatan--;
                txtJawaban.setText("Angka Tebakan Lebih Kecil");
            } else {
                int hasil = kesempatan * 10;
                txtJawaban.setText("Selamat! Anda Menebak: " + tebakan);
                txtScore.setText(String.valueOf(hasil));
                
                ImageIcon icon = new ImageIcon(tebak.class.getResource("Wwindah.gif").getFile());
                JOptionPane.showMessageDialog(null, "SELAMAT !!!\nTEBAKAN ANDA BENAR",
                        "CONGRATS",JOptionPane.INFORMATION_MESSAGE, icon);

                String nama = JOptionPane.showInputDialog(null, "SILAKAN MASUKAN NAMA");

                while (nama == null || nama.isEmpty()){
                    JOptionPane.showMessageDialog(null, "NAMA TIDAK BOLEH KOSONG!", 
                            "Kesalahan", JOptionPane.WARNING_MESSAGE);
                    nama = JOptionPane.showInputDialog(null, "SILAKAN MASUKAN NAMA");
                }
                
                scoreList.add("Nama : " + nama + "-" + "Score : " + hasil);
                scoreList.repaint();
                
                tebakan = angkaTebakan.nextInt(100) + 1; 
            }

            btnTebak.setText("Tebak (" + kesempatan + ")");
            if (kesempatan == 0) {
                ImageIcon icon = new ImageIcon(tebak.class.getResource("Lwindah.gif").getFile());
                JOptionPane.showMessageDialog(null, "KESEMPATAN ANDA HABIS,\nANGKA YANG BENAR ADALAH " + tebakan,
                        "FAILED", JOptionPane.INFORMATION_MESSAGE, icon);
                btnTebak.setEnabled(false);
                resetGame();
            }
        } catch (NumberFormatException e) {
            ImageIcon icon = new ImageIcon(tebak.class.getResource("Swindah.gif").getFile());
            JOptionPane.showMessageDialog(null, "TEBAKAN HARUS BERUPA ANGKA", 
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_btnTebakActionPerformed
    
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int Reset = JOptionPane.showConfirmDialog(null,"INGIN RESET ?","RESET",JOptionPane.YES_NO_OPTION);
        if (Reset == JOptionPane.YES_OPTION) {
            resetGame();
        } else if (Reset == JOptionPane.NO_OPTION){} 
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluar1ActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"KELUAR PERMAINAN ?","KELUAR",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluar1ActionPerformed

    private void btnKeluar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluar2ActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"KELUAR PERMAINAN ?","KELUAR",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluar2ActionPerformed

    private void resetListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetListActionPerformed
        // TODO add your handling code here:
        int rList = JOptionPane.showConfirmDialog(null,"HAPUS LIST ?","DELETE",JOptionPane.YES_NO_OPTION);
        if (rList == JOptionPane.YES_OPTION) {
            scoreList.removeAll();
        }
    }//GEN-LAST:event_resetListActionPerformed

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
            java.util.logging.Logger.getLogger(tebak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tebak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tebak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tebak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tebak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Game;
    private javax.swing.JPanel Score;
    private javax.swing.JTabbedPane TabbedPane;
    private javax.swing.JButton btnKeluar1;
    private javax.swing.JButton btnKeluar2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTebak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pBottom;
    private javax.swing.JPanel pCenter;
    private javax.swing.JPanel pTop;
    private javax.swing.JPanel ptop;
    private javax.swing.JButton resetList;
    private java.awt.List scoreList;
    private javax.swing.JTextField txtJawaban;
    private javax.swing.JTextField txtScore;
    private javax.swing.JTextField txtTebak;
    // End of variables declaration//GEN-END:variables
}