/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorNotificacio;
import MVC.Conexio;
import Model.ConsultesNotificacio;
import Model.Login;
import Model.Notificacio;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Victor
 */
public class JFPrincipal extends javax.swing.JFrame {

    boolean a = true;

    private int xMouse, yMouse;

    public int id;

    public int idTasca;

    public int id_tasca = 0;

    public static String user_update = "", element_update = "", tasca_update = "";

    public boolean jf = false;

    /**
     * Creates new form Ventana_Tasques2
     */
    public JFPrincipal() {

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

        ImageIcon menu_logo = new ImageIcon("src/images/back_32px.png");
        MenuDes.setIcon(menu_logo);
        this.repaint();

        ImageIcon config_logo = new ImageIcon("src/images/settings_32px.png");
        btnConfiguracio.setIcon(config_logo);
        this.repaint();

        ImageIcon tasques_logo = new ImageIcon("src/images/clock-6-32.png");
        btnTasques.setIcon(tasques_logo);
        this.repaint();

        ImageIcon elements_logo = new ImageIcon("src/images/icons8-workstation-30.png");
        btnElements.setIcon(elements_logo);
        this.repaint();

        ImageIcon elements_usuaris = new ImageIcon("src/images/icons8-user-account-30.png");
        btnUsuaris.setIcon(elements_usuaris);
        this.repaint();

        ImageIcon elements_grups = new ImageIcon("src/images/icons8-dog-tag-30.png");
        btnGrup.setIcon(elements_grups);
        this.repaint();

        ImageIcon tancarSessio = new ImageIcon("src/images/icons8-logout-30.png");
        btnTancarSessio.setIcon(tancarSessio);
        this.repaint();

        ImageIcon enrera_logo = new ImageIcon("src/images/icons8-left-35.png");
        Enrera.setIcon(enrera_logo);
        this.repaint();

        ImageIcon logo = new ImageIcon("src/images/ezgif-com-gif-maker2.png");
        btnlogo.setIcon(logo);
        this.repaint();

        ImageIcon iconUser = new ImageIcon("src/images/icons8-user-32.png");
        txt_fotoUsuari.setIcon(iconUser);
        this.repaint();

        ImageIcon iconTasca = new ImageIcon("src/images/icons8-task-50.png");
        jButtonTascaNormal.setIcon(iconTasca);
        this.repaint();

        ImageIcon iconTasca2 = new ImageIcon("src/images/icons8-task-planning-50.png");
        jButtonTascaRepeticio.setIcon(iconTasca2);
        this.repaint();

        ImageIcon iconOrdinador = new ImageIcon("src/images/icons8-laptop-50.png");
        jButtonOrdinadors.setIcon(iconOrdinador);
        this.repaint();

        ImageIcon iconTelefons = new ImageIcon("src/images/icons8-mobile-phone-50.png");
        jButtonTelefons.setIcon(iconTelefons);
        this.repaint();

        ImageIcon iconImpresores = new ImageIcon("src/images/icons8-printer-50.png");
        jButtonImpresores.setIcon(iconImpresores);
        this.repaint();

        ImageIcon iconServidors = new ImageIcon("src/images/icons8-server-50.png");
        jButtonServidors.setIcon(iconServidors);
        this.repaint();

        ImageIcon iconDispositiusXarxa = new ImageIcon("src/images/icons8-wired-network-connection-50.png");
        jButtonDispositiusXarxa.setIcon(iconDispositiusXarxa);
        this.repaint();

        jTable_Tasques.getTableHeader().setOpaque(false);
        jTable_Tasques.getTableHeader().setBackground(new Color(255, 153, 51));
        jTable_Tasques.getTableHeader().setForeground(Color.BLACK);
        jTable_Tasques.setRowHeight(25);
        jTable_Tasques.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Ordinadors.getTableHeader().setOpaque(false);
        jTable_Ordinadors.getTableHeader().setBackground(new Color(255, 153, 51));
        jTable_Ordinadors.getTableHeader().setForeground(Color.BLACK);
        jTable_Ordinadors.setRowHeight(25);
        jTable_Ordinadors.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Telefons.getTableHeader().setOpaque(false);
        jTable_Telefons.getTableHeader().setBackground(new Color(255, 153, 51));
        jTable_Telefons.getTableHeader().setForeground(Color.BLACK);
        jTable_Telefons.setRowHeight(25);
        jTable_Telefons.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Usuaris.getTableHeader().setOpaque(false);
        jTable_Usuaris.getTableHeader().setBackground(new Color(255, 153, 51));
        jTable_Usuaris.getTableHeader().setForeground(Color.BLACK);
        jTable_Usuaris.setRowHeight(25);
        jTable_Usuaris.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Grups.getTableHeader().setOpaque(false);
        jTable_Grups.getTableHeader().setBackground(new Color(255, 153, 51));
        jTable_Grups.getTableHeader().setForeground(Color.BLACK);
        jTable_Grups.setRowHeight(25);

        jTable_Grups.getTableHeader().setPreferredSize(new Dimension(100, 32));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Header = new javax.swing.JPanel();
        IconMinMaxClose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        Logo = new javax.swing.JPanel();
        btnlogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        MenuIcon = new javax.swing.JPanel();
        LiniaHideMenu = new javax.swing.JPanel();
        HideMenu = new javax.swing.JPanel();
        MenuDes = new javax.swing.JLabel();
        LiniaConfiguracio = new javax.swing.JPanel();
        TancarSessio = new javax.swing.JPanel();
        btnTancarSessio = new javax.swing.JLabel();
        Configuracio = new javax.swing.JPanel();
        btnConfiguracio = new javax.swing.JLabel();
        Tasques = new javax.swing.JPanel();
        btnTasques = new javax.swing.JLabel();
        LiniaTasques = new javax.swing.JPanel();
        Elements = new javax.swing.JPanel();
        btnElements = new javax.swing.JLabel();
        LiniaElements = new javax.swing.JPanel();
        Usuaris = new javax.swing.JPanel();
        btnUsuaris = new javax.swing.JLabel();
        LiniaUsuaris = new javax.swing.JPanel();
        LiniaGrups = new javax.swing.JPanel();
        Grups = new javax.swing.JPanel();
        btnGrup = new javax.swing.JLabel();
        MenuHide = new javax.swing.JPanel();
        N_Tasques = new javax.swing.JPanel();
        btn_Tasques = new javax.swing.JLabel();
        N_Elements = new javax.swing.JPanel();
        btn_Elements = new javax.swing.JLabel();
        N_Usuaris = new javax.swing.JPanel();
        btn_Usuaris = new javax.swing.JLabel();
        N_TancarSessio = new javax.swing.JPanel();
        btn_TancarSessio = new javax.swing.JLabel();
        N_Configuracio = new javax.swing.JPanel();
        btn_Configuracio = new javax.swing.JLabel();
        N_Usuari = new javax.swing.JPanel();
        jButtonNomUsuari = new javax.swing.JLabel();
        N_Grups = new javax.swing.JPanel();
        btn_Grups = new javax.swing.JLabel();
        txt_fotoUsuari = new com.bolivia.label.CLabel();
        DashBoardView = new javax.swing.JPanel();
        DashChat = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        DashTriaElement = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jButtonTasca2 = new javax.swing.JPanel();
        jButtonOrdinadors = new javax.swing.JLabel();
        jButtonTascaNormal13 = new javax.swing.JLabel();
        jButtonTasca3 = new javax.swing.JPanel();
        jButtonTelefons = new javax.swing.JLabel();
        jButtonTascaNormal14 = new javax.swing.JLabel();
        jButtonTasca6 = new javax.swing.JPanel();
        jButtonTascaNormal17 = new javax.swing.JLabel();
        jButtonTascaNormal18 = new javax.swing.JLabel();
        jButtonDispositiusXarxa = new javax.swing.JLabel();
        jButtonTasca5 = new javax.swing.JPanel();
        jButtonServidors = new javax.swing.JLabel();
        jButtonTascaNormal16 = new javax.swing.JLabel();
        jButtonTasca4 = new javax.swing.JPanel();
        jButtonImpresores = new javax.swing.JLabel();
        jButtonTascaNormal15 = new javax.swing.JLabel();
        DashTriaTasca = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jButtonTasca = new javax.swing.JPanel();
        jButtonTascaNormal12 = new javax.swing.JLabel();
        jButtonTascaNormal = new javax.swing.JLabel();
        jButtonTasca1 = new javax.swing.JPanel();
        jButtonTascaRec = new javax.swing.JLabel();
        jButtonTascaRepeticio = new javax.swing.JLabel();
        DashNovaTasca = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        ComboUsuariAssignat = new javax.swing.JComboBox<>();
        txt_titolTasc = new javax.swing.JTextField();
        txt_descripcioTasc = new javax.swing.JTextField();
        dateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel63 = new javax.swing.JLabel();
        jCheckBoxNotificacio = new javax.swing.JCheckBox();
        ComboPrioritatTasc1 = new javax.swing.JComboBox<>();
        jButtonRegistarTasca = new javax.swing.JButton();
        ComboGrupAfectat = new javax.swing.JComboBox<>();
        jLabel84 = new javax.swing.JLabel();
        jButtonAfegirUsuari = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextUsuariAssignat = new javax.swing.JTextArea();
        DashInfoGrup = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel88 = new javax.swing.JLabel();
        jButtonRegistarGrup1 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        txt_nomGrup1 = new javax.swing.JTextField();
        txt_cerca2 = new javax.swing.JTextField();
        jScrollPaneElements1 = new javax.swing.JScrollPane();
        jTableCrearGrups = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextGrupUsuaris1 = new javax.swing.JTextArea();
        jButtonAfegir1 = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jButtonAfegirElement1 = new javax.swing.JButton();
        txt_cerca3 = new javax.swing.JTextField();
        DashNouGrup = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jButtonRegistarGrup = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        txt_nomGrup = new javax.swing.JTextField();
        txt_cerca = new javax.swing.JTextField();
        jScrollPaneElements = new javax.swing.JScrollPane();
        jTableCrearGrupsElements = new javax.swing.JTable();
        jScrollPaneUsuaris = new javax.swing.JScrollPane();
        jTableCrearGrupsUsuaris = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextGrupUsuaris = new javax.swing.JTextArea();
        jButtonAfegir = new javax.swing.JButton();
        jRadioButtonElements = new javax.swing.JRadioButton();
        jRadioButtonUsuaris = new javax.swing.JRadioButton();
        jLabel73 = new javax.swing.JLabel();
        jButtonAfegirElement = new javax.swing.JButton();
        txt_cerca1 = new javax.swing.JTextField();
        DashTasques = new javax.swing.JPanel();
        Contador4 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtBuscadorTasques = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jButtonNovaTasca = new javax.swing.JButton();
        jButtonEliminarTasca = new javax.swing.JButton();
        jComboBoxDashTasquesUsuari = new javax.swing.JComboBox<>();
        jLabel127 = new javax.swing.JLabel();
        jTextFieldTasquesTotals = new javax.swing.JTextField();
        jTextFieldTasquesAssignades = new javax.swing.JTextField();
        jTextFieldTasquesPendents = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane_Tasques = new javax.swing.JScrollPane();
        jTable_Tasques = new javax.swing.JTable();
        DashTelefons = new javax.swing.JPanel();
        Contador3 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        txt_buscadorTelefons = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jButtonNouTelefon = new javax.swing.JButton();
        jButtonEliminarTelefons = new javax.swing.JButton();
        jButtonEstadisitquesOrdiandor1 = new javax.swing.JButton();
        TasquesTotalsElements1 = new javax.swing.JTextField();
        TasquesAsignadesElements1 = new javax.swing.JTextField();
        TasquesGestionadesElements1 = new javax.swing.JTextField();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane_Telefons = new javax.swing.JScrollPane();
        jTable_Telefons = new javax.swing.JTable();
        DashUsuaris = new javax.swing.JPanel();
        Contador1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtBuscadorUsuaris = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButtonNouUsuari = new javax.swing.JButton();
        jButtonEliminarUsuari = new javax.swing.JButton();
        TasquesTotalsUsuaris = new javax.swing.JTextField();
        TasquesAsignadesUsuaris = new javax.swing.JTextField();
        TasquesGestionadesUsuaris = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane_Usuaris = new javax.swing.JScrollPane();
        jTable_Usuaris = new javax.swing.JTable();
        DashConfiguracio = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jButtonExportar = new javax.swing.JButton();
        jButtonImportar = new javax.swing.JButton();
        jCheckBoxSo = new javax.swing.JCheckBox();
        jCheckBoxEnviarCorreu = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        DashInfoUsuari = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txt_telefon = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_cognom = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_usuari = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ComboEstat = new javax.swing.JComboBox<>();
        ComboNivell = new javax.swing.JComboBox<>();
        jButtonEditarUsuari = new javax.swing.JButton();
        Enrera = new javax.swing.JLabel();
        DashNouUsuari = new javax.swing.JPanel();
        txt_usuari1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonRegistarUsuari = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ComboNivell1 = new javax.swing.JComboBox<>();
        ComboEstat1 = new javax.swing.JComboBox<>();
        txt_nom1 = new javax.swing.JTextField();
        txt_cognom1 = new javax.swing.JTextField();
        txt_telefon1 = new javax.swing.JTextField();
        txt_mail1 = new javax.swing.JTextField();
        DashNouOrdinador = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_model = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButtonRegistarOrdinador = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        ComboTipus = new javax.swing.JComboBox<>();
        ComboEstatElem = new javax.swing.JComboBox<>();
        txt_nomElem = new javax.swing.JTextField();
        txt_numserie = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        txt_observacions = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jRadioButtonRentingOrdinador = new javax.swing.JRadioButton();
        jRadioButtonCompraOrdinador = new javax.swing.JRadioButton();
        dataIngresOrdinador = new com.github.lgooddatepicker.components.DatePicker();
        jLabel97 = new javax.swing.JLabel();
        ComboUsuariAssignatOrdinador = new javax.swing.JComboBox<>();
        DashInfoOrdinador = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jButtonEditarOrdinador = new javax.swing.JButton();
        Enrera1 = new javax.swing.JLabel();
        txt_nomElem1 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_marca1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txt_model1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txt_numserie1 = new javax.swing.JTextField();
        ComboEstatElem1 = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        ComboTipus1 = new javax.swing.JComboBox<>();
        jLabel43 = new javax.swing.JLabel();
        ComboUsuariAssignatOrdinador1 = new javax.swing.JComboBox<>();
        jLabel100 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jRadioButtonRentingOrdinador1 = new javax.swing.JRadioButton();
        jRadioButtonCompraOrdinador1 = new javax.swing.JRadioButton();
        txt_observacions1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        dataIngresOrdinador1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel46 = new javax.swing.JLabel();
        DashInfoTasca = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txt_titolTasc2 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        ComboEstatTasc2 = new javax.swing.JComboBox<>();
        jButtonEditarTasca = new javax.swing.JButton();
        Enrera2 = new javax.swing.JLabel();
        txt_descripcioTasc2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        ComboPrioritatTasc2 = new javax.swing.JComboBox<>();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        ComboUsuariAssignat2 = new javax.swing.JComboBox<>();
        ComboGrupAfectat1 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfoTasca = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextUsuariAssignat1 = new javax.swing.JTextArea();
        jButtonAfegirUsuari1 = new javax.swing.JButton();
        jButtonChat = new javax.swing.JButton();
        DashGrups = new javax.swing.JPanel();
        Contador5 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtBuscadorTasques1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jButtonNouGrup = new javax.swing.JButton();
        jButtonEliminarGrup = new javax.swing.JButton();
        TasquesTotalsGrups = new javax.swing.JTextField();
        TasquesAsignadesGrups = new javax.swing.JTextField();
        TasquesGestionadesGrups = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane_Grups = new javax.swing.JScrollPane();
        jTable_Grups = new javax.swing.JTable();
        DashInfoTascaRepeticio = new javax.swing.JPanel();
        jLabelSetmanes2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBoxDissabte1 = new javax.swing.JCheckBox();
        jCheckBoxDimecres1 = new javax.swing.JCheckBox();
        jCheckBoxDimarts1 = new javax.swing.JCheckBox();
        jCheckBoxDiumenge1 = new javax.swing.JCheckBox();
        jCheckBoxDijous1 = new javax.swing.JCheckBox();
        jCheckBoxDilluns1 = new javax.swing.JCheckBox();
        jCheckBoxDivendres1 = new javax.swing.JCheckBox();
        jLabelRepetirCada1 = new javax.swing.JLabel();
        dateTimePickerRepeticioFinal1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel78 = new javax.swing.JLabel();
        jLabelDias1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonAcabar1 = new javax.swing.JRadioButton();
        jRadioButtonMensual1 = new javax.swing.JRadioButton();
        jRadioButtonSetmanal1 = new javax.swing.JRadioButton();
        jRadioButtonDiari1 = new javax.swing.JRadioButton();
        jButtonEditarTascaRecurrent = new javax.swing.JButton();
        jRadioButtonAnual1 = new javax.swing.JRadioButton();
        dateTimePickerRepeticio1 = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabelMesos1 = new javax.swing.JLabel();
        jLabelAnys1 = new javax.swing.JLabel();
        jRadioButtonDataFinal1 = new javax.swing.JRadioButton();
        jSpinnerAcabar1 = new javax.swing.JSpinner();
        jLabelSetmanes3 = new javax.swing.JLabel();
        txt_titolTasc3 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        ComboPrioritatTasc4 = new javax.swing.JComboBox<>();
        ComboEstatTasc3 = new javax.swing.JComboBox<>();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        ComboUsuariAssignat3 = new javax.swing.JComboBox<>();
        jCheckBoxNotificacio2 = new javax.swing.JCheckBox();
        txt_descripcioTasc3 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        ComboMesNumero1 = new javax.swing.JComboBox<>();
        jRadioButtonEl1 = new javax.swing.JRadioButton();
        ComboMesDia1 = new javax.swing.JComboBox<>();
        ComboMes1 = new javax.swing.JComboBox<>();
        ComboGrupAfectat3 = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInfoTasca1 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextUsuariAssignat3 = new javax.swing.JTextArea();
        jButtonAfegirUsuari3 = new javax.swing.JButton();
        DashPerfilUsuari = new javax.swing.JPanel();
        jButtonCanviarContrasenya = new javax.swing.JButton();
        jButtonGuardarFoto = new javax.swing.JButton();
        jButtonCanviarFoto = new javax.swing.JButton();
        txtNomImatge = new javax.swing.JTextField();
        cLabelFoto = new com.bolivia.label.CLabel();
        jLabel70 = new javax.swing.JLabel();
        DashNovaTascaRepeticio = new javax.swing.JPanel();
        jLabelSetmanes = new javax.swing.JLabel();
        jSpinner = new javax.swing.JSpinner();
        jCheckBoxDissabte = new javax.swing.JCheckBox();
        jCheckBoxDimecres = new javax.swing.JCheckBox();
        jCheckBoxDimarts = new javax.swing.JCheckBox();
        jCheckBoxDiumenge = new javax.swing.JCheckBox();
        jCheckBoxDijous = new javax.swing.JCheckBox();
        jCheckBoxDilluns = new javax.swing.JCheckBox();
        jCheckBoxDivendres = new javax.swing.JCheckBox();
        jLabelRepetirCada = new javax.swing.JLabel();
        dateTimePickerRepeticioFinal = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel4 = new javax.swing.JLabel();
        jLabelDias = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonAcabar = new javax.swing.JRadioButton();
        jRadioButtonMensual = new javax.swing.JRadioButton();
        jRadioButtonSetmanal = new javax.swing.JRadioButton();
        jRadioButtonDiari = new javax.swing.JRadioButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAceptar = new javax.swing.JButton();
        jRadioButtonAnual = new javax.swing.JRadioButton();
        dateTimePickerRepeticio = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabelMesos = new javax.swing.JLabel();
        jLabelAnys = new javax.swing.JLabel();
        jRadioButtonDataFinal = new javax.swing.JRadioButton();
        jSpinnerAcabar = new javax.swing.JSpinner();
        jLabelSetmanes1 = new javax.swing.JLabel();
        txt_titolTasc1 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        ComboPrioritatTasc3 = new javax.swing.JComboBox<>();
        ComboEstatTasc1 = new javax.swing.JComboBox<>();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        ComboUsuariAssignat1 = new javax.swing.JComboBox<>();
        jCheckBoxNotificacio1 = new javax.swing.JCheckBox();
        txt_descripcioTasc1 = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        ComboMesNumero = new javax.swing.JComboBox<>();
        ComboMesDia = new javax.swing.JComboBox<>();
        jRadioButtonEl = new javax.swing.JRadioButton();
        ComboMes = new javax.swing.JComboBox<>();
        ComboGrupAfectat2 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextUsuariAssignat2 = new javax.swing.JTextArea();
        jButtonAfegirUsuari2 = new javax.swing.JButton();
        DashOrdinadors = new javax.swing.JPanel();
        jScrollPane_Ordiandors = new javax.swing.JScrollPane();
        jTable_Ordinadors = new javax.swing.JTable();
        Contador6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        txtBuscadorOrdinadors = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jButtonNouOrdinador = new javax.swing.JButton();
        jButtonEliminarOrdinadors = new javax.swing.JButton();
        TasquesTotalsElements = new javax.swing.JTextField();
        TasquesAsignadesElements = new javax.swing.JTextField();
        TasquesGestionadesElements = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        DashNouTelefon = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        txt_modelTel = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jButtonRegistarTelefon = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        ComboTipusTel = new javax.swing.JComboBox<>();
        ComboEstatTel = new javax.swing.JComboBox<>();
        txt_nomTel = new javax.swing.JTextField();
        txt_imeiTel = new javax.swing.JTextField();
        txt_marcaTel = new javax.swing.JTextField();
        txt_observacionsTel = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jRadioButtonRentingTel = new javax.swing.JRadioButton();
        jRadioButtonCompraTel = new javax.swing.JRadioButton();
        dataIngresTel = new com.github.lgooddatepicker.components.DatePicker();
        jLabel112 = new javax.swing.JLabel();
        ComboUsuariAssignatTel = new javax.swing.JComboBox<>();
        jLabel125 = new javax.swing.JLabel();
        txt_numeroTel = new javax.swing.JTextField();
        DashInfoTelefon = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        txt_modelTel1 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jButtonEditarTelefon = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        ComboTipusTel1 = new javax.swing.JComboBox<>();
        ComboEstatTel1 = new javax.swing.JComboBox<>();
        txt_nomTel1 = new javax.swing.JTextField();
        txt_imeiTel1 = new javax.swing.JTextField();
        txt_marcaTel1 = new javax.swing.JTextField();
        txt_observacionsTel1 = new javax.swing.JTextField();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jRadioButtonRentingTel1 = new javax.swing.JRadioButton();
        jRadioButtonCompraTel1 = new javax.swing.JRadioButton();
        dataIngresTel1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel123 = new javax.swing.JLabel();
        ComboUsuariAssignatTel1 = new javax.swing.JComboBox<>();
        txt_numeroTel1 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Header.setBackground(new java.awt.Color(255, 153, 51));
        Header.setPreferredSize(new java.awt.Dimension(800, 50));
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
        IconMinMaxClose.setPreferredSize(new java.awt.Dimension(150, 50));
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

        Logo.setBackground(new java.awt.Color(255, 153, 51));
        Logo.setPreferredSize(new java.awt.Dimension(50, 50));

        btnlogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogo.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        Logo.setLayout(LogoLayout);
        LogoLayout.setHorizontalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoLayout.createSequentialGroup()
                .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
            LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoLayout.createSequentialGroup()
                .addComponent(btnlogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Header.add(Logo, java.awt.BorderLayout.LINE_START);

        jLabel1.setText("Control Tasques");
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        Header.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        Menu.setPreferredSize(new java.awt.Dimension(270, 450));
        Menu.setLayout(new java.awt.BorderLayout());

        MenuIcon.setBackground(new java.awt.Color(255, 153, 0));
        MenuIcon.setPreferredSize(new java.awt.Dimension(50, 450));
        MenuIcon.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LiniaHideMenu.setBackground(new java.awt.Color(255, 153, 0));
        LiniaHideMenu.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaHideMenuLayout = new javax.swing.GroupLayout(LiniaHideMenu);
        LiniaHideMenu.setLayout(LiniaHideMenuLayout);
        LiniaHideMenuLayout.setHorizontalGroup(
            LiniaHideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaHideMenuLayout.setVerticalGroup(
            LiniaHideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaHideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 5));

        HideMenu.setBackground(new java.awt.Color(255, 153, 0));
        HideMenu.setLayout(new java.awt.BorderLayout());

        MenuDes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuDes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuDesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuDesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuDesMouseExited(evt);
            }
        });
        HideMenu.add(MenuDes, java.awt.BorderLayout.CENTER);

        MenuIcon.add(HideMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 50, 50));

        LiniaConfiguracio.setBackground(new java.awt.Color(255, 153, 0));
        LiniaConfiguracio.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaConfiguracioLayout = new javax.swing.GroupLayout(LiniaConfiguracio);
        LiniaConfiguracio.setLayout(LiniaConfiguracioLayout);
        LiniaConfiguracioLayout.setHorizontalGroup(
            LiniaConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaConfiguracioLayout.setVerticalGroup(
            LiniaConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaConfiguracio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 50, 5));

        TancarSessio.setBackground(new java.awt.Color(255, 153, 0));
        TancarSessio.setLayout(new java.awt.BorderLayout());

        btnTancarSessio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTancarSessio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTancarSessioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTancarSessioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTancarSessioMouseExited(evt);
            }
        });
        TancarSessio.add(btnTancarSessio, java.awt.BorderLayout.CENTER);

        MenuIcon.add(TancarSessio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 50, 50));

        Configuracio.setBackground(new java.awt.Color(255, 153, 0));
        Configuracio.setLayout(new java.awt.BorderLayout());

        btnConfiguracio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnConfiguracio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfiguracioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnConfiguracioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnConfiguracioMouseExited(evt);
            }
        });
        Configuracio.add(btnConfiguracio, java.awt.BorderLayout.CENTER);

        MenuIcon.add(Configuracio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 50, 50));

        Tasques.setBackground(new java.awt.Color(255, 153, 0));
        Tasques.setLayout(new java.awt.BorderLayout());

        btnTasques.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTasques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTasquesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTasquesMouseExited(evt);
            }
        });
        Tasques.add(btnTasques, java.awt.BorderLayout.CENTER);

        MenuIcon.add(Tasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 50, 50));

        LiniaTasques.setBackground(new java.awt.Color(255, 153, 0));
        LiniaTasques.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaTasquesLayout = new javax.swing.GroupLayout(LiniaTasques);
        LiniaTasques.setLayout(LiniaTasquesLayout);
        LiniaTasquesLayout.setHorizontalGroup(
            LiniaTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaTasquesLayout.setVerticalGroup(
            LiniaTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaTasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 50, 10));

        Elements.setBackground(new java.awt.Color(255, 153, 0));
        Elements.setLayout(new java.awt.BorderLayout());

        btnElements.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnElements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnElementsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnElementsMouseExited(evt);
            }
        });
        Elements.add(btnElements, java.awt.BorderLayout.CENTER);

        MenuIcon.add(Elements, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 50, 50));

        LiniaElements.setBackground(new java.awt.Color(255, 153, 0));
        LiniaElements.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaElementsLayout = new javax.swing.GroupLayout(LiniaElements);
        LiniaElements.setLayout(LiniaElementsLayout);
        LiniaElementsLayout.setHorizontalGroup(
            LiniaElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaElementsLayout.setVerticalGroup(
            LiniaElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 50, 5));

        Usuaris.setBackground(new java.awt.Color(255, 153, 0));
        Usuaris.setLayout(new java.awt.BorderLayout());

        btnUsuaris.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuaris.setPreferredSize(new java.awt.Dimension(50, 50));
        btnUsuaris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUsuarisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUsuarisMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUsuarisMouseReleased(evt);
            }
        });
        Usuaris.add(btnUsuaris, java.awt.BorderLayout.LINE_END);

        MenuIcon.add(Usuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 50, 50));

        LiniaUsuaris.setBackground(new java.awt.Color(255, 153, 0));
        LiniaUsuaris.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaUsuarisLayout = new javax.swing.GroupLayout(LiniaUsuaris);
        LiniaUsuaris.setLayout(LiniaUsuarisLayout);
        LiniaUsuarisLayout.setHorizontalGroup(
            LiniaUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaUsuarisLayout.setVerticalGroup(
            LiniaUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 50, 5));

        LiniaGrups.setBackground(new java.awt.Color(255, 153, 0));
        LiniaGrups.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout LiniaGrupsLayout = new javax.swing.GroupLayout(LiniaGrups);
        LiniaGrups.setLayout(LiniaGrupsLayout);
        LiniaGrupsLayout.setHorizontalGroup(
            LiniaGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        LiniaGrupsLayout.setVerticalGroup(
            LiniaGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaGrups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 50, -1));

        Grups.setBackground(new java.awt.Color(255, 153, 0));
        Grups.setLayout(new java.awt.BorderLayout());

        btnGrup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGrup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGrupMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGrupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGrupMouseExited(evt);
            }
        });
        Grups.add(btnGrup, java.awt.BorderLayout.CENTER);

        MenuIcon.add(Grups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 50, 50));

        Menu.add(MenuIcon, java.awt.BorderLayout.LINE_START);

        MenuHide.setBackground(new java.awt.Color(255, 153, 51));
        MenuHide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        N_Tasques.setBackground(new java.awt.Color(255, 153, 51));
        N_Tasques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                N_TasquesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                N_TasquesMouseExited(evt);
            }
        });
        N_Tasques.setLayout(new java.awt.BorderLayout());

        btn_Tasques.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Tasques.setText("  Tasques");
        btn_Tasques.setBackground(new java.awt.Color(255, 255, 255));
        btn_Tasques.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Tasques.setForeground(new java.awt.Color(255, 255, 255));
        btn_Tasques.setMaximumSize(new java.awt.Dimension(111, 32));
        btn_Tasques.setMinimumSize(new java.awt.Dimension(111, 32));
        btn_Tasques.setPreferredSize(new java.awt.Dimension(111, 32));
        btn_Tasques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TasquesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TasquesMouseExited(evt);
            }
        });
        N_Tasques.add(btn_Tasques, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Tasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 220, 50));

        N_Elements.setBackground(new java.awt.Color(255, 153, 51));
        N_Elements.setLayout(new java.awt.BorderLayout());

        btn_Elements.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Elements.setText("  Elements");
        btn_Elements.setBackground(new java.awt.Color(255, 255, 255));
        btn_Elements.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Elements.setForeground(new java.awt.Color(255, 255, 255));
        btn_Elements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ElementsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ElementsMouseExited(evt);
            }
        });
        N_Elements.add(btn_Elements, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Elements, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 220, 50));

        N_Usuaris.setBackground(new java.awt.Color(255, 153, 51));
        N_Usuaris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                N_UsuarisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                N_UsuarisMouseExited(evt);
            }
        });
        N_Usuaris.setLayout(new java.awt.BorderLayout());

        btn_Usuaris.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Usuaris.setText("  Usuaris");
        btn_Usuaris.setBackground(new java.awt.Color(255, 153, 51));
        btn_Usuaris.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Usuaris.setForeground(new java.awt.Color(255, 255, 255));
        btn_Usuaris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_UsuarisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_UsuarisMouseExited(evt);
            }
        });
        N_Usuaris.add(btn_Usuaris, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Usuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 220, 50));

        N_TancarSessio.setBackground(new java.awt.Color(255, 153, 51));
        N_TancarSessio.setLayout(new java.awt.BorderLayout());

        btn_TancarSessio.setBackground(new java.awt.Color(255, 255, 255));
        btn_TancarSessio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_TancarSessio.setForeground(new java.awt.Color(255, 255, 255));
        btn_TancarSessio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_TancarSessio.setText("  Tancar Sessió");
        btn_TancarSessio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TancarSessioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TancarSessioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TancarSessioMouseExited(evt);
            }
        });
        N_TancarSessio.add(btn_TancarSessio, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_TancarSessio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 220, 50));

        N_Configuracio.setBackground(new java.awt.Color(255, 153, 51));
        N_Configuracio.setLayout(new java.awt.BorderLayout());

        btn_Configuracio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Configuracio.setText("  Configuració");
        btn_Configuracio.setBackground(new java.awt.Color(255, 255, 255));
        btn_Configuracio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Configuracio.setForeground(new java.awt.Color(255, 255, 255));
        btn_Configuracio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ConfiguracioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ConfiguracioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ConfiguracioMouseExited(evt);
            }
        });
        N_Configuracio.add(btn_Configuracio, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Configuracio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 220, 50));

        N_Usuari.setBackground(new java.awt.Color(255, 153, 51));
        N_Usuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                N_UsuariMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                N_UsuariMouseExited(evt);
            }
        });
        N_Usuari.setLayout(new java.awt.BorderLayout());

        jButtonNomUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonNomUsuari.setText("Usuari");
        jButtonNomUsuari.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonNomUsuari.setForeground(new java.awt.Color(255, 255, 255));
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
        N_Usuari.add(jButtonNomUsuari, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Usuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));

        N_Grups.setBackground(new java.awt.Color(255, 153, 51));
        N_Grups.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                N_GrupsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                N_GrupsMouseExited(evt);
            }
        });
        N_Grups.setLayout(new java.awt.BorderLayout());

        btn_Grups.setBackground(new java.awt.Color(255, 153, 51));
        btn_Grups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Grups.setForeground(new java.awt.Color(255, 255, 255));
        btn_Grups.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Grups.setText("  Grups");
        btn_Grups.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GrupsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_GrupsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GrupsMouseExited(evt);
            }
        });
        N_Grups.add(btn_Grups, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Grups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 220, 50));

        txt_fotoUsuari.setText("");
        txt_fotoUsuari.setBackground(new java.awt.Color(255, 153, 0));
        txt_fotoUsuari.setForeground(new java.awt.Color(60, 63, 65));
        txt_fotoUsuari.setLineColor(new java.awt.Color(255, 255, 255));
        MenuHide.add(txt_fotoUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 70, 70));

        Menu.add(MenuHide, java.awt.BorderLayout.CENTER);

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        DashBoardView.setBackground(new java.awt.Color(255, 255, 255));

        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane9.setViewportView(jList1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Seguiment Tasca");

        javax.swing.GroupLayout DashChatLayout = new javax.swing.GroupLayout(DashChat);
        DashChat.setLayout(DashChatLayout);
        DashChatLayout.setHorizontalGroup(
            DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
            .addGroup(DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashChatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(DashChatLayout.createSequentialGroup()
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        DashChatLayout.setVerticalGroup(
            DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashChatLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(7, 7, 7)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(DashChatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );

        DashTriaElement.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setBackground(new java.awt.Color(0, 0, 0));
        jLabel128.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 0));
        jLabel128.setText("Tria el tipus d'element");
        jPanel11.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, -1, -1));

        jButtonTasca2.setBackground(new java.awt.Color(255, 153, 51));

        jButtonOrdinadors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonOrdinadors.setBackground(new java.awt.Color(255, 255, 255));
        jButtonOrdinadors.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonOrdinadors.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal13.setText("Ordinadors");
        jButtonTascaNormal13.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal13.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca2Layout = new javax.swing.GroupLayout(jButtonTasca2);
        jButtonTasca2.setLayout(jButtonTasca2Layout);
        jButtonTasca2Layout.setHorizontalGroup(
            jButtonTasca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonTascaNormal13, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonOrdinadors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jButtonTasca2Layout.setVerticalGroup(
            jButtonTasca2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca2Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jButtonTascaNormal13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel11.add(jButtonTasca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 140, 160));

        jButtonTasca3.setBackground(new java.awt.Color(255, 153, 51));

        jButtonTelefons.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTelefons.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTelefons.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTelefons.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal14.setText("Telèfons");
        jButtonTascaNormal14.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal14.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca3Layout = new javax.swing.GroupLayout(jButtonTasca3);
        jButtonTasca3.setLayout(jButtonTasca3Layout);
        jButtonTasca3Layout.setHorizontalGroup(
            jButtonTasca3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTasca3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jButtonTasca3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTelefons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTascaNormal14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addContainerGap())
        );
        jButtonTasca3Layout.setVerticalGroup(
            jButtonTasca3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jButtonTascaNormal14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel11.add(jButtonTasca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 140, 160));

        jButtonTasca6.setBackground(new java.awt.Color(255, 153, 51));

        jButtonTascaNormal17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal17.setText("Dispositius");
        jButtonTascaNormal17.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonTascaNormal17.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal17.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal17.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal18.setText("de Xarxa");
        jButtonTascaNormal18.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonTascaNormal18.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal18.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal18.setForeground(new java.awt.Color(255, 255, 255));

        jButtonDispositiusXarxa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonDispositiusXarxa.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDispositiusXarxa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonDispositiusXarxa.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca6Layout = new javax.swing.GroupLayout(jButtonTasca6);
        jButtonTasca6.setLayout(jButtonTasca6Layout);
        jButtonTasca6Layout.setHorizontalGroup(
            jButtonTasca6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonTascaNormal18, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
            .addGroup(jButtonTasca6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonDispositiusXarxa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jButtonTasca6Layout.createSequentialGroup()
                .addComponent(jButtonTascaNormal17, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jButtonTasca6Layout.setVerticalGroup(
            jButtonTasca6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca6Layout.createSequentialGroup()
                .addComponent(jButtonTascaNormal17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTascaNormal18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDispositiusXarxa, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel11.add(jButtonTasca6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 150, 160));

        jButtonTasca5.setBackground(new java.awt.Color(255, 153, 51));

        jButtonServidors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonServidors.setBackground(new java.awt.Color(255, 255, 255));
        jButtonServidors.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonServidors.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal16.setText("Servidors");
        jButtonTascaNormal16.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal16.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca5Layout = new javax.swing.GroupLayout(jButtonTasca5);
        jButtonTasca5.setLayout(jButtonTasca5Layout);
        jButtonTasca5Layout.setHorizontalGroup(
            jButtonTasca5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTasca5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jButtonTasca5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonServidors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonTascaNormal16, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                .addContainerGap())
        );
        jButtonTasca5Layout.setVerticalGroup(
            jButtonTasca5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jButtonTascaNormal16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonServidors, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.add(jButtonTasca5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 150, 160));

        jButtonTasca4.setBackground(new java.awt.Color(255, 153, 51));

        jButtonImpresores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonImpresores.setBackground(new java.awt.Color(255, 255, 255));
        jButtonImpresores.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonImpresores.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal15.setText("Impresores");
        jButtonTascaNormal15.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal15.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca4Layout = new javax.swing.GroupLayout(jButtonTasca4);
        jButtonTasca4.setLayout(jButtonTasca4Layout);
        jButtonTasca4Layout.setHorizontalGroup(
            jButtonTasca4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTasca4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jButtonTasca4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTascaNormal15, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jButtonImpresores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jButtonTasca4Layout.setVerticalGroup(
            jButtonTasca4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jButtonTasca4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonTascaNormal15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImpresores, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel11.add(jButtonTasca4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 140, 160));

        javax.swing.GroupLayout DashTriaElementLayout = new javax.swing.GroupLayout(DashTriaElement);
        DashTriaElement.setLayout(DashTriaElementLayout);
        DashTriaElementLayout.setHorizontalGroup(
            DashTriaElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTriaElementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashTriaElementLayout.setVerticalGroup(
            DashTriaElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTriaElementLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        DashTriaTasca.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setBackground(new java.awt.Color(0, 0, 0));
        jLabel126.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setText("Tria el tipus de tasca");
        jPanel9.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jButtonTasca.setBackground(new java.awt.Color(255, 153, 51));

        jButtonTascaNormal12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal12.setText("Normal ");
        jButtonTascaNormal12.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal12.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaNormal.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTascaLayout = new javax.swing.GroupLayout(jButtonTasca);
        jButtonTasca.setLayout(jButtonTascaLayout);
        jButtonTascaLayout.setHorizontalGroup(
            jButtonTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTascaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jButtonTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTascaNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTascaNormal12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jButtonTascaLayout.setVerticalGroup(
            jButtonTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTascaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButtonTascaNormal12, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTascaNormal, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel9.add(jButtonTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, 170));

        jButtonTasca1.setBackground(new java.awt.Color(255, 153, 51));

        jButtonTascaRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaRec.setText("Recurrent");
        jButtonTascaRec.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaRec.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaRec.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaRepeticio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaRepeticio.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaRepeticio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonTascaRepeticio.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jButtonTasca1Layout = new javax.swing.GroupLayout(jButtonTasca1);
        jButtonTasca1.setLayout(jButtonTasca1Layout);
        jButtonTasca1Layout.setHorizontalGroup(
            jButtonTasca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTasca1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jButtonTasca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonTascaRec, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jButtonTasca1Layout.setVerticalGroup(
            jButtonTasca1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jButtonTasca1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButtonTascaRec)
                .addGap(18, 18, 18)
                .addComponent(jButtonTascaRepeticio, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jPanel9.add(jButtonTasca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, 170));

        javax.swing.GroupLayout DashTriaTascaLayout = new javax.swing.GroupLayout(DashTriaTasca);
        DashTriaTasca.setLayout(DashTriaTascaLayout);
        DashTriaTascaLayout.setHorizontalGroup(
            DashTriaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTriaTascaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashTriaTascaLayout.setVerticalGroup(
            DashTriaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTriaTascaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DashNovaTasca.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("Nova Tasca Simple");
        jLabel47.setBackground(new java.awt.Color(0, 0, 0));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, 60));

        jLabel48.setText("Data Venciment");
        jLabel48.setBackground(new java.awt.Color(255, 153, 51));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, 25));

        jLabel49.setText("Prioritat");
        jLabel49.setBackground(new java.awt.Color(255, 153, 51));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel55.setText("Titol");
        jLabel55.setBackground(new java.awt.Color(0, 0, 0));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 25));

        jLabel58.setText("Descripció");
        jLabel58.setBackground(new java.awt.Color(255, 153, 51));
        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 30));

        ComboUsuariAssignat.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(ComboUsuariAssignat, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 150, 30));

        txt_titolTasc.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_titolTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 190, 30));

        txt_descripcioTasc.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_descripcioTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 620, 80));

        dateTimePicker.setBackground(new java.awt.Color(255, 153, 51));
        dateTimePicker.setForeground(new java.awt.Color(255, 153, 51));
        jPanel5.add(dateTimePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 260, 30));

        jLabel63.setText("Grup Afectat");
        jLabel63.setBackground(new java.awt.Color(255, 153, 51));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 25));

        jCheckBoxNotificacio.setText("Mostrar notificació");
        jCheckBoxNotificacio.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxNotificacio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxNotificacio.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxNotificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacioActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBoxNotificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 30));

        ComboPrioritatTasc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc1.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(ComboPrioritatTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 150, 30));

        jButtonRegistarTasca.setText("Guardar");
        jButtonRegistarTasca.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarTasca.setBorder(null);
        jButtonRegistarTasca.setBorderPainted(false);
        jButtonRegistarTasca.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarTasca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jButtonRegistarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 150, 30));

        ComboGrupAfectat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat.setBackground(new java.awt.Color(255, 153, 51));
        ComboGrupAfectat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(ComboGrupAfectat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 150, 26));

        jLabel84.setText("Usuari Assignat");
        jLabel84.setBackground(new java.awt.Color(255, 153, 51));
        jLabel84.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, 25));

        jButtonAfegirUsuari.setText("+");
        jButtonAfegirUsuari.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirUsuari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAfegirUsuari.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(jButtonAfegirUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 30, 30));

        jTextUsuariAssignat.setColumns(20);
        jTextUsuariAssignat.setRows(5);
        jScrollPane5.setViewportView(jTextUsuariAssignat);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 150, 150));

        javax.swing.GroupLayout DashNovaTascaLayout = new javax.swing.GroupLayout(DashNovaTasca);
        DashNovaTasca.setLayout(DashNovaTascaLayout);
        DashNovaTascaLayout.setHorizontalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DashNovaTascaLayout.setVerticalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        DashInfoGrup.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel88.setText("Nou Grup");
        jLabel88.setBackground(new java.awt.Color(255, 153, 51));
        jLabel88.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 153, 51));
        jPanel10.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 60));

        jButtonRegistarGrup1.setText("Actualitzar");
        jButtonRegistarGrup1.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarGrup1.setBorder(null);
        jButtonRegistarGrup1.setBorderPainted(false);
        jButtonRegistarGrup1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarGrup1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonRegistarGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 150, 30));

        jLabel89.setBackground(new java.awt.Color(0, 0, 0));
        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setText("Cerca:");
        jPanel10.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 25));

        txt_nomGrup1.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomGrup1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(txt_nomGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 31));

        txt_cerca2.setBackground(new java.awt.Color(255, 153, 51));
        txt_cerca2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(txt_cerca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 31));

        jTableCrearGrups.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneElements1.setViewportView(jTableCrearGrups);

        jPanel10.add(jScrollPaneElements1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 450, 230));

        jTextGrupUsuaris1.setColumns(20);
        jTextGrupUsuaris1.setRows(5);
        jScrollPane4.setViewportView(jTextGrupUsuaris1);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 110, 350));

        jButtonAfegir1.setText("Afegir Usuari");
        jButtonAfegir1.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegir1.setBorder(null);
        jButtonAfegir1.setBorderPainted(false);
        jButtonAfegir1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAfegir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonAfegir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 90, 30));

        jLabel90.setBackground(new java.awt.Color(0, 0, 0));
        jLabel90.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setText("Nom Grup:");
        jPanel10.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 25));

        jButtonAfegirElement1.setText("Afegir Element");
        jButtonAfegirElement1.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirElement1.setBorder(null);
        jButtonAfegirElement1.setBorderPainted(false);
        jButtonAfegirElement1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAfegirElement1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonAfegirElement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 90, 30));

        txt_cerca3.setBackground(new java.awt.Color(255, 153, 51));
        txt_cerca3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(txt_cerca3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 31));

        javax.swing.GroupLayout DashInfoGrupLayout = new javax.swing.GroupLayout(DashInfoGrup);
        DashInfoGrup.setLayout(DashInfoGrupLayout);
        DashInfoGrupLayout.setHorizontalGroup(
            DashInfoGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DashInfoGrupLayout.setVerticalGroup(
            DashInfoGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        DashNouGrup.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(255, 153, 51));
        jLabel50.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 153, 51));
        jLabel50.setText("Nou Grup");
        jPanel8.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 60));

        jButtonRegistarGrup.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarGrup.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarGrup.setText("Guardar");
        jButtonRegistarGrup.setBorder(null);
        jButtonRegistarGrup.setBorderPainted(false);
        jButtonRegistarGrup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jButtonRegistarGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, 150, 30));

        jLabel72.setBackground(new java.awt.Color(0, 0, 0));
        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("Cerca:");
        jPanel8.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, -1, 25));

        txt_nomGrup.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomGrup.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_nomGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 31));

        txt_cerca.setBackground(new java.awt.Color(255, 153, 51));
        txt_cerca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_cerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 31));

        jTableCrearGrupsElements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneElements.setViewportView(jTableCrearGrupsElements);

        jPanel8.add(jScrollPaneElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 450, 300));

        jTableCrearGrupsUsuaris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneUsuaris.setViewportView(jTableCrearGrupsUsuaris);

        jPanel8.add(jScrollPaneUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 450, 300));

        jTextGrupUsuaris.setColumns(20);
        jTextGrupUsuaris.setRows(5);
        jScrollPane2.setViewportView(jTextGrupUsuaris);

        jPanel8.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, 110, 350));

        jButtonAfegir.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAfegir.setText("Afegir Usuari");
        jButtonAfegir.setBorder(null);
        jButtonAfegir.setBorderPainted(false);
        jButtonAfegir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jButtonAfegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 90, 30));

        jRadioButtonElements.setText("Elements");
        jRadioButtonElements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonElementsActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButtonElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jRadioButtonUsuaris.setText("Usuaris");
        jRadioButtonUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUsuarisActionPerformed(evt);
            }
        });
        jPanel8.add(jRadioButtonUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, -1, -1));

        jLabel73.setBackground(new java.awt.Color(0, 0, 0));
        jLabel73.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Nom Grup:");
        jPanel8.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 25));

        jButtonAfegirElement.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirElement.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAfegirElement.setText("Afegir Element");
        jButtonAfegirElement.setBorder(null);
        jButtonAfegirElement.setBorderPainted(false);
        jButtonAfegirElement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel8.add(jButtonAfegirElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 290, 90, 30));

        txt_cerca1.setBackground(new java.awt.Color(255, 153, 51));
        txt_cerca1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(txt_cerca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 100, 31));

        javax.swing.GroupLayout DashNouGrupLayout = new javax.swing.GroupLayout(DashNouGrup);
        DashNouGrup.setLayout(DashNouGrupLayout);
        DashNouGrupLayout.setHorizontalGroup(
            DashNouGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
        );
        DashNouGrupLayout.setVerticalGroup(
            DashNouGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        DashTasques.setBackground(new java.awt.Color(255, 255, 255));
        DashTasques.setForeground(new java.awt.Color(51, 51, 255));
        DashTasques.setPreferredSize(new java.awt.Dimension(779, 400));

        Contador4.setBackground(new java.awt.Color(255, 153, 51));
        Contador4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Tasques Totals");
        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));

        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Tasques Pendents");
        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel6.add(txtBuscadorTasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 9, 150, 20));

        jLabel53.setText("Buscar :");
        jLabel53.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 57, 40));

        jButtonNovaTasca.setText("Nova Tasca");
        jPanel6.add(jButtonNovaTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

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
        jPanel6.add(jButtonEliminarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jPanel6.add(jComboBoxDashTasquesUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 120, -1));

        jLabel127.setText("Usuari:");
        jLabel127.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jPanel6.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 50, -1));

        jTextFieldTasquesTotals.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldTasquesTotals.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTasquesTotals.setBackground(new java.awt.Color(0, 153, 255));
        jTextFieldTasquesTotals.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldTasquesTotals.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldTasquesAssignades.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldTasquesAssignades.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTasquesAssignades.setBackground(new java.awt.Color(255, 255, 51));
        jTextFieldTasquesAssignades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextFieldTasquesPendents.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextFieldTasquesPendents.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTasquesPendents.setBackground(new java.awt.Color(102, 255, 102));
        jTextFieldTasquesPendents.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextFieldTasquesPendents.setForeground(new java.awt.Color(0, 0, 0));

        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Tasques Asignades");
        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Contador4Layout = new javax.swing.GroupLayout(Contador4);
        Contador4.setLayout(Contador4Layout);
        Contador4Layout.setHorizontalGroup(
            Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador4Layout.createSequentialGroup()
                .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador4Layout.createSequentialGroup()
                        .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador4Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jTextFieldTasquesTotals, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel54)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel52)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(Contador4Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextFieldTasquesAssignades, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldTasquesPendents, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97))))
                    .addGroup(Contador4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador4Layout.setVerticalGroup(
            Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTasquesTotals, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldTasquesAssignades, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldTasquesPendents, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane_Tasques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        jScrollPane_Tasques.setFocusable(false);
        jScrollPane_Tasques.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane_Tasques.setOpaque(false);

        jTable_Tasques.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable_Tasques.setFocusable(false);
        jTable_Tasques.setOpaque(false);
        jTable_Tasques.setRowHeight(25);
        jTable_Tasques.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable_Tasques.setShowHorizontalLines(true);
        jScrollPane_Tasques.setViewportView(jTable_Tasques);

        javax.swing.GroupLayout DashTasquesLayout = new javax.swing.GroupLayout(DashTasques);
        DashTasques.setLayout(DashTasquesLayout);
        DashTasquesLayout.setHorizontalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        DashTasquesLayout.setVerticalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createSequentialGroup()
                .addComponent(Contador4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );

        DashTelefons.setBackground(new java.awt.Color(255, 255, 255));
        DashTelefons.setForeground(new java.awt.Color(51, 51, 255));

        Contador3.setBackground(new java.awt.Color(255, 153, 51));
        Contador3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Tasques Totals");
        jLabel92.setBackground(new java.awt.Color(255, 255, 255));
        jLabel92.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Tasques Gestionades");
        jLabel93.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.setForeground(new java.awt.Color(255, 255, 255));

        jLabel94.setText("Buscar :");
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));

        jButtonNouTelefon.setText("Nou");

        jButtonEliminarTelefons.setText("Eliminar");
        jButtonEliminarTelefons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarTelefonsMouseClicked(evt);
            }
        });
        jButtonEliminarTelefons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTelefonsActionPerformed(evt);
            }
        });

        jButtonEstadisitquesOrdiandor1.setText("Estadístiques");
        jButtonEstadisitquesOrdiandor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEstadisitquesOrdiandor1MouseClicked(evt);
            }
        });
        jButtonEstadisitquesOrdiandor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEstadisitquesOrdiandor1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonNouTelefon)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarTelefons)
                .addGap(18, 18, 18)
                .addComponent(jButtonEstadisitquesOrdiandor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscadorTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscadorTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94)
                    .addComponent(jButtonEliminarTelefons)
                    .addComponent(jButtonNouTelefon)
                    .addComponent(jButtonEstadisitquesOrdiandor1))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        TasquesTotalsElements1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesTotalsElements1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesTotalsElements1.setBackground(new java.awt.Color(0, 153, 255));
        TasquesTotalsElements1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TasquesAsignadesElements1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesAsignadesElements1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesAsignadesElements1.setBackground(new java.awt.Color(255, 255, 51));
        TasquesAsignadesElements1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesAsignadesElements1.setForeground(new java.awt.Color(0, 0, 0));
        TasquesAsignadesElements1.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        TasquesGestionadesElements1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesGestionadesElements1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesGestionadesElements1.setBackground(new java.awt.Color(102, 255, 102));
        TasquesGestionadesElements1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesGestionadesElements1.setForeground(new java.awt.Color(0, 0, 0));
        TasquesGestionadesElements1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TasquesGestionadesElements1ActionPerformed(evt);
            }
        });

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setText("Tasques Asignades");
        jLabel95.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Contador3Layout = new javax.swing.GroupLayout(Contador3);
        Contador3.setLayout(Contador3Layout);
        Contador3Layout.setHorizontalGroup(
            Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador3Layout.createSequentialGroup()
                .addGroup(Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador3Layout.createSequentialGroup()
                        .addGroup(Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador3Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(TasquesTotalsElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador3Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(TasquesAsignadesElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(TasquesGestionadesElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador3Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel95)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel93)))
                        .addGap(0, 65, Short.MAX_VALUE))
                    .addGroup(Contador3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador3Layout.setVerticalGroup(
            Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TasquesAsignadesElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesGestionadesElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesTotalsElements1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane_Telefons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Telefons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), null, null, null, null, null},
                { new Boolean(false), null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seleccionar", "Nom", "Usuari Asignat", "Tipus", "Marca", "Estat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_Telefons.setViewportView(jTable_Telefons);

        javax.swing.GroupLayout DashTelefonsLayout = new javax.swing.GroupLayout(DashTelefons);
        DashTelefons.setLayout(DashTelefonsLayout);
        DashTelefonsLayout.setHorizontalGroup(
            DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Telefons, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        DashTelefonsLayout.setVerticalGroup(
            DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createSequentialGroup()
                .addComponent(Contador3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane_Telefons, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DashUsuaris.setBackground(new java.awt.Color(255, 255, 255));
        DashUsuaris.setForeground(new java.awt.Color(51, 51, 255));

        Contador1.setBackground(new java.awt.Color(255, 153, 51));
        Contador1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tasques Totals");
        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tasques Gestionades");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        txtBuscadorUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorUsuarisActionPerformed(evt);
            }
        });
        txtBuscadorUsuaris.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorUsuarisKeyReleased(evt);
            }
        });

        jLabel7.setText("Buscar :");
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        jButtonNouUsuari.setText("Nou");
        jButtonNouUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouUsuariActionPerformed(evt);
            }
        });

        jButtonEliminarUsuari.setText("Eliminar");
        jButtonEliminarUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarUsuariMouseClicked(evt);
            }
        });
        jButtonEliminarUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarUsuariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonNouUsuari)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarUsuari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscadorUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButtonEliminarUsuari)
                    .addComponent(jButtonNouUsuari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TasquesTotalsUsuaris.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesTotalsUsuaris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesTotalsUsuaris.setBackground(new java.awt.Color(0, 153, 255));
        TasquesTotalsUsuaris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesTotalsUsuaris.setForeground(new java.awt.Color(0, 0, 0));

        TasquesAsignadesUsuaris.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesAsignadesUsuaris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesAsignadesUsuaris.setBackground(new java.awt.Color(255, 255, 51));
        TasquesAsignadesUsuaris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesAsignadesUsuaris.setForeground(new java.awt.Color(0, 0, 0));

        TasquesGestionadesUsuaris.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesGestionadesUsuaris.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesGestionadesUsuaris.setBackground(new java.awt.Color(102, 255, 102));
        TasquesGestionadesUsuaris.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesGestionadesUsuaris.setForeground(new java.awt.Color(0, 0, 0));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tasques Asignades");
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Contador1Layout = new javax.swing.GroupLayout(Contador1);
        Contador1.setLayout(Contador1Layout);
        Contador1Layout.setHorizontalGroup(
            Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador1Layout.createSequentialGroup()
                .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador1Layout.createSequentialGroup()
                        .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(TasquesTotalsUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(TasquesAsignadesUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(TasquesGestionadesUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel23)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel6)))
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(Contador1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador1Layout.setVerticalGroup(
            Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TasquesAsignadesUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesGestionadesUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesTotalsUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane_Usuaris.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Usuaris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), null, null, null, null, null},
                { new Boolean(false), null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seleccionar", "Nom", "Cognom", "Usuari", "Nivell", "Estat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_Usuaris.setViewportView(jTable_Usuaris);

        javax.swing.GroupLayout DashUsuarisLayout = new javax.swing.GroupLayout(DashUsuaris);
        DashUsuaris.setLayout(DashUsuarisLayout);
        DashUsuarisLayout.setHorizontalGroup(
            DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Usuaris)
        );
        DashUsuarisLayout.setVerticalGroup(
            DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashUsuarisLayout.createSequentialGroup()
                .addComponent(Contador1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Usuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DashConfiguracio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel91.setText("Configuració");
        jLabel91.setBackground(new java.awt.Color(255, 153, 51));
        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 153, 51));

        jButtonExportar.setText("Exportar BD");
        jButtonExportar.setBackground(new java.awt.Color(255, 153, 51));
        jButtonExportar.setForeground(new java.awt.Color(255, 255, 255));

        jButtonImportar.setText("Importar BD");
        jButtonImportar.setBackground(new java.awt.Color(255, 153, 51));
        jButtonImportar.setForeground(new java.awt.Color(255, 255, 255));

        jCheckBoxSo.setText("Tó de notificació");

        jCheckBoxEnviarCorreu.setText("Enviar Correu");

        jLabel27.setText("Notificació Tasques");
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));

        jLabel98.setText("Base de dades");
        jLabel98.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout DashConfiguracioLayout = new javax.swing.GroupLayout(DashConfiguracio);
        DashConfiguracio.setLayout(DashConfiguracioLayout);
        DashConfiguracioLayout.setHorizontalGroup(
            DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashConfiguracioLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonImportar)
                    .addComponent(jButtonExportar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashConfiguracioLayout.createSequentialGroup()
                .addContainerGap(277, Short.MAX_VALUE)
                .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashConfiguracioLayout.createSequentialGroup()
                        .addComponent(jLabel91)
                        .addGap(273, 273, 273))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashConfiguracioLayout.createSequentialGroup()
                        .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxSo)
                            .addComponent(jCheckBoxEnviarCorreu))
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashConfiguracioLayout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(155, 155, 155))))
            .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashConfiguracioLayout.createSequentialGroup()
                    .addGap(154, 154, 154)
                    .addComponent(jLabel98)
                    .addContainerGap(508, Short.MAX_VALUE)))
        );
        DashConfiguracioLayout.setVerticalGroup(
            DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashConfiguracioLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel91)
                .addGap(63, 63, 63)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExportar)
                    .addComponent(jCheckBoxSo))
                .addGap(27, 27, 27)
                .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonImportar)
                    .addComponent(jCheckBoxEnviarCorreu))
                .addContainerGap(255, Short.MAX_VALUE))
            .addGroup(DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashConfiguracioLayout.createSequentialGroup()
                    .addGap(150, 150, 150)
                    .addComponent(jLabel98)
                    .addContainerGap(350, Short.MAX_VALUE)))
        );

        DashInfoUsuari.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoUsuari.setForeground(new java.awt.Color(51, 51, 255));

        jLabel8.setText("Informació Usuari");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        txt_telefon.setBackground(new java.awt.Color(255, 153, 51));
        txt_telefon.setForeground(new java.awt.Color(255, 255, 255));

        txt_nom.setBackground(new java.awt.Color(255, 153, 51));
        txt_nom.setForeground(new java.awt.Color(255, 255, 255));

        txt_cognom.setBackground(new java.awt.Color(255, 153, 51));
        txt_cognom.setForeground(new java.awt.Color(255, 255, 255));
        txt_cognom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cognomActionPerformed(evt);
            }
        });

        txt_email.setBackground(new java.awt.Color(255, 153, 51));
        txt_email.setForeground(new java.awt.Color(255, 255, 255));

        txt_usuari.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuari.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setText("Nom:");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setText("Telefon:");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setText("Cognom:");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setText("Email:");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setText("Usuari:");
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setText("Nivell:");
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setText("Estat:");
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));

        ComboEstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));
        ComboEstat.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstat.setForeground(new java.awt.Color(255, 255, 255));

        ComboNivell.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell.setBackground(new java.awt.Color(255, 153, 51));
        ComboNivell.setForeground(new java.awt.Color(255, 255, 255));
        ComboNivell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivellActionPerformed(evt);
            }
        });

        jButtonEditarUsuari.setText("Guardar");
        jButtonEditarUsuari.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarUsuari.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarUsuariMouseClicked(evt);
            }
        });
        jButtonEditarUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarUsuariActionPerformed(evt);
            }
        });

        Enrera.setBackground(new java.awt.Color(0, 0, 0));
        Enrera.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout DashInfoUsuariLayout = new javax.swing.GroupLayout(DashInfoUsuari);
        DashInfoUsuari.setLayout(DashInfoUsuariLayout);
        DashInfoUsuariLayout.setHorizontalGroup(
            DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_cognom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(121, 121, 121)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboNivell, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboEstat, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txt_usuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addComponent(Enrera, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel8))
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(jButtonEditarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        DashInfoUsuariLayout.setVerticalGroup(
            DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Enrera, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_usuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(44, 44, 44)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(ComboNivell))
                        .addGap(65, 65, 65)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(ComboEstat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(44, 44, 44)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_cognom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(48, 48, 48)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(54, 54, 54)
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                .addComponent(jButtonEditarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        DashNouUsuari.setBackground(new java.awt.Color(255, 255, 255));

        txt_usuari1.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuari1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Nou Usuari");
        jLabel15.setBackground(new java.awt.Color(255, 153, 51));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 51));

        jLabel17.setText("Cognom");
        jLabel17.setBackground(new java.awt.Color(255, 153, 51));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setText("Email");
        jLabel18.setBackground(new java.awt.Color(255, 153, 51));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));

        jButtonRegistarUsuari.setText("Guardar");
        jButtonRegistarUsuari.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarUsuari.setBorder(null);
        jButtonRegistarUsuari.setBorderPainted(false);
        jButtonRegistarUsuari.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarUsuari.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistarUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistarUsuariMouseClicked(evt);
            }
        });
        jButtonRegistarUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarUsuariActionPerformed(evt);
            }
        });

        jLabel19.setText("Usuari");
        jLabel19.setBackground(new java.awt.Color(255, 153, 51));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setText("Nom");
        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));

        jLabel21.setText("Telèfon");
        jLabel21.setBackground(new java.awt.Color(255, 153, 51));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));

        jLabel22.setText("Nivell");
        jLabel22.setBackground(new java.awt.Color(255, 153, 51));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));

        jLabel24.setText("Estat");
        jLabel24.setBackground(new java.awt.Color(255, 153, 51));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));

        ComboNivell1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell1.setBackground(new java.awt.Color(255, 153, 51));
        ComboNivell1.setForeground(new java.awt.Color(255, 255, 255));
        ComboNivell1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivell1ActionPerformed(evt);
            }
        });

        ComboEstat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));
        ComboEstat1.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstat1.setForeground(new java.awt.Color(255, 255, 255));

        txt_nom1.setBackground(new java.awt.Color(255, 153, 51));
        txt_nom1.setForeground(new java.awt.Color(255, 255, 255));

        txt_cognom1.setBackground(new java.awt.Color(255, 153, 51));
        txt_cognom1.setForeground(new java.awt.Color(255, 255, 255));

        txt_telefon1.setBackground(new java.awt.Color(255, 153, 51));
        txt_telefon1.setForeground(new java.awt.Color(255, 255, 255));

        txt_mail1.setBackground(new java.awt.Color(255, 153, 51));
        txt_mail1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout DashNouUsuariLayout = new javax.swing.GroupLayout(DashNouUsuari);
        DashNouUsuari.setLayout(DashNouUsuariLayout);
        DashNouUsuariLayout.setHorizontalGroup(
            DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addComponent(jButtonRegistarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouUsuariLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_mail1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_telefon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_cognom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboNivell1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_usuari1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(168, 168, 168))
        );
        DashNouUsuariLayout.setVerticalGroup(
            DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usuari1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ComboNivell1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouUsuariLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cognom1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefon1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mail1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addComponent(jButtonRegistarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        DashNouOrdinador.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_model.setBackground(new java.awt.Color(255, 153, 51));
        txt_model.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 151, 30));

        jLabel29.setBackground(new java.awt.Color(255, 153, 51));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 153, 51));
        jLabel29.setText("Nou Ordinador");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 60));

        jLabel30.setText("Data ingrés");
        jLabel30.setBackground(new java.awt.Color(255, 153, 51));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 25));

        jLabel31.setText("Marca");
        jLabel31.setBackground(new java.awt.Color(255, 153, 51));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jButtonRegistarOrdinador.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarOrdinador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarOrdinador.setText("Guardar");
        jButtonRegistarOrdinador.setBorder(null);
        jButtonRegistarOrdinador.setBorderPainted(false);
        jButtonRegistarOrdinador.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistarOrdinador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistarOrdinadorMouseClicked(evt);
            }
        });
        jButtonRegistarOrdinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarOrdinadorActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonRegistarOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 150, 30));

        jLabel32.setText("Model");
        jLabel32.setBackground(new java.awt.Color(255, 153, 51));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 151, 30));

        jLabel33.setText("Nom");
        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, 25));

        jLabel34.setText("Tipus");
        jLabel34.setBackground(new java.awt.Color(255, 153, 51));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 25));

        jLabel35.setText("Número Serie");
        jLabel35.setBackground(new java.awt.Color(255, 153, 51));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 151, 30));

        jLabel36.setText("Observacions");
        jLabel36.setBackground(new java.awt.Color(255, 153, 51));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, 30));

        ComboTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escriptori", "Portàtil" }));
        ComboTipus.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(ComboTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 151, 30));

        ComboEstatElem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatElem.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatElem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(ComboEstatElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 150, 26));

        txt_nomElem.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomElem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nomElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 121, 150, 31));

        txt_numserie.setBackground(new java.awt.Color(255, 153, 51));
        txt_numserie.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_numserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 31));

        txt_marca.setBackground(new java.awt.Color(255, 153, 51));
        txt_marca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 30));

        txt_observacions.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacions.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_observacions, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 186, 190));

        jLabel37.setText("Adquisicó");
        jLabel37.setBackground(new java.awt.Color(255, 153, 51));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 30));

        jLabel96.setText("Estat");
        jLabel96.setBackground(new java.awt.Color(255, 153, 51));
        jLabel96.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 30));

        jRadioButtonRentingOrdinador.setText("Renting");
        jPanel4.add(jRadioButtonRentingOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jRadioButtonCompraOrdinador.setText("Compra");
        jPanel4.add(jRadioButtonCompraOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));

        dataIngresOrdinador.setBackground(new java.awt.Color(255, 153, 51));
        jPanel4.add(dataIngresOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, -1, -1));

        jLabel97.setText("Usuari Assignat");
        jLabel97.setBackground(new java.awt.Color(255, 153, 51));
        jLabel97.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, 25));

        ComboUsuariAssignatOrdinador.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignatOrdinador.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(ComboUsuariAssignatOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 150, 26));

        javax.swing.GroupLayout DashNouOrdinadorLayout = new javax.swing.GroupLayout(DashNouOrdinador);
        DashNouOrdinador.setLayout(DashNouOrdinadorLayout);
        DashNouOrdinadorLayout.setHorizontalGroup(
            DashNouOrdinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        DashNouOrdinadorLayout.setVerticalGroup(
            DashNouOrdinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DashInfoOrdinador.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.setForeground(new java.awt.Color(51, 51, 255));
        DashInfoOrdinador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setText("Informació Element");
        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 60, -1, -1));

        jButtonEditarOrdinador.setText("Guardar");
        jButtonEditarOrdinador.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarOrdinador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarOrdinador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarOrdinadorMouseClicked(evt);
            }
        });
        jButtonEditarOrdinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarOrdinadorActionPerformed(evt);
            }
        });
        DashInfoOrdinador.add(jButtonEditarOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 479, 150, 30));

        Enrera1.setBackground(new java.awt.Color(0, 0, 0));
        Enrera1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(Enrera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 60, 62, 32));

        txt_nomElem1.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomElem1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(txt_nomElem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 150, 31));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Nom");
        DashInfoOrdinador.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 25));

        jLabel40.setBackground(new java.awt.Color(255, 153, 51));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Marca");
        DashInfoOrdinador.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        txt_marca1.setBackground(new java.awt.Color(255, 153, 51));
        txt_marca1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(txt_marca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 150, 30));

        jLabel41.setBackground(new java.awt.Color(255, 153, 51));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Model");
        DashInfoOrdinador.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 151, 30));

        txt_model1.setBackground(new java.awt.Color(255, 153, 51));
        txt_model1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(txt_model1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 151, 30));

        jLabel42.setBackground(new java.awt.Color(255, 153, 51));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Número Serie");
        DashInfoOrdinador.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 151, 30));

        txt_numserie1.setBackground(new java.awt.Color(255, 153, 51));
        txt_numserie1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(txt_numserie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 150, 31));

        ComboEstatElem1.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatElem1.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatElem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        DashInfoOrdinador.add(ComboEstatElem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, 26));

        jLabel99.setBackground(new java.awt.Color(255, 153, 51));
        jLabel99.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Estat");
        DashInfoOrdinador.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, -1, 30));

        ComboTipus1.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipus1.setForeground(new java.awt.Color(255, 255, 255));
        ComboTipus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escriptori", "Portàtil" }));
        DashInfoOrdinador.add(ComboTipus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 151, 30));

        jLabel43.setBackground(new java.awt.Color(255, 153, 51));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Tipus");
        DashInfoOrdinador.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, 25));

        ComboUsuariAssignatOrdinador1.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignatOrdinador1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(ComboUsuariAssignatOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 150, 26));

        jLabel100.setBackground(new java.awt.Color(255, 153, 51));
        jLabel100.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        jLabel100.setText("Usuari Assignat");
        DashInfoOrdinador.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, -1, 25));

        jLabel44.setBackground(new java.awt.Color(255, 153, 51));
        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Adquisicó");
        DashInfoOrdinador.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, -1, 30));

        jRadioButtonRentingOrdinador1.setText("Renting");
        DashInfoOrdinador.add(jRadioButtonRentingOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        jRadioButtonCompraOrdinador1.setText("Compra");
        DashInfoOrdinador.add(jRadioButtonCompraOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, -1, -1));

        txt_observacions1.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacions1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.add(txt_observacions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 186, 190));

        jLabel45.setBackground(new java.awt.Color(255, 153, 51));
        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Observacions");
        DashInfoOrdinador.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, -1, 30));

        dataIngresOrdinador1.setBackground(new java.awt.Color(255, 153, 51));
        DashInfoOrdinador.add(dataIngresOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, -1, -1));

        jLabel46.setBackground(new java.awt.Color(255, 153, 51));
        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Data ingrés");
        DashInfoOrdinador.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, 25));

        DashInfoTasca.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.setForeground(new java.awt.Color(51, 51, 255));
        DashInfoTasca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setText("Informació Tasca Simple");
        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 460, -1));

        txt_titolTasc2.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc2.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(txt_titolTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 150, 30));

        jLabel57.setText("Titol:");
        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        jLabel60.setText("Prioritat: ");
        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel61.setText("Usuari Assignat:");
        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, -1));

        jLabel62.setText("Data Venciment:");
        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jLabel65.setText("Estat:");
        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        ComboEstatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés", "Finalitzada" }));
        ComboEstatTasc2.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTasc2.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(ComboEstatTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 110, 30));

        jButtonEditarTasca.setText("Actualitzar");
        jButtonEditarTasca.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarTasca.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarTasca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarTascaMouseClicked(evt);
            }
        });
        jButtonEditarTasca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarTascaActionPerformed(evt);
            }
        });
        DashInfoTasca.add(jButtonEditarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 150, 30));

        Enrera2.setBackground(new java.awt.Color(0, 0, 0));
        Enrera2.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(Enrera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 62, 32));

        txt_descripcioTasc2.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc2.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(txt_descripcioTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 640, 80));

        jLabel66.setText("Descripció:");
        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        ComboPrioritatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitjana", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc2.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc2.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(ComboPrioritatTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 90, 30));
        DashInfoTasca.add(dateTimePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 260, 30));

        ComboUsuariAssignat2.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignat2.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(ComboUsuariAssignat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 30));

        ComboGrupAfectat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat1.setBackground(new java.awt.Color(255, 153, 51));
        ComboGrupAfectat1.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.add(ComboGrupAfectat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, 180, 30));

        jLabel85.setText("Grup Afectat:");
        jLabel85.setBackground(new java.awt.Color(255, 153, 51));
        jLabel85.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, -1, -1));

        jTableInfoTasca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableInfoTasca);

        DashInfoTasca.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 180, 140));

        jCheckBox1.setText("Mostrar Notificació");
        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 140, 30));

        jTextUsuariAssignat1.setColumns(20);
        jTextUsuariAssignat1.setRows(5);
        jScrollPane6.setViewportView(jTextUsuariAssignat1);

        DashInfoTasca.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 150, 100));

        jButtonAfegirUsuari1.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirUsuari1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAfegirUsuari1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari1.setText("+");
        jButtonAfegirUsuari1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashInfoTasca.add(jButtonAfegirUsuari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 30, 30));

        jButtonChat.setBackground(new java.awt.Color(255, 153, 51));
        jButtonChat.setForeground(new java.awt.Color(255, 255, 255));
        jButtonChat.setText("Chat");
        jButtonChat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChatMouseClicked(evt);
            }
        });
        jButtonChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChatActionPerformed(evt);
            }
        });
        DashInfoTasca.add(jButtonChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 150, 30));

        DashGrups.setBackground(new java.awt.Color(255, 255, 255));
        DashGrups.setForeground(new java.awt.Color(51, 51, 255));

        Contador5.setBackground(new java.awt.Color(255, 153, 51));
        Contador5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador5.setForeground(new java.awt.Color(255, 255, 255));

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setText("Tasques Totals");
        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Tasques Gestionades");
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        txtBuscadorTasques1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorTasques1ActionPerformed(evt);
            }
        });
        txtBuscadorTasques1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorTasques1KeyReleased(evt);
            }
        });

        jLabel68.setText("Buscar :");
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));

        jButtonNouGrup.setText("Nou");

        jButtonEliminarGrup.setText("Eliminar");
        jButtonEliminarGrup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarGrupMouseClicked(evt);
            }
        });
        jButtonEliminarGrup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarGrup(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonNouGrup)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarGrup)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscadorTasques1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorTasques1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel68)
                    .addComponent(jButtonEliminarGrup)
                    .addComponent(jButtonNouGrup))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        TasquesTotalsGrups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesTotalsGrups.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesTotalsGrups.setBackground(new java.awt.Color(0, 153, 255));
        TasquesTotalsGrups.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesTotalsGrups.setForeground(new java.awt.Color(0, 0, 0));

        TasquesAsignadesGrups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesAsignadesGrups.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesAsignadesGrups.setBackground(new java.awt.Color(255, 255, 51));
        TasquesAsignadesGrups.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesAsignadesGrups.setForeground(new java.awt.Color(0, 0, 0));

        TasquesGestionadesGrups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesGestionadesGrups.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesGestionadesGrups.setBackground(new java.awt.Color(102, 255, 102));
        TasquesGestionadesGrups.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesGestionadesGrups.setForeground(new java.awt.Color(0, 0, 0));

        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel69.setText("Tasques Asignades");
        jLabel69.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Contador5Layout = new javax.swing.GroupLayout(Contador5);
        Contador5.setLayout(Contador5Layout);
        Contador5Layout.setHorizontalGroup(
            Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador5Layout.createSequentialGroup()
                .addGroup(Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador5Layout.createSequentialGroup()
                        .addGroup(Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador5Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(TasquesTotalsGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador5Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(TasquesAsignadesGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(TasquesGestionadesGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador5Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel69)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel67)))
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(Contador5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador5Layout.setVerticalGroup(
            Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TasquesAsignadesGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesGestionadesGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesTotalsGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane_Grups.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Grups.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), null, null, null, null, null},
                { new Boolean(false), null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seleccionar", "Titol", "Prioritat", "Usuari", "Data", "Estat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_Grups.setViewportView(jTable_Grups);

        javax.swing.GroupLayout DashGrupsLayout = new javax.swing.GroupLayout(DashGrups);
        DashGrups.setLayout(DashGrupsLayout);
        DashGrupsLayout.setHorizontalGroup(
            DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Grups)
        );
        DashGrupsLayout.setVerticalGroup(
            DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashGrupsLayout.createSequentialGroup()
                .addComponent(Contador5, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Grups, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );

        DashInfoTascaRepeticio.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSetmanes2.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSetmanes2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetmanes2.setText("setmanes");
        DashInfoTascaRepeticio.add(jLabelSetmanes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));
        DashInfoTascaRepeticio.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 50, -1));

        jCheckBoxDissabte1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDissabte1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDissabte1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDissabte1.setText("Dissabte");
        DashInfoTascaRepeticio.add(jCheckBoxDissabte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, -1));

        jCheckBoxDimecres1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimecres1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDimecres1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDimecres1.setText("Dimecres");
        DashInfoTascaRepeticio.add(jCheckBoxDimecres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jCheckBoxDimarts1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimarts1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDimarts1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDimarts1.setText("Dimarts");
        DashInfoTascaRepeticio.add(jCheckBoxDimarts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, -1));

        jCheckBoxDiumenge1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDiumenge1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDiumenge1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDiumenge1.setText("Diumenge");
        DashInfoTascaRepeticio.add(jCheckBoxDiumenge1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        jCheckBoxDijous1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDijous1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDijous1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDijous1.setText("Dijous");
        DashInfoTascaRepeticio.add(jCheckBoxDijous1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jCheckBoxDilluns1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDilluns1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDilluns1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDilluns1.setText("Dilluns");
        DashInfoTascaRepeticio.add(jCheckBoxDilluns1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jCheckBoxDivendres1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDivendres1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDivendres1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxDivendres1.setText("Divendres");
        DashInfoTascaRepeticio.add(jCheckBoxDivendres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabelRepetirCada1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRepetirCada1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRepetirCada1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRepetirCada1.setText("Repetir Cada");
        DashInfoTascaRepeticio.add(jLabelRepetirCada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        dateTimePickerRepeticioFinal1.setEnabled(false);
        DashInfoTascaRepeticio.add(dateTimePickerRepeticioFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 290, -1));

        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("Data Inici: ");
        DashInfoTascaRepeticio.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, -1, 30));

        jLabelDias1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDias1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDias1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDias1.setText("dias");
        DashInfoTascaRepeticio.add(jLabelDias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Repetició");
        DashInfoTascaRepeticio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 84, -1));

        jRadioButtonAcabar1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAcabar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonAcabar1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonAcabar1.setText("Finalitzar després de");
        DashInfoTascaRepeticio.add(jRadioButtonAcabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, -1, -1));

        jRadioButtonMensual1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonMensual1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMensual1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonMensual1.setText("Mensual");
        DashInfoTascaRepeticio.add(jRadioButtonMensual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 80, -1));

        jRadioButtonSetmanal1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonSetmanal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonSetmanal1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonSetmanal1.setText("Setmanal");
        DashInfoTascaRepeticio.add(jRadioButtonSetmanal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jRadioButtonDiari1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDiari1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonDiari1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonDiari1.setText("Diari");
        DashInfoTascaRepeticio.add(jRadioButtonDiari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jButtonEditarTascaRecurrent.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarTascaRecurrent.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarTascaRecurrent.setText("Actualitzar");
        DashInfoTascaRepeticio.add(jButtonEditarTascaRecurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, -1, -1));

        jRadioButtonAnual1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAnual1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonAnual1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonAnual1.setText("Anual");
        DashInfoTascaRepeticio.add(jRadioButtonAnual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 72, -1));
        DashInfoTascaRepeticio.add(dateTimePickerRepeticio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 290, -1));

        jLabelMesos1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMesos1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMesos1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMesos1.setText("mesos");
        DashInfoTascaRepeticio.add(jLabelMesos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabelAnys1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAnys1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAnys1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelAnys1.setText("anys");
        DashInfoTascaRepeticio.add(jLabelAnys1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jRadioButtonDataFinal1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDataFinal1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonDataFinal1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonDataFinal1.setText("Data Final");
        DashInfoTascaRepeticio.add(jRadioButtonDataFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 90, -1));

        jSpinnerAcabar1.setEnabled(false);
        DashInfoTascaRepeticio.add(jSpinnerAcabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 60, -1));

        jLabelSetmanes3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSetmanes3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSetmanes3.setText("vegades");
        DashInfoTascaRepeticio.add(jLabelSetmanes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 50, 20));

        txt_titolTasc3.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc3.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.add(txt_titolTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 130, 31));

        jLabel79.setBackground(new java.awt.Color(0, 0, 0));
        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("Titol");
        DashInfoTascaRepeticio.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jLabel80.setBackground(new java.awt.Color(255, 153, 51));
        jLabel80.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Prioritat");
        DashInfoTascaRepeticio.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));

        ComboPrioritatTasc4.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc4.setForeground(new java.awt.Color(255, 255, 255));
        ComboPrioritatTasc4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        DashInfoTascaRepeticio.add(ComboPrioritatTasc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 100, 26));

        ComboEstatTasc3.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTasc3.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatTasc3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés" }));
        DashInfoTascaRepeticio.add(ComboEstatTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 90, 26));

        jLabel81.setBackground(new java.awt.Color(255, 153, 51));
        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setText("Estat");
        DashInfoTascaRepeticio.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        jLabel82.setText("Usuari Assignat");
        jLabel82.setBackground(new java.awt.Color(255, 153, 51));
        jLabel82.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, -1, 30));

        ComboUsuariAssignat3.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignat3.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.add(ComboUsuariAssignat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 120, 26));

        jCheckBoxNotificacio2.setText("Notificació");
        jCheckBoxNotificacio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacio2ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(jCheckBoxNotificacio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 100, 30));

        txt_descripcioTasc3.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc3.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.add(txt_descripcioTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 650, 80));

        jLabel83.setBackground(new java.awt.Color(255, 153, 51));
        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Descripció");
        DashInfoTascaRepeticio.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, 30));

        ComboMesNumero1.setBackground(new java.awt.Color(255, 153, 51));
        ComboMesNumero1.setForeground(new java.awt.Color(255, 255, 255));
        ComboMesNumero1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primer", "Segon", "Tercer", "Cuart", "Últim" }));
        DashInfoTascaRepeticio.add(ComboMesNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 90, 26));

        jRadioButtonEl1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonEl1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonEl1.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonEl1.setText("El");
        DashInfoTascaRepeticio.add(jRadioButtonEl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        ComboMesDia1.setBackground(new java.awt.Color(255, 153, 51));
        ComboMesDia1.setForeground(new java.awt.Color(255, 255, 255));
        ComboMesDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge" }));
        ComboMesDia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesDia1ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(ComboMesDia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 90, 26));

        ComboMes1.setBackground(new java.awt.Color(255, 153, 51));
        ComboMes1.setForeground(new java.awt.Color(255, 255, 255));
        ComboMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre" }));
        ComboMes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMes1ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(ComboMes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 90, 26));

        ComboGrupAfectat3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat3.setBackground(new java.awt.Color(255, 153, 51));
        ComboGrupAfectat3.setForeground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.add(ComboGrupAfectat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 150, 26));

        jLabel87.setText("Grup Afectat");
        jLabel87.setBackground(new java.awt.Color(255, 153, 51));
        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, 30));

        jTableInfoTasca1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableInfoTasca1);

        DashInfoTascaRepeticio.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 160, 70));

        jTextUsuariAssignat3.setColumns(20);
        jTextUsuariAssignat3.setRows(5);
        jScrollPane8.setViewportView(jTextUsuariAssignat3);

        DashInfoTascaRepeticio.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 140, 100));

        jButtonAfegirUsuari3.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirUsuari3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAfegirUsuari3.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari3.setText("+");
        jButtonAfegirUsuari3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashInfoTascaRepeticio.add(jButtonAfegirUsuari3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 260, 30, 30));

        DashPerfilUsuari.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCanviarContrasenya.setText("Canviar contrasenya");
        jButtonCanviarContrasenya.setBackground(new java.awt.Color(255, 153, 51));
        jButtonCanviarContrasenya.setBorder(null);
        jButtonCanviarContrasenya.setBorderPainted(false);
        jButtonCanviarContrasenya.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCanviarContrasenya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonGuardarFoto.setText("Guardar Foto");
        jButtonGuardarFoto.setBackground(new java.awt.Color(255, 153, 51));
        jButtonGuardarFoto.setBorder(null);
        jButtonGuardarFoto.setBorderPainted(false);
        jButtonGuardarFoto.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonCanviarFoto.setText("Selecionar foto");
        jButtonCanviarFoto.setBackground(new java.awt.Color(255, 153, 51));
        jButtonCanviarFoto.setBorder(null);
        jButtonCanviarFoto.setBorderPainted(false);
        jButtonCanviarFoto.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCanviarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        cLabelFoto.setText("");

        jLabel70.setText("Perfil");
        jLabel70.setBackground(new java.awt.Color(255, 153, 51));
        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 153, 51));

        javax.swing.GroupLayout DashPerfilUsuariLayout = new javax.swing.GroupLayout(DashPerfilUsuari);
        DashPerfilUsuari.setLayout(DashPerfilUsuariLayout);
        DashPerfilUsuariLayout.setHorizontalGroup(
            DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                .addGap(312, 312, 312)
                .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashPerfilUsuariLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel70))
                        .addGap(365, 365, 365))
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonCanviarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jButtonGuardarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jButtonCanviarContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DashPerfilUsuariLayout.setVerticalGroup(
            DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel70)
                .addGap(33, 33, 33)
                .addComponent(cLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNomImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCanviarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGuardarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonCanviarContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(334, Short.MAX_VALUE))
        );

        DashNovaTascaRepeticio.setBackground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.setMaximumSize(new java.awt.Dimension(700, 502));
        DashNovaTascaRepeticio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSetmanes.setText("setmanes");
        jLabelSetmanes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSetmanes.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelSetmanes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));
        DashNovaTascaRepeticio.add(jSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 50, -1));

        jCheckBoxDissabte.setText("Dissabte");
        jCheckBoxDissabte.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDissabte.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDissabte.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDissabte, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, -1, 20));

        jCheckBoxDimecres.setText("Dimecres");
        jCheckBoxDimecres.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimecres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDimecres.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDimecres, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        jCheckBoxDimarts.setText("Dimarts");
        jCheckBoxDimarts.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimarts.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDimarts.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDimarts, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, -1, 20));

        jCheckBoxDiumenge.setText("Diumenge");
        jCheckBoxDiumenge.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDiumenge.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDiumenge.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDiumenge, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jCheckBoxDijous.setText("Dijous");
        jCheckBoxDijous.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDijous.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDijous.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDijous, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, 20));

        jCheckBoxDilluns.setText("Dilluns");
        jCheckBoxDilluns.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDilluns.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDilluns.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDilluns, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jCheckBoxDivendres.setText("Divendres");
        jCheckBoxDivendres.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDivendres.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxDivendres.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDivendres, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, -1, -1));

        jLabelRepetirCada.setText("Repetir Cada");
        jLabelRepetirCada.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRepetirCada.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelRepetirCada.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelRepetirCada, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        dateTimePickerRepeticioFinal.setEnabled(false);
        DashNovaTascaRepeticio.add(dateTimePickerRepeticioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 320, -1));

        jLabel4.setText("Data Inici: ");
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, 20));

        jLabelDias.setText("dias");
        jLabelDias.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDias.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabel2.setText("Nova Tasca Recurrent");
        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 360, -1));

        jRadioButtonAcabar.setText("Acabar després de ");
        jRadioButtonAcabar.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAcabar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonAcabar.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonAcabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        jRadioButtonMensual.setText("Mensual");
        jRadioButtonMensual.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonMensual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonMensual.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 80, -1));

        jRadioButtonSetmanal.setText("Setmanal");
        jRadioButtonSetmanal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonSetmanal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonSetmanal.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonSetmanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        jRadioButtonDiari.setText("Diari");
        jRadioButtonDiari.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDiari.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonDiari.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonDiari, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, -1, -1));

        jButtonCancelar.setBackground(new java.awt.Color(255, 153, 51));
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        DashNovaTascaRepeticio.add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, -1, -1));

        jButtonAceptar.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAceptar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAceptar.setText("Aceptar");
        DashNovaTascaRepeticio.add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, -1));

        jRadioButtonAnual.setText("Anual");
        jRadioButtonAnual.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAnual.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonAnual.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 72, -1));
        DashNovaTascaRepeticio.add(dateTimePickerRepeticio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 320, -1));

        jLabelMesos.setText("mesos");
        jLabelMesos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMesos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMesos.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelMesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jLabelAnys.setText("anys");
        jLabelAnys.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAnys.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAnys.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelAnys, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        jRadioButtonDataFinal.setText("Data Final");
        jRadioButtonDataFinal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDataFinal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonDataFinal.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 90, 30));

        jSpinnerAcabar.setEnabled(false);
        DashNovaTascaRepeticio.add(jSpinnerAcabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 60, -1));

        jLabelSetmanes1.setText("vegades");
        jLabelSetmanes1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSetmanes1.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelSetmanes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        txt_titolTasc1.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc1.setForeground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.add(txt_titolTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 130, 31));

        jLabel71.setBackground(new java.awt.Color(0, 0, 0));
        jLabel71.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("Titol");
        DashNovaTascaRepeticio.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, 25));

        jLabel74.setBackground(new java.awt.Color(255, 153, 51));
        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Prioritat");
        DashNovaTascaRepeticio.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        ComboPrioritatTasc3.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc3.setForeground(new java.awt.Color(255, 255, 255));
        ComboPrioritatTasc3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        DashNovaTascaRepeticio.add(ComboPrioritatTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 100, 26));

        ComboEstatTasc1.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTasc1.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatTasc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés" }));
        DashNovaTascaRepeticio.add(ComboEstatTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 90, 26));

        jLabel75.setBackground(new java.awt.Color(255, 153, 51));
        jLabel75.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Estat");
        DashNovaTascaRepeticio.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        jLabel76.setText("Usuari Assignat");
        jLabel76.setBackground(new java.awt.Color(255, 153, 51));
        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, -1, 25));

        ComboUsuariAssignat1.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignat1.setForeground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.add(ComboUsuariAssignat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 120, 26));

        jCheckBoxNotificacio1.setText("Mostrar Notificació");
        jCheckBoxNotificacio1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBoxNotificacio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacio1ActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(jCheckBoxNotificacio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 170, 30));

        txt_descripcioTasc1.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc1.setForeground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.add(txt_descripcioTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 650, 80));

        jLabel77.setText("Descripció");
        jLabel77.setBackground(new java.awt.Color(255, 153, 51));
        jLabel77.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, -1, 30));

        ComboMesNumero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primer", "Segon", "Tercer", "Cuart", "Últim" }));
        ComboMesNumero.setBackground(new java.awt.Color(255, 153, 51));
        ComboMesNumero.setForeground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.add(ComboMesNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 100, 26));

        ComboMesDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge" }));
        ComboMesDia.setBackground(new java.awt.Color(255, 153, 51));
        ComboMesDia.setForeground(new java.awt.Color(255, 255, 255));
        ComboMesDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesDiaActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(ComboMesDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 90, 26));

        jRadioButtonEl.setText("El");
        jRadioButtonEl.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonEl.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonEl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, -1, -1));

        ComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre" }));
        ComboMes.setBackground(new java.awt.Color(255, 153, 51));
        ComboMes.setForeground(new java.awt.Color(255, 255, 255));
        ComboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(ComboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 90, 26));

        ComboGrupAfectat2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat2.setBackground(new java.awt.Color(255, 153, 51));
        ComboGrupAfectat2.setForeground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.add(ComboGrupAfectat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 120, 26));

        jLabel86.setText("Grup Afectat");
        jLabel86.setBackground(new java.awt.Color(255, 153, 51));
        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 110, -1, 25));

        jTextUsuariAssignat2.setColumns(20);
        jTextUsuariAssignat2.setRows(5);
        jScrollPane7.setViewportView(jTextUsuariAssignat2);

        DashNovaTascaRepeticio.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 140, 120));

        jButtonAfegirUsuari2.setBackground(new java.awt.Color(255, 153, 51));
        jButtonAfegirUsuari2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAfegirUsuari2.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari2.setText("+");
        jButtonAfegirUsuari2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashNovaTascaRepeticio.add(jButtonAfegirUsuari2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, 30, 30));

        DashOrdinadors.setBackground(new java.awt.Color(255, 255, 255));
        DashOrdinadors.setForeground(new java.awt.Color(51, 51, 255));
        DashOrdinadors.setPreferredSize(new java.awt.Dimension(776, 537));

        jScrollPane_Ordiandors.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Ordinadors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Boolean(false), null, null, null, null, null},
                { new Boolean(false), null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Seleccionar", "Nom", "Usuari Asignat", "Tipus", "Marca", "Estat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane_Ordiandors.setViewportView(jTable_Ordinadors);

        Contador6.setBackground(new java.awt.Color(255, 153, 51));
        Contador6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Tasques Totals");
        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Tasques Gestionades");
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));

        txtBuscadorOrdinadors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorOrdinadorsActionPerformed(evt);
            }
        });
        txtBuscadorOrdinadors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorOrdinadorsKeyReleased(evt);
            }
        });

        jLabel28.setText("Buscar :");
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));

        jButtonNouOrdinador.setText("Nou");
        jButtonNouOrdinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouOrdinadorActionPerformed(evt);
            }
        });

        jButtonEliminarOrdinadors.setText("Eliminar");
        jButtonEliminarOrdinadors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarOrdinadorsMouseClicked(evt);
            }
        });
        jButtonEliminarOrdinadors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarOrdinadorsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonNouOrdinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarOrdinadors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscadorOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jButtonEliminarOrdinadors)
                    .addComponent(jButtonNouOrdinador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TasquesTotalsElements.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesTotalsElements.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesTotalsElements.setBackground(new java.awt.Color(0, 153, 255));
        TasquesTotalsElements.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesTotalsElements.setForeground(new java.awt.Color(0, 0, 0));

        TasquesAsignadesElements.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesAsignadesElements.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesAsignadesElements.setBackground(new java.awt.Color(255, 255, 51));
        TasquesAsignadesElements.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesAsignadesElements.setForeground(new java.awt.Color(0, 0, 0));

        TasquesGestionadesElements.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TasquesGestionadesElements.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TasquesGestionadesElements.setBackground(new java.awt.Color(102, 255, 102));
        TasquesGestionadesElements.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TasquesGestionadesElements.setForeground(new java.awt.Color(0, 0, 0));

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel101.setText("Tasques Asignades");
        jLabel101.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Contador6Layout = new javax.swing.GroupLayout(Contador6);
        Contador6.setLayout(Contador6Layout);
        Contador6Layout.setHorizontalGroup(
            Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador6Layout.createSequentialGroup()
                .addGroup(Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador6Layout.createSequentialGroup()
                        .addGroup(Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador6Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(TasquesTotalsElements, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador6Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(TasquesAsignadesElements, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(TasquesGestionadesElements, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador6Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel101)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel26)))
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(Contador6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador6Layout.setVerticalGroup(
            Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel101, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TasquesAsignadesElements, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesGestionadesElements, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TasquesTotalsElements, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashOrdinadorsLayout = new javax.swing.GroupLayout(DashOrdinadors);
        DashOrdinadors.setLayout(DashOrdinadorsLayout);
        DashOrdinadorsLayout.setHorizontalGroup(
            DashOrdinadorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane_Ordiandors, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
            .addComponent(Contador6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DashOrdinadorsLayout.setVerticalGroup(
            DashOrdinadorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashOrdinadorsLayout.createSequentialGroup()
                .addComponent(Contador6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane_Ordiandors, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(270, 270, 270))
        );

        DashNouTelefon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_modelTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_modelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 151, 30));

        jLabel102.setBackground(new java.awt.Color(255, 153, 51));
        jLabel102.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 153, 51));
        jLabel102.setText("Nou Telefon");
        jPanel14.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 60));

        jLabel103.setText("Data ingrés");
        jLabel103.setBackground(new java.awt.Color(255, 153, 51));
        jLabel103.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, 25));

        jLabel104.setText("Marca");
        jLabel104.setBackground(new java.awt.Color(255, 153, 51));
        jLabel104.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jButtonRegistarTelefon.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarTelefon.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarTelefon.setText("Guardar");
        jButtonRegistarTelefon.setBorder(null);
        jButtonRegistarTelefon.setBorderPainted(false);
        jButtonRegistarTelefon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRegistarTelefon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistarTelefonMouseClicked(evt);
            }
        });
        jButtonRegistarTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistarTelefonActionPerformed(evt);
            }
        });
        jPanel14.add(jButtonRegistarTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 150, 30));

        jLabel105.setText("Model");
        jLabel105.setBackground(new java.awt.Color(255, 153, 51));
        jLabel105.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 151, 30));

        jLabel106.setText("Nom");
        jLabel106.setBackground(new java.awt.Color(0, 0, 0));
        jLabel106.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, 25));

        jLabel107.setText("Tipus");
        jLabel107.setBackground(new java.awt.Color(255, 153, 51));
        jLabel107.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 25));

        jLabel108.setText("Número Serie");
        jLabel108.setBackground(new java.awt.Color(255, 153, 51));
        jLabel108.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 151, 30));

        jLabel109.setText("Observacions");
        jLabel109.setBackground(new java.awt.Color(255, 153, 51));
        jLabel109.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, 30));

        ComboTipusTel.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipusTel.setForeground(new java.awt.Color(255, 255, 255));
        ComboTipusTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SmartPhone", "Mòbil", "Teléfon" }));
        jPanel14.add(ComboTipusTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 151, 30));

        ComboEstatTel.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTel.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        jPanel14.add(ComboEstatTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 150, 26));

        txt_nomTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_nomTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 121, 150, 31));

        txt_imeiTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_imeiTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_imeiTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 31));

        txt_marcaTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_marcaTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_marcaTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 30));

        txt_observacionsTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacionsTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_observacionsTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 186, 110));

        jLabel110.setText("Adquisicó");
        jLabel110.setBackground(new java.awt.Color(255, 153, 51));
        jLabel110.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 30));

        jLabel111.setText("Estat");
        jLabel111.setBackground(new java.awt.Color(255, 153, 51));
        jLabel111.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 30));

        jRadioButtonRentingTel.setText("Renting");
        jPanel14.add(jRadioButtonRentingTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jRadioButtonCompraTel.setText("Compra");
        jPanel14.add(jRadioButtonCompraTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));

        dataIngresTel.setBackground(new java.awt.Color(255, 153, 51));
        jPanel14.add(dataIngresTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel112.setText("Usuari Assignat");
        jLabel112.setBackground(new java.awt.Color(255, 153, 51));
        jLabel112.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 0, 0));
        jPanel14.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 25));

        ComboUsuariAssignatTel.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignatTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(ComboUsuariAssignatTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 150, 26));

        jLabel125.setBackground(new java.awt.Color(255, 153, 51));
        jLabel125.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 0, 0));
        jLabel125.setText("Número");
        jPanel14.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 151, 30));

        txt_numeroTel.setBackground(new java.awt.Color(255, 153, 51));
        txt_numeroTel.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(txt_numeroTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 150, 31));

        javax.swing.GroupLayout DashNouTelefonLayout = new javax.swing.GroupLayout(DashNouTelefon);
        DashNouTelefon.setLayout(DashNouTelefonLayout);
        DashNouTelefonLayout.setHorizontalGroup(
            DashNouTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouTelefonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        DashNouTelefonLayout.setVerticalGroup(
            DashNouTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouTelefonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DashInfoTelefon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_modelTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_modelTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 151, 30));

        jLabel113.setBackground(new java.awt.Color(255, 153, 51));
        jLabel113.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(255, 153, 51));
        jLabel113.setText("Nou Telefon");
        jPanel15.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 60));

        jLabel114.setBackground(new java.awt.Color(255, 153, 51));
        jLabel114.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setText("Data ingrés");
        jPanel15.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, -1, 25));

        jLabel115.setText("Marca");
        jLabel115.setBackground(new java.awt.Color(255, 153, 51));
        jLabel115.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jButtonEditarTelefon.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarTelefon.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarTelefon.setText("Guardar");
        jButtonEditarTelefon.setBorder(null);
        jButtonEditarTelefon.setBorderPainted(false);
        jButtonEditarTelefon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditarTelefon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarTelefonMouseClicked(evt);
            }
        });
        jButtonEditarTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarTelefonActionPerformed(evt);
            }
        });
        jPanel15.add(jButtonEditarTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 150, 30));

        jLabel116.setText("Model");
        jLabel116.setBackground(new java.awt.Color(255, 153, 51));
        jLabel116.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 151, 30));

        jLabel117.setText("Nom");
        jLabel117.setBackground(new java.awt.Color(0, 0, 0));
        jLabel117.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, 25));

        jLabel118.setText("Tipus");
        jLabel118.setBackground(new java.awt.Color(255, 153, 51));
        jLabel118.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, 25));

        jLabel119.setText("Número");
        jLabel119.setBackground(new java.awt.Color(255, 153, 51));
        jLabel119.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 151, 30));

        jLabel120.setBackground(new java.awt.Color(255, 153, 51));
        jLabel120.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 0));
        jLabel120.setText("Observacions");
        jPanel15.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, 30));

        ComboTipusTel1.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipusTel1.setForeground(new java.awt.Color(255, 255, 255));
        ComboTipusTel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SmartPhone", "Mòbil", "Teléfon" }));
        jPanel15.add(ComboTipusTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 151, 30));

        ComboEstatTel1.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTel1.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatTel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        jPanel15.add(ComboEstatTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 150, 26));

        txt_nomTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_nomTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 121, 150, 31));

        txt_imeiTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_imeiTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_imeiTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 31));

        txt_marcaTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_marcaTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_marcaTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 30));

        txt_observacionsTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacionsTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_observacionsTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 186, 110));

        jLabel121.setText("Adquisicó");
        jLabel121.setBackground(new java.awt.Color(255, 153, 51));
        jLabel121.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, -1, 30));

        jLabel122.setText("Estat");
        jLabel122.setBackground(new java.awt.Color(255, 153, 51));
        jLabel122.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 0, 0));
        jPanel15.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, 30));

        jRadioButtonRentingTel1.setText("Renting");
        jPanel15.add(jRadioButtonRentingTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, -1, -1));

        jRadioButtonCompraTel1.setText("Compra");
        jPanel15.add(jRadioButtonCompraTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, -1, -1));

        dataIngresTel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel15.add(dataIngresTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, -1, -1));

        jLabel123.setBackground(new java.awt.Color(255, 153, 51));
        jLabel123.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jLabel123.setText("Usuari Assignat");
        jPanel15.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, 25));

        ComboUsuariAssignatTel1.setBackground(new java.awt.Color(255, 153, 51));
        ComboUsuariAssignatTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(ComboUsuariAssignatTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 150, 26));

        txt_numeroTel1.setBackground(new java.awt.Color(255, 153, 51));
        txt_numeroTel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel15.add(txt_numeroTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 150, 31));

        jLabel124.setBackground(new java.awt.Color(255, 153, 51));
        jLabel124.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 0, 0));
        jLabel124.setText("IMEI");
        jPanel15.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 151, 30));

        javax.swing.GroupLayout DashInfoTelefonLayout = new javax.swing.GroupLayout(DashInfoTelefon);
        DashInfoTelefon.setLayout(DashInfoTelefonLayout);
        DashInfoTelefonLayout.setHorizontalGroup(
            DashInfoTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        DashInfoTelefonLayout.setVerticalGroup(
            DashInfoTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashBoardViewLayout = new javax.swing.GroupLayout(DashBoardView);
        DashBoardView.setLayout(DashBoardViewLayout);
        DashBoardViewLayout.setHorizontalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardViewLayout.createSequentialGroup()
                .addComponent(DashConfiguracio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 48, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashUsuaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashInfoUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashNouOrdinador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 108, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 45, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashGrups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashNouGrup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashPerfilUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 48, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTriaTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 48, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(61, 61, 61)
                    .addComponent(DashInfoGrup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(61, 61, 61)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTriaElement, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 51, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 47, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 49, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DashChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DashBoardViewLayout.setVerticalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardViewLayout.createSequentialGroup()
                .addComponent(DashConfiguracio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(203, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 16, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(182, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 203, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoOrdinador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTasques, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 191, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashGrups, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 78, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashPerfilUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 7, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashNovaTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(187, 187, 187)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTriaTasca, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 204, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 188, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(DashInfoGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTriaElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 203, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashTelefons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 189, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(197, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(DashInfoTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DashChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(DashBoardView, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1046, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Canviar el color de les icones
    public void changecolor(JPanel hover, Color rand) {

        hover.setBackground(rand);

    }

    //Establir el color al passar amb el ratolí
    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 204, 102));
    }//GEN-LAST:event_CloseMouseEntered

    //Establir el color per defecte
    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 153, 0));
    }//GEN-LAST:event_CloseMouseExited

    //Establir l'accio al clickar el boto
    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color(255, 204, 102));
    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color(255, 153, 0));
    }//GEN-LAST:event_MaxMouseExited

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != JFPrincipal.MAXIMIZED_BOTH) {
            this.setExtendedState(JFPrincipal.MAXIMIZED_BOTH);

        } else {
            this.setExtendedState(JFPrincipal.NORMAL);

        }

    }//GEN-LAST:event_MaxMouseClicked

    public void changeimage(JLabel button, String resourceimg) {

        ImageIcon aimg = new ImageIcon(getClass().getResource(resourceimg));
        button.setIcon(aimg);

    }

    public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {

        if (dashboard == true) {

            menushowhide.setPreferredSize(new Dimension(50, menushowhide.getHeight()));
            //changeimage(button, "src/images/menu_32px.png");
            ImageIcon config_logo = new ImageIcon("src/images/menu_32px.png");
            MenuDes.setIcon(config_logo);
            this.repaint();
        } else {

            menushowhide.setPreferredSize(new Dimension(270, menushowhide.getHeight()));
            //changeimage(button, "src/images/back_32px.png");
            ImageIcon config_logo = new ImageIcon("src/images/back_32px.png");
            MenuDes.setIcon(config_logo);
            this.repaint();

        }

    }

    private void MenuDesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDesMouseEntered
        // TODO add your handling code here:
        changecolor(LiniaHideMenu, new Color(51, 51, 51));
        changecolor(HideMenu, new Color(255, 204, 102));
    }//GEN-LAST:event_MenuDesMouseEntered

    private void MenuDesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDesMouseExited
        // TODO add your handling code here:
        changecolor(LiniaHideMenu, new Color(255, 153, 0));
        changecolor(HideMenu, new Color(255, 153, 0));
    }//GEN-LAST:event_MenuDesMouseExited

    private void MenuDesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuDesMouseClicked
        // TODO add your handling code here:
        //clickmenu(HideMenu,Configuracio, 1);
        if (a == true) {
            hideshow(Menu, a, MenuDes);
            SwingUtilities.updateComponentTreeUI(this);
            a = false;
        } else {
            hideshow(Menu, a, MenuDes);
            SwingUtilities.updateComponentTreeUI(this);
            a = true;
        }

    }//GEN-LAST:event_MenuDesMouseClicked

    private void btnConfiguracioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracioMouseEntered
        // TODO add your handling code here:
        changecolor(Configuracio, new Color(255, 204, 102));
        changecolor(N_Configuracio, new Color(255, 204, 102));

    }//GEN-LAST:event_btnConfiguracioMouseEntered

    private void btnConfiguracioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracioMouseExited
        // TODO add your handling code here:
        changecolor(Configuracio, new Color(255, 153, 0));
        changecolor(N_Configuracio, new Color(255, 153, 0));

    }//GEN-LAST:event_btnConfiguracioMouseExited

    private void btnConfiguracioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfiguracioMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnConfiguracioMouseClicked

    private void btnTasquesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTasquesMouseEntered
        // TODO add your handling code here:
        changecolor(Tasques, new Color(255, 204, 102));
        changecolor(N_Tasques, new Color(255, 204, 102));

    }//GEN-LAST:event_btnTasquesMouseEntered

    private void btnTasquesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTasquesMouseExited
        // TODO add your handling code here:
        changecolor(Tasques, new Color(255, 153, 0));
        changecolor(N_Tasques, new Color(255, 153, 0));

    }//GEN-LAST:event_btnTasquesMouseExited

    private void btnElementsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElementsMouseEntered
        // TODO add your handling code here:
        changecolor(Elements, new Color(255, 204, 102));
        changecolor(N_Elements, new Color(255, 204, 102));

    }//GEN-LAST:event_btnElementsMouseEntered

    private void btnElementsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnElementsMouseExited
        // TODO add your handling code here:
        changecolor(Elements, new Color(255, 153, 0));
        changecolor(N_Elements, new Color(255, 153, 0));

    }//GEN-LAST:event_btnElementsMouseExited

    private void btnUsuarisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarisMouseEntered
        // TODO add your handling code here:
        changecolor(Usuaris, new Color(255, 204, 102));
        changecolor(N_Usuaris, new Color(255, 204, 102));
    }//GEN-LAST:event_btnUsuarisMouseEntered

    private void btnUsuarisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarisMouseExited
        // TODO add your handling code here:
        changecolor(Usuaris, new Color(255, 153, 0));
        changecolor(N_Usuaris, new Color(255, 153, 0));
    }//GEN-LAST:event_btnUsuarisMouseExited

    private void btnGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGrupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGrupMouseClicked

    private void btnGrupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGrupMouseEntered
        // TODO add your handling code here:
        changecolor(Grups, new Color(255, 204, 102));
        changecolor(N_Grups, new Color(255, 204, 102));
    }//GEN-LAST:event_btnGrupMouseEntered

    private void btnGrupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGrupMouseExited
        // TODO add your handling code here:
        changecolor(Grups, new Color(255, 153, 0));
        changecolor(N_Grups, new Color(255, 153, 0));
    }//GEN-LAST:event_btnGrupMouseExited

    private void N_TasquesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_TasquesMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_N_TasquesMouseEntered

    private void N_TasquesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_TasquesMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_N_TasquesMouseExited

    private void btn_ElementsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ElementsMouseEntered
        // TODO add your handling code here:
        changecolor(N_Elements, new Color(255, 204, 102));
        changecolor(Elements, new Color(255, 204, 102));
    }//GEN-LAST:event_btn_ElementsMouseEntered

    private void btn_ElementsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ElementsMouseExited
        // TODO add your handling code here:
        changecolor(N_Elements, new Color(255, 153, 0));
        changecolor(Elements, new Color(255, 153, 0));
    }//GEN-LAST:event_btn_ElementsMouseExited

    private void btn_UsuarisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UsuarisMouseEntered
        // TODO add your handling code here:
        changecolor(N_Usuaris, new Color(255, 204, 102));
        changecolor(Usuaris, new Color(255, 204, 102));

    }//GEN-LAST:event_btn_UsuarisMouseEntered

    private void btn_UsuarisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UsuarisMouseExited
        // TODO add your handling code here:
        changecolor(Usuaris, new Color(255, 153, 0));
        changecolor(N_Usuaris, new Color(255, 153, 0));
    }//GEN-LAST:event_btn_UsuarisMouseExited

    private void N_UsuarisMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_UsuarisMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_N_UsuarisMouseEntered

    private void N_UsuarisMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_UsuarisMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_N_UsuarisMouseExited

    private void btn_GrupsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GrupsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_GrupsMouseClicked

    private void btn_GrupsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GrupsMouseEntered
        // TODO add your handling code here:
        changecolor(N_Grups, new Color(255, 204, 102));
        changecolor(Grups, new Color(255, 204, 102));
    }//GEN-LAST:event_btn_GrupsMouseEntered

    private void btn_GrupsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GrupsMouseExited
        // TODO add your handling code here:
        changecolor(Grups, new Color(255, 153, 0));
        changecolor(N_Grups, new Color(255, 153, 0));
    }//GEN-LAST:event_btn_GrupsMouseExited

    private void N_UsuariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_UsuariMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_N_UsuariMouseEntered

    private void N_UsuariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_UsuariMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_N_UsuariMouseExited

    private void btn_ConfiguracioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfiguracioMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_ConfiguracioMouseClicked

    private void btn_ConfiguracioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfiguracioMouseEntered
        // TODO add your handling code here:
        changecolor(N_Configuracio, new Color(255, 204, 102));
        changecolor(Configuracio, new Color(255, 204, 102));

    }//GEN-LAST:event_btn_ConfiguracioMouseEntered

    private void btn_ConfiguracioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfiguracioMouseExited
        // TODO add your handling code here:
        changecolor(Configuracio, new Color(255, 153, 0));
        changecolor(N_Configuracio, new Color(255, 153, 0));

    }//GEN-LAST:event_btn_ConfiguracioMouseExited

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color(255, 204, 102));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color(255, 153, 0));
    }//GEN-LAST:event_MinMouseExited

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_HeaderMouseDragged

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        // TODO add your handling code here:

        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void btnUsuarisMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarisMouseReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_btnUsuarisMouseReleased

    private void txtBuscadorUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorUsuarisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorUsuarisActionPerformed

    private void ComboNivellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivellActionPerformed

    private void jButtonEditarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarUsuariActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEditarUsuariActionPerformed

    private void txt_cognomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cognomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cognomActionPerformed

    private void jButtonEliminarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuariActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEliminarUsuariActionPerformed

    /* public boolean IsSelected(int fila, int columna, JTable taula) {

        Boolean checked = Boolean.valueOf(taula.getValueAt(fila, columna).toString());
        System.out.print(checked);
        return checked;

    }*/
    private void jButtonEliminarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuariMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEliminarUsuariMouseClicked

    private void txtBuscadorUsuarisKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorUsuarisKeyReleased
        // TODO add your handling code here:
        // BuscarUsuaris(txt_buscador.getText());
    }//GEN-LAST:event_txtBuscadorUsuarisKeyReleased

    private void jButtonNouUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNouUsuariActionPerformed
        // TODO add your handling code here:   
        //DashUsuaris.setVisible(false);
        //DashNouUsuari.setVisible(true);
    }//GEN-LAST:event_jButtonNouUsuariActionPerformed

    //Modificar Usuari
    private void jButtonEditarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarUsuariMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEditarUsuariMouseClicked

    //Crear Elements
    private void jButtonRegistarOrdinadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistarOrdinadorMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonRegistarOrdinadorMouseClicked

    private void jButtonRegistarOrdinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarOrdinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarOrdinadorActionPerformed

    //Modificacio ELements
    private void jButtonEditarOrdinadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarOrdinadorMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEditarOrdinadorMouseClicked

    private void jButtonEditarOrdinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarOrdinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarOrdinadorActionPerformed

    private void txtBuscadorTasquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTasquesActionPerformed

    private void txtBuscadorTasquesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesKeyReleased
        // TODO add your handling code here:

        // BuscarTasques(txtBuscadorTasques.getText());
    }//GEN-LAST:event_txtBuscadorTasquesKeyReleased

    private void jButtonEliminarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarTascaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonEliminarTascaMouseClicked

    private void jButtonEliminarTasca(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTasca
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTasca

    //Modificar Tasca
    private void jButtonEditarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarTascaMouseClicked

    }//GEN-LAST:event_jButtonEditarTascaMouseClicked

    private void jButtonEditarTascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTascaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarTascaActionPerformed

    private void jButtonNomUsuariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseEntered
        // TODO add your handling code here:
        changecolor(N_Usuari, new Color(255, 204, 102));

    }//GEN-LAST:event_jButtonNomUsuariMouseEntered

    private void jButtonNomUsuariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseExited
        // TODO add your handling code here:

        changecolor(N_Usuari, new Color(255, 153, 0));
    }//GEN-LAST:event_jButtonNomUsuariMouseExited

    private void txtBuscadorTasques1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorTasques1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTasques1ActionPerformed

    private void txtBuscadorTasques1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorTasques1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTasques1KeyReleased

    private void jButtonEliminarGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarGrupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarGrupMouseClicked

    private void jButtonEliminarGrup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarGrup
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarGrup

    private void jRadioButtonElementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonElementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonElementsActionPerformed

    private void jRadioButtonUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUsuarisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonUsuarisActionPerformed

    private void jCheckBoxNotificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacioActionPerformed

    private void btn_TasquesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TasquesMouseEntered
        // TODO add your handling code here:
        changecolor(Tasques, new Color(255, 204, 102));
        changecolor(N_Tasques, new Color(255, 204, 102));

    }//GEN-LAST:event_btn_TasquesMouseEntered

    private void btn_TasquesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TasquesMouseExited
        // TODO add your handling code here:

        changecolor(Tasques, new Color(255, 153, 0));
        changecolor(N_Tasques, new Color(255, 153, 0));

    }//GEN-LAST:event_btn_TasquesMouseExited

    private void N_GrupsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_GrupsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_N_GrupsMouseEntered

    private void N_GrupsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_GrupsMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_N_GrupsMouseExited

    private void ComboNivell1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivell1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivell1ActionPerformed

    //Crear usuaris
    private void jButtonRegistarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarUsuariActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonRegistarUsuariActionPerformed

    private void jButtonRegistarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistarUsuariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarUsuariMouseClicked

    private void btnTancarSessioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTancarSessioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTancarSessioMouseClicked

    private void btnTancarSessioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTancarSessioMouseEntered
        // TODO add your handling code here:
        changecolor(TancarSessio, new Color(255, 204, 102));
        changecolor(N_TancarSessio, new Color(255, 204, 102));

    }//GEN-LAST:event_btnTancarSessioMouseEntered

    private void btnTancarSessioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTancarSessioMouseExited
        // TODO add your handling code here:

        changecolor(TancarSessio, new Color(255, 153, 0));
        changecolor(N_TancarSessio, new Color(255, 153, 0));
    }//GEN-LAST:event_btnTancarSessioMouseExited

    private void btn_TancarSessioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TancarSessioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TancarSessioMouseClicked

    private void btn_TancarSessioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TancarSessioMouseEntered
        // TODO add your handling code here:

        changecolor(TancarSessio, new Color(255, 204, 102));
        changecolor(N_TancarSessio, new Color(255, 204, 102));
    }//GEN-LAST:event_btn_TancarSessioMouseEntered

    private void btn_TancarSessioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TancarSessioMouseExited
        // TODO add your handling code here:
        changecolor(TancarSessio, new Color(255, 153, 0));
        changecolor(N_TancarSessio, new Color(255, 153, 0));
    }//GEN-LAST:event_btn_TancarSessioMouseExited

    private void jCheckBoxNotificacio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacio1ActionPerformed

    private void jCheckBoxNotificacio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacio2ActionPerformed

    private void ComboMesDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesDiaActionPerformed

    private void ComboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesActionPerformed

    private void ComboMesDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesDia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesDia1ActionPerformed

    private void ComboMes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMes1ActionPerformed

    private void jButtonEliminarTelefonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarTelefonsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTelefonsMouseClicked

    private void jButtonEliminarTelefonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTelefonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTelefonsActionPerformed

    private void jButtonEstadisitquesOrdiandor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEstadisitquesOrdiandor1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEstadisitquesOrdiandor1MouseClicked

    private void jButtonEstadisitquesOrdiandor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEstadisitquesOrdiandor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEstadisitquesOrdiandor1ActionPerformed

    private void TasquesGestionadesElements1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TasquesGestionadesElements1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TasquesGestionadesElements1ActionPerformed

    private void txtBuscadorOrdinadorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorOrdinadorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorOrdinadorsActionPerformed

    private void txtBuscadorOrdinadorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorOrdinadorsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorOrdinadorsKeyReleased

    private void jButtonNouOrdinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNouOrdinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNouOrdinadorActionPerformed

    private void jButtonEliminarOrdinadorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarOrdinadorsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarOrdinadorsMouseClicked

    private void jButtonEliminarOrdinadorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarOrdinadorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarOrdinadorsActionPerformed

    private void jButtonRegistarTelefonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistarTelefonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarTelefonMouseClicked

    private void jButtonRegistarTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarTelefonActionPerformed

    private void jButtonEditarTelefonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarTelefonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarTelefonMouseClicked

    private void jButtonEditarTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTelefonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarTelefonActionPerformed

    private void jButtonChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChatMouseClicked

    private void jButtonChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChatActionPerformed

    public void load_caht(int id) {

        idTasca = id;

        try {

            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT msg FROM Tasques WHERE id_tasca='" + idTasca + "'");
            ResultSet rs = pst.executeQuery();
            String missatge = "";
            while (rs.next()) {
                DefaultListModel cm = new DefaultListModel();
                java.sql.Blob ablob = rs.getBlob(1);
                missatge = new String(ablob.getBytes(1l, (int) ablob.length()));
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String msg = Login.usuari + " : " + jTextField1.getText();
        String aux = "";
        DefaultListModel mod = new DefaultListModel();
        mod = (DefaultListModel) jList1.getModel();
        for (int i = 0; i < mod.size(); i++) {
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
            Connection cn = Conexio.conectar();
            PreparedStatement s = cn.prepareStatement("Update Tasques SET msg=? WHERE id_tasca='" + idTasca + "'");
            Blob blob = (Blob) cn.createBlob();
            blob.setBytes(1, aux.getBytes());
            s.setBlob(1, blob);
            jTextField1.setText("");
            s.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);

        }

        jList1.updateUI();
        load_caht(idTasca);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void inicialitzarNotificacio(Date date) throws MessagingException {

        Notificacio n = new Notificacio();
        ConsultesNotificacio cn = new ConsultesNotificacio();
        ControladorNotificacio con = new ControladorNotificacio(n, cn, this);
        con.Notificacio(date);

    }

    public void recordatori(Date date) throws InterruptedException, ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        String d = formatter.format(date);

        try {
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_tasca, notificacio, titol, data from Tasques where data = '" + d + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                if (rs.getInt("notificacio") == 0) {

                    id_tasca = rs.getInt("id_tasca");
                    String titol = rs.getString("titol");
                    String data = rs.getString("data");
                    recordatori(titol, date);

                }

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            //JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

    }

    public void recordatori(String titol, Date data) throws ParseException {

        String[] botones = {"Veure Tasca", "Posposar 5min"};
        int ventana = JOptionPane.showOptionDialog(null, titol, "Notificacio Tasca", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                botones, botones[0]);
        if (ventana == 0) {

            System.out.println("Veure Tasca");
            try {
                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("update Tasques set notificacio=? where id_tasca = '" + id_tasca + "'");
                pst.setInt(1, 1);
                pst.executeUpdate();
                cn.close();

            } catch (SQLException e) {

                System.err.println("Error al modificar la notificacio" + e);

            }
            jTable_Tasques.repaint();
            jTable_Tasques.updateUI();
            //DashTasques.setVisible(false);                        
            // informacioTasca(titol);
            DashInfoTasca.setVisible(true);
            DashInfoUsuari.setVisible(false);
            //DashInfoTasca.setVisible(false);
            DashNovaTasca.setVisible(false);
            DashConfiguracio.setVisible(false);
            DashTasques.setVisible(false);
            DashNouUsuari.setVisible(false);
            DashNouOrdinador.setVisible(false);
            DashUsuaris.setVisible(false);
            DashOrdinadors.setVisible(false);
            DashInfoOrdinador.setVisible(false);
        } else if (ventana == 1) {

            long timeInSecs = data.getTime();
            Date afterAdding10Mins = new Date((1 * 60 * 1000) + timeInSecs);
            //String d = data.substring(14,16);
            System.out.println("Posposar 5min");
            /*DateFormat formatter = new SimpleDateFormat("HH:mm");
                    java.sql.Time timeValue = new java.sql.Time(formatter.parse(data).getTime());
                    timeValue.setSeconds(5 + timeValue.getSeconds());
                    
                    
                     DateFormat formattter = new SimpleDateFormat("HH:mm");            
                     String hora = formattter.format(timeValue);*/

            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            String d = formatter.format(afterAdding10Mins);

            System.out.println("DATAAAAAAAAA:" + d);

            //DATA FORMAT!!!!!!!!!
            /* String string = "January 2, 2010";
                    DateTimeFormatter formatter = DateTimeFoDateTrmatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
                    LocalDate date = LocalDate.parse(string, formatter);
                    System.out.println(date); */
            try {
                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("update Tasques set data=? where id_tasca = '" + id_tasca + "'");

                pst.setString(1, d);
                pst.executeUpdate();
                cn.close();

            } catch (SQLException e) {

                System.err.println("Error al modificar la notificacio" + e);

            }

        }

    }

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
                if ("Windows Classic".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JPanel ButtonMin;
    public javax.swing.JLabel Close;
    public javax.swing.JComboBox<String> ComboEstat;
    public javax.swing.JComboBox<String> ComboEstat1;
    public javax.swing.JComboBox<String> ComboEstatElem;
    public javax.swing.JComboBox<String> ComboEstatElem1;
    public javax.swing.JComboBox<String> ComboEstatTasc1;
    public javax.swing.JComboBox<String> ComboEstatTasc2;
    public javax.swing.JComboBox<String> ComboEstatTasc3;
    public javax.swing.JComboBox<String> ComboEstatTel;
    public javax.swing.JComboBox<String> ComboEstatTel1;
    public javax.swing.JComboBox<String> ComboGrupAfectat;
    public javax.swing.JComboBox<String> ComboGrupAfectat1;
    public javax.swing.JComboBox<String> ComboGrupAfectat2;
    public javax.swing.JComboBox<String> ComboGrupAfectat3;
    public javax.swing.JComboBox<String> ComboMes;
    public javax.swing.JComboBox<String> ComboMes1;
    public javax.swing.JComboBox<String> ComboMesDia;
    public javax.swing.JComboBox<String> ComboMesDia1;
    public javax.swing.JComboBox<String> ComboMesNumero;
    public javax.swing.JComboBox<String> ComboMesNumero1;
    public javax.swing.JComboBox<String> ComboNivell;
    public javax.swing.JComboBox<String> ComboNivell1;
    public javax.swing.JComboBox<String> ComboPrioritatTasc1;
    public javax.swing.JComboBox<String> ComboPrioritatTasc2;
    public javax.swing.JComboBox<String> ComboPrioritatTasc3;
    public javax.swing.JComboBox<String> ComboPrioritatTasc4;
    public javax.swing.JComboBox<String> ComboTipus;
    public javax.swing.JComboBox<String> ComboTipus1;
    public javax.swing.JComboBox<String> ComboTipusTel;
    public javax.swing.JComboBox<String> ComboTipusTel1;
    public javax.swing.JComboBox<String> ComboUsuariAssignat;
    public javax.swing.JComboBox<String> ComboUsuariAssignat1;
    public javax.swing.JComboBox<String> ComboUsuariAssignat2;
    public javax.swing.JComboBox<String> ComboUsuariAssignat3;
    public javax.swing.JComboBox<String> ComboUsuariAssignatOrdinador;
    public javax.swing.JComboBox<String> ComboUsuariAssignatOrdinador1;
    public javax.swing.JComboBox<String> ComboUsuariAssignatTel;
    public javax.swing.JComboBox<String> ComboUsuariAssignatTel1;
    private javax.swing.JPanel Configuracio;
    private javax.swing.JPanel Contador1;
    private javax.swing.JPanel Contador3;
    private javax.swing.JPanel Contador4;
    private javax.swing.JPanel Contador5;
    private javax.swing.JPanel Contador6;
    public javax.swing.JPanel DashBoardView;
    public javax.swing.JPanel DashChat;
    public javax.swing.JPanel DashConfiguracio;
    public javax.swing.JPanel DashGrups;
    public javax.swing.JPanel DashInfoGrup;
    public javax.swing.JPanel DashInfoOrdinador;
    public javax.swing.JPanel DashInfoTasca;
    public javax.swing.JPanel DashInfoTascaRepeticio;
    public javax.swing.JPanel DashInfoTelefon;
    public javax.swing.JPanel DashInfoUsuari;
    public javax.swing.JPanel DashNouGrup;
    public javax.swing.JPanel DashNouOrdinador;
    public javax.swing.JPanel DashNouTelefon;
    public javax.swing.JPanel DashNouUsuari;
    public javax.swing.JPanel DashNovaTasca;
    public javax.swing.JPanel DashNovaTascaRepeticio;
    public javax.swing.JPanel DashOrdinadors;
    public javax.swing.JPanel DashPerfilUsuari;
    public javax.swing.JPanel DashTasques;
    public javax.swing.JPanel DashTelefons;
    public javax.swing.JPanel DashTriaElement;
    public javax.swing.JPanel DashTriaTasca;
    public javax.swing.JPanel DashUsuaris;
    private javax.swing.JPanel Elements;
    private javax.swing.JLabel Enrera;
    private javax.swing.JLabel Enrera1;
    private javax.swing.JLabel Enrera2;
    private javax.swing.JPanel Grups;
    public javax.swing.JPanel Header;
    private javax.swing.JPanel HideMenu;
    public javax.swing.JPanel IconMinMaxClose;
    private javax.swing.JPanel LiniaConfiguracio;
    private javax.swing.JPanel LiniaElements;
    private javax.swing.JPanel LiniaGrups;
    private javax.swing.JPanel LiniaHideMenu;
    private javax.swing.JPanel LiniaTasques;
    private javax.swing.JPanel LiniaUsuaris;
    private javax.swing.JPanel Logo;
    public javax.swing.JLabel Max;
    public javax.swing.JPanel Menu;
    private javax.swing.JLabel MenuDes;
    public javax.swing.JPanel MenuHide;
    public javax.swing.JPanel MenuIcon;
    public javax.swing.JLabel Min;
    private javax.swing.JPanel N_Configuracio;
    private javax.swing.JPanel N_Elements;
    private javax.swing.JPanel N_Grups;
    private javax.swing.JPanel N_TancarSessio;
    private javax.swing.JPanel N_Tasques;
    private javax.swing.JPanel N_Usuari;
    private javax.swing.JPanel N_Usuaris;
    private javax.swing.JPanel TancarSessio;
    private javax.swing.JPanel Tasques;
    public javax.swing.JTextField TasquesAsignadesElements;
    public javax.swing.JTextField TasquesAsignadesElements1;
    public javax.swing.JTextField TasquesAsignadesGrups;
    public javax.swing.JTextField TasquesAsignadesUsuaris;
    public javax.swing.JTextField TasquesGestionadesElements;
    public javax.swing.JTextField TasquesGestionadesElements1;
    public javax.swing.JTextField TasquesGestionadesGrups;
    public javax.swing.JTextField TasquesGestionadesUsuaris;
    public javax.swing.JTextField TasquesTotalsElements;
    public javax.swing.JTextField TasquesTotalsElements1;
    public javax.swing.JTextField TasquesTotalsGrups;
    public javax.swing.JTextField TasquesTotalsUsuaris;
    private javax.swing.JPanel Usuaris;
    public javax.swing.JLabel btnConfiguracio;
    public javax.swing.JLabel btnElements;
    public javax.swing.JLabel btnGrup;
    public javax.swing.JLabel btnTancarSessio;
    public javax.swing.JLabel btnTasques;
    public javax.swing.JLabel btnUsuaris;
    public javax.swing.JLabel btn_Configuracio;
    public javax.swing.JLabel btn_Elements;
    public javax.swing.JLabel btn_Grups;
    public javax.swing.JLabel btn_TancarSessio;
    public javax.swing.JLabel btn_Tasques;
    public javax.swing.JLabel btn_Usuaris;
    private javax.swing.JLabel btnlogo;
    public com.bolivia.label.CLabel cLabelFoto;
    public com.github.lgooddatepicker.components.DatePicker dataIngresOrdinador;
    public com.github.lgooddatepicker.components.DatePicker dataIngresOrdinador1;
    public com.github.lgooddatepicker.components.DatePicker dataIngresTel;
    public com.github.lgooddatepicker.components.DatePicker dataIngresTel1;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePicker;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePickerRepeticio;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePickerRepeticio1;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePickerRepeticioFinal;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePickerRepeticioFinal1;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButtonAceptar;
    public javax.swing.JButton jButtonAfegir;
    public javax.swing.JButton jButtonAfegir1;
    public javax.swing.JButton jButtonAfegirElement;
    public javax.swing.JButton jButtonAfegirElement1;
    public javax.swing.JButton jButtonAfegirUsuari;
    public javax.swing.JButton jButtonAfegirUsuari1;
    public javax.swing.JButton jButtonAfegirUsuari2;
    public javax.swing.JButton jButtonAfegirUsuari3;
    public javax.swing.JButton jButtonCancelar;
    public javax.swing.JButton jButtonCanviarContrasenya;
    public javax.swing.JButton jButtonCanviarFoto;
    public javax.swing.JButton jButtonChat;
    public javax.swing.JLabel jButtonDispositiusXarxa;
    public javax.swing.JButton jButtonEditarOrdinador;
    public javax.swing.JButton jButtonEditarTasca;
    public javax.swing.JButton jButtonEditarTascaRecurrent;
    public javax.swing.JButton jButtonEditarTelefon;
    public javax.swing.JButton jButtonEditarUsuari;
    public javax.swing.JButton jButtonEliminarGrup;
    public javax.swing.JButton jButtonEliminarOrdinadors;
    public javax.swing.JButton jButtonEliminarTasca;
    public javax.swing.JButton jButtonEliminarTelefons;
    public javax.swing.JButton jButtonEliminarUsuari;
    public javax.swing.JButton jButtonEstadisitquesOrdiandor1;
    public javax.swing.JButton jButtonExportar;
    public javax.swing.JButton jButtonGuardarFoto;
    public javax.swing.JButton jButtonImportar;
    public javax.swing.JLabel jButtonImpresores;
    public javax.swing.JLabel jButtonNomUsuari;
    public javax.swing.JButton jButtonNouGrup;
    public javax.swing.JButton jButtonNouOrdinador;
    public javax.swing.JButton jButtonNouTelefon;
    public javax.swing.JButton jButtonNouUsuari;
    public javax.swing.JButton jButtonNovaTasca;
    public javax.swing.JLabel jButtonOrdinadors;
    public javax.swing.JButton jButtonRegistarGrup;
    public javax.swing.JButton jButtonRegistarGrup1;
    public javax.swing.JButton jButtonRegistarOrdinador;
    public javax.swing.JButton jButtonRegistarTasca;
    public javax.swing.JButton jButtonRegistarTelefon;
    public javax.swing.JButton jButtonRegistarUsuari;
    public javax.swing.JLabel jButtonServidors;
    public javax.swing.JPanel jButtonTasca;
    public javax.swing.JPanel jButtonTasca1;
    public javax.swing.JPanel jButtonTasca2;
    public javax.swing.JPanel jButtonTasca3;
    public javax.swing.JPanel jButtonTasca4;
    public javax.swing.JPanel jButtonTasca5;
    public javax.swing.JPanel jButtonTasca6;
    public javax.swing.JLabel jButtonTascaNormal;
    public javax.swing.JLabel jButtonTascaNormal12;
    public javax.swing.JLabel jButtonTascaNormal13;
    public javax.swing.JLabel jButtonTascaNormal14;
    public javax.swing.JLabel jButtonTascaNormal15;
    public javax.swing.JLabel jButtonTascaNormal16;
    public javax.swing.JLabel jButtonTascaNormal17;
    public javax.swing.JLabel jButtonTascaNormal18;
    public javax.swing.JLabel jButtonTascaRec;
    public javax.swing.JLabel jButtonTascaRepeticio;
    public javax.swing.JLabel jButtonTelefons;
    private javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBoxDijous;
    public javax.swing.JCheckBox jCheckBoxDijous1;
    public javax.swing.JCheckBox jCheckBoxDilluns;
    public javax.swing.JCheckBox jCheckBoxDilluns1;
    public javax.swing.JCheckBox jCheckBoxDimarts;
    public javax.swing.JCheckBox jCheckBoxDimarts1;
    public javax.swing.JCheckBox jCheckBoxDimecres;
    public javax.swing.JCheckBox jCheckBoxDimecres1;
    public javax.swing.JCheckBox jCheckBoxDissabte;
    public javax.swing.JCheckBox jCheckBoxDissabte1;
    public javax.swing.JCheckBox jCheckBoxDiumenge;
    public javax.swing.JCheckBox jCheckBoxDiumenge1;
    public javax.swing.JCheckBox jCheckBoxDivendres;
    public javax.swing.JCheckBox jCheckBoxDivendres1;
    public javax.swing.JCheckBox jCheckBoxEnviarCorreu;
    public javax.swing.JCheckBox jCheckBoxNotificacio;
    public javax.swing.JCheckBox jCheckBoxNotificacio1;
    public javax.swing.JCheckBox jCheckBoxNotificacio2;
    public javax.swing.JCheckBox jCheckBoxSo;
    public javax.swing.JComboBox<String> jComboBoxDashTasquesUsuari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    public javax.swing.JLabel jLabelAnys;
    public javax.swing.JLabel jLabelAnys1;
    public javax.swing.JLabel jLabelDias;
    public javax.swing.JLabel jLabelDias1;
    public javax.swing.JLabel jLabelMesos;
    public javax.swing.JLabel jLabelMesos1;
    public javax.swing.JLabel jLabelRepetirCada;
    public javax.swing.JLabel jLabelRepetirCada1;
    public javax.swing.JLabel jLabelSetmanes;
    public javax.swing.JLabel jLabelSetmanes1;
    public javax.swing.JLabel jLabelSetmanes2;
    public javax.swing.JLabel jLabelSetmanes3;
    private javax.swing.JList<String> jList1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JRadioButton jRadioButtonAcabar;
    public javax.swing.JRadioButton jRadioButtonAcabar1;
    public javax.swing.JRadioButton jRadioButtonAnual;
    public javax.swing.JRadioButton jRadioButtonAnual1;
    public javax.swing.JRadioButton jRadioButtonCompraOrdinador;
    public javax.swing.JRadioButton jRadioButtonCompraOrdinador1;
    public javax.swing.JRadioButton jRadioButtonCompraTel;
    public javax.swing.JRadioButton jRadioButtonCompraTel1;
    public javax.swing.JRadioButton jRadioButtonDataFinal;
    public javax.swing.JRadioButton jRadioButtonDataFinal1;
    public javax.swing.JRadioButton jRadioButtonDiari;
    public javax.swing.JRadioButton jRadioButtonDiari1;
    public javax.swing.JRadioButton jRadioButtonEl;
    public javax.swing.JRadioButton jRadioButtonEl1;
    public javax.swing.JRadioButton jRadioButtonElements;
    public javax.swing.JRadioButton jRadioButtonMensual;
    public javax.swing.JRadioButton jRadioButtonMensual1;
    public javax.swing.JRadioButton jRadioButtonRentingOrdinador;
    public javax.swing.JRadioButton jRadioButtonRentingOrdinador1;
    public javax.swing.JRadioButton jRadioButtonRentingTel;
    public javax.swing.JRadioButton jRadioButtonRentingTel1;
    public javax.swing.JRadioButton jRadioButtonSetmanal;
    public javax.swing.JRadioButton jRadioButtonSetmanal1;
    public javax.swing.JRadioButton jRadioButtonUsuaris;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JScrollPane jScrollPaneElements;
    public javax.swing.JScrollPane jScrollPaneElements1;
    public javax.swing.JScrollPane jScrollPaneUsuaris;
    public javax.swing.JScrollPane jScrollPane_Grups;
    public javax.swing.JScrollPane jScrollPane_Ordiandors;
    public javax.swing.JScrollPane jScrollPane_Tasques;
    public javax.swing.JScrollPane jScrollPane_Telefons;
    public javax.swing.JScrollPane jScrollPane_Usuaris;
    public javax.swing.JSpinner jSpinner;
    public javax.swing.JSpinner jSpinner1;
    public javax.swing.JSpinner jSpinnerAcabar;
    public javax.swing.JSpinner jSpinnerAcabar1;
    public javax.swing.JTable jTableCrearGrups;
    public javax.swing.JTable jTableCrearGrupsElements;
    public javax.swing.JTable jTableCrearGrupsUsuaris;
    public javax.swing.JTable jTableInfoTasca;
    public javax.swing.JTable jTableInfoTasca1;
    public javax.swing.JTable jTable_Grups;
    public javax.swing.JTable jTable_Ordinadors;
    public javax.swing.JTable jTable_Tasques;
    public javax.swing.JTable jTable_Telefons;
    public javax.swing.JTable jTable_Usuaris;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextFieldTasquesAssignades;
    public javax.swing.JTextField jTextFieldTasquesPendents;
    public javax.swing.JTextField jTextFieldTasquesTotals;
    public javax.swing.JTextArea jTextGrupUsuaris;
    public javax.swing.JTextArea jTextGrupUsuaris1;
    public javax.swing.JTextArea jTextUsuariAssignat;
    public javax.swing.JTextArea jTextUsuariAssignat1;
    public javax.swing.JTextArea jTextUsuariAssignat2;
    public javax.swing.JTextArea jTextUsuariAssignat3;
    public javax.swing.JTextField txtBuscadorOrdinadors;
    public javax.swing.JTextField txtBuscadorTasques;
    public javax.swing.JTextField txtBuscadorTasques1;
    public javax.swing.JTextField txtBuscadorUsuaris;
    public javax.swing.JTextField txtNomImatge;
    public javax.swing.JTextField txt_buscadorTelefons;
    public javax.swing.JTextField txt_cerca;
    public javax.swing.JTextField txt_cerca1;
    public javax.swing.JTextField txt_cerca2;
    public javax.swing.JTextField txt_cerca3;
    public javax.swing.JTextField txt_cognom;
    public javax.swing.JTextField txt_cognom1;
    public javax.swing.JTextField txt_descripcioTasc;
    public javax.swing.JTextField txt_descripcioTasc1;
    public javax.swing.JTextField txt_descripcioTasc2;
    public javax.swing.JTextField txt_descripcioTasc3;
    public javax.swing.JTextField txt_email;
    public com.bolivia.label.CLabel txt_fotoUsuari;
    public javax.swing.JTextField txt_imeiTel;
    public javax.swing.JTextField txt_imeiTel1;
    public javax.swing.JTextField txt_mail1;
    public javax.swing.JTextField txt_marca;
    public javax.swing.JTextField txt_marca1;
    public javax.swing.JTextField txt_marcaTel;
    public javax.swing.JTextField txt_marcaTel1;
    public javax.swing.JTextField txt_model;
    public javax.swing.JTextField txt_model1;
    public javax.swing.JTextField txt_modelTel;
    public javax.swing.JTextField txt_modelTel1;
    public javax.swing.JTextField txt_nom;
    public javax.swing.JTextField txt_nom1;
    public javax.swing.JTextField txt_nomElem;
    public javax.swing.JTextField txt_nomElem1;
    public javax.swing.JTextField txt_nomGrup;
    public javax.swing.JTextField txt_nomGrup1;
    public javax.swing.JTextField txt_nomTel;
    public javax.swing.JTextField txt_nomTel1;
    public javax.swing.JTextField txt_numeroTel;
    public javax.swing.JTextField txt_numeroTel1;
    public javax.swing.JTextField txt_numserie;
    public javax.swing.JTextField txt_numserie1;
    public javax.swing.JTextField txt_observacions;
    public javax.swing.JTextField txt_observacions1;
    public javax.swing.JTextField txt_observacionsTel;
    public javax.swing.JTextField txt_observacionsTel1;
    public javax.swing.JTextField txt_telefon;
    public javax.swing.JTextField txt_telefon1;
    public javax.swing.JTextField txt_titolTasc;
    public javax.swing.JTextField txt_titolTasc1;
    public javax.swing.JTextField txt_titolTasc2;
    public javax.swing.JTextField txt_titolTasc3;
    public javax.swing.JTextField txt_usuari;
    public javax.swing.JTextField txt_usuari1;
    // End of variables declaration//GEN-END:variables

}
