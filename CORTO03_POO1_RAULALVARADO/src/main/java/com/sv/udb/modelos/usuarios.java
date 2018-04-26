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
 public class usuarios {
    
    private int codiusua;
    private String nomb;
    private String acce;
    private String cont;

    public usuarios() {
    }
    
    public usuarios(int codiusua, String nomb, String acce, String cont) {
        this.codiusua = codiusua;
        this.nomb = nomb;
        this.acce = acce;
        this.cont = cont;
    }

    public int getCodiusua() {
        return codiusua;
    }

    public void setCodiusua(int codiusua) {
        this.codiusua = codiusua;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public String getAcce() {
        return acce;
    }

    public void setAcce(String acce) {
        this.acce = acce;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    
    
    
    @Override
    public String toString() {
        return this.nomb;
    }
    
}




