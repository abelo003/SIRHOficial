/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.domine;

/**
 *
 * @author macpro
 */
public class Pregunta {
    private long id_pregunta;
    private long id_examen;
    private String descripcion;

    public Pregunta(){}
    
    public long getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(long id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public long getId_examen() {
        return id_examen;
    }

    public void setId_examen(long id_examen) {
        this.id_examen = id_examen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
