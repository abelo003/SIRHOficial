/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.clases;

/**
 *
 * @author macpro
 */
public class Respuesta {
    private int idRespuesta;
    private int idPregunta;
    private char inciso;

    public char getInciso() {
        return inciso;
    }

    public void setInciso(char inciso) {
        this.inciso = inciso;
    }
    private String descripcion;
    
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
