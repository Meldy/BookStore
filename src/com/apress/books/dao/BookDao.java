package com.apress.books.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.apress.books.model.Book;
import com.apress.books.model.Category;
import com.apress.books.model.Author;

//an interface is an abstract class that groups related methods
//cannot be used to create objects
public interface BookDao {
    public List<Book>findAllBooks(); //method for listing all the books from the database
    public List<Book>searchBooksByKeyword(String keyWord); //enables users to search for a book using keywords like the author's name or book title
    public List<Category>findAllCategories(); //display category
    public void insert(Book book);
    public void update(Book book);
    public void delete(Long bookId);
}
public class BookDAOImpl implements BookDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {

        }
    }
    private Connection getConnection()
            throws SQLException {
        return
                DriverManager.getConnection("jdbc:mysql://localhost:3306/books",
        "root", "password");
    }
    private void closeConnection(Connection connection) {
        if (connection == null)
        return;
        try {
            connection.close();
        } catch (SQLException ex) {
        }
    }
    public List<Book> findAllBooks() {
        List<Book> result = new
                ArrayList<>();
        ArrayList<>();
        List<Author> authorList = new
                String sql = "select * from book inner join author on book.id = author.book_id";
        Connection connection = null;
        try {
            connection =
                    getConnection();
            PreparedStatement statement
                    = connection.prepareStatement(sql);
            ResultSet resultSet =
                    statement.executeQuery();
            while (resultSet.next()) {Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setCategoryId(resultSet.getLong("category_id"));
                author.setBookId(resultSet.getLong("book_Id"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                authorList.add(author);
                book.setAuthors(authorList);
                book.setPublisherName(resultSet.getString("publisher"));
                result.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection)
            ;
        }
        return result;
    }
    public List<Book> searchBooksByKeyword(String keyWord) {
        List<Book> result = new ArrayList<>();
        List<Author> authorList = new ArrayList<>();
        String sql = "select * from book inner join author on book.id = author.book_id" + " where book_title like '%" '%" + keyWord.trim() + "%'" + " or first_name like + keyWord.trim()
        + "%'" " or last_name like '%" + keyWord.trim() + "%'";
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                Author author = new Author();
                book.setId(resultSet.getLong("id"));
                book.setBookTitle(resultSet.getString("book_title"));
                book.setPublisherName(resultSet.getString("publisher"));
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));
                author.setBookId(resultSet.getLong("book_id"));
                authorList.add(author);
                book.setAuthors(author List);
                result.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }
    public
    List<Category>
    findAllCategories() {
        List<Category> result = new ArrayList<>();
        String sql = "select * from category";
        Connection connection = null;
        try {connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong("id"));
                category.setCategoryDescription(resultSet.getString("category_description"));
                result.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection(connection
            );
        }
        return result;
    }
    public void insert(Book book) {
    }
    public void update(Book book) {}
    public void delete(Long bookId) {
    }
}
