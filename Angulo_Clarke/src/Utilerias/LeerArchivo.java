/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

//import java.awt.image.BufferedImage;
import java.io.File;
//import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author raulsantiago-montero
 */
public class LeerArchivo {
    //variables de instancia

    
    //variables de instancia de atributos

    //métodos de instancia
    //--------------------------------------------------------------------
    //método de instancia que abre el archivo donde se contiene la imagen
    public static String nomArchivo(){
        JFileChooser selector= new JFileChooser();
        File imagenSeleccionada;
        String nombreImg="";
        selector.setDialogTitle("Selección de Imagen");//Encabezado de la ventana
        //se establece el tipo de extensión
        FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG", "PNG", "jpg", "png","jpeg","bmp");
        //se asigna la restricción
        selector.setFileFilter(filtro);
        int bandera = selector.showOpenDialog(null);
        //Se verifica que ha sido abierta la ventana de selección de archivo
        if(bandera==JFileChooser.APPROVE_OPTION){
            try{               
            
            imagenSeleccionada=selector.getSelectedFile();
            
            if (imagenSeleccionada.canRead()){
                nombreImg=imagenSeleccionada.getPath();//
            }//if
            }//try
            catch(Exception e){
              System.out.println("Error al abrir la imagen"+e.getLocalizedMessage()+ " ,"+ e.getMessage());      
            }//catch
        }
              
        //retorno de valor del método
        return nombreImg;
        
        
    }//nomArchivo
    
   
}
