package com.pluralsight.NorthwindTradersAPI3.controllers;


import com.pluralsight.NorthwindTradersAPI3.dao.interfaces.ICategoryDAO;
import com.pluralsight.NorthwindTradersAPI3.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private List<Category> categories;

    @Autowired
    private ICategoryDAO categoryDao;

    public CategoriesController() {
        categories = new ArrayList<>();
        categories.add(new Category(17, "Fruits"));
        categories.add(new Category(21, "Toiletries"));
        categories.add(new Category(30, "Electronics"));
    }

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories() {
        return categories;
    }

    @RequestMapping(path = "/categories/{categoryId}", method = RequestMethod.GET)
    public Category getCategoryById(@PathVariable int categoryId) {
        for (Category category : categories) {
            if (category.getCategoryId() == categoryId) {
                return category;
            }
        }
        return null;
    }

    @RequestMapping(path = "/categories", method = RequestMethod.POST)
    public Category addCategory(@RequestBody Category category) {
        return categoryDao.insert(category);
    }

}
