/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesGrups;
import Model.ConsultesTasques;
import Model.Grups;
import Model.Tasques;
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Victor
 */
public class ControladorGrups implements ActionListener, MouseListener, KeyListener {

    private Grups mod;
    private ConsultesGrups modC;
    private JFPrincipal vis;

    public DefaultTableModel modelGrupsUsuaris;
    public DefaultTableModel modelGrupsElements;
    public DefaultTableModel modelGrups;

    public ControladorGrups(Grups mod, ConsultesGrups modC, JFPrincipal vis) {

        this.mod = mod;
        this.modC = modC;
        this.vis = vis;

        this.vis.jButtonNouGrup.addActionListener(this);
        this.vis.jButtonEliminarGrup.addActionListener(this);
        this.vis.jButtonRegistarGrup.addActionListener(this);
        this.vis.jTable_Grups.addMouseListener(this);
        this.vis.jButtonAfegir.addActionListener(this);
        this.vis.jButtonAfegir1.addActionListener(this);
        this.vis.jButtonAfegirElement.addActionListener(this);
        this.vis.jButtonAfegirElement1.addActionListener(this);
        this.vis.jRadioButtonElements.addActionListener(this);
        this.vis.jRadioButtonUsuaris.addActionListener(this);
        this.vis.txt_cerca.addKeyListener(this);
        this.vis.txt_cerca1.addKeyListener(this);
        this.vis.txtBuscadorTasques1.addKeyListener(this);
        this.vis.jButtonRegistarGrup1.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(this.vis.jRadioButtonElements);
        group.add(this.vis.jRadioButtonUsuaris);

    }

    public void inicialitzar() {

        MostrarTaula();
    }

    public void MostrarTaula() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        vis.TasquesTotalsGrups.setText(String.valueOf(tas.getTasquesTotals()));
        vis.TasquesTotalsGrups.setEditable(false);
        vis.TasquesAsignadesGrups.setText(String.valueOf(tas.getTasquesAssingades()));
        vis.TasquesAsignadesGrups.setEditable(false);
        vis.TasquesGestionadesGrups.setText(String.valueOf(tas.getTasquesPendents()));
        vis.TasquesGestionadesGrups.setEditable(false);

        DefaultTableModel model_grups = new DefaultTableModel();

        model_grups.addColumn("Seleccionar");
        model_grups.addColumn("Nom");
        //model_grups.addColumn("Tipus");        
        model_grups.addColumn("ID");

        Object[] columna = new Object[3];

        int numRegistres = modC.MostrarGrups().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarGrups().get(i).getNom();
            columna[2] = modC.MostrarGrups().get(i).getId();

            model_grups.addRow(columna);

            mod.setId(modC.MostrarGrups().get(i).getId());
            modC.GuardarId(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_grups.setValueAt(false, i, 0);

        }

        vis.jTable_Grups.setModel(model_grups);
        modelGrups = model_grups;
        addCheckBox(0, vis.jTable_Grups);
        vis.jTable_Grups.removeColumn(vis.jTable_Grups.getColumnModel().getColumn(2));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Grups.getModel()));
        vis.jTable_Grups.setRowSorter(sorter3);

    }

    public void MostrarTaulaGrupsUsuaris() {

        DefaultTableModel model_grups = new DefaultTableModel();

        model_grups.addColumn("Seleccionar");
        model_grups.addColumn("Nom");
        model_grups.addColumn("Cognom");
        model_grups.addColumn("Usuari");
        model_grups.addColumn("ID");

        Object[] columna = new Object[5];

        int numRegistres = modC.MostrarGrupsUsuaris().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarGrupsUsuaris().get(i).getNomUsuari();
            columna[2] = modC.MostrarGrupsUsuaris().get(i).getCognom();
            columna[3] = modC.MostrarGrupsUsuaris().get(i).getUsuari();
            columna[4] = modC.MostrarGrupsUsuaris().get(i).getIdUsuari();

            model_grups.addRow(columna);

            mod.setId(modC.MostrarGrupsUsuaris().get(i).getId());
            modC.GuardarIdUsuari(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_grups.setValueAt(false, i, 0);

        }

        vis.jTableCrearGrupsUsuaris.setModel(model_grups);
        modelGrupsUsuaris = model_grups;
        addCheckBox(0, vis.jTableCrearGrupsUsuaris);
        vis.jTableCrearGrupsUsuaris.removeColumn(vis.jTableCrearGrupsUsuaris.getColumnModel().getColumn(4));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrupsUsuaris.getModel()));
        vis.jTableCrearGrupsUsuaris.setRowSorter(sorter);

    }

    public void MostrarTaulaGrupsElements() {

        DefaultTableModel model_grups = new DefaultTableModel();

        model_grups.addColumn("Seleccionar");
        model_grups.addColumn("Nom");
        model_grups.addColumn("Usuari");
        model_grups.addColumn("Tipus");
        model_grups.addColumn("ID");

        Object[] columna = new Object[5];

        int numRegistres = modC.MostrarGrupsElements().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarGrupsElements().get(i).getNomElement();
            columna[2] = modC.MostrarGrupsElements().get(i).getUsuariElement();
            columna[3] = modC.MostrarGrupsElements().get(i).getTipusElement();
            columna[4] = modC.MostrarGrupsElements().get(i).getIdElement();

            model_grups.addRow(columna);

            mod.setId(modC.MostrarGrupsElements().get(i).getId());
            modC.GuardarIdElement(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_grups.setValueAt(false, i, 0);

        }

        vis.jTableCrearGrupsElements.setModel(model_grups);
        modelGrupsElements = model_grups;
        addCheckBox(0, vis.jTableCrearGrupsElements);
        vis.jTableCrearGrupsElements.removeColumn(vis.jTableCrearGrupsElements.getColumnModel().getColumn(4));
        TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrupsElements.getModel()));
        vis.jTableCrearGrupsElements.setRowSorter(sorter2);

    }

    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));

    }

    public boolean IsSelected(int fila, int columna, JTable taula) {

        Boolean checked = Boolean.valueOf(taula.getValueAt(fila, columna).toString());
        System.out.print(checked);
        return checked;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jButtonEliminarGrup) {

            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Grups.getRowSorter();
            DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Grups.getModel();
            int rows = trs.getViewRowCount();
            System.out.print("ROOOWS " + rows);
            int j = rows - 1;

            for (int i = j; i >= 0; i--) {

                Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                System.out.print("Boolean " + checked);
                //DISPLAY
                if (checked) {
                    System.out.print("ROW COUNT" + vis.jTable_Grups.getRowCount());
                    int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 2);
                    mod.setId(id);
                    model_tasques3.removeRow(i);
                    if (modC.EliminarGrup(mod) == 2) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar el grup, contacti amb l'administrador");

                    }
                }
            }
            System.out.print("ROW COUNT TRS " + trs.getModelRowCount());
            MostrarTaula();

        }

        if (e.getSource() == vis.jButtonNouGrup) {

            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(true);
            vis.jRadioButtonUsuaris.setSelected(true);
            vis.jButtonAfegirElement.setVisible(false);
            vis.jScrollPaneElements.setVisible(false);

            ArrayList<String> UsuariArrayList = new ArrayList<String>();
            ArrayList<Integer> idArrayList = new ArrayList<Integer>();
            ArrayList<String> ElementArrayList = new ArrayList<String>();
            ArrayList<Integer> idElementArrayList = new ArrayList<Integer>();
            mod.setUsuariArrayList(UsuariArrayList);
            mod.setIdArrayList(idArrayList);
            mod.setElementArrayList(ElementArrayList);
            mod.setIdElementArrayList(idElementArrayList);
            MostrarTaulaGrupsUsuaris();

        }

        if (e.getSource() == vis.jButtonAfegir) {

            System.out.println("PRimer:" + mod.getUsuariArrayList());
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTableCrearGrupsUsuaris.getRowSorter();
            DefaultTableModel model3 = (DefaultTableModel) vis.jTableCrearGrupsUsuaris.getModel();
            String line = "";
            ArrayList<String> UsuariArrayList = mod.getUsuariArrayList();
            ArrayList<Integer> idArrayList = mod.getIdArrayList();

            for (int i = 0; i < vis.jTableCrearGrupsUsuaris.getRowCount(); i++) {

                String usuari = model3.getValueAt(trs.convertRowIndexToModel(i), 3).toString();
                int id = (int) model3.getValueAt(trs.convertRowIndexToModel(i), 4);

                if (IsSelected(i, 0, vis.jTableCrearGrupsUsuaris)) {

                    if (!UsuariArrayList.contains(usuari)) {

                        UsuariArrayList.add(usuari);
                        idArrayList.add(id);
                        String[] array = UsuariArrayList.toArray(new String[UsuariArrayList.size()]);
                        int[] arrayID = idArrayList.stream().mapToInt(Integer::intValue).toArray();
                        mod.setGrupUsuaris(array);
                        mod.setIdUsuaris(arrayID);

                    }

                } else {

                    if (UsuariArrayList.contains(usuari)) {
                        UsuariArrayList.remove(usuari);
                        System.out.println(idArrayList);
                        String idRemove = String.valueOf(id);
                        idArrayList.remove(idRemove);

                    }

                }

            }

            mod.setUsuariArrayList(UsuariArrayList);
            mod.setIdArrayList(idArrayList);

            String[] array = UsuariArrayList.toArray(new String[UsuariArrayList.size()]);

            for (int i = 0; i < mod.getUsuariArrayList().size(); i++) {

                line = line + array[i] + "\n";
            }
            vis.jTextGrupUsuaris.setText(line);

        }

        if (e.getSource() == vis.jButtonAfegirElement) {

            System.out.println("PRimer:" + mod.getElementArrayList());
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTableCrearGrupsElements.getRowSorter();
            DefaultTableModel model3 = (DefaultTableModel) vis.jTableCrearGrupsElements.getModel();
            String line = "";
            ArrayList<String> ElementArrayList = new ArrayList();
            ArrayList<Integer> idElementArrayList = new ArrayList();
            ElementArrayList = mod.getElementArrayList();
            idElementArrayList = mod.getIdElementArrayList();

            for (int i = 0; i < vis.jTableCrearGrupsElements.getRowCount(); i++) {

                String usuari = model3.getValueAt(trs.convertRowIndexToModel(i), 1).toString();
                int id = (int) model3.getValueAt(trs.convertRowIndexToModel(i), 4);

                if (IsSelected(i, 0, vis.jTableCrearGrupsElements)) {

                    if (!ElementArrayList.contains(usuari)) {

                        ElementArrayList.add(usuari);
                        idElementArrayList.add(id);
                        String[] array = ElementArrayList.toArray(new String[ElementArrayList.size()]);
                        int[] arrayID = idElementArrayList.stream().mapToInt(Integer::intValue).toArray();
                        mod.setGrupUsuaris(array);
                        mod.setIdUsuaris(arrayID);

                    }

                } else {

                    if (ElementArrayList.contains(usuari)) {
                        ElementArrayList.remove(usuari);
                        System.out.println(idElementArrayList);
                        String idRemove = String.valueOf(id);
                        idElementArrayList.remove(idRemove);

                    }

                }

            }

            mod.setElementArrayList(ElementArrayList);
            mod.setIdElementArrayList(idElementArrayList);

            String[] array = ElementArrayList.toArray(new String[ElementArrayList.size()]);

            for (int i = 0; i < mod.getElementArrayList().size(); i++) {

                line = line + array[i] + "\n";
            }
            vis.jTextGrupUsuaris.setText(line);

        }

        if (e.getSource() == vis.jButtonRegistarGrup1) {

            mod.setNom(vis.txt_nomGrup1.getText().trim());
            String text = (vis.jTextGrupUsuaris1.getText());
            System.out.println("Actualitzar" + mod.getGrupUsuaris());
            System.out.println("Actualitzar" + mod.getGrupElements());

            if ((mod.getGrupUsuaris() != null) || (mod.getGrupElements() != null)) {

                switch (modC.EditarUserGrup(mod)) {

                    case 1:
                        JOptionPane.showMessageDialog(null, "Grup modificat Correctament!");
                        Natejar();
                        vis.DashInfoGrup.setVisible(false);
                        vis.DashGrups.setVisible(true);
                        MostrarTaula();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Error al modificar el grup. Contacti amb l'administrador");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                        break;
                    default:
                        break;

                }
            }

            /* if (mod.getGrupElements() != null) {

                 switch (modC.NouElementGrup(mod)) {

                     case 1:
                         if (modC.NouGrup(mod) == 1) {

                             JOptionPane.showMessageDialog(null, "Grup modificat Correctament!");

                         } else {

                             JOptionPane.showMessageDialog(null, "Error al modificar el grup. Contacti amb l'administrador");

                         }
                         Natejar();
                         vis.DashNouGrup.setVisible(false);
                         vis.DashGrups.setVisible(true);

                         MostrarTaula();
                         break;
                     case 2:
                         JOptionPane.showMessageDialog(null, "Error al modificar el grup. Contacti amb l'administrador");
                         break;
                     case 3:
                         JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");
                         break;
                     default:
                         break;

                 }

             }*/
        }

        if (e.getSource() == vis.jButtonRegistarGrup) {

            mod.setNom(vis.txt_nomGrup.getText().trim());
            String text = (vis.jTextGrupUsuaris.getText());

            if (mod.getGrupUsuaris() != null) {

                boolean type = false;
                if (vis.jRadioButtonUsuaris.isSelected()) {

                    type = true;
                }

                mod.setTipusGrup(type);

                switch (modC.NouUserGrup(mod)) {

                    case 1:
                        if (modC.NouGrup(mod) == 1) {

                            JOptionPane.showMessageDialog(null, "Element Creat Correctament!");

                        } else {

                            JOptionPane.showMessageDialog(null, "Error al crear l'element2. Contacti amb l'administrador");

                        }
                        Natejar();
                        vis.DashNouGrup.setVisible(false);
                        vis.DashGrups.setVisible(true);

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

            if (mod.getGrupElements() != null) {
                System.out.print("HOOOOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
                switch (modC.NouElementGrup(mod)) {

                    case 1:
                        if (modC.NouGrup(mod) == 1) {

                            JOptionPane.showMessageDialog(null, "Element Creat Correctament!");

                        } else {

                            JOptionPane.showMessageDialog(null, "Error al crear l'element2. Contacti amb l'administrador");

                        }
                        Natejar();
                        vis.DashNouGrup.setVisible(false);
                        vis.DashGrups.setVisible(true);

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

        }

        if (e.getSource() == vis.jButtonAfegir1) {

            System.out.println("PRimer:" + mod.getUsuariArrayList());
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTableCrearGrups.getRowSorter();
            DefaultTableModel model3 = (DefaultTableModel) vis.jTableCrearGrups.getModel();
            String line = "";
            ArrayList<String> UsuariArrayList = mod.getUsuariArrayList();
            ArrayList<Integer> idArrayList = mod.getIdArrayList();

            for (int i = 0; i < vis.jTableCrearGrups.getRowCount(); i++) {

                String usuari = model3.getValueAt(trs.convertRowIndexToModel(i), 3).toString();
                int id = (int) model3.getValueAt(trs.convertRowIndexToModel(i), 4);

                if (IsSelected(i, 0, vis.jTableCrearGrups)) {

                    if (!UsuariArrayList.contains(usuari)) {

                        UsuariArrayList.add(usuari);
                        idArrayList.add(id);
                        String[] array = UsuariArrayList.toArray(new String[UsuariArrayList.size()]);
                        int[] arrayID = idArrayList.stream().mapToInt(Integer::intValue).toArray();
                        mod.setGrupUsuaris(array);
                        mod.setIdUsuaris(arrayID);

                    }

                } else {

                    if (UsuariArrayList.contains(usuari)) {
                        UsuariArrayList.remove(usuari);
                        System.out.println(idArrayList);
                        String idRemove = String.valueOf(id);
                        idArrayList.remove(idRemove);

                    }

                }

            }

            mod.setUsuariArrayList(UsuariArrayList);
            mod.setIdArrayList(idArrayList);

            String[] array = UsuariArrayList.toArray(new String[UsuariArrayList.size()]);

            for (int i = 0; i < mod.getUsuariArrayList().size(); i++) {

                line = line + array[i] + "\n";
            }
            vis.jTextGrupUsuaris1.setText(line);

        }

        if (e.getSource() == vis.jButtonAfegirElement1) {

            System.out.println("PRimer:" + mod.getUsuariArrayList());
            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTableCrearGrups.getRowSorter();
            DefaultTableModel model3 = (DefaultTableModel) vis.jTableCrearGrups.getModel();
            String line = "";
            ArrayList<String> ElementArrayList = mod.getElementArrayList();
            ArrayList<Integer> idElementArrayList = mod.getIdElementArrayList();

            for (int i = 0; i < vis.jTableCrearGrups.getRowCount(); i++) {

                String usuari = model3.getValueAt(trs.convertRowIndexToModel(i), 1).toString();
                int id = (int) model3.getValueAt(trs.convertRowIndexToModel(i), 4);

                if (IsSelected(i, 0, vis.jTableCrearGrups)) {

                    if (!ElementArrayList.contains(usuari)) {

                        ElementArrayList.add(usuari);
                        idElementArrayList.add(id);
                        String[] array = ElementArrayList.toArray(new String[ElementArrayList.size()]);
                        int[] arrayID = idElementArrayList.stream().mapToInt(Integer::intValue).toArray();
                        mod.setGrupElements(array);
                        System.out.println("mod.setGrupElements(array)" + mod.getGrupElements());
                        mod.setIdElements(arrayID);

                    }

                } else {

                    if (ElementArrayList.contains(usuari)) {
                        ElementArrayList.remove(usuari);
                        System.out.println(idElementArrayList);
                        String idRemove = String.valueOf(id);
                        idElementArrayList.remove(idRemove);

                    }

                }

            }

            mod.setElementArrayList(ElementArrayList);
            mod.setIdElementArrayList(idElementArrayList);

            String[] array = ElementArrayList.toArray(new String[ElementArrayList.size()]);

            for (int i = 0; i < mod.getElementArrayList().size(); i++) {

                line = line + array[i] + "\n";
            }
            vis.jTextGrupUsuaris1.setText(line);

        }

        if (e.getSource() == vis.jRadioButtonUsuaris) {

            vis.jScrollPaneElements.setVisible(false);
            vis.jScrollPaneUsuaris.setVisible(true);
            vis.jButtonAfegir.setVisible(true);
            vis.jButtonAfegirElement.setVisible(false);
            vis.txt_cerca1.setVisible(false);
            vis.txt_cerca.setVisible(true);
            MostrarTaulaGrupsUsuaris();

        }

        if (e.getSource() == vis.jRadioButtonElements) {

            vis.jScrollPaneUsuaris.setVisible(false);
            vis.jScrollPaneElements.setVisible(true);
            vis.jButtonAfegir.setVisible(false);
            vis.jButtonAfegirElement.setVisible(true);
            vis.txt_cerca1.setVisible(true);
            vis.txt_cerca.setVisible(false);
            MostrarTaulaGrupsElements();

        }

    }

    public void Natejar() {

        vis.txt_nomGrup.setText("");

    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent evt) {

        if (evt.getSource() == vis.txt_cerca) {

            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrupsUsuaris.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(vis.txt_cerca.getText()));
            vis.jTableCrearGrupsUsuaris.setRowSorter(sorter);

        }

        if (evt.getSource() == vis.txt_cerca1) {

            TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrupsElements.getModel()));
            sorter2.setRowFilter(RowFilter.regexFilter(vis.txt_cerca1.getText()));
            vis.jTableCrearGrupsElements.setRowSorter(sorter2);

        }

        if (evt.getSource() == vis.txtBuscadorTasques1) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Grups.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorTasques1.getText()));
            vis.jTable_Grups.setRowSorter(sorter3);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vis.jTable_Grups) {

            int fila_point = vis.jTable_Grups.rowAtPoint(e.getPoint());
            int columna_point = vis.jTable_Grups.columnAtPoint(e.getPoint());
            int columna = 1;

            System.out.println("Fila" + fila_point);
            System.out.println("Columna" + columna_point);
            vis.jTable_Grups.repaint();
            vis.jTable_Grups.updateUI();

            if (fila_point > -1 && columna_point > 0) {

                TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
                trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Grups.getRowSorter();
                DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Grups.getModel();
                String nom = String.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), columna));
                System.out.println("Nom Grup" + nom);
                mod.setNom(nom);
                int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(fila_point), 2);
                mod.setId(id);
                System.out.println("INT_ID: " + mod.getId());

                switch (modC.informacioGrups(mod)) {

                    case 0:
                        JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");
                        break;
                    case 1:
                        vis.txt_nomGrup1.setText(mod.getNom());
                        DefaultTableModel model_grups2 = new DefaultTableModel();
                        model_grups2.addColumn("Seleccionar");
                        model_grups2.addColumn("Nom");
                        model_grups2.addColumn("Usuari");
                        model_grups2.addColumn("Tipus");
                        model_grups2.addColumn("ID");

                        Object[] columnes2 = new Object[5];

                        int numRegistres2 = modC.MostrarGrupsElements().size();
                        System.out.println("Num: " + numRegistres2);

                        for (int i = 0; i < numRegistres2; i++) {

                            String nomU = modC.MostrarGrupsElements().get(i).getNomElement();
                            System.out.println("Error" + nomU);
                            System.out.println("Array" + mod.getElementArrayList());
                            if (mod.getElementArrayList().contains(nomU)) {

                                columnes2[0] = Boolean.TRUE;

                            } else {

                                columnes2[0] = Boolean.FALSE;

                            }
                            columnes2[1] = modC.MostrarGrupsElements().get(i).getNomElement();
                            columnes2[2] = modC.MostrarGrupsElements().get(i).getUsuariElement();
                            columnes2[3] = modC.MostrarGrupsElements().get(i).getTipusElement();
                            columnes2[4] = modC.MostrarGrupsElements().get(i).getIdElement();
                            model_grups2.addRow(columnes2);

                        }
                        String line2 = "";
                        for (int i = 0; i < mod.getElementArrayList().size(); i++) {

                            line2 = line2 + mod.getElementArrayList().get(i) + "\n";
                        }
                        vis.jTextGrupUsuaris1.setText(line2);

                        vis.jTableCrearGrups.setModel(model_grups2);
                        addCheckBox(0, vis.jTableCrearGrups);
                        vis.jTableCrearGrups.removeColumn(vis.jTableCrearGrups.getColumnModel().getColumn(4));
                        TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrups.getModel()));
                        vis.jTableCrearGrups.setRowSorter(sorter2);
                        vis.jButtonAfegirElement1.setVisible(true);
                        vis.jButtonAfegir1.setVisible(false);
                        vis.DashInfoGrup.setVisible(true);
                        vis.DashGrups.setVisible(false);

                        break;
                    case 2:

                        vis.txt_nomGrup1.setText(mod.getNom());
                        DefaultTableModel model_grups = new DefaultTableModel();
                        model_grups.addColumn("Seleccionar");
                        model_grups.addColumn("Nom");
                        model_grups.addColumn("Cognom");
                        model_grups.addColumn("Usuari");
                        model_grups.addColumn("ID");

                        Object[] columnes = new Object[5];

                        int numRegistres = modC.MostrarGrupsUsuaris().size();
                        System.out.println("Num: " + numRegistres);

                        for (int i = 0; i < numRegistres; i++) {

                            String nomU = modC.MostrarGrupsUsuaris().get(i).getUsuari();
                            System.out.println("Error" + nomU);
                            System.out.println("Array" + mod.getUsuariArrayList());
                            if (mod.getUsuariArrayList().contains(nomU)) {

                                columnes[0] = Boolean.TRUE;

                            } else {

                                columnes[0] = Boolean.FALSE;

                            }
                            columnes[1] = modC.MostrarGrupsUsuaris().get(i).getNomUsuari();
                            columnes[2] = modC.MostrarGrupsUsuaris().get(i).getCognom();
                            columnes[3] = modC.MostrarGrupsUsuaris().get(i).getUsuari();
                            columnes[4] = modC.MostrarGrupsUsuaris().get(i).getIdUsuari();
                            model_grups.addRow(columnes);

                        }
                        String line = "";
                        for (int i = 0; i < mod.getUsuariArrayList().size(); i++) {

                            line = line + mod.getUsuariArrayList().get(i) + "\n";
                        }
                        vis.jTextGrupUsuaris1.setText(line);

                        vis.jTableCrearGrups.setModel(model_grups);
                        addCheckBox(0, vis.jTableCrearGrups);
                        vis.jTableCrearGrups.removeColumn(vis.jTableCrearGrups.getColumnModel().getColumn(4));
                        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTableCrearGrups.getModel()));
                        vis.jTableCrearGrups.setRowSorter(sorter);
                        vis.jButtonAfegirElement1.setVisible(false);
                        vis.jButtonAfegir1.setVisible(true);
                        vis.DashInfoGrup.setVisible(true);
                        vis.DashGrups.setVisible(false);
                        break;

                    default:

                        break;

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

}
