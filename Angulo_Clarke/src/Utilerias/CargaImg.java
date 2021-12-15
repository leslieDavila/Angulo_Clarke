/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author raulsantiago-montero
 */
public class CargaImg extends LeerArchivo{
    
    public static BufferedImage abriImagen(){
        BufferedImage imgOri=null;
        try{
        imgOri=ImageIO.read(new File(nomArchivo()));        
        }//fin try
        
        catch (Exception e) {
                System.out.println("Error class Open image"+ e.getLocalizedMessage()+ ", "+ e.getMessage());
        }//fin catch 
       
        return imgOri;        
    }//fin AbrirImagen

    
}//CargaImg
