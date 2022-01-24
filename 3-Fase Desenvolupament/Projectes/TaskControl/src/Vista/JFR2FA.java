/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Victor
 */
public class JFR2FA extends javax.swing.JFrame {

    private int xMouse, yMouse;

    /**
     * Creates new form JFR2FA
     */
    public JFR2FA() {
        initComponents();
        this.setSize(new Dimension(1380, 868));
        Image icono = Toolkit.getDefaultToolkit().getImage("src/images/ezgif.com-gif-maker.png");

        // Define el icono
        this.setIconImage(icono);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        IconMinMaxClose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnEntrar1 = new javax.swing.JButton();
        txtVer = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setUndecorated(true);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setForeground(new java.awt.Color(51, 51, 51));
        jPanel4.setPreferredSize(new java.awt.Dimension(1415, 1027));

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-gif-maker.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Control Tasques");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Header.setBackground(new java.awt.Color(0, 51, 204));
        Header.setPreferredSize(new java.awt.Dimension(800, 50));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });
        Header.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 204));
        jPanel2.setForeground(new java.awt.Color(0, 51, 204));
        jPanel2.setLayout(new java.awt.BorderLayout());
        Header.add(jPanel2, java.awt.BorderLayout.LINE_START);

        IconMinMaxClose.setBackground(new java.awt.Color(255, 255, 255));
        IconMinMaxClose.setForeground(new java.awt.Color(255, 255, 255));
        IconMinMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonClose.setBackground(new java.awt.Color(0, 51, 204));
        ButtonClose.setLayout(new java.awt.BorderLayout());

        Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        Close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CloseMouseExited(evt);
            }
        });
        ButtonClose.add(Close, java.awt.BorderLayout.CENTER);

        IconMinMaxClose.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        ButtonMax.setBackground(new java.awt.Color(0, 51, 204));
        ButtonMax.setLayout(new java.awt.BorderLayout());

        Max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expand.png"))); // NOI18N
        Max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MaxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MaxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MaxMouseExited(evt);
            }
        });
        ButtonMax.add(Max, java.awt.BorderLayout.CENTER);

        IconMinMaxClose.add(ButtonMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        ButtonMin.setBackground(new java.awt.Color(0, 51, 204));
        ButtonMin.setLayout(new java.awt.BorderLayout());

        Min.setBackground(new java.awt.Color(0, 51, 204));
        Min.setForeground(new java.awt.Color(0, 51, 204));
        Min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png"))); // NOI18N
        Min.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinMouseExited(evt);
            }
        });
        ButtonMin.add(Min, java.awt.BorderLayout.CENTER);

        IconMinMaxClose.add(ButtonMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        Header.add(IconMinMaxClose, java.awt.BorderLayout.LINE_END);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Autentificació de doble factor");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 930, 61));

        jLabel2.setBackground(new java.awt.Color(255, 153, 51));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Codi de verificació:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 190, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 330, 10));

        btnEntrar1.setBackground(new java.awt.Color(160, 160, 160));
        btnEntrar1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnEntrar1.setForeground(new java.awt.Color(0, 0, 0));
        btnEntrar1.setText("Entrar");
        btnEntrar1.setBorder(null);
        btnEntrar1.setBorderPainted(false);
        btnEntrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEntrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEntrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEntrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 620, 260, 50));

        txtVer.setBackground(new java.awt.Color(255, 255, 255));
        txtVer.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtVer.setForeground(new java.awt.Color(0, 0, 0));
        txtVer.setBorder(null);
        jPanel1.add(txtVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 320, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 971, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1381, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1380, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 0, 51));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(0, 51, 204));
    }//GEN-LAST:event_CloseMouseExited

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != JFPrincipal.MAXIMIZED_BOTH) {
            this.setExtendedState(JFPrincipal.MAXIMIZED_BOTH);

        } else {
            this.setExtendedState(JFPrincipal.NORMAL);

        }
    }//GEN-LAST:event_MaxMouseClicked

    public void changecolor(JPanel hover, Color rand) {

        hover.setBackground(rand);

    }
    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color(160, 160, 160));
    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:

        changecolor(ButtonMax, new Color(0, 51, 204));
    }//GEN-LAST:event_MaxMouseExited

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color(160, 160, 160));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color(0, 51, 204));
    }//GEN-LAST:event_MinMouseExited

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:

        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void btnEntrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEntrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFR2FA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFR2FA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFR2FA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFR2FA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFR2FA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JPanel ButtonMin;
    public javax.swing.JLabel Close;
    public javax.swing.JPanel Header;
    public javax.swing.JPanel IconMinMaxClose;
    public javax.swing.JLabel Max;
    public javax.swing.JLabel Min;
    public javax.swing.JButton btnEntrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTextField txtVer;
    // End of variables declaration//GEN-END:variables
}
