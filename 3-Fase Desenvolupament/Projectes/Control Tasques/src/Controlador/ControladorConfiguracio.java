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
import Vista.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Victor
 */
public class ControladorConfiguracio implements ActionListener {

    private Configuracio con;
    private ConsultesConfiguracio modC;
    private JFPrincipal vis;
    public static Boolean so = false;
    public static Boolean enviarCorreu = false;

    public ControladorConfiguracio(JFPrincipal vis, ConsultesConfiguracio modC, Configuracio con) {

        this.vis = vis;
        this.modC = modC;
        this.con = con;
        this.vis.jButtonExportar.addActionListener(this);
        this.vis.jButtonImportar.addActionListener(this);
        this.vis.jCheckBoxSo.addActionListener(this);
        this.vis.jCheckBoxEnviarCorreu.addActionListener(this);

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

    }

}
