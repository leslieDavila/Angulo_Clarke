package view;

import java.awt.BorderLayout;
import controlador.FotoPanel;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class FotoMarco extends javax.swing.JFrame {

    private FotoPanel photoPanel;

    File fichero;
    int  bandera1,bandera2;



    /**
     * Creates new form PhotoFrame
     */
    public FotoMarco() {
        initComponents();
        photoPanel = new FotoPanel();
        FotoMarco.this.setTitle("Recortar imagen");
        FotoMarco.this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(jPanel1, BorderLayout.NORTH);
        jPanel1.add(photoPanel);
        add(jPanel2, BorderLayout.SOUTH);
        jPanel2.add(btn_listo);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_listo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        btn_listo.setText("Listo");
        btn_listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_listoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 892, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(btn_listo)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 6, Short.MAX_VALUE)
                    .addComponent(btn_listo)
                    .addGap(0, 6, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Seleccionar imagen");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG, GIF & PNG", "jpg", "png", "gif", "bmp");
        fileChooser.setFileFilter(filtro);
        fileChooser.setCurrentDirectory(fileChooser.getCurrentDirectory());
        int result = fileChooser.showOpenDialog(null);
        fichero = fileChooser.getSelectedFile();

        if (result == JFileChooser.APPROVE_OPTION) {

            try {
                Image image = ImageIO.read(fichero);
                photoPanel.setPhoto(image.getScaledInstance(jPanel1.getWidth(), jPanel1.getHeight(), Image.SCALE_DEFAULT), fileChooser.getSelectedFile().getName());
                photoPanel.banderaD = 0;
                photoPanel.banderaI = 0;
            } catch (IOException ex) {
                System.err.println("Error: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_listoActionPerformed
        // TODO add your handling code here:

            bandera1 = photoPanel.banderaD;
            bandera2 = photoPanel.banderaI;
         System.out.println("Metodo listo" + "bandera derecha" + bandera1 + "  bandera izquieda: " + bandera2);
        if (bandera1 == 1) {
            if (bandera2 == 1) {
                setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Por favor asignar imagen a pie izquierdo");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor asignar imagen a pie derecho");
        }


    }//GEN-LAST:event_btn_listoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_listo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables






}
