package com.bookapp.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderDetailsTestCase {
    
    @Mock
    IBookService bookService;
    
    @InjectMocks
    OrderDetails details;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    Book book1, book2, book3, book4, book5;
    @BeforeEach
    void setUp() throws Exception {

        book1 = new Book(1, "Java", "Kathy", 900);
        book2 = new Book(2, "JSP", "Kathy", 200);
        book3 = new Book(3, "Seven Habits", "Steve", 300);
        book4 = new Book(4, "5am Club", "Robin", 800);
        book5 = new Book(5, "Spring", "Kathy", 100);
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    @DisplayName("Testing Correct Order")
    void testOrderBook() throws BookNotFoundException {
        int bookId=1;
        doReturn(book1).when(bookService).getById(bookId);
        String actual=details.orderBook(bookId);
        assertEquals("Ordered Successfully", actual);
        
        
    }
    
    
    @Test
    @DisplayName("Testing book returns null")
    void testOrderBookNull() throws BookNotFoundException {
        int bookId=1;
        doReturn(null).when(bookService).getById(bookId);
        String actual= details.orderBook(bookId);
        assertEquals("Book not Ordered", actual);
        
        
    }
    
    
    @Test
    @DisplayName("Testing book returning exception")
    void testOrderBookException() throws BookNotFoundException {
        int bookId=1;
        doThrow(new BookNotFoundException("Done")).when(bookService).getById(bookId);
        
        
    String actual = details.orderBook(bookId);
    assertEquals("Technical Issue", actual);
        
    }
    
    
    @Test
    @DisplayName("Testing Add Book with noReturn type")
    void testAddBook() {
    	doNothing().when(bookService).addBook(book1);
    	String actual = details.addBook(book1);
    	assertEquals("Book Added", actual);
    }
    
    
    @Test
    @DisplayName("Testing for Null book with void type")
    void testAddBookNull() {
    	doNothing().when(bookService).addBook(null);
    	String actual = details.addBook(null);
    	assertEquals("book not added",actual);
    }
    
   
    

    

}