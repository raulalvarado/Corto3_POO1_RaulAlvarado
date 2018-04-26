/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;

import java.util.Date;

/**
 *
 * @author Estudiante
 */
public class prestamos {
    private int codipres;
    private libros libro;
    private usuarios usuario;
    private Date fechaprest;
    //private String fechadevo;

    public prestamos() {
    }

    public prestamos(int codipres, libros libro, usuarios usuario, Date fechaprest/*, String fechadevo*/) {
        this.codipres = codipres;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaprest = fechaprest;
        //this.fechadevo = fechadevo;
    }

    public int getCodipres() {
        return codipres;
    }

    public void setCodipres(int codipres) {
        this.codipres = codipres;
    }

    public libros getLibro() {
        return libro;
    }

    public void setLibro(libros libro) {
        this.libro = libro;
    }

    public usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public Date getFechaprest() {
        return fechaprest;
    }

    public void setFechaprest(Date fechaprest) {
        this.fechaprest = fechaprest;
    }

    /*public String getFechadevo() {
        return fechadevo;
    }

    public void setFechadevo(String fechadevo) {
        this.fechadevo = fechadevo;
    }
*/
    
    @Override
    public String toString() {
        return String.valueOf(codipres);
    }
}
