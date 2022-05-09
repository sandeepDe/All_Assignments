package com.bookapp.service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.exception.IdNotFoundException;
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
        if(bookId<=0)
            throw new RuntimeException("Other ype Of Exception");

        return getBookList()
                .stream()
                .filter((book)-> book.getBookId()==bookId)
                .findAny()
                .orElseThrow(()->  new IdNotFoundException("Invalid Id"));

    }

//    @Override
//    public void deleteBookById(int bookId) {
//
//    }

    @Override
    public List<Book> getBookByCategory(String category) {
        List<Book> bookList = getBookList()
                .stream()
                .filter((book)-> book.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        if(bookList.isEmpty())
            throw new BookNotFoundException("Book Not Found With category");
        return bookList;
    }

    @Override
    public List<Book> getBookByAuthor(String author) {
        List<Book> bookList = getBookList()
                .stream().filter((book)-> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
        if(bookList.isEmpty())
            throw new BookNotFoundException("Book Not Found With Author");
        return bookList;

    }

    private List<Book> getBookList(){
        return Arrays.asList(new Book(1,"FountainHead","AynRand","Philosophical"),
                new Book(1,"Eat That Frog","Brian Tracy","Self-help book"),
                new Book(3,"Ways To Heaven" , "Teaky","fiction"));



    }


}
