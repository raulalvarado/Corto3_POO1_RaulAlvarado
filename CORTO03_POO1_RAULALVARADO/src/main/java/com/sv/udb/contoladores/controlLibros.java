/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.contoladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.sv.udb.modelos.libros;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;

/**
 *
 * @author Estudiante
 */
public class controlLibros {
    
    private final Connection conect;

    public controlLibros() {
        this.conect = new conexion().getConn();
    }
    
    
    public ArrayList<libros> selectLibros() {
        ArrayList<libros> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = conect.prepareStatement("SELECT * FROM libros");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(new libros(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5),rs.getInt(6)));
            }
        } catch (Exception e) {
            System.err.println("Error al consultar lirbos: " + e.getMessage());
        } finally {
            try {
                if (conect != null) {
                    if (!conect.isClosed()) {
                        conect.close();
                    }
                }
            } catch (Exception e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
        return resp;
    }
    
}
