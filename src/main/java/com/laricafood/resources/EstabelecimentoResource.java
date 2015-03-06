package com.laricafood.resources;

import com.laricafood.bean.Estabelecimento;
import com.laricafood.dao.impl.ComidaDAOImpl;
import com.laricafood.dao.impl.EstabelecimentoDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@RestController
@RequestMapping("/Estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoDAOImpl estabelecimentoDAOImpl;

    @RequestMapping("/getById/{id}")
    public Estabelecimento getById(@PathParam("id") int id) {

        Estabelecimento estabelecimento = estabelecimentoDAOImpl.getByID(id);
        return estabelecimento;
    }

    @RequestMapping("/listByUserId")
    public List<Estabelecimento> listByUserId() {

        List<Estabelecimento> estabelecimento = estabelecimentoDAOImpl.getByUserId(583633830);
        return estabelecimento;
    }

    @RequestMapping("/getAll")
    public List<Estabelecimento> getAll() {

        List<Estabelecimento> estabelecimento = estabelecimentoDAOImpl.getAll();
        return estabelecimento;
    }

    @RequestMapping("/delete")
    public boolean create(@PathParam("id") int id, @PathParam("userId") Long userId) {
        return estabelecimentoDAOImpl.delete(id, userId);
    }

    @RequestMapping("/create")
    public Estabelecimento create(@PathParam("name") String name, @PathParam("userId") Long userId, @PathParam("address") String address, @PathParam("neighborhood") String neighborhood, @PathParam("city") String city, @PathParam("foto1") String foto1, @PathParam("foto2") String foto2, @PathParam("foto3") String foto3, @PathParam("foto4") String foto4) {

        Estabelecimento estabelecimento = estabelecimentoDAOImpl.create(name, userId, address, neighborhood, city, foto1, foto2, foto3, foto4);
        return estabelecimento;
    }

    @RequestMapping("/update")
    public Estabelecimento update(@PathParam("id") int id, @PathParam("name") String name, @PathParam("userId") Long userId, @PathParam("address") String address, @PathParam("neighborhood") String neighborhood, @PathParam("city") String city, @PathParam("foto1") String foto1, @PathParam("foto2") String foto2, @PathParam("foto3") String foto3, @PathParam("foto4") String foto4) {

        Estabelecimento estabelecimento = estabelecimentoDAOImpl.update(id, name, userId, address, neighborhood, city, foto1, foto2, foto3, foto4);
        return estabelecimento;
    }

}
