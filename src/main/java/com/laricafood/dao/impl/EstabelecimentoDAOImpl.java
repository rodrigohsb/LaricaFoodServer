package com.laricafood.dao.impl;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.bean.User;
import com.laricafood.bean.UserType;
import com.laricafood.dao.EstabelecimentoDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
public class EstabelecimentoDAOImpl implements EstabelecimentoDAO {

    private Logger LOGGER = LoggerFactory.getLogger(EstabelecimentoDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * Todos os estabelecimentos.
     *
     * @return
     */
    public List<Estabelecimento> getAll() {

        String SQL_QUERY = "SELECT E.*,U.* FROM ESTABELECIMENTO E INNER JOIN USER U ";

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY);

        for (Map<String, Object> row : rows) {

            estabelecimentos.add(populate(row));
        }

        return estabelecimentos;
    }

    /**
     * Obtem o Estabelecimento a partir do ID.
     *
     * @param id
     * @return
     */
    public Estabelecimento getByID(int id) {

        String SQL_QUERY = "SELECT E.*,U.* FROM ESTABELECIMENTO E INNER JOIN USER U WHERE E.ID = ?";

        Estabelecimento estabelecimento = jdbcTemplate.queryForObject(SQL_QUERY, new Object[]{id}, new RowMapper<Estabelecimento>() {

            @Override
            public Estabelecimento mapRow(ResultSet resultSet, int i) throws SQLException {

                return populate(resultSet);
            }
        });
        return estabelecimento;
    }

    public List<Estabelecimento> getByCategory(int categoryId) {
        String SQL_QUERY = "SELECT U.*,E.*,CO.*,CA.* FROM USER U INNER JOIN ESTABELECIMENTO E ON E.USER_ID = U.ID INNER JOIN ESTABELECIMENTO_COMIDA EC ON EC.ESTABELECIMENTO_ID = E.ID INNER JOIN COMIDA CO ON CO.ID = EC.COMIDA_ID INNER JOIN CATEGORY CA ON CA.ID = CO.CATEGORY_ID WHERE CA.ID = ?";

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY, new Object[]{categoryId});

        for (Map<String, Object> row : rows) {

            estabelecimentos.add(populate(row));
        }

        return estabelecimentos;
    }

    /**
     * @param id
     * @param userId
     * @return
     */
    public boolean delete(final int id, final Long userId) {

        String SQL_QUERY = "DELETE FROM ESTABELECIMENTO WHERE ID = ? AND USER_ID = ?";

        int rows = jdbcTemplate.update(SQL_QUERY, new Object[]{id, userId});
        return (rows > 0 ? true : false);
    }

    /**
     * @param name
     * @param userId
     * @param address
     * @param neighborhood
     * @param city
     * @param foto1
     * @param foto2
     * @param foto3
     * @param foto4
     * @return
     */
    public Estabelecimento create(final String name, final Long userId, final String address, final String neighborhood, final String city, final String foto1, final String foto2, final String foto3, final String foto4) {

        final String SQL_QUERY = "INSERT INTO ESTABELECIMENTO(NAME,USER_ID,ADDRESS,NEIGHBORHOOD,CITY,FOTO1,FOTO2,FOTO3,FOTO4) VALUES (?,?,?,?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement(SQL_QUERY);
                ps.setString(1, name);
                ps.setLong(2, userId);
                ps.setString(3, address);
                ps.setString(4, neighborhood);
                ps.setString(5, city);
                ps.setString(6, foto1);
                ps.setString(7, foto2);
                ps.setString(8, foto3);
                ps.setString(9, foto4);
                return ps;

            }
        }, keyHolder);

        Number number = keyHolder.getKey();

        return getByID(number.intValue());
    }


    /**
     * @param id
     * @param name
     * @param userId
     * @param address
     * @param neighborhood
     * @param city
     * @param foto1
     * @param foto2
     * @param foto3
     * @param foto4
     * @return
     */
    public Estabelecimento update(final int id, final String name, final Long userId, final String address, final String neighborhood, final String city, final String foto1, final String foto2, final String foto3, final String foto4) {

        final String SQL_QUERY = "UPDATE ESTABELECIMENTO SET NAME = ? , USER_ID = ?, ADDRESS = ?, NEIGHBORHOOD =  ?, CITY = ?, FOTO1 = ?, FOTO2 = ?, FOTO3 = ?, FOTO4 =? WHERE ID = ?";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps = con.prepareStatement(SQL_QUERY);

                ps.setString(1, name);
                ps.setLong(2, userId);
                ps.setString(3, address);
                ps.setString(4, neighborhood);
                ps.setString(5, city);
                ps.setString(6, foto1);
                ps.setString(7, foto2);
                ps.setString(8, foto3);
                ps.setString(9, foto4);
                ps.setInt(10, id);

                return ps;
            }
        });

        return getByID(id);
    }

    /**
     * @param userID
     * @return
     */
    @Override
    public List<Estabelecimento> getByUserId(long userID) {

        String SQL_QUERY = "SELECT E.*,U.* FROM ESTABELECIMENTO E INNER JOIN USER U WHERE U.FACEBOOK_ID = ?";

        List<Estabelecimento> estabelecimentos = new ArrayList<Estabelecimento>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL_QUERY, new Object[]{userID});

        for (Map<String, Object> row : rows) {

            estabelecimentos.add(populate(row));
        }

        return estabelecimentos;
    }


    /**
     * @param resultSet
     * @return
     * @throws SQLException
     */
    private Estabelecimento populate(ResultSet resultSet) throws SQLException {

        User u = new User();
        u.setFacebookId(resultSet.getLong("U.id"));
        u.setCreateDate(resultSet.getDate("U.creationDate"));
        u.setUpdateDate(resultSet.getDate("U.updateDate"));
        u.setType(resultSet.getInt("U.usertype_id") == 1 ? UserType.PROPRETARIO : UserType.CLIENTE);

        Estabelecimento estabelecimento = new Estabelecimento();
        estabelecimento.setId(resultSet.getInt("E.id"));
        estabelecimento.setName(resultSet.getString("name"));
        estabelecimento.setUser_id(u);
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

    /**
     * @param row
     * @return
     */
    private Estabelecimento populate(Map<String, Object> row) {

        User u = new User();
        u.setType(UserType.PROPRETARIO);
        u.setFacebookId((Integer) row.get("U.id"));
        u.setCreateDate((Date) row.get("U.creationDate"));
        u.setUpdateDate((Date) row.get("U.updateDate"));

        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setId((Integer) row.get("id"));
        estabelecimento.setName((String) row.get("name"));
        estabelecimento.setUser_id(u);
        estabelecimento.setAddress((String) row.get("address"));
        estabelecimento.setNeighborhood((String) row.get("neighborhood"));
        estabelecimento.setCity((String) row.get("city"));
        estabelecimento.setLatitude((Float) row.get("latitude"));
        estabelecimento.setLongitude((Float) row.get("longitude"));
        estabelecimento.setPontuacao((Float) row.get("pontuacao"));
        estabelecimento.setVotos((Integer) row.get("votos"));

        estabelecimento.setFoto1((String) row.get("foto1"));
        estabelecimento.setFoto2((String) row.get("foto2"));
        estabelecimento.setFoto3((String) row.get("foto3"));
        estabelecimento.setFoto4((String) row.get("foto4"));

        estabelecimento.setCreateDate((Date) row.get("creationDate"));
        estabelecimento.setUpdateDate((Date) row.get("updateDate"));

        return estabelecimento;
    }

}
