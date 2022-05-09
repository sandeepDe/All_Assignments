package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
import com.bookapp.model.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    public Book getBookById(int bookId) throws IdNotFoundException;
   // public void deleteBookById(int bookId);
    List<Book> getBookByCategory(String category) throws BookNotFoundException;
    List<Book> getBookByAuthor(String author) throws BookNotFoundException;

}
