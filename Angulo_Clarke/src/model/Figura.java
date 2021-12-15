package model;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;

public class Figura implements Serializable {

    private int fig;
    private Point origen, destino;
    private Color color;


    public static final int LINEA = 0;
    public static final int LINEA2 = 1;
    public static final int RECT = 2;
    public static final int OVAL = 3;
    public static final int FRECT = 4;
    public static final int FOVAL = 5;
    public static final int TXT = 6;

    public Figura(final int fig, Point origen, Point destino, Color color) {
        this.fig = fig;
        this.origen = origen;
        this.destino = destino;
        this.color = color;
    }

    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(2));
        switch (fig) {
            case LINEA:
                g.drawLine(origen.getX(), origen.getY(),
                        destino.getX(), destino.getY());
                break;

            case LINEA2:
                g.drawLine(origen.getX(), origen.getY(),
                        destino.getX(), destino.getY());
                break;

            
        }

    }

    public void setDestino(Point p) {
        this.destino = p;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Figura: " + fig + " x1: " + origen.getX() + " y1: " + origen.getY();
    }
}
