/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentes;

import java.io.Serializable;
/**
 * En esta clase se definen los atributos y los metodos de la persona.
 * @author ASUS
 */
public class Persona implements Serializable{
    /**
     * identificador unico*/
    private static final long serialVersionUID = 1L;
    /**
     * Atributo que recibe el nombre*/
    private String nombre;
    /**
     * Atributo que recibe la cedula*/
    private int cedula;
    /**
     * Atributo que recibe la edad*/
    private int edad;
    /**
     * Atributo que recibe el genero*/
    private String genero;

    /**
     * Constructor de la clase.
     * @param nombre
     * @param cedula
     * @param edad
     * @param genero 
     */
    public Persona(String nombre, int cedula, int edad, String genero) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
