package com.pluralsight.NorthwindTradersAPI3.dao.interfaces;



import com.pluralsight.NorthwindTradersAPI3.models.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAll();

    Category getById(int id);

    // added for new exercise
    Category insert(Category category);
}