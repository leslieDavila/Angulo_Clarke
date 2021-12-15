/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Figura;
import model.Point;
import controlador.PaintingPanel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import java.awt.image.BufferedImage;
import java.io.ObjectInputStream;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import model.Datos;
import controlador.FotoPanel;
import controlador.calculos;
import controlador.manejoImagen;

/**
 *
 * @author karen
 */
public class ventana extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    public PaintingPanel pp;
    private calculos calcular;
    private JPanel toolPanel, panelInferior, separacion, panelImg, imgPanel, imgPanel2, foto1, foto2, foto3;
    private JLabel labelNombreImagen, lblFoto1, lblFoto2, lblFoto3, lblFoto11, lblFoto22, lblFoto33, lblR1, lblR2, lblR3, lblR11, lblR22, lblR33;

    private Point origen, destino;
    private boolean clicked, input;
    private int seleccion;
    private ArrayList<Figura> lista;
    private Color color;
    double angulofinal;
    File archivo;

    public class Imagen extends javax.swing.JPanel {

        public Imagen() {
            this.setSize(1000, 1000); //se selecciona el tamaño del panel
        }
    }

    public ventana() {
        //Apariencia de la ventana
        try {
            UIManager.setLookAndFeel(new AluminiumLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Declaramos nuestros componentes
        initComponents();
        seleccion = 0;
        clicked = false;
        input = false;
        origen = new Point();
        destino = new Point();
        lista = new ArrayList<Figura>();
        toolPanel = new JPanel();
        panelInferior = new JPanel();
        panelImg = new JPanel();
        imgPanel = new JPanel();
        imgPanel2 = new JPanel();
        labelNombreImagen = new JLabel();
        lblFoto1 = new JLabel();
        lblFoto2 = new JLabel();
        lblFoto3 = new JLabel();
        lblR1 = new JLabel();
        lblR2 = new JLabel();
        lblR3 = new JLabel();
        lblFoto11 = new JLabel();
        lblFoto22 = new JLabel();
        lblFoto33 = new JLabel();
        lblR11 = new JLabel();
        lblR22 = new JLabel();
        lblR33 = new JLabel();
        separacion = new JPanel();
        foto1 = new JPanel();
        foto2 = new JPanel();
        foto3 = new JPanel();
        Icon icono = null;

        pp = new PaintingPanel(origen, destino, lista, icono);
        calcular = new calculos();
        // Se comienza a armar nuestra ventana 

        toolPanel.setLayout(new FlowLayout());
        panelInferior.setLayout(new FlowLayout());
        separacion.setLayout(new FlowLayout());
        imgPanel.setLayout(new BoxLayout(imgPanel, BoxLayout.Y_AXIS));
        imgPanel2.setLayout(new BoxLayout(imgPanel2, BoxLayout.Y_AXIS));
        //panel de herramientas
        toolPanel.add(btn_nuevo);
        toolPanel.add(btn_abrir);
        toolPanel.add(btn_abrirDerecho);
        toolPanel.add(btn_abrirIzquierdo);
        toolPanel.add(btn_borrar);
        toolPanel.add(btn_linea1);
        toolPanel.add(btn_linea2);
        toolPanel.add(btn_calcular);
        toolPanel.add(btn_color);
        //panel inferior
        panelInferior.add(new JSeparator());
        panelInferior.add(labelNombreImagen);
        panelInferior.add(new JSeparator());
        panelInferior.add(btn_guardarDato);
        panelInferior.add(btn_guardarAnalisis);
        panelInferior.add(new JSeparator());
// Primer panel de imagenes de analisis 
        ImageIcon iconLogo = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        Icon iconoP = new ImageIcon(iconLogo.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT));
        imgPanel.add(new JSeparator());
        imgPanel.add(lblFoto1);
        lblFoto1.setIcon(iconoP);
        imgPanel.add(lblR1);
        lblR1.setText("Resultado 1");
        imgPanel.add(new JSeparator());
        imgPanel.add(lblFoto2);
        lblFoto2.setIcon(iconoP);
        imgPanel.add(lblR2);
        lblR2.setText("Resultado 1");
        imgPanel.add(new JSeparator());
        imgPanel.add(lblFoto3);
        lblFoto3.setIcon(iconoP);
        imgPanel.add(lblR3);
        lblR3.setText("Resultado 1");
        imgPanel.add(new JSeparator());
//segundo panel de imagenes
        imgPanel2.add(new JSeparator());
        imgPanel2.add(lblFoto11);
        lblFoto11.setIcon(iconoP);
        imgPanel2.add(lblR11);
        lblR11.setText("Resultado 2");
        imgPanel2.add(new JSeparator());
        imgPanel2.add(lblFoto22);
        lblFoto22.setIcon(iconoP);
        imgPanel2.add(lblR22);
        lblR22.setText("Resultado 2");
        imgPanel2.add(new JSeparator());
        imgPanel2.add(lblFoto33);
        lblFoto33.setIcon(iconoP);
        imgPanel2.add(lblR33);
        lblR33.setText("Resultado 2");
        imgPanel2.add(new JSeparator());
        //acomodo de los paneles 
        setLayout(new BorderLayout());
        add(toolPanel, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelImg, BorderLayout.EAST);
        panelImg.add(imgPanel);
        panelImg.add(imgPanel2);
        pp.add(lblFoto);
        add(separacion, BorderLayout.WEST);
        pp.addMouseListener(this);
        pp.addMouseMotionListener(this);
        add(pp, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setTitle("Menú principal");
        btn_linea1.addActionListener(this);
        btn_linea2.addActionListener(this);
        btn_color.addActionListener(this);
        btn_abrir.addActionListener(this);
        btn_abrirDerecho.addActionListener(this);
        btn_abrirIzquierdo.addActionListener(this);
        btn_nuevo.addActionListener(this);
        btn_guardarAnalisis.addActionListener(this);
        btn_guardarDato.addActionListener(this);
        btn_calcular.addActionListener(this);
        btn_borrar.addActionListener(this);

    }
    //variables para mas de un metodo.
    FotoMarco frame = new FotoMarco();
    calculos resultado = new calculos();
    Datos e = new Datos();
    
    File fichero;
    String tipo, tipo2, diagnostico, url_Izq, url_Der;
    double anguloRedondeado, primerAngulo, segundoAngulo;

    int c1 = 0, c2 = 0, c3 = 0, alto, ancho;

    @Override
    //para obtener los img y dibujar las lineas
    public void mouseClicked(MouseEvent e) {
        if (!clicked) {
            origen.setX(e.getX());
            origen.setY(e.getY());
            pp.setColor(color);
            clicked = true;
        } else {
            destino.setX(e.getX());
            destino.setY(e.getY());
            lista.add(new Figura(seleccion, new Point(origen), new Point(destino), color));
            clicked = false;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (clicked) {
            destino.setX(e.getX());
            destino.setY(e.getY());
            pp.repaint();
        }
    }

    @Override
    // acción para el boton de nuevo
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_nuevo) {
            lista.clear();
            pp.repaint();
            pp.removeAll();
            pp.setIcon(null);

            frame.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton5 = new javax.swing.JButton();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jSeparator1 = new javax.swing.JSeparator();
        btn_abrirDerecho = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_guardarAnalisis = new javax.swing.JButton();
        btn_linea1 = new javax.swing.JButton();
        btn_linea2 = new javax.swing.JButton();
        btn_calcular = new javax.swing.JButton();
        btn_color = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_abrirIzquierdo = new javax.swing.JButton();
        btn_guardarDato = new javax.swing.JButton();
        btn_abrir = new javax.swing.JButton();

        jButton5.setText("jButton5");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_abrirDerecho.setText("Abrir Pie Derecho");
        btn_abrirDerecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirDerechoActionPerformed(evt);
            }
        });

        btn_borrar.setText("Borrar");
        btn_borrar.setMaximumSize(new java.awt.Dimension(61, 25));
        btn_borrar.setMinimumSize(new java.awt.Dimension(61, 25));
        btn_borrar.setPreferredSize(new java.awt.Dimension(61, 25));
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_guardarAnalisis.setText("Guardar Analisis");
        btn_guardarAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarAnalisisActionPerformed(evt);
            }
        });

        btn_linea1.setText("Linea 1");
        btn_linea1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_linea1ActionPerformed(evt);
            }
        });

        btn_linea2.setText("Linea 2");
        btn_linea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_linea2ActionPerformed(evt);
            }
        });

        btn_calcular.setText("Calcular");
        btn_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularActionPerformed(evt);
            }
        });

        btn_color.setText("Color");
        btn_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_colorActionPerformed(evt);
            }
        });

        btn_nuevo.setText("Nuevo");

        btn_abrirIzquierdo.setText("Abrir Pie Izquierdo");
        btn_abrirIzquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirIzquierdoActionPerformed(evt);
            }
        });

        btn_guardarDato.setText("Guardar Primer Dato ");
        btn_guardarDato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarDatoActionPerformed(evt);
            }
        });

        btn_abrir.setText("Abrir");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(btn_guardarDato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_guardarAnalisis)
                .addGap(269, 269, 269))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_nuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_abrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_abrirDerecho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_abrirIzquierdo)
                .addGap(29, 29, 29)
                .addComponent(btn_linea1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_linea2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_color)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_calcular)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_linea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_linea2)
                    .addComponent(btn_color)
                    .addComponent(btn_borrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_calcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_abrirIzquierdo)
                    .addComponent(btn_abrirDerecho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_abrir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_guardarAnalisis)
                    .addComponent(btn_guardarDato))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btn_abrirDerechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirDerechoActionPerformed
        //analisis

        // PONER IMAGEN  
        FotoPanel datos = new FotoPanel();
        BufferedImage nana = datos.pieD;
        if (nana == null) {
            JOptionPane.showMessageDialog(null, "Realiza el recorte de las imagenes primero");

        } else {
            JOptionPane.showMessageDialog(null, "Abriendo imagen pie derecho");
            ImageIcon icon = new ImageIcon(nana);
            Icon icono2 = new ImageIcon(icon.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT));
            pp.setIcon(icono2);
        }
    }//GEN-LAST:event_btn_abrirDerechoActionPerformed

    private void btn_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_colorActionPerformed
        color = JColorChooser.showDialog(null, "Selecciona un color...", Color.RED);
    }//GEN-LAST:event_btn_colorActionPerformed

    private void btn_linea1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_linea1ActionPerformed
        FotoPanel img = new FotoPanel();
        if (img.pieD == null && img.pieI == null) {
            JOptionPane.showMessageDialog(null, "Realice el recorte de las imagenes primero");
        } else {
            seleccion = PaintingPanel.LINEA;
            pp.setSeleccion(seleccion);
        }
    }//GEN-LAST:event_btn_linea1ActionPerformed

    private void btn_linea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_linea2ActionPerformed
        FotoPanel img = new FotoPanel();
        if (img.pieD == null && img.pieI == null) {
            JOptionPane.showMessageDialog(null, "Realice el recorte de las imagenes primero");
        } else {
            seleccion = PaintingPanel.LINEA2;
            pp.setSeleccion(seleccion);
        }
    }//GEN-LAST:event_btn_linea2ActionPerformed

    private void btn_guardarAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarAnalisisActionPerformed

        FotoPanel img = new FotoPanel();
        if (img.pieD == null && img.pieI == null) {
            JOptionPane.showMessageDialog(null, "Realice un analisis primero");
        } else {
            segundoAngulo = anguloRedondeado;
            tipo2 = resultado.diagnostico(angulofinal);
            //asignar diagnostico
            e.setD_izquierdo(tipo2);
            e.setD_derecho(tipo);
            //asignar resultado
            e.setR_pieIzquierdo((float) segundoAngulo);
            e.setR_pieDerecho((float) primerAngulo);
            //enviar diagnostico a guardar y abrir guardar
            Guardar enviar = new Guardar();
            enviar.recibir(e);
            enviar.setVisible(true);

            //colocación de las fotos en el lateral
            BufferedImage nana = img.pieD;
            BufferedImage nana2 = img.pieI;
            ImageIcon icon = new ImageIcon(nana);
            ImageIcon icon2 = new ImageIcon(nana2);
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT));
            Icon icono2 = new ImageIcon(icon2.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT));
            if (c1 == 0) {
                lblFoto1.setIcon(icono2);
                lblFoto11.setIcon(icono);

                lblR1.setText("Resultado:" + tipo2 + " con: " + segundoAngulo + "°");
                lblR11.setText("Resultado:" + tipo + " con: " + primerAngulo + "°");
                c1 = 1;
            } else if (c2 == 0) {
                lblFoto2.setIcon(icono2);
                lblFoto22.setIcon(icono);

                lblR2.setText("Resultado:" + tipo2 + " con: " + segundoAngulo + "°");
                lblR22.setText("Resultado:" + tipo + " con: " + primerAngulo + "°");
                c2 = 1;
            } else if (c3 == 0) {
                lblFoto3.setIcon(icono2);
                lblFoto33.setIcon(icono);
                lblR3.setText("Resultado:" + tipo2 + " con: " + segundoAngulo + "°");
                lblR33.setText("Resultado:" + tipo + " con: " + primerAngulo + "°");
                c3 = 1;
                c1 = 0;
            }
        }

    }//GEN-LAST:event_btn_guardarAnalisisActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        
        seleccion = PaintingPanel.BORRAR;
        pp.setSeleccion(seleccion);
        pp.repaint();
        lista.clear();
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularActionPerformed
        // TODO add your handling code here: 
        anguloRedondeado = Math.round(Math.abs(pp.resultadoFinal()));
        angulofinal = Math.abs(pp.resultadoFinal());
        if (anguloRedondeado == 0) {
            JOptionPane.showMessageDialog(null, "El angulo no puede ser 0, revise que las lineas esten trazadas");
        } else {
            diagnostico = resultado.diagnostico(angulofinal);
            JOptionPane.showMessageDialog(null, "Valor del angulo: " + anguloRedondeado + "\n" + "El angulo de Clarke indica un pie " + diagnostico);

        }

        //resultado.diagnostico(angulofinal);

    }//GEN-LAST:event_btn_calcularActionPerformed

    private void btn_abrirIzquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirIzquierdoActionPerformed

        //                    PONER IMAGEN 
        FotoPanel datos = new FotoPanel();
        BufferedImage nana = datos.pieI;
        if (nana == null) {
            JOptionPane.showMessageDialog(null, "Realiza el recorte de las imagenes primero");

        } else {
            JOptionPane.showMessageDialog(null, "Abriendo imagen pie izquierdo");
            ImageIcon icon = new ImageIcon(nana);
            Icon icono2 = new ImageIcon(icon.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT));
            pp.setIcon(icono2);
        }
    }//GEN-LAST:event_btn_abrirIzquierdoActionPerformed

    private void btn_guardarDatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarDatoActionPerformed
        // TODO add your handling code here:    
        if (anguloRedondeado == 0) {
            JOptionPane.showMessageDialog(null, "Realice un calculo primero");
        } else {
            primerAngulo = anguloRedondeado;
            tipo = resultado.diagnostico(angulofinal);
            JOptionPane.showMessageDialog(null, "Primer Dato guardado procesa con el siguiente analisis");
        }
    }//GEN-LAST:event_btn_guardarDatoActionPerformed

    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed
        // TODO add your handling code here:
        Abrir ventanAbrir = new Abrir();
        ventanAbrir.setVisible(true);
    }//GEN-LAST:event_btn_abrirActionPerformed

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_abrir;
    private javax.swing.JButton btn_abrirDerecho;
    private javax.swing.JButton btn_abrirIzquierdo;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_calcular;
    private javax.swing.JButton btn_color;
    private javax.swing.JButton btn_guardarAnalisis;
    private javax.swing.JButton btn_guardarDato;
    private javax.swing.JButton btn_linea1;
    private javax.swing.JButton btn_linea2;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton jButton5;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFoto;
    // End of variables declaration//GEN-END:variables
}
