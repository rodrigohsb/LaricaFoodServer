package com.laricafood.resources;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.dao.impl.EstabelecimentoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoDAOImpl estabelecimentoDAOImpl;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Estabelecimento getById(@PathVariable int id) {

        return estabelecimentoDAOImpl.getByID(id);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public List<Estabelecimento> listByUser(@PathVariable Long userId) {

        return estabelecimentoDAOImpl.getByUserId(userId);
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public List<Estabelecimento> getByCategory(@PathVariable int categoryId) {

        return estabelecimentoDAOImpl.getByCategory(categoryId);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Estabelecimento> getAll() {

        return estabelecimentoDAOImpl.getAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean create(@PathParam("id") int id, @PathParam("userId") Long userId) {

        return estabelecimentoDAOImpl.delete(id, userId);

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Estabelecimento create(@PathParam("name") String name, @PathParam("userId") Long userId, @PathParam("address") String address, @PathParam("neighborhood") String neighborhood, @PathParam("city") String city, @PathParam("foto1") String foto1, @PathParam("foto2") String foto2, @PathParam("foto3") String foto3, @PathParam("foto4") String foto4) {

        return estabelecimentoDAOImpl.create(name, userId, address, neighborhood, city, foto1, foto2, foto3, foto4);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Estabelecimento update(@PathParam("id") int id, @PathParam("name") String name, @PathParam("userId") Long userId, @PathParam("address") String address, @PathParam("neighborhood") String neighborhood, @PathParam("city") String city, @PathParam("foto1") String foto1, @PathParam("foto2") String foto2, @PathParam("foto3") String foto3, @PathParam("foto4") String foto4) {

        return estabelecimentoDAOImpl.update(id, name, userId, address, neighborhood, city, foto1, foto2, foto3, foto4);
    }

}
