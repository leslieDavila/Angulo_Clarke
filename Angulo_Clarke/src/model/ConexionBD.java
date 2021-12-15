/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author karen
 */
public class ConexionBD {

    public static Connection getConnection() {
        Connection conect = null;
        String usuario = "sa";
        String contraseña = "123456";
        String url = "jdbc:sqlserver://localhost:1433;databaseName=AnguloClarke";
        try {
            conect = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("Conectado.");
           
            Datos e = new Datos();

        } catch (SQLException ex) {
            ex.printStackTrace();
            
            System.out.println("Error.");

        }

        return conect;
    }

    public static int save(Datos e) {
        int status = 0;
        try {
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "insert into paciente(id_paciente,nombre,edad,genero,peso,estatura) values (?,?,?,?,?,?)");
            ps.setInt(1, e.getID());
            ps.setString(2, e.getNombre());
            ps.setInt(3, e.getEdad());
            ps.setString(4, e.getGenero());
            ps.setFloat(5, e.getPeso());
            ps.setFloat(6, e.getEstatura());

            status = ps.executeUpdate();

            PreparedStatement ps4 = con.prepareStatement(
                    "insert into imagen(id_imagen,id_paciente, imgDerecho,imgIzquierdo) values (?,?,?,?)");
            ps4.setInt(1, e.getID());
            ps4.setInt(2, e.getID());
            ps4.setString(3, e.getUrlDerecho());
            ps4.setString(4, e.getUrlIzquierdo());

            status = ps4.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                    "insert into calculo_anguloC(id_calculo,id_imagen,anguloDerecho,anguloIzquierdo) values (?,?,?,?)");
            ps2.setInt(1, e.getID());
            ps2.setInt(2, e.getID());
            ps2.setFloat(3, e.getR_pieDerecho());
            ps2.setFloat(4, e.getR_pieIzquierdo());

            status = ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(
                    "insert into diagnostico(id_diagnostico,id_calculo, resultadoDerecho,resultadoIzquierdo) values (?,?,?,?)");
            ps3.setInt(1, e.getID());
            ps3.setInt(2, e.getID());
            ps3.setString(3, e.getD_derecho());
            ps3.setString(4, e.getD_izquierdo());

            status = ps3.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }

    public static Datos buscar(int Id) {
        Datos e = new Datos();
        try {
            Connection con = ConexionBD.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from imagen where Id_paciente=?");
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();

            PreparedStatement ps1 = con.prepareStatement("select * from diagnostico where Id_diagnostico=?");
            ps1.setInt(1, Id);
            ResultSet rs1 = ps1.executeQuery();

            PreparedStatement ps2 = con.prepareStatement("select * from calculo_anguloC where Id_calculo=?");
            ps2.setInt(1, Id);
            ResultSet rs2 = ps2.executeQuery();  
            
            if (rs.next()) {
                e.setID(rs.getInt(1));
                e.setID(rs.getInt(2));
                e.setUrlDerecho(rs.getString(3));
                e.setUrlIzquierdo(rs.getString(4));
            }
            if (rs1.next()) {
                e.setID(rs1.getInt(1));
                e.setID(rs1.getInt(2));
                e.setD_derecho(rs1.getString(3));
                e.setD_izquierdo(rs1.getString(4));
            }           
            if (rs2.next()) {
                e.setID(rs2.getInt(1));
                e.setID(rs2.getInt(2));
                e.setR_pieDerecho(rs2.getFloat(3));
                e.setR_pieIzquierdo(rs2.getFloat(4));
            }
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return e;
    }
}
