/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;

/**
 *
 * @author karen
 */
public class Datos {
    private float  peso,estatura,R_pieDerecho, R_pieIzquierdo;
    private int ID,edad,banderaD,banderaI;
    private String Nombre,genero,D_izquierdo,D_derecho,  UrlDerecho, UrlIzquierdo;

    public int getBanderaD() {
        return banderaD;
    }

    public void setBanderaD(int banderaD) {
        this.banderaD = banderaD;
    }

    public int getBanderaI() {
        return banderaI;
    }

    public void setBanderaI(int banderaI) {
        this.banderaI = banderaI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEstatura() {
        return estatura;
    }

    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    public float getR_pieDerecho() {
        return R_pieDerecho;
    }

    public void setR_pieDerecho(float R_pieDerecho) {
        this.R_pieDerecho = R_pieDerecho;
    }

    public float getR_pieIzquierdo() {
        return R_pieIzquierdo;
    }

    public void setR_pieIzquierdo(float R_pieIzquierdo) {
        this.R_pieIzquierdo = R_pieIzquierdo;
    }

    public String getD_izquierdo() {
        return D_izquierdo;
    }

    public void setD_izquierdo(String D_izquierdo) {
        this.D_izquierdo = D_izquierdo;
    }

    public String getD_derecho() {
        return D_derecho;
    }

    public void setD_derecho(String D_derecho) {
        this.D_derecho = D_derecho;
    }

    public String getUrlDerecho() {
        return UrlDerecho;
    }

    public void setUrlDerecho(String UrlDerecho) {
        this.UrlDerecho = UrlDerecho;
    }

    public String getUrlIzquierdo() {
        return UrlIzquierdo;
    }

    public void setUrlIzquierdo(String UrlIzquierdo) {
        this.UrlIzquierdo = UrlIzquierdo;
    }


    
    
}
