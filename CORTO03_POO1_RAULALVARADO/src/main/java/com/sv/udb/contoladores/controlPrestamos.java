/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.contoladores;

import com.sv.udb.modelos.libros;
import com.sv.udb.modelos.usuarios;
import com.sv.udb.modelos.prestamos;
import com.sv.udb.modelos.Fechas;
import com.sv.udb.recursos.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class controlPrestamos {
    
    private final Connection conect;

    public controlPrestamos() {
        this.conect = new conexion().getConn();
    }
    
    public List<prestamos> consTodo () {
        List<prestamos> resp = new ArrayList<>();
        try {
            PreparedStatement cmd = this.conect.prepareStatement("select nomb_usua,nomb_libr,fech_pres,fech_devo from prestamos INNER JOIN libros on prestamos.codi_libr=libros.codi_libr INNER JOIN usuarios on prestamos.codi_usua=usuarios.codi_usua");
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp.add(
                        new prestamos(
                                rs.getInt(1), 
                                new libros(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)),
                                new usuarios(rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11)),
                                rs.getDate(12)
                        ));
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar bodega: " + ex.getMessage());
        } finally {
            try {
                if (this.conect != null) {
                    if (!this.conect.isClosed()) {
                        this.conect.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión al consultar bodega: " + ex.getMessage());
            }
        }
        return resp;
    }
     public prestamos obtenerPorId(int id){
    prestamos resp = new prestamos();
        try {
            PreparedStatement cmd;
            cmd= this.conect.prepareStatement("select p.codi_pres, l.codi_libr,l.nomb_libr,u.codi_usua,u.nomb_usua,p.fech_pres,p.fech_devo from prestamos p inner join libros l on p.codi_libr = l.codi_libr INNER JOIN usuarios u on p.codi_usua = u.codi_usua where p.codi_pres="+id);
            
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                resp=new prestamos(
                                rs.getInt(1), 
                                new libros(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getInt(7)),
                                new usuarios(rs.getInt(8),rs.getString(9),rs.getString(10),rs.getString(11)),
                                rs.getDate(12)
                        );
            }
        } catch (SQLException ex) {
            System.err.println("Error al consultar ENTITY: " + ex.getMessage());
        } finally {
            try {
                if (this.conect != null) {
                    if (!this.conect.isClosed()) {
                        this.conect.close();
                    }
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión al consultar ENTITY: " + ex.getMessage());
            }
        }
        return resp;
    }
    
    public boolean agregarPrestamo(prestamos p){
        boolean resp = false;
        
        try {
            PreparedStatement cmd = this.conect.prepareStatement("insert into prestamos values(null,?,?,?,null)");
            cmd.setInt(1, p.getLibro().getCodilib());
            cmd.setInt(2, p.getUsuario().getCodiusua());
            cmd.setString(3, Fechas.formatDate(p.getFechaprest(), Fechas.DATE_DB));
            cmd.executeUpdate();
            resp = true;
        } catch (Exception ex) {
            System.err.println("Error al guardar equipos" + ex.getMessage());
        } finally {
            try {
                if (this.conect != null) {
                    if (!this.conect.isClosed()) {
                        this.conect.close();
                    }
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexion en equipos: " + e.getMessage());
            }
        }
        
        return resp;
    }
    
}
