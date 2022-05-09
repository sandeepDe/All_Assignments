package com.bookapp.service;

import com.bookapp.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements IBookService{
    @Override
    public void addBook(Book book) {
        System.out.println(book);

    }

    @Override
    public Book getBookById(int bookId) {
        return getBookList()
                .stream()
                .filter((book)-> book.getBookId()==bookId)
                .findAny()
                .orElse(new Book());
    }

//    @Override
//    public void deleteBookById(int bookId) {
//
//    }

    @Override
    public List<Book> getBookByCategory(String category) {
        return getBookList()
                .stream()
                .filter((book)-> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        return getBookList()
                .stream().filter((book)-> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    private List<Book> getBookList(){
        return Arrays.asList(new Book(1,"FountainHead","AynRand","Philosophical"),
                new Book(1,"Eat That Frog","Brian Tracy","Self-help book"),
                new Book(3,"Ways To Heaven" , "Teaky","fiction"));



    }


}
