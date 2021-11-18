/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorTasques;
import Model.ConsultesTasques;
import Model.Tasques;
import clases.Conexio;
import com.github.lgooddatepicker.components.DateTimePicker;
import java.sql.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import static javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.TableRowSorter;
import ventanas.Contrasenya;
import java.awt.event.*;
import javax.swing.JButton;

/**
 *
 * @author Victor
 */
public class JFPrincipal extends javax.swing.JFrame  {

    boolean a = true;
   
    private int xMouse, yMouse;
    
    public int id;
    
    public int id_tasca = 0;
    
    public static String user_update="", element_update="", tasca_update = "";
   
    public boolean jf = false;
   
    
    /**
     * Creates new form Ventana_Tasques2
     */
    public JFPrincipal() {        
        
        
        
        initComponents();
        
       //setVisible(true);
        
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
        
        
        ImageIcon enrera_logo = new ImageIcon("src/images/icons8-left-35.png");
        Enrera.setIcon(enrera_logo);
        this.repaint();
        
       /* jTable_Tasques.addMouseListener(new MouseAdapter() {
             @Override
                 public void mouseClicked(MouseEvent e) {
                    System.out.println("HELLOO");
                     
                     DefaultTableModel model_tasques2 = new DefaultTableModel();
                model_tasques2 = (DefaultTableModel) jTable_Tasques.getModel();
                Tasques modTasques = new Tasques();
                
                
                int fila_point = jTable_Tasques.rowAtPoint(e.getPoint());
                int columna_point = jTable_Tasques.columnAtPoint(e.getPoint());
                int columna = 1;
                
                
                  
                
                
                System.out.println("Fila" + fila_point);
                System.out.println("Columna" + columna_point);
                jTable_Tasques.repaint();
                jTable_Tasques.updateUI();
                //vis.DashNovaTasca.setVisible(true);
                if (fila_point > -1 && columna_point > 0) {

                    System.out.println("Columna");
                    tasca_update = model_tasques2.getValueAt(fila_point, columna).toString();                    
                    //DashTasques.show();
                   // DashInfoTasca.show();
                    DashInfoTasca.setVisible(true);
                    DashTasques.setVisible(false);
          
                   
                    
                    informacioTasca(tasca_update);
                    
                    System.out.println("Fila");
                    System.out.println("tasca_update:" + tasca_update);
                 
                }

            }

        });*/
        
     

    }
    
    /* public void informacioTasca(String tasca) {

             
        Tasques mod = new Tasques();
        ConsultesTasques modC = new ConsultesTasques();
        ConsultesTasques modCTasques = new ConsultesTasques();
        JFPrincipal vistPrincipal = new JFPrincipal();
        ControladorTasques con = new ControladorTasques(mod, modCTasques, vistPrincipal);
        mod.setTitol(tasca);        
        modC.informacioTasca(mod);        
        System.out.println("Prioritat" + mod.getPrioritat());
        System.out.println("Data" + mod.getData());
        txt_titolTasc2.setText(mod.getTitol());
        txt_usuariTasc2.setText(mod.getUsuariAssignat());
        txt_descripcioTasc2.setText(mod.getDescripcio());
        txt_dataTasc2.setText(mod.getData());
        ComboPrioritatTasc2.setSelectedItem(mod.getPrioritat());
        ComboEstatTasc2.setSelectedItem(mod.getEstat());
        ComboEstatTasc2.setSelectedItem(mod.getEstat());       
        txt_titolTasc2.setText(mod.getTitol());
   
        con.natejar();
       
        
        
        
    }*/
    

   
    
    
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
        Menu = new javax.swing.JPanel();
        MenuIcon = new javax.swing.JPanel();
        LiniaHideMenu = new javax.swing.JPanel();
        HideMenu = new javax.swing.JPanel();
        MenuDes = new javax.swing.JLabel();
        LiniaConfiguracio = new javax.swing.JPanel();
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
        N_LiniaTasques = new javax.swing.JPanel();
        N_Tasques = new javax.swing.JPanel();
        btn_Tasques = new javax.swing.JLabel();
        N_Elements = new javax.swing.JPanel();
        btn_Elements = new javax.swing.JLabel();
        N_Usuaris = new javax.swing.JPanel();
        btn_Usuaris = new javax.swing.JLabel();
        N_Grups = new javax.swing.JPanel();
        btn_Grups = new javax.swing.JLabel();
        N_Configuracio = new javax.swing.JPanel();
        btn_Configuracio = new javax.swing.JLabel();
        DashBoardView = new javax.swing.JPanel();
        DashTasques = new javax.swing.JPanel();
        Contador4 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtBuscadorTasques = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jButtonNovaTasca = new javax.swing.JButton();
        jButtonEliminarTasca = new javax.swing.JButton();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane_Tasques = new javax.swing.JScrollPane();
        jTable_Tasques = new javax.swing.JTable();
        DashElements = new javax.swing.JPanel();
        Contador2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_buscador1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        btnNovaTasca = new javax.swing.JButton();
        Eliminar_Element = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane_Elements = new javax.swing.JScrollPane();
        jTable_Elements = new javax.swing.JTable();
        DashUsuaris = new javax.swing.JPanel();
        Contador1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_buscador = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Nou_Usuari = new javax.swing.JButton();
        Eliminar_Usuari = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane_Usuaris = new javax.swing.JScrollPane();
        jTable_Usuaris = new javax.swing.JTable();
        DashConfiguracio = new javax.swing.JPanel();
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
        Guardar = new javax.swing.JButton();
        Enrera = new javax.swing.JLabel();
        Contrasenya = new javax.swing.JButton();
        DashNouUsuari = new javax.swing.JPanel();
        txt_usuari1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton_Registar = new javax.swing.JButton();
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
        DashNouElement = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        txt_model = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jButton_RegistarElm = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        ComboTipus = new javax.swing.JComboBox<>();
        ComboEstatElem = new javax.swing.JComboBox<>();
        txt_nomElem = new javax.swing.JTextField();
        txt_numserie = new javax.swing.JTextField();
        txt_usuariassignat = new javax.swing.JTextField();
        txt_marca = new javax.swing.JTextField();
        txt_observacions = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        DashInfoElement = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        txt_numeroserieElem2 = new javax.swing.JTextField();
        txt_nomElem2 = new javax.swing.JTextField();
        txt_usuariElem2 = new javax.swing.JTextField();
        txt_marcaElem2 = new javax.swing.JTextField();
        txt_modelElem2 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        ComboEstatElem2 = new javax.swing.JComboBox<>();
        ComboTipusElem2 = new javax.swing.JComboBox<>();
        Guardar2 = new javax.swing.JButton();
        Enrera1 = new javax.swing.JLabel();
        txt_observacionsElem2 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        DashNovaTasca = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jButtonRegistarTasca = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        ComboPrioritatTasc = new javax.swing.JComboBox<>();
        txt_titolTasc = new javax.swing.JTextField();
        txt_usuariassignatTasc = new javax.swing.JTextField();
        txt_descripcioTasc = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        dateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel63 = new javax.swing.JLabel();
        ComboEstatElem3 = new javax.swing.JComboBox<>();
        DashInfoTasca = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        txt_titolTasc2 = new javax.swing.JTextField();
        txt_usuariTasc2 = new javax.swing.JTextField();
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

        MenuIcon.add(Configuracio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 50, 50));

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

        MenuIcon.add(Tasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 50, 50));

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
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuIcon.add(LiniaTasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 50, 5));

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

        MenuIcon.add(Elements, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 50, 50));

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
        Usuaris.add(btnUsuaris, java.awt.BorderLayout.CENTER);

        MenuIcon.add(Usuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 50, 50));

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

        MenuIcon.add(LiniaGrups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 50, 5));

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

        MenuIcon.add(Grups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 50, 50));

        Menu.add(MenuIcon, java.awt.BorderLayout.LINE_START);

        MenuHide.setBackground(new java.awt.Color(255, 153, 51));
        MenuHide.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        N_LiniaTasques.setBackground(new java.awt.Color(255, 153, 0));
        N_LiniaTasques.setPreferredSize(new java.awt.Dimension(50, 5));

        javax.swing.GroupLayout N_LiniaTasquesLayout = new javax.swing.GroupLayout(N_LiniaTasques);
        N_LiniaTasques.setLayout(N_LiniaTasquesLayout);
        N_LiniaTasquesLayout.setHorizontalGroup(
            N_LiniaTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        N_LiniaTasquesLayout.setVerticalGroup(
            N_LiniaTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        MenuHide.add(N_LiniaTasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 220, 5));

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

        btn_Tasques.setBackground(new java.awt.Color(255, 255, 255));
        btn_Tasques.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Tasques.setForeground(new java.awt.Color(255, 255, 255));
        btn_Tasques.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Tasques.setText("  Tasques");
        btn_Tasques.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_TasquesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_TasquesMouseExited(evt);
            }
        });
        N_Tasques.add(btn_Tasques, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Tasques, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 220, 50));

        N_Elements.setBackground(new java.awt.Color(255, 153, 51));
        N_Elements.setLayout(new java.awt.BorderLayout());

        btn_Elements.setBackground(new java.awt.Color(255, 255, 255));
        btn_Elements.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Elements.setForeground(new java.awt.Color(255, 255, 255));
        btn_Elements.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Elements.setText("  Elements");
        btn_Elements.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_ElementsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_ElementsMouseExited(evt);
            }
        });
        N_Elements.add(btn_Elements, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Elements, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 50));

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

        btn_Usuaris.setBackground(new java.awt.Color(255, 153, 51));
        btn_Usuaris.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Usuaris.setForeground(new java.awt.Color(255, 255, 255));
        btn_Usuaris.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Usuaris.setText("  Usuaris");
        btn_Usuaris.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_UsuarisMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_UsuarisMouseExited(evt);
            }
        });
        N_Usuaris.add(btn_Usuaris, java.awt.BorderLayout.CENTER);

        MenuHide.add(N_Usuaris, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 220, 50));

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

        btn_Grups.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Grups.setText("  Grups");
        btn_Grups.setBackground(new java.awt.Color(255, 153, 51));
        btn_Grups.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_Grups.setForeground(new java.awt.Color(255, 255, 255));
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

        MenuHide.add(N_Grups, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 220, 50));

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

        MenuHide.add(N_Configuracio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 220, 50));

        Menu.add(MenuHide, java.awt.BorderLayout.CENTER);

        getContentPane().add(Menu, java.awt.BorderLayout.LINE_START);

        DashBoardView.setBackground(new java.awt.Color(255, 255, 255));

        DashTasques.setBackground(new java.awt.Color(255, 255, 255));
        DashTasques.setForeground(new java.awt.Color(51, 51, 255));

        Contador4.setBackground(new java.awt.Color(255, 153, 51));
        Contador4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel51.setBackground(new java.awt.Color(255, 255, 255));
        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Tasques Totals");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Tasques Gestionades");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

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

        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Buscar :");

        jButtonNovaTasca.setText("Nou");

        jButtonEliminarTasca.setText("Eliminar");
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButtonNovaTasca)
                .addGap(18, 18, 18)
                .addComponent(jButtonEliminarTasca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jButtonEliminarTasca)
                    .addComponent(jButtonNovaTasca))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTextField10.setBackground(new java.awt.Color(255, 153, 51));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField11.setBackground(new java.awt.Color(255, 153, 51));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField12.setBackground(new java.awt.Color(255, 153, 51));
        jTextField12.setForeground(new java.awt.Color(0, 0, 0));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Tasques Asignades");

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
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador4Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador4Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel54)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel52)))
                        .addGap(0, 64, Short.MAX_VALUE))
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
                .addGroup(Contador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane_Tasques.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Tasques.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_Tasques.setViewportView(jTable_Tasques);

        javax.swing.GroupLayout DashTasquesLayout = new javax.swing.GroupLayout(DashTasques);
        DashTasques.setLayout(DashTasquesLayout);
        DashTasquesLayout.setHorizontalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Tasques)
        );
        DashTasquesLayout.setVerticalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createSequentialGroup()
                .addComponent(Contador4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE))
        );

        DashElements.setBackground(new java.awt.Color(255, 255, 255));
        DashElements.setForeground(new java.awt.Color(51, 51, 255));

        Contador2.setBackground(new java.awt.Color(255, 153, 51));
        Contador2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Tasques Totals");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Tasques Gestionades");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        txt_buscador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscador1ActionPerformed(evt);
            }
        });
        txt_buscador1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscador1KeyReleased(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Buscar :");

        btnNovaTasca.setText("Nou");

        Eliminar_Element.setText("Eliminar");
        Eliminar_Element.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Eliminar_ElementMouseClicked(evt);
            }
        });
        Eliminar_Element.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_ElementActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnNovaTasca)
                .addGap(18, 18, 18)
                .addComponent(Eliminar_Element)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscador1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(Eliminar_Element)
                    .addComponent(btnNovaTasca))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jTextField2.setBackground(new java.awt.Color(255, 153, 51));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField5.setBackground(new java.awt.Color(255, 153, 51));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField6.setBackground(new java.awt.Color(255, 153, 51));
        jTextField6.setForeground(new java.awt.Color(0, 0, 0));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Tasques Asignades");

        javax.swing.GroupLayout Contador2Layout = new javax.swing.GroupLayout(Contador2);
        Contador2.setLayout(Contador2Layout);
        Contador2Layout.setHorizontalGroup(
            Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador2Layout.createSequentialGroup()
                .addGroup(Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Contador2Layout.createSequentialGroup()
                        .addGroup(Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador2Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel28)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel26)))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(Contador2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Contador2Layout.setVerticalGroup(
            Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Contador2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Contador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane_Elements.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));

        jTable_Elements.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane_Elements.setViewportView(jTable_Elements);

        javax.swing.GroupLayout DashElementsLayout = new javax.swing.GroupLayout(DashElements);
        DashElements.setLayout(DashElementsLayout);
        DashElementsLayout.setHorizontalGroup(
            DashElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Contador2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane_Elements, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        DashElementsLayout.setVerticalGroup(
            DashElementsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashElementsLayout.createSequentialGroup()
                .addComponent(Contador2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane_Elements, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DashUsuaris.setBackground(new java.awt.Color(255, 255, 255));
        DashUsuaris.setForeground(new java.awt.Color(51, 51, 255));

        Contador1.setBackground(new java.awt.Color(255, 153, 51));
        Contador1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(153, 153, 153), null, null));
        Contador1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Tasques Totals");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tasques Gestionades");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        txt_buscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscadorActionPerformed(evt);
            }
        });
        txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscadorKeyReleased(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Buscar :");

        Nou_Usuari.setText("Nou");
        Nou_Usuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nou_UsuariActionPerformed(evt);
            }
        });

        Eliminar_Usuari.setText("Eliminar");
        Eliminar_Usuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Eliminar_UsuariMouseClicked(evt);
            }
        });
        Eliminar_Usuari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_UsuariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Nou_Usuari)
                .addGap(18, 18, 18)
                .addComponent(Eliminar_Usuari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(Eliminar_Usuari)
                    .addComponent(Nou_Usuari))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setBackground(new java.awt.Color(255, 153, 51));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField3.setBackground(new java.awt.Color(255, 153, 51));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField4.setBackground(new java.awt.Color(255, 153, 51));
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tasques Asignades");

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
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Contador1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))
                        .addGroup(Contador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Contador1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Contador1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel23)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel6)))
                        .addGap(0, 64, Short.MAX_VALUE))
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
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        DashConfiguracio.setBackground(new java.awt.Color(51, 255, 51));

        javax.swing.GroupLayout DashConfiguracioLayout = new javax.swing.GroupLayout(DashConfiguracio);
        DashConfiguracio.setLayout(DashConfiguracioLayout);
        DashConfiguracioLayout.setHorizontalGroup(
            DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        DashConfiguracioLayout.setVerticalGroup(
            DashConfiguracioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        DashInfoUsuari.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoUsuari.setForeground(new java.awt.Color(51, 51, 255));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Informació Usuari");

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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nom:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Telefon:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Cognom:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Email:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Usuari:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nivell:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Estat:");

        ComboEstat.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstat.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));

        ComboNivell.setBackground(new java.awt.Color(255, 153, 51));
        ComboNivell.setForeground(new java.awt.Color(255, 255, 255));
        ComboNivell.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivellActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(255, 153, 51));
        Guardar.setForeground(new java.awt.Color(255, 255, 255));
        Guardar.setText("Guardar");
        Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GuardarMouseClicked(evt);
            }
        });
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Enrera.setBackground(new java.awt.Color(0, 0, 0));
        Enrera.setForeground(new java.awt.Color(0, 0, 0));

        Contrasenya.setBackground(new java.awt.Color(255, 153, 51));
        Contrasenya.setForeground(new java.awt.Color(255, 255, 255));
        Contrasenya.setText("Actualitzar Contrassenya");
        Contrasenya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrasenyaActionPerformed(evt);
            }
        });

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
                        .addGroup(DashInfoUsuariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashInfoUsuariLayout.createSequentialGroup()
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashInfoUsuariLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(Contrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addComponent(Enrera, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel8))
                    .addGroup(DashInfoUsuariLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
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
                            .addComponent(jLabel12)
                            .addComponent(Contrasenya, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        DashNouUsuari.setBackground(new java.awt.Color(255, 255, 255));

        txt_usuari1.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuari1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setBackground(new java.awt.Color(255, 153, 51));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 51));
        jLabel15.setText("Nou Usuari");

        jLabel17.setBackground(new java.awt.Color(255, 153, 51));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Cognom");

        jLabel18.setBackground(new java.awt.Color(255, 153, 51));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Email");

        jButton_Registar.setBackground(new java.awt.Color(255, 153, 51));
        jButton_Registar.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Registar.setText("Guardar");
        jButton_Registar.setBorder(null);
        jButton_Registar.setBorderPainted(false);
        jButton_Registar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Registar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_RegistarMouseClicked(evt);
            }
        });
        jButton_Registar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistarActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 153, 51));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Usuari");

        jLabel20.setBackground(new java.awt.Color(0, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Nom");

        jLabel21.setBackground(new java.awt.Color(255, 153, 51));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Telèfon");

        jLabel22.setBackground(new java.awt.Color(255, 153, 51));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Nivell");

        jLabel24.setBackground(new java.awt.Color(255, 153, 51));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Estat");

        ComboNivell1.setBackground(new java.awt.Color(255, 153, 51));
        ComboNivell1.setForeground(new java.awt.Color(255, 255, 255));
        ComboNivell1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Oficinista", "Operari", " " }));
        ComboNivell1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNivell1ActionPerformed(evt);
            }
        });

        ComboEstat1.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstat1.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstat1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actiu", "No Actiu", " " }));

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
                .addComponent(jButton_Registar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
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
                .addComponent(jButton_Registar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        DashNouElement.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_model.setBackground(new java.awt.Color(255, 153, 51));
        txt_model.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_model, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 226, 151, 30));

        jLabel29.setBackground(new java.awt.Color(255, 153, 51));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 153, 51));
        jLabel29.setText("Nou Element");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 18, -1, 60));

        jLabel30.setBackground(new java.awt.Color(255, 153, 51));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Usuari Assignat");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 190, -1, 25));

        jLabel31.setBackground(new java.awt.Color(255, 153, 51));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Marca");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 95, -1, -1));

        jButton_RegistarElm.setBackground(new java.awt.Color(255, 153, 51));
        jButton_RegistarElm.setForeground(new java.awt.Color(255, 255, 255));
        jButton_RegistarElm.setText("Guardar");
        jButton_RegistarElm.setBorder(null);
        jButton_RegistarElm.setBorderPainted(false);
        jButton_RegistarElm.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RegistarElm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_RegistarElmMouseClicked(evt);
            }
        });
        jButton_RegistarElm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistarElmActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_RegistarElm, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 407, 150, 30));

        jLabel32.setBackground(new java.awt.Color(255, 153, 51));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Model");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 190, 151, 30));

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Nom");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, 25));

        jLabel34.setBackground(new java.awt.Color(255, 153, 51));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Tipus");
        jPanel4.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 297, -1, 25));

        jLabel35.setBackground(new java.awt.Color(255, 153, 51));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Número Serie");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 285, 151, 30));

        jLabel36.setBackground(new java.awt.Color(255, 153, 51));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Observacions");
        jPanel4.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 174, -1, 30));

        ComboTipus.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipus.setForeground(new java.awt.Color(255, 255, 255));
        ComboTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinador", "Portatil", "SmartPhone", "Impresora" }));
        ComboTipus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipusActionPerformed(evt);
            }
        });
        jPanel4.add(ComboTipus, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 328, 151, 30));

        ComboEstatElem.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatElem.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatElem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));
        jPanel4.add(ComboEstatElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 128, 150, 26));

        txt_nomElem.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomElem.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_nomElem, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 121, 150, 31));

        txt_numserie.setBackground(new java.awt.Color(255, 153, 51));
        txt_numserie.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_numserie, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 327, 150, 31));

        txt_usuariassignat.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuariassignat.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_usuariassignat, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 221, 150, 31));

        txt_marca.setBackground(new java.awt.Color(255, 153, 51));
        txt_marca.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_marca, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 126, 150, 30));

        txt_observacions.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacions.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_observacions, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 210, 186, 148));

        jLabel37.setBackground(new java.awt.Color(255, 153, 51));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Estat");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 90, -1, 30));

        javax.swing.GroupLayout DashNouElementLayout = new javax.swing.GroupLayout(DashNouElement);
        DashNouElement.setLayout(DashNouElementLayout);
        DashNouElementLayout.setHorizontalGroup(
            DashNouElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouElementLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        DashNouElementLayout.setVerticalGroup(
            DashNouElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNouElementLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DashInfoElement.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoElement.setForeground(new java.awt.Color(51, 51, 255));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Informació Element");

        txt_numeroserieElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_numeroserieElem2.setForeground(new java.awt.Color(255, 255, 255));

        txt_nomElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_nomElem2.setForeground(new java.awt.Color(255, 255, 255));

        txt_usuariElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuariElem2.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuariElem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuariElem2ActionPerformed(evt);
            }
        });

        txt_marcaElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_marcaElem2.setForeground(new java.awt.Color(255, 255, 255));

        txt_modelElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_modelElem2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Nom:");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Número Serie:");

        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Usuari:");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Marca:");

        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Model:");

        jLabel44.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Tipus:");

        jLabel45.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Estat:");

        ComboEstatElem2.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatElem2.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatElem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));

        ComboTipusElem2.setBackground(new java.awt.Color(255, 153, 51));
        ComboTipusElem2.setForeground(new java.awt.Color(255, 255, 255));
        ComboTipusElem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ordinador", "Portatil", "SmartPhone", "Impresora" }));
        ComboTipusElem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipusElem2ActionPerformed(evt);
            }
        });

        Guardar2.setBackground(new java.awt.Color(255, 153, 51));
        Guardar2.setForeground(new java.awt.Color(255, 255, 255));
        Guardar2.setText("Guardar");
        Guardar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Guardar2MouseClicked(evt);
            }
        });
        Guardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Guardar2ActionPerformed(evt);
            }
        });

        Enrera1.setBackground(new java.awt.Color(0, 0, 0));
        Enrera1.setForeground(new java.awt.Color(0, 0, 0));

        txt_observacionsElem2.setBackground(new java.awt.Color(255, 153, 51));
        txt_observacionsElem2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Observacions:");

        javax.swing.GroupLayout DashInfoElementLayout = new javax.swing.GroupLayout(DashInfoElement);
        DashInfoElement.setLayout(DashInfoElementLayout);
        DashInfoElementLayout.setHorizontalGroup(
            DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoElementLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoElementLayout.createSequentialGroup()
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashInfoElementLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboTipusElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_usuariElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_marcaElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nomElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83)
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(DashInfoElementLayout.createSequentialGroup()
                                    .addComponent(jLabel43)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_modelElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(DashInfoElementLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jLabel45)
                                    .addGap(18, 18, 18)
                                    .addComponent(ComboEstatElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DashInfoElementLayout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_numeroserieElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))
                            .addGroup(DashInfoElementLayout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(18, 18, 18)
                                .addComponent(txt_observacionsElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DashInfoElementLayout.createSequentialGroup()
                        .addComponent(Enrera1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel38))
                    .addGroup(DashInfoElementLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(Guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        DashInfoElementLayout.setVerticalGroup(
            DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoElementLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(Enrera1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoElementLayout.createSequentialGroup()
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_modelElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(DashInfoElementLayout.createSequentialGroup()
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nomElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39))
                        .addGap(44, 44, 44)
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_usuariElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(txt_numeroserieElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40))
                        .addGap(39, 39, 39)
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(ComboTipusElem2)
                            .addComponent(jLabel45)
                            .addComponent(ComboEstatElem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addGroup(DashInfoElementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_observacionsElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel46))
                            .addComponent(txt_marcaElem2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)))
                .addComponent(Guardar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        DashNovaTasca.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setText("Nova Tasca");
        jLabel47.setBackground(new java.awt.Color(255, 153, 51));
        jLabel47.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 153, 51));
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, -1, 60));

        jLabel48.setText("Data");
        jLabel48.setBackground(new java.awt.Color(255, 153, 51));
        jLabel48.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, 25));

        jLabel49.setBackground(new java.awt.Color(255, 153, 51));
        jLabel49.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Prioritat");
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 95, -1, -1));

        jButtonRegistarTasca.setText("Guardar");
        jButtonRegistarTasca.setBackground(new java.awt.Color(255, 153, 51));
        jButtonRegistarTasca.setBorder(null);
        jButtonRegistarTasca.setBorderPainted(false);
        jButtonRegistarTasca.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistarTasca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel5.add(jButtonRegistarTasca, new org.netbeans.lib.awtextra.AbsoluteConstraints(251, 407, 150, 30));

        jLabel55.setBackground(new java.awt.Color(0, 0, 0));
        jLabel55.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Titol");
        jPanel5.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 90, -1, 25));

        jLabel58.setText("Descripció");
        jLabel58.setBackground(new java.awt.Color(255, 153, 51));
        jLabel58.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 30));

        ComboPrioritatTasc.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc.setForeground(new java.awt.Color(255, 255, 255));
        ComboPrioritatTasc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitja", "Alta", "Urgent", "Prioritaria" }));
        jPanel5.add(ComboPrioritatTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 150, 26));

        txt_titolTasc.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_titolTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 121, 150, 31));

        txt_usuariassignatTasc.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuariassignatTasc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_usuariassignatTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 221, 150, 31));

        txt_descripcioTasc.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(txt_descripcioTasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 560, 90));

        jLabel59.setBackground(new java.awt.Color(255, 153, 51));
        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Estat");
        jPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 90, -1, 30));

        dateTimePicker.setBackground(new java.awt.Color(255, 153, 51));
        dateTimePicker.setForeground(new java.awt.Color(255, 153, 51));
        jPanel5.add(dateTimePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 350, 30));

        jLabel63.setBackground(new java.awt.Color(255, 153, 51));
        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Usuari Assignat");
        jPanel5.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 190, -1, 25));

        ComboEstatElem3.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatElem3.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatElem3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nova", "En espera", "En procés", "Finalitzada" }));
        jPanel5.add(ComboEstatElem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(453, 128, 150, 26));

        javax.swing.GroupLayout DashNovaTascaLayout = new javax.swing.GroupLayout(DashNovaTasca);
        DashNovaTasca.setLayout(DashNovaTascaLayout);
        DashNovaTascaLayout.setHorizontalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                .addGap(43, 43, 43))
        );
        DashNovaTascaLayout.setVerticalGroup(
            DashNovaTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashNovaTascaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        DashInfoTasca.setBackground(new java.awt.Color(255, 255, 255));
        DashInfoTasca.setForeground(new java.awt.Color(51, 51, 255));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Informació Tasca");

        txt_titolTasc2.setBackground(new java.awt.Color(255, 153, 51));
        txt_titolTasc2.setForeground(new java.awt.Color(255, 255, 255));

        txt_usuariTasc2.setBackground(new java.awt.Color(255, 153, 51));
        txt_usuariTasc2.setForeground(new java.awt.Color(255, 255, 255));
        txt_usuariTasc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuariTasc2ActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Titol:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("Prioritat: ");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Usuari:");

        jLabel62.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Data:");

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Estat:");

        ComboEstatTasc2.setBackground(new java.awt.Color(255, 153, 51));
        ComboEstatTasc2.setForeground(new java.awt.Color(255, 255, 255));
        ComboEstatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Correcte", "Baixa", "Reparació" }));

        jButtonEditarTasca.setBackground(new java.awt.Color(255, 153, 51));
        jButtonEditarTasca.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditarTasca.setText("Guardar");
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

        Enrera2.setBackground(new java.awt.Color(0, 0, 0));
        Enrera2.setForeground(new java.awt.Color(0, 0, 0));

        txt_descripcioTasc2.setBackground(new java.awt.Color(255, 153, 51));
        txt_descripcioTasc2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Descripció:");

        ComboPrioritatTasc2.setBackground(new java.awt.Color(255, 153, 51));
        ComboPrioritatTasc2.setForeground(new java.awt.Color(255, 255, 255));
        ComboPrioritatTasc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Mitjana", "Alta", "Urgent", "Prioritaria" }));

        javax.swing.GroupLayout DashInfoTascaLayout = new javax.swing.GroupLayout(DashInfoTasca);
        DashInfoTasca.setLayout(DashInfoTascaLayout);
        DashInfoTascaLayout.setHorizontalGroup(
            DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoTascaLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_titolTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_usuariTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(51, 51, 51)
                                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                                .addComponent(jLabel65)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboEstatTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                                .addComponent(jLabel60)
                                                .addGap(18, 18, 18)
                                                .addComponent(ComboPrioritatTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(dateTimePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                .addComponent(Enrera2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(192, 192, 192)
                                .addComponent(jLabel56))
                            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_descripcioTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DashInfoTascaLayout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jButtonEditarTasca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(155, Short.MAX_VALUE))
        );
        DashInfoTascaLayout.setVerticalGroup(
            DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashInfoTascaLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(Enrera2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashInfoTascaLayout.createSequentialGroup()
                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(ComboPrioritatTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(ComboEstatTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)
                        .addComponent(dateTimePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashInfoTascaLayout.createSequentialGroup()
                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_titolTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addGap(44, 44, 44)
                        .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_usuariTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel61))
                        .addGap(46, 46, 46)
                        .addComponent(jLabel62)))
                .addGap(36, 36, 36)
                .addGroup(DashInfoTascaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_descripcioTasc2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66))
                .addGap(42, 42, 42)
                .addComponent(jButtonEditarTasca, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashBoardViewLayout = new javax.swing.GroupLayout(DashBoardView);
        DashBoardView.setLayout(DashBoardViewLayout);
        DashBoardViewLayout.setHorizontalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashConfiguracio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashUsuaris, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashInfoUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashElements, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashNouElement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(DashTasques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(6, 6, 6)))
        );
        DashBoardViewLayout.setVerticalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DashConfiguracio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashUsuaris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashInfoUsuari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashNouUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashElements, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashNouElement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 203, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(DashInfoElement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTasques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(DashNovaTasca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(197, Short.MAX_VALUE)))
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(DashInfoTasca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(16, 16, 16)))
        );

        getContentPane().add(DashBoardView, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1046, 575));
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

        //clickmenu(Configuracio,HideMenu,1);
        // DashBoardView.setVisible(false);
       /* DashTasques.setVisible(false);
        DashUsuaris.setVisible(false);
        DashConfiguracio.setVisible(true);*/

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

    
    public void addCheckBox(int column, JTable table) {

        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));
        

    }    
    
    public void vistaNovaTasca(){
    
        DashNovaTasca.setVisible(true);
      //  DashTasques.setVisible(false)
    
    }
    
    
    public void inicialitzarVista(){
     System.out.println("Inicialitzar");
            DashTasques.setVisible(false);        
            DashInfoUsuari.setVisible(false);
            DashInfoTasca.setVisible(false);
            DashNovaTasca.setVisible(false);
            DashConfiguracio.setVisible(false);     
            DashNouUsuari.setVisible(false);
            DashNouElement.setVisible(false);
            DashUsuaris.setVisible(true);
            DashElements.setVisible(false);
            DashInfoElement.setVisible(false);    
    
    }
    
    
    
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

    private void N_GrupsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_GrupsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_N_GrupsMouseEntered

    private void N_GrupsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_N_GrupsMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_N_GrupsMouseExited

    private void btn_ConfiguracioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ConfiguracioMouseClicked
        // TODO add your handling code here:
      //  DashTasques.setVisible(false);
       // DashUsuaris.setVisible(false);
        //DashConfiguracio.setVisible(true);
        
        /*CODI PER CANVIAR DE FINESTRA/CLASSE
        Usuaris usuari = new Usuaris();
        usuari.setVisible(true);        
        Point p = Header.getLocationOnScreen();       
        usuari.setLocation(p);*/
        

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

    private void txt_buscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscadorActionPerformed

    private void ComboNivellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivellActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivellActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_GuardarActionPerformed

    private void txt_cognomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cognomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cognomActionPerformed

    private void ContrasenyaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrasenyaActionPerformed
        // TODO add your handling code here:
        
        new Contrasenya().setVisible(true);
    }//GEN-LAST:event_ContrasenyaActionPerformed

    private void Eliminar_UsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_UsuariActionPerformed
        // TODO add your handling code here:
            
    }//GEN-LAST:event_Eliminar_UsuariActionPerformed

    //Pantalla Usuaris
    public void DashUsuaris() {

        DashInfoUsuari.setVisible(false);
        DashConfiguracio.setVisible(false);
        DashTasques.setVisible(false);
        DashNouUsuari.setVisible(false);
        DashNouElement.setVisible(false);
        DashElements.setVisible(false);
        DashInfoElement.setVisible(false);
        DashUsuaris.setVisible(true);

        DefaultTableModel model = new DefaultTableModel();

        try {

            jTable_Usuaris.setModel(model);
            model.fireTableDataChanged();
            try ( Connection cn = Conexio.conectar()) {
                PreparedStatement pst = cn.prepareStatement("select nom, cognom, usuari, nivell, estat from Usuaris");
                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsMd = rs.getMetaData();
                int cantitatColumnas = 6;
                int cantitatFilas = 0;
                model.addColumn("Seleccionar");
                model.addColumn("Nom");
                model.addColumn("Cognom");
                model.addColumn("Usuari");
                model.addColumn("Nivell");
                model.addColumn("Estat");

                while (rs.next()) {

                    Object[] fila = new Object[cantitatColumnas];

                    for (int i = 1; i < cantitatColumnas; i++) {

                        fila[i] = rs.getObject(i);

                    }
                    cantitatFilas++;
                    model.addRow(fila);
                    addCheckBox(0, jTable_Usuaris);

                }

                for (int i = 0; i < cantitatFilas; i++) {

                    model.setValueAt(false, i, 0);

                }
            }

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
        Natejar();
        jTable_Usuaris.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel model2 = new DefaultTableModel();
                model2 = (DefaultTableModel) jTable_Usuaris.getModel();

                int fila_point = jTable_Usuaris.rowAtPoint(e.getPoint());
                int columna_point = jTable_Usuaris.columnAtPoint(e.getPoint());
                int columna = 3;

                System.out.println("Fila" + fila_point);
                System.out.println("Columna" + columna_point);

                jTable_Usuaris.repaint();
                jTable_Usuaris.updateUI();
                if (fila_point > -1 && columna_point > 0) {

                    user_update = model2.getValueAt(fila_point, columna).toString();
                    //Informacion_usuario informacion_usuario = new InofrmacionUsuario();
                    DashUsuaris.setVisible(false);
                    DashInfoUsuari.setVisible(true);
                    informacioUsuari(user_update);
                }

            }

        });

    }

    //Mostra informacio detallada dels usuaris
    public void informacioUsuari(String user) {

        System.out.print(user);
        
        try {
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris where usuari = '" + user + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                jLabel8.setText(rs.getString("nom"));
                id = rs.getInt("id_usuari");
                txt_nom.setText(rs.getString("nom"));
                txt_cognom.setText(rs.getString("cognom"));
                txt_email.setText(rs.getString("email"));
                txt_telefon.setText(rs.getString("telefon"));
                txt_usuari.setText(rs.getString("usuari"));

                ComboNivell.setSelectedItem(rs.getString("nivell"));
                ComboEstat.setSelectedItem(rs.getString("estat"));

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades d'usuari" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
    }

    public boolean IsSelected(int fila, int columna, JTable taula) {

        Boolean checked = Boolean.valueOf(taula.getValueAt(fila, columna).toString());
        System.out.print(checked);
        return checked;

    }

    private void Eliminar_UsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_UsuariMouseClicked
        // TODO add your handling code here:

        for (int i = 0; i < jTable_Usuaris.getRowCount(); i++) {
            Boolean checked = Boolean.valueOf(jTable_Usuaris.getValueAt(i, 0).toString());
            String col = jTable_Usuaris.getValueAt(i, 1).toString();

            //DISPLAY
            if (checked) {

//                eliminarRegistre(jTable_Usuaris.getValueAt(i, 3).toString());
            }
        }
        DashUsuaris();

    }//GEN-LAST:event_Eliminar_UsuariMouseClicked

    private void txt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscadorKeyReleased
        // TODO add your handling code here:
       // BuscarUsuaris(txt_buscador.getText());
    }//GEN-LAST:event_txt_buscadorKeyReleased

    private void Nou_UsuariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nou_UsuariActionPerformed
        // TODO add your handling code here:   
        DashUsuaris.setVisible(false);
        DashNouUsuari.setVisible(true);
    }//GEN-LAST:event_Nou_UsuariActionPerformed

    public void Natejar() {

        txt_telefon1.setText(" ");
        txt_nom1.setText(" ");
        txt_cognom1.setText(" ");
        txt_usuari1.setText(" ");        
        txt_mail1.setText(" ");
        txt_buscador.setText("");
        txt_buscador1.setText("");
        
        txt_nomElem.setText("");
        txt_usuariassignat.setText("");
        txt_marca.setText("");
        txt_model.setText("");
        txt_numserie.setText("");
        txt_observacions.setText("");
        
        txt_titolTasc.setText("");
        txt_usuariassignatTasc.setText("");        
        txt_usuariassignatTasc.setText("");
        txt_descripcioTasc.setText("");
        

    }

    public void NatejarColor() {

        txt_usuari.setBackground(Color.WHITE);
        txt_nom1.setBackground(Color.white);
        txt_telefon1.setBackground(Color.white);
        txt_mail1.setBackground(Color.white);        
        txt_cognom1.setBackground(Color.white);

    }

    //Modificar Usuari
    private void GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GuardarMouseClicked
        // TODO add your handling code here:
        int nivell, estat, validacio = 0;
        String nom, cognom, mail, telefon, usuari, nivell_string = "", estat_string = "";

        mail = txt_email.getText().trim();
        nom = txt_nom.getText().trim();
        cognom = txt_cognom.getText().trim();
        telefon = txt_telefon.getText().trim();
        usuari = txt_usuari.getText().trim();

        nivell = ComboNivell.getSelectedIndex() + 1;
        estat = ComboEstat.getSelectedIndex() + 1;

        if (mail.equals("")) {

            //txt_email.setBackground(Color.red);
            validacio++;
        }
        if (nom.equals("")) {

            //txt_nom.setBackground(Color.red);
            validacio++;
        }
        if (cognom.equals("")) {

            //txt_cognom.setBackground(Color.red);
            validacio++;
        }
        if (telefon.equals("")) {

            //txt_telefon.setBackground(Color.red);
            validacio++;
        }

        if (validacio == 0) {

            if (nivell == 1) {

                nivell_string = "Administrador";

            }
            if (nivell == 2) {

                nivell_string = "Oficinista";
            }
            if (nivell == 3) {

                nivell_string = "Operari";

            }

            if (estat == 1) {

                estat_string = "Actiu";
            }

            if (estat == 2) {

                estat_string = "No Actiu";

            }

            try {

                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("select usuari from Usuaris where usuari = '" + usuari + "' and not id_usuari = '" + id + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    txt_usuari.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nom d'usuari no disponible");
                    cn.close();

                } else {

                    Connection cn2 = Conexio.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update Usuaris set nom=?, cognom=?, telefon=?, email=?, usuari=?, nivell=?, estat=?" + "where id_usuari = '"
                            + id + "'");
                    pst2.setString(1, nom);
                    pst2.setString(2, cognom);
                    pst2.setString(3, telefon);
                    pst2.setString(4, mail);
                    pst2.setString(5, usuari);
                    pst2.setString(6, nivell_string);
                    pst2.setString(7, estat_string);

                    pst2.executeUpdate();
                    cn2.close();

                    /*txt_email.setBackground(Color.green);
                    txt_nom.setBackground(Color.green);
                    txt_cognom.setBackground(Color.green);
                    txt_telefon.setBackground(Color.green);
                    txt_usuari.setBackground(Color.green);
                    ComboEstat.setBackground(Color.green);
                    ComboNivell.setBackground(Color.green);*/

                    JOptionPane.showMessageDialog(null, "Modificacio Correcta!");
                    DashInfoUsuari.setVisible(false);
                    DashUsuaris();
                }

            } catch (SQLException e) {

                System.err.println("Error al Guardar" + e);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");

        }

        
    }//GEN-LAST:event_GuardarMouseClicked

    private void ComboNivell1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNivell1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNivell1ActionPerformed

    //Crear usuaris
    private void jButton_RegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistarActionPerformed
        // TODO add your handling code here:

        int  nivell, estat, validacio = 0;
        String nom, cognom, mail, telefon, usuari,contrasenya, nivell_string=" ", estat_string=" ";

        mail = txt_mail1.getText().trim();
        nom = txt_nom1.getText().trim();
        cognom = txt_cognom1.getText().trim();
        telefon = txt_telefon1.getText().trim();
        usuari = txt_usuari1.getText().trim();
        contrasenya = "";

        nivell = ComboNivell1.getSelectedIndex() +1;
        estat = ComboEstat1.getSelectedIndex() + 1;

        if (mail.equals("")) {

            txt_mail1.setBackground(Color.red);
            validacio++;
        }
        if (nom.equals("")) {

            txt_nom1.setBackground(Color.red);
            validacio++;
        }
        if (cognom.equals("")) {

            txt_cognom1.setBackground(Color.red);
            validacio++;
        }
        if (telefon.equals("")) {

            txt_telefon1.setBackground(Color.red);
            validacio++;
        }

        if (validacio == 0) {

            if (nivell == 1) {

                nivell_string = "Administrador";

            }
            if (nivell == 2) {

                nivell_string = "Oficinista";
            }
            if (nivell == 3) {

                nivell_string = "Operari";

            }

            if (estat == 1) {

                estat_string = "Actiu";
            }

            if (estat == 2) {

                estat_string = "No Actiu";

            }

            try {

                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("select usuari from Usuaris where usuari = '" + usuari + "' and not id_usuari = '" + id + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    txt_usuari1.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nom d'usuari no disponible");
                    cn.close();

                } else {

                    Connection cn2 = Conexio.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("insert into Usuaris values (?,?,?,?,?,?,?,?,?)");
                    pst2.setInt(1,0);
                    pst2.setString(2, nom);
                    pst2.setString(3, cognom);
                    pst2.setString(4, telefon);
                    pst2.setString(5, mail);
                    pst2.setString(6, usuari);
                    pst2.setString(7, contrasenya);
                    pst2.setString(8, nivell_string);
                    pst2.setString(9, estat_string);

                    pst2.executeUpdate();
                    cn2.close();

                    /*txt_email.setBackground(Color.green);
                    txt_nom.setBackground(Color.green);
                    txt_cognom.setBackground(Color.green);
                    txt_telefon.setBackground(Color.green);
                    txt_usuari.setBackground(Color.green);
                    ComboEstat.setBackground(Color.green);
                    ComboNivell.setBackground(Color.green);*/

                    JOptionPane.showMessageDialog(null, "Usuari Creat Correctament!");
                    DashNouUsuari.setVisible(false);
                    DashUsuaris();
                }

            } catch (SQLException e) {

                System.err.println("Error al Crear el Usuari" + e);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");

        }

    }//GEN-LAST:event_jButton_RegistarActionPerformed

    private void jButton_RegistarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegistarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_RegistarMouseClicked

    private void txt_buscador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscador1ActionPerformed

    private void txt_buscador1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscador1KeyReleased
        // TODO add your handling code here:
        BuscarElements(txt_buscador1.getText());
    }//GEN-LAST:event_txt_buscador1KeyReleased

    private void Eliminar_ElementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Eliminar_ElementMouseClicked
        // TODO add your handling code here:
        
         for (int i = 0; i < jTable_Elements.getRowCount(); i++) {
            Boolean checked = Boolean.valueOf(jTable_Elements.getValueAt(i, 0).toString());
            String col = jTable_Elements.getValueAt(i, 1).toString();

            //DISPLAY
            if (checked) {

              //  eliminarRegistreElem(jTable_Elements.getValueAt(i, 1).toString());
            }
        }
        //DashElements();
    }//GEN-LAST:event_Eliminar_ElementMouseClicked

    private void Eliminar_ElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_ElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Eliminar_ElementActionPerformed
    //Crear Elements
    private void jButton_RegistarElmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegistarElmMouseClicked
        // TODO add your handling code here:
        int  tipus, estat, validacio = 0;
        String nom, usuari, marca, model, numero_serie, observacions, tipus_string=" ", estat_string=" ";

       
        
        nom = txt_nomElem.getText().trim();
        usuari = txt_usuariassignat.getText().trim();
        marca = txt_marca.getText().trim();
        model = txt_model.getText().trim();
        numero_serie = txt_numserie.getText().trim();
        observacions = txt_observacions.getText().trim();

        tipus = ComboTipus.getSelectedIndex() +1;
        estat = ComboEstatElem.getSelectedIndex() + 1;

        if (nom.equals("")) {
            
            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (marca.equals("")) {
            
            validacio++;
        }
        if (model.equals("")) {
            
            validacio++;
        }
        if (numero_serie.equals("")) {
            
            validacio++;
        }

        if (validacio == 0) {

            if (tipus == 1) {

                tipus_string = "Ordinador";

            }
            if (tipus == 2) {

                tipus_string = "Portatil";
            }
            if (tipus == 3) {

               tipus_string = "SmartPhone";

            }
            if (tipus == 4) {

               tipus_string = "Impresora";

            }

            if (estat == 1) {

                estat_string = "Correcte";
            }

            if (estat == 2) {

                estat_string = "Baixa";

            }
            if (estat == 3) {

                estat_string = "Reparació";

            }

            try {

                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("select nom from Elements where nom = '" + nom + "' and not id_element = '" + id + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    txt_nom.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nom d'element no disponible");
                    cn.close();

                } else {

                    Connection cn2 = Conexio.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("insert into Elements values (?,?,?,?,?,?,?,?,?)");
                    pst2.setInt(1,0);
                    pst2.setString(2, nom);
                    pst2.setString(3, usuari);
                    pst2.setString(4, tipus_string);
                    pst2.setString(5, marca);
                    pst2.setString(6, model);
                    pst2.setString(7, numero_serie);
                    pst2.setString(8, estat_string);
                    pst2.setString(9, observacions);

                    pst2.executeUpdate();
                    cn2.close();

                    JOptionPane.showMessageDialog(null, "Element Creat Correctament!");
                    DashNouElement.setVisible(false);
//                    DashElements();
                }

            } catch (SQLException e) {

                System.err.println("Error al Crear L'element" + e);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");

        }

    }//GEN-LAST:event_jButton_RegistarElmMouseClicked

    private void jButton_RegistarElmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistarElmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_RegistarElmActionPerformed

    private void ComboTipusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTipusActionPerformed

    private void txt_usuariElem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuariElem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuariElem2ActionPerformed

    private void ComboTipusElem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipusElem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboTipusElem2ActionPerformed

    //Modificacio ELements
    private void Guardar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Guardar2MouseClicked
        // TODO add your handling code here:
        
        int  tipus, estat, validacio = 0;
        String nom, usuari, marca, model, numero_serie, observacions, tipus_string=" ", estat_string=" ";

         
        nom = txt_nomElem2.getText().trim();
        usuari = txt_usuariElem2.getText().trim();
        marca = txt_marcaElem2.getText().trim();
        model = txt_modelElem2.getText().trim();
        numero_serie = txt_numeroserieElem2.getText().trim();
        observacions = txt_observacionsElem2.getText().trim();

        tipus = ComboTipusElem2.getSelectedIndex() +1;
        estat = ComboEstatElem2.getSelectedIndex() + 1;

        if (nom.equals("")) {
            
            validacio++;
        }
        if (usuari.equals("")) {

            validacio++;
        }
        if (marca.equals("")) {
            
            validacio++;
        }
        if (model.equals("")) {
            
            validacio++;
        }
        if (numero_serie.equals("")) {
            
            validacio++;
        }

        if (validacio == 0) {

            if (tipus == 1) {

                tipus_string = "Ordinador";

            }
            if (tipus == 2) {

                tipus_string = "Portatil";
            }
            if (tipus == 3) {

               tipus_string = "SmartPhone";

            }
            if (tipus == 4) {

               tipus_string = "Impresora";

            }

            if (estat == 1) {

                estat_string = "Correcte";
            }

            if (estat == 2) {

                estat_string = "Baixa";

            }
            if (estat == 3) {

                estat_string = "Reparació";

            }

            try {

                Connection cn = Conexio.conectar();
                PreparedStatement pst = cn.prepareStatement("select nom from Elements where nom = '" + nom + "' and not id_element = '" + id + "'");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {

                    txt_nom.setBackground(Color.red);
                    JOptionPane.showMessageDialog(null, "Nom d'element no disponible");
                    cn.close();

                } else {
                    System.out.print(id);
                    Connection cn2 = Conexio.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("update Elements set nom=?, usuari=?, tipus=?, marca=?, model=?, numero_serie=?, estat=?, observacions=? where id_element = '"+id+"'");
                   
                    pst2.setString(1, nom);
                    pst2.setString(2, usuari);
                    pst2.setString(3, tipus_string);
                    pst2.setString(4, marca);
                    pst2.setString(5, model);
                    pst2.setString(6, numero_serie);
                    pst2.setString(7, estat_string);
                    pst2.setString(8, observacions);

                    pst2.executeUpdate();
                    cn2.close();

                    JOptionPane.showMessageDialog(null, "Element Modificat!");
                    DashInfoElement.setVisible(false);
//                    DashElements();
                }

            } catch (SQLException e) {

                System.err.println("Error al modificar L'element" + e);

            }

        } else {

            JOptionPane.showMessageDialog(null, "Has d'omplir tots els camps");

        }       

    }//GEN-LAST:event_Guardar2MouseClicked

    private void Guardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Guardar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Guardar2ActionPerformed

    private void txtBuscadorTasquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorTasquesActionPerformed

    private void txtBuscadorTasquesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorTasquesKeyReleased
        // TODO add your handling code here:
        
        
        BuscarTasques(txtBuscadorTasques.getText());
    }//GEN-LAST:event_txtBuscadorTasquesKeyReleased

    private void jButtonEliminarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarTascaMouseClicked
        // TODO add your handling code here:
       /* for (int i = 0; i < jTable_Tasques.getRowCount(); i++) {
            boolean checked = Boolean.valueOf(jTable_Tasques.getValueAt(i, 0).toString());
            String col = jTable_Tasques.getValueAt(i, 1).toString();

            //DISPLAY
            if (checked) {

                System.out.println(checked + col);
                //eliminarRegistreTasc(jTable_Tasques.getValueAt(i, 1).toString());
            }
        }
//        DashTasques();*/
                       
        
    }//GEN-LAST:event_jButtonEliminarTascaMouseClicked

    //public boolean eliminarRegistreTasc(String titol) {

       /* try {
            System.out.println(titol);
            int id = 0;
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_tasca from Tasques where titol = '" + titol + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_tasca");

            }

            System.out.println(id);
            cn.close();

            Connection cn2 = Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Tasques where id_tasca='" + id + "'");            
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar tasca" + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar la tasca, contacti amb l'administrador");
            return false;
        }*/

   // }
    
    
    private void jButtonEliminarTasca(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTasca
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarTasca

    private void txt_usuariTasc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuariTasc2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuariTasc2ActionPerformed

    //Modificar Tasca
    private void jButtonEditarTascaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarTascaMouseClicked
       
        
        
        
    }//GEN-LAST:event_jButtonEditarTascaMouseClicked

    private void jButtonEditarTascaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarTascaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarTascaActionPerformed

    private void btn_TasquesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TasquesMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TasquesMouseEntered

    private void btn_TasquesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TasquesMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_TasquesMouseExited

        
    
        //Mostra informacio detallada dels elements
    public void informacioElement(String element) {

        System.out.print(element);
        
        try {
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from Elements where nom = '" + element + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txt_nomElem2.setText(rs.getString("nom"));
                id = rs.getInt("id_element");
                txt_usuariElem2.setText(rs.getString("usuari"));
                txt_marcaElem2.setText(rs.getString("marca"));
                txt_modelElem2.setText(rs.getString("model"));
                txt_numeroserieElem2.setText(rs.getString("numero_serie"));
                txt_observacionsElem2.setText(rs.getString("observacions"));

                ComboTipusElem2.setSelectedItem(rs.getString("tipus"));
                ComboEstatElem2.setSelectedItem(rs.getString("estat"));

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
    }
    
    

    public boolean eliminarRegistre(String usuari) {

        try {
            System.out.println(usuari);
            int id = 0;
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_usuari from Usuaris where usuari = '" + usuari + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_usuari");

            }

            System.out.println(id);
            cn.close();

            Connection cn2 = Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Usuaris where id_usuari='" + id + "'");            
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar usuari" + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar l'usuari, contacti amb l'administrador");
            return false;
        }

    }
    
    public boolean eliminarRegistreElem(String nom) {

        try {
            System.out.println(nom);
            int id = 0;
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_element from Elements where nom = '" + nom + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_element");

            }

            System.out.println(id);
            cn.close();

            Connection cn2 = Conexio.conectar();
            PreparedStatement pst2 = cn2.prepareStatement("delete from Elements where id_element='" + id + "'");            
            int i = pst2.executeUpdate();
            if (i != 0) {

                return true;

            } else {

                return false;
            }

        } catch (SQLException e) {

            System.err.println("Error al eliminar usuari" + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar l'usuari, contacti amb l'administrador");
            return false;
        }

    }

    public void BuscarUsuaris(String buscar) {

        DefaultTableModel model = new DefaultTableModel();

        try {

                                 
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from Usuaris where nom like '%" + buscar + "%' or cognom like '%" + buscar + "%'"
                    + "or usuari like '%" + buscar + "%' or nivell like '%" + buscar + "%' or estat like '%" + buscar + "%'");
            ResultSet rs = pst.executeQuery();
            //ResultSetMetaData rsMd = rs.getMetaData();

            int cantitatColumnas = 6;

            model.addColumn("Seleccionar");
            model.addColumn("Nom");
            model.addColumn("Cognom");
            model.addColumn("Usuari");
            model.addColumn("Nivell");
            model.addColumn("Estat");

            while (rs.next()) {

                Object[] fila = new Object[cantitatColumnas];

                fila[1] = rs.getString("Nom");
                fila[2] = rs.getString("Cognom");
                fila[3] = rs.getString("Usuari");
                fila[4] = rs.getString("Nivell");
                fila[5] = rs.getString("Estat");

                model.addRow(fila);

            }

            jTable_Usuaris.setModel(model);
            addCheckBox(0, jTable_Usuaris);
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        jTable_Usuaris.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {

                int fila_point = jTable_Usuaris.rowAtPoint(e.getPoint());
                int columna_point = jTable_Usuaris.columnAtPoint(e.getPoint());
                int columna = 3;

                if (fila_point > -1 && columna_point > 0) {

                    user_update = (String) model.getValueAt(fila_point, columna + 1);
                    //Informacion_usuario informacion_usuario = new InofrmacionUsuario();
                    DashUsuaris.setVisible(false);
                    DashInfoUsuari.setVisible(true);
                    informacioUsuari(user_update);
                }

            }

        });

    }

    //Pantalla Usuaris
    public void DashElements() {

        DashInfoUsuari.setVisible(false);
        DashConfiguracio.setVisible(false);
        DashTasques.setVisible(false);
        DashNouUsuari.setVisible(false);
        DashNouElement.setVisible(false);
        DashUsuaris.setVisible(false);
        DashElements.setVisible(true);

        DefaultTableModel model_elements = new DefaultTableModel();

        try {

            jTable_Elements.setModel(model_elements);
            model_elements.fireTableDataChanged();
            try ( Connection cn = Conexio.conectar()) {
                PreparedStatement pst = cn.prepareStatement("select nom, usuari, tipus, marca, estat from Elements");
                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsMd = rs.getMetaData();
                int cantitatColumnas = 6;
                int cantitatFilas = 0;
                model_elements.addColumn("Seleccionar");
                model_elements.addColumn("Nom");
                model_elements.addColumn("Usuari assignat");
                model_elements.addColumn("Tipus");
                model_elements.addColumn("Marca");
                model_elements.addColumn("Estat");

                while (rs.next()) {

                    Object[] fila = new Object[cantitatColumnas];

                    for (int i = 1; i < cantitatColumnas; i++) {

                        fila[i] = rs.getObject(i);

                    }
                    cantitatFilas++;
                    model_elements.addRow(fila);
                    addCheckBox(0, jTable_Elements);

                }

                for (int i = 0; i < cantitatFilas; i++) {

                    model_elements.setValueAt(false, i, 0);

                }
            }

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
        Natejar();
        jTable_Elements.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel model_elements2 = new DefaultTableModel();
                model_elements2 = (DefaultTableModel) jTable_Elements.getModel();

                int fila_point = jTable_Elements.rowAtPoint(e.getPoint());
                int columna_point = jTable_Elements.columnAtPoint(e.getPoint());
                int columna = 1;

                System.out.println("Fila" + fila_point);
                System.out.println("Columna" + columna_point);

                jTable_Elements.repaint();
                jTable_Elements.updateUI();
                if (fila_point > -1 && columna_point > 0) {

                    element_update = model_elements2.getValueAt(fila_point, columna).toString();                    
                    DashElements.setVisible(false);
                    DashInfoElement.setVisible(true);
                    informacioElement(element_update);
                }

            }

        });

    }
     
     public void BuscarElements(String buscarElem){  

         DefaultTableModel model = new DefaultTableModel();

        try {

                                 
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from Elements where nom like '%" + buscarElem + "%' or usuari like '%" + buscarElem + "%'"
                    + "or tipus like '%" + buscarElem + "%' or marca like '%" + buscarElem + "%' or estat like '%" + buscarElem + "%'");
            ResultSet rs = pst.executeQuery();
            //ResultSetMetaData rsMd = rs.getMetaData();

            int cantitatColumnas = 6;

            model.addColumn("Seleccionar");
            model.addColumn("Nom");
            model.addColumn("Usuari Assignat");
            model.addColumn("Tipus");
            model.addColumn("Marca");
            model.addColumn("Estat");

            while (rs.next()) {

                Object[] fila = new Object[cantitatColumnas];

                fila[1] = rs.getString("nom");
                fila[2] = rs.getString("usuari");
                fila[3] = rs.getString("tipus");
                fila[4] = rs.getString("marca");
                fila[5] = rs.getString("estat");

                model.addRow(fila);

            }

            jTable_Elements.setModel(model);
            addCheckBox(0, jTable_Elements);
            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        jTable_Elements.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {

                int fila_point = jTable_Elements.rowAtPoint(e.getPoint());
                int columna_point = jTable_Elements.columnAtPoint(e.getPoint());
                int columna = 1;

                if (fila_point > -1 && columna_point > 0) {

                    element_update = (String) model.getValueAt(fila_point, columna + 1);                    
                    DashElements.setVisible(false);
                    DashInfoElement.setVisible(true);
                    informacioUsuari(element_update);
                }

            }

        });  
     
     }
     
     //Pantalla Tasques
    public void DashTasques() {

    /*    DashInfoUsuari.setVisible(false);
        DashInfoTasca.setVisible(false);
        DashNovaTasca.setVisible(false);
        DashConfiguracio.setVisible(false);
        DashTasques.setVisible(true);
        DashNouUsuari.setVisible(false);
        DashNouElement.setVisible(false);
        DashUsuaris.setVisible(false);
        DashElements.setVisible(false);
        DashInfoElement.setVisible(false);

        DefaultTableModel model_tasques = new DefaultTableModel();

        try {

            jTable_Tasques.setModel(model_tasques);
            model_tasques.fireTableDataChanged();
            try ( Connection cn = Conexio.conectar()) {
                PreparedStatement pst = cn.prepareStatement("select titol, prioritat, usuari, data, estat from Tasques");
                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsMd = rs.getMetaData();
                int cantitatColumnas = 6;
                int cantitatFilas = 0;
                model_tasques.addColumn("Seleccionar");
                model_tasques.addColumn("Titol");
                model_tasques.addColumn("Prioritat");
                model_tasques.addColumn("Usuari assignat");
                model_tasques.addColumn("Data");
                model_tasques.addColumn("Estat");

                while (rs.next()) {

                    Object[] fila = new Object[cantitatColumnas];

                    for (int i = 1; i < cantitatColumnas; i++) {

                        fila[i] = rs.getObject(i);

                    }
                    cantitatFilas++;
                    model_tasques.addRow(fila);
                    addCheckBox(0, jTable_Tasques);

                }

                for (int i = 0; i < cantitatFilas; i++) {

                    model_tasques.setValueAt(false, i, 0);

                }
            }

            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model_tasques);
            jTable_Tasques.setRowSorter(sorter);
            
            List<SortKey> sortKeys = new ArrayList();
            sortKeys.add(new SortKey(4,SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
            
        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
        Natejar();
        jTable_Tasques.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                DefaultTableModel model_tasques2 = new DefaultTableModel();
                model_tasques2 = (DefaultTableModel) jTable_Tasques.getModel();

                int fila_point = jTable_Tasques.rowAtPoint(e.getPoint());
                int columna_point = jTable_Tasques.columnAtPoint(e.getPoint());
                int columna = 1;

                System.out.println("Fila" + fila_point);
                System.out.println("Columna" + columna_point);
                
      

                jTable_Tasques.repaint();
                jTable_Tasques.updateUI();
                if (fila_point > -1 && columna_point > 0) {

                    tasca_update = model_tasques2.getValueAt(fila_point, columna).toString();                    
                    DashTasques.setVisible(false);
                    DashInfoTasca.setVisible(true);
                    informacioTasca(tasca_update);
                }

            }

        });*/

    }
    
    
     //Mostra informacio detallada dels elements
/*    public void informacioTasca(String tasca) {

        System.out.print(tasca);
        
        try {
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select * from Tasques where titol = '" + tasca + "'");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txt_titolTasc2.setText(rs.getString("titol"));
                id = rs.getInt("id_tasca");
                //txt_prioritatTasc2.setText(rs.getString("prioritat"));
                txt_usuariTasc2.setText(rs.getString("usuari"));
                //String d = rs.getString("data");
               // SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");            
                //String d = formatter.format(afterAdding10Mins);
                //Date date = new Date(d);                
                //dateTimePicker1.setDateTimePermissive(LocalDateTime.parse(d,formatter));
                txt_descripcioTasc2.setText(rs.getString("descripcio"));
                txt_dataTasc2.setText(rs.getString("data"));
                ComboPrioritatTasc2.setSelectedItem(rs.getString("prioritat"));
                ComboEstatTasc2.setSelectedItem(rs.getString("estat"));

            }

            cn.close();

        } catch (SQLException e) {

            System.err.println("Error al solicitar les dades" + e);
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
    }*/
    
    public void BuscarTasques(String buscarTasc){  

        DefaultTableModel modelTasc = new DefaultTableModel();
                 

        try {

                                 
            try (Connection cn = Conexio.conectar()) {
                PreparedStatement pst = cn.prepareStatement("select * from Tasques where titol like '%" + buscarTasc + "%' or prioritat like '%" + buscarTasc + "%'"
                        + "or usuari like '%" + buscarTasc + "%' or data like '%" + buscarTasc + "%' or estat like '%" + buscarTasc + "%'");
                ResultSet rs = pst.executeQuery();               
                
                int cantitatColumnas = 6;
                
                modelTasc.addColumn("Seleccionar");
                modelTasc.addColumn("Titol");
                modelTasc.addColumn("Prioritat");
                modelTasc.addColumn("Usuari Assignat");
                modelTasc.addColumn("Data");
                modelTasc.addColumn("Estat");
                
                while (rs.next()) {
                    
                    Object[] fila = new Object[cantitatColumnas];
                    
                    fila[1] = rs.getString("Titol");
                    fila[2] = rs.getString("Prioritat");
                    fila[3] = rs.getString("Usuari");
                    fila[4] = rs.getString("Data");
                    fila[5] = rs.getString("Estat");
                    
                    modelTasc.addRow(fila);
                    
                }
                
                jTable_Tasques.setModel(modelTasc);
                addCheckBox(0, jTable_Tasques);
            }
            
             TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modelTasc);
             jTable_Tasques.setRowSorter(sorter2);

        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }

        jTable_Tasques.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {

                int fila_point = jTable_Tasques.rowAtPoint(e.getPoint());
                int columna_point = jTable_Tasques.columnAtPoint(e.getPoint());
                int columna = 1;

                if (fila_point > -1 && columna_point > 0) {

                    tasca_update = (String) modelTasc.getValueAt(fila_point, columna);                    
                    DashTasques.setVisible(false);
                    DashInfoTasca.setVisible(true);
                    informacioUsuari(tasca_update);
                }

            }

        });  
     
     }
    
       public void recordatori(Date date) throws InterruptedException, ParseException{
       
                 
            DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");            
            String d = formatter.format(date);
                      
       try {
            Connection cn = Conexio.conectar();
            PreparedStatement pst = cn.prepareStatement("select id_tasca, notificacio, titol, data from Tasques where data = '" + d + "'");
            ResultSet rs = pst.executeQuery();
            
            
            if (rs.next()) {
               
                if(rs.getInt("notificacio")==0){
                
                    
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
       
       public void recordatori(String titol, Date data) throws ParseException{
       
           
           String[] botones = {"Veure Tasca", "Posposar 5min"};
		int ventana = JOptionPane.showOptionDialog(null,titol,"Notificacio Tasca",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, 
						botones, botones[0]);
		if(ventana == 0) {
                    
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
                        DashInfoTasca.setVisible(false);
                        DashNovaTasca.setVisible(false);
                        DashConfiguracio.setVisible(false);
                        DashTasques.setVisible(false);
                        DashNouUsuari.setVisible(false);
                        DashNouElement.setVisible(false);
                        DashUsuaris.setVisible(false);
                        DashElements.setVisible(false);
                        DashInfoElement.setVisible(false);
                } 
		else if(ventana == 1) {
                    
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
                        
                        
                        pst.setString(1,d);
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
                if ("Nimbus".equals(info.getName())) {
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
    private javax.swing.JLabel Close;
    private javax.swing.JComboBox<String> ComboEstat;
    private javax.swing.JComboBox<String> ComboEstat1;
    private javax.swing.JComboBox<String> ComboEstatElem;
    private javax.swing.JComboBox<String> ComboEstatElem2;
    public javax.swing.JComboBox<String> ComboEstatElem3;
    public javax.swing.JComboBox<String> ComboEstatTasc2;
    private javax.swing.JComboBox<String> ComboNivell;
    private javax.swing.JComboBox<String> ComboNivell1;
    public javax.swing.JComboBox<String> ComboPrioritatTasc;
    public javax.swing.JComboBox<String> ComboPrioritatTasc2;
    private javax.swing.JComboBox<String> ComboTipus;
    private javax.swing.JComboBox<String> ComboTipusElem2;
    private javax.swing.JPanel Configuracio;
    private javax.swing.JPanel Contador1;
    private javax.swing.JPanel Contador2;
    private javax.swing.JPanel Contador4;
    private javax.swing.JButton Contrasenya;
    public javax.swing.JPanel DashBoardView;
    public javax.swing.JPanel DashConfiguracio;
    public javax.swing.JPanel DashElements;
    public javax.swing.JPanel DashInfoElement;
    public javax.swing.JPanel DashInfoTasca;
    public javax.swing.JPanel DashInfoUsuari;
    public javax.swing.JPanel DashNouElement;
    public javax.swing.JPanel DashNouUsuari;
    public javax.swing.JPanel DashNovaTasca;
    public javax.swing.JPanel DashTasques;
    public javax.swing.JPanel DashUsuaris;
    private javax.swing.JPanel Elements;
    private javax.swing.JButton Eliminar_Element;
    private javax.swing.JButton Eliminar_Usuari;
    private javax.swing.JLabel Enrera;
    private javax.swing.JLabel Enrera1;
    private javax.swing.JLabel Enrera2;
    private javax.swing.JPanel Grups;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Guardar2;
    public javax.swing.JPanel Header;
    private javax.swing.JPanel HideMenu;
    public javax.swing.JPanel IconMinMaxClose;
    private javax.swing.JPanel LiniaConfiguracio;
    private javax.swing.JPanel LiniaElements;
    private javax.swing.JPanel LiniaGrups;
    private javax.swing.JPanel LiniaHideMenu;
    private javax.swing.JPanel LiniaTasques;
    private javax.swing.JPanel LiniaUsuaris;
    private javax.swing.JLabel Max;
    public javax.swing.JPanel Menu;
    private javax.swing.JLabel MenuDes;
    public javax.swing.JPanel MenuHide;
    public javax.swing.JPanel MenuIcon;
    private javax.swing.JLabel Min;
    private javax.swing.JPanel N_Configuracio;
    private javax.swing.JPanel N_Elements;
    private javax.swing.JPanel N_Grups;
    private javax.swing.JPanel N_LiniaTasques;
    private javax.swing.JPanel N_Tasques;
    private javax.swing.JPanel N_Usuaris;
    private javax.swing.JButton Nou_Usuari;
    private javax.swing.JPanel Tasques;
    private javax.swing.JPanel Usuaris;
    public javax.swing.JLabel btnConfiguracio;
    public javax.swing.JLabel btnElements;
    public javax.swing.JLabel btnGrup;
    public javax.swing.JButton btnNovaTasca;
    public javax.swing.JLabel btnTasques;
    public javax.swing.JLabel btnUsuaris;
    public javax.swing.JLabel btn_Configuracio;
    public javax.swing.JLabel btn_Elements;
    public javax.swing.JLabel btn_Grups;
    public javax.swing.JLabel btn_Tasques;
    public javax.swing.JLabel btn_Usuaris;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePicker;
    public com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    public javax.swing.JButton jButtonEditarTasca;
    public javax.swing.JButton jButtonEliminarTasca;
    public javax.swing.JButton jButtonNovaTasca;
    public javax.swing.JButton jButtonRegistarTasca;
    private javax.swing.JButton jButton_Registar;
    private javax.swing.JButton jButton_RegistarElm;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JScrollPane jScrollPane_Elements;
    public javax.swing.JScrollPane jScrollPane_Tasques;
    private javax.swing.JScrollPane jScrollPane_Usuaris;
    public javax.swing.JTable jTable_Elements;
    public javax.swing.JTable jTable_Tasques;
    private javax.swing.JTable jTable_Usuaris;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    public javax.swing.JTextField txtBuscadorTasques;
    private javax.swing.JTextField txt_buscador;
    private javax.swing.JTextField txt_buscador1;
    private javax.swing.JTextField txt_cognom;
    private javax.swing.JTextField txt_cognom1;
    public javax.swing.JTextField txt_descripcioTasc;
    public javax.swing.JTextField txt_descripcioTasc2;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_mail1;
    private javax.swing.JTextField txt_marca;
    private javax.swing.JTextField txt_marcaElem2;
    private javax.swing.JTextField txt_model;
    private javax.swing.JTextField txt_modelElem2;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_nom1;
    private javax.swing.JTextField txt_nomElem;
    private javax.swing.JTextField txt_nomElem2;
    private javax.swing.JTextField txt_numeroserieElem2;
    private javax.swing.JTextField txt_numserie;
    private javax.swing.JTextField txt_observacions;
    private javax.swing.JTextField txt_observacionsElem2;
    private javax.swing.JTextField txt_telefon;
    private javax.swing.JTextField txt_telefon1;
    public javax.swing.JTextField txt_titolTasc;
    public javax.swing.JTextField txt_titolTasc2;
    private javax.swing.JTextField txt_usuari;
    private javax.swing.JTextField txt_usuari1;
    private javax.swing.JTextField txt_usuariElem2;
    public javax.swing.JTextField txt_usuariTasc2;
    private javax.swing.JTextField txt_usuariassignat;
    public javax.swing.JTextField txt_usuariassignatTasc;
    // End of variables declaration//GEN-END:variables

    
}
