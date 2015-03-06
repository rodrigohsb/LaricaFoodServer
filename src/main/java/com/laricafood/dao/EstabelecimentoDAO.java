package com.laricafood.dao;

import com.laricafood.bean.Estabelecimento;

import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
public interface EstabelecimentoDAO {

    Estabelecimento getByID(int id);

    List<Estabelecimento> getByUserId(long userID);
}
