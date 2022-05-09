package com.testcases.studentapp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shristi.exceptions.ExceedingMaximumException;
//import com.shristi.exceptions.InvalidNumException;
import com.shristi.exceptions.NegativeValueException;
import com.shristi.training.Student;

class StudentTest {

	Student student = null; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		student = new Student();
	}

	@AfterEach
	void tearDown() throws Exception {
		student = null;
	}

	@Test
	@DisplayName("Testing Positive Values")
	void testTotalMarks() throws NegativeValueException, ExceedingMaximumException {
		
		assertEquals(200, student.totalMarks(100, 50, 50),"values not matched");
		
		
	}
	
	
	@Test
	@DisplayName("Testing Negative values")
	void testNegAtiveTotalMarks() {
		assertThrows(NegativeValueException.class , ()->student.totalMarks(-50,-20,50));
	}
	
	@Test
	@DisplayName("100")
	void testGreaterTotalMarks() {
		assertThrows(ExceedingMaximumException.class, ()-> student.totalMarks(100, 200,300));
	}
	
	@Test
	@DisplayName("Testing grade-A")
	void testGradeA() throws ExceedingMaximumException {
		int[] marks = {90,90,95};
		
		String grade = student.getGrade(marks);
		
		
		assertEquals("A",grade,"Expecting A");
	}
	
	
	@Test
	@DisplayName("Testing grade-B")
	void testGradeB() throws ExceedingMaximumException {
		int[] marks = {80,90,80};
		
		String grade = student.getGrade(marks);
		
		
		assertEquals("B",grade,"Expecting B");
	}
	
	@Test
	@DisplayName("Testing grade-C")
	void testGradeC() throws ExceedingMaximumException {
		int[] marks = {70,70,70};
		
		String grade = student.getGrade(marks);
		
		
		assertEquals("C",grade,"Expecting C");
	}
	
	@Test
	@DisplayName("Testing grade-D")
	void testGradeD() throws ExceedingMaximumException {
		int[] marks = {60,60,60};
		
		String grade = student.getGrade(marks);
		
		
		assertEquals("D",grade,"Expecting D");
	}
	
	@Test
	@DisplayName("Testing grade-FAIL")
	void testGradeF() throws ExceedingMaximumException {
		int[] marks = {30,30,30};
		
		String grade = student.getGrade(marks);
		
		
		assertEquals("F",grade,"Expecting F");
	}
	
	@Test
	@DisplayName("Testing Negative values")
	void testGrade() throws ExceedingMaximumException {
		int[] marks = {-50,-60,-70};
		assertThrows(ExceedingMaximumException.class,()->student.getGrade(marks));
	}
	
	@Test
	@DisplayName("Testing final result")
	void testFinal() throws ExceedingMaximumException {
		
		int [] marks = null;
		
		
		assertEquals("completed", student.getGrade(marks));
	}

}
