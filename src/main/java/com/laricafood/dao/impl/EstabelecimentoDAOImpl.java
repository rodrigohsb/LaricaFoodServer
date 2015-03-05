package com.laricafood.dao.impl;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.bean.User;
import com.laricafood.bean.UserType;
import com.laricafood.dao.EstabelecimentoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Estabelecimento getByID(int id) {

        Estabelecimento estabelecimento = jdbcTemplate.queryForObject("SELECT E.*,U.* FROM ESTABELECIMENTO E INNER JOIN USER U WHERE E.ID = ?", new Object[]{id}, new RowMapper<Estabelecimento>() {

            @Override
            public Estabelecimento mapRow(ResultSet resultSet, int i) throws SQLException {

                Estabelecimento estabelecimento = new Estabelecimento();

                estabelecimento.setId(resultSet.getInt("E.id"));
                estabelecimento.setName(resultSet.getString("name"));

                User u = new User();
                u.setType(UserType.PROPRETARIO);
                u.setFacebookId(resultSet.getLong("facebook_id"));
                u.setCreateDate(resultSet.getDate("U.creationDate"));
                u.setUpdateDate(resultSet.getDate("U.updateDate"));

                estabelecimento.setProprietario_id(u);
                estabelecimento.setAddress(resultSet.getString("address"));
                estabelecimento.setNeighborhood(resultSet.getString("neighborhood"));
                estabelecimento.setCity(resultSet.getString("city"));
                estabelecimento.setLatitude(resultSet.getFloat("latitude"));
                estabelecimento.setLongitude(resultSet.getFloat("longitude"));
                estabelecimento.setPontuacao(resultSet.getFloat("pontuacao"));
                estabelecimento.setVotos(resultSet.getInt("votos"));

                estabelecimento.setFoto1(resultSet.getString("foto1"));
                estabelecimento.setFoto2(resultSet.getString("foto2"));
                estabelecimento.setFoto3(resultSet.getString("foto3"));
                estabelecimento.setFoto4(resultSet.getString("foto4"));

                estabelecimento.setCreateDate(resultSet.getDate("E.creationDate"));
                estabelecimento.setUpdateDate(resultSet.getDate("E.updateDate"));

                return estabelecimento;
            }
        });
        return estabelecimento;
    }


}
