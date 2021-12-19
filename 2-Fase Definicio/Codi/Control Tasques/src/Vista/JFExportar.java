/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import Controlador.ControladorConfiguracio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class JFExportar extends javax.swing.JFrame {

    /**
     * Creates new form Exportar
     */
    public JFExportar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtruta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Exportar una base de datos");

        txtruta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Seleccionar Carpeta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setText("Exportar BD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtruta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addComponent(jButton2)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        JFileChooser ch = new JFileChooser();
        ch.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int se = ch.showSaveDialog(null);
        if(se == JFileChooser.APPROVE_OPTION){
            String ruta = ch.getSelectedFile().getPath();
            txtruta.setText(ruta);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String ruta = txtruta.getText();
        System.out.println("Ruta"+ruta);
        String name = "backup.sql";
       
        if(ruta.trim().length()!=0){
           /* try{
                backus = "docker exec c95b62aa59f9 /usr/bin/mysqldump --opt -u"+Conectar.getUs()+" -p"+Conectar.getPas()+" -B "+Conectar.getBd()+" -r "+ruta+name;
                //backus = "docker exec c95b62aa59f9 /usr/bin/mysqldump --opt -u root --password=mypassword testdb >  -r "+ruta+name;
                Runtime rt = Runtime.getRuntime();
                rt.exec(backus);
                JOptionPane.showMessageDialog(null, "Backus creado: "+ruta);
            }catch(HeadlessException | IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }*/
       
       
       FileWriter myWriter = null;
        try {

            File fichero = new File(ruta+"/temp.sql");
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("docker", "exec", "db", "/usr/bin/mysqldump", "-u", "root", "--password=mypassword", "-B", "testdb");
            myWriter = new FileWriter(ruta+"/temp.sql");

            try {

                Writer fstream = null;                
                fstream = new OutputStreamWriter(new FileOutputStream(ruta+"/temp.sql"));
                Process process = processBuilder.start();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;

                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                    builder.append(System.getProperty("line.separator"));
                    System.out.println("DINS");
                }
                String result = builder.toString();                
                fstream.write(result);               
                System.out.println("RESULT" + builder);

                try ( BufferedWriter writer = new BufferedWriter(new FileWriter(fichero))) {
                    writer.write(builder.toString());
                }

                int exitCode = process.waitFor();
                System.out.println("\n Exited with error code : " + exitCode);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorConfiguracio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                myWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(ControladorConfiguracio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {

            File inputFile = new File(ruta+"/temp.sql");
            File tempFile = new File(ruta+"/"+name);

            String lineToRemove = "";
            BufferedReader reader = null;
            BufferedWriter writer = null;
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            lineToRemove = "USE `testdb`;";

            while ((currentLine = reader.readLine()) != null) {
                
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            
            writer.close();
            reader.close();
           
       

        } catch (IOException ex) {
            Logger.getLogger(ControladorConfiguracio.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       try {
                 
                String linea;
                Runtime.getRuntime().exec("rm -f temp.sql", null, new File(ruta+"/"));
               
               /* BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));      
               
               while ((linea = input.readLine()) != null) {
                   System.out.println(linea);
               }*/
           
                JOptionPane.showMessageDialog(null, "Backup Exportat: " + ruta + name);
               // Runtime.getRuntime().exec("rm -f temp.sql", null, new File(ruta+"/"));
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null, err.getMessage());
            }
        
        }
    }//GEN-LAST:event_jButton2ActionPerformed

   
    
    
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
            java.util.logging.Logger.getLogger(JFExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFExportar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFExportar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTextField txtruta;
    // End of variables declaration//GEN-END:variables
}
