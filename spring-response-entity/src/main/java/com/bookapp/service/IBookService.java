package com.bookapp.service;

import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    public Book getBookById(int bookId);
   // public void deleteBookById(int bookId);
    List<Book> getBookByCategory(String category);
    List<Book> getBookByAuthor(String author);

}
