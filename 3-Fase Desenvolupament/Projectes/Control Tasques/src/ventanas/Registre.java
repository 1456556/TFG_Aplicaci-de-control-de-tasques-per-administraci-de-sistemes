/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import clases.Conexio;
import java.awt.Color;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author Victor
 */
public class Registre extends javax.swing.JFrame {

    
    private int xMouse,yMouse;
    
    /**
     * Creates new form Registre
     */
    public Registre() {
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
        Registre = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
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

        Registre.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 153, 51));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 153, 51));
        jLabel4.setText("Registrar-se");

        txt_mail.setBackground(new java.awt.Color(255, 255, 255));
        txt_mail.setForeground(new java.awt.Color(153, 153, 153));
        txt_mail.setBorder(null);

        jLabel6.setBackground(new java.awt.Color(255, 153, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("Cognom");

        jLabel7.setBackground(new java.awt.Color(255, 153, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 51));
        jLabel7.setText("Email");

        jButton_Registar.setBackground(new java.awt.Color(255, 153, 51));
        jButton_Registar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registar.setText("Registar");
        jButton_Registar.setBorder(null);
        jButton_Registar.setBorderPainted(false);
        jButton_Registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistarActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 153, 51));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("Usuari");

        jLabel9.setBackground(new java.awt.Color(255, 153, 51));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 51));
        jLabel9.setText("Nom");

        txt_nom.setBackground(new java.awt.Color(255, 255, 255));
        txt_nom.setForeground(new java.awt.Color(153, 153, 153));
        txt_nom.setBorder(null);

        txt_cognom.setBackground(new java.awt.Color(255, 255, 255));
        txt_cognom.setForeground(new java.awt.Color(153, 153, 153));
        txt_cognom.setBorder(null);

        jLabel10.setBackground(new java.awt.Color(255, 153, 51));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 51));
        jLabel10.setText("Telèfon");

        txt_telefon.setBackground(new java.awt.Color(255, 255, 255));
        txt_telefon.setForeground(new java.awt.Color(153, 153, 153));
        txt_telefon.setBorder(null);

        txt_contrassenya.setBackground(new java.awt.Color(255, 255, 255));
        txt_contrassenya.setForeground(new java.awt.Color(153, 153, 153));
        txt_contrassenya.setBorder(null);

        jLabel11.setBackground(new java.awt.Color(255, 153, 51));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 153, 51));
        jLabel11.setText("Contrasenya");

        txt_usuari.setBackground(new java.awt.Color(255, 255, 255));
        txt_usuari.setForeground(new java.awt.Color(153, 153, 153));
        txt_usuari.setBorder(null);

        javax.swing.GroupLayout RegistreLayout = new javax.swing.GroupLayout(Registre);
        Registre.setLayout(RegistreLayout);
        RegistreLayout.setHorizontalGroup(
            RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegistreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(txt_cognom, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(txt_usuari, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(160, 160, 160)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(txt_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(txt_contrassenya, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(140, 140, 140)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jButton_Registar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        RegistreLayout.setVerticalGroup(
            RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RegistreLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_cognom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_usuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(RegistreLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(txt_contrassenya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(RegistreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(60, 60, 60)
                    .addComponent(jButton_Registar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Resize.add(Registre, java.awt.BorderLayout.CENTER);

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

       public void changecolor(JPanel hover, Color rand){
        
        hover.setBackground(rand);
    
    }
    
    
    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color (255,204,102));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color (255,153,0));
    }//GEN-LAST:event_CloseMouseExited

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        if(this.getExtendedState()!= Principal.MAXIMIZED_BOTH){
            this.setExtendedState(Principal.MAXIMIZED_BOTH);

        }else{
            this.setExtendedState(Principal.NORMAL);

        }
    }//GEN-LAST:event_MaxMouseClicked

    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color (255,204,102));
    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color (255,153,0));
    }//GEN-LAST:event_MaxMouseExited

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:

        changecolor(ButtonMin, new Color (255,204,102));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color (255,153,0));

    }//GEN-LAST:event_MinMouseExited

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void jButton_RegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistarActionPerformed
        // TODO add your handling code here:
        int validacio = 0;
        String nom, cognom, mail, telefon, usuari, contrassenya, nivell, estat;

        mail = txt_mail.getText().trim();
        nom = txt_nom.getText().trim();
        cognom = txt_cognom.getText().trim();
        telefon = txt_telefon.getText().trim();
        usuari = txt_usuari.getText().trim();
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

            txt_usuari.setBackground(Color.ORANGE.darker());
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
                        new Login().setVisible(true);

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registre().setVisible(true);
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
    private javax.swing.JPanel Registre;
    private javax.swing.JPanel Resize;
    private javax.swing.JButton jButton_Registar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField txt_cognom;
    private javax.swing.JPasswordField txt_contrassenya;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_telefon;
    private javax.swing.JTextField txt_usuari;
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