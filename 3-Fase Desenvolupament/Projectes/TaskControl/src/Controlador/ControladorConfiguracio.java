/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Configuracio;
import Model.ConsultesConfiguracio;
import Vista.JFExportar;
import Vista.JFImportar;
import Vista.JFPrincipal2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class ControladorConfiguracio implements ActionListener {

    private Configuracio con;
    private ConsultesConfiguracio modC;
    private JFPrincipal2 vis;
    public static Boolean so = false;
    public static Boolean enviarCorreu = false;
    public static Boolean dobleFactor = false;

    public ControladorConfiguracio(JFPrincipal2 vis, ConsultesConfiguracio modC, Configuracio con) {

        this.vis = vis;
        this.modC = modC;
        this.con = con;
        this.vis.jButtonExportar.addActionListener(this);
        this.vis.jButtonImportar.addActionListener(this);
        this.vis.jCheckBoxSo.addActionListener(this);
        this.vis.jCheckBoxEnviarCorreu.addActionListener(this);
        this.vis.jCheckBox2FA.addActionListener(this);

    }

    public void inicialitzar() {

        modC.isSo(con);
        if (con.getSo()) {

            vis.jCheckBoxSo.setSelected(true);

        } else {
            vis.jCheckBoxSo.setSelected(false);

        }

        modC.isEnviarCorreu(con);
        if (con.getEnviarCorreu()) {

            vis.jCheckBoxEnviarCorreu.setSelected(true);

        } else {
            vis.jCheckBoxEnviarCorreu.setSelected(false);

        }
        modC.isdobleFactor(con);
        if (con.getDobleFactor()) {

            vis.jCheckBox2FA.setSelected(true);

        } else {
            vis.jCheckBox2FA.setSelected(false);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vis.jButtonImportar) {

            new JFImportar().setVisible(true);

        }

        if (e.getSource() == vis.jButtonExportar) {

            new JFExportar().setVisible(true);

        }

        if (e.getSource() == vis.jCheckBoxSo) {

            if (vis.jCheckBoxSo.isSelected()) {
                so = true;
                con.setSo(true);
                modC.so(con);

            } else {
                so = false;
                con.setSo(false);
                modC.so(con);

            }

        }

        if (e.getSource() == vis.jCheckBoxEnviarCorreu) {

            if (vis.jCheckBoxEnviarCorreu.isSelected()) {
                enviarCorreu = true;
                con.setEnviarCorreu(true);
                modC.enviarCorreu(con);

            } else {
                enviarCorreu = false;
                con.setEnviarCorreu(false);
                modC.enviarCorreu(con);

            }

        }

        if (e.getSource() == vis.jCheckBox2FA) {

            if (vis.jCheckBox2FA.isSelected()) {
                dobleFactor = true;
                con.setDobleFactor(true);
                modC.dobleFactor(con);

            } else {
                dobleFactor = false;
                con.setDobleFactor(false);
                modC.dobleFactor(con);

            }

        }

    }

}
