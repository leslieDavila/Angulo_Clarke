/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Point;

/**
 *
 * @author karen
 */
public class calculos {
    double resultado, angle1, angle2,a,b,anguloRedondeado;
    String tipo;
    public calculos() {
        this.resultado = resultado;
    }

    public double angulo1(Point origen, Point destino) {
        angle1 = Math.atan2(origen.getY() - destino.getY(),
                origen.getX() - destino.getX());
        a= Math.toDegrees(angle1);       
        return a;
    }

    public double angulo2(Point origen, Point destino) {
        angle2 = Math.atan2(origen.getY() - destino.getY(),
                origen.getX() - destino.getX());
            
        b= Math.toDegrees(angle2);
        return angle2;
    }

    public double anguloEntreDosLineas(double angle1, double angle2) {
        resultado   = a - b;       
        return resultado;
    }
    
    public String diagnostico (double anguloFinal){
        anguloRedondeado = Math.round(anguloFinal);
        if (anguloFinal < 30) {          
            tipo = "Plano";
        } else if (anguloFinal >= 30) {          
            tipo = "Normal";
        }
        
        return tipo;
    }

}
