package com.pluralsight.NorthwindTradersAPI3.controllers;


import com.pluralsight.NorthwindTradersAPI3.models.Category;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {
    private List<Category> categories;

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
}
