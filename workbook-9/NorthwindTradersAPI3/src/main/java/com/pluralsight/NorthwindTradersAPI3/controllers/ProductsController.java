package com.pluralsight.NorthwindTradersAPI3.controllers;


import com.pluralsight.NorthwindTradersAPI3.dao.interfaces.IProductDAO;
import com.pluralsight.NorthwindTradersAPI3.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

    @Autowired
    private IProductDAO productDao;

    public ProductsController() {
        products = new ArrayList<>();
        products.add(new Product(1, "Apple", 17, 0.99));
        products.add(new Product(2, "Banana", 17, 0.59));
        products.add(new Product(3, "Soap", 21, 3.49));
        products.add(new Product(4, "Shampoo", 21, 5.99));
        products.add(new Product(5, "Laptop", 30, 999.99));
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return products;
    }

    @RequestMapping(path = "/products/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    @RequestMapping(path = "/products", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product) {
        return productDao.insert(product);
    }

}

