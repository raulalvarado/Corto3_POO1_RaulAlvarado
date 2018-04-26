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
@Data public class usuarios {
    
    private int codiusua;
    private String nomb;
    private String acce;
    private String cont;
    
    @Override
    public String toString() {
        return this.nomb;
    }
    
}




