package com.apress.books.model;

import java.util.List;
import com.apress.books.model.Author;

public class Book<authors> {
    private Long id;
    private Long categoryId;
    private String bookTitle;
    private List<Author> authors;
    private String publisherName;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    public List<Author> getAuthors() {
        return authors;
    }
    public
    authors) {
        void
        setAuthors(List272103_1_En
        this.authors
        this.authors = authors;
    }
    public String getPublisherName() {
        return publisherName;
    }
    public
    void
    publisherName) {
        setPublisherName(String
        this.publisherName = publisherName;
    }
    public String toString() {
        return "com.apress.books.model.Book - Id: " + id + ", com.apress.books.model.Book Title:
        " + bookTitle;
    }
}