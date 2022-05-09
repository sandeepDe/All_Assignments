package com.bookapp.testcases;


import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bookapp.exceptions.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.service.IBookService;
import com.bookapp.service.OrderDetails;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)

class OrderDetailsTest {
	
	@Mock
	IBookService bookService;
	
	@InjectMocks
	
	OrderDetails orderDetails = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	Book book1, book2,book3,book4,book5;
	
	@BeforeEach
	void setUp() throws Exception {
		//orderDetails = new OrderDetails();
		
		
		//orderDetails.setBookService(bookService);
		
		 book1 = new Book(1,"java","Sandeep",800);
		 book2 = new Book(2,"spring","Sandeep",800);
		 book3 = new Book(3,"js","Sandeep",800);
		 book4 = new Book(4,"js","Avinash",800);
		 
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	
	


	@Test
	@DisplayName("Testing By Author")
	void testBookByAuthor() throws BookNotFoundException {
		
		String author = "Sandeep";
		
		List<Book> booksByAuthor = Arrays.asList(book1,book2,book3);
		
		when(bookService.getByAuthor(author)).thenReturn(booksByAuthor);
		
		//assertThrows(BookNotFoundException.class, ()->orderDetails.findByAuthor(author));
		
		List<Book> books = orderDetails.findByAuthor(author);
		
		assertNotNull(books);
		
		
	}
	

	@Test
	@DisplayName("Testing By Author - returning null")
	void testFindByAuthorNull() throws BookNotFoundException {

		String author = "kathy";
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book> books = orderDetails.findByAuthor(author);
		assertNull(books);

	}
	
	
	@Test
	@DisplayName("Testing By Author - empty list")
	void testFindByAuthoEmpty() throws BookNotFoundException {

		String author = "kathy";

		when(bookService.getByAuthor(author)).thenReturn(new ArrayList<Book>());

		assertThrows(BookNotFoundException.class, () -> orderDetails.findByAuthor(author));

	}


	
	@Test
	@DisplayName("Testing By Author - empty list")
	void testByAuthorException() throws BookNotFoundException {
		String author = "paul";
		when(bookService.getByAuthor(author)).thenThrow(new BookNotFoundException(author));
		assertThrows(BookNotFoundException.class, () -> orderDetails.findByAuthor(author));
	}
	
	
	@Test
	@DisplayName("Testing Verify")
	void testVerify()throws BookNotFoundException{
		String author = "Kathy";
		
		List<Book> expected = Arrays.asList(book1,book2,book3);
		when(bookService.getByAuthor(author)).thenReturn(Arrays.asList(book1,book2,book3));
		
		List<Book> actualList = orderDetails.findByAuthor(author);
		assertEquals(expected.toString(), actualList.toString());
		assertNotNull(actualList);
		
		when(bookService.getByAuthor(author)).thenReturn(null);
		List<Book>actual = orderDetails.findByAuthor(author);
		assertNull(actual);
		
		Mockito.verify(bookService,times(2)).getByAuthor(author);
		
		
	}
	
	
	
	
	
	

	
}
