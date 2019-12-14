/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvdv.paradigmas.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import javax.swing.WindowConstants;


/**
 *
 * @author Marcos Vicente && Daniel Villalobos
 */
public class ClientInterface extends javax.swing.JFrame {
    private int counter = 0;

    public ClientInterface() {
        Connection connection = new Connection(this);
        initComponents();
        connection.start();
    }

    public void updateAirplaneContentText(ArrayList<String> text) {
        String textToSet = "";

        for (String suitcase : text) {
            if (this.counter % 5 == 0 && this.counter != 0) {
                textToSet += "\n";
                this.counter = 0;
            }
            textToSet += (this.counter == 0) ? suitcase : "\t" + suitcase;

            this.counter += 1;

        }
        this.airplaneContent.append(textToSet);
    }

    public void updateConveyorContentText(ArrayList<String> text){
        String textToSet = "";
        int conveyorCounter = 0;

        for (String suitcase: text){
            if (conveyorCounter % 4 == 0 && conveyorCounter != 0){
                textToSet += "\n";
                conveyorCounter = 0;
            }
            textToSet += (conveyorCounter == 0) ? suitcase : "\t" + suitcase;
            conveyorCounter += 1;
        }
        this.suitcaseContent.setText(textToSet);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        airplaneContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        suitcaseContent = new javax.swing.JTextArea();

        jTextArea4.setColumns(20);
        jTextArea4.setRows(1);
        jScrollPane4.setViewportView(jTextArea4);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ejemplo de Ventana");
        setBackground(new java.awt.Color(0, 0, 0));
        setFont(new java.awt.Font("Open Sans", 0, 10)); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                System.exit(0);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        airplaneContent.setEditable(false);
        airplaneContent.setColumns(20);
        airplaneContent.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        airplaneContent.setForeground(new java.awt.Color(72, 72, 85));
        airplaneContent.setRows(30);
        airplaneContent.setBorder(null);
        airplaneContent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        airplaneContent.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        airplaneContent.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane9.setViewportView(airplaneContent);

        jLabel1.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(72, 72, 85));
        jLabel1.setText("Airplane content");

        jLabel4.setFont(new java.awt.Font("Open Sans", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(72, 72, 85));
        jLabel4.setText("Suitcase conveyor content");

        suitcaseContent.setEditable(false);
        suitcaseContent.setColumns(20);
        suitcaseContent.setFont(new java.awt.Font("Open Sans", 0, 20)); // NOI18N
        suitcaseContent.setForeground(new java.awt.Color(72, 72, 85));
        suitcaseContent.setRows(2);
        suitcaseContent.setBorder(null);
        suitcaseContent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        suitcaseContent.setDisabledTextColor(new java.awt.Color(72, 72, 85));
        suitcaseContent.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane13.setViewportView(suitcaseContent);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(116, 116, 116)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 911,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 911,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(405, 405, 405).addComponent(jLabel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup().addGap(335, 335, 335).addComponent(jLabel4,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(2125, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup().addGap(20, 20, 20).addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1).addGap(18, 18, 18).addComponent(jScrollPane9,
                                javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel1,
                                javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        setBounds(0, 0, 1127, 476);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientInterface.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientInterface().setVisible(true);
            }
        });
    }

    private javax.swing.JTextArea airplaneContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea suitcaseContent;
}
