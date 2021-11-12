/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Vista.JFPrincipal.tasca_update;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Victor
 */
public class ConsultesTasques extends Conexio {
    
    
    public void MostrarTasques() {

       /* DashInfoUsuari.setVisible(false);
        DashInfoTasca.setVisible(false);
        DashNovaTasca.setVisible(false);
        DashConfiguracio.setVisible(false);
        DashTasques.setVisible(true);
        DashNouUsuari.setVisible(false);
        DashNouElement.setVisible(false);
        DashUsuaris.setVisible(false);
        DashElements.setVisible(false);
        DashInfoElement.setVisible(false);*/

        DefaultTableModel model_tasques = new DefaultTableModel();

        try {

            //jTable_Tasques.setModel(model_tasques);
            model_tasques.fireTableDataChanged();
            try (Connection cn = getConexio()) {
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
                    //addCheckBox(0, jTable_Tasques);

                }

                for (int i = 0; i < cantitatFilas; i++) {

                    model_tasques.setValueAt(false, i, 0);

                }
            }

           /* TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model_tasques);
            jTable_Tasques.setRowSorter(sorter);
            
            List<SortKey> sortKeys = new ArrayList();
            sortKeys.add(new SortKey(4,SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);*/
            
            
        } catch (SQLException e) {

            System.err.println("Error al omplir la taula");
            JOptionPane.showMessageDialog(null, "Error al mostrar la informacio, contacti amb l'administrador");

        }
       // Natejar();
        /*jTable_Tasques.addMouseListener(new MouseAdapter() {

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
    
    
}
