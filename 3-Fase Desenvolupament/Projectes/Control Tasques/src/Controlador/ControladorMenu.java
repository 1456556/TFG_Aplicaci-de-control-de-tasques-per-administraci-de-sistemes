/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Configuracio;
import Model.ConsultesConfiguracio;
import Model.ConsultesElements;
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
import Vista.JFLogin;
import Vista.JFPrincipal;
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

    private JFPrincipal vis;
    private JFileChooser jf;
    String newLine = System.getProperty("line.separator");

    public ControladorMenu(JFPrincipal vis, JFContrasenya contrasenya, JFileChooser jf) {

        this.vis = vis;
        addMouseListener(this);
        this.vis.setVisible(true);
        this.jf = jf;
        this.contrasenya = contrasenya;
        this.vis.btnTasques.addMouseListener(this);
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
        this.vis.btn_TancarSessio.addMouseListener(this);

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
        vis.DashTriaElement.setVisible(false);
        vis.DashOrdinadors.setVisible(false);
        vis.DashTelefons.setVisible(false);
        vis.DashInfoTelefon.setVisible(false);
        vis.DashNouTelefon.setVisible(false);

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
        vis.DashTriaElement.setVisible(false);
        vis.DashOrdinadors.setVisible(false);
        vis.DashTelefons.setVisible(false);
        vis.DashInfoTelefon.setVisible(false);
        vis.DashNouTelefon.setVisible(false);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

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
                JFLogin vist = new JFLogin();
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

    }

}
