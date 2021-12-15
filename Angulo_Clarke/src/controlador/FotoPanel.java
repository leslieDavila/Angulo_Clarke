package controlador;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.TimerTask;
import java.util.Timer;
import javax.imageio.ImageIO;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import model.Datos;
import view.FotoMarco;

public class FotoPanel extends JPanel implements MouseMotionListener, MouseListener {

     Datos e = new Datos();
     
    private Image photo;
    BufferedImage bimage;
    private BufferedImage BufferedImage;
    
    /**
     * Nombre de archivo deimagen
     */
    private String nameFile;
    
    /**
     * Contador de recortes
     */
    public int banderaD, banderaI;
    
    /**
     * Colores para las lineas
     */
    private Color color1 = new Color(255, 255, 255);
    private Color color2 = new Color(0, 0, 0);
    
    /**
     * Para la imagen que se recortara
     */
    public static BufferedImage tmp_Recorte, pieD,pieI;
    //Image pieD, pieI;
    /**
     * coordenadas y tamaño del recorte
     */
    private float clipX = 0;
    private float clipY = 0;
    private float clipWidth;
    private float clipHeight;

    /**
     * Coordenadas x,y para el dibujo del recorte
     */ 
    private int x1 = 0;
    private int y1 = 0;
    private int dx1x2 = 0;
    private int dy1y2 = 0;
    private int x2 = 0;
    private int y2 = 0;

    /**
     * bandera para el cambio de color de la mascara de recorte
     */
    boolean band = true;

    /**
     * Menu emergente
     */
    private JPopupMenu popupMenu = new JPopupMenu();

    /**
     * Constructor de clase
     */
    public FotoPanel() {
        super();
        
        FotoPanel.this.setSize(new Dimension(0,0));
        FotoPanel.this.setPreferredSize(new Dimension(0,0));
        
        //eventos del raton
        FotoPanel.this.addMouseMotionListener(FotoPanel.this);
        FotoPanel.this.addMouseListener(FotoPanel.this);

        /**
         * Crea menu emergente y listener
         */
        JMenuItem menuItem1 = new JMenuItem("Pie derecho");  
        JMenuItem menuItem2 = new JMenuItem("Pie izquierdo"); 
        menuItem1.addActionListener((ActionEvent e) -> {
            imagen1();            
        });
          menuItem2.addActionListener((ActionEvent e) -> {
            imagen2();            
        });
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);

        /**
         * Timer que va cambiando el color de linea de la
         * mascara de recorte cada X tiempo 
         */
        Timer timer = new Timer();
        TimerTask timerColor = new TimerTask() {
            @Override
            public void run() {                
                color1 = (band)?new Color(255, 255, 255):new Color(0, 0, 0);
                color2 = (band)?new Color(0,0,0):new Color(255,255,255);                
                band = !band;
                repaint();
            }
        };
        timer.schedule(timerColor, 1000, 350);
    }//PhotoPanel:constructor

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;        
        g2.setColor(new Color(255, 255, 255));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        
        if (photo != null) {
            //se crea un lienzo del tamaño de la foto
            BufferedImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2D = BufferedImage.createGraphics();
            g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //se añade la foto grande original
            g2D.drawImage(photo, 0, 0, photo.getWidth(this), photo.getHeight(this), this);            
            
            //pinta rectangulo solido para delimitar la seccion de recorte 
            g2D.setStroke(new BasicStroke(1f));
            g2D.setColor(color1);
            drawRect(g2D);
            //pinta rectangulo segmentando  
            float dash1[] = {5.0f};
            g2D.setStroke(new BasicStroke(1.0f,
                    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f));
            g2D.setColor(color2);
            drawRect(g2D);
            
            //se dibuja todo
            g2.drawImage(BufferedImage, 0, 0, this);
        }
    }

    /**
     * Pinta un rectangulo
     */
    private void drawRect(Graphics2D g2D) {
        g2D.drawLine(x1, y1, x1 + dx1x2, y1);
        g2D.drawLine(x1, y1, x1, y1 + dy1y2);
        g2D.drawLine(x1 + dx1x2, y1, x1 + dx1x2, y1 + dy1y2);
        g2D.drawLine(x1, y1 + dy1y2, x1 + dx1x2, y1 + dy1y2);
    }

    /**
     * despliega el popupmenu
     */
    private void showPopup(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {//clic derecho
            if (e.isPopupTrigger()) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    /**
     * Asigna objeto Image
     *
     * @param photo
     * @param nameFile nombre de archivo
     */
    public void setPhoto(Image photo, String nameFile) {
        if (photo != null) {
            this.photo = photo;
            this.nameFile= nameFile;
            this.setSize(new Dimension(photo.getWidth(null), photo.getHeight(null)));
            this.setPreferredSize(new Dimension(photo.getWidth(null), photo.getHeight(null)));
            //reinicia valores
            x1=0;
            y1=0;
            x2=0;
            y2=0;
            dx1x2=0;
            dy1y2=0;
            clipX=0;
            clipY=0;
            clipWidth=0;
            clipHeight=0;
            
            repaint();
        }
    }

    
    public  BufferedImage ABufferedImage (Image img){
        
        if(img instanceof BufferedImage){
            return(BufferedImage) img;
        }
        
        
        bimage = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_INT_ARGB);
        //conversion 
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return bimage;
    }  
   private void imagen1(){
         ABufferedImage(photo);
        tmp_Recorte = bimage.getSubimage((int) clipX, (int) clipY, (int) clipWidth, (int) clipHeight);
        pieD =tmp_Recorte;
        banderaD=1;

        
}
    
        private void imagen2(){
            ABufferedImage(photo);
        tmp_Recorte = bimage.getSubimage((int) clipX, (int) clipY, (int) clipWidth, (int) clipHeight);
        pieI = tmp_Recorte;
        banderaI=1;

}
    /* ----------------------------------------------------------------
     * eventos del mouse
     ------------------------------------------------------------------ */
    @Override
    public void mouseDragged(MouseEvent e) {
        x2 = (int) e.getPoint().getX();
        y2 = (int) e.getPoint().getY();

        //evita que se salga fuera de los limites del panel
        if(x2<0)x2=0;
        if(y2<0)y2=0;
        
        //distancia recorrida
        dx1x2 = x2 - x1;
        dy1y2 = y2 - y1;
        
        //evita que se salga fuera de los limites del panel
        if( x1 + dx1x2> getWidth() ) dx1x2 = getWidth() - x1 - 1;
        if( y1 + dy1y2> getHeight( )) dy1y2 = getHeight() - y1 - 1;
               
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        showPopup(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            x1 = (int) e.getPoint().getX();
            y1 = (int) e.getPoint().getY();
        }
        showPopup(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //dimensiones del recorte
        clipX = x1;
        clipY = y1;
        clipWidth = Math.abs(dx1x2);
        clipHeight=Math.abs(dy1y2);
        
        if(dx1x2<0 & dy1y2<0){
            clipX = clipX - Math.abs(dx1x2);
            clipY = clipY - Math.abs(dy1y2);
        }else if(dy1y2<0){            
            clipY = clipY - Math.abs(dy1y2);
        }else if(dx1x2<0){
            clipX = clipX - Math.abs(dx1x2);
        }
        showPopup(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }




}//PhotoPanel:end
