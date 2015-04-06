package com.laricafood.resources;

import com.laricafood.bean.Category;
import com.laricafood.dao.impl.CategoryDAOimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Rodrigo on 03/04/15.
 */
@RestController
@RequestMapping("/category")
public class CategoryResource {

    @Autowired
    CategoryDAOimpl categoryDAOimpl;

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public List<Category> listAll() {

        return categoryDAOimpl.listAll();
    }
}
