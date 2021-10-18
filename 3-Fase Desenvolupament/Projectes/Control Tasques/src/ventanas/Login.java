/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.sql.*;
import clases.Conexio;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Login extends javax.swing.JFrame {

    boolean a = true;
    public static String usuari = "";
    String contraseña = "";
    private int xMouse,yMouse;
    
    /**
     * Creates new form Ventana_Tasques2
     */
    public Login() {
        initComponents();
        ImageIcon delete_logo = new ImageIcon("src/images/delete_32px.png");        
        Close.setIcon(delete_logo);
        this.repaint();
        
        ImageIcon max_logo = new ImageIcon("src/images/full_screen_32px.png");        
        Max.setIcon(max_logo);
        this.repaint();
        
        ImageIcon min_logo = new ImageIcon("src/images/icons8-compress-30.png");        
        Min.setIcon(min_logo);
        this.repaint();   
        
        ImageIcon logo_logo = new ImageIcon("src/images/ezgif.com-gif-maker.png");        
        logo.setIcon(logo_logo);
        this.repaint();
        
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Resize = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        IconMinMaxClose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Entrar1 = new javax.swing.JButton();
        jButton_Entrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txt_contraseña = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        txt_usuari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Resize.setBackground(new java.awt.Color(255, 255, 255));
        Resize.setLayout(new java.awt.BorderLayout());

        Header.setBackground(new java.awt.Color(255, 153, 51));
        Header.setMinimumSize(new java.awt.Dimension(200, 50));
        Header.setPreferredSize(new java.awt.Dimension(1050, 50));
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

        IconMinMaxClose.setBackground(new java.awt.Color(255, 153, 0));
        IconMinMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButtonClose.setBackground(new java.awt.Color(255, 153, 0));
        ButtonClose.setLayout(new java.awt.BorderLayout());

        Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        ButtonMax.setBackground(new java.awt.Color(255, 153, 0));
        ButtonMax.setLayout(new java.awt.BorderLayout());

        Max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        ButtonMin.setBackground(new java.awt.Color(255, 153, 0));
        ButtonMin.setLayout(new java.awt.BorderLayout());

        Min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ButtonMin.add(Min, java.awt.BorderLayout.CENTER);

        IconMinMaxClose.add(ButtonMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        Header.add(IconMinMaxClose, java.awt.BorderLayout.LINE_END);

        Resize.add(Header, java.awt.BorderLayout.PAGE_START);

        Left.setBackground(new java.awt.Color(255, 153, 51));
        Left.setPreferredSize(new java.awt.Dimension(400, 400));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        Resize.add(Left, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(650, 525));

        jLabel3.setBackground(new java.awt.Color(255, 153, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sessió");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setBackground(new java.awt.Color(255, 153, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 51));
        jLabel5.setText("Usuari");

        jLabel2.setBackground(new java.awt.Color(255, 153, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 51));
        jLabel2.setText("Contrasenya");

        jButton_Entrar1.setBackground(new java.awt.Color(255, 153, 51));
        jButton_Entrar1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Entrar1.setText("Entrar");
        jButton_Entrar1.setBorder(null);
        jButton_Entrar1.setBorderPainted(false);
        jButton_Entrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton_Entrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Entrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Entrar1ActionPerformed(evt);
            }
        });

        jButton_Entrar.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Entrar.setForeground(new java.awt.Color(255, 153, 51));
        jButton_Entrar.setText("No teniu un compte? Registra't aquí ");
        jButton_Entrar.setBorder(null);
        jButton_Entrar.setBorderPainted(false);
        jButton_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EntrarActionPerformed(evt);
            }
        });

        txt_contraseña.setBackground(new java.awt.Color(255, 255, 255));
        txt_contraseña.setForeground(new java.awt.Color(153, 153, 153));
        txt_contraseña.setBorder(null);

        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txt_usuari.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuari.setForeground(new java.awt.Color(153, 153, 153));
        txt_usuari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuari.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(70, 70, 70))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(txt_usuari)
                .addGap(160, 160, 160))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(80, 80, 80))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(txt_contraseña)
                .addGap(160, 160, 160))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jSeparator1)
                .addGap(160, 160, 160))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jButton_Entrar, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(180, 180, 180))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jButton_Entrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(170, 170, 170))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(txt_usuari, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(txt_contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jButton_Entrar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(jButton_Entrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(65, 65, 65))
        );

        Resize.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Resize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Resize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(1050, 575));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EntrarActionPerformed

        dispose();
        new Ventana_Registrar().setVisible(true);
    }//GEN-LAST:event_jButton_EntrarActionPerformed

    private void jButton_Entrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Entrar1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        usuari = txt_usuari.getText().trim();
        contraseña = txt_contraseña.getText().trim();

        if (usuari.equals("") || !contraseña.equals("")){

            try{
                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "select nivell from Usuaris where usuari = '" + usuari + " ' and contrassenya = '" + contraseña + "'");

                ResultSet rs = pst.executeQuery();

                if (rs.next()){

                    String nivell = rs.getString("nivell");
                    if (nivell.equalsIgnoreCase("Administrador")){
                        dispose();
                        new Ventana_Tasques().setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null, "Dades d'inici de sessió incorrectes");
                        txt_usuari.setText("");
                        txt_contraseña.setText("");

                    };

                }else{
                    JOptionPane.showMessageDialog(null, "Dades d'inici de sessió incorrectes");
                    txt_usuari.setText("");
                    txt_contraseña.setText("");

                }

            }catch(SQLException e){
                System.err.println("Error en el boto ENTRAR" + e);
                JOptionPane.showMessageDialog(null, "Error d'inici de sessió. Contacta amb l'administrador");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
        }
    }//GEN-LAST:event_jButton_Entrar1ActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();

    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);

    }//GEN-LAST:event_HeaderMouseDragged

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color (255,153,0));
    }//GEN-LAST:event_MaxMouseExited

    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color (255,204,102));
    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        if(this.getExtendedState()!= Ventana_Tasques2.MAXIMIZED_BOTH){
            this.setExtendedState(Ventana_Tasques2.MAXIMIZED_BOTH);

        }else{
            this.setExtendedState(Ventana_Tasques2.NORMAL);

        }
    }//GEN-LAST:event_MaxMouseClicked

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color (255,153,0));
    }//GEN-LAST:event_CloseMouseExited

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color (255,204,102));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked
    
    //Canviar el color de les icones
    public void changecolor(JPanel hover, Color rand){
        
        hover.setBackground(rand);
    
    }
    
    
    
   
    
   
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JPanel ButtonMin;
    private javax.swing.JLabel Close;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel IconMinMaxClose;
    private javax.swing.JPanel Left;
    private javax.swing.JLabel Max;
    private javax.swing.JLabel Min;
    private javax.swing.JPanel Resize;
    private javax.swing.JButton jButton_Entrar;
    private javax.swing.JButton jButton_Entrar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_usuari;
    // End of variables declaration//GEN-END:variables
}
