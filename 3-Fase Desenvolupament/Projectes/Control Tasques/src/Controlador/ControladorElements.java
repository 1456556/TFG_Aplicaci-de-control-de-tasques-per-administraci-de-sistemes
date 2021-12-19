/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesElements;
import Model.ConsultesTasques;
import Model.Elements;
import Model.Tasques;
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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

        this.vis.jButtonNouElement.addActionListener(this);
        this.vis.jButtonRegistarElement.addActionListener(this);
        this.vis.jButtonEditarElement.addActionListener(this);
        this.vis.jTable_Elements.addMouseListener(this);
        this.vis.jButtonEliminarElement.addActionListener(this);
        this.vis.txt_buscadorElements.addKeyListener(this);
    }

    public void inicialitzar() {

        MostrarTaula();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jButtonNouElement) {

            vis.DashElements.setVisible(false);
            vis.DashNouElement.setVisible(true);
        }

        if (e.getSource() == vis.jButtonRegistarElement) {

            System.out.println("HOlA");
            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomElem.getText().trim());
            mod.setModel(vis.txt_model.getText().trim());
            mod.setNumeroSerie(vis.txt_numserie.getText().trim());
            mod.setUsuariAssignat(vis.txt_usuariassignat.getText().trim());
            mod.setObservacions(vis.txt_observacions.getText().trim());
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

                tipus_string = "Ordinador";
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

            switch (modC.NouElement(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouElement.setVisible(false);
                    vis.DashElements.setVisible(true);
                    MostrarTaula();
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

        if (e.getSource() == vis.jButtonEditarElement) {

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

                tipus_string = "Ordinador";
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
                    vis.DashInfoElement.setVisible(false);
                    vis.DashElements.setVisible(true);
                    MostrarTaula();
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

        if (e.getSource() == vis.jButtonEliminarElement) {

            for (int i = 0; i < vis.jTable_Elements.getRowCount(); i++) {

                Boolean checked = Boolean.valueOf(vis.jTable_Elements.getValueAt(i, 0).toString());

                //DISPLAY
                if (checked) {

                    int id = (int) modelElements.getValueAt(i, 6);
                    mod.setId(id);
                    if (modC.EliminarElement(mod) == false) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar, contacti amb l'administrador");

                    }
                }
            }
            MostrarTaula();

        }

    }

    public void MostrarTaula() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        vis.TasquesTotalsElements.setText(String.valueOf(tas.getTasquesTotals()));
        vis.TasquesTotalsElements.setEditable(false);
        vis.TasquesAsignadesElements.setText(String.valueOf(tas.getTasquesAssingades()));
        vis.TasquesAsignadesElements.setEditable(false);
        vis.TasquesGestionadesElements.setText(String.valueOf(tas.getTasquesPendents()));
        vis.TasquesGestionadesElements.setEditable(false);

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
        // int numRegistres = modC.BuscarTasques(vis.txtBuscadorTasques.getText()).size();

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

        vis.jTable_Elements.setModel(model_elements);
        modelElements = model_elements;
        addCheckBox(0, vis.jTable_Elements);
        vis.jTable_Elements.removeColumn(vis.jTable_Elements.getColumnModel().getColumn(6));

    }

    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));

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
        vis.txt_usuariassignat.setText("");
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

        if (e.getSource() == vis.jTable_Elements) {

            DefaultTableModel model_elements2 = new DefaultTableModel();
            model_elements2 = (DefaultTableModel) vis.jTable_Elements.getModel();

            int fila_point = vis.jTable_Elements.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Elements.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Elements.repaint();
            vis.jTable_Elements.updateUI();

            if (fila_point > -1 && columna_point > 0) {

                String titol = model_elements2.getValueAt(fila_point, columna).toString();
                mod.setNom(titol);
                int id = (int) modelElements.getValueAt(fila_point, 6);
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
                    vis.DashInfoElement.setVisible(true);
                    vis.DashElements.setVisible(false);

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

        DefaultTableModel model_elements = new DefaultTableModel();

        model_elements.addColumn("Seleccionar");
        model_elements.addColumn("Nom");
        model_elements.addColumn("Usuari Assignat");
        model_elements.addColumn("Tipus");
        model_elements.addColumn("Marca");
        model_elements.addColumn("Estat");
        model_elements.addColumn("ID");

        Object[] columna = new Object[7];

        System.out.print("Buscador" + vis.txt_buscadorElements.getText());
        System.out.println("Nom" + mod.getNom());

        int numRegistres = modC.BuscarElements(vis.txt_buscadorElements.getText()).size();

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getNom();
            columna[2] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getUsuariAssignat();
            columna[3] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getTipus();
            columna[4] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getMarca();
            columna[5] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getModel();
            columna[6] = modC.BuscarElements(vis.txt_buscadorElements.getText()).get(i).getId();
            model_elements.addRow(columna);
            System.out.println("Titol" + mod.getNom());
            mod.setId(modC.MostrarElements().get(i).getId());
            modC.GuardarId(mod);
        }

        for (int i = 0; i < numRegistres; i++) {

            model_elements.setValueAt(false, i, 0);

        }

        vis.jTable_Elements.setModel(model_elements);

        modelElements = model_elements;
        addCheckBox(0, vis.jTable_Elements);
        vis.jTable_Elements.removeColumn(vis.jTable_Elements.getColumnModel().getColumn(6));

    }

}
