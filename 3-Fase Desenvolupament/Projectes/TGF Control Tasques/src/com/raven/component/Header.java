package com.raven.component;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class Header extends javax.swing.JPanel {

    public Header() {
        initComponents();
    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmdMenu = new com.raven.swing.Button();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N

        ButtonClose.setBackground(new java.awt.Color(255, 255, 255));
        ButtonClose.setLayout(new java.awt.BorderLayout());

        Close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/close.png"))); // NOI18N
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

        ButtonMax.setBackground(new java.awt.Color(255, 255, 255));
        ButtonMax.setLayout(new java.awt.BorderLayout());

        Max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/expand.png"))); // NOI18N
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

        ButtonMin.setBackground(new java.awt.Color(255, 255, 255));
        ButtonMin.setLayout(new java.awt.BorderLayout());

        Min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/minimize.png"))); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 684, Short.MAX_VALUE)
                .addComponent(ButtonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void changecolor(JPanel hover, Color rand) {

        hover.setBackground(rand);

    }

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(33, 105, 249));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 255, 255));
    }//GEN-LAST:event_CloseMouseExited

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        /*if (this.getExtendedState() != Main.MAXIMIZED_BOTH) {
            this.setExtendedState(Main.MAXIMIZED_BOTH);

        } else {
            this.setExtendedState(Main.NORMAL);

        }*/
    }//GEN-LAST:event_MaxMouseClicked

    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        //changecolor(ButtonMax, new Color(255, 204, 102));
    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:
        //changecolor(ButtonMax, new Color(255, 153, 0));
    }//GEN-LAST:event_MaxMouseExited

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        // TODO add your handling code here:
        //this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:
        //changecolor(ButtonMin, new Color(255, 204, 102));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:
        //changecolor(ButtonMin, new Color(255, 153, 0));
    }//GEN-LAST:event_MinMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JPanel ButtonMin;
    public javax.swing.JLabel Close;
    public javax.swing.JLabel Max;
    public javax.swing.JLabel Min;
    private com.raven.swing.Button cmdMenu;
    // End of variables declaration//GEN-END:variables
}
