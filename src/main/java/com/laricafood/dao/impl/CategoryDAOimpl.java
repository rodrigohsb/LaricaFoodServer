package com.laricafood.dao.impl;

import com.laricafood.bean.Category;
import com.laricafood.dao.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by rodrigo.bacellar on 04/03/2015.
 */
@Repository
public class CategoryDAOimpl implements CategoryDAO {

    /*
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> listAll() {

        List<Category> categoryList = new ArrayList<Category>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT * FROM CATEGORY;");

        for (Map<String, Object> row : rows) {

            Category category = new Category();
            category.setId((Integer) row.get("CATID"));
            category.setName((String) row.get("CA_NAME"));

            categoryList.add(category);

        }

        return categoryList;
    }
    */
}
