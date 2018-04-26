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

@Data public class prestamos {
    private int codipres;
    private libros libro;
    private usuarios usuario;
    private String fechaprest;
    private String fechadevo;
    
    @Override
    public String toString() {
        return String.valueOf(codipres);
    }
}
