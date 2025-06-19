package com.pluralsight.NorthwindTradersAPI3.dao.interfaces;



import com.pluralsight.NorthwindTradersAPI3.models.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> getAll();

    Product getById(int id);

    //added for new exercise
    Product insert(Product product);
}