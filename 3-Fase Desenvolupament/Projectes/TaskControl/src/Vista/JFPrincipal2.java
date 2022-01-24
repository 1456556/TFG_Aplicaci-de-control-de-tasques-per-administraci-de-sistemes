/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorMenu;
import MVC.Conexio;
import Model.Login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Victor
 */
public class JFPrincipal2 extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal2
     */
    boolean a = true;

    private int xMouse, yMouse;

    public int id;

    public int idTasca;

    public int id_tasca = 0;

    public static String user_update = "", element_update = "", tasca_update = "";

    public boolean jf = false;

    public JFPrincipal2() {
        initComponents();

        jTable_Tasques.getTableHeader().setOpaque(false);
        jTable_Tasques.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Tasques.getTableHeader().setForeground(Color.WHITE);
        jTable_Tasques.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Tasques.setRowHeight(25);
        jTable_Tasques.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Ordinadors.getTableHeader().setOpaque(false);
        jTable_Ordinadors.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Ordinadors.getTableHeader().setForeground(Color.WHITE);
        jTable_Ordinadors.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Ordinadors.setRowHeight(25);
        jTable_Ordinadors.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Telefons.getTableHeader().setOpaque(false);
        jTable_Telefons.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Telefons.getTableHeader().setForeground(Color.WHITE);
        jTable_Telefons.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Telefons.setRowHeight(25);
        jTable_Telefons.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Impresores.getTableHeader().setOpaque(false);
        jTable_Impresores.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Impresores.getTableHeader().setForeground(Color.WHITE);
        jTable_Impresores.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Impresores.setRowHeight(25);
        jTable_Impresores.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Servidors.getTableHeader().setOpaque(false);
        jTable_Servidors.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Servidors.getTableHeader().setForeground(Color.WHITE);
        jTable_Servidors.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Servidors.setRowHeight(25);
        jTable_Servidors.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Usuaris.getTableHeader().setOpaque(false);
        jTable_Usuaris.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Usuaris.getTableHeader().setForeground(Color.WHITE);
        jTable_Usuaris.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Usuaris.setRowHeight(25);
        jTable_Usuaris.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTable_Grups.getTableHeader().setOpaque(false);
        jTable_Grups.getTableHeader().setBackground(new Color(4, 79, 210));
        jTable_Grups.getTableHeader().setForeground(Color.WHITE);
        jTable_Grups.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTable_Grups.setRowHeight(25);
        jTable_Grups.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTableCrearGrupsElements.getTableHeader().setOpaque(false);
        jTableCrearGrupsElements.getTableHeader().setBackground(new Color(4, 79, 210));
        jTableCrearGrupsElements.getTableHeader().setForeground(Color.WHITE);
        jTableCrearGrupsElements.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTableCrearGrupsElements.setRowHeight(25);
        jTableCrearGrupsElements.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTableCrearGrupsUsuaris.getTableHeader().setOpaque(false);
        jTableCrearGrupsUsuaris.getTableHeader().setBackground(new Color(4, 79, 210));
        jTableCrearGrupsUsuaris.getTableHeader().setForeground(Color.WHITE);
        jTableCrearGrupsUsuaris.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTableCrearGrupsUsuaris.setRowHeight(25);
        jTableCrearGrupsUsuaris.getTableHeader().setPreferredSize(new Dimension(100, 32));

        jTableCrearGrups.getTableHeader().setOpaque(false);
        jTableCrearGrups.getTableHeader().setBackground(new Color(4, 79, 210));
        jTableCrearGrups.getTableHeader().setForeground(Color.WHITE);
        jTableCrearGrups.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
        jTableCrearGrups.setRowHeight(25);
        jTableCrearGrups.getTableHeader().setPreferredSize(new Dimension(100, 32));

        Image icono = Toolkit.getDefaultToolkit().getImage("src/images/ezgif.com-gif-maker.png");

        // Define el icono
        this.setIconImage(icono);

        execute();
    }

    private void execute() {

        ControladorMenu menu = new ControladorMenu(this);
        ImageIcon iconTasques = new ImageIcon("src/images/clock-6-32.png");
        ImageIcon iconElements = new ImageIcon("src/images/icons8-workstation-30.png");
        ImageIcon iconUsuaris = new ImageIcon("src/images/icons8-user-account-30.png");
        ImageIcon iconGrups = new ImageIcon("src/images/icons8-dog-tag-30.png");
        ImageIcon iconTancarSessio = new ImageIcon("src/images/icons8-logout-30.png");
        ImageIcon iconOrdinador = new ImageIcon("src/images/icons8-down-right-30.png");
        ImageIcon iconTelefons = new ImageIcon("src/images/icons8-down-right-30.png");
        ImageIcon iconImpresores = new ImageIcon("src/images/icons8-down-right-30.png");
        ImageIcon iconServidors = new ImageIcon("src/images/icons8-down-right-30.png");
        ImageIcon iconEstadistiques = new ImageIcon("src/images/icons8-line-graphics-30.png");
        ImageIcon iconConfiguracio = new ImageIcon("src/images/settings_32px.png");
        ImageIcon iconPerfil = new ImageIcon("src/images/icons8-male-user-30.png");

        //  create submenu staff
        MenuItem Ordinadors = new MenuItem(iconOrdinador, "  Ordinadors", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(21);

            }
        });
        MenuItem Telefons = new MenuItem(iconTelefons, "  Teléfons", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(22);

            }
        });
        MenuItem Impresores = new MenuItem(iconImpresores, "  Impresores", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(23);

            }
        });
        MenuItem Servidors = new MenuItem(iconServidors, "  Servidors", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(24);

            }
        });

        MenuItem menuTasques = new MenuItem(iconTasques, "Tasques", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(1);

            }
        });

        MenuItem menuElements = new MenuItem(iconElements, "Elements", null, Ordinadors, Telefons, Impresores, Servidors);
        MenuItem menuUsuaris = new MenuItem(iconUsuaris, "Usuaris", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(3);

            }
        });
        MenuItem menuGrups = new MenuItem(iconGrups, "Grups", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(4);

            }
        });
        ;

        MenuItem menuGrafiques = new MenuItem(iconEstadistiques, "Gràfiques", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(5);

            }
        });

        MenuItem menuPerfil = new MenuItem(iconPerfil, "Perfil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(8);

            }
        });
        MenuItem menuConfiguracio = new MenuItem(iconConfiguracio, "Configuració", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(6);

            }
        });
        MenuItem menuTancaSessio = new MenuItem(iconTancarSessio, "Tancar Sessió", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                menu.CanviarMenu(7);

            }
        });

        addMenu(menuTasques, menuElements, menuUsuaris, menuGrups, menuGrafiques, menuConfiguracio, menuPerfil, menuTancaSessio);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jButtonNomUsuari = new javax.swing.JLabel();
        txt_fotoUsuari = new com.bolivia.label.CLabel();
        jScrollPane = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        IconMinMaxClose = new javax.swing.JPanel();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        lbTitle2 = new javax.swing.JLabel();
        jTextFieldTasquesPendents = new javax.swing.JLabel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        lbTitle4 = new javax.swing.JLabel();
        jTextFieldTasquesTotals = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        lbTitle5 = new javax.swing.JLabel();
        jTextFieldTasquesAssignades = new javax.swing.JLabel();
        DashBoardView = new javax.swing.JPanel();
        DashConfiguracio = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jButtonExportar = new javax.swing.JButton();
        jButtonImportar = new javax.swing.JButton();
        jCheckBoxSo = new javax.swing.JCheckBox();
        jCheckBoxEnviarCorreu = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jCheckBox2FA = new javax.swing.JCheckBox();
        jLabel102 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        DashGrups = new javax.swing.JPanel();
        jButtonEliminarGrup = new javax.swing.JButton();
        Grups = new javax.swing.JLabel();
        jButtonNouGrup = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtBuscadorGrups = new javax.swing.JTextField();
        jScrollPane_Grups = new javax.swing.JScrollPane();
        jTable_Grups = new javax.swing.JTable();
        DashUsuaris = new javax.swing.JPanel();
        jButtonEliminarUsuari = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jButtonNouUsuari = new javax.swing.JButton();
        jLabel128 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        txtBuscadorUsuari = new javax.swing.JTextField();
        jScrollPane_Usuaris = new javax.swing.JScrollPane();
        jTable_Usuaris = new javax.swing.JTable();
        DashOrdinadors = new javax.swing.JPanel();
        jScrollPane_Ordiandors = new javax.swing.JScrollPane();
        jTable_Ordinadors = new javax.swing.JTable();
        jButtonEliminarOrdinadors = new javax.swing.JButton();
        jButtonNouOrdinador = new javax.swing.JButton();
        txtBuscadorOrdinadors = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        DashGrafiques = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jComboBoxTipus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jToggleButtonActualitzarGrafic = new javax.swing.JToggleButton();
        jRadioButton2D = new javax.swing.JRadioButton();
        jRadioButton3D = new javax.swing.JRadioButton();
        jPanelTipus = new javax.swing.JPanel();
        jComboBoxGrafic = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrafica = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        DashServidors = new javax.swing.JPanel();
        jScrollPane_Servidors = new javax.swing.JScrollPane();
        jTable_Servidors = new javax.swing.JTable();
        jButtonNouServidor = new javax.swing.JButton();
        jButtonEliminarServidors = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        txtBuscadorServidors = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        DashImpresores = new javax.swing.JPanel();
        jScrollPane_Impresores = new javax.swing.JScrollPane();
        jTable_Impresores = new javax.swing.JTable();
        jButtonNouImpresora = new javax.swing.JButton();
        jButtonEliminarImpresores = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        txtBuscadorImpresores = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        DashTasques = new javax.swing.JPanel();
        jScrollPane_Tasques = new javax.swing.JScrollPane();
        jTable_Tasques = new javax.swing.JTable();
        jButtonEliminarTasca = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonNovaTasca = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxDashTasquesUsuari = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtBuscadorTasques = new javax.swing.JTextField();
        DashTelefons = new javax.swing.JPanel();
        jScrollPane_Telefons = new javax.swing.JScrollPane();
        jTable_Telefons = new javax.swing.JTable();
        jButtonNouTelefon = new javax.swing.JButton();
        jButtonEliminarTelefons = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtBuscadorTelefons = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        DashNouGrup = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
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
        jLabel88 = new javax.swing.JLabel();
        Grups3 = new javax.swing.JLabel();
        DashInfoGrup = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButtonRegistarGrup1 = new javax.swing.JButton();
        jLabel89 = new javax.swing.JLabel();
        txt_nomGrup1 = new javax.swing.JTextField();
        txt_cerca2 = new javax.swing.JTextField();
        jScrollPaneElements1 = new javax.swing.JScrollPane();
        jTableCrearGrups = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextGrupUsuaris1 = new javax.swing.JTextArea();
        jButtonAfegir1 = new javax.swing.JButton();
        jButtonAfegirElement1 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        Grups4 = new javax.swing.JLabel();
        DashNovaTasca = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
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
        jLabel47 = new javax.swing.JLabel();
        DashTriaTasca = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jButtonTasca = new javax.swing.JPanel();
        jButtonTascaNormal12 = new javax.swing.JLabel();
        jButtonTascaNormal = new javax.swing.JLabel();
        jButtonTasca1 = new javax.swing.JPanel();
        jButtonTascaRec = new javax.swing.JLabel();
        jButtonTascaRepeticio = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        DashChat = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        DashInfoUsuari = new javax.swing.JPanel();
        txt_telefon = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_cognom = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_usuari = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        ComboEstat = new javax.swing.JComboBox<>();
        ComboNivell = new javax.swing.JComboBox<>();
        jButtonEditarUsuari = new javax.swing.JButton();
        Enrera = new javax.swing.JLabel();
        Grups5 = new javax.swing.JLabel();
        DashNouUsuari = new javax.swing.JPanel();
        txt_usuari1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonRegistarUsuari = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        ComboNivell1 = new javax.swing.JComboBox<>();
        ComboEstat1 = new javax.swing.JComboBox<>();
        txt_nom1 = new javax.swing.JTextField();
        txt_cognom1 = new javax.swing.JTextField();
        txt_telefon1 = new javax.swing.JTextField();
        txt_mail1 = new javax.swing.JTextField();
        Grups6 = new javax.swing.JLabel();
        DashNouOrdinador = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_model = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        ComboTipus = new javax.swing.JComboBox<>();
        ComboEstatElem = new javax.swing.JComboBox<>();
        txt_nomElem = new javax.swing.JTextField();
        txt_numserie = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        txt_observacions = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jRadioButtonRentingOrdinador = new javax.swing.JRadioButton();
        jRadioButtonCompraOrdinador = new javax.swing.JRadioButton();
        dataIngresOrdinador = new com.github.lgooddatepicker.components.DatePicker();
        jLabel97 = new javax.swing.JLabel();
        ComboUsuariAssignatOrdinador = new javax.swing.JComboBox<>();
        jButtonRegistarOrdinador = new javax.swing.JButton();
        Grups8 = new javax.swing.JLabel();
        DashInfoOrdinador = new javax.swing.JPanel();
        jButtonEditarOrdinador = new javax.swing.JButton();
        Enrera1 = new javax.swing.JLabel();
        txt_nomElem1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txt_marca1 = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txt_model1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txt_numserie1 = new javax.swing.JTextField();
        ComboEstatElem1 = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        ComboTipus1 = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        ComboUsuariAssignatOrdinador1 = new javax.swing.JComboBox<>();
        jLabel100 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jRadioButtonRentingOrdinador1 = new javax.swing.JRadioButton();
        jRadioButtonCompraOrdinador1 = new javax.swing.JRadioButton();
        txt_observacions1 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        dataIngresOrdinador1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel53 = new javax.swing.JLabel();
        Grups9 = new javax.swing.JLabel();
        DashInfoTasca = new javax.swing.JPanel();
        txt_titolTasc2 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        ComboEstatTasc2 = new javax.swing.JComboBox<>();
        jButtonEditarTasca = new javax.swing.JButton();
        txt_descripcioTasc2 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        ComboPrioritatTasc2 = new javax.swing.JComboBox<>();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        ComboUsuariAssignat2 = new javax.swing.JComboBox<>();
        ComboGrupAfectat1 = new javax.swing.JComboBox<>();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInfoTasca = new javax.swing.JTable();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextUsuariAssignat1 = new javax.swing.JTextArea();
        jButtonAfegirUsuari1 = new javax.swing.JButton();
        jButtonChat = new javax.swing.JButton();
        Grups2 = new javax.swing.JLabel();
        DashInfoTascaRepeticio = new javax.swing.JPanel();
        jLabelSetmanes1 = new javax.swing.JLabel();
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
        jCheckBoxNotificacio22 = new javax.swing.JCheckBox();
        txt_descripcioTasc3 = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        ComboMesNumero1 = new javax.swing.JComboBox<>();
        jRadioButtonEl1 = new javax.swing.JRadioButton();
        ComboMesDia1 = new javax.swing.JComboBox<>();
        ComboMes1 = new javax.swing.JComboBox<>();
        ComboGrupAfectat3 = new javax.swing.JComboBox<>();
        jLabel87 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableInfoTasca1 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextUsuariAssignat3 = new javax.swing.JTextArea();
        jButtonAfegirUsuari3 = new javax.swing.JButton();
        Grups1 = new javax.swing.JLabel();
        jButtonChat1 = new javax.swing.JButton();
        DashPerfilUsuari = new javax.swing.JPanel();
        jButtonCanviarContrasenya = new javax.swing.JButton();
        jButtonGuardarFoto = new javax.swing.JButton();
        jButtonCanviarFoto = new javax.swing.JButton();
        txtNomImatge = new javax.swing.JTextField();
        Grups7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cLabelFoto = new com.bolivia.label.CLabel();
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
        jRadioButtonAcabar = new javax.swing.JRadioButton();
        jRadioButtonMensual = new javax.swing.JRadioButton();
        jRadioButtonSetmanal = new javax.swing.JRadioButton();
        jRadioButtonDiari = new javax.swing.JRadioButton();
        jButtonAceptar = new javax.swing.JButton();
        jRadioButtonAnual = new javax.swing.JRadioButton();
        dateTimePickerRepeticio = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabelMesos = new javax.swing.JLabel();
        jLabelAnys = new javax.swing.JLabel();
        jRadioButtonDataFinal = new javax.swing.JRadioButton();
        jSpinnerAcabar = new javax.swing.JSpinner();
        jLabelvegades = new javax.swing.JLabel();
        txt_titolTasc1 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        ComboPrioritatTasc3 = new javax.swing.JComboBox<>();
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
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextUsuariAssignat2 = new javax.swing.JTextArea();
        jButtonAfegirUsuari2 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        DashInfoServidor = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        txt_modelSer1 = new javax.swing.JTextField();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel173 = new javax.swing.JLabel();
        ComboTipusSer1 = new javax.swing.JComboBox<>();
        ComboEstatSer1 = new javax.swing.JComboBox<>();
        txt_nomSer1 = new javax.swing.JTextField();
        txt_NumeroSerieSer1 = new javax.swing.JTextField();
        txt_marcaSer1 = new javax.swing.JTextField();
        txt_observacionsSer1 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        jLabel175 = new javax.swing.JLabel();
        jRadioButtonRentingSer1 = new javax.swing.JRadioButton();
        jRadioButtonCompraSer1 = new javax.swing.JRadioButton();
        dataIngresSer1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel176 = new javax.swing.JLabel();
        jLabel177 = new javax.swing.JLabel();
        txt_numeroSer1 = new javax.swing.JTextField();
        txt_ubicacioSer1 = new javax.swing.JTextField();
        txt_SistemaOperatiu1 = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        Grups15 = new javax.swing.JLabel();
        jButtonGuardarSer1 = new javax.swing.JButton();
        DashNouServidor = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        txt_modelSer = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        ComboTipusSer = new javax.swing.JComboBox<>();
        ComboEstatSer = new javax.swing.JComboBox<>();
        txt_nomSer = new javax.swing.JTextField();
        txt_NumeroSerieSer = new javax.swing.JTextField();
        txt_marcaSer = new javax.swing.JTextField();
        txt_observacionsSer = new javax.swing.JTextField();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jRadioButtonRentingSer = new javax.swing.JRadioButton();
        jRadioButtonCompraSer = new javax.swing.JRadioButton();
        dataIngresSer = new com.github.lgooddatepicker.components.DatePicker();
        jLabel164 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        txt_numeroSer = new javax.swing.JTextField();
        txt_ubicacioSer = new javax.swing.JTextField();
        txt_SistemaOperatiu = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        Grups14 = new javax.swing.JLabel();
        jButtonGuardarSer = new javax.swing.JButton();
        DashNouImpresora = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        txt_modelImp = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        ComboTipusImp = new javax.swing.JComboBox<>();
        ComboEstatImp = new javax.swing.JComboBox<>();
        txt_nomImp = new javax.swing.JTextField();
        txt_NumeroSerieImp = new javax.swing.JTextField();
        txt_marcaImp = new javax.swing.JTextField();
        txt_observacionsImp = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jRadioButtonRentingImp = new javax.swing.JRadioButton();
        jRadioButtonCompraImp = new javax.swing.JRadioButton();
        dataIngresImp = new com.github.lgooddatepicker.components.DatePicker();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        txt_numeroImp = new javax.swing.JTextField();
        txt_departamentImp = new javax.swing.JTextField();
        Grups12 = new javax.swing.JLabel();
        jButtonActualitzarImp = new javax.swing.JButton();
        DashNouTelefon = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        txt_modelTel = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        ComboTipusTel = new javax.swing.JComboBox<>();
        ComboEstatTel = new javax.swing.JComboBox<>();
        txt_nomTel = new javax.swing.JTextField();
        txt_imeiTel = new javax.swing.JTextField();
        txt_marcaTel = new javax.swing.JTextField();
        txt_observacionsTel = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jRadioButtonRentingTel = new javax.swing.JRadioButton();
        jRadioButtonCompraTel = new javax.swing.JRadioButton();
        dataIngresTel = new com.github.lgooddatepicker.components.DatePicker();
        jLabel115 = new javax.swing.JLabel();
        ComboUsuariAssignatTel = new javax.swing.JComboBox<>();
        jLabel125 = new javax.swing.JLabel();
        txt_numeroTel = new javax.swing.JTextField();
        Grups10 = new javax.swing.JLabel();
        jButtonRegistarTelefon = new javax.swing.JButton();
        DashInfoImpresores = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        txt_modelImp1 = new javax.swing.JTextField();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        ComboTipusImp1 = new javax.swing.JComboBox<>();
        ComboEstatImp1 = new javax.swing.JComboBox<>();
        txt_nomImp1 = new javax.swing.JTextField();
        txt_NumeroSerieImp1 = new javax.swing.JTextField();
        txt_marcaImp1 = new javax.swing.JTextField();
        txt_observacionsImp1 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jRadioButtonRentingImp1 = new javax.swing.JRadioButton();
        jRadioButtonCompraImp1 = new javax.swing.JRadioButton();
        dataIngresImp1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        txt_numeroImp1 = new javax.swing.JTextField();
        txt_departamentImp1 = new javax.swing.JTextField();
        Grups13 = new javax.swing.JLabel();
        jButtonEditarImp = new javax.swing.JButton();
        DashInfoTelefon = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txt_modelTel1 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        ComboTipusTel1 = new javax.swing.JComboBox<>();
        ComboEstatTel1 = new javax.swing.JComboBox<>();
        txt_nomTel1 = new javax.swing.JTextField();
        txt_imeiTel1 = new javax.swing.JTextField();
        txt_marcaTel1 = new javax.swing.JTextField();
        txt_observacionsTel1 = new javax.swing.JTextField();
        jLabel124 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jRadioButtonRentingTel1 = new javax.swing.JRadioButton();
        jRadioButtonCompraTel1 = new javax.swing.JRadioButton();
        dataIngresTel1 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel130 = new javax.swing.JLabel();
        ComboUsuariAssignatTel1 = new javax.swing.JComboBox<>();
        txt_numeroTel1 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        Grups11 = new javax.swing.JLabel();
        jButtonEditarTelefon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setFocusable(false);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new java.awt.BorderLayout());

        Menu.setBackground(new java.awt.Color(0, 51, 204));
        Menu.setForeground(new java.awt.Color(0, 51, 204));
        Menu.setPreferredSize(new java.awt.Dimension(270, 450));

        panelMenu.setBackground(new java.awt.Color(0, 51, 204));
        panelMenu.setForeground(new java.awt.Color(0, 51, 204));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jButtonNomUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonNomUsuari.setText("Usuari");
        jButtonNomUsuari.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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

        txt_fotoUsuari.setText("");
        txt_fotoUsuari.setBackground(new java.awt.Color(255, 255, 255));
        txt_fotoUsuari.setForeground(new java.awt.Color(60, 63, 65));
        txt_fotoUsuari.setLineColor(new java.awt.Color(255, 255, 255));

        jScrollPane.setBackground(new java.awt.Color(0, 51, 204));
        jScrollPane.setBorder(null);
        jScrollPane.setForeground(new java.awt.Color(0, 51, 204));

        menus.setBackground(new java.awt.Color(0, 51, 204));
        menus.setForeground(new java.awt.Color(0, 51, 204));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(txt_fotoUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txt_fotoUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(691, Short.MAX_VALUE))
            .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                    .addContainerGap(214, Short.MAX_VALUE)
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)))
        );

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1177, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1415, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Header.setBackground(new java.awt.Color(0, 51, 204));
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

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-gif-maker2.png"))); // NOI18N
        jLabel6.setText("ControlTasques");
        jLabel6.setBackground(new java.awt.Color(0, 51, 204));
        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setPreferredSize(new java.awt.Dimension(248, 55));
        jPanel1.add(jLabel6, java.awt.BorderLayout.CENTER);

        Header.add(jPanel1, java.awt.BorderLayout.LINE_START);

        IconMinMaxClose.setBackground(new java.awt.Color(255, 255, 255));
        IconMinMaxClose.setForeground(new java.awt.Color(255, 255, 255));
        IconMinMaxClose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        IconMinMaxClose.add(ButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 50, 50));

        ButtonMax.setBackground(new java.awt.Color(0, 51, 204));
        ButtonMax.setLayout(new java.awt.BorderLayout());

        Max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/expand.png"))); // NOI18N
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

        ButtonMin.setBackground(new java.awt.Color(0, 51, 204));
        ButtonMin.setLayout(new java.awt.BorderLayout());

        Min.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Min.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimize.png"))); // NOI18N
        Min.setBackground(new java.awt.Color(0, 51, 204));
        Min.setForeground(new java.awt.Color(0, 51, 204));
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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        kGradientPanel1.setBackground(new java.awt.Color(194, 85, 1));
        kGradientPanel1.setkEndColor(new java.awt.Color(208, 255, 90));
        kGradientPanel1.setkStartColor(new java.awt.Color(60, 195, 0));

        lbTitle2.setText("Tasques Pendents");
        lbTitle2.setFont(new java.awt.Font("sansserif", 1, 19)); // NOI18N
        lbTitle2.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldTasquesPendents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldTasquesPendents.setText("3");
        jTextFieldTasquesPendents.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        jTextFieldTasquesPendents.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTasquesPendents.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lbTitle2)
                .addGap(14, 14, 14))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jTextFieldTasquesPendents)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(lbTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTasquesPendents)
                .addGap(12, 12, 12))
        );

        kGradientPanel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        lbTitle4.setText("Tasques Totals");
        lbTitle4.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        lbTitle4.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldTasquesTotals.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldTasquesTotals.setText("1");
        jTextFieldTasquesTotals.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        jTextFieldTasquesTotals.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTasquesTotals.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lbTitle4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jTextFieldTasquesTotals)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lbTitle4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldTasquesTotals)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        kGradientPanel3.setBackground(new java.awt.Color(194, 85, 1));
        kGradientPanel3.setkEndColor(new java.awt.Color(194, 85, 1));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 212, 99));

        lbTitle5.setText("Tasques Assignades");
        lbTitle5.setFont(new java.awt.Font("sansserif", 1, 19)); // NOI18N
        lbTitle5.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldTasquesAssignades.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTextFieldTasquesAssignades.setText("2");
        jTextFieldTasquesAssignades.setFont(new java.awt.Font("sansserif", 1, 25)); // NOI18N
        jTextFieldTasquesAssignades.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTasquesAssignades.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbTitle5))
                    .addGroup(kGradientPanel3Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jTextFieldTasquesAssignades)))
                .addGap(13, 13, 13))
        );
        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbTitle5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTasquesAssignades, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113)
                .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        DashBoardView.setBackground(new java.awt.Color(255, 255, 255));
        DashBoardView.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DashBoardView.setForeground(new java.awt.Color(255, 255, 255));

        DashConfiguracio.setBackground(new java.awt.Color(255, 255, 255));
        DashConfiguracio.setForeground(new java.awt.Color(255, 255, 255));
        DashConfiguracio.setPreferredSize(new java.awt.Dimension(1140, 680));
        DashConfiguracio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel90.setBackground(new java.awt.Color(0, 0, 0));
        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setOpaque(true);
        DashConfiguracio.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonExportar.setText("Exportar BD");
        jButtonExportar.setBackground(new java.awt.Color(160, 160, 160));
        jButtonExportar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonExportar.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jButtonExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 138, 40));

        jButtonImportar.setText("Importar BD");
        jButtonImportar.setBackground(new java.awt.Color(160, 160, 160));
        jButtonImportar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonImportar.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jButtonImportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 138, 35));

        jCheckBoxSo.setText("Tó de notificació");
        jCheckBoxSo.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxSo.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxSo.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jCheckBoxSo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        jCheckBoxEnviarCorreu.setText("Enviar Correu de notificació");
        jCheckBoxEnviarCorreu.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxEnviarCorreu.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxEnviarCorreu.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jCheckBoxEnviarCorreu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        jLabel27.setText("Notificació Tasques:");
        jLabel27.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel98.setText("Doble factor d'autentificació:");
        jLabel98.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, -1, -1));

        jLabel64.setText("Configuració");
        jLabel64.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(4, 72, 210));
        DashConfiguracio.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 6, -1, -1));

        jCheckBox2FA.setText("2FA al inicar sessió");
        jCheckBox2FA.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2FA.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBox2FA.setForeground(new java.awt.Color(0, 0, 0));
        DashConfiguracio.add(jCheckBox2FA, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 270, -1, -1));

        jLabel102.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Base de dades:");
        DashConfiguracio.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, -1, -1));

        jLabel75.setBackground(new java.awt.Color(0, 0, 0));
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setOpaque(true);
        DashConfiguracio.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel93.setBackground(new java.awt.Color(0, 0, 0));
        jLabel93.setForeground(new java.awt.Color(0, 0, 0));
        jLabel93.setOpaque(true);
        DashConfiguracio.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 1, 270));

        jLabel104.setBackground(new java.awt.Color(0, 0, 0));
        jLabel104.setForeground(new java.awt.Color(0, 0, 0));
        jLabel104.setOpaque(true);
        DashConfiguracio.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 1, 270));

        DashGrups.setBackground(new java.awt.Color(255, 255, 255));
        DashGrups.setPreferredSize(new java.awt.Dimension(1140, 680));

        jButtonEliminarGrup.setText("Eliminar Grups");
        jButtonEliminarGrup.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarGrup.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarGrup.setForeground(new java.awt.Color(0, 0, 0));
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

        Grups.setText("Grups");
        Grups.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups.setForeground(new java.awt.Color(4, 72, 210));

        jButtonNouGrup.setText("Crear Grup");
        jButtonNouGrup.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouGrup.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouGrup.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setText("Cerca:");
        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel13.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));

        jLabel54.setBackground(new java.awt.Color(0, 0, 0));
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setOpaque(true);

        txtBuscadorGrups.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorGrups.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorGrups.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscadorGrups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorGrupsActionPerformed(evt);
            }
        });
        txtBuscadorGrups.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorGrupsKeyReleased(evt);
            }
        });

        jTable_Grups.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane_Grups.setViewportView(jTable_Grups);

        javax.swing.GroupLayout DashGrupsLayout = new javax.swing.GroupLayout(DashGrups);
        DashGrups.setLayout(DashGrupsLayout);
        DashGrupsLayout.setHorizontalGroup(
            DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashGrupsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashGrupsLayout.createSequentialGroup()
                        .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(DashGrupsLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButtonNouGrup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarGrup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(DashGrupsLayout.createSequentialGroup()
                        .addComponent(Grups)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashGrupsLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jScrollPane_Grups, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        DashGrupsLayout.setVerticalGroup(
            DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashGrupsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups)
                .addGap(25, 25, 25)
                .addGroup(DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashGrupsLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscadorGrups, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DashGrupsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNouGrup)
                        .addComponent(jButtonEliminarGrup)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_Grups, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        DashUsuaris.setBackground(new java.awt.Color(255, 255, 255));
        DashUsuaris.setPreferredSize(new java.awt.Dimension(1140, 680));

        jButtonEliminarUsuari.setText("Eliminar Usuaris");
        jButtonEliminarUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarUsuari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarUsuari.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminarUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarUsuariMouseClicked(evt);
            }
        });
        jButtonEliminarUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarUsuari(evt);
            }
        });

        jLabel23.setText("Usuaris");
        jLabel23.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(4, 72, 210));

        jButtonNouUsuari.setText("Crear Usuari");
        jButtonNouUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouUsuari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouUsuari.setForeground(new java.awt.Color(0, 0, 0));

        jLabel128.setText("Cerca:");
        jLabel128.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel128.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(0, 0, 0));

        jLabel132.setBackground(new java.awt.Color(0, 0, 0));
        jLabel132.setForeground(new java.awt.Color(0, 0, 0));
        jLabel132.setOpaque(true);

        txtBuscadorUsuari.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorUsuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorUsuariActionPerformed(evt);
            }
        });
        txtBuscadorUsuari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorUsuariKeyReleased(evt);
            }
        });

        jTable_Usuaris.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane_Usuaris.setViewportView(jTable_Usuaris);

        javax.swing.GroupLayout DashUsuarisLayout = new javax.swing.GroupLayout(DashUsuaris);
        DashUsuaris.setLayout(DashUsuarisLayout);
        DashUsuarisLayout.setHorizontalGroup(
            DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashUsuarisLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashUsuarisLayout.createSequentialGroup()
                        .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(DashUsuarisLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButtonNouUsuari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarUsuari)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(DashUsuarisLayout.createSequentialGroup()
                        .addGroup(DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane_Usuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(0, 20, Short.MAX_VALUE))))
        );
        DashUsuarisLayout.setVerticalGroup(
            DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashUsuarisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(25, 25, 25)
                .addGroup(DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashUsuarisLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel128))
                    .addGroup(DashUsuarisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNouUsuari)
                        .addComponent(jButtonEliminarUsuari))
                    .addComponent(txtBuscadorUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_Usuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DashOrdinadors.setBackground(new java.awt.Color(255, 255, 255));
        DashOrdinadors.setForeground(new java.awt.Color(51, 51, 255));
        DashOrdinadors.setPreferredSize(new java.awt.Dimension(1140, 680));

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

        jButtonEliminarOrdinadors.setText("Eliminar Ordinadors");
        jButtonEliminarOrdinadors.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarOrdinadors.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarOrdinadors.setForeground(new java.awt.Color(0, 0, 0));
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

        jButtonNouOrdinador.setText("Nou Ordinador");
        jButtonNouOrdinador.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouOrdinador.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouOrdinador.setForeground(new java.awt.Color(0, 0, 0));
        jButtonNouOrdinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNouOrdinadorActionPerformed(evt);
            }
        });

        txtBuscadorOrdinadors.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorOrdinadors.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorOrdinadors.setCaretColor(new java.awt.Color(0, 0, 0));
        txtBuscadorOrdinadors.setForeground(new java.awt.Color(160, 160, 160));
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

        jLabel103.setText("Cerca:");
        jLabel103.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 0, 0));

        jLabel56.setText("Ordinadors");
        jLabel56.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(4, 72, 210));

        jLabel68.setBackground(new java.awt.Color(0, 0, 0));
        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setOpaque(true);

        javax.swing.GroupLayout DashOrdinadorsLayout = new javax.swing.GroupLayout(DashOrdinadors);
        DashOrdinadors.setLayout(DashOrdinadorsLayout);
        DashOrdinadorsLayout.setHorizontalGroup(
            DashOrdinadorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashOrdinadorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashOrdinadorsLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jButtonNouOrdinador)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarOrdinadors)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel103)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBuscadorOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashOrdinadorsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane_Ordiandors, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashOrdinadorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashOrdinadorsLayout.setVerticalGroup(
            DashOrdinadorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashOrdinadorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addGap(32, 32, 32)
                .addGroup(DashOrdinadorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel103)
                    .addComponent(jButtonNouOrdinador)
                    .addComponent(jButtonEliminarOrdinadors))
                .addGap(18, 18, 18)
                .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane_Ordiandors, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );

        DashGrafiques.setBackground(new java.awt.Color(255, 255, 255));
        DashGrafiques.setForeground(new java.awt.Color(51, 51, 255));

        jLabel94.setText("Gràfiques");
        jLabel94.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(4, 72, 210));

        jLabel95.setBackground(new java.awt.Color(0, 0, 0));
        jLabel95.setForeground(new java.awt.Color(0, 0, 0));
        jLabel95.setOpaque(true);

        jComboBoxTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Circular", "Barres", "Lineal" }));
        jComboBoxTipus.setBackground(new java.awt.Color(160, 160, 160));
        jComboBoxTipus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBoxTipus.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setText("Tipus Gràfic:");
        jLabel1.setBackground(new java.awt.Color(160, 160, 160));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));

        jToggleButtonActualitzarGrafic.setText("Actualitzar");
        jToggleButtonActualitzarGrafic.setBackground(new java.awt.Color(160, 160, 160));
        jToggleButtonActualitzarGrafic.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jToggleButtonActualitzarGrafic.setForeground(new java.awt.Color(0, 0, 0));

        jRadioButton2D.setText("2D");
        jRadioButton2D.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton2D.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButton2D.setForeground(new java.awt.Color(0, 0, 0));

        jRadioButton3D.setText("3D");
        jRadioButton3D.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton3D.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButton3D.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanelTipusLayout = new javax.swing.GroupLayout(jPanelTipus);
        jPanelTipus.setLayout(jPanelTipusLayout);
        jPanelTipusLayout.setHorizontalGroup(
            jPanelTipusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1059, Short.MAX_VALUE)
        );
        jPanelTipusLayout.setVerticalGroup(
            jPanelTipusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );

        jComboBoxGrafic.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipus Tasques", "Estat Tasques", "Prioritat Tasques", "Usuaris Assignats" }));
        jComboBoxGrafic.setBackground(new java.awt.Color(160, 160, 160));
        jComboBoxGrafic.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jComboBoxGrafic.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Gràfic:");
        jLabel2.setBackground(new java.awt.Color(160, 160, 160));
        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));

        jTableGrafica.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableGrafica);

        jLabel3.setText("Vista:");
        jLabel3.setBackground(new java.awt.Color(160, 160, 160));
        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout DashGrafiquesLayout = new javax.swing.GroupLayout(DashGrafiques);
        DashGrafiques.setLayout(DashGrafiquesLayout);
        DashGrafiquesLayout.setHorizontalGroup(
            DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashGrafiquesLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DashGrafiquesLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxGrafic, 0, 741, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipus, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2D)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3D)
                        .addGap(110, 110, 110)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jToggleButtonActualitzarGrafic))
                    .addComponent(jPanelTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(615, Short.MAX_VALUE))
            .addGroup(DashGrafiquesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel94)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashGrafiquesLayout.createSequentialGroup()
                    .addContainerGap(56, Short.MAX_VALUE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        DashGrafiquesLayout.setVerticalGroup(
            DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashGrafiquesLayout.createSequentialGroup()
                .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashGrafiquesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel94)
                        .addGap(43, 43, 43)
                        .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButtonActualitzarGrafic, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1)
                                .addComponent(jRadioButton2D)
                                .addComponent(jRadioButton3D)
                                .addComponent(jComboBoxGrafic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashGrafiquesLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jPanelTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(DashGrafiquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashGrafiquesLayout.createSequentialGroup()
                    .addContainerGap(105, Short.MAX_VALUE)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(760, Short.MAX_VALUE)))
        );

        DashServidors.setBackground(new java.awt.Color(255, 255, 255));
        DashServidors.setForeground(new java.awt.Color(51, 51, 255));

        jScrollPane_Servidors.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Servidors.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_Servidors.setViewportView(jTable_Servidors);

        jButtonNouServidor.setText("Crear Servidor");
        jButtonNouServidor.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouServidor.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouServidor.setForeground(new java.awt.Color(0, 0, 0));

        jButtonEliminarServidors.setText("Eliminar Servidors");
        jButtonEliminarServidors.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarServidors.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarServidors.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminarServidors.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarServidorsMouseClicked(evt);
            }
        });
        jButtonEliminarServidors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarServidors(evt);
            }
        });

        jLabel69.setText("Cerca:");
        jLabel69.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel69.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 0, 0));

        txtBuscadorServidors.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorServidors.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorServidors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorServidorsActionPerformed(evt);
            }
        });
        txtBuscadorServidors.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorServidorsKeyReleased(evt);
            }
        });

        jLabel70.setText("Servidors");
        jLabel70.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(4, 72, 210));

        jLabel92.setBackground(new java.awt.Color(0, 0, 0));
        jLabel92.setForeground(new java.awt.Color(0, 0, 0));
        jLabel92.setOpaque(true);

        javax.swing.GroupLayout DashServidorsLayout = new javax.swing.GroupLayout(DashServidors);
        DashServidors.setLayout(DashServidorsLayout);
        DashServidorsLayout.setHorizontalGroup(
            DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashServidorsLayout.createSequentialGroup()
                        .addComponent(jLabel70)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addGroup(DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane_Servidors, javax.swing.GroupLayout.PREFERRED_SIZE, 1045, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DashServidorsLayout.createSequentialGroup()
                                .addComponent(jButtonNouServidor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEliminarServidors)
                                .addGap(544, 544, 544)
                                .addComponent(jLabel69)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscadorServidors, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
            .addGroup(DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createSequentialGroup()
                    .addContainerGap(32, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        DashServidorsLayout.setVerticalGroup(
            DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70)
                .addGap(30, 30, 30)
                .addGroup(DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNouServidor)
                        .addComponent(jButtonEliminarServidors))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscadorServidors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel69)))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane_Servidors, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(DashServidorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashServidorsLayout.createSequentialGroup()
                    .addContainerGap(100, Short.MAX_VALUE)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(755, Short.MAX_VALUE)))
        );

        DashImpresores.setBackground(new java.awt.Color(255, 255, 255));
        DashImpresores.setForeground(new java.awt.Color(51, 51, 255));

        jScrollPane_Impresores.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Impresores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_Impresores.setViewportView(jTable_Impresores);

        jButtonNouImpresora.setText("Crear Impresora");
        jButtonNouImpresora.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouImpresora.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouImpresora.setForeground(new java.awt.Color(0, 0, 0));

        jButtonEliminarImpresores.setText("Eliminar Impresores");
        jButtonEliminarImpresores.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarImpresores.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarImpresores.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminarImpresores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarImpresoresMouseClicked(evt);
            }
        });
        jButtonEliminarImpresores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarImpresores(evt);
            }
        });

        jLabel32.setText("Cerca:");
        jLabel32.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel32.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));

        txtBuscadorImpresores.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorImpresores.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorImpresores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorImpresoresActionPerformed(evt);
            }
        });
        txtBuscadorImpresores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorImpresoresKeyReleased(evt);
            }
        });

        jLabel41.setText("Teléfons");
        jLabel41.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(4, 72, 210));

        jLabel50.setBackground(new java.awt.Color(0, 0, 0));
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setOpaque(true);

        javax.swing.GroupLayout DashImpresoresLayout = new javax.swing.GroupLayout(DashImpresores);
        DashImpresores.setLayout(DashImpresoresLayout);
        DashImpresoresLayout.setHorizontalGroup(
            DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashImpresoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashImpresoresLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashImpresoresLayout.createSequentialGroup()
                        .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DashImpresoresLayout.createSequentialGroup()
                                .addGap(0, 59, Short.MAX_VALUE)
                                .addComponent(jScrollPane_Impresores, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DashImpresoresLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButtonNouImpresora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEliminarImpresores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBuscadorImpresores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(54, 54, 54))))
            .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashImpresoresLayout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        DashImpresoresLayout.setVerticalGroup(
            DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashImpresoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41)
                .addGap(31, 31, 31)
                .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNouImpresora)
                        .addComponent(jButtonEliminarImpresores))
                    .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscadorImpresores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel32)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane_Impresores, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(DashImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashImpresoresLayout.createSequentialGroup()
                    .addContainerGap(95, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(750, Short.MAX_VALUE)))
        );

        DashTasques.setBackground(new java.awt.Color(255, 255, 255));
        DashTasques.setPreferredSize(new java.awt.Dimension(1140, 680));

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
        jTable_Tasques.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jScrollPane_Tasques.setViewportView(jTable_Tasques);

        jButtonEliminarTasca.setText("Eliminar Tasques");
        jButtonEliminarTasca.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarTasca.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarTasca.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel8.setText("Usuari:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setText("Tasques");
        jLabel11.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(4, 72, 210));

        jButtonNovaTasca.setText("Crear Tasca");
        jButtonNovaTasca.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNovaTasca.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNovaTasca.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Cerca:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        jComboBoxDashTasquesUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jComboBoxDashTasquesUsuari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setOpaque(true);

        txtBuscadorTasques.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorTasques.setBackground(new java.awt.Color(160, 160, 160));
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

        javax.swing.GroupLayout DashTasquesLayout = new javax.swing.GroupLayout(DashTasques);
        DashTasques.setLayout(DashTasquesLayout);
        DashTasquesLayout.setHorizontalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTasquesLayout.createSequentialGroup()
                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashTasquesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashTasquesLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(DashTasquesLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButtonNovaTasca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEliminarTasca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 212, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashTasquesLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 1059, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        DashTasquesLayout.setVerticalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTasquesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashTasquesLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonNovaTasca)
                            .addComponent(jButtonEliminarTasca))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        DashTelefons.setBackground(new java.awt.Color(255, 255, 255));
        DashTelefons.setForeground(new java.awt.Color(51, 51, 255));

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

        jButtonNouTelefon.setText("Crear Teléfon");
        jButtonNouTelefon.setBackground(new java.awt.Color(160, 160, 160));
        jButtonNouTelefon.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonNouTelefon.setForeground(new java.awt.Color(0, 0, 0));

        jButtonEliminarTelefons.setText("Eliminar Teléfons");
        jButtonEliminarTelefons.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEliminarTelefons.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEliminarTelefons.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEliminarTelefons.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarTelefonsMouseClicked(evt);
            }
        });
        jButtonEliminarTelefons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTelefons(evt);
            }
        });

        jLabel12.setText("Cerca:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jLabel12.setFont(new java.awt.Font("sansserif", 1, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));

        txtBuscadorTelefons.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtBuscadorTelefons.setBackground(new java.awt.Color(160, 160, 160));
        txtBuscadorTelefons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorTelefonsActionPerformed(evt);
            }
        });
        txtBuscadorTelefons.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscadorTelefonsKeyReleased(evt);
            }
        });

        jLabel14.setText("Teléfons");
        jLabel14.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(4, 72, 210));

        jLabel22.setBackground(new java.awt.Color(0, 0, 0));
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setOpaque(true);

        javax.swing.GroupLayout DashTelefonsLayout = new javax.swing.GroupLayout(DashTelefons);
        DashTelefons.setLayout(DashTelefonsLayout);
        DashTelefonsLayout.setHorizontalGroup(
            DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(DashTelefonsLayout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addComponent(jButtonNouTelefon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarTelefons)
                        .addGap(556, 556, 556)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashTelefonsLayout.createSequentialGroup()
                        .addGroup(DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashTelefonsLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane_Telefons, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(48, 48, 48))
            .addGroup(DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createSequentialGroup()
                    .addContainerGap(26, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        DashTelefonsLayout.setVerticalGroup(
            DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(30, 30, 30)
                .addGroup(DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNouTelefon)
                        .addComponent(jButtonEliminarTelefons))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtBuscadorTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane_Telefons, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(DashTelefonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTelefonsLayout.createSequentialGroup()
                    .addContainerGap(95, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(750, Short.MAX_VALUE)))
        );

        DashNouGrup.setBackground(new java.awt.Color(255, 255, 255));
        DashNouGrup.setPreferredSize(new java.awt.Dimension(1140, 680));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistarGrup.setText("Guardar");
        jButtonRegistarGrup.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarGrup.setBorder(null);
        jButtonRegistarGrup.setBorderPainted(false);
        jButtonRegistarGrup.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarGrup.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistarGrup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(jButtonRegistarGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 520, 150, 30));

        jLabel72.setText("Cerca:");
        jLabel72.setBackground(new java.awt.Color(0, 0, 0));
        jLabel72.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, 20));

        txt_nomGrup.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomGrup.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomGrup.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(txt_nomGrup, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 180, 30));

        txt_cerca.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_cerca.setBackground(new java.awt.Color(160, 160, 160));
        txt_cerca.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(txt_cerca, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 130, 30));

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

        jPanel12.add(jScrollPaneElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 560, 390));

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

        jPanel12.add(jScrollPaneUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 560, 390));

        jTextGrupUsuaris.setColumns(20);
        jTextGrupUsuaris.setRows(5);
        jScrollPane2.setViewportView(jTextGrupUsuaris);

        jPanel12.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 220, 370));

        jButtonAfegir.setText("Afegir Usuari");
        jButtonAfegir.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegir.setBorder(null);
        jButtonAfegir.setBorderPainted(false);
        jButtonAfegir.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegir.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(jButtonAfegir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 100, 30));

        jRadioButtonElements.setText("Elements");
        jRadioButtonElements.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonElements.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonElements.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonElements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonElementsActionPerformed(evt);
            }
        });
        jPanel12.add(jRadioButtonElements, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, -1, -1));

        jRadioButtonUsuaris.setText("Usuaris");
        jRadioButtonUsuaris.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonUsuaris.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonUsuaris.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButtonUsuaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUsuarisActionPerformed(evt);
            }
        });
        jPanel12.add(jRadioButtonUsuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, -1, -1));

        jLabel73.setText("Tipus Grup:");
        jLabel73.setBackground(new java.awt.Color(0, 0, 0));
        jLabel73.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, 20));

        jButtonAfegirElement.setText("Afegir Element");
        jButtonAfegirElement.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirElement.setBorder(null);
        jButtonAfegirElement.setBorderPainted(false);
        jButtonAfegirElement.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegirElement.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirElement.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel12.add(jButtonAfegirElement, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 100, 30));

        txt_cerca1.setBackground(new java.awt.Color(160, 160, 160));
        txt_cerca1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel12.add(txt_cerca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 130, 20));

        jLabel88.setText("Nom Grup:");
        jLabel88.setBackground(new java.awt.Color(0, 0, 0));
        jLabel88.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jPanel12.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, 25));

        Grups3.setText("Grups / Nou Grup");
        Grups3.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups3.setForeground(new java.awt.Color(4, 72, 210));

        javax.swing.GroupLayout DashNouGrupLayout = new javax.swing.GroupLayout(DashNouGrup);
        DashNouGrup.setLayout(DashNouGrupLayout);
        DashNouGrupLayout.setHorizontalGroup(
            DashNouGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouGrupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashNouGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                    .addGroup(DashNouGrupLayout.createSequentialGroup()
                        .addComponent(Grups3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DashNouGrupLayout.setVerticalGroup(
            DashNouGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouGrupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups3)
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DashInfoGrup.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoGrup.setPreferredSize(new java.awt.Dimension(1140, 680));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistarGrup1.setText("Actualitzar");
        jButtonRegistarGrup1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarGrup1.setBorder(null);
        jButtonRegistarGrup1.setBorderPainted(false);
        jButtonRegistarGrup1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarGrup1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistarGrup1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonRegistarGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 150, 30));

        jLabel89.setText("Nom Grup:");
        jLabel89.setBackground(new java.awt.Color(0, 0, 0));
        jLabel89.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, 25));

        txt_nomGrup1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomGrup1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomGrup1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(txt_nomGrup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 31));

        txt_cerca2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_cerca2.setBackground(new java.awt.Color(160, 160, 160));
        txt_cerca2.setCaretColor(new java.awt.Color(0, 0, 0));
        txt_cerca2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(txt_cerca2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 30, 130, 31));

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

        jPanel10.add(jScrollPaneElements1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 630, 400));

        jTextGrupUsuaris1.setColumns(20);
        jTextGrupUsuaris1.setRows(5);
        jScrollPane4.setViewportView(jTextGrupUsuaris1);

        jPanel10.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 90, 180, 410));

        jButtonAfegir1.setText("Afegir Usuari");
        jButtonAfegir1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegir1.setBorder(null);
        jButtonAfegir1.setBorderPainted(false);
        jButtonAfegir1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegir1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegir1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonAfegir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 100, 30));

        jButtonAfegirElement1.setText("Afegir Element");
        jButtonAfegirElement1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirElement1.setBorder(null);
        jButtonAfegirElement1.setBorderPainted(false);
        jButtonAfegirElement1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegirElement1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirElement1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel10.add(jButtonAfegirElement1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, 100, 30));

        jLabel91.setText("Cerca:");
        jLabel91.setBackground(new java.awt.Color(0, 0, 0));
        jLabel91.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jPanel10.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, 25));

        Grups4.setText("Grup / Informació Grup");
        Grups4.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups4.setForeground(new java.awt.Color(4, 72, 210));

        javax.swing.GroupLayout DashInfoGrupLayout = new javax.swing.GroupLayout(DashInfoGrup);
        DashInfoGrup.setLayout(DashInfoGrupLayout);
        DashInfoGrupLayout.setHorizontalGroup(
            DashInfoGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoGrupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashInfoGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoGrupLayout.createSequentialGroup()
                        .addComponent(Grups4)
                        .addContainerGap(972, Short.MAX_VALUE))
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        DashInfoGrupLayout.setVerticalGroup(
            DashInfoGrupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashInfoGrupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DashNovaTasca.setBackground(new java.awt.Color(255, 255, 255));
        DashNovaTasca.setPreferredSize(new java.awt.Dimension(1140, 680));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setText("Data Venciment");
        jLabel48.setBackground(new java.awt.Color(255, 153, 51));
        jLabel48.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, 25));

        jLabel49.setText("Prioritat");
        jLabel49.setBackground(new java.awt.Color(255, 153, 51));
        jLabel49.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jLabel55.setText("Titol");
        jLabel55.setBackground(new java.awt.Color(0, 0, 0));
        jLabel55.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, 25));

        jLabel58.setText("Descripció");
        jLabel58.setBackground(new java.awt.Color(255, 153, 51));
        jLabel58.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, 30));

        ComboUsuariAssignat.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignat.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(ComboUsuariAssignat, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 150, 30));

        txt_titolTasc.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_titolTasc.setBackground(new java.awt.Color(160, 160, 160));
        txt_titolTasc.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(txt_titolTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 190, 30));

        txt_descripcioTasc.setBackground(new java.awt.Color(160, 160, 160));
        txt_descripcioTasc.setForeground(new java.awt.Color(0, 0, 0));
        txt_descripcioTasc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_descripcioTasc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_descripcioTasc.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jPanel5.add(txt_descripcioTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 980, 110));

        dateTimePicker.setBackground(new java.awt.Color(160, 160, 160));
        dateTimePicker.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dateTimePicker.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(dateTimePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 280, 30));

        jLabel63.setText("Grup Afectat");
        jLabel63.setBackground(new java.awt.Color(255, 153, 51));
        jLabel63.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, 25));

        jCheckBoxNotificacio.setText("Mostrar notificació");
        jCheckBoxNotificacio.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxNotificacio.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxNotificacio.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxNotificacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacioActionPerformed(evt);
            }
        });
        jPanel5.add(jCheckBoxNotificacio, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 230, 170, 30));

        ComboPrioritatTasc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc1.setBackground(new java.awt.Color(160, 160, 160));
        ComboPrioritatTasc1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboPrioritatTasc1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(ComboPrioritatTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 150, 30));

        jButtonRegistarTasca.setText("Guardar");
        jButtonRegistarTasca.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarTasca.setBorder(null);
        jButtonRegistarTasca.setBorderPainted(false);
        jButtonRegistarTasca.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarTasca.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistarTasca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jButtonRegistarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 150, 30));

        ComboGrupAfectat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat.setBackground(new java.awt.Color(160, 160, 160));
        ComboGrupAfectat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboGrupAfectat.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(ComboGrupAfectat, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 150, 26));

        jLabel84.setText("Usuari Assignat");
        jLabel84.setBackground(new java.awt.Color(255, 153, 51));
        jLabel84.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, 25));

        jButtonAfegirUsuari.setText("Afegir");
        jButtonAfegirUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirUsuari.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jButtonAfegirUsuari.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel5.add(jButtonAfegirUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 70, 30));

        jTextUsuariAssignat.setColumns(20);
        jTextUsuariAssignat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextUsuariAssignat.setRows(5);
        jTextUsuariAssignat.setBackground(new java.awt.Color(160, 160, 160));
        jTextUsuariAssignat.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(jTextUsuariAssignat);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, 110));

        jLabel47.setText("Tasques / Nova Tasca ");
        jLabel47.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(4, 72, 210));
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout DashNovaTascaLayout = new javax.swing.GroupLayout(DashNovaTasca);
        DashNovaTasca.setLayout(DashNovaTascaLayout);
        DashNovaTascaLayout.setHorizontalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 2310, Short.MAX_VALUE)
                .addContainerGap())
        );
        DashNovaTascaLayout.setVerticalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );

        DashTriaTasca.setBackground(new java.awt.Color(255, 255, 255));
        DashTriaTasca.setPreferredSize(new java.awt.Dimension(1140, 680));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setText("Tria el tipus de tasca");
        jLabel126.setBackground(new java.awt.Color(0, 0, 0));
        jLabel126.setFont(new java.awt.Font("SansSerif", 0, 36)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jPanel9.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, -1));

        jButtonTasca.setBackground(new java.awt.Color(4, 72, 210));

        jButtonTascaNormal12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal12.setText("Simple");
        jButtonTascaNormal12.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaNormal12.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonTascaNormal12.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaNormal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-task-50.png"))); // NOI18N
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

        jPanel9.add(jButtonTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, 170));

        jButtonTasca1.setBackground(new java.awt.Color(4, 72, 210));

        jButtonTascaRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaRec.setText("Recurrent");
        jButtonTascaRec.setBackground(new java.awt.Color(255, 255, 255));
        jButtonTascaRec.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonTascaRec.setForeground(new java.awt.Color(255, 255, 255));

        jButtonTascaRepeticio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonTascaRepeticio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-task-planning-50.png"))); // NOI18N
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

        jPanel9.add(jButtonTasca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 130, -1, 170));

        jLabel101.setText("Tasques / Tipus Tasca ");
        jLabel101.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(4, 72, 210));

        javax.swing.GroupLayout DashTriaTascaLayout = new javax.swing.GroupLayout(DashTriaTasca);
        DashTriaTasca.setLayout(DashTriaTascaLayout);
        DashTriaTascaLayout.setHorizontalGroup(
            DashTriaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
            .addGroup(DashTriaTascaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashTriaTascaLayout.setVerticalGroup(
            DashTriaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTriaTascaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addGap(37, 37, 37)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addContainerGap())
        );

        jList1.setBackground(new java.awt.Color(160, 160, 160));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane9.setViewportView(jList1);

        jButton1.setText("Enviar");
        jButton1.setBackground(new java.awt.Color(160, 160, 160));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBackground(new java.awt.Color(160, 160, 160));

        jLabel59.setText("Seguiment Tasca");
        jLabel59.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N

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
            .addGap(0, 491, Short.MAX_VALUE)
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

        DashInfoUsuari.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoUsuari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        DashInfoUsuari.setForeground(new java.awt.Color(51, 51, 255));
        DashInfoUsuari.setPreferredSize(new java.awt.Dimension(1140, 680));
        DashInfoUsuari.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_telefon.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_telefon.setBackground(new java.awt.Color(160, 160, 160));
        txt_telefon.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(txt_telefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 304, 150, 30));

        txt_nom.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nom.setBackground(new java.awt.Color(160, 160, 160));
        txt_nom.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 152, 150, 30));

        txt_cognom.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_cognom.setBackground(new java.awt.Color(160, 160, 160));
        txt_cognom.setForeground(new java.awt.Color(0, 0, 0));
        txt_cognom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cognomActionPerformed(evt);
            }
        });
        DashInfoUsuari.add(txt_cognom, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 226, 150, 30));

        txt_email.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_email.setBackground(new java.awt.Color(160, 160, 160));
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 376, 150, 30));

        txt_usuari.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_usuari.setBackground(new java.awt.Color(160, 160, 160));
        txt_usuari.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(txt_usuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 181, 150, 30));

        jLabel15.setText("Nom:");
        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 128, -1, -1));

        jLabel16.setText("Teléfon:");
        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 280, -1, -1));

        jLabel17.setText("Cognom:");
        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 200, -1, -1));

        jLabel18.setText("Email:");
        jLabel18.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 352, -1, -1));

        jLabel19.setText("Usuari:");
        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 157, -1, -1));

        jLabel20.setText("Nivell:");
        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 231, -1, -1));

        jLabel21.setText("Estat:");
        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 304, -1, -1));

        ComboEstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));
        ComboEstat.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstat.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstat.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(ComboEstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 328, 150, -1));

        ComboNivell.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell.setBackground(new java.awt.Color(160, 160, 160));
        ComboNivell.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboNivell.setForeground(new java.awt.Color(0, 0, 0));
        ComboNivell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivellActionPerformed(evt);
            }
        });
        DashInfoUsuari.add(ComboNivell, new org.netbeans.lib.awtextra.AbsoluteConstraints(723, 255, 150, -1));

        jButtonEditarUsuari.setText("Guardar");
        jButtonEditarUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarUsuari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEditarUsuari.setForeground(new java.awt.Color(0, 0, 0));
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
        DashInfoUsuari.add(jButtonEditarUsuari, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 150, 30));

        Enrera.setBackground(new java.awt.Color(0, 0, 0));
        Enrera.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoUsuari.add(Enrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 60, 62, 32));

        Grups5.setText("Usuaris / Informació Usuaris");
        Grups5.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups5.setForeground(new java.awt.Color(4, 72, 210));
        DashInfoUsuari.add(Grups5, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 6, -1, -1));

        DashNouUsuari.setBackground(new java.awt.Color(255, 255, 255));

        txt_usuari1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_usuari1.setBackground(new java.awt.Color(160, 160, 160));
        txt_usuari1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel24.setText("Cognom:");
        jLabel24.setBackground(new java.awt.Color(255, 153, 51));
        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));

        jLabel25.setText("Email:");
        jLabel25.setBackground(new java.awt.Color(255, 153, 51));
        jLabel25.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));

        jButtonRegistarUsuari.setText("Guardar");
        jButtonRegistarUsuari.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarUsuari.setBorder(null);
        jButtonRegistarUsuari.setBorderPainted(false);
        jButtonRegistarUsuari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarUsuari.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel26.setText("Usuari:");
        jLabel26.setBackground(new java.awt.Color(160, 160, 160));
        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));

        jLabel28.setText("Nom:");
        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));

        jLabel29.setText("Telèfon:");
        jLabel29.setBackground(new java.awt.Color(255, 153, 51));
        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));

        jLabel30.setText("Nivell:");
        jLabel30.setBackground(new java.awt.Color(160, 160, 160));
        jLabel30.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));

        jLabel31.setText("Estat");
        jLabel31.setBackground(new java.awt.Color(160, 160, 160));
        jLabel31.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));

        ComboNivell1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell1.setBackground(new java.awt.Color(160, 160, 160));
        ComboNivell1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboNivell1.setForeground(new java.awt.Color(0, 0, 0));
        ComboNivell1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivell1ActionPerformed(evt);
            }
        });

        ComboEstat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));
        ComboEstat1.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstat1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstat1.setForeground(new java.awt.Color(0, 0, 0));

        txt_nom1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_nom1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nom1.setForeground(new java.awt.Color(0, 0, 0));

        txt_cognom1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_cognom1.setBackground(new java.awt.Color(160, 160, 160));
        txt_cognom1.setForeground(new java.awt.Color(0, 0, 0));

        txt_telefon1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_telefon1.setBackground(new java.awt.Color(160, 160, 160));
        txt_telefon1.setForeground(new java.awt.Color(0, 0, 0));

        txt_mail1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txt_mail1.setBackground(new java.awt.Color(160, 160, 160));
        txt_mail1.setForeground(new java.awt.Color(0, 0, 0));

        Grups6.setText("Usuaris / Nou Usuari");
        Grups6.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups6.setForeground(new java.awt.Color(4, 72, 210));

        javax.swing.GroupLayout DashNouUsuariLayout = new javax.swing.GroupLayout(DashNouUsuari);
        DashNouUsuari.setLayout(DashNouUsuariLayout);
        DashNouUsuariLayout.setHorizontalGroup(
            DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups6)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addGap(287, 287, 287)
                        .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_mail1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_telefon1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cognom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(379, 379, 379)
                                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboNivell1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_usuari1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ComboEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addGap(587, 587, 587)
                        .addComponent(jButtonRegistarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1355, Short.MAX_VALUE))
        );
        DashNouUsuariLayout.setVerticalGroup(
            DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouUsuariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups6)
                .addGap(112, 112, 112)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashNouUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addComponent(txt_nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cognom1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefon1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_mail1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashNouUsuariLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_usuari1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(ComboNivell1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboEstat1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(111, 111, 111)
                .addComponent(jButtonRegistarUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        DashNouOrdinador.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_model.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_model.setBackground(new java.awt.Color(160, 160, 160));
        txt_model.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 151, 30));

        jLabel33.setText("Data ingrés");
        jLabel33.setBackground(new java.awt.Color(255, 153, 51));
        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 90, -1, 25));

        jLabel34.setText("Marca");
        jLabel34.setBackground(new java.awt.Color(255, 153, 51));
        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        jLabel35.setText("Model");
        jLabel35.setBackground(new java.awt.Color(255, 153, 51));
        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 151, 30));

        jLabel36.setText("Nom");
        jLabel36.setBackground(new java.awt.Color(0, 0, 0));
        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, 25));

        jLabel37.setText("Tipus");
        jLabel37.setBackground(new java.awt.Color(255, 153, 51));
        jLabel37.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 25));

        jLabel38.setText("Número Serie");
        jLabel38.setBackground(new java.awt.Color(255, 153, 51));
        jLabel38.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 151, 30));

        jLabel39.setText("Observacions");
        jLabel39.setBackground(new java.awt.Color(255, 153, 51));
        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 180, -1, 30));

        ComboTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escriptori", "Portàtil" }));
        ComboTipus.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipus.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(ComboTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 151, 30));

        ComboEstatElem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatElem.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatElem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatElem.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(ComboEstatElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 150, 26));

        txt_nomElem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomElem.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomElem.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_nomElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 150, 31));

        txt_numserie.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numserie.setBackground(new java.awt.Color(160, 160, 160));
        txt_numserie.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_numserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 150, 31));

        txt_marca.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marca.setBackground(new java.awt.Color(160, 160, 160));
        txt_marca.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 150, 30));

        txt_observacions.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacions.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacions.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(txt_observacions, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, 186, 190));

        jLabel40.setText("Adquisicó");
        jLabel40.setBackground(new java.awt.Color(255, 153, 51));
        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, 30));

        jLabel96.setText("Estat");
        jLabel96.setBackground(new java.awt.Color(255, 153, 51));
        jLabel96.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, 30));

        jRadioButtonRentingOrdinador.setText("Renting");
        jRadioButtonRentingOrdinador.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingOrdinador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingOrdinador.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jRadioButtonRentingOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, -1, -1));

        jRadioButtonCompraOrdinador.setText("Compra");
        jRadioButtonCompraOrdinador.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraOrdinador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraOrdinador.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jRadioButtonCompraOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        dataIngresOrdinador.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresOrdinador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel4.add(dataIngresOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, -1));

        jLabel97.setText("Usuari Assignat");
        jLabel97.setBackground(new java.awt.Color(255, 153, 51));
        jLabel97.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, -1, 25));

        ComboUsuariAssignatOrdinador.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignatOrdinador.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignatOrdinador.setForeground(new java.awt.Color(0, 0, 0));
        jPanel4.add(ComboUsuariAssignatOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 150, 26));

        jButtonRegistarOrdinador.setText("Guardar");
        jButtonRegistarOrdinador.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarOrdinador.setBorder(null);
        jButtonRegistarOrdinador.setBorderPainted(false);
        jButtonRegistarOrdinador.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarOrdinador.setForeground(new java.awt.Color(0, 0, 0));
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

        Grups8.setText("Ordinadors / Nou Ordinador");
        Grups8.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups8.setForeground(new java.awt.Color(4, 72, 210));

        javax.swing.GroupLayout DashNouOrdinadorLayout = new javax.swing.GroupLayout(DashNouOrdinador);
        DashNouOrdinador.setLayout(DashNouOrdinadorLayout);
        DashNouOrdinadorLayout.setHorizontalGroup(
            DashNouOrdinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                .addGap(43, 43, 43))
            .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                .addGroup(DashNouOrdinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(jButtonRegistarOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Grups8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashNouOrdinadorLayout.setVerticalGroup(
            DashNouOrdinadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouOrdinadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(jButtonRegistarOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        DashInfoOrdinador.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoOrdinador.setForeground(new java.awt.Color(51, 51, 255));
        DashInfoOrdinador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonEditarOrdinador.setText("Guardar");
        jButtonEditarOrdinador.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarOrdinador.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEditarOrdinador.setForeground(new java.awt.Color(0, 0, 0));
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
        DashInfoOrdinador.add(jButtonEditarOrdinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 480, 150, 30));

        Enrera1.setBackground(new java.awt.Color(0, 0, 0));
        Enrera1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(Enrera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 60, 62, 32));

        txt_nomElem1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomElem1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomElem1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(txt_nomElem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 150, 31));

        jLabel42.setText("Nom");
        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, 25));

        jLabel43.setText("Marca");
        jLabel43.setBackground(new java.awt.Color(255, 153, 51));
        jLabel43.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        txt_marca1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marca1.setBackground(new java.awt.Color(160, 160, 160));
        txt_marca1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(txt_marca1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 150, 30));

        jLabel44.setText("Model");
        jLabel44.setBackground(new java.awt.Color(255, 153, 51));
        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 151, 30));

        txt_model1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_model1.setBackground(new java.awt.Color(160, 160, 160));
        txt_model1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(txt_model1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 151, 30));

        jLabel45.setText("Número Serie");
        jLabel45.setBackground(new java.awt.Color(255, 153, 51));
        jLabel45.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 151, 30));

        txt_numserie1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numserie1.setBackground(new java.awt.Color(160, 160, 160));
        txt_numserie1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(txt_numserie1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 150, 31));

        ComboEstatElem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatElem1.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatElem1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatElem1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(ComboEstatElem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 150, 26));

        jLabel99.setText("Estat");
        jLabel99.setBackground(new java.awt.Color(255, 153, 51));
        jLabel99.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, 30));

        ComboTipus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escriptori", "Portàtil" }));
        ComboTipus1.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipus1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipus1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(ComboTipus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 151, 30));

        jLabel46.setText("Tipus");
        jLabel46.setBackground(new java.awt.Color(255, 153, 51));
        jLabel46.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, 25));

        ComboUsuariAssignatOrdinador1.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignatOrdinador1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignatOrdinador1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(ComboUsuariAssignatOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 150, 26));

        jLabel100.setText("Usuari Assignat");
        jLabel100.setBackground(new java.awt.Color(255, 153, 51));
        jLabel100.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, -1, 25));

        jLabel51.setText("Adquisicó");
        jLabel51.setBackground(new java.awt.Color(255, 153, 51));
        jLabel51.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 30));

        jRadioButtonRentingOrdinador1.setText("Renting");
        jRadioButtonRentingOrdinador1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingOrdinador1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingOrdinador1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jRadioButtonRentingOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, -1, -1));

        jRadioButtonCompraOrdinador1.setText("Compra");
        jRadioButtonCompraOrdinador1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraOrdinador1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraOrdinador1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jRadioButtonCompraOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 400, -1, -1));

        txt_observacions1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacions1.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacions1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(txt_observacions1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 230, 186, 190));

        jLabel52.setText("Observacions");
        jLabel52.setBackground(new java.awt.Color(255, 153, 51));
        jLabel52.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 200, -1, 30));

        dataIngresOrdinador1.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresOrdinador1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dataIngresOrdinador1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(dataIngresOrdinador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, -1, -1));

        jLabel53.setText("Data ingrés");
        jLabel53.setBackground(new java.awt.Color(255, 153, 51));
        jLabel53.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoOrdinador.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, 25));

        Grups9.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups9.setForeground(new java.awt.Color(4, 72, 210));
        Grups9.setText("Ordinadors / Informació Ordinador");
        DashInfoOrdinador.add(Grups9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        DashInfoTasca.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.setForeground(new java.awt.Color(51, 51, 255));
        DashInfoTasca.setPreferredSize(new java.awt.Dimension(1140, 680));
        DashInfoTasca.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_titolTasc2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_titolTasc2.setBackground(new java.awt.Color(160, 160, 160));
        txt_titolTasc2.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(txt_titolTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 150, 30));

        jLabel57.setText("Titol:");
        jLabel57.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        jLabel60.setText("Prioritat: ");
        jLabel60.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        jLabel61.setText("Usuari Assignat:");
        jLabel61.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 110, -1));

        jLabel62.setText("Data Venciment:");
        jLabel62.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        jLabel65.setText("Estat:");
        jLabel65.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        ComboEstatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés", "Finalitzada" }));
        ComboEstatTasc2.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatTasc2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatTasc2.setForeground(new java.awt.Color(0, 0, 0));
        ComboEstatTasc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEstatTasc2ActionPerformed(evt);
            }
        });
        DashInfoTasca.add(ComboEstatTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 110, 30));

        jButtonEditarTasca.setText("Actualitzar");
        jButtonEditarTasca.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarTasca.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEditarTasca.setForeground(new java.awt.Color(0, 0, 0));
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
        DashInfoTasca.add(jButtonEditarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, 150, 30));

        txt_descripcioTasc2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_descripcioTasc2.setBackground(new java.awt.Color(160, 160, 160));
        txt_descripcioTasc2.setForeground(new java.awt.Color(0, 0, 0));
        txt_descripcioTasc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcioTasc2ActionPerformed(evt);
            }
        });
        DashInfoTasca.add(txt_descripcioTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 970, 130));

        jLabel66.setText("Descripció:");
        jLabel66.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, -1, -1));

        ComboPrioritatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitjana", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc2.setBackground(new java.awt.Color(160, 160, 160));
        ComboPrioritatTasc2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboPrioritatTasc2.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(ComboPrioritatTasc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, 30));
        DashInfoTasca.add(dateTimePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 270, 30));

        ComboUsuariAssignat2.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignat2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignat2.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(ComboUsuariAssignat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 150, 30));

        ComboGrupAfectat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat1.setBackground(new java.awt.Color(160, 160, 160));
        ComboGrupAfectat1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboGrupAfectat1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(ComboGrupAfectat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 180, 30));

        jLabel85.setText("Grup Afectat:");
        jLabel85.setBackground(new java.awt.Color(255, 153, 51));
        jLabel85.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 80, -1, -1));

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
        jScrollPane3.setViewportView(jTableInfoTasca);

        DashInfoTasca.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 180, 140));

        jCheckBox1.setText("Mostrar Notificació");
        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTasca.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 150, 30));

        jTextUsuariAssignat1.setColumns(20);
        jTextUsuariAssignat1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextUsuariAssignat1.setRows(5);
        jTextUsuariAssignat1.setBackground(new java.awt.Color(160, 160, 160));
        jTextUsuariAssignat1.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane6.setViewportView(jTextUsuariAssignat1);

        DashInfoTasca.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 150, 100));

        jButtonAfegirUsuari1.setText("+");
        jButtonAfegirUsuari1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirUsuari1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAfegirUsuari1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashInfoTasca.add(jButtonAfegirUsuari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 30, 30));

        jButtonChat.setText("Chat");
        jButtonChat.setBackground(new java.awt.Color(160, 160, 160));
        jButtonChat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonChat.setForeground(new java.awt.Color(0, 0, 0));
        jButtonChat.setOpaque(true);
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
        DashInfoTasca.add(jButtonChat, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 330, 180, 30));

        Grups2.setText("Tasques / Informació Tasca");
        Grups2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups2.setForeground(new java.awt.Color(4, 72, 210));
        DashInfoTasca.add(Grups2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        DashInfoTascaRepeticio.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoTascaRepeticio.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.setPreferredSize(new java.awt.Dimension(1140, 680));
        DashInfoTascaRepeticio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSetmanes1.setText("setmanes");
        jLabelSetmanes1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelSetmanes1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelSetmanes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));
        DashInfoTascaRepeticio.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 50, -1));

        jCheckBoxDissabte1.setText("Dissabte");
        jCheckBoxDissabte1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDissabte1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDissabte1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDissabte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, -1));

        jCheckBoxDimecres1.setText("Dimecres");
        jCheckBoxDimecres1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimecres1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDimecres1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDimecres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        jCheckBoxDimarts1.setText("Dimarts");
        jCheckBoxDimarts1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimarts1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDimarts1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDimarts1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        jCheckBoxDiumenge1.setText("Diumenge");
        jCheckBoxDiumenge1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDiumenge1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDiumenge1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDiumenge1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, -1, -1));

        jCheckBoxDijous1.setText("Dijous");
        jCheckBoxDijous1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDijous1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDijous1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDijous1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, -1, -1));

        jCheckBoxDilluns1.setText("Dilluns");
        jCheckBoxDilluns1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDilluns1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDilluns1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDilluns1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, -1, -1));

        jCheckBoxDivendres1.setText("Divendres");
        jCheckBoxDivendres1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDivendres1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDivendres1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jCheckBoxDivendres1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, -1, -1));

        jLabelRepetirCada1.setText("Repetir Cada");
        jLabelRepetirCada1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRepetirCada1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelRepetirCada1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelRepetirCada1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, -1, -1));

        dateTimePickerRepeticioFinal1.setBackground(new java.awt.Color(160, 160, 160));
        dateTimePickerRepeticioFinal1.setEnabled(false);
        dateTimePickerRepeticioFinal1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DashInfoTascaRepeticio.add(dateTimePickerRepeticioFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 270, -1));

        jLabel78.setText("Data Inici: ");
        jLabel78.setBackground(new java.awt.Color(255, 255, 255));
        jLabel78.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 70, 30));

        jLabelDias1.setText("dias");
        jLabelDias1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDias1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelDias1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelDias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jRadioButtonAcabar1.setText("Finalitzar després de");
        jRadioButtonAcabar1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAcabar1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonAcabar1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonAcabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, 160, -1));

        jRadioButtonMensual1.setText("Mensual");
        jRadioButtonMensual1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonMensual1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonMensual1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonMensual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 80, -1));

        jRadioButtonSetmanal1.setText("Setmanal");
        jRadioButtonSetmanal1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonSetmanal1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonSetmanal1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonSetmanal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, -1));

        jRadioButtonDiari1.setText("Diari");
        jRadioButtonDiari1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDiari1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonDiari1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonDiari1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, -1, -1));

        jButtonEditarTascaRecurrent.setText("Actualitzar");
        jButtonEditarTascaRecurrent.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarTascaRecurrent.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEditarTascaRecurrent.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jButtonEditarTascaRecurrent, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, 110, 30));

        jRadioButtonAnual1.setText("Anual");
        jRadioButtonAnual1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAnual1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonAnual1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonAnual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 240, 72, -1));

        dateTimePickerRepeticio1.setBackground(new java.awt.Color(160, 160, 160));
        dateTimePickerRepeticio1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        DashInfoTascaRepeticio.add(dateTimePickerRepeticio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 250, 270, -1));

        jLabelMesos1.setText("mesos");
        jLabelMesos1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMesos1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelMesos1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelMesos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jLabelAnys1.setText("anys");
        jLabelAnys1.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAnys1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelAnys1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelAnys1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        jRadioButtonDataFinal1.setText("Data Final");
        jRadioButtonDataFinal1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDataFinal1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonDataFinal1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonDataFinal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 280, 100, -1));

        jSpinnerAcabar1.setEnabled(false);
        DashInfoTascaRepeticio.add(jSpinnerAcabar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 360, 70, -1));

        jLabelSetmanes3.setText("vegades");
        jLabelSetmanes3.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelSetmanes3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabelSetmanes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 60, 20));

        txt_titolTasc3.setBackground(new java.awt.Color(160, 160, 160));
        txt_titolTasc3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(txt_titolTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 170, 31));

        jLabel79.setText("Titol");
        jLabel79.setBackground(new java.awt.Color(0, 0, 0));
        jLabel79.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 40, 30));

        jLabel80.setText("Prioritat");
        jLabel80.setBackground(new java.awt.Color(255, 153, 51));
        jLabel80.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 60, 30));

        ComboPrioritatTasc4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc4.setBackground(new java.awt.Color(160, 160, 160));
        ComboPrioritatTasc4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboPrioritatTasc4.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(ComboPrioritatTasc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 100, 30));

        ComboEstatTasc3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés", "Finalitzada" }));
        ComboEstatTasc3.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatTasc3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatTasc3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(ComboEstatTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, 26));

        jLabel81.setText("Estat");
        jLabel81.setBackground(new java.awt.Color(255, 153, 51));
        jLabel81.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 40, 30));

        jLabel82.setText("Usuari Assignat");
        jLabel82.setBackground(new java.awt.Color(255, 153, 51));
        jLabel82.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 110, 30));

        ComboUsuariAssignat3.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignat3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignat3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(ComboUsuariAssignat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, 26));

        jCheckBoxNotificacio22.setText("Mostrar Notificació");
        jCheckBoxNotificacio22.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxNotificacio22.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxNotificacio22.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxNotificacio22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacio22ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(jCheckBoxNotificacio22, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 150, 30));

        txt_descripcioTasc3.setBackground(new java.awt.Color(160, 160, 160));
        txt_descripcioTasc3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(txt_descripcioTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 970, 140));

        jLabel83.setText("Descripció");
        jLabel83.setBackground(new java.awt.Color(255, 153, 51));
        jLabel83.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, 30));

        ComboMesNumero1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primer", "Segon", "Tercer", "Cuart", "Últim" }));
        ComboMesNumero1.setBackground(new java.awt.Color(160, 160, 160));
        ComboMesNumero1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboMesNumero1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(ComboMesNumero1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 90, 26));

        jRadioButtonEl1.setText("El");
        jRadioButtonEl1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonEl1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonEl1.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jRadioButtonEl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 280, -1, -1));

        ComboMesDia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge" }));
        ComboMesDia1.setBackground(new java.awt.Color(160, 160, 160));
        ComboMesDia1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboMesDia1.setForeground(new java.awt.Color(0, 0, 0));
        ComboMesDia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesDia1ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(ComboMesDia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 90, 26));

        ComboMes1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre" }));
        ComboMes1.setBackground(new java.awt.Color(160, 160, 160));
        ComboMes1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboMes1.setForeground(new java.awt.Color(0, 0, 0));
        ComboMes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMes1ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(ComboMes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, 90, 26));

        ComboGrupAfectat3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat3.setBackground(new java.awt.Color(160, 160, 160));
        ComboGrupAfectat3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboGrupAfectat3.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(ComboGrupAfectat3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, 150, 26));

        jLabel87.setText("Grup Afectat");
        jLabel87.setBackground(new java.awt.Color(255, 153, 51));
        jLabel87.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        DashInfoTascaRepeticio.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 90, 30));

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
        jScrollPane7.setViewportView(jTableInfoTasca1);

        DashInfoTascaRepeticio.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 200, 90));

        jTextUsuariAssignat3.setColumns(20);
        jTextUsuariAssignat3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextUsuariAssignat3.setRows(5);
        jTextUsuariAssignat3.setBackground(new java.awt.Color(160, 160, 160));
        jTextUsuariAssignat3.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane8.setViewportView(jTextUsuariAssignat3);

        DashInfoTascaRepeticio.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 140, 150));

        jButtonAfegirUsuari3.setText("Afegir");
        jButtonAfegirUsuari3.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirUsuari3.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegirUsuari3.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashInfoTascaRepeticio.add(jButtonAfegirUsuari3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 80, 30));

        Grups1.setText("Tasques / Informació Tasca Recurrent");
        Grups1.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups1.setForeground(new java.awt.Color(4, 72, 210));
        DashInfoTascaRepeticio.add(Grups1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButtonChat1.setText("Chat");
        jButtonChat1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonChat1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonChat1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonChat1.setOpaque(true);
        jButtonChat1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChat1MouseClicked(evt);
            }
        });
        jButtonChat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChat1ActionPerformed(evt);
            }
        });
        DashInfoTascaRepeticio.add(jButtonChat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 180, 30));

        DashPerfilUsuari.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCanviarContrasenya.setText("Canviar contrasenya");
        jButtonCanviarContrasenya.setBackground(new java.awt.Color(160, 160, 160));
        jButtonCanviarContrasenya.setBorder(null);
        jButtonCanviarContrasenya.setBorderPainted(false);
        jButtonCanviarContrasenya.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonCanviarContrasenya.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCanviarContrasenya.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButtonGuardarFoto.setText("Guardar Foto");
        jButtonGuardarFoto.setBackground(new java.awt.Color(160, 160, 160));
        jButtonGuardarFoto.setBorder(null);
        jButtonGuardarFoto.setBorderPainted(false);
        jButtonGuardarFoto.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonGuardarFoto.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuardarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarFotoActionPerformed(evt);
            }
        });

        jButtonCanviarFoto.setText("Selecionar foto");
        jButtonCanviarFoto.setBackground(new java.awt.Color(160, 160, 160));
        jButtonCanviarFoto.setBorder(null);
        jButtonCanviarFoto.setBorderPainted(false);
        jButtonCanviarFoto.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonCanviarFoto.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCanviarFoto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCanviarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCanviarFotoActionPerformed(evt);
            }
        });

        Grups7.setText("Perfil");
        Grups7.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups7.setForeground(new java.awt.Color(4, 72, 210));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setOpaque(true);

        cLabelFoto.setText("");

        javax.swing.GroupLayout DashPerfilUsuariLayout = new javax.swing.GroupLayout(DashPerfilUsuari);
        DashPerfilUsuari.setLayout(DashPerfilUsuariLayout);
        DashPerfilUsuariLayout.setHorizontalGroup(
            DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Grups7))
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addGap(528, 528, 528)
                        .addComponent(txtNomImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonCanviarFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonGuardarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(108, 108, 108))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashPerfilUsuariLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121)))
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(jButtonCanviarContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1476, Short.MAX_VALUE))
        );
        DashPerfilUsuariLayout.setVerticalGroup(
            DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(txtNomImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Grups7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashPerfilUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addComponent(cLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButtonCanviarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashPerfilUsuariLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jButtonCanviarContrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        DashNovaTascaRepeticio.setBackground(new java.awt.Color(255, 255, 255));
        DashNovaTascaRepeticio.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.setMaximumSize(new java.awt.Dimension(700, 502));
        DashNovaTascaRepeticio.setPreferredSize(new java.awt.Dimension(1140, 680));
        DashNovaTascaRepeticio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSetmanes.setText("setmanes");
        jLabelSetmanes.setBackground(new java.awt.Color(255, 255, 255));
        jLabelSetmanes.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelSetmanes.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelSetmanes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));
        DashNovaTascaRepeticio.add(jSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 60, 20));

        jCheckBoxDissabte.setText("Dissabte");
        jCheckBoxDissabte.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDissabte.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDissabte.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDissabte, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 300, -1, 20));

        jCheckBoxDimecres.setText("Dimecres");
        jCheckBoxDimecres.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimecres.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDimecres.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDimecres, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, 20));

        jCheckBoxDimarts.setText("Dimarts");
        jCheckBoxDimarts.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDimarts.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDimarts.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDimarts, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, -1, 20));

        jCheckBoxDiumenge.setText("Diumenge");
        jCheckBoxDiumenge.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDiumenge.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDiumenge.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDiumenge, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 280, -1, -1));

        jCheckBoxDijous.setText("Dijous");
        jCheckBoxDijous.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDijous.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDijous.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDijous, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, 20));

        jCheckBoxDilluns.setText("Dilluns");
        jCheckBoxDilluns.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDilluns.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDilluns.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDilluns, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, -1, -1));

        jCheckBoxDivendres.setText("Divendres");
        jCheckBoxDivendres.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxDivendres.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxDivendres.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jCheckBoxDivendres, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        jLabelRepetirCada.setText("Repetir Cada");
        jLabelRepetirCada.setBackground(new java.awt.Color(255, 255, 255));
        jLabelRepetirCada.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelRepetirCada.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelRepetirCada, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, -1, -1));

        dateTimePickerRepeticioFinal.setBackground(new java.awt.Color(160, 160, 160));
        dateTimePickerRepeticioFinal.setEnabled(false);
        dateTimePickerRepeticioFinal.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dateTimePickerRepeticioFinal.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(dateTimePickerRepeticioFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, 290, -1));

        jLabel4.setText("Data Inici: ");
        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, -1, 20));

        jLabelDias.setText("dias");
        jLabelDias.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDias.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelDias.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelDias, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jRadioButtonAcabar.setText("Acabar després de ");
        jRadioButtonAcabar.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAcabar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonAcabar.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonAcabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, -1, -1));

        jRadioButtonMensual.setText("Mensual");
        jRadioButtonMensual.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonMensual.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonMensual.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 240, 80, -1));

        jRadioButtonSetmanal.setText("Setmanal");
        jRadioButtonSetmanal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonSetmanal.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonSetmanal.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonSetmanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jRadioButtonDiari.setText("Diari");
        jRadioButtonDiari.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDiari.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonDiari.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonDiari, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 240, -1, -1));

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAceptar.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAceptar.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jButtonAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 600, 120, 30));

        jRadioButtonAnual.setText("Anual");
        jRadioButtonAnual.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonAnual.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonAnual.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 72, -1));

        dateTimePickerRepeticio.setBackground(new java.awt.Color(160, 160, 160));
        dateTimePickerRepeticio.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        dateTimePickerRepeticio.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(dateTimePickerRepeticio, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 290, -1));

        jLabelMesos.setText("mesos");
        jLabelMesos.setBackground(new java.awt.Color(255, 255, 255));
        jLabelMesos.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelMesos.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelMesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jLabelAnys.setText("anys");
        jLabelAnys.setBackground(new java.awt.Color(255, 255, 255));
        jLabelAnys.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelAnys.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelAnys, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, -1, -1));

        jRadioButtonDataFinal.setText("Data Final");
        jRadioButtonDataFinal.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonDataFinal.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jRadioButtonDataFinal.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonDataFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 260, 90, 30));

        jSpinnerAcabar.setEnabled(false);
        DashNovaTascaRepeticio.add(jSpinnerAcabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 340, 60, -1));

        jLabelvegades.setText("vegades");
        jLabelvegades.setBackground(new java.awt.Color(255, 255, 255));
        jLabelvegades.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabelvegades.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabelvegades, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, -1, 20));

        txt_titolTasc1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_titolTasc1.setBackground(new java.awt.Color(160, 160, 160));
        txt_titolTasc1.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(txt_titolTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 180, 31));

        jLabel71.setText("Títol");
        jLabel71.setBackground(new java.awt.Color(0, 0, 0));
        jLabel71.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 80, 25));

        jLabel74.setText("Prioritat");
        jLabel74.setBackground(new java.awt.Color(255, 153, 51));
        jLabel74.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        ComboPrioritatTasc3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        ComboPrioritatTasc3.setBackground(new java.awt.Color(160, 160, 160));
        ComboPrioritatTasc3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboPrioritatTasc3.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(ComboPrioritatTasc3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 130, 26));

        jLabel76.setText("Usuari Assignat");
        jLabel76.setBackground(new java.awt.Color(255, 153, 51));
        jLabel76.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 110, 25));

        ComboUsuariAssignat1.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignat1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignat1.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(ComboUsuariAssignat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, 30));

        jCheckBoxNotificacio1.setText("Mostrar Notificació");
        jCheckBoxNotificacio1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBoxNotificacio1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jCheckBoxNotificacio1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBoxNotificacio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNotificacio1ActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(jCheckBoxNotificacio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 150, 30));

        txt_descripcioTasc1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_descripcioTasc1.setBackground(new java.awt.Color(160, 160, 160));
        txt_descripcioTasc1.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(txt_descripcioTasc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 970, 120));

        jLabel77.setText("Descripció");
        jLabel77.setBackground(new java.awt.Color(255, 153, 51));
        jLabel77.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, -1, 30));

        ComboMesNumero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Primer", "Segon", "Tercer", "Cuart", "Últim" }));
        ComboMesNumero.setBackground(new java.awt.Color(160, 160, 160));
        ComboMesNumero.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(ComboMesNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 100, 26));

        ComboMesDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Dissabte", "Diumenge" }));
        ComboMesDia.setBackground(new java.awt.Color(160, 160, 160));
        ComboMesDia.setForeground(new java.awt.Color(0, 0, 0));
        ComboMesDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesDiaActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(ComboMesDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, 90, 26));

        jRadioButtonEl.setText("El");
        jRadioButtonEl.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonEl.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jRadioButtonEl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, -1, -1));

        ComboMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gener", "Febrer", "Març", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octubre", "Novembre" }));
        ComboMes.setBackground(new java.awt.Color(160, 160, 160));
        ComboMes.setForeground(new java.awt.Color(0, 0, 0));
        ComboMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboMesActionPerformed(evt);
            }
        });
        DashNovaTascaRepeticio.add(ComboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 90, 26));

        ComboGrupAfectat2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboGrupAfectat2.setBackground(new java.awt.Color(160, 160, 160));
        ComboGrupAfectat2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboGrupAfectat2.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(ComboGrupAfectat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 120, 26));

        jLabel86.setText("Grup Afectat");
        jLabel86.setBackground(new java.awt.Color(255, 153, 51));
        jLabel86.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        DashNovaTascaRepeticio.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, 25));

        jTextUsuariAssignat2.setColumns(20);
        jTextUsuariAssignat2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jTextUsuariAssignat2.setRows(5);
        jTextUsuariAssignat2.setBackground(new java.awt.Color(160, 160, 160));
        jScrollPane10.setViewportView(jTextUsuariAssignat2);

        DashNovaTascaRepeticio.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 150, 120));

        jButtonAfegirUsuari2.setText("+");
        jButtonAfegirUsuari2.setBackground(new java.awt.Color(160, 160, 160));
        jButtonAfegirUsuari2.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonAfegirUsuari2.setForeground(new java.awt.Color(0, 0, 0));
        jButtonAfegirUsuari2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        DashNovaTascaRepeticio.add(jButtonAfegirUsuari2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 40, 30));

        jLabel67.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(4, 72, 210));
        jLabel67.setText("Tasques / Nova Tasca Recurrent");
        DashNovaTascaRepeticio.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        DashInfoServidor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_modelSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, 30));

        jLabel167.setText("Data ingrés");
        jLabel167.setBackground(new java.awt.Color(255, 153, 51));
        jLabel167.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, 25));

        jLabel168.setText("Marca");
        jLabel168.setBackground(new java.awt.Color(255, 153, 51));
        jLabel168.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel169.setText("Model");
        jLabel169.setBackground(new java.awt.Color(255, 153, 51));
        jLabel169.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 151, 30));

        jLabel170.setText("Nom");
        jLabel170.setBackground(new java.awt.Color(0, 0, 0));
        jLabel170.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 25));

        jLabel171.setText("Tipus");
        jLabel171.setBackground(new java.awt.Color(255, 153, 51));
        jLabel171.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 25));

        jLabel172.setText("Número Serie");
        jLabel172.setBackground(new java.awt.Color(255, 153, 51));
        jLabel172.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        jLabel173.setText("Observacions");
        jLabel173.setBackground(new java.awt.Color(255, 153, 51));
        jLabel173.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel173.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, -1, 30));

        ComboTipusSer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tèrmica", "Làser", "Multifunció", "Plotter", "3D", "Etiquetes" }));
        ComboTipusSer1.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(ComboTipusSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 151, 30));

        ComboEstatSer1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatSer1.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(ComboEstatSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 26));

        txt_nomSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_nomSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, 31));

        txt_NumeroSerieSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_NumeroSerieSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_NumeroSerieSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_NumeroSerieSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 31));

        txt_marcaSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_marcaSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txt_observacionsSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsSer1.setForeground(new java.awt.Color(0, 0, 0));
        txt_observacionsSer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_observacionsSer1ActionPerformed(evt);
            }
        });
        jPanel21.add(txt_observacionsSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 186, 150));

        jLabel174.setText("Adquisicó");
        jLabel174.setBackground(new java.awt.Color(255, 153, 51));
        jLabel174.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel174.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, 30));

        jLabel175.setText("Estat");
        jLabel175.setBackground(new java.awt.Color(255, 153, 51));
        jLabel175.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel175.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel175, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, 30));

        jRadioButtonRentingSer1.setText("Renting");
        jRadioButtonRentingSer1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jRadioButtonRentingSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jRadioButtonCompraSer1.setText("Compra");
        jRadioButtonCompraSer1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jRadioButtonCompraSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, -1, -1));

        dataIngresSer1.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel21.add(dataIngresSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        jLabel176.setText("Ubicació");
        jLabel176.setBackground(new java.awt.Color(255, 153, 51));
        jLabel176.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel176.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel176, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 25));

        jLabel177.setText("IP");
        jLabel177.setBackground(new java.awt.Color(255, 153, 51));
        jLabel177.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel177.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel177, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 151, 30));

        txt_numeroSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_numeroSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 150, 31));

        txt_ubicacioSer1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_ubicacioSer1.setBackground(new java.awt.Color(160, 160, 160));
        txt_ubicacioSer1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_ubicacioSer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 150, 31));

        txt_SistemaOperatiu1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_SistemaOperatiu1.setBackground(new java.awt.Color(160, 160, 160));
        txt_SistemaOperatiu1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(txt_SistemaOperatiu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 150, 31));

        jLabel178.setText("Sistema Operatiu");
        jLabel178.setBackground(new java.awt.Color(255, 153, 51));
        jLabel178.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel178.setForeground(new java.awt.Color(0, 0, 0));
        jPanel21.add(jLabel178, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 151, 30));

        Grups15.setText("Servidor / Informació Servidor");
        Grups15.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups15.setForeground(new java.awt.Color(4, 72, 210));

        jButtonGuardarSer1.setText("Guardar");
        jButtonGuardarSer1.setBackground(new java.awt.Color(160, 160, 160));
        jButtonGuardarSer1.setBorder(null);
        jButtonGuardarSer1.setBorderPainted(false);
        jButtonGuardarSer1.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonGuardarSer1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuardarSer1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarSer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarSer1MouseClicked(evt);
            }
        });
        jButtonGuardarSer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarSer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashInfoServidorLayout = new javax.swing.GroupLayout(DashInfoServidor);
        DashInfoServidor.setLayout(DashInfoServidorLayout);
        DashInfoServidorLayout.setHorizontalGroup(
            DashInfoServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashInfoServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoServidorLayout.createSequentialGroup()
                        .addComponent(Grups15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1125, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashInfoServidorLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jButtonGuardarSer1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashInfoServidorLayout.setVerticalGroup(
            DashInfoServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashInfoServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups15)
                .addGap(57, 57, 57)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGuardarSer1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        DashNouServidor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_modelSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, 30));

        jLabel155.setText("Data ingrés");
        jLabel155.setBackground(new java.awt.Color(255, 153, 51));
        jLabel155.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel155.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, 25));

        jLabel156.setText("Marca");
        jLabel156.setBackground(new java.awt.Color(255, 153, 51));
        jLabel156.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel156.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel157.setText("Model");
        jLabel157.setBackground(new java.awt.Color(255, 153, 51));
        jLabel157.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel157.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 151, 30));

        jLabel158.setText("Nom");
        jLabel158.setBackground(new java.awt.Color(0, 0, 0));
        jLabel158.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel158.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 25));

        jLabel159.setText("Tipus");
        jLabel159.setBackground(new java.awt.Color(255, 153, 51));
        jLabel159.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 25));

        jLabel160.setText("Número Serie");
        jLabel160.setBackground(new java.awt.Color(255, 153, 51));
        jLabel160.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel160.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        jLabel161.setText("Observacions");
        jLabel161.setBackground(new java.awt.Color(255, 153, 51));
        jLabel161.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, -1, 30));

        ComboTipusSer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tèrmica", "Làser", "Multifunció", "Plotter", "3D", "Etiquetes" }));
        ComboTipusSer.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(ComboTipusSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 151, 30));

        ComboEstatSer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatSer.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(ComboEstatSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 26));

        txt_nomSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_nomSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, 31));

        txt_NumeroSerieSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_NumeroSerieSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_NumeroSerieSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_NumeroSerieSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 31));

        txt_marcaSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_marcaSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txt_observacionsSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsSer.setForeground(new java.awt.Color(0, 0, 0));
        txt_observacionsSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_observacionsSerActionPerformed(evt);
            }
        });
        jPanel20.add(txt_observacionsSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 186, 110));

        jLabel162.setText("Adquisicó");
        jLabel162.setBackground(new java.awt.Color(255, 153, 51));
        jLabel162.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel162.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, -1, 30));

        jLabel163.setText("Estat");
        jLabel163.setBackground(new java.awt.Color(255, 153, 51));
        jLabel163.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, 30));

        jRadioButtonRentingSer.setText("Renting");
        jRadioButtonRentingSer.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jRadioButtonRentingSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jRadioButtonCompraSer.setText("Compra");
        jRadioButtonCompraSer.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jRadioButtonCompraSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 150, -1, -1));

        dataIngresSer.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel20.add(dataIngresSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, -1, -1));

        jLabel164.setText("Ubicació");
        jLabel164.setBackground(new java.awt.Color(255, 153, 51));
        jLabel164.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 25));

        jLabel165.setText("IP");
        jLabel165.setBackground(new java.awt.Color(255, 153, 51));
        jLabel165.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 151, 30));

        txt_numeroSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_numeroSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 150, 31));

        txt_ubicacioSer.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_ubicacioSer.setBackground(new java.awt.Color(160, 160, 160));
        txt_ubicacioSer.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_ubicacioSer, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 150, 31));

        txt_SistemaOperatiu.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_SistemaOperatiu.setBackground(new java.awt.Color(160, 160, 160));
        txt_SistemaOperatiu.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(txt_SistemaOperatiu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 150, 31));

        jLabel166.setText("Sistema Operatiu");
        jLabel166.setBackground(new java.awt.Color(255, 153, 51));
        jLabel166.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(0, 0, 0));
        jPanel20.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 151, 30));

        Grups14.setText("Servidor / Nou Servidor");
        Grups14.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups14.setForeground(new java.awt.Color(4, 72, 210));

        jButtonGuardarSer.setText("Guardar");
        jButtonGuardarSer.setBackground(new java.awt.Color(160, 160, 160));
        jButtonGuardarSer.setBorder(null);
        jButtonGuardarSer.setBorderPainted(false);
        jButtonGuardarSer.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonGuardarSer.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGuardarSer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarSer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarSerMouseClicked(evt);
            }
        });
        jButtonGuardarSer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarSerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashNouServidorLayout = new javax.swing.GroupLayout(DashNouServidor);
        DashNouServidor.setLayout(DashNouServidorLayout);
        DashNouServidorLayout.setHorizontalGroup(
            DashNouServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashNouServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouServidorLayout.createSequentialGroup()
                        .addComponent(Grups14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashNouServidorLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jButtonGuardarSer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashNouServidorLayout.setVerticalGroup(
            DashNouServidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouServidorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups14)
                .addGap(57, 57, 57)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGuardarSer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        DashNouImpresora.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_modelImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, 30));

        jLabel116.setText("Data ingrés");
        jLabel116.setBackground(new java.awt.Color(255, 153, 51));
        jLabel116.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, 25));

        jLabel134.setText("Marca");
        jLabel134.setBackground(new java.awt.Color(255, 153, 51));
        jLabel134.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel135.setText("Model");
        jLabel135.setBackground(new java.awt.Color(255, 153, 51));
        jLabel135.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 151, 30));

        jLabel136.setText("Nom");
        jLabel136.setBackground(new java.awt.Color(0, 0, 0));
        jLabel136.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 25));

        jLabel137.setText("Tipus");
        jLabel137.setBackground(new java.awt.Color(255, 153, 51));
        jLabel137.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 25));

        jLabel138.setText("Número Serie");
        jLabel138.setBackground(new java.awt.Color(255, 153, 51));
        jLabel138.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        jLabel139.setText("Observacions");
        jLabel139.setBackground(new java.awt.Color(255, 153, 51));
        jLabel139.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, 30));

        ComboTipusImp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tèrmica", "Làser", "Multifunció", "Plotter", "3D", "Etiquetes" }));
        ComboTipusImp.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(ComboTipusImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 151, 30));

        ComboEstatImp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatImp.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(ComboEstatImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 26));

        txt_nomImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_nomImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, 31));

        txt_NumeroSerieImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_NumeroSerieImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_NumeroSerieImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_NumeroSerieImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 31));

        txt_marcaImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_marcaImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txt_observacionsImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_observacionsImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 186, 110));

        jLabel140.setText("Adquisicó");
        jLabel140.setBackground(new java.awt.Color(255, 153, 51));
        jLabel140.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, 30));

        jLabel141.setText("Estat");
        jLabel141.setBackground(new java.awt.Color(255, 153, 51));
        jLabel141.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, 30));

        jRadioButtonRentingImp.setText("Renting");
        jRadioButtonRentingImp.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jRadioButtonRentingImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jRadioButtonCompraImp.setText("Compra");
        jRadioButtonCompraImp.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jRadioButtonCompraImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        dataIngresImp.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel18.add(dataIngresImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jLabel142.setText("Departartament Assignat");
        jLabel142.setBackground(new java.awt.Color(255, 153, 51));
        jLabel142.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 25));

        jLabel143.setText("IP");
        jLabel143.setBackground(new java.awt.Color(255, 153, 51));
        jLabel143.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 151, 30));

        txt_numeroImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_numeroImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 150, 31));

        txt_departamentImp.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_departamentImp.setBackground(new java.awt.Color(160, 160, 160));
        txt_departamentImp.setForeground(new java.awt.Color(0, 0, 0));
        jPanel18.add(txt_departamentImp, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 150, 31));

        Grups12.setText("Impresora / Nou Impresora");
        Grups12.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups12.setForeground(new java.awt.Color(4, 72, 210));

        jButtonActualitzarImp.setText("Guardar");
        jButtonActualitzarImp.setBackground(new java.awt.Color(160, 160, 160));
        jButtonActualitzarImp.setBorder(null);
        jButtonActualitzarImp.setBorderPainted(false);
        jButtonActualitzarImp.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonActualitzarImp.setForeground(new java.awt.Color(0, 0, 0));
        jButtonActualitzarImp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonActualitzarImp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonActualitzarImpMouseClicked(evt);
            }
        });
        jButtonActualitzarImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualitzarImpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashNouImpresoraLayout = new javax.swing.GroupLayout(DashNouImpresora);
        DashNouImpresora.setLayout(DashNouImpresoraLayout);
        DashNouImpresoraLayout.setHorizontalGroup(
            DashNouImpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouImpresoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashNouImpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouImpresoraLayout.createSequentialGroup()
                        .addComponent(Grups12)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashNouImpresoraLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jButtonActualitzarImp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashNouImpresoraLayout.setVerticalGroup(
            DashNouImpresoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouImpresoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups12)
                .addGap(57, 57, 57)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActualitzarImp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );

        DashNouTelefon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_modelTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, 30));

        jLabel106.setText("Data ingrés");
        jLabel106.setBackground(new java.awt.Color(255, 153, 51));
        jLabel106.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, 25));

        jLabel107.setText("Marca");
        jLabel107.setBackground(new java.awt.Color(255, 153, 51));
        jLabel107.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel108.setText("Model");
        jLabel108.setBackground(new java.awt.Color(255, 153, 51));
        jLabel108.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 151, 30));

        jLabel109.setText("Nom");
        jLabel109.setBackground(new java.awt.Color(0, 0, 0));
        jLabel109.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 25));

        jLabel110.setText("Tipus");
        jLabel110.setBackground(new java.awt.Color(255, 153, 51));
        jLabel110.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, 25));

        jLabel111.setText("Número Serie");
        jLabel111.setBackground(new java.awt.Color(255, 153, 51));
        jLabel111.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        jLabel112.setText("Observacions");
        jLabel112.setBackground(new java.awt.Color(255, 153, 51));
        jLabel112.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, 30));

        ComboTipusTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SmartPhone", "Mòbil", "Teléfon" }));
        ComboTipusTel.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(ComboTipusTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 151, 30));

        ComboEstatTel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatTel.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(ComboEstatTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 150, 26));

        txt_nomTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_nomTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, 31));

        txt_imeiTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_imeiTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_imeiTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_imeiTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 31));

        txt_marcaTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_marcaTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txt_observacionsTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_observacionsTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 186, 110));

        jLabel113.setText("Adquisicó");
        jLabel113.setBackground(new java.awt.Color(255, 153, 51));
        jLabel113.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, 30));

        jLabel114.setText("Estat");
        jLabel114.setBackground(new java.awt.Color(255, 153, 51));
        jLabel114.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, 30));

        jRadioButtonRentingTel.setText("Renting");
        jRadioButtonRentingTel.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jRadioButtonRentingTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, -1, -1));

        jRadioButtonCompraTel.setText("Compra");
        jRadioButtonCompraTel.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jRadioButtonCompraTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, -1, -1));

        dataIngresTel.setBackground(new java.awt.Color(160, 160, 160));
        jPanel16.add(dataIngresTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jLabel115.setText("Usuari Assignat");
        jLabel115.setBackground(new java.awt.Color(255, 153, 51));
        jLabel115.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 25));

        ComboUsuariAssignatTel.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignatTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignatTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(ComboUsuariAssignatTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 150, 26));

        jLabel125.setText("Número");
        jLabel125.setBackground(new java.awt.Color(255, 153, 51));
        jLabel125.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 151, 30));

        txt_numeroTel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroTel.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroTel.setForeground(new java.awt.Color(0, 0, 0));
        jPanel16.add(txt_numeroTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 150, 31));

        Grups10.setText("Teléfons / Nou Teléfon");
        Grups10.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups10.setForeground(new java.awt.Color(4, 72, 210));

        jButtonRegistarTelefon.setText("Guardar");
        jButtonRegistarTelefon.setBackground(new java.awt.Color(160, 160, 160));
        jButtonRegistarTelefon.setBorder(null);
        jButtonRegistarTelefon.setBorderPainted(false);
        jButtonRegistarTelefon.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonRegistarTelefon.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout DashNouTelefonLayout = new javax.swing.GroupLayout(DashNouTelefon);
        DashNouTelefon.setLayout(DashNouTelefonLayout);
        DashNouTelefonLayout.setHorizontalGroup(
            DashNouTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouTelefonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashNouTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashNouTelefonLayout.createSequentialGroup()
                        .addComponent(Grups10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashNouTelefonLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jButtonRegistarTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashNouTelefonLayout.setVerticalGroup(
            DashNouTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashNouTelefonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups10)
                .addGap(57, 57, 57)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRegistarTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        DashInfoImpresores.setBackground(new java.awt.Color(255, 255, 255));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_modelImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 151, 30));

        jLabel144.setText("Data ingrés");
        jLabel144.setBackground(new java.awt.Color(255, 153, 51));
        jLabel144.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, -1, 25));

        jLabel145.setText("Marca");
        jLabel145.setBackground(new java.awt.Color(255, 153, 51));
        jLabel145.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel146.setText("Model");
        jLabel146.setBackground(new java.awt.Color(255, 153, 51));
        jLabel146.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel146.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 151, 30));

        jLabel147.setText("Nom");
        jLabel147.setBackground(new java.awt.Color(0, 0, 0));
        jLabel147.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel147.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, 25));

        jLabel148.setText("Tipus");
        jLabel148.setBackground(new java.awt.Color(255, 153, 51));
        jLabel148.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, -1, 25));

        jLabel149.setText("Número Serie");
        jLabel149.setBackground(new java.awt.Color(255, 153, 51));
        jLabel149.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 151, 30));

        jLabel150.setText("Observacions");
        jLabel150.setBackground(new java.awt.Color(255, 153, 51));
        jLabel150.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, -1, 30));

        ComboTipusImp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tèrmica", "Làser", "Multifunció", "Plotter", "3D", "Etiquetes" }));
        ComboTipusImp1.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(ComboTipusImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 151, 30));

        ComboEstatImp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatImp1.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(ComboEstatImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 150, 26));

        txt_nomImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_nomImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 150, 31));

        txt_NumeroSerieImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_NumeroSerieImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_NumeroSerieImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_NumeroSerieImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 31));

        txt_marcaImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_marcaImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 150, 30));

        txt_observacionsImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_observacionsImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 230, 186, 110));

        jLabel151.setText("Adquisicó");
        jLabel151.setBackground(new java.awt.Color(255, 153, 51));
        jLabel151.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, 30));

        jLabel152.setText("Estat");
        jLabel152.setBackground(new java.awt.Color(255, 153, 51));
        jLabel152.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, 30));

        jRadioButtonRentingImp1.setText("Renting");
        jRadioButtonRentingImp1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jRadioButtonRentingImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, -1, -1));

        jRadioButtonCompraImp1.setText("Compra");
        jRadioButtonCompraImp1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jRadioButtonCompraImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, -1, -1));

        dataIngresImp1.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel19.add(dataIngresImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 150, -1, -1));

        jLabel153.setText("Departartament Assignat");
        jLabel153.setBackground(new java.awt.Color(255, 153, 51));
        jLabel153.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel153.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, -1, 25));

        jLabel154.setText("IP");
        jLabel154.setBackground(new java.awt.Color(255, 153, 51));
        jLabel154.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 151, 30));

        txt_numeroImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_numeroImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 150, 31));

        txt_departamentImp1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_departamentImp1.setBackground(new java.awt.Color(160, 160, 160));
        txt_departamentImp1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel19.add(txt_departamentImp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 150, 31));

        Grups13.setText("Impresora / Informació Impresora");
        Grups13.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups13.setForeground(new java.awt.Color(4, 72, 210));

        jButtonEditarImp.setText("Actualitzar");
        jButtonEditarImp.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarImp.setBorder(null);
        jButtonEditarImp.setBorderPainted(false);
        jButtonEditarImp.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jButtonEditarImp.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEditarImp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEditarImp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarImpMouseClicked(evt);
            }
        });
        jButtonEditarImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarImpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DashInfoImpresoresLayout = new javax.swing.GroupLayout(DashInfoImpresores);
        DashInfoImpresores.setLayout(DashInfoImpresoresLayout);
        DashInfoImpresoresLayout.setHorizontalGroup(
            DashInfoImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoImpresoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashInfoImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoImpresoresLayout.createSequentialGroup()
                        .addComponent(Grups13)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(DashInfoImpresoresLayout.createSequentialGroup()
                .addGap(478, 478, 478)
                .addComponent(jButtonEditarImp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashInfoImpresoresLayout.setVerticalGroup(
            DashInfoImpresoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashInfoImpresoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups13)
                .addGap(57, 57, 57)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditarImp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        DashInfoTelefon.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_modelTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_modelTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_modelTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_modelTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 151, 30));

        jLabel117.setText("Data ingrés");
        jLabel117.setBackground(new java.awt.Color(255, 153, 51));
        jLabel117.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, -1, 25));

        jLabel118.setText("Marca");
        jLabel118.setBackground(new java.awt.Color(255, 153, 51));
        jLabel118.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel119.setText("Model");
        jLabel119.setBackground(new java.awt.Color(255, 153, 51));
        jLabel119.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 151, 30));

        jLabel120.setText("Nom");
        jLabel120.setBackground(new java.awt.Color(0, 0, 0));
        jLabel120.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, 25));

        jLabel121.setText("Tipus");
        jLabel121.setBackground(new java.awt.Color(255, 153, 51));
        jLabel121.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, 25));

        jLabel122.setText("Número");
        jLabel122.setBackground(new java.awt.Color(255, 153, 51));
        jLabel122.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 151, 30));

        jLabel123.setText("Observacions");
        jLabel123.setBackground(new java.awt.Color(255, 153, 51));
        jLabel123.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, -1, 30));

        ComboTipusTel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SmartPhone", "Mòbil", "Teléfon" }));
        ComboTipusTel1.setBackground(new java.awt.Color(160, 160, 160));
        ComboTipusTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboTipusTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(ComboTipusTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, 151, 30));

        ComboEstatTel1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        ComboEstatTel1.setBackground(new java.awt.Color(160, 160, 160));
        ComboEstatTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboEstatTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(ComboEstatTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 150, 26));

        txt_nomTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_nomTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_nomTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_nomTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 150, 31));

        txt_imeiTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_imeiTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_imeiTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_imeiTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 150, 31));

        txt_marcaTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_marcaTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_marcaTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_marcaTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 150, 30));

        txt_observacionsTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_observacionsTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_observacionsTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_observacionsTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 186, 110));

        jLabel124.setText("Adquisicó");
        jLabel124.setBackground(new java.awt.Color(255, 153, 51));
        jLabel124.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, 30));

        jLabel127.setText("Estat");
        jLabel127.setBackground(new java.awt.Color(255, 153, 51));
        jLabel127.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, 30));

        jRadioButtonRentingTel1.setText("Renting");
        jRadioButtonRentingTel1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonRentingTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonRentingTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jRadioButtonRentingTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, -1));

        jRadioButtonCompraTel1.setText("Compra");
        jRadioButtonCompraTel1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButtonCompraTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jRadioButtonCompraTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jRadioButtonCompraTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        dataIngresTel1.setBackground(new java.awt.Color(160, 160, 160));
        dataIngresTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jPanel17.add(dataIngresTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, -1, -1));

        jLabel130.setText("Usuari Assignat");
        jLabel130.setBackground(new java.awt.Color(255, 153, 51));
        jLabel130.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, 25));

        ComboUsuariAssignatTel1.setBackground(new java.awt.Color(160, 160, 160));
        ComboUsuariAssignatTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        ComboUsuariAssignatTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(ComboUsuariAssignatTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 150, 26));

        txt_numeroTel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txt_numeroTel1.setBackground(new java.awt.Color(160, 160, 160));
        txt_numeroTel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(txt_numeroTel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 150, 31));

        jLabel131.setText("IMEI");
        jLabel131.setBackground(new java.awt.Color(255, 153, 51));
        jLabel131.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jPanel17.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 151, 30));

        Grups11.setText("Teléfons / Informació Teléfon");
        Grups11.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        Grups11.setForeground(new java.awt.Color(4, 72, 210));

        jButtonEditarTelefon.setText("Guardar");
        jButtonEditarTelefon.setBackground(new java.awt.Color(160, 160, 160));
        jButtonEditarTelefon.setBorder(null);
        jButtonEditarTelefon.setBorderPainted(false);
        jButtonEditarTelefon.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jButtonEditarTelefon.setForeground(new java.awt.Color(0, 0, 0));
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

        javax.swing.GroupLayout DashInfoTelefonLayout = new javax.swing.GroupLayout(DashInfoTelefon);
        DashInfoTelefon.setLayout(DashInfoTelefonLayout);
        DashInfoTelefonLayout.setHorizontalGroup(
            DashInfoTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                .addGap(43, 43, 43))
            .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                .addGroup(DashInfoTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Grups11))
                    .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                        .addGap(481, 481, 481)
                        .addComponent(jButtonEditarTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashInfoTelefonLayout.setVerticalGroup(
            DashInfoTelefonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTelefonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Grups11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEditarTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashBoardViewLayout = new javax.swing.GroupLayout(DashBoardView);
        DashBoardView.setLayout(DashBoardViewLayout);
        DashBoardViewLayout.setHorizontalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardViewLayout.createSequentialGroup()
                .addComponent(DashTasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap(913, Short.MAX_VALUE)
                    .addComponent(DashChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(970, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashTriaTasca, javax.swing.GroupLayout.DEFAULT_SIZE, 1134, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoGrup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouGrup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTelefons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashConfiguracio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1188, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouOrdinador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoOrdinador, javax.swing.GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTascaRepeticio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashPerfilUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTascaRepeticio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashGrups, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1188, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashOrdinadors, javax.swing.GroupLayout.DEFAULT_SIZE, 1146, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(DashImpresores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(DashNouImpresora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(DashInfoImpresores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(9, 9, 9)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashServidors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(DashNouServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashInfoServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashGrafiques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        DashBoardViewLayout.setVerticalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashBoardViewLayout.createSequentialGroup()
                .addComponent(DashTasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap(120, Short.MAX_VALUE)
                    .addComponent(DashChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(263, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashTriaTasca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(188, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 194, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoGrup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 194, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouGrup, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 91, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTelefons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashConfiguracio, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 221, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 107, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoOrdinador, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(103, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashInfoTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 112, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap(150, Short.MAX_VALUE)
                    .addComponent(DashPerfilUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNovaTascaRepeticio, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 111, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 222, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashGrups, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 217, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashOrdinadors, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(88, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(DashImpresores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 23, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(DashInfoImpresores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashServidors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(DashNouServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(DashInfoServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashGrafiques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 9, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 1383, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DashBoardView, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(223, 223, 223)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1177, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(232, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DashBoardView, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(124, 124, 124))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(958, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(200, 200, 200)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(808, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1380, 868));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void hideshow(JPanel menushowhide, boolean dashboard, JLabel button) {

        if (dashboard == true) {

            menushowhide.setPreferredSize(new Dimension(50, menushowhide.getHeight()));
            //changeimage(button, "src/images/menu_32px.png");
            ImageIcon config_logo = new ImageIcon("src/images/menu_32px.png");
            //MenuDes.setIcon(config_logo);
            this.repaint();
        } else {

            menushowhide.setPreferredSize(new Dimension(270, menushowhide.getHeight()));
            //changeimage(button, "src/images/back_32px.png");
            ImageIcon config_logo = new ImageIcon("src/images/back_32px.png");
            //MenuDes.setIcon(config_logo);
            this.repaint();

        }

    }

    public void changecolor(JPanel hover, Color rand) {

        hover.setBackground(rand);

    }

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

    private void CloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseMouseClicked

    private void CloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(255, 0, 51));
    }//GEN-LAST:event_CloseMouseEntered

    private void CloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseMouseExited
        // TODO add your handling code here:
        changecolor(ButtonClose, new Color(0, 51, 204));
    }//GEN-LAST:event_CloseMouseExited

    private void MaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseClicked
        // TODO add your handling code here:
        if (this.getExtendedState() != JFPrincipal.MAXIMIZED_BOTH) {
            this.setExtendedState(JFPrincipal.MAXIMIZED_BOTH);

        } else {
            this.setExtendedState(JFPrincipal.NORMAL);

        }
    }//GEN-LAST:event_MaxMouseClicked

    private void MaxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMax, new Color(160, 160, 160));

    }//GEN-LAST:event_MaxMouseEntered

    private void MaxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MaxMouseExited
        // TODO add your handling code here:

        changecolor(ButtonMax, new Color(0, 51, 204));
    }//GEN-LAST:event_MaxMouseExited

    private void MinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:
        changecolor(ButtonMin, new Color(160, 160, 160));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:

        changecolor(ButtonMin, new Color(0, 51, 204));
    }//GEN-LAST:event_MinMouseExited

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

    private void jButtonNomUsuariMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNomUsuariMouseEntered

    private void jButtonNomUsuariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNomUsuariMouseExited

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

    private void jCheckBoxNotificacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacioActionPerformed

    private void jRadioButtonElementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonElementsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonElementsActionPerformed

    private void jRadioButtonUsuarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUsuarisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonUsuarisActionPerformed

    private void txt_cognomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cognomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cognomActionPerformed

    private void ComboNivellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivellActionPerformed

    private void jButtonEditarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarUsuariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarUsuariMouseClicked

    private void jButtonEditarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarUsuariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarUsuariActionPerformed

    private void jButtonRegistarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistarUsuariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarUsuariMouseClicked

    private void jButtonRegistarUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarUsuariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarUsuariActionPerformed

    private void ComboNivell1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivell1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivell1ActionPerformed

    private void jButtonRegistarOrdinadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistarOrdinadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarOrdinadorMouseClicked

    private void jButtonRegistarOrdinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistarOrdinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistarOrdinadorActionPerformed

    private void jButtonEditarOrdinadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarOrdinadorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarOrdinadorMouseClicked

    private void jButtonEditarOrdinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarOrdinadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarOrdinadorActionPerformed

    private void jButtonEditarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarTascaMouseClicked

    }//GEN-LAST:event_jButtonEditarTascaMouseClicked

    private void jButtonEditarTascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTascaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarTascaActionPerformed

    private void jButtonChatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChatMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChatMouseClicked

    private void jButtonChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChatActionPerformed

    private void ComboMesDia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesDia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesDia1ActionPerformed

    private void ComboMes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMes1ActionPerformed

    private void jCheckBoxNotificacio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacio1ActionPerformed

    private void ComboMesDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesDiaActionPerformed

    private void ComboMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboMesActionPerformed

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

    private void jButtonEliminarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarUsuariMouseClicked

    private void jButtonEliminarUsuari(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarUsuari
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarUsuari

    private void txtBuscadorUsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorUsuariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorUsuariActionPerformed

    private void txtBuscadorUsuariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorUsuariKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorUsuariKeyReleased

    private void jButtonEliminarGrupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarGrupMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarGrupMouseClicked

    private void jButtonEliminarGrup(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarGrup
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarGrup

    private void txtBuscadorGrupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorGrupsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorGrupsActionPerformed

    private void txtBuscadorGrupsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorGrupsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorGrupsKeyReleased

    private void jButtonGuardarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarFotoActionPerformed

    private void jButtonEliminarTelefonsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarTelefonsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTelefonsMouseClicked

    private void jButtonEliminarTelefons(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTelefons
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTelefons

    private void txtBuscadorTelefonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorTelefonsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTelefonsActionPerformed

    private void txtBuscadorTelefonsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorTelefonsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTelefonsKeyReleased

    private void jButtonEliminarImpresoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarImpresoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarImpresoresMouseClicked

    private void jButtonEliminarImpresores(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarImpresores
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarImpresores

    private void txtBuscadorImpresoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorImpresoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorImpresoresActionPerformed

    private void txtBuscadorImpresoresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorImpresoresKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorImpresoresKeyReleased

    private void jButtonActualitzarImpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualitzarImpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualitzarImpMouseClicked

    private void jButtonActualitzarImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualitzarImpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualitzarImpActionPerformed

    private void jButtonEditarImpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarImpMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarImpMouseClicked

    private void jButtonEditarImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarImpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarImpActionPerformed

    private void jButtonEliminarServidorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarServidorsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarServidorsMouseClicked

    private void jButtonEliminarServidors(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarServidors
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarServidors

    private void txtBuscadorServidorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorServidorsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorServidorsActionPerformed

    private void txtBuscadorServidorsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorServidorsKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorServidorsKeyReleased

    private void jButtonGuardarSerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarSerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarSerMouseClicked

    private void jButtonGuardarSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarSerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarSerActionPerformed

    private void txt_observacionsSerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_observacionsSerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_observacionsSerActionPerformed

    private void txt_observacionsSer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_observacionsSer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_observacionsSer1ActionPerformed

    private void jButtonGuardarSer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarSer1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarSer1MouseClicked

    private void jButtonGuardarSer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarSer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarSer1ActionPerformed

    private void ComboEstatTasc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEstatTasc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboEstatTasc2ActionPerformed

    private void txt_descripcioTasc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcioTasc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcioTasc2ActionPerformed

    private void jButtonChat1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChat1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChat1MouseClicked

    private void jButtonChat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonChat1ActionPerformed

    private void jCheckBoxNotificacio22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNotificacio22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxNotificacio22ActionPerformed

    private void jButtonCanviarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCanviarFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCanviarFotoActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal2().setVisible(true);
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
    public javax.swing.JComboBox<String> ComboEstatImp;
    public javax.swing.JComboBox<String> ComboEstatImp1;
    public javax.swing.JComboBox<String> ComboEstatSer;
    public javax.swing.JComboBox<String> ComboEstatSer1;
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
    public javax.swing.JComboBox<String> ComboTipusImp;
    public javax.swing.JComboBox<String> ComboTipusImp1;
    public javax.swing.JComboBox<String> ComboTipusSer;
    public javax.swing.JComboBox<String> ComboTipusSer1;
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
    private javax.swing.JPanel DashBoardView;
    public javax.swing.JPanel DashChat;
    public javax.swing.JPanel DashConfiguracio;
    public javax.swing.JPanel DashGrafiques;
    public javax.swing.JPanel DashGrups;
    public javax.swing.JPanel DashImpresores;
    public javax.swing.JPanel DashInfoGrup;
    public javax.swing.JPanel DashInfoImpresores;
    public javax.swing.JPanel DashInfoOrdinador;
    public javax.swing.JPanel DashInfoServidor;
    public javax.swing.JPanel DashInfoTasca;
    public javax.swing.JPanel DashInfoTascaRepeticio;
    public javax.swing.JPanel DashInfoTelefon;
    public javax.swing.JPanel DashInfoUsuari;
    public javax.swing.JPanel DashNouGrup;
    public javax.swing.JPanel DashNouImpresora;
    public javax.swing.JPanel DashNouOrdinador;
    public javax.swing.JPanel DashNouServidor;
    public javax.swing.JPanel DashNouTelefon;
    public javax.swing.JPanel DashNouUsuari;
    public javax.swing.JPanel DashNovaTasca;
    public javax.swing.JPanel DashNovaTascaRepeticio;
    public javax.swing.JPanel DashOrdinadors;
    public javax.swing.JPanel DashPerfilUsuari;
    public javax.swing.JPanel DashServidors;
    public javax.swing.JPanel DashTasques;
    public javax.swing.JPanel DashTelefons;
    public javax.swing.JPanel DashTriaTasca;
    public javax.swing.JPanel DashUsuaris;
    private javax.swing.JLabel Enrera;
    private javax.swing.JLabel Enrera1;
    private javax.swing.JLabel Grups;
    private javax.swing.JLabel Grups1;
    private javax.swing.JLabel Grups10;
    private javax.swing.JLabel Grups11;
    private javax.swing.JLabel Grups12;
    private javax.swing.JLabel Grups13;
    private javax.swing.JLabel Grups14;
    private javax.swing.JLabel Grups15;
    private javax.swing.JLabel Grups2;
    private javax.swing.JLabel Grups3;
    private javax.swing.JLabel Grups4;
    private javax.swing.JLabel Grups5;
    private javax.swing.JLabel Grups6;
    private javax.swing.JLabel Grups7;
    private javax.swing.JLabel Grups8;
    private javax.swing.JLabel Grups9;
    public javax.swing.JPanel Header;
    public javax.swing.JPanel IconMinMaxClose;
    public javax.swing.JLabel Max;
    public javax.swing.JPanel Menu;
    public javax.swing.JLabel Min;
    public com.bolivia.label.CLabel cLabelFoto;
    public com.github.lgooddatepicker.components.DatePicker dataIngresImp;
    public com.github.lgooddatepicker.components.DatePicker dataIngresImp1;
    public com.github.lgooddatepicker.components.DatePicker dataIngresOrdinador;
    public com.github.lgooddatepicker.components.DatePicker dataIngresOrdinador1;
    public com.github.lgooddatepicker.components.DatePicker dataIngresSer;
    public com.github.lgooddatepicker.components.DatePicker dataIngresSer1;
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
    public javax.swing.JButton jButtonActualitzarImp;
    public javax.swing.JButton jButtonAfegir;
    public javax.swing.JButton jButtonAfegir1;
    public javax.swing.JButton jButtonAfegirElement;
    public javax.swing.JButton jButtonAfegirElement1;
    public javax.swing.JButton jButtonAfegirUsuari;
    public javax.swing.JButton jButtonAfegirUsuari1;
    public javax.swing.JButton jButtonAfegirUsuari2;
    public javax.swing.JButton jButtonAfegirUsuari3;
    public javax.swing.JButton jButtonCanviarContrasenya;
    public javax.swing.JButton jButtonCanviarFoto;
    public javax.swing.JButton jButtonChat;
    public javax.swing.JButton jButtonChat1;
    public javax.swing.JButton jButtonEditarImp;
    public javax.swing.JButton jButtonEditarOrdinador;
    public javax.swing.JButton jButtonEditarTasca;
    public javax.swing.JButton jButtonEditarTascaRecurrent;
    public javax.swing.JButton jButtonEditarTelefon;
    public javax.swing.JButton jButtonEditarUsuari;
    public javax.swing.JButton jButtonEliminarGrup;
    public javax.swing.JButton jButtonEliminarImpresores;
    public javax.swing.JButton jButtonEliminarOrdinadors;
    public javax.swing.JButton jButtonEliminarServidors;
    public javax.swing.JButton jButtonEliminarTasca;
    public javax.swing.JButton jButtonEliminarTelefons;
    public javax.swing.JButton jButtonEliminarUsuari;
    public javax.swing.JButton jButtonExportar;
    public javax.swing.JButton jButtonGuardarFoto;
    public javax.swing.JButton jButtonGuardarSer;
    public javax.swing.JButton jButtonGuardarSer1;
    public javax.swing.JButton jButtonImportar;
    public javax.swing.JLabel jButtonNomUsuari;
    public javax.swing.JButton jButtonNouGrup;
    public javax.swing.JButton jButtonNouImpresora;
    public javax.swing.JButton jButtonNouOrdinador;
    public javax.swing.JButton jButtonNouServidor;
    public javax.swing.JButton jButtonNouTelefon;
    public javax.swing.JButton jButtonNouUsuari;
    public javax.swing.JButton jButtonNovaTasca;
    public javax.swing.JButton jButtonRegistarGrup;
    public javax.swing.JButton jButtonRegistarGrup1;
    public javax.swing.JButton jButtonRegistarOrdinador;
    public javax.swing.JButton jButtonRegistarTasca;
    public javax.swing.JButton jButtonRegistarTelefon;
    public javax.swing.JButton jButtonRegistarUsuari;
    public javax.swing.JPanel jButtonTasca;
    public javax.swing.JPanel jButtonTasca1;
    public javax.swing.JLabel jButtonTascaNormal;
    public javax.swing.JLabel jButtonTascaNormal12;
    public javax.swing.JLabel jButtonTascaRec;
    public javax.swing.JLabel jButtonTascaRepeticio;
    private javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JCheckBox jCheckBox2FA;
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
    public javax.swing.JCheckBox jCheckBoxNotificacio22;
    public javax.swing.JCheckBox jCheckBoxSo;
    public javax.swing.JComboBox<String> jComboBoxDashTasquesUsuari;
    public javax.swing.JComboBox<String> jComboBoxGrafic;
    public javax.swing.JComboBox<String> jComboBoxTipus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
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
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
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
    public javax.swing.JLabel jLabelSetmanes3;
    public javax.swing.JLabel jLabelvegades;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JPanel jPanelTipus;
    public javax.swing.JRadioButton jRadioButton2D;
    public javax.swing.JRadioButton jRadioButton3D;
    public javax.swing.JRadioButton jRadioButtonAcabar;
    public javax.swing.JRadioButton jRadioButtonAcabar1;
    public javax.swing.JRadioButton jRadioButtonAnual;
    public javax.swing.JRadioButton jRadioButtonAnual1;
    public javax.swing.JRadioButton jRadioButtonCompraImp;
    public javax.swing.JRadioButton jRadioButtonCompraImp1;
    public javax.swing.JRadioButton jRadioButtonCompraOrdinador;
    public javax.swing.JRadioButton jRadioButtonCompraOrdinador1;
    public javax.swing.JRadioButton jRadioButtonCompraSer;
    public javax.swing.JRadioButton jRadioButtonCompraSer1;
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
    public javax.swing.JRadioButton jRadioButtonRentingImp;
    public javax.swing.JRadioButton jRadioButtonRentingImp1;
    public javax.swing.JRadioButton jRadioButtonRentingOrdinador;
    public javax.swing.JRadioButton jRadioButtonRentingOrdinador1;
    public javax.swing.JRadioButton jRadioButtonRentingSer;
    public javax.swing.JRadioButton jRadioButtonRentingSer1;
    public javax.swing.JRadioButton jRadioButtonRentingTel;
    public javax.swing.JRadioButton jRadioButtonRentingTel1;
    public javax.swing.JRadioButton jRadioButtonSetmanal;
    public javax.swing.JRadioButton jRadioButtonSetmanal1;
    public javax.swing.JRadioButton jRadioButtonUsuaris;
    private javax.swing.JScrollPane jScrollPane;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JScrollPane jScrollPaneElements;
    public javax.swing.JScrollPane jScrollPaneElements1;
    public javax.swing.JScrollPane jScrollPaneUsuaris;
    public javax.swing.JScrollPane jScrollPane_Grups;
    public javax.swing.JScrollPane jScrollPane_Impresores;
    public javax.swing.JScrollPane jScrollPane_Ordiandors;
    public javax.swing.JScrollPane jScrollPane_Servidors;
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
    public javax.swing.JTable jTableGrafica;
    public javax.swing.JTable jTableInfoTasca;
    public javax.swing.JTable jTableInfoTasca1;
    public javax.swing.JTable jTable_Grups;
    public javax.swing.JTable jTable_Impresores;
    public javax.swing.JTable jTable_Ordinadors;
    public javax.swing.JTable jTable_Servidors;
    public javax.swing.JTable jTable_Tasques;
    public javax.swing.JTable jTable_Telefons;
    public javax.swing.JTable jTable_Usuaris;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JLabel jTextFieldTasquesAssignades;
    public javax.swing.JLabel jTextFieldTasquesPendents;
    public javax.swing.JLabel jTextFieldTasquesTotals;
    public javax.swing.JTextArea jTextGrupUsuaris;
    public javax.swing.JTextArea jTextGrupUsuaris1;
    public javax.swing.JTextArea jTextUsuariAssignat;
    public javax.swing.JTextArea jTextUsuariAssignat1;
    public javax.swing.JTextArea jTextUsuariAssignat2;
    public javax.swing.JTextArea jTextUsuariAssignat3;
    public javax.swing.JToggleButton jToggleButtonActualitzarGrafic;
    public keeptoo.KGradientPanel kGradientPanel1;
    public keeptoo.KGradientPanel kGradientPanel2;
    public keeptoo.KGradientPanel kGradientPanel3;
    public javax.swing.JLabel lbTitle2;
    public javax.swing.JLabel lbTitle4;
    public javax.swing.JLabel lbTitle5;
    private javax.swing.JPanel menus;
    public javax.swing.JPanel panelMenu;
    public javax.swing.JTextField txtBuscadorGrups;
    public javax.swing.JTextField txtBuscadorImpresores;
    public javax.swing.JTextField txtBuscadorOrdinadors;
    public javax.swing.JTextField txtBuscadorServidors;
    public javax.swing.JTextField txtBuscadorTasques;
    public javax.swing.JTextField txtBuscadorTelefons;
    public javax.swing.JTextField txtBuscadorUsuari;
    public javax.swing.JTextField txtNomImatge;
    public javax.swing.JTextField txt_NumeroSerieImp;
    public javax.swing.JTextField txt_NumeroSerieImp1;
    public javax.swing.JTextField txt_NumeroSerieSer;
    public javax.swing.JTextField txt_NumeroSerieSer1;
    public javax.swing.JTextField txt_SistemaOperatiu;
    public javax.swing.JTextField txt_SistemaOperatiu1;
    public javax.swing.JTextField txt_cerca;
    public javax.swing.JTextField txt_cerca1;
    public javax.swing.JTextField txt_cerca2;
    public javax.swing.JTextField txt_cognom;
    public javax.swing.JTextField txt_cognom1;
    public javax.swing.JTextField txt_departamentImp;
    public javax.swing.JTextField txt_departamentImp1;
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
    public javax.swing.JTextField txt_marcaImp;
    public javax.swing.JTextField txt_marcaImp1;
    public javax.swing.JTextField txt_marcaSer;
    public javax.swing.JTextField txt_marcaSer1;
    public javax.swing.JTextField txt_marcaTel;
    public javax.swing.JTextField txt_marcaTel1;
    public javax.swing.JTextField txt_model;
    public javax.swing.JTextField txt_model1;
    public javax.swing.JTextField txt_modelImp;
    public javax.swing.JTextField txt_modelImp1;
    public javax.swing.JTextField txt_modelSer;
    public javax.swing.JTextField txt_modelSer1;
    public javax.swing.JTextField txt_modelTel;
    public javax.swing.JTextField txt_modelTel1;
    public javax.swing.JTextField txt_nom;
    public javax.swing.JTextField txt_nom1;
    public javax.swing.JTextField txt_nomElem;
    public javax.swing.JTextField txt_nomElem1;
    public javax.swing.JTextField txt_nomGrup;
    public javax.swing.JTextField txt_nomGrup1;
    public javax.swing.JTextField txt_nomImp;
    public javax.swing.JTextField txt_nomImp1;
    public javax.swing.JTextField txt_nomSer;
    public javax.swing.JTextField txt_nomSer1;
    public javax.swing.JTextField txt_nomTel;
    public javax.swing.JTextField txt_nomTel1;
    public javax.swing.JTextField txt_numeroImp;
    public javax.swing.JTextField txt_numeroImp1;
    public javax.swing.JTextField txt_numeroSer;
    public javax.swing.JTextField txt_numeroSer1;
    public javax.swing.JTextField txt_numeroTel;
    public javax.swing.JTextField txt_numeroTel1;
    public javax.swing.JTextField txt_numserie;
    public javax.swing.JTextField txt_numserie1;
    public javax.swing.JTextField txt_observacions;
    public javax.swing.JTextField txt_observacions1;
    public javax.swing.JTextField txt_observacionsImp;
    public javax.swing.JTextField txt_observacionsImp1;
    public javax.swing.JTextField txt_observacionsSer;
    public javax.swing.JTextField txt_observacionsSer1;
    public javax.swing.JTextField txt_observacionsTel;
    public javax.swing.JTextField txt_observacionsTel1;
    public javax.swing.JTextField txt_telefon;
    public javax.swing.JTextField txt_telefon1;
    public javax.swing.JTextField txt_titolTasc;
    public javax.swing.JTextField txt_titolTasc1;
    public javax.swing.JTextField txt_titolTasc2;
    public javax.swing.JTextField txt_titolTasc3;
    public javax.swing.JTextField txt_ubicacioSer;
    public javax.swing.JTextField txt_ubicacioSer1;
    public javax.swing.JTextField txt_usuari;
    public javax.swing.JTextField txt_usuari1;
    // End of variables declaration//GEN-END:variables
}
