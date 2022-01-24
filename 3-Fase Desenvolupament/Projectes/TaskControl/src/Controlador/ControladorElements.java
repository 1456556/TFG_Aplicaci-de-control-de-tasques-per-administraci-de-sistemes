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
import Vista.JFPrincipal2;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
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
    private JFPrincipal2 vis;
    public DefaultTableModel modelElements;

    public ControladorElements(Elements mod, ConsultesElements modC, JFPrincipal2 vis) {

        this.mod = mod;
        this.modC = modC;
        this.vis = vis;

        this.vis.jButtonNouOrdinador.addActionListener(this);
        this.vis.jButtonRegistarOrdinador.addActionListener(this);
        this.vis.jButtonEditarOrdinador.addActionListener(this);
        this.vis.jTable_Ordinadors.addMouseListener(this);
        this.vis.jButtonEliminarOrdinadors.addActionListener(this);
        this.vis.txtBuscadorOrdinadors.addKeyListener(this);
        this.vis.txtBuscadorImpresores.addKeyListener(this);
        this.vis.txtBuscadorTelefons.addKeyListener(this);
//        this.vis.jButtonOrdinadors.addMouseListener(this);
        //  this.vis.jButtonTelefons.addMouseListener(this);
        this.vis.jButtonNouTelefon.addActionListener(this);
        this.vis.jButtonNouImpresora.addActionListener(this);
        this.vis.jButtonEliminarImpresores.addActionListener(this);
        this.vis.jButtonRegistarTelefon.addActionListener(this);
        this.vis.jButtonEditarTelefon.addActionListener(this);
        // this.vis.jButtonImpresores.addMouseListener(this);
        // this.vis.jButtonServidors.addMouseListener(this);
        // this.vis.jButtonDispositiusXarxa.addMouseListener(this);
        this.vis.jButtonEliminarTelefons.addActionListener(this);
        this.vis.jTable_Telefons.addMouseListener(this);
        this.vis.jButtonActualitzarImp.addActionListener(this);
        this.vis.jTable_Impresores.addMouseListener(this);
        this.vis.jButtonEditarImp.addActionListener(this);
        this.vis.jButtonNouServidor.addActionListener(this);
        this.vis.jTable_Servidors.addMouseListener(this);
        this.vis.jButtonEliminarServidors.addActionListener(this);
        this.vis.jButtonGuardarSer.addActionListener(this);
        this.vis.txtBuscadorServidors.addKeyListener(this);

        ButtonGroup groupOrdinadors = new ButtonGroup();
        groupOrdinadors.add(this.vis.jRadioButtonCompraOrdinador);
        groupOrdinadors.add(this.vis.jRadioButtonRentingOrdinador);
        this.vis.jRadioButtonCompraOrdinador.setSelected(true);

        ButtonGroup groupTelefons = new ButtonGroup();
        groupTelefons.add(this.vis.jRadioButtonCompraTel);
        groupTelefons.add(this.vis.jRadioButtonRentingTel);
        this.vis.jRadioButtonCompraTel.setSelected(true);

    }

    public void inicialitzar(int menu) {

        if (menu == 21) {
            vis.DashNouOrdinador.setVisible(true);
            vis.DashOrdinadors.setVisible(false);
            MostrarTaulaOrdinadors();
        }

        if (menu == 22) {

            vis.DashNouTelefon.setVisible(true);
            vis.DashTelefons.setVisible(false);
            MostrarTaulaTelefons();

        }

        if (menu == 23) {

            vis.DashImpresores.setVisible(false);
            vis.DashNouImpresora.setVisible(true);
            MostrarTaulaImpresores();

        }

        if (menu == 24) {

            vis.DashServidors.setVisible(false);
            vis.DashImpresores.setVisible(true);
            MostrarTaulaServidors();

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

        if (e.getSource() == vis.jButtonNouTelefon) {

            vis.DashNouTelefon.setVisible(true);
            vis.DashTelefons.setVisible(false);

            DefaultComboBoxModel mdl = new DefaultComboBoxModel();
            mdl.removeAllElements();
            vis.ComboUsuariAssignatTel.setModel(mdl);
            vis.ComboUsuariAssignatTel.setSelectedItem(Login.usuari);
            modC.UsuariAssignat(vis);
            AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatTel);

        }

        if (e.getSource() == vis.jButtonNouImpresora) {

            vis.DashNouImpresora.setVisible(true);
            vis.DashImpresores.setVisible(false);
        }

        if (e.getSource() == vis.jButtonNouServidor) {

            vis.DashNouServidor.setVisible(true);
            vis.DashServidors.setVisible(false);
        }

        /* if (e.getSource() == vis.jButtonDispositiusXarxa) {

            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(true);
        }*/
        if (e.getSource() == vis.jButtonRegistarOrdinador) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomElem.getText().trim());
            mod.setModel(vis.txt_model.getText().trim());
            mod.setNumeroSerie(vis.txt_numserie.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignatOrdinador.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacions.getText().trim());
            mod.setData(vis.dataIngresOrdinador.getDateStringOrEmptyString());
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

        if (e.getSource() == vis.jButtonRegistarTelefon) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomTel.getText().trim());
            mod.setModel(vis.txt_modelTel.getText().trim());
            mod.setNumeroSerie(vis.txt_imeiTel.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignatTel.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacionsTel.getText().trim());
            mod.setData(vis.dataIngresTel.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaTel.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroTel.getText().trim()));
            int estat = vis.ComboEstatTel.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusTel.getSelectedIndex() + 1;

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

                tipus_string = "SmartPhone";
            }
            if (tipus == 2) {

                tipus_string = "Mòbil";
            }
            if (tipus == 3) {

                tipus_string = "Telèfon";
            }

            if (vis.jRadioButtonCompraTel.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingTel.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.NouTelefon(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouTelefon.setVisible(false);
                    vis.DashTelefons.setVisible(true);
                    MostrarTaulaTelefons();
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

        if (e.getSource() == vis.jButtonActualitzarImp) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomImp.getText().trim());
            mod.setModel(vis.txt_modelImp.getText().trim());
            mod.setNumeroSerie(vis.txt_NumeroSerieImp.getText().trim());
            mod.setDepertament(vis.txt_departamentImp.getText().trim());
            // mod.setUsuariAssignat(vis.ComboUsuariAssignatImp.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacionsImp.getText().trim());
            mod.setData(vis.dataIngresImp.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaImp.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroImp.getText().trim()));
            int estat = vis.ComboEstatImp.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusImp.getSelectedIndex() + 1;

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

                tipus_string = "Tèrmica";
            }
            if (tipus == 2) {

                tipus_string = "Làser";
            }
            if (tipus == 3) {

                tipus_string = "Multifunció";
            }
            if (tipus == 4) {

                tipus_string = "Plotter";
            }
            if (tipus == 5) {

                tipus_string = "3D";
            }
            if (tipus == 6) {

                tipus_string = "Etiquetes";
            }

            if (vis.jRadioButtonCompraImp.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingImp.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.NouImpresora(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouImpresora.setVisible(false);
                    vis.DashImpresores.setVisible(true);
                    MostrarTaulaImpresores();
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

        if (e.getSource() == vis.jButtonGuardarSer) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomSer.getText().trim());
            mod.setModel(vis.txt_modelSer.getText().trim());
            mod.setNumeroSerie(vis.txt_NumeroSerieSer.getText().trim());
            mod.setDepertament(vis.txt_ubicacioSer.getText().trim());
            mod.setObservacions(vis.txt_observacionsSer.getText().trim());
            mod.setData(vis.dataIngresSer.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaSer.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroSer.getText().trim()));
            mod.setUbicacio(vis.txt_ubicacioSer.getText().trim());
            mod.setSistemaOperatiu(vis.txt_SistemaOperatiu.getText().trim());
            int estat = vis.ComboEstatSer.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusSer.getSelectedIndex() + 1;

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

                tipus_string = "Tèrmica";
            }
            if (tipus == 2) {

                tipus_string = "Làser";
            }
            if (tipus == 3) {

                tipus_string = "Multifunció";
            }
            if (tipus == 4) {

                tipus_string = "Plotter";
            }
            if (tipus == 5) {

                tipus_string = "3D";
            }
            if (tipus == 6) {

                tipus_string = "Etiquetes";
            }

            if (vis.jRadioButtonCompraSer.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingSer.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.NouServidor(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouServidor.setVisible(false);
                    vis.DashServidors.setVisible(true);
                    MostrarTaulaServidors();
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
            mod.setNom(vis.txt_nomElem1.getText().trim());
            mod.setModel(vis.txt_model1.getText().trim());
            mod.setNumeroSerie(vis.txt_numserie1.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignatOrdinador1.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacions1.getText().trim());
            mod.setData(vis.dataIngresOrdinador1.getDate().toString());
            mod.setMarca(vis.txt_marca1.getText().trim());
            int estat = vis.ComboEstatElem1.getSelectedIndex() + 1;
            int tipus = vis.ComboTipus1.getSelectedIndex() + 1;

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
        if (e.getSource() == vis.jButtonEditarTelefon) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomTel1.getText().trim());
            mod.setModel(vis.txt_modelTel1.getText().trim());
            mod.setNumeroSerie(vis.txt_imeiTel1.getText().trim());
            mod.setUsuariAssignat(vis.ComboUsuariAssignatTel1.getSelectedItem().toString());
            mod.setObservacions(vis.txt_observacionsTel1.getText().trim());
            mod.setData(vis.dataIngresTel1.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaTel1.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroTel1.getText().trim()));
            int estat = vis.ComboEstatTel1.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusTel1.getSelectedIndex() + 1;

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

                tipus_string = "SmartPhone";
            }
            if (tipus == 2) {

                tipus_string = "Mòbil";
            }
            if (tipus == 3) {

                tipus_string = "Telèfon";
            }

            if (vis.jRadioButtonCompraTel1.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingTel1.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.EditarTelefon(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashInfoImpresores.setVisible(false);
                    vis.DashImpresores.setVisible(true);
                    MostrarTaulaImpresores();
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

        if (e.getSource() == vis.jButtonEditarImp) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomImp1.getText().trim());
            mod.setModel(vis.txt_modelImp1.getText().trim());
            mod.setNumeroSerie(vis.txt_NumeroSerieImp1.getText().trim());
            mod.setDepertament(vis.txt_departamentImp1.getText().trim());
            mod.setObservacions(vis.txt_observacionsImp1.getText().trim());
            mod.setData(vis.dataIngresImp1.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaImp1.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroImp1.getText().trim()));
            int estat = vis.ComboEstatImp1.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusImp1.getSelectedIndex() + 1;

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

                tipus_string = "Tèrmica";
            }
            if (tipus == 2) {

                tipus_string = "Làser";
            }
            if (tipus == 3) {

                tipus_string = "Multifunció";
            }
            if (tipus == 4) {

                tipus_string = "Plotter";
            }
            if (tipus == 5) {

                tipus_string = "3D";
            }
            if (tipus == 6) {

                tipus_string = "Etiquetes";
            }

            if (vis.jRadioButtonCompraImp1.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingImp1.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.EditarImpresora(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashInfoImpresores.setVisible(false);
                    vis.DashImpresores.setVisible(true);
                    MostrarTaulaImpresores();
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

        if (e.getSource() == vis.jButtonGuardarSer1) {

            String tipus_string = null, estat_string = null;
            mod.setNom(vis.txt_nomSer1.getText().trim());
            mod.setModel(vis.txt_modelSer1.getText().trim());
            mod.setNumeroSerie(vis.txt_NumeroSerieSer1.getText().trim());
            mod.setDepertament(vis.txt_ubicacioSer1.getText().trim());
            mod.setObservacions(vis.txt_observacionsSer1.getText().trim());
            mod.setData(vis.dataIngresSer1.getDateStringOrEmptyString());
            mod.setMarca(vis.txt_marcaSer1.getText().trim());
            mod.setNumeroTel(Integer.valueOf(vis.txt_numeroSer1.getText().trim()));
            mod.setUbicacio(vis.txt_ubicacioSer1.getText().trim());
            mod.setSistemaOperatiu(vis.txt_SistemaOperatiu1.getText().trim());
            int estat = vis.ComboEstatSer1.getSelectedIndex() + 1;
            int tipus = vis.ComboTipusSer1.getSelectedIndex() + 1;

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

                tipus_string = "Tèrmica";
            }
            if (tipus == 2) {

                tipus_string = "Làser";
            }
            if (tipus == 3) {

                tipus_string = "Multifunció";
            }
            if (tipus == 4) {

                tipus_string = "Plotter";
            }
            if (tipus == 5) {

                tipus_string = "3D";
            }
            if (tipus == 6) {

                tipus_string = "Etiquetes";
            }

            if (vis.jRadioButtonCompraSer1.isSelected()) {

                mod.setAdquisicio("Compra");

            }

            if (vis.jRadioButtonRentingSer1.isSelected()) {

                mod.setAdquisicio("Renting");
            }

            mod.setEstat(estat_string);
            mod.setTipus(tipus_string);

            switch (modC.EditarServidor(mod)) {

                case 1:
                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    natejar();
                    vis.DashNouServidor.setVisible(false);
                    vis.DashServidors.setVisible(true);
                    MostrarTaulaServidors();
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

        if (e.getSource() == vis.jButtonEliminarTelefons) {

            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Telefons.getRowSorter();
            DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Telefons.getModel();
            int rows = trs.getViewRowCount();
            System.out.print("ROOOWS " + rows);
            int j = rows - 1;

            for (int i = j; i >= 0; i--) {

                Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                System.out.print("Boolean " + checked);
                //DISPLAY
                if (checked) {
                    System.out.print("ROW COUNT" + vis.jTable_Telefons.getRowCount());
                    int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 6);
                    mod.setId(id);
                    model_tasques3.removeRow(i);
                    if (modC.EliminarElement(mod) == false) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar, contacti amb l'administrador");

                    }
                }
            }
            MostrarTaulaTelefons();

        }

        if (e.getSource() == vis.jButtonEliminarImpresores) {

            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Impresores.getRowSorter();
            DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Impresores.getModel();
            int rows = trs.getViewRowCount();
            System.out.print("ROOOWS " + rows);
            int j = rows - 1;

            for (int i = j; i >= 0; i--) {

                Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                System.out.print("Boolean " + checked);
                //DISPLAY
                if (checked) {
                    System.out.print("ROW COUNT" + vis.jTable_Impresores.getRowCount());
                    int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 6);
                    mod.setId(id);
                    model_tasques3.removeRow(i);
                    if (modC.EliminarElement(mod) == false) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar, contacti amb l'administrador");

                    }
                }
            }
            MostrarTaulaImpresores();

        }

        if (e.getSource() == vis.jButtonEliminarServidors) {

            TableRowSorter<DefaultTableModel> trs = new TableRowSorter();
            trs = (TableRowSorter<DefaultTableModel>) vis.jTable_Servidors.getRowSorter();
            DefaultTableModel model_tasques3 = (DefaultTableModel) vis.jTable_Servidors.getModel();
            int rows = trs.getViewRowCount();
            System.out.print("ROOOWS " + rows);
            int j = rows - 1;

            for (int i = j; i >= 0; i--) {

                Boolean checked = Boolean.valueOf(model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 0).toString());
                System.out.print("Boolean " + checked);
                //DISPLAY
                if (checked) {
                    System.out.print("ROW COUNT" + vis.jTable_Servidors.getRowCount());
                    int id = (int) model_tasques3.getValueAt(trs.convertRowIndexToModel(i), 6);
                    mod.setId(id);
                    model_tasques3.removeRow(i);
                    if (modC.EliminarElement(mod) == false) {

                        JOptionPane.showMessageDialog(null, "Error al eliminar, contacti amb l'administrador");

                    }
                }
            }
            MostrarTaulaServidors();

        }

    }

    public void MostrarTaulaOrdinadors() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        /*        vis.TasquesTotalsElements.setText(String.valueOf(tas.getTasquesTotals()));
        vis.TasquesTotalsElements.setEditable(false);
        vis.TasquesAsignadesElements.setText(String.valueOf(tas.getTasquesAssingades()));
        vis.TasquesAsignadesElements.setEditable(false);
        vis.TasquesGestionadesElements.setText(String.valueOf(tas.getTasquesPendents()));
        vis.TasquesGestionadesElements.setEditable(false);*/

        DefaultPieDataset datos = new DefaultPieDataset();
        datos.setValue("HP", 50);
        datos.setValue("Asus", 150);
        datos.setValue("Lenovo", 30);
        datos.setValue("Appel", 20);

        JFreeChart grafico_circular = ChartFactory.createPieChart("", datos, false, false, false);
        ChartPanel panel = new ChartPanel(grafico_circular);
        panel.setMouseWheelEnabled(true);
        panel.setPreferredSize(new Dimension(300, 175));
//        vis.jPanel1.setLayout(new BorderLayout());
        //  vis.jPanel1.add(panel, BorderLayout.EAST);

        DefaultPieDataset datos2 = new DefaultPieDataset();
        datos2.setValue("Portatil", 50);
        datos2.setValue("Escriptori", 150);

        JFreeChart grafico_circular2 = ChartFactory.createPieChart("", datos2, false, false, false);
        ChartPanel panel2 = new ChartPanel(grafico_circular2);
        panel2.setMouseWheelEnabled(true);
        panel2.setPreferredSize(new Dimension(300, 175));
        //vis.jPanel1.setLayout(new BorderLayout());
//        vis.jPanel1.add(panel2, BorderLayout.WEST);

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

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < vis.jTable_Ordinadors.getColumnCount(); i++) {

            vis.jTable_Ordinadors.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        addCheckBox(0, vis.jTable_Ordinadors);
        vis.jTable_Ordinadors.removeColumn(vis.jTable_Ordinadors.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Ordinadors.getModel()));
        vis.jTable_Ordinadors.setRowSorter(sorter3);

    }

    public void MostrarTaulaTelefons() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        DefaultTableModel model_elements = new DefaultTableModel();

        model_elements.addColumn("Seleccionar");
        model_elements.addColumn("Nom");
        model_elements.addColumn("Usuari Assignat");
        model_elements.addColumn("Tipus");
        model_elements.addColumn("Marca");
        model_elements.addColumn("Estat");
        model_elements.addColumn("ID");

        Object[] columna = new Object[7];

        int numRegistres = modC.MostrarTelefons().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarTelefons().get(i).getNom();
            columna[2] = modC.MostrarTelefons().get(i).getUsuariAssignat();
            columna[3] = modC.MostrarTelefons().get(i).getTipus();
            columna[4] = modC.MostrarTelefons().get(i).getMarca();
            columna[5] = modC.MostrarTelefons().get(i).getEstat();
            columna[6] = modC.MostrarTelefons().get(i).getId();
            model_elements.addRow(columna);

            mod.setId(modC.MostrarTelefons().get(i).getId());
            modC.GuardarId(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_elements.setValueAt(false, i, 0);

        }

        vis.jTable_Telefons.setModel(model_elements);
        modelElements = model_elements;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < vis.jTable_Telefons.getColumnCount(); i++) {

            vis.jTable_Telefons.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        addCheckBox(0, vis.jTable_Telefons);
        vis.jTable_Telefons.removeColumn(vis.jTable_Telefons.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Telefons.getModel()));
        vis.jTable_Telefons.setRowSorter(sorter3);

    }

    public void MostrarTaulaServidors() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        DefaultTableModel model_elements = new DefaultTableModel();

        model_elements.addColumn("Seleccionar");
        model_elements.addColumn("Nom");
        model_elements.addColumn("Ubicació");
        model_elements.addColumn("Tipus");
        model_elements.addColumn("Marca");
        model_elements.addColumn("Estat");
        model_elements.addColumn("ID");

        Object[] columna = new Object[7];

        int numRegistres = modC.MostrarServidors().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarServidors().get(i).getNom();
            columna[2] = modC.MostrarServidors().get(i).getUbicacio();
            columna[3] = modC.MostrarServidors().get(i).getTipus();
            columna[4] = modC.MostrarServidors().get(i).getMarca();
            columna[5] = modC.MostrarServidors().get(i).getEstat();
            columna[6] = modC.MostrarServidors().get(i).getId();
            model_elements.addRow(columna);

            mod.setId(modC.MostrarServidors().get(i).getId());
            modC.GuardarId(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_elements.setValueAt(false, i, 0);

        }

        vis.jTable_Servidors.setModel(model_elements);
        modelElements = model_elements;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < vis.jTable_Servidors.getColumnCount(); i++) {

            vis.jTable_Servidors.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        addCheckBox(0, vis.jTable_Servidors);
        vis.jTable_Servidors.removeColumn(vis.jTable_Servidors.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Servidors.getModel()));
        vis.jTable_Servidors.setRowSorter(sorter3);

    }

    public void MostrarTaulaImpresores() {

        Tasques tas = new Tasques();
        ConsultesTasques tasC = new ConsultesTasques();
        tasC.contadorTasques(tas);
        DefaultTableModel model_elements = new DefaultTableModel();

        model_elements.addColumn("Seleccionar");
        model_elements.addColumn("Nom");
        model_elements.addColumn("Departament");
        model_elements.addColumn("Tipus");
        model_elements.addColumn("Marca");
        model_elements.addColumn("Estat");
        model_elements.addColumn("ID");

        Object[] columna = new Object[7];

        int numRegistres = modC.MostrarImpresores().size();
        System.out.println("Num: " + numRegistres);

        for (int i = 0; i < numRegistres; i++) {

            columna[1] = modC.MostrarImpresores().get(i).getNom();
            columna[2] = modC.MostrarImpresores().get(i).getDepertament();
            columna[3] = modC.MostrarImpresores().get(i).getTipus();
            columna[4] = modC.MostrarImpresores().get(i).getMarca();
            columna[5] = modC.MostrarImpresores().get(i).getEstat();
            columna[6] = modC.MostrarImpresores().get(i).getId();
            model_elements.addRow(columna);

            mod.setId(modC.MostrarImpresores().get(i).getId());
            modC.GuardarId(mod);

        }

        for (int i = 0; i < numRegistres; i++) {

            model_elements.setValueAt(false, i, 0);

        }

        vis.jTable_Impresores.setModel(model_elements);
        modelElements = model_elements;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < vis.jTable_Impresores.getColumnCount(); i++) {

            vis.jTable_Impresores.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

        }

        addCheckBox(0, vis.jTable_Impresores);
        vis.jTable_Impresores.removeColumn(vis.jTable_Impresores.getColumnModel().getColumn(6));

        TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Impresores.getModel()));
        vis.jTable_Impresores.setRowSorter(sorter3);

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

        vis.txt_nomImp.setText("");
        vis.dataIngresImp.setDateToToday();
        vis.txt_observacionsImp.setText("");
        vis.ComboEstatImp.setSelectedIndex(0);
        vis.ComboTipusImp.setSelectedIndex(0);
        vis.txt_modelImp.setText("");
        vis.txt_marcaImp.setText("");
        vis.txt_NumeroSerieImp.setText("");
        vis.txt_departamentImp.setText("");

        vis.txt_nomSer.setText("");
        vis.dataIngresSer.setDateToToday();
        vis.txt_observacionsSer.setText("");
        vis.ComboEstatSer.setSelectedIndex(0);
        vis.ComboTipusSer.setSelectedIndex(0);
        vis.txt_modelSer.setText("");
        vis.txt_marcaSer.setText("");
        vis.txt_NumeroSerieSer.setText("");
        vis.txt_ubicacioSer.setText("");
        vis.txt_SistemaOperatiu.setText("");

        vis.txt_nomImp1.setText("");
        vis.dataIngresImp1.setDateToToday();
        vis.txt_observacionsImp1.setText("");
        vis.ComboEstatImp1.setSelectedIndex(0);
        vis.ComboTipusImp1.setSelectedIndex(0);
        vis.txt_modelImp1.setText("");
        vis.txt_marcaImp1.setText("");
        vis.txt_NumeroSerieImp1.setText("");
        vis.txt_departamentImp1.setText("");

        vis.txt_nomElem1.setText("");
        vis.dataIngresOrdinador1.setDateToToday();
        vis.txt_observacions1.setText("");
        vis.ComboEstatElem1.setSelectedIndex(0);
        vis.ComboTipus1.setSelectedIndex(0);
        vis.txt_model1.setText("");
        vis.txt_marca1.setText("");
        vis.txt_numserie1.setText("");

    }

    public LocalDate convertData2LocalDate() {

        String d3 = mod.getData();
        String date3 = d3.substring(0, 10);
        String data3 = date3.replace("-", "/");
        System.out.println("DATAASAAAAAAAA:" + d3);
        System.out.println("sSubCadena:" + date3);
        System.out.println("sSubCadena:" + data3);
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("yyyy/MM/d");
        LocalDate localDate = LocalDate.parse(data3, formatter5);

        return localDate;

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

                    DefaultComboBoxModel mdl = new DefaultComboBoxModel();
                    mdl.removeAllElements();
                    vis.ComboUsuariAssignatOrdinador1.setModel(mdl);
                    modC.UsuariAssignat(vis);
                    AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatOrdinador1);

                    vis.txt_nomElem1.setText(mod.getNom());
                    vis.ComboUsuariAssignatOrdinador1.setSelectedItem(mod.getUsuariAssignat());
                    vis.txt_observacions1.setText(mod.getObservacions());
                    vis.ComboTipus1.setSelectedItem(mod.getTipus());
                    vis.ComboEstatElem1.setSelectedItem(mod.getEstat());
                    vis.txt_marca1.setText(mod.getMarca());
                    vis.txt_numserie1.setText(mod.getNumeroSerie());
                    vis.txt_model1.setText(mod.getModel());
                    vis.dataIngresOrdinador1.setDate(convertData2LocalDate());

                    if (mod.getAdquisicio() == "Compra") {

                        vis.jRadioButtonCompraOrdinador1.setSelected(true);

                    } else {

                        vis.jRadioButtonRentingOrdinador1.setSelected(true);

                    }
                    vis.DashInfoOrdinador.setVisible(true);
                    vis.DashOrdinadors.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }
            }
        }

        if (e.getSource() == vis.jTable_Telefons) {

            int fila_point1 = vis.jTable_Telefons.rowAtPoint(e.getPoint());
            int columna_point1 = vis.jTable_Telefons.columnAtPoint(e.getPoint());
            int columna1 = 1;

            System.out.println("Fila" + fila_point1);
            System.out.println("Columna" + columna_point1);
            vis.jTable_Telefons.repaint();
            vis.jTable_Telefons.updateUI();

            if (fila_point1 > -1 && columna_point1 > 0) {

                TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter();
                trs1 = (TableRowSorter<DefaultTableModel>) vis.jTable_Telefons.getRowSorter();
                DefaultTableModel model_tasques1 = (DefaultTableModel) vis.jTable_Telefons.getModel();
                String nom1 = String.valueOf(model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), columna1));
                System.out.println("Nom" + nom1);
                mod.setNom(nom1);
                int id1 = (int) model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), 6);
                mod.setId(id1);
                System.out.println("INT_ID: " + mod.getId());

                if (modC.informacioElement(mod) == 1) {

                    DefaultComboBoxModel mdl = new DefaultComboBoxModel();
                    mdl.removeAllElements();
                    vis.ComboUsuariAssignatTel1.setModel(mdl);
                    modC.UsuariAssignat(vis);
                    AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatTel1);

                    vis.txt_nomTel1.setText(mod.getNom());
                    vis.ComboUsuariAssignatTel1.setSelectedItem(mod.getUsuariAssignat());
                    vis.txt_observacionsTel1.setText(mod.getObservacions());
                    vis.ComboTipusTel1.setSelectedItem(mod.getTipus());
                    vis.ComboEstatTel1.setSelectedItem(mod.getEstat());
                    vis.txt_marcaTel1.setText(mod.getMarca());
                    vis.txt_imeiTel1.setText(mod.getNumeroSerie());
                    vis.txt_modelTel1.setText(mod.getModel());
                    vis.dataIngresTel1.setDate(convertData2LocalDate());
                    vis.txt_numeroTel1.setText(Integer.toString(mod.getNumeroTel()));

                    if (mod.getAdquisicio() == "Compra") {

                        vis.jRadioButtonCompraTel1.setSelected(true);

                    } else {

                        vis.jRadioButtonRentingTel1.setSelected(true);

                    }
                    vis.DashInfoTelefon.setVisible(true);
                    vis.DashTelefons.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }

            }

        }

        if (e.getSource() == vis.jTable_Impresores) {

            int fila_point1 = vis.jTable_Impresores.rowAtPoint(e.getPoint());
            int columna_point1 = vis.jTable_Impresores.columnAtPoint(e.getPoint());
            int columna1 = 1;

            System.out.println("Fila" + fila_point1);
            System.out.println("Columna" + columna_point1);
            vis.jTable_Impresores.repaint();
            vis.jTable_Impresores.updateUI();

            if (fila_point1 > -1 && columna_point1 > 0) {

                TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter();
                trs1 = (TableRowSorter<DefaultTableModel>) vis.jTable_Impresores.getRowSorter();
                DefaultTableModel model_tasques1 = (DefaultTableModel) vis.jTable_Impresores.getModel();
                String nom1 = String.valueOf(model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), columna1));
                System.out.println("Nom" + nom1);
                mod.setNom(nom1);
                int id1 = (int) model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), 6);
                mod.setId(id1);
                System.out.println("INT_ID: " + mod.getId());

                if (modC.informacioElement(mod) == 1) {

                    DefaultComboBoxModel mdl = new DefaultComboBoxModel();
                    mdl.removeAllElements();
                    vis.ComboUsuariAssignatTel1.setModel(mdl);
                    modC.UsuariAssignat(vis);
                    AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatTel1);

                    vis.txt_nomImp1.setText(mod.getNom());
                    vis.txt_departamentImp1.setText(mod.getDepertament());
                    vis.txt_observacionsImp1.setText(mod.getObservacions());
                    vis.ComboTipusImp1.setSelectedItem(mod.getTipus());
                    vis.ComboEstatImp1.setSelectedItem(mod.getEstat());
                    vis.txt_marcaImp1.setText(mod.getMarca());
                    vis.txt_NumeroSerieImp1.setText(mod.getNumeroSerie());
                    vis.txt_modelImp1.setText(mod.getModel());
                    vis.dataIngresImp1.setDate(convertData2LocalDate());
                    vis.txt_numeroImp1.setText(Integer.toString(mod.getNumeroTel()));

                    if (mod.getAdquisicio() == "Compra") {

                        vis.jRadioButtonCompraTel1.setSelected(true);

                    } else {

                        vis.jRadioButtonRentingTel1.setSelected(true);

                    }
                    vis.DashInfoImpresores.setVisible(true);
                    vis.DashImpresores.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }

            }

        }

        if (e.getSource() == vis.jTable_Servidors) {

            int fila_point1 = vis.jTable_Servidors.rowAtPoint(e.getPoint());
            int columna_point1 = vis.jTable_Servidors.columnAtPoint(e.getPoint());
            int columna1 = 1;

            System.out.println("Fila" + fila_point1);
            System.out.println("Columna" + columna_point1);
            vis.jTable_Servidors.repaint();
            vis.jTable_Servidors.updateUI();

            if (fila_point1 > -1 && columna_point1 > 0) {

                TableRowSorter<DefaultTableModel> trs1 = new TableRowSorter();
                trs1 = (TableRowSorter<DefaultTableModel>) vis.jTable_Servidors.getRowSorter();
                DefaultTableModel model_tasques1 = (DefaultTableModel) vis.jTable_Servidors.getModel();
                String nom1 = String.valueOf(model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), columna1));
                System.out.println("Nom" + nom1);
                mod.setNom(nom1);
                int id1 = (int) model_tasques1.getValueAt(trs1.convertRowIndexToModel(fila_point1), 6);
                mod.setId(id1);
                System.out.println("INT_ID: " + mod.getId());

                if (modC.informacioElement(mod) == 1) {

                    /*DefaultComboBoxModel mdl = new DefaultComboBoxModel();
                    mdl.removeAllElements();
                    vis.ComboUsuariAssignatTel1.setModel(mdl);
                    modC.UsuariAssignat(vis);
                    AutoCompleteDecorator.decorate(vis.ComboUsuariAssignatTel1);*/
                    vis.txt_nomSer1.setText(mod.getNom());
                    vis.txt_ubicacioSer1.setText(mod.getUbicacio());
                    vis.txt_observacionsSer1.setText(mod.getObservacions());
                    vis.ComboTipusSer1.setSelectedItem(mod.getTipus());
                    vis.ComboEstatSer1.setSelectedItem(mod.getEstat());
                    vis.txt_marcaSer1.setText(mod.getMarca());
                    vis.txt_NumeroSerieSer1.setText(mod.getNumeroSerie());
                    vis.txt_modelSer1.setText(mod.getModel());
                    vis.dataIngresSer1.setDate(convertData2LocalDate());
                    vis.txt_numeroSer1.setText(Integer.toString(mod.getNumeroTel()));

                    if (mod.getAdquisicio() == "Compra") {

                        vis.jRadioButtonCompraSer1.setSelected(true);

                    } else {

                        vis.jRadioButtonRentingSer1.setSelected(true);

                    }
                    vis.DashInfoServidor.setVisible(true);
                    vis.DashServidors.setVisible(false);

                } else {

                    JOptionPane.showMessageDialog(null, "Error al mostrar l'informacio, contacti amb l'administrador");

                }

            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e
    ) {

    }

    @Override
    public void mouseReleased(MouseEvent e
    ) {

    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {

    }

    @Override
    public void mouseExited(MouseEvent e
    ) {

    }

    @Override
    public void keyTyped(KeyEvent e
    ) {

    }

    @Override
    public void keyPressed(KeyEvent e
    ) {

    }

    @Override
    public void keyReleased(KeyEvent e
    ) {

        if (e.getSource() == vis.txtBuscadorOrdinadors) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Ordinadors.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorOrdinadors.getText()));
            vis.jTable_Ordinadors.setRowSorter(sorter3);

        }

        if (e.getSource() == vis.txtBuscadorTelefons) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Telefons.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorTelefons.getText()));
            vis.jTable_Telefons.setRowSorter(sorter3);

        }

        if (e.getSource() == vis.txtBuscadorImpresores) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Impresores.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorImpresores.getText()));
            vis.jTable_Impresores.setRowSorter(sorter3);

        }

        if (e.getSource() == vis.txtBuscadorServidors) {

            TableRowSorter<TableModel> sorter3 = new TableRowSorter<TableModel>(((DefaultTableModel) vis.jTable_Servidors.getModel()));
            sorter3.setRowFilter(RowFilter.regexFilter(vis.txtBuscadorServidors.getText()));
            vis.jTable_Servidors.setRowSorter(sorter3);

        }

    }

}
