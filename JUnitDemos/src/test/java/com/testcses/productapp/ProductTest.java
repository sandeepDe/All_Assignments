package com.testcses.productapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("product")
public class ProductTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Tag("Adding")
	void testAdd() {
		String s1 = "Hi";
		String s2 ="Hello";
		
		assertSame(s1,s2);
		
		
	}
	
	
	@Test
	@Tag("All-Products")
	void testAll() {
		int[] numbers = null;
		
		assertNull(numbers,"numbers is not null");
		
		
	}
	
	
	@Test
	@Tag("by-brand")
	void testAllBrands() {
		int[] numbers = null;
		
		assertNull(numbers,"numbers is null");
		
		
	}
	
	
	
	
	

}
