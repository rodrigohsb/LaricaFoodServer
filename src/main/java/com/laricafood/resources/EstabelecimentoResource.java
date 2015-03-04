package com.laricafood.resources;

import com.google.gson.Gson;
import com.laricafood.bean.Estabelecimento;
import com.laricafood.constants.Constants;
import com.laricafood.dao.impl.EstabelecimentoDAOImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Component
@Path(Constants.ESTABELECIMENTO)
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EstabelecimentoResource {

    private final Logger logger = LoggerFactory.getLogger(EstabelecimentoResource.class);

    @Autowired
    private EstabelecimentoDAOImpl estabelecimentoDAOImpl;

    @Autowired
    private Gson gson;

    @GET
    @Path(Constants.LIST_ALL)
    public String listAll() {

        Estabelecimento estabelecimento = estabelecimentoDAOImpl.getByID(1);
        return gson.toJson(estabelecimento);
    }
}
