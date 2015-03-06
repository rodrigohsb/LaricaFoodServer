package com.laricafood.dao;

import com.laricafood.bean.Estabelecimento;

import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public interface EstabelecimentoDAO {

    Estabelecimento getByID(int id);

    List<Estabelecimento> getByUserId(long userID);

    Estabelecimento update(final int id, final String name, final Long userId, final String address, final String neighborhood, final String city, final String foto1, final String foto2, final String foto3, final String foto4);

    Estabelecimento create(final String name, final Long userId, final String address, final String neighborhood, final String city, final String foto1, final String foto2, final String foto3, final String foto4);

    boolean delete(final int id, final Long userId);

    List<Estabelecimento> getAll();
}
