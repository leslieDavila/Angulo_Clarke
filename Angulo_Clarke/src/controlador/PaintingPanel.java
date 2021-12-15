package controlador;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import model.Point;
import model.Figura;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Figura;
import model.Point;
import controlador.calculos;
import static java.awt.Color.red;

public class PaintingPanel extends JLabel {

    BufferedImage img;
    private Point origen, destino;
    private int seleccion, x, x1, y1, y;
    private ArrayList<Figura> lista;
    private Color color;
    public double angulo1, angulo2, angulo;

    public static final int LINEA = 0;
    public static final int LINEA2 = 1;
    public static final int BORRAR = 2;

    calculos datos = new calculos();

    public PaintingPanel(Point origen, Point destino, ArrayList<Figura> lista, Icon icono) {
        super(icono);
        this.seleccion = 0;
        this.origen = origen;
        this.destino = destino;
        this.lista = lista;
        this.img = img;
        setBackground(Color.WHITE);

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        if (!lista.isEmpty()) {
            lista.forEach((fig) -> {
                g.setColor(fig.getColor());
                fig.draw(g);
            });
        }
        g.setColor(color);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2));
        switch (seleccion) {
            case LINEA:

                g.drawLine(origen.getX(), origen.getY(), destino.getX(), destino.getY());

                angulo1 = datos.angulo1(origen, destino);
                break;

            case LINEA2:

                g.drawLine(origen.getX(), origen.getY(), destino.getX(), destino.getY());
                angulo2 = datos.angulo2(origen, destino);
                break;

            case BORRAR:
                x = origen.getX();
                y = origen.getY();
                x1 = destino.getX();
                y1 = destino.getY();
                repaint();
                lista.clear();
                break;

        }

    }

    public double resultadoFinal() {
        angulo = datos.anguloEntreDosLineas(angulo1, angulo2);
        return angulo;
    }

    public void setSeleccion(int s) {
        this.seleccion = s;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
