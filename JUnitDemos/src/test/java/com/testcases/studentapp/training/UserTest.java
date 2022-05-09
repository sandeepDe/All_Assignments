package com.testcases.studentapp.training;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.shristi.training.User;

public class UserTest {
	
	User user = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		user = new User();
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
	}

	@Disabled
	@ParameterizedTest
	@ValueSource(strings={"Great Day","Have a great day","Good day"})
	@Test
	void testGreet() {
		assertEquals("Have a great day", user.greet());
	}

	
	@ParameterizedTest
	@ValueSource(ints= {2,100,-900})
	void testNum(int num) {
		assertTrue(num<user.check());
		assertEquals(num,user.check());
	}

	

}
