package com.bookapp.controllers;

import com.bookapp.model.Book;
import com.bookapp.service.BookServiceImpl;
import com.bookapp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Here We are using Response Entity(It is a representation of Http response)

@RestController //For Controlling REST Full APIs
public class BookController {

    //We Can also AutoWire Here but best Practice is to AutoWire the Setter Method
    private IBookService bookService;

    //AutoWiring the setter method of IBookService for accessing the methods from IBookService
    //We can also AutoWire for Constructor
    //
    @Autowired
    public void setBookService(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    //Mapping for path "/greet" that returns String Message
    @GetMapping("/greet")
    public ResponseEntity<String> sayHello(){
        String msg = "Welcome to Book App";
        //For creating custom headers we need to create instance for HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        // Creating Custom Headers here
        headers.add("desc","Online Book Application");
        //Below we are creating ResponseEntity object for sending status , headers , body as a response
        return new ResponseEntity<String>(msg,headers, HttpStatus.OK);
    }

    //Mapping for Getting a Single book
    @GetMapping("/books/bookId/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int bookId){
        Book book = bookService.getBookById(bookId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting Book By Id");
        headers.add("san","lol we can add anything here");
        //but here we are using static method of ResponseEntity for sending status , headers , body as a response
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(book);


    }

    //Mapping for getting List of Books on basis of category
    @GetMapping("/books/category/{category}")
    public ResponseEntity<List<Book> >getBokByCategory(@PathVariable("category") String category){
        List <Book> books = bookService.getBookByCategory(category);
        // below i Don't want to send headers and body so i have used Response.ok method
        return ResponseEntity.ok(books);
    }



    // For Adding Book I Don't want to return any content from body part of the response so, I used Void as a return type for ResponseEntity
    @PostMapping("/books")
    ResponseEntity<Void> addBook(@RequestBody Book book){
        bookService.addBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Book Added");
        return  ResponseEntity.status(HttpStatus.OK).headers(headers).build();// Build Methods helps to build the ResponseEntity with No Body

    }



























}
