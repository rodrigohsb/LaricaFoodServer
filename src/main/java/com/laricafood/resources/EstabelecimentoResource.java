package com.laricafood.resources;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.dao.impl.ComidaDAOImpl;
import com.laricafood.dao.impl.EstabelecimentoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@RestController
@RequestMapping("/Estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoDAOImpl estabelecimentoDAOImpl;

    @RequestMapping("/listAll")
    public Estabelecimento listAll() {

        Estabelecimento estabelecimento = estabelecimentoDAOImpl.getByID(1);
        return estabelecimento;
    }
}
