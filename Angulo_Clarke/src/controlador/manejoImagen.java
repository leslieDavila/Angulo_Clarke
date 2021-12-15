/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import view.Previa;

/**
 *
 * @author karen
 */
public class manejoImagen extends javax.swing.JFrame {

    String url_Izq, url_Der;

    /**
     * Directorio donde guardar los recortes
     */
    public String guardar_Izq(BufferedImage e, String ee) {
        String Nombre_Archivo = String.valueOf(ee);
        File directorio = new File("C:\\Users\\karen\\Desktop\\RESIDENCIAS\\ImagenesRecortadas\\" + Nombre_Archivo);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
        try {
            //se escribe en disco            

            ImageIO.write(e, "jpg", new File(directorio + "\\" + Nombre_Archivo + "_izquierdo" + ".jpg"));
            url_Izq = directorio + "\\" + Nombre_Archivo + "_izquierdo" + ".jpg";
            //System.out.println("Obtuve la siguiente ruta " + url_Izq);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return url_Izq;
    }

    public String guardar_Der(BufferedImage e, String ee) {
        try {
            //se escribe en disco            
            String Nombre_Archivo = String.valueOf(ee);
            File directorio = new File("C:\\Users\\karen\\Desktop\\RESIDENCIAS\\ImagenesRecortadas\\" + Nombre_Archivo);

            ImageIO.write(e, "jpg", new File(directorio + "\\" + Nombre_Archivo + "_derecho" + ".jpg"));
            url_Der = directorio + "\\" + Nombre_Archivo + "_derecho" + ".jpg";
           // System.out.println("Obtuve la siguiente ruta " + url_Der);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return url_Der;
    }
}
