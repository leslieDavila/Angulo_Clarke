
package Utilerias;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author raulsantiago-montero
 */
public class ImgPanel extends JPanel{
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public ImgPanel(BufferedImage image) {
        super();        
        this.image = image;        
    }
    
    public void paint(Graphics g) {
//        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(image, 0, 0, null);

    }
    //métodos de atributos
    public int getAncho(){
        return image.getWidth();
    }
    public int getAltura(){
        return image.getHeight();
    }
}//ImgPanel
