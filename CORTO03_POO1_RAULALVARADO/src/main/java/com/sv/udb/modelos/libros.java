/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;


/**
 *
 * @author Estudiante
 */

public class libros {
    private int codilib;
    private String nomb;
    private String auto;
    private String gene;
    private int año;
    private int esta;

    public libros() {
    }
    
    public libros(int codilib, String nomb, String auto, String gene, int año, int esta) {
        this.codilib = codilib;
        this.nomb = nomb;
        this.auto = auto;
        this.gene = gene;
        this.año = año;
        this.esta = esta;
    }
    
    public int getCodilib() {
        return codilib;
    }

    public void setCodilib(int codilib) {
        this.codilib = codilib;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getEsta() {
        return esta;
    }

    public void setEsta(int esta) {
        this.esta = esta;
    }
    
    
    
    @Override
    public String toString() {
        return this.nomb;
    }
    
}
