package com.laricafood.dao.impl;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.dao.EstabelecimentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Estabelecimento getByID(int id) {

        Estabelecimento estabelecimento = jdbcTemplate.queryForObject("select * from ESTABELECIMENTselect * from ESTABELECIMENTO where id = ?", Estabelecimento.class, id);
        return null;
    }


}
