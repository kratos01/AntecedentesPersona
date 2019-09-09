/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udec.antecedentes;

import java.io.Serializable;

/**
 * En esta clase se definen los atributos y metodos de antecedente.
 * @author ASUS
 */
public class Antecedente implements Serializable{
    /**
     * identificador unico*/
    private static final long serialVersionUID = 1L;
    /**
     * Atributo que recibe fecha*/
    private String fecha;
    /**
     * Atributo que recibe descripcion de antecedente*/
    private String descripcion;
    /**
     * Atributo que recibe tipo de antecedente*/
    private String tipoAntecedente;
    /**
     * Atributo que recibe cedula de la persona*/
    private int cedulaper;

    /**
     * Constructor de la clase.
     * @param fecha 
     * @param descripcion
     * @param tipoAntecedente
     * @param cedulaper 
     */
    public Antecedente(String fecha, String descripcion, String tipoAntecedente, int cedulaper) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipoAntecedente = tipoAntecedente;
        this.cedulaper = cedulaper;
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

    public String getTipoAntecedente() {
        return tipoAntecedente;
    }

    public void setTipoAntecedente(String tipoAntecedente) {
        this.tipoAntecedente = tipoAntecedente;
    }

    public int getCedulaper() {
        return cedulaper;
    }

    public void setCedulaper(int cedulaper) {
        this.cedulaper = cedulaper;
    }
    
}
