package com.laricafood.dao.impl;

import com.laricafood.bean.Category;
import com.laricafood.bean.Comida;
import com.laricafood.dao.ComidaDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
public class ComidaDAOImpl implements ComidaDAO {

    private Logger LOGGER = LoggerFactory.getLogger(ComidaDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Comida getByID(int id) {

        long startTime = System.currentTimeMillis();

        final Comida comida = jdbcTemplate.queryForObject("SELECT CO.* FROM COMIDA AS CO WHERE COID = ?;", new Object[]{id}, new RowMapper<Comida>() {
            @Override
            public Comida mapRow(ResultSet rs, int rowNum) throws SQLException {

                Comida comida = new Comida();
                comida.setId(rs.getInt("COID"));
                comida.setName(rs.getString("CO_NAME"));

                Category category = Category.values()[rs.getInt("CATEGORY_ID") - 1];
                comida.setCategory(category);

                return comida;
            }
        });
        long endTime = System.currentTimeMillis();

        LOGGER.info("[" + (endTime - startTime) + "] ms");

        return comida;
    }

    public List<Comida> getByEstabelecimentoID(int estabelecimentoId) {

        List<Map<String, Object>> rows1 = jdbcTemplate.queryForList("SELECT CO.* FROM COMIDA AS CO INNER JOIN ESTABELECIMENTO_COMIDA AS EC ON EC.COMIDA_ID = COID WHERE EC.ESTABELECIMENTO_ID = " + estabelecimentoId);

        List<Comida> comidas = new ArrayList<Comida>();

        for (Map<String, Object> row1 : rows1) {

            Comida comida = new Comida();

            comida.setId((Integer) row1.get("COID"));
            comida.setName((String) row1.get("CO_NAME"));
            Category category = Category.values()[((Integer) row1.get("CATEGORY_ID")) - 1];
            comida.setCategory(category);

            comidas.add(comida);
        }

        return comidas;
    }
}
