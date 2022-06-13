package com.apress.books.dao;

import java.util.List;

import com.apress.books.model.Book;
import com.apress.books.model.Category;

public interface BookDao {
    public List<Book>findAllBooks(); //method for listing all the books from the database
    public List<Book>searchBooksByKeyword(String keyWord); //enables users to search for a book using keywords like the author's name or book title
    public List<Category>findAllCategories();
    public void insert(Book book);
    public void update(Book book);
    public void delete(Long bookId);
}
