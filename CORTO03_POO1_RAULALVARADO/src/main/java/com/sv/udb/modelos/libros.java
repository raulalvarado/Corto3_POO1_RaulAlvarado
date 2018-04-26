/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Estudiante
 */

@AllArgsConstructor
@NoArgsConstructor

@Data public class libros {
    private int codilib;
    private String nomb;
    private String auto;
    private String gene;
    private int año;
    private int esta;
    
    @Override
    public String toString() {
        return this.nomb;
    }
    
}
