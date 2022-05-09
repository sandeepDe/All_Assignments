package com.testcses.productapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.shristi.training.Student;


@Tag("Vehicle-details")
public class VehicleTest {

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
	@Tag("creation")
	void testAdd() {
		Student s1 = new Student();
		
		//Student s2 = new Student();
		
		Student s3 = s1;
		
		assertSame(s1,s3);
	}
	
	
	
	@Test
	@Tag("check")
	
	void testCheck() {
		Student s1 = new Student();
		
		//Student s2 = new Student();
		
		Student s3 = s1;
		
		assertSame(s1,s3);
	}
	
	
	//repetitive checks
	
	@Disabled
	@RepeatedTest(value = 4 , name="{displayName} for {currentRepition} out of {totalRepitions}")
	//@RepeatedTest(value = 4 , name="{displayName} for {currentRepition} st time")
    @DisplayName("testing numbers")
	void testName() {
		assertEquals(10,10);
	}
	
	
	@RepeatedTest(value=10 , name="{displayname}  for {currentRepitition}")
	@DisplayName("Testing Temperature")
	void testTemprature() {
		double num1 = Math.random();
		
		long val1 = Math.round(num1);
		System.out.println(num1 + " " + val1);
		
		double num2 = Math.random();
		
		long val2 = Math.round(num2);
		System.out.println(num2 + " " + val2);
		assertEquals(val1, val2);
	}
	

	

}
