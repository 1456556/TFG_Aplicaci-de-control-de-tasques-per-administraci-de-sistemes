package com.raven.form;

import Controlador.ControladorTasques;
import Model.ConsultesTasques;
import Model.Tasques;
import com.raven.dialog.Message;
import com.raven.main.Main;
import com.raven.model.ModelCard;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import java.awt.Color;
import javax.swing.Icon;
import javax.swing.table.DefaultTableModel;

public class FormTasques extends javax.swing.JPanel {

    public FormTasques() {
        initComponents();
        //jTable_Tasques.fixTable(jScrollPane_Tasques);
        setOpaque(false);
        initData();

    }

    private void initData() {
//        initCardData();
        initNoticeBoard();
        //initTableData();
        ConsultesTasques ct = new ConsultesTasques();
        Tasques t = new Tasques();
        ControladorTasques con = new ControladorTasques(ct, t);
        con.inicialitzar();
        //main.setVisible(false);
        //ft.setVisible(true);
    }

    private void initTableData() {

        //modC.contadorTasques(mod);
        /*vis.jTextFieldTasquesTotals.setText(String.valueOf(mod.getTasquesTotals()));
        vis.jTextFieldTasquesTotals.setEditable(false);
        vis.jTextFieldTasquesAssignades.setText(String.valueOf(mod.getTasquesAssingades()));
        vis.jTextFieldTasquesAssignades.setEditable(false);
        vis.jTextFieldTasquesPendents.setText(String.valueOf(mod.getTasquesPendents()));
        vis.jTextFieldTasquesPendents.setEditable(false);*/
        DefaultTableModel model_tasques = new DefaultTableModel();

        model_tasques.addColumn("Sleccionar");
        model_tasques.addColumn("Titol");
        model_tasques.addColumn("Prioritat");
        model_tasques.addColumn("Usuari assignat");
        model_tasques.addColumn("Data");
        model_tasques.addColumn("Estat");
        model_tasques.addColumn("ID");

        Object[] columna = new Object[7];

        columna[1] = "fdfs";
        columna[2] = "fdfs";
        columna[3] = "fdfs";
        columna[4] = "fdfs";
        columna[5] = "fdfs";
        columna[6] = "fdfs";

        model_tasques.addRow(columna);
        jTable_Tasques.setModel(model_tasques);
        /*int numRegistres = modC.MostrarTasques().size();
        System.out.println("Num: " + numRegistres);
        // int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();

        for (int i = 0; i < numRegistres; i++) {

            int lenght = modC.MostrarTasques().get(i).getUsuariArrayList().size();
            ArrayList<String> len = modC.MostrarTasques().get(i).getUsuariArrayList();
            System.out.println("ArrayList" + len);
            //for (int j = 0; j < lenght; j++) {

            columna[1] = modC.MostrarTasques().get(i).getTitol();
            columna[2] = modC.MostrarTasques().get(i).getPrioritat();
            String usuari = modC.MostrarTasques().get(i).getUsuariArrayList().get(i);
            String sinSaltos = usuari.replaceAll("\n", "<br> ");
            usuari = "<HTML> " + sinSaltos + " </HTML>";
            System.out.print("UASUARI HTLM: " + usuari);
            columna[3] = usuari;
            columna[4] = modC.MostrarTasques().get(i).getData();
            columna[5] = modC.MostrarTasques().get(i).getEstat();
            columna[6] = modC.MostrarTasques().get(i).getId();

            model_tasques.addRow(columna);

            mod.setId(modC.MostrarTasques().get(i).getId());
            modC.GuardarId(mod);

        }
        for (int i = 0; i < numRegistres; i++) {

            model_tasques.setValueAt(false, i, 0);

        }

        vis.jTable_Tasques.setModel(model_tasques);

        modelTasques = model_tasques;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < vis.jTable_Tasques.getColumnCount(); i++) {

            vis.jTable_Tasques.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }
        //vis.jComboBoxDashTasquesUsuari.setVisible(false);
        addCheckBox(0, vis.jTable_Tasques);
        vis.jTable_Tasques.removeColumn(vis.jTable_Tasques.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Tasques.getModel()));
        sorter.setRowFilter(RowFilter.regexFilter("victor"));
        jTable_Tasques.setRowSorter(sorter);
        jTable_Tasques.getRowSorter().toggleSortOrder(4);*/
    }

    /* EventAction eventAction = new EventAction() {
            @Override
            public void delete(ModelStudent student) {
                if (showMessage("Delete Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }

            @Override
            public void update(ModelStudent student) {
                if (showMessage("Update Student : " + student.getName())) {
                    System.out.println("User click OK");
                } else {
                    System.out.println("User click Cancel");
                }
            }
        };*/

 /*jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile1.jpg")), "Dara", "Male", "C++", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));
        jTable_Tasques.addRow(new ModelStudent(new ImageIcon(getClass().getResource("/com/raven/icon/profile2.jpg")), "Bora", "Male", "C#", 300).toRowTable(eventAction));*/
//}
    private void initCardData() {
        Icon icon1 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.PEOPLE, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card1.setData(new ModelCard("New Student", 5100, 20, icon1));
        Icon icon2 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MONETIZATION_ON, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card2.setData(new ModelCard("Income", 2000, 60, icon2));
        Icon icon3 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SHOPPING_BASKET, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card3.setData(new ModelCard("Expense", 3000, 80, icon3));
        Icon icon4 = IconFontSwing.buildIcon(GoogleMaterialDesignIcons.BUSINESS_CENTER, 60, new Color(255, 255, 255, 100), new Color(255, 255, 255, 15));
        card4.setData(new ModelCard("Other Income", 550, 95, icon4));
    }

    private void initNoticeBoard() {
        /* noticeBoard.addDate("04/10/2021");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(94, 49, 238), "Hidemode", "Now", "Sets the hide mode for the component. If the hide mode has been specified in the This hide mode can be overridden by the component constraint."));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(218, 49, 238), "Tag", "2h ago", "Tags the component with metadata name that can be used by the layout engine. The tag can be used to explain for the layout manager what the components is showing, such as an OK or Cancel button."));
        noticeBoard.addDate("03/10/2021");
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(32, 171, 43), "Further Reading", "12:30 PM", "There are more information to digest regarding MigLayout. The resources are all available at www.migcomponents.com"));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(50, 93, 215), "Span", "10:30 AM", "Spans the current cell (merges) over a number of cells. Practically this means that this cell and the count number of cells will be treated as one cell and the component can use the space that all these cells have."));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(27, 188, 204), "Skip ", "9:00 AM", "Skips a number of cells in the flow. This is used to jump over a number of cells before the next free cell is looked for. The skipping is done before this component is put in a cell and thus this cells is affected by it. \"count\" defaults to 1 if not specified."));
        noticeBoard.addNoticeBoard(new ModelNoticeBoard(new Color(238, 46, 57), "Push", "7:15 AM", "Makes the row and/or column that the component is residing in grow with \"weight\". This can be used instead of having a \"grow\" keyword in the column/row constraints."));
        noticeBoard.scrollToTop();*/
    }

    private boolean showMessage(String message) {
        Message obj = new Message(Main.getFrames()[0], true);
        obj.showMessage(message);
        return obj.isOk();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card1 = new com.raven.component.Card();
        jLabel1 = new javax.swing.JLabel();
        card2 = new com.raven.component.Card();
        card3 = new com.raven.component.Card();
        card4 = new com.raven.component.Card();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonNovaTasca = new javax.swing.JButton();
        jButtonEliminarTasca = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        jComboBoxDashTasquesUsuari = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        txtBuscadorTasques = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane_Tasques = new javax.swing.JScrollPane();
        jTable_Tasques = new javax.swing.JTable();

        card1.setColorGradient(new java.awt.Color(211, 28, 215));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        card2.setBackground(new java.awt.Color(10, 30, 214));
        card2.setColorGradient(new java.awt.Color(72, 111, 252));

        card3.setBackground(new java.awt.Color(194, 85, 1));
        card3.setColorGradient(new java.awt.Color(255, 212, 99));

        card4.setBackground(new java.awt.Color(60, 195, 0));
        card4.setColorGradient(new java.awt.Color(208, 255, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Notice Board");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Simple Miglayout API Doc");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setOpaque(true);

        jButtonNovaTasca.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButtonNovaTasca.setText("Crear Tasca");

        jButtonEliminarTasca.setText("Eliminar Tasques");
        jButtonEliminarTasca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarTascaMouseClicked(evt);
            }
        });
        jButtonEliminarTasca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTasca(evt);
            }
        });

        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jLabel127.setText("Usuari:");

        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Buscar :");

        txtBuscadorTasques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorTasquesActionPerformed(evt);
            }
        });
        txtBuscadorTasques.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorTasquesKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonNovaTasca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarTasca)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovaTasca)
                    .addComponent(jButtonEliminarTasca)
                    .addComponent(jLabel127)
                    .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(76, 76, 76));
        jLabel5.setText("Data Student");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jTable_Tasques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane_Tasques.setViewportView(jTable_Tasques);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(card4, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarTascaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTascaMouseClicked

    private void jButtonEliminarTasca(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTasca
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTasca

    private void txtBuscadorTasquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTasquesActionPerformed

    private void txtBuscadorTasquesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesKeyReleased
        // TODO add your handling code here:

        // BuscarTasques(txtBuscadorTasques.getText());
    }//GEN-LAST:event_txtBuscadorTasquesKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.component.Card card1;
    private com.raven.component.Card card2;
    private com.raven.component.Card card3;
    private com.raven.component.Card card4;
    public javax.swing.JButton jButtonEliminarTasca;
    public javax.swing.JButton jButtonNovaTasca;
    public javax.swing.JComboBox<String> jComboBoxDashTasquesUsuari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JScrollPane jScrollPane_Tasques;
    public javax.swing.JTable jTable_Tasques;
    public javax.swing.JTextField txtBuscadorTasques;
    // End of variables declaration//GEN-END:variables
}
