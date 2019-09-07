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
public class Antecedente implements Serializable{
    
    private Date fecha;
    private String descripcion;
    private String tipoAntecedente;

    public Antecedente(Date fecha, String descripcion, String tipoAntecedente) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipoAntecedente = tipoAntecedente;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
    
}
