package com.laricafood.resources;

import com.laricafood.bean.Comida;
import com.laricafood.dao.impl.ComidaDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rodrigo.bacellar on 13/03/2015.
 */
@RestController
@RequestMapping("/comida")
public class ComidaResource {

//    @Autowired
//    private ComidaDAOImpl ComidaDAOImpl;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void getById(@PathVariable int id) {

//        return ComidaDAOImpl.getByID(id);
    }
}
