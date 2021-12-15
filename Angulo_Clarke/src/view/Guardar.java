package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import model.ConexionBD;
import model.Datos;
import controlador.FotoPanel;
import controlador.manejoImagen;

/**
 *
 * @author karen
 */
public class Guardar extends javax.swing.JFrame {

    Datos e = new Datos();
    private int Id, Edad, comprobado, R;
    BufferedImage nana, nana2;
    private float Estatura, Peso, obtener3, obtener4;
    private String Nombre, Genero, obtener1, obtener2, url_Izq, url_Der;
    private JPanel panelDatos, panelFotos, panelInferior, panelOrdenado;
    private JLabel lblId, lblNombre, lblEstatura, lblPeso, lblSexo, lblEdad, lblResultado, lblImagen, lblImagen2, lblResultado2;
    private JTextField TF_Id, TF_Nombre, TF_Estatura, TF_Peso, TF_Genero, TF_Edad, TF_R_pieDerecho, TF_R_pieIzquierdo;

    public Guardar() {
        initComponents();

        //Declaramos nuestros componentes
        panelDatos = new JPanel();
        panelFotos = new JPanel();
        panelInferior = new JPanel();
        panelOrdenado = new JPanel();
        lblId = new JLabel();
        lblNombre = new JLabel();
        lblEstatura = new JLabel();
        lblPeso = new JLabel();
        lblSexo = new JLabel();
        lblEdad = new JLabel();
        lblResultado = new JLabel();
        lblImagen = new JLabel();
        lblImagen2 = new JLabel();
        lblResultado2 = new JLabel();
        TF_Id = new JTextField();
        TF_Nombre = new JTextField();
        TF_Estatura = new JTextField();
        TF_Peso = new JTextField();
        TF_Genero = new JTextField();
        TF_Edad = new JTextField();
        TF_R_pieIzquierdo = new JTextField();
        TF_R_pieDerecho = new JTextField();

        //armado
        panelDatos.setLayout(new BoxLayout(panelDatos, BoxLayout.Y_AXIS));
        panelFotos.setLayout(new BoxLayout(panelFotos, BoxLayout.Y_AXIS));

        panelInferior.setLayout(new FlowLayout());
//panel datos
        panelDatos.add(lblId);
        lblId.setText("Id del archivo:");
        panelDatos.add(TF_Id);

        panelDatos.add(lblNombre);
        lblNombre.setText("Nombre archivo:");
        panelDatos.add(TF_Nombre);

        panelDatos.add(lblEstatura);
        lblEstatura.setText("Estatura:");
        panelDatos.add(TF_Estatura);

        panelDatos.add(lblPeso);
        lblPeso.setText("Peso:");
        panelDatos.add(TF_Peso);

        panelDatos.add(lblSexo);
        lblSexo.setText("Genero:");
        panelDatos.add(TF_Genero);

        panelDatos.add(lblEdad);
        lblEdad.setText("Edad:");
        panelDatos.add(TF_Edad);

        //panel imagen
        FotoPanel datos = new FotoPanel();

        nana = datos.pieD;
        nana2 = datos.pieI;
        ImageIcon iconLogo = new ImageIcon(nana);
        ImageIcon iconLogo2 = new ImageIcon(nana2);
        Icon iconoP = new ImageIcon(iconLogo.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT));
        Icon iconoP2 = new ImageIcon(iconLogo2.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT));
        panelFotos.add(new JSeparator());
        panelFotos.add(lblImagen);
        lblImagen.setIcon(iconoP);
        panelFotos.add(new JSeparator());
        panelFotos.add(lblImagen2);
        lblImagen2.setIcon(iconoP2);
        panelFotos.add(new JSeparator());

//panel abajo
        panelInferior.add(btn_guardar);

        setLayout(new BorderLayout());
        add(panelDatos, BorderLayout.CENTER);
        add(panelFotos, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        setLocationRelativeTo(null);
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
        setTitle("Datos del paciente");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_guardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_guardar.setText("Guardar");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(btn_guardar)
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(262, Short.MAX_VALUE)
                .addComponent(btn_guardar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        Comprobar();
        // if(variable devuelta en comprobar  == 1)
        //else mensaje de que ingrese todos los datos

        if (comprobado == 1) {

            Asignar();
            //enviarlos a la base de datos
            ConexionBD conectar = new ConexionBD();
            conectar.save(e);
            JOptionPane.showMessageDialog(null, "Guardado");
            setVisible(false);
        }

    }//GEN-LAST:event_btn_guardarActionPerformed
    private void Asignar() {
        //obtener los datos de la ventana de guardado

        Id = Integer.parseInt(TF_Id.getText());
        Nombre = TF_Nombre.getText();
        Estatura = Float.parseFloat(TF_Estatura.getText());
        Peso = Float.parseFloat(TF_Peso.getText());
        Genero = TF_Genero.getText();
        Edad = Integer.parseInt(TF_Edad.getText());
        //Asignar los datos obtenidos a Datos para mejor manejo
        e.setID(Id);
        e.setNombre(Nombre);
        e.setEstatura(Estatura);
        e.setPeso(Peso);
        e.setGenero(Genero);
        e.setEdad(Edad);
        //Valores numericos
        e.setD_derecho(obtener1);
        e.setD_izquierdo(obtener2);
        e.setR_pieDerecho(obtener3);
        e.setR_pieIzquierdo(obtener4);
        //Se hace el guardado de las imagenes en la carpeta
        manejoImagen guardado = new manejoImagen();
        //Se obtienen las rutas donde se guardaron 
        url_Izq = guardado.guardar_Izq(nana2, Nombre);
        url_Der = guardado.guardar_Der(nana, Nombre);
        //Se asignan a Datos para mejor manejo
        e.setUrlDerecho(url_Der);
        e.setUrlIzquierdo(url_Izq);
    }

    public void recibir(Datos e) {
        obtener1 = e.getD_derecho();
        obtener2 = e.getD_izquierdo();
        obtener3 = e.getR_pieDerecho();
        obtener4 = e.getR_pieIzquierdo();

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_guardar;
    // End of variables declaration//GEN-END:variables

    private void Comprobar() {


        if (TF_Id.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar el ID");
        } else if (TF_Nombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar Nombre de archivo");
        } else if (TF_Estatura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar la estatura");
        } else if (TF_Peso.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar el peso");
        } else if (TF_Genero.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar el genero del paciente");
        } else if (TF_Edad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingresar la edad");
        } else {
            comprobado =1;

        }
     
    }//final comprobar

}//final clase
