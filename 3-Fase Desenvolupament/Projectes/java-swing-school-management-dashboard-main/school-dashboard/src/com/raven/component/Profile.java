package com.raven.component;

public class Profile extends javax.swing.JPanel {

    public Profile() {
        initComponents();
        setOpaque(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pic = new com.raven.swing.ImageAvatar();
        jButtonNomUsuari = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(224, 224, 224));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-gif-maker2.png"))); // NOI18N
        jLabel1.setText("ControlTasques");

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg"))); // NOI18N

        jButtonNomUsuari.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonNomUsuari.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonNomUsuari.setText("Usuari");
        jButtonNomUsuari.setMaximumSize(new java.awt.Dimension(111, 32));
        jButtonNomUsuari.setMinimumSize(new java.awt.Dimension(111, 32));
        jButtonNomUsuari.setPreferredSize(new java.awt.Dimension(111, 32));
        jButtonNomUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonNomUsuariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButtonNomUsuariMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNomUsuariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseEntered
        // TODO add your handling code here:
        //changecolor(N_Usuari, new Color(255, 204, 102));
    }//GEN-LAST:event_jButtonNomUsuariMouseEntered

    private void jButtonNomUsuariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseExited
        // TODO add your handling code here:

        //changecolor(N_Usuari, new Color(255, 153, 0));
    }//GEN-LAST:event_jButtonNomUsuariMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel jButtonNomUsuari;
    private javax.swing.JLabel jLabel1;
    private com.raven.swing.ImageAvatar pic;
    // End of variables declaration//GEN-END:variables
}
