package com.testcases.calcapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.shristi.training.Calculator;

public class CalculatorTest {

	Calculator calc = null;

	@BeforeAll
	public static void init() {
		System.out.println("CALLED BEFORE ALL THE TEST CASES");

	}
	@BeforeEach
	public void setup() {
		System.out.println("CALLED BEFORE EACH TEST CASE");

		calc = new Calculator();
	}

	

	@Test
	public void testAdd() {
		int actualResult = calc.add(20, 30);

		int expected = 50;

		assertEquals(expected, actualResult, "The Expected output is 50 ");
	}

	@Test
	public void testProduct() {

		assertEquals(40, calc.product(20, 2), "res = 40");

	}
	
	@Test
	public void testDifference() {
		assertEquals(10, calc.difference(20, 10) , "Output:10");
	}
	
	@Test
	public void testGreetUser() {
		assertEquals("Welcome SANDEEP" , calc.greetUser("Sandeep"));
	}
	
	@AfterEach
	public  void tearDown() {
		System.out.println("CALLED AFTER EACH TEST CASE");
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("CALLED AFTER ALL THE TEST CASES");
	}
	

	
}
