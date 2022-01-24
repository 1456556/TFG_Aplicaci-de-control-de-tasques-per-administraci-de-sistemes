/*
 * To change this license header1, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.raven.component.Header;
import com.raven.component.Menu;
import com.raven.event.EventMenu;
import com.raven.event.EventMenuSelected;
import com.raven.event.EventShowPopupMenu;
import com.raven.form.MainForm;
import com.raven.model.ModelMenu;
import com.raven.swing.MenuAnimation;
import com.raven.swing.MenuItem;
import com.raven.swing.PopupMenu;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.raven.swing.scrollbar.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 *
 * @author Victor
 */
public class JFVista extends javax.swing.JFrame {

    /**
     * Creates new form JFVista
     */
    private MigLayout layout;
    private Menu men;
    private Header head;
    private MainForm main;
    private Animator animator;
    private JFVista vis;

    public JFVista() {
        initComponents();
        //setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel.setLayout(layout);
        DashTasques.setVisible(true);
        initMenuItem();
        init();

    }

    public JFVista(JFVista vis) {

        this.vis = vis;

    }

    public void addMenuEvent(ActionListener event) {
        cmdMenu.addActionListener(event);
        hideallMenu();
    }

    private void init() {
        /* layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        bg.setLayout(layout);
       
         */
        //JFVista = new MainForm();
        head = new Header();
        men = new Menu();
        main = new MainForm();
        men.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
                if (menuIndex == 0) {
                    if (subMenuIndex == 0) {
                        System.out.println("Hola");
                    } else if (subMenuIndex == 1) {
                        System.out.println("Hola");

                    }
                }

                if (menuIndex == 1) {
                    System.out.println("Hola");
                }
            }
        });
        men.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                MenuItem item = (MenuItem) com;
                PopupMenu popup = new PopupMenu(JFVista.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = JFVista.this.getX() + 52;
                int y = JFVista.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
        men.initMenuItem();
        bg.add(men, "w 230!, spany 2");    // Span Y 2cell
        bg.add(head, "h 50!, wrap");
        // bg.add(main, "w 100%, h 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (men.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(men, "w " + width + "!, spany2");
                men.revalidate();
            }

            @Override
            public void end() {
                men.setShowMenu(!men.isShowMenu());
                men.setEnableMenu(true);
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        head.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                men.setEnableMenu(false);
                if (men.isShowMenu()) {
                    men.hideallMenu();
                }
            }
        });
        //  Init google icon font
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        //  Start with this form
        //main.showForm(new Form_Home());
    }

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    //private MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public void initMenuItem() {
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/1.png")), "Dashboard", "Home", "Buttons", "Cards", "Tabs", "Accordions", "Modals"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/13.png")), "Tasques"));
        addMenu(new ModelMenu(new ImageIcon(getClass().getResource("/com/raven/icon/14.png")), "Usuaris"));
    }

    private void addMenu(ModelMenu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 40!");
    }

    private EventMenu getEventMenu() {
        return new EventMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }

    protected void paintComponent(Graphics grphcs) {
//        super.paintComponent(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(33, 105, 249), getWidth(), 0, new Color(93, 58, 196));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        cmdMenu = new com.raven.swing.Button();
        ButtonClose = new javax.swing.JPanel();
        Close = new javax.swing.JLabel();
        ButtonMax = new javax.swing.JPanel();
        Max = new javax.swing.JLabel();
        ButtonMin = new javax.swing.JPanel();
        Min = new javax.swing.JLabel();
        menu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pic = new com.raven.swing.ImageAvatar();
        jButtonNomUsuari = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        DashBoardView = new javax.swing.JPanel();
        DashTasques = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonNovaTasca = new javax.swing.JButton();
        jButtonEliminarTasca = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        jComboBoxDashTasquesUsuari = new javax.swing.JComboBox<>();
        jLabel53 = new javax.swing.JLabel();
        txtBuscadorTasques = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane_Tasques = new javax.swing.JScrollPane();
        jTable_Tasques = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbTitle1 = new javax.swing.JLabel();
        lbValues1 = new javax.swing.JLabel();
        lbIcon1 = new javax.swing.JLabel();
        pro1 = new com.raven.swing.ProgressBarCustom();
        lbPer1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        lbTitle3 = new javax.swing.JLabel();
        lbValues3 = new javax.swing.JLabel();
        lbIcon3 = new javax.swing.JLabel();
        pro3 = new com.raven.swing.ProgressBarCustom();
        lbPer3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbValues = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        pro = new com.raven.swing.ProgressBarCustom();
        lbPer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(255, 255, 255));

        header.setBackground(new java.awt.Color(255, 255, 255));

        cmdMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/menu.png"))); // NOI18N
        cmdMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdMenuActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addComponent(cmdMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ButtonClose, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ButtonMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        menu.setBackground(new java.awt.Color(0, 51, 204));
        menu.setForeground(new java.awt.Color(0, 51, 204));
        menu.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setForeground(new java.awt.Color(0, 51, 204));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(224, 224, 224));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ezgif.com-gif-maker2.png"))); // NOI18N
        jLabel6.setText("ControlTasques");

        pic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/profile.jpg"))); // NOI18N

        jButtonNomUsuari.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonNomUsuari.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNomUsuari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonNomUsuari.setText("Usuari");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(pic, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNomUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 783, Short.MAX_VALUE)
            .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(menuLayout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 604, Short.MAX_VALUE)))
        );

        sp.setBackground(new java.awt.Color(0, 51, 255));
        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel.setBackground(new java.awt.Color(0, 51, 153));
        panel.setOpaque(false);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 714, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        DashBoardView.setBackground(new java.awt.Color(255, 255, 255));

        DashTasques.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Notice Board");
        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(105, 105, 105));
        jLabel3.setText("Simple Miglayout API Doc");
        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
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

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(4, 72, 210));
        jLabel1.setText("Dashboard / Home");

        javax.swing.GroupLayout DashTasquesLayout = new javax.swing.GroupLayout(DashTasques);
        DashTasques.setLayout(DashTasquesLayout);
        DashTasquesLayout.setHorizontalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTasquesLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashTasquesLayout.createSequentialGroup()
                        .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashTasquesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(DashTasquesLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(DashTasquesLayout.createSequentialGroup()
                                        .addComponent(jButtonNovaTasca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonEliminarTasca)))))
                        .addGap(127, 127, 127)
                        .addComponent(jLabel127, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashTasquesLayout.createSequentialGroup()
                        .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        DashTasquesLayout.setVerticalGroup(
            DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashTasquesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashTasquesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovaTasca)
                    .addComponent(jButtonEliminarTasca)
                    .addComponent(jLabel127)
                    .addComponent(jComboBoxDashTasquesUsuari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscadorTasques, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Tasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashBoardViewLayout = new javax.swing.GroupLayout(DashBoardView);
        DashBoardView.setLayout(DashBoardViewLayout);
        DashBoardViewLayout.setHorizontalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1127, Short.MAX_VALUE)
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashBoardViewLayout.createSequentialGroup()
                    .addComponent(DashTasques, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        DashBoardViewLayout.setVerticalGroup(
            DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
            .addGroup(DashBoardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DashBoardViewLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(DashTasques, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(16, Short.MAX_VALUE)))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle1.setForeground(new java.awt.Color(225, 225, 225));
        lbTitle1.setText("Title");

        lbValues1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbValues1.setForeground(new java.awt.Color(225, 225, 225));
        lbValues1.setText("Values");

        lbIcon1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbPer1.setForeground(new java.awt.Color(255, 255, 255));
        lbPer1.setText("0%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pro1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPer1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle1)
                            .addComponent(lbValues1))
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lbTitle1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues1))
                    .addComponent(lbIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPer1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(pro1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle3.setForeground(new java.awt.Color(225, 225, 225));
        lbTitle3.setText("Title");

        lbValues3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbValues3.setForeground(new java.awt.Color(225, 225, 225));
        lbValues3.setText("Values");

        lbIcon3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbPer3.setForeground(new java.awt.Color(255, 255, 255));
        lbPer3.setText("0%");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(pro3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPer3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle3)
                            .addComponent(lbValues3))
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(lbTitle3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues3))
                    .addComponent(lbIcon3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPer3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(pro3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 8, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lbTitle.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(225, 225, 225));
        lbTitle.setText("Title");

        lbValues.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        lbValues.setForeground(new java.awt.Color(225, 225, 225));
        lbValues.setText("Values");

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        lbPer.setForeground(new java.awt.Color(255, 255, 255));
        lbPer.setText("0%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(pro, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbPer))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addComponent(lbValues))
                        .addGap(18, 18, 18)
                        .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbValues))
                    .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1133, Short.MAX_VALUE)))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(233, 233, 233)
                    .addComponent(DashBoardView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(bgLayout.createSequentialGroup()
                    .addGap(187, 187, 187)
                    .addComponent(DashBoardView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1366, 783));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        if (this.getExtendedState() != JFVista.MAXIMIZED_BOTH) {
            this.setExtendedState(JFVista.MAXIMIZED_BOTH);

        } else {
            this.setExtendedState(JFVista.NORMAL);

        }
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
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_MinMouseClicked

    private void MinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseEntered
        // TODO add your handling code here:
        //changecolor(ButtonMin, new Color(255, 204, 102));
    }//GEN-LAST:event_MinMouseEntered

    private void MinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinMouseExited
        // TODO add your handling code here:
        //changecolor(ButtonMin, new Color(255, 153, 0));
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
        //changecolor(N_Usuari, new Color(255, 204, 102));
    }//GEN-LAST:event_jButtonNomUsuariMouseEntered

    private void jButtonNomUsuariMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNomUsuariMouseExited
        // TODO add your handling code here:

        //changecolor(N_Usuari, new Color(255, 153, 0));
    }//GEN-LAST:event_jButtonNomUsuariMouseExited

    private void cmdMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMenuActionPerformed
        // TODO add your handling code here:
        hideallMenu();
    }//GEN-LAST:event_cmdMenuActionPerformed

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
            java.util.logging.Logger.getLogger(JFVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonClose;
    private javax.swing.JPanel ButtonMax;
    private javax.swing.JPanel ButtonMin;
    public javax.swing.JLabel Close;
    private javax.swing.JPanel DashBoardView;
    private javax.swing.JPanel DashTasques;
    public javax.swing.JLabel Max;
    public javax.swing.JLabel Min;
    private javax.swing.JPanel bg;
    private com.raven.swing.Button cmdMenu;
    private javax.swing.JPanel header;
    public javax.swing.JButton jButtonEliminarTasca;
    public javax.swing.JLabel jButtonNomUsuari;
    public javax.swing.JButton jButtonNovaTasca;
    public javax.swing.JComboBox<String> jComboBoxDashTasquesUsuari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    public javax.swing.JScrollPane jScrollPane_Tasques;
    public javax.swing.JTable jTable_Tasques;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbIcon1;
    private javax.swing.JLabel lbIcon3;
    private javax.swing.JLabel lbPer;
    private javax.swing.JLabel lbPer1;
    private javax.swing.JLabel lbPer3;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitle1;
    private javax.swing.JLabel lbTitle3;
    private javax.swing.JLabel lbValues;
    private javax.swing.JLabel lbValues1;
    private javax.swing.JLabel lbValues3;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel panel;
    private com.raven.swing.ImageAvatar pic;
    private com.raven.swing.ProgressBarCustom pro;
    private com.raven.swing.ProgressBarCustom pro1;
    private com.raven.swing.ProgressBarCustom pro3;
    private javax.swing.JScrollPane sp;
    public javax.swing.JTextField txtBuscadorTasques;
    // End of variables declaration//GEN-END:variables

    private void changecolor(JPanel ButtonClose, Color color) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
