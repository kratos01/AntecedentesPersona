/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Antecedente extends Persona{
    
    private String fecha;
    private String descripcion;
    

    public Antecedente(String fecha, String descripcion, String nombre, String cedula, int edad, String genero) {
        super(nombre, cedula, edad, genero);
        this.fecha = fecha;
        this.descripcion = descripcion;
        
    }

   
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
