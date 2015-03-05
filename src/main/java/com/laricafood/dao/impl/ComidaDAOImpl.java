package com.laricafood.dao.impl;

import com.laricafood.bean.Comida;
import com.laricafood.dao.ComidaDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
public class ComidaDAOImpl implements ComidaDAO {

    private Logger LOGGER = LoggerFactory.getLogger(ComidaDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Comida getComidaByID(int id) {

        long startTime = System.currentTimeMillis();

        Comida comida = jdbcTemplate.queryForObject("select * from COMIDA where id = ?", new Object[]{id}, new BeanPropertyRowMapper<Comida>(Comida.class));
        long endTime = System.currentTimeMillis();

        LOGGER.info("[" + (endTime - startTime) + "] ms");

        return comida;
    }
}
