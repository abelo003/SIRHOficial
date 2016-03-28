/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abel.sigsa.daoimp;

import com.abel.sigsa.domine.Pregunta;
import com.abel.sigsa.dao.PreguntaDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author macpro
 */
public class PreguntaDaoImp implements PreguntaDao{
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public PreguntaDaoImp(){}
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insertPregunta(Pregunta pregunta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pregunta findPreguntaId(int id) {
        String query = "select id_pregunta, id_examen, descripcion\n" +
            "from pregunta \n" +
            "where id_pregunta = ?";
        jdbcTemplate = new JdbcTemplate(this.dataSource);
        Pregunta pregunta = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Pregunta>(){

            @Override
            public Pregunta mapRow(ResultSet rs, int i) throws SQLException {
                Pregunta pres = new Pregunta();
                pres.setId_pregunta(rs.getLong("id_pregunta"));
                pres.setId_examen(rs.getLong("id_examen"));
                pres.setDescripcion(rs.getString("descripcion"));
                return pres;
            }            
        });
        return pregunta;
    }

    @Override
    public List<Pregunta> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
