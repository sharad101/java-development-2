package com.pluralsight.apireview.services;

import com.pluralsight.apireview.dao.interfaces.IBookDAO;
import com.pluralsight.apireview.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookService {
    private IBookDAO bookDAO;

    @Autowired
    public BookService(IBookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllBooks(String title, String author, Integer publication_year){
        return bookDAO.getAllBooks(title, author, publication_year);
    }


}
