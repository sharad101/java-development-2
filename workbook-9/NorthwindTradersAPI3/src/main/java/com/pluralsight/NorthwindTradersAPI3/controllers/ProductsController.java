package com.pluralsight.NorthwindTradersAPI3.controllers;


import com.pluralsight.NorthwindTradersAPI2.models.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {
    private List<Product> products;

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
}

