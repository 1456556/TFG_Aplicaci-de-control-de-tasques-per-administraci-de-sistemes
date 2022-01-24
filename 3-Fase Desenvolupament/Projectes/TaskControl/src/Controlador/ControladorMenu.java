/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Configuracio;
import Model.ConsultesConfiguracio;
import Model.ConsultesElements;
import Model.ConsultesGrafiques;
import Model.ConsultesGrups;
import Model.ConsultesLogin;
import Model.ConsultesPerfil;
import Model.ConsultesTasques;
import Model.ConsultesUsuaris;
import Model.Elements;
import Model.Grups;
import Model.Login;
import Model.Perfil;
import Model.Tasques;
import Model.Usuaris;
import Vista.JFContrasenya;
import Vista.JFLogin2;
import Vista.JFPrincipal2;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import java.awt.event.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class ControladorMenu implements MouseListener {

    private JFContrasenya contrasenya;

    private JFPrincipal2 vis;
    private JFileChooser jf;
    String newLine = System.getProperty("line.separator");

    public ControladorMenu(JFPrincipal2 vis, JFContrasenya contrasenya, JFileChooser jf) {

        this.vis = vis;
        addMouseListener(this);
        this.vis.setVisible(true);
        this.jf = jf;
        this.contrasenya = contrasenya;
        /* this.vis.btnTasques.addMouseListener(this);
        this.vis.btn_Tasques.addMouseListener(this);
        this.vis.jButtonNomUsuari.addMouseListener(this);
        this.vis.btnElements.addMouseListener(this);
        this.vis.btn_Elements.addMouseListener(this);
        this.vis.btnUsuaris.addMouseListener(this);
        this.vis.btn_Usuaris.addMouseListener(this);
        this.vis.btn_Grups.addMouseListener(this);
        this.vis.btnGrup.addMouseListener(this);
        this.vis.btnConfiguracio.addMouseListener(this);
        this.vis.btn_Configuracio.addMouseListener(this);
        this.vis.jButtonNomUsuari.addMouseListener(this);
        this.vis.btnTancarSessio.addMouseListener(this);
        this.vis.btn_TancarSessio.addMouseListener(this);*/

    }

    public ControladorMenu(JFPrincipal2 aThis) {

        this.vis = aThis;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inicialitzar() {

        vis.jButtonNomUsuari.setText(Login.usuari);
        Tasques modTasques = new Tasques();
        ConsultesTasques modCTasques = new ConsultesTasques();
        ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);
        con.inicialitzar();
        // con.MostrarTaula(vis.jTable_Tasques);

        ConsultesPerfil modCPerfil = new ConsultesPerfil();
        modCPerfil.CargarImatge(vis);

        vis.DashTasques.setVisible(true);
        vis.DashNovaTasca.setVisible(false);
        vis.DashInfoTasca.setVisible(false);
        vis.DashOrdinadors.setVisible(false);
        vis.DashNouOrdinador.setVisible(false);
        vis.DashInfoOrdinador.setVisible(false);
        vis.DashUsuaris.setVisible(false);
        vis.DashNouUsuari.setVisible(false);
        vis.DashInfoUsuari.setVisible(false);
        vis.DashGrups.setVisible(false);
        vis.DashNouGrup.setVisible(false);
        vis.DashConfiguracio.setVisible(false);
        vis.DashPerfilUsuari.setVisible(false);
        vis.DashTriaTasca.setVisible(false);
        vis.DashNovaTascaRepeticio.setVisible(false);
        vis.DashInfoTascaRepeticio.setVisible(false);
        vis.DashInfoGrup.setVisible(false);
        vis.DashOrdinadors.setVisible(false);
        vis.DashTelefons.setVisible(false);
        vis.DashInfoTelefon.setVisible(false);
        vis.DashNouTelefon.setVisible(false);
        vis.DashChat.setVisible(false);
        vis.DashImpresores.setVisible(false);
        vis.DashNouImpresora.setVisible(false);
        vis.DashInfoImpresores.setVisible(false);
        vis.DashServidors.setVisible(false);
        vis.DashNouServidor.setVisible(false);
        vis.DashInfoServidor.setVisible(false);
        vis.DashGrafiques.setVisible(false);

    }

    public void notificacio() {

        vis.DashTasques.setVisible(false);
        vis.DashNovaTasca.setVisible(false);
        vis.DashInfoTasca.setVisible(true);
        vis.DashOrdinadors.setVisible(false);
        vis.DashNouOrdinador.setVisible(false);
        vis.DashInfoOrdinador.setVisible(false);
        vis.DashUsuaris.setVisible(false);
        vis.DashNouUsuari.setVisible(false);
        vis.DashInfoUsuari.setVisible(false);
        vis.DashGrups.setVisible(false);
        vis.DashNouGrup.setVisible(false);
        vis.DashConfiguracio.setVisible(false);
        vis.DashPerfilUsuari.setVisible(false);
        vis.DashTriaTasca.setVisible(false);
        vis.DashNovaTascaRepeticio.setVisible(false);
        vis.DashInfoTascaRepeticio.setVisible(false);
        vis.DashInfoGrup.setVisible(false);

        vis.DashOrdinadors.setVisible(false);
        vis.DashTelefons.setVisible(false);
        vis.DashInfoTelefon.setVisible(false);
        vis.DashNouTelefon.setVisible(false);
        vis.DashImpresores.setVisible(false);
        vis.DashNouImpresora.setVisible(false);
        vis.DashInfoImpresores.setVisible(false);
        vis.DashServidors.setVisible(false);
        vis.DashNouServidor.setVisible(false);
        vis.DashInfoServidor.setVisible(false);
        vis.DashGrafiques.setVisible(false);

    }

    public void CanviarMenu(int menu) {

        switch (menu) {
            case 1:
                Tasques modTasques = new Tasques();
                ConsultesTasques modCTasques = new ConsultesTasques();
                ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);
                con.inicialitzar();
                //con.MostrarTaula(vis.jTable_Tasques);
                vis.DashTasques.setVisible(true);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;
            case 21:
                Elements modElements = new Elements();
                ConsultesElements modCElements = new ConsultesElements();
                ControladorElements con21 = new ControladorElements(modElements, modCElements, vis);
                con21.inicialitzar(21);

                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);
                vis.DashOrdinadors.setVisible(true);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;
            case 22:
                Elements modElements22 = new Elements();
                ConsultesElements modCElements22 = new ConsultesElements();
                ControladorElements con22 = new ControladorElements(modElements22, modCElements22, vis);
                con22.inicialitzar(22);

                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(true);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;

            case 23:
                Elements modElements23 = new Elements();
                ConsultesElements modCElements23 = new ConsultesElements();
                ControladorElements con23 = new ControladorElements(modElements23, modCElements23, vis);
                con23.inicialitzar(23);

                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(true);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;

            case 24:
                Elements modElements24 = new Elements();
                ConsultesElements modCElements24 = new ConsultesElements();
                ControladorElements con24 = new ControladorElements(modElements24, modCElements24, vis);
                con24.inicialitzar(24);

                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(true);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;

            case 3:
                Usuaris modUsuaris = new Usuaris();
                ConsultesUsuaris modCUsuaris = new ConsultesUsuaris();
                ControladorUsuaris con3 = new ControladorUsuaris(modUsuaris, modCUsuaris, vis);
                con3.inicialitzar();

                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(true);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;
            case 4:
                Grups modGrups = new Grups();
                ConsultesGrups modCGrups = new ConsultesGrups();
                ControladorGrups con4 = new ControladorGrups(modGrups, modCGrups, vis);
                con4.inicialitzar();

                vis.DashTasques.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashGrups.setVisible(true);
                vis.DashNouGrup.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;
            case 5:
                //Configuracio c = new Configuracio();
                ConsultesGrafiques c5 = new ConsultesGrafiques();
                ControladorGrafiques con5 = new ControladorGrafiques(vis, c5);
                con5.inicialitzar();

                vis.DashTasques.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(true);

                break;
            case 6:
                Configuracio c = new Configuracio();
                ConsultesConfiguracio cc = new ConsultesConfiguracio();
                ControladorConfiguracio con6 = new ControladorConfiguracio(vis, cc, c);
                con6.inicialitzar();

                vis.DashTasques.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashConfiguracio.setVisible(true);
                vis.DashNouUsuari.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);
                break;
            case 7:
                String[] botones = {"Sí", "No"};
                int ventana = JOptionPane.showOptionDialog(null, "Esteu segurs de tancar la sessió?", "Tancar Sessió", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                        botones, botones[0]);
                if (ventana == 0) {
                    vis.dispose();
                    Login mod = new Login();
                    ConsultesLogin modC = new ConsultesLogin();
                    JFLogin2 vist = new JFLogin2();
                    ControladorLogin cont = new ControladorLogin(mod, modC, vist, vis, contrasenya, jf);
                    cont.inicialitzar();
                    vist.setVisible(true);
                }

                vis.DashTasques.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashConfiguracio.setVisible(true);
                vis.DashNouUsuari.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashPerfilUsuari.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);

                break;

            case 8:
                Perfil modPerfil = new Perfil();
                ConsultesPerfil modCPerfil = new ConsultesPerfil();
                JFContrasenya contra = new JFContrasenya();
                JFileChooser jf = new JFileChooser();
                ControladorPerfil con8 = new ControladorPerfil(modPerfil, modCPerfil, vis, contra, jf);
                con8.inicialitzar();

                vis.DashPerfilUsuari.setVisible(true);
                vis.DashTasques.setVisible(false);
                vis.DashNovaTasca.setVisible(false);
                vis.DashInfoTasca.setVisible(false);
                vis.DashOrdinadors.setVisible(false);
                vis.DashNouOrdinador.setVisible(false);
                vis.DashInfoOrdinador.setVisible(false);
                vis.DashUsuaris.setVisible(false);
                vis.DashNouUsuari.setVisible(false);
                vis.DashInfoUsuari.setVisible(false);
                vis.DashGrups.setVisible(false);
                vis.DashNouGrup.setVisible(false);
                vis.DashConfiguracio.setVisible(false);
                vis.DashTriaTasca.setVisible(false);
                vis.DashNovaTascaRepeticio.setVisible(false);
                vis.DashInfoTascaRepeticio.setVisible(false);
                vis.DashInfoGrup.setVisible(false);

                vis.DashOrdinadors.setVisible(false);
                vis.DashTelefons.setVisible(false);
                vis.DashInfoTelefon.setVisible(false);
                vis.DashNouTelefon.setVisible(false);
                vis.DashImpresores.setVisible(false);
                vis.DashNouImpresora.setVisible(false);
                vis.DashInfoImpresores.setVisible(false);
                vis.DashServidors.setVisible(false);
                vis.DashNouServidor.setVisible(false);
                vis.DashInfoServidor.setVisible(false);
                vis.DashGrafiques.setVisible(false);

                break;
            default:

                break;
        }

    }

    /* public void mouseClicked(MouseEvent e) {

        if (e.getSource() == vis.jButtonNomUsuari) {

            Perfil modPerfil = new Perfil();
            ConsultesPerfil modCPerfil = new ConsultesPerfil();
            ControladorPerfil con = new ControladorPerfil(modPerfil, modCPerfil, vis, contrasenya, jf);
            con.inicialitzar();

            vis.DashPerfilUsuari.setVisible(true);
            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btnTasques) {

            Tasques modTasques = new Tasques();
            ConsultesTasques modCTasques = new ConsultesTasques();
            ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);
            con.inicialitzar();
            //con.MostrarTaula(vis.jTable_Tasques);

            vis.DashTasques.setVisible(true);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btn_Tasques) {

            Tasques modTasques = new Tasques();
            ConsultesTasques modCTasques = new ConsultesTasques();
            ControladorTasques con = new ControladorTasques(modTasques, modCTasques, vis);
            con.inicialitzar();
            //con.MostrarTaula(vis.jTable_Tasques);

            vis.DashTasques.setVisible(true);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btn_Elements) {

            Elements modElements = new Elements();
            ConsultesElements modCElements = new ConsultesElements();
            ControladorElements con = new ControladorElements(modElements, modCElements, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(true);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btnElements) {

            Elements modElements = new Elements();
            ConsultesElements modCElements = new ConsultesElements();
            ControladorElements con = new ControladorElements(modElements, modCElements, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(true);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btn_Usuaris) {

            Usuaris modUsuaris = new Usuaris();
            ConsultesUsuaris modCUsuaris = new ConsultesUsuaris();
            ControladorUsuaris con = new ControladorUsuaris(modUsuaris, modCUsuaris, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(true);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btnUsuaris) {

            Usuaris modUsuaris = new Usuaris();
            ConsultesUsuaris modCUsuaris = new ConsultesUsuaris();
            ControladorUsuaris con = new ControladorUsuaris(modUsuaris, modCUsuaris, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(true);
            vis.DashNouUsuari.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btnGrup) {

            Grups modGrups = new Grups();
            ConsultesGrups modCGrups = new ConsultesGrups();
            ControladorGrups con = new ControladorGrups(modGrups, modCGrups, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashGrups.setVisible(true);
            vis.DashNouGrup.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btn_Grups) {

            Grups modGrups = new Grups();
            ConsultesGrups modCGrups = new ConsultesGrups();
            ControladorGrups con = new ControladorGrups(modGrups, modCGrups, vis);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(false);
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashGrups.setVisible(true);
            vis.DashNouGrup.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btnConfiguracio) {

            Configuracio c = new Configuracio();
            ConsultesConfiguracio cc = new ConsultesConfiguracio();
            ControladorConfiguracio con = new ControladorConfiguracio(vis, cc, c);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(true);
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if (e.getSource() == vis.btn_Configuracio) {

            Configuracio c = new Configuracio();
            ConsultesConfiguracio cc = new ConsultesConfiguracio();
            ControladorConfiguracio con = new ControladorConfiguracio(vis, cc, c);
            con.inicialitzar();

            vis.DashTasques.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(true);
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

        }

        if ((e.getSource() == vis.btn_TancarSessio) || (e.getSource() == vis.btnTancarSessio)) {

            String[] botones = {"Sí", "No"};
            int ventana = JOptionPane.showOptionDialog(null, "Esteu segurs de tancar la sessió?", "Tancar Sessió", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    botones, botones[0]);
            if (ventana == 0) {
                vis.dispose();
                Login mod = new Login();
                ConsultesLogin modC = new ConsultesLogin();
                JFLogin2 vist = new JFLogin2();
                ControladorLogin cont = new ControladorLogin(mod, modC, vist, vis, contrasenya, jf);
                cont.inicialitzar();
                vist.setVisible(true);
            }

            vis.DashTasques.setVisible(false);
            vis.DashInfoUsuari.setVisible(false);
            vis.DashInfoTasca.setVisible(false);
            vis.DashNovaTasca.setVisible(false);
            vis.DashConfiguracio.setVisible(true);
            vis.DashNouUsuari.setVisible(false);
            vis.DashNouOrdinador.setVisible(false);
            vis.DashUsuaris.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashInfoOrdinador.setVisible(false);
            vis.DashGrups.setVisible(false);
            vis.DashNouGrup.setVisible(false);
            vis.DashPerfilUsuari.setVisible(false);
            vis.DashTriaTasca.setVisible(false);
            vis.DashNovaTascaRepeticio.setVisible(false);
            vis.DashInfoTascaRepeticio.setVisible(false);
            vis.DashInfoGrup.setVisible(false);
            vis.DashTriaElement.setVisible(false);
            vis.DashOrdinadors.setVisible(false);
            vis.DashTelefons.setVisible(false);
            vis.DashInfoTelefon.setVisible(false);
            vis.DashNouTelefon.setVisible(false);

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

    }*/
    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
