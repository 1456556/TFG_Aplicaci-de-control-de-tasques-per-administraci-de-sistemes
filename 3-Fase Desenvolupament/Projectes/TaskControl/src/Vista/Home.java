/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Model.Conexio;
import Model.Login;
import com.mysql.cj.jdbc.Blob;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Go
 */
public class Home extends javax.swing.JFrame {

    int idTasca;

    public Home(int id) {
        initComponents();

        this.idTasca = id;

    }

    public void load_caht(ArrayList resultados) {

        Conexio d = new Conexio();
        String idxat = "";

        try {

            Connection cn = d.getConexio();
            PreparedStatement pst = cn.prepareStatement("SELECT msg FROM Tasques WHERE id_tasca='" + idTasca + "'");
            ResultSet rs = pst.executeQuery();
            String missatge = "";
            while (rs.next()) {
                DefaultListModel cm = new DefaultListModel();
                java.sql.Blob ablob = rs.getBlob(1);
                missatge = new String(ablob.getBytes(1l, (int) ablob.length()));

                System.out.println("missatge" + missatge);
                String[] parts = missatge.split(";");
                System.out.println(parts.toString());
                for (int i = 0; i < parts.length; i++) {

                    cm.addElement(parts[i].toString());

                }

                jList1.setModel(cm);

            }

        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 51));
        setUndecorated(true);
        setResizable(false);

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(160, 160, 160));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));

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

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Seguiment Tasca");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Conexio d = new Conexio();
        String msg = Login.usuari + " : " + jTextField1.getText();

        String aux = "";
        DefaultListModel mod = new DefaultListModel();
        mod = (DefaultListModel) jList1.getModel();
        for (int i = 0; i < mod.size(); i++) {
            System.out.println("ERROR" + mod.get(i));
            if (i == 0) {

                aux = mod.get(i) + ";";

            } else {

                aux = aux + mod.get(i) + ";";

            }

        }
        System.out.println("Aux1" + aux);
        aux = aux + msg + ";";
        System.out.println("Aux2" + aux);

        try {

            Connection cn = d.getConexio();

            PreparedStatement s = cn.prepareStatement("Update Tasques SET msg=? WHERE id_tasca='" + idTasca + "'");
            Blob blob = (Blob) cn.createBlob();
            blob.setBytes(1, aux.getBytes());
            s.setBlob(1, blob);
            jTextField1.setText("");
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

        String usuaris = "";
        try {

            Connection cn = d.getConexio();
            PreparedStatement pst = cn.prepareStatement("SELECT usuari FROM Tasques WHERE id_tasca='" + idTasca + "'");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                usuaris = rs.getString(1);
                System.out.println("usuaris" + usuaris);
            }

        } catch (SQLException e) {
            System.out.println("ERROR" + e);
        }

        String usuariReplace = usuaris.replace(Login.usuari, "");
        System.out.println("usuarisReplace" + usuariReplace);
        String[] arrOfStr = usuariReplace.split("\n", 5);

        for (String a : arrOfStr) {
            System.out.println("usuari " + a);
            String usu = "";
            try {

                Connection cn = d.getConexio();
                PreparedStatement pst = cn.prepareStatement("SELECT xat FROM Usuaris WHERE usuari='" + a + "'");
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {

                    usu = rs.getString(1);
                    System.out.println("usu" + usu);
                }

            } catch (SQLException e) {
                System.out.println("ERROR" + e);
            }

            try {

                Connection cn = d.getConexio();

                PreparedStatement s = cn.prepareStatement("Update Usuaris SET xat=? WHERE usuari='" + a + "'");
                String idtas = String.valueOf(idTasca);

                if (!usu.contains(idtas)) {

                    if (usu.isEmpty()) {
                        s.setString(1, idtas);
                    } else {
                        s.setString(1, usu + "\n" + idTasca);
                    }

                }

                s.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);

            }
        }

        jList1.updateUI();

        // load_caht();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void changecolor(JPanel hover, Color rand) {

        hover.setBackground(rand);

    }

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:

        int EXIT_ON_CLOSE1 = Home.EXIT_ON_CLOSE;
        this.dispose();

    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 0, 51));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(0, 51, 204));
    }//GEN-LAST:event_CloseMouseExited

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JLabel Close;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
