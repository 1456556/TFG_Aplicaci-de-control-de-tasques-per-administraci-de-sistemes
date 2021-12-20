/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesElements;
import Model.ConsultesTasques;
import Model.Elements;
import Model.Login;
import Model.Tasques;
import Vista.JFPrincipal;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Victor
 */
class ControladorElements implements ActionListener, MouseListener, KeyListener {

    private Elements mod;
    private ConsultesElements modC;
    private JFPrincipal vis;
    public DefaultTableModel modelElements;

    public ControladorElements(Elements mod, ConsultesElements modC, JFPrincipal vis) {

        this.mod = mod;
        this.modC = modC;
        this.vis = vis;

        this.vis.jButtonNouOrdinador.addActionListener(this);
        this.vis.jButtonRegistarOrdinador.addActionListener(this);
        this.vis.jButtonEditarOrdinador.addActionListener(this);
        this.vis.jTable_Ordinadors.addMouseListener(this);
        this.vis.jButtonEliminarOrdinadors.addActionListener(this);
        this.vis.txtBuscadorOrdinadors.addKeyListener(this);
        this.vis.jButtonOrdinadors.addActionListener(this);
        this.vis.jButtonTelefons.addActionListener(this);
        this.vis.jButtonImpresores.addActionListener(this);
        this.vis.jButtonServidors.addActionListener(this);
        this.vis.jButtonXarxa.addActionListener(this);

        ButtonGroup groupOrdinadors = new ButtonGroup();
        groupOrdinadors.add(this.vis.jRadioButtonCompraOrdinador);
        groupOrdinadors.add(this.vis.jRadioButtonRentingOrdinador);
        this.vis.jRadioButtonCompraOrdinador.setSelected(true);

    }

    public void inicialitzar() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jButtonOrdinadors) {

            vis.DashOrdinadors.setVisible(true);
            vis.DashTriaElement.setVisible(false);
            MostrarTaulaOrdinadors();
        }

        if (e.getSource() == vis.jButtonNouOrdinador) {

            vis.DashNouOrdinador.setVisible(true);
            vis.DashOrdinadors.setVisible(false);

            DefaultComboBoxModel mdl = new DefaultComboBoxModel();
            mdl.removeAllElements();
            vis.ComboUsuariAssignatOrdinador.setModel(mdl);
            vis.ComboUsuariAssignatOrdinador.setSelectedItem(Login.usuari);
            modC.UsuariAssignat(vis);
            AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatOrdinador);

        }

        if (e.getSource() == vis.jButtonTelefons) {

            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(true);
        }

        if (e.getSource() == vis.jButtonImpresores) {

            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(true);
        }

        if (e.getSource() == vis.jButtonXarxa) {

            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(true);
        }

        if (e.getSource() == vis.jButtonRegistarOrdinador) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomElem.getText().trim());
            mod.setModel(vis.txt_model.getText().trim());
            mod.setNumeroSerie(vis.txt_numserie.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignatOrdinador.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacions.getText().trim());
            mod.setData(vis.dataIngresOrdinador.getDate().toString());
            mod.setMarca(vis.txt_marca.getText().trim());
            int estat = vis.ComboEstatElem.getSelectedIndex() + 1;
            int tipus = vis.ComboTipus.getSelectedIndex() + 1;

            if (estat == 1) {

                estat_string = "Correcte";
            }

            if (estat == 2) {

                estat_string = "Baixa";

            }
            if (estat == 3) {

                estat_string = "Reparació";

            }

            if (tipus == 1) {

                tipus_string = "Escriptori";
            }
            if (tipus == 2) {

                tipus_string = "Protatil";
            }

            if (vis.jRadioButtonCompraOrdinador.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingOrdinador.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.NouElement(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouOrdinador.setVisible(false);
                    vis.DashOrdinadors.setVisible(true);
                    MostrarTaulaOrdinadors();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al crear l'element. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                    break;
                default:
                    break;

            }
        }

        if (e.getSource() == vis.jButtonEditarOrdinador) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomElem2.getText().trim());
            mod.setModel(vis.txt_modelElem2.getText().trim());
            mod.setNumeroSerie(vis.txt_numeroserieElem2.getText().trim());
            mod.setUsuariAssignat(vis.txt_usuariElem2.getText().trim());
            mod.setObservacions(vis.txt_observacionsElem2.getText().trim());
            mod.setMarca(vis.txt_marcaElem2.getText().trim());
            int estat = vis.ComboEstatElem2.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusElem2.getSelectedIndex() + 1;

            if (estat == 1) {

                estat_string = "Correcte";
            }

            if (estat == 2) {

                estat_string = "Baixa";

            }
            if (estat == 3) {

                estat_string = "Reparació";

            }

            if (tipus == 1) {

                tipus_string = "Escriptori";
            }
            if (tipus == 2) {

                tipus_string = "Protatil";
            }
            if (tipus == 3) {

                tipus_string = "SmartPhone";

            }
            if (tipus == 4) {

                tipus_string = "Impresora";
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.EditarElement(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Modificat!");
                    natejar();
                    vis.DashInfoOrdinador.setVisible(false);
                    vis.DashOrdinadors.setVisible(true);
                    MostrarTaulaOrdinadors();
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Error al modificar l'element. Contacti amb l'administrador");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                    break;
                default:
                    break;

            }

        }

        if (e.getSource() == vis.jButtonEliminarOrdinadors) {

            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Ordinadors.getRowSorter();
            DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Ordinadors.getModel();
            int rows = trs.getViewRowCount();
            System.out.print("ROOOWS " + rows);
            int j = rows - 1;

            for (int i = j; i >= 0; i--) {

                Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                System.out.print("Boolean " + checked);
                //DISPLAY
                if (checked) {
                    System.out.print("ROW COUNT" + vis.jTable_Ordinadors.getRowCount());
                    int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 6);
                    mod.setId(id);
                    model_tasques3.removeRow(i);
                    if (modC.EliminarElement(mod) == false) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar el grup, contacti amb l'administrador");

                    }
                }
            }
            MostrarTaulaOrdinadors();

        }

    }

    public void MostrarTaulaOrdinadors() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        vis.TasquesTotalsElements.setText(String.valueOf(tas.getTasquesTotals()));
        vis.TasquesTotalsElements.setEditable(false);
        vis.TasquesAsignadesElements.setText(String.valueOf(tas.getTasquesAssingades()));
        vis.TasquesAsignadesElements.setEditable(false);
        vis.TasquesGestionadesElements.setText(String.valueOf(tas.getTasquesPendents()));
        vis.TasquesGestionadesElements.setEditable(false);

        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("HP", 50);
        datos.setValue("Asus", 150);
        datos.setValue("Lenovo", 30);
        datos.setValue("Appel", 20);

        JFreeChart grafico_circular = ChartFactory.createPieChart("", datos, false, false, false);
        ChartPanel panel = new ChartPanel(grafico_circular);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(300, 175));
        vis.jPanel1.setLayout(new BorderLayout());
        vis.jPanel1.add(panel, BorderLayout.EAST);

        DefaultPieDataset datos2 = new DefaultPieDataset();
        datos2.setValue("Portatil", 50);
        datos2.setValue("Escriptori", 150);

        JFreeChart grafico_circular2 = ChartFactory.createPieChart("", datos2, false, false, false);
        ChartPanel panel2 = new ChartPanel(grafico_circular2);
        panel2.setMouseWheelEnabled(true);
        panel2.setPreferredSize(new Dimension(300, 175));
        //vis.jPanel1.setLayout(new BorderLayout());
        vis.jPanel1.add(panel2, BorderLayout.WEST);

        //this.vis.pack();
        //this.vis.repaint();*/
        DefaultTableModel model_elements = new DefaultTableModel();

        model_elements.addColumn("Seleccionar");
        model_elements.addColumn("Nom");
        model_elements.addColumn("Usuari Assignat");
        model_elements.addColumn("Tipus");
        model_elements.addColumn("Marca");
        model_elements.addColumn("Estat");
        model_elements.addColumn("ID");

        Object[] columna = new Object[7];

        int numRegistres = modC.MostrarElements().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarElements().get(i).getNom();
            columna[2] = modC.MostrarElements().get(i).getUsuariAssignat();
            columna[3] = modC.MostrarElements().get(i).getTipus();
            columna[4] = modC.MostrarElements().get(i).getMarca();
            columna[5] = modC.MostrarElements().get(i).getEstat();
            columna[6] = modC.MostrarElements().get(i).getId();
            model_elements.addRow(columna);

            mod.setId(modC.MostrarElements().get(i).getId());
            modC.GuardarId(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_elements.setValueAt(false, i, 0);

        }

        vis.jTable_Ordinadors.setModel(model_elements);
        modelElements = model_elements;
        addCheckBox(0, vis.jTable_Ordinadors);
        vis.jTable_Ordinadors.removeColumn(vis.jTable_Ordinadors.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Ordinadors.getModel()));
        vis.jTable_Ordinadors.setRowSorter(sorter3);

    }

    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc
                .setCellEditor(table.getDefaultEditor(Boolean.class
                ));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class
        ));

    }

    public void natejar() {

        mod.setNom("");
        mod.setMarca("");
        mod.setModel("");
        mod.setNumeroSerie("");
        mod.setObservacions("");
        mod.setUsuariAssignat("");
        mod.setTipus("");
        mod.setEstat("");

        vis.txt_nomElem.setText("");
        vis.dataIngresOrdinador.setDateToToday();

        vis.txt_observacions.setText("");
        vis.ComboEstatElem.setSelectedIndex(0);
        vis.ComboTipus.setSelectedIndex(0);
        vis.txt_model.setText("");
        vis.txt_marca.setText("");
        vis.txt_numserie.setText("");

        vis.txt_nomElem2.setText("");
        vis.txt_numeroserieElem2.setText("");
        vis.txt_observacionsElem2.setText("");
        vis.ComboEstatElem2.setSelectedIndex(0);
        vis.ComboTipusElem2.setSelectedIndex(0);
        vis.txt_modelElem2.setText("");
        vis.txt_marcaElem2.setText("");
        vis.txt_numeroserieElem2.setText("");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vis.jTable_Ordinadors) {

            int fila_point = vis.jTable_Ordinadors.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Ordinadors.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Ordinadors.repaint();
            vis.jTable_Ordinadors.updateUI();

            if (fila_point > -1 && columna_point > 0) {

                TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
                trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Ordinadors.getRowSorter();
                DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Ordinadors.getModel();
                String nom = String.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), columna));
                System.out.println("Nom" + nom);
                mod.setNom(nom);
                int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), 6);
                mod.setId(id);
                System.out.println("INT_ID: " + mod.getId());

                if (modC.informacioElement(mod) == 1) {

                    vis.txt_nomElem2.setText(mod.getNom());
                    vis.txt_usuariElem2.setText(mod.getUsuariAssignat());
                    vis.txt_observacionsElem2.setText(mod.getObservacions());
                    vis.ComboTipusElem2.setSelectedItem(mod.getTipus());
                    vis.ComboEstatElem2.setSelectedItem(mod.getEstat());
                    vis.txt_marcaElem2.setText(mod.getMarca());
                    vis.txt_numeroserieElem2.setText(mod.getNumeroSerie());
                    vis.txt_modelElem2.setText(mod.getModel());
                    vis.DashInfoOrdinador.setVisible(true);
                    vis.DashOrdinadors.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }

            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getSource() == vis.txtBuscadorOrdinadors) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Ordinadors.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorOrdinadors.getText()));
            vis.jTable_Ordinadors.setRowSorter(sorter3);

        }

    }

}
