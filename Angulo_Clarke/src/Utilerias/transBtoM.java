/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.image.BufferedImage;

/**
 *
 * @author raulsantiago-montero
 */
public class transBtoM extends CargaImg{
    
    public static void deBaM(int [][] matrizImagen, BufferedImage imagen ){
    //Extrael los componentes de la imagen
    //Se requiere conocer el tamaño de la imagen
    int anchoImg=imagen.getWidth();
    int altoImg=imagen.getHeight();
    //
    
    //Procedemos a recorrer toda la imagen a lo ancho primero y después a largo
    for(int y=0; y<altoImg; y++){
        for(int x=0; x<anchoImg; x++){
            //Las matrices en java consideran filas-columnas y el BufferedImage
            //columnas-filas
            matrizImagen[y][x] = imagen.getRGB(x, y);
        }//fin anchoImg
    }//fin altoImg
}//deBaM
        public static BufferedImage deMaB(int array[][]) {

        int alto = array.length;        
        int ancho = array[0].length;
        
        BufferedImage img = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                img.setRGB(j, i, array[i][j]);
            }//cierra for de j
        }//cierra for de i

        return img;

    }//cierra metodo arrayToBufferedImage
    
}//transBtoM
