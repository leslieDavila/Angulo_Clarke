/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import javax.swing.UIManager;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        setSize(465,845);
        ImageIcon foto = new ImageIcon(getClass().getResource("/imagenes/fondoInicio.png"));
        Icon iconoFinal = new ImageIcon(foto.getImage().getScaledInstance(450, 800, Image.SCALE_DEFAULT));

        FotoInicio.setIcon(iconoFinal);
         setTitle("Inicio");
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FotoInicio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        FotoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FotoInicioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FotoInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FotoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FotoInicioMouseClicked
        ventana caca = new ventana();
        caca.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_FotoInicioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FotoInicio;
    // End of variables declaration//GEN-END:variables
}
