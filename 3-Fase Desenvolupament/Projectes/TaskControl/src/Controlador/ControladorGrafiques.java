/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.ConsultesGrafiques;
import Vista.JFPrincipal2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Victor
 */
public class ControladorGrafiques implements ActionListener {

    private ConsultesGrafiques modC;
    private JFPrincipal2 vis;
    public boolean barres = false;
    public boolean circular = false;
    public boolean lineal = false;
    public DefaultTableModel miModelo;

    public ControladorGrafiques(JFPrincipal2 vis, ConsultesGrafiques modC) {

        this.vis = vis;
        this.modC = modC;
        this.vis.jToggleButtonActualitzarGrafic.addActionListener(this);
        this.vis.jRadioButton2D.addActionListener(this);
        this.vis.jRadioButton3D.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(this.vis.jRadioButton2D);
        group.add(this.vis.jRadioButton3D);

        this.vis.jRadioButton2D.setSelected(true);
        this.vis.jTableGrafica.setVisible(false);
        this.vis.jScrollPane1.setVisible(false);
    }

    public void inicialitzar() {

        graficaTipus(1, 2);
    }

    public void graficaTipus(int tipus, int d) {

        System.out.println("numero" + tipus);
        vis.jPanelTipus.updateUI();
        vis.jPanelTipus.removeAll();
        modC.agruparPrioritats();
        miModelo = modC.agruparTipus();
        vis.jTableGrafica.setModel(miModelo);
        vis.jTableGrafica.setValueAt("Tasques Recurrents", 0, 0);
        vis.jTableGrafica.setValueAt("Tasques Simples", 1, 0);

        if (d == 1) {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String tipus1 = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countipus = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroTipus = Integer.valueOf(countipus);

                    System.out.println("hola" + tipus1 + countipus);

                    datos.setValue(tipus1, numeroTipus);

                }
                JFreeChart ch = ChartFactory.createPieChart("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());

                }
                JFreeChart ch = ChartFactory.createBarChart("", "Tipus Tasques", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), " ", vis.jTableGrafica.getValueAt(i, 0).toString());
                }

                JFreeChart ch2 = ChartFactory.createLineChart("", "Tipus Tasques", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        } else {
            System.out.println("HOla fora");
            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String tipus1 = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countipus = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroTipus = Integer.valueOf(countipus);
                    System.out.println("hola" + tipus1 + countipus);
                    datos.setValue(tipus1, numeroTipus);

                    JFreeChart ch = ChartFactory.createPieChart3D("", datos, false, true, true);
                    ChartPanel panel = new ChartPanel(ch);
                    panel.setMouseWheelEnabled(true);
                    panel.setPreferredSize(new Dimension(1059, 454));
                    vis.jPanelTipus.setLayout(new BorderLayout());
                    vis.jPanelTipus.add(panel, BorderLayout.CENTER);

                }
            }
            if (tipus == 2) {
                System.out.println("HOla");
                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());

                }
                JFreeChart ch = ChartFactory.createBarChart3D("", "Tipus Tasques", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart3D("", "Tipus Tasques", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        }

    }

    public void graficaEstat(int tipus, int d) {

        System.out.println("numero" + tipus);
        vis.jPanelTipus.updateUI();
        vis.jPanelTipus.removeAll();
        miModelo = modC.agruparEstat();
        vis.jTableGrafica.setModel(miModelo);

        if (d == 1) {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), vis.jTableGrafica.getValueAt(i, 0).toString(), vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        } else {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart3D("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), vis.jTableGrafica.getValueAt(i, 0).toString(), vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart3D("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart3D("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        }
    }

    public void graficaPrioritat(int tipus, int d) {

        System.out.println("numero" + tipus);
        vis.jPanelTipus.updateUI();
        vis.jPanelTipus.removeAll();
        modC.agruparPrioritats();
        miModelo = modC.agruparPrioritats();
        vis.jTableGrafica.setModel(miModelo);

        if (d == 1) {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);

                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        } else {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart3D("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart3D("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart3D("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        }

    }

    public void graficaUsuaris(int tipus, int d) {

        System.out.println("numero" + tipus);
        vis.jPanelTipus.updateUI();
        vis.jPanelTipus.removeAll();
        modC.agruparPrioritats();
        miModelo = modC.agruparUsuaris();
        vis.jTableGrafica.setModel(miModelo);

        if (d == 1) {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), vis.jTableGrafica.getValueAt(i, 0).toString(), vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        } else {

            if (tipus == 1) {
                DefaultPieDataset datos = new DefaultPieDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {
                    String prioritat = vis.jTableGrafica.getValueAt(i, 0).toString();
                    String countPrioritat = vis.jTableGrafica.getValueAt(i, 1).toString();
                    int numeroPrioritat = Integer.valueOf(countPrioritat);
                    System.out.println("hola" + prioritat + countPrioritat);
                    datos.setValue(prioritat, numeroPrioritat);

                }
                JFreeChart ch = ChartFactory.createPieChart3D("", datos, false, true, true);
                ChartPanel panel = new ChartPanel(ch);
                panel.setMouseWheelEnabled(true);
                panel.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(panel, BorderLayout.CENTER);

            }
            if (tipus == 2) {

                DefaultCategoryDataset dtsc = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), vis.jTableGrafica.getValueAt(i, 0).toString(), vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch = ChartFactory.createBarChart3D("", "Prioritat", "Nº Tasques", dtsc, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }
            if (tipus == 3) {

                DefaultCategoryDataset dtsc1 = new DefaultCategoryDataset();
                for (int i = 0; i < vis.jTableGrafica.getRowCount(); i++) {

                    dtsc1.setValue(Integer.parseInt(vis.jTableGrafica.getValueAt(i, 1).toString()), "", vis.jTableGrafica.getValueAt(i, 0).toString());
                }
                JFreeChart ch2 = ChartFactory.createLineChart3D("", "Prioritat", "Nº Tasques", dtsc1, PlotOrientation.VERTICAL, false, false, false);
                ChartPanel cp = new ChartPanel(ch2);
                cp.setPreferredSize(new Dimension(1059, 454));
                vis.jPanelTipus.setLayout(new BorderLayout());
                vis.jPanelTipus.add(cp, BorderLayout.CENTER);

            }

        }
    }

    public void graficaTemps() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jToggleButtonActualitzarGrafic) {

            String grafic = vis.jComboBoxGrafic.getSelectedItem().toString();
            String tipus = vis.jComboBoxTipus.getSelectedItem().toString();

            if (grafic.equals("Tipus Tasques") && (tipus.equals("Circular"))) {

                System.out.println("TIPUS / CIRCULAR");

                if (vis.jRadioButton2D.isSelected()) {
                    graficaTipus(1, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaTipus(1, 2);
                }

            }

            if (grafic.equals("Tipus Tasques") && (tipus.equals("Barres"))) {

                System.out.println("TIPUS / BARRES");

                if (vis.jRadioButton2D.isSelected()) {

                    graficaTipus(2, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaTipus(2, 2);
                }

            }

            if (grafic.equals("Tipus Tasques") && (tipus.equals("Lineal"))) {

                System.out.println("TIPUS / LINEAL");
                if (vis.jRadioButton2D.isSelected()) {

                    graficaTipus(3, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaTipus(3, 2);

                }

            }

            if (grafic.equals("Estat Tasques") && (tipus.equals("Circular"))) {

                System.out.println("TIPUS / CIRCULAR");

                if (vis.jRadioButton2D.isSelected()) {
                    graficaEstat(1, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaEstat(1, 2);
                }

            }

            if (grafic.equals("Estat Tasques") && (tipus.equals("Barres"))) {

                System.out.println("TIPUS / BARRES");

                if (vis.jRadioButton2D.isSelected()) {

                    graficaEstat(2, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaEstat(2, 2);
                }

            }

            if (grafic.equals("Estat Tasques") && (tipus.equals("Lineal"))) {

                System.out.println("TIPUS / LINEAL");
                if (vis.jRadioButton2D.isSelected()) {

                    graficaEstat(3, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaEstat(3, 2);

                }

            }

            if (grafic.equals("Prioritat Tasques") && (tipus.equals("Circular"))) {

                if (vis.jRadioButton2D.isSelected()) {
                    graficaPrioritat(1, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaPrioritat(1, 2);
                }
            }

            if (grafic.equals("Prioritat Tasques") && (tipus.equals("Barres"))) {

                if (vis.jRadioButton2D.isSelected()) {
                    graficaPrioritat(2, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaPrioritat(2, 2);
                }

            }
            if (grafic.equals("Prioritat Tasques") && (tipus.equals("Lineal"))) {

                if (vis.jRadioButton2D.isSelected()) {
                    graficaPrioritat(3, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaPrioritat(3, 2);
                }

            }

            if (grafic.equals("Usuaris Assignats") && (tipus.equals("Circular"))) {

                System.out.println("TIPUS / CIRCULAR");

                if (vis.jRadioButton2D.isSelected()) {
                    graficaUsuaris(1, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaUsuaris(1, 2);
                }

            }

            if (grafic.equals("Usuaris Assignats") && (tipus.equals("Barres"))) {

                System.out.println("TIPUS / BARRES");

                if (vis.jRadioButton2D.isSelected()) {

                    graficaUsuaris(2, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaUsuaris(2, 2);
                }

            }

            if (grafic.equals("Usuaris Assignats") && (tipus.equals("Lineal"))) {

                System.out.println("TIPUS / LINEAL");
                if (vis.jRadioButton2D.isSelected()) {

                    graficaUsuaris(3, 1);
                }
                if (vis.jRadioButton3D.isSelected()) {
                    graficaUsuaris(3, 2);

                }

            }

        }
    }

}
