/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;
import clases.Conexio;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Ventana_Registrar extends javax.swing.JFrame {
    
    

    /**
     * Creates new form Ventana_Registrar
     */
    public Ventana_Registrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Registrar");
        setSize(1050,575);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_usuari = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_contraseña = new javax.swing.JPasswordField();
        jButton_Entrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton_Entrar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton_Registar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txt_cognom = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        txt_telefon = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        txt_contrassenya = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        txt_usuari2 = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(238, 112, 82));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(238, 112, 82));
        jLabel3.setText("Iniciar Sessió");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 230, 60));

        txt_usuari.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuari.setForeground(new java.awt.Color(153, 153, 153));
        txt_usuari.setBorder(null);
        jPanel1.add(txt_usuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 310, 30));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 310, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 310, 10));

        txt_contraseña.setBackground(new java.awt.Color(255, 255, 255));
        txt_contraseña.setForeground(new java.awt.Color(153, 153, 153));
        txt_contraseña.setText("jPasswordField1");
        txt_contraseña.setBorder(null);
        jPanel1.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 310, -1));

        jButton_Entrar.setBackground(new java.awt.Color(255, 255, 255));
        jButton_Entrar.setForeground(new java.awt.Color(238, 112, 82));
        jButton_Entrar.setText("No teniu un compte? Registra't aquí ");
        jButton_Entrar.setBorder(null);
        jButton_Entrar.setBorderPainted(false);
        jButton_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EntrarActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 230, 30));

        jLabel5.setBackground(new java.awt.Color(238, 112, 82));
        jLabel5.setForeground(new java.awt.Color(238, 112, 82));
        jLabel5.setText("Usuari");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 150, 30));

        jLabel2.setBackground(new java.awt.Color(238, 112, 82));
        jLabel2.setForeground(new java.awt.Color(238, 112, 82));
        jLabel2.setText("Contrasenya");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 150, 30));

        jButton_Entrar1.setBackground(new java.awt.Color(238, 112, 82));
        jButton_Entrar1.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Entrar1.setText("Entrar");
        jButton_Entrar1.setBorder(null);
        jButton_Entrar1.setBorderPainted(false);
        jButton_Entrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Entrar1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton_Entrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 440, 130, 30));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1050, 575));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(238, 112, 82));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(238, 112, 82));
        jLabel4.setText("Registrar-se");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 230, 60));

        txt_mail.setBackground(new java.awt.Color(255, 255, 255));
        txt_mail.setForeground(new java.awt.Color(153, 153, 153));
        txt_mail.setBorder(null);
        jPanel2.add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 180, 30));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 55, 10, 450));

        jLabel6.setBackground(new java.awt.Color(238, 112, 82));
        jLabel6.setForeground(new java.awt.Color(238, 112, 82));
        jLabel6.setText("Cognom");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 150, 30));

        jLabel7.setBackground(new java.awt.Color(238, 112, 82));
        jLabel7.setForeground(new java.awt.Color(238, 112, 82));
        jLabel7.setText("Email");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 170, 150, 30));

        jButton_Registar.setBackground(new java.awt.Color(238, 112, 82));
        jButton_Registar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registar.setText("Registar");
        jButton_Registar.setBorder(null);
        jButton_Registar.setBorderPainted(false);
        jButton_Registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_Registar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 470, 130, 30));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 170, 10));

        jLabel8.setBackground(new java.awt.Color(238, 112, 82));
        jLabel8.setForeground(new java.awt.Color(238, 112, 82));
        jLabel8.setText("Usuari");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 150, 30));

        jLabel9.setBackground(new java.awt.Color(238, 112, 82));
        jLabel9.setForeground(new java.awt.Color(238, 112, 82));
        jLabel9.setText("Nom");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 150, 30));

        txt_nom.setBackground(new java.awt.Color(255, 255, 255));
        txt_nom.setForeground(new java.awt.Color(153, 153, 153));
        txt_nom.setBorder(null);
        jPanel2.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 170, 30));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 170, 10));

        txt_cognom.setBackground(new java.awt.Color(255, 255, 255));
        txt_cognom.setForeground(new java.awt.Color(153, 153, 153));
        txt_cognom.setBorder(null);
        jPanel2.add(txt_cognom, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 170, 30));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 170, 10));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 170, 10));

        jLabel10.setBackground(new java.awt.Color(238, 112, 82));
        jLabel10.setForeground(new java.awt.Color(238, 112, 82));
        jLabel10.setText("Telèfon");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 150, 30));

        txt_telefon.setBackground(new java.awt.Color(255, 255, 255));
        txt_telefon.setForeground(new java.awt.Color(153, 153, 153));
        txt_telefon.setBorder(null);
        jPanel2.add(txt_telefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 170, 30));
        jPanel2.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 170, 10));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 170, 10));

        txt_contrassenya.setBackground(new java.awt.Color(255, 255, 255));
        txt_contrassenya.setForeground(new java.awt.Color(153, 153, 153));
        txt_contrassenya.setText("jPasswordField1");
        txt_contrassenya.setBorder(null);
        jPanel2.add(txt_contrassenya, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 380, 170, -1));

        jLabel11.setBackground(new java.awt.Color(238, 112, 82));
        jLabel11.setForeground(new java.awt.Color(238, 112, 82));
        jLabel11.setText("Contrasenya");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 340, 150, 30));

        txt_usuari2.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuari2.setForeground(new java.awt.Color(153, 153, 153));
        txt_usuari2.setBorder(null);
        jPanel2.add(txt_usuari2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, 180, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EntrarActionPerformed

        

    }//GEN-LAST:event_jButton_EntrarActionPerformed

    private void jButton_Entrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Entrar1ActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_jButton_Entrar1ActionPerformed

    private void jButton_RegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistarActionPerformed
        // TODO add your handling code here:
        int validacio = 0;
        String nom, cognom, mail, telefon, usuari, contrassenya, nivell, estat;
        
        mail = txt_mail.getText().trim();
        nom = txt_nom.getText().trim();
        cognom = txt_cognom.getText().trim();
        telefon = txt_telefon.getText().trim();
        usuari = txt_usuari2.getText().trim();
        contrassenya = txt_contrassenya.getText().trim();
        nivell = "Administrador";
        estat = "Actiu";
        
      
        
        
        if (mail.equals("")){
        
            txt_mail.setBackground(Color.orange.darker());
            validacio++;
        }
        if (nom.equals("")){
        
            txt_nom.setBackground(Color.ORANGE.darker());
            validacio++;
        }
        if (cognom.equals("")){
        
            txt_cognom.setBackground(Color.ORANGE.darker());
            validacio++;
        }
        if (telefon.equals("")){
        
            txt_telefon.setBackground(Color.ORANGE.darker());
            validacio++;
        }
        if (usuari.equals("")){
        
            txt_usuari2.setBackground(Color.ORANGE.darker());
            validacio++;
        }
        if (contrassenya.equals("")){
        
            txt_contrassenya.setBackground(Color.ORANGE.darker());
            validacio++;
        }
        
        try{
            
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select usuari from Usuaris where usuari = '" + usuari + "'" );
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){            
                txt_usuari.setBackground(Color.red);
                JOptionPane.showMessageDialog(null, "Nom d'usuari no disponible");
                cn.close();
            }else{
                 cn.close();
                 if (validacio == 0){
                     try{
                         
                         Connection cn2 = Conexio.conectar();
                         PreparedStatement pst2 = cn2.prepareStatement("insert into Usuaris values (?,?,?,?,?,?,?,?,?)");
                         pst2.setInt(1,0);
                         pst2.setString(2,nom);
                         pst2.setString(3,cognom);
                         pst2.setString(4,telefon);
                         pst2.setString(5,mail);
                         pst2.setString(6,usuari);
                         pst2.setString(7,contrassenya);
                         pst2.setString(8,nivell);
                         pst2.setString(9,estat);
                         
                         pst2.executeUpdate();
                         cn2.close();
                         
                         Natejar();
                         
                         JOptionPane.showMessageDialog(null, "Registrat amb exit");
                         this.dispose();
                         new Ventana_Login().setVisible(true);
                         
                     }catch (SQLException e){
                         
                         System.err.println("Error en Registrar el Usuari" + e);
                         JOptionPane.showMessageDialog(null, "Error al registar. Contacta amb l'administrador");
                     }
                 
                 }else{
                     NatejarColor();
                     JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps per registrar-te");
                     
                     
                 }
                
            }
        
        }catch (Exception e){
        
            System.err.println("Error en validar el nom d'usuari" + e);
            JOptionPane.showMessageDialog(null,"Error al crear usuari. Contacti amb l'administrador.");
        }
        
        
        
    }//GEN-LAST:event_jButton_RegistarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Registrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Entrar;
    private javax.swing.JButton jButton_Entrar1;
    private javax.swing.JButton jButton_Registar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField txt_cognom;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JPasswordField txt_contrassenya;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_telefon;
    private javax.swing.JTextField txt_usuari;
    private javax.swing.JTextField txt_usuari2;
    // End of variables declaration//GEN-END:variables
    
    public void Natejar(){
    
        txt_mail.setText("");
        txt_usuari.setText("");
        txt_cognom.setText("");
        txt_telefon.setText("");
        txt_contrassenya.setText("");
        txt_nom.setText("");  
    
    
    }
    
    
    public void NatejarColor(){
    
        //txt_usuari.setBackground(Color.WHITE);
        txt_mail.setText("");
        txt_cognom.setText("");
        txt_telefon.setText("");
        txt_contrassenya.setText("");
        txt_nom.setText("");  
    
    
    }




}




