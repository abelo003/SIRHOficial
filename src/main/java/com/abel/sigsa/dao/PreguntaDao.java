/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.dao;

import com.abel.sigsa.domine.Pregunta;
import java.util.List;

/**
 *
 * @author macpro
 */
public interface PreguntaDao {
    public void insertPregunta(Pregunta pregunta);
    public Pregunta findPreguntaId(int id);
//    public int updatePregunta();
    public List<Pregunta> listAll();
}
