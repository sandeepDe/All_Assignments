package com.shristi.training;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.shristi.exceptions.ExceedingMaximumException;
import com.shristi.exceptions.NegativeValueException;

class BankTest {
	
	Bank bank = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		bank = new Bank(30000);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	

	@AfterEach
	void tearDown() throws Exception {
		bank = null;
	}

	@Test
	@DisplayName("DepositLowAmount")
	void DepositLowAmount() throws ExceedingMaximumException, NegativeValueException {
		
	int amount = -600;
		
		
	assertThrows(NegativeValueException.class,()-> bank.deposit(amount));
		
		
	}
	
	
	
	
	
	@Test
	@DisplayName("DepositHighAmount")
	void DepositHighAmount() throws ExceedingMaximumException, NegativeValueException {
		
	int amount = 500000;
		
		
	assertThrows(ExceedingMaximumException.class,()-> bank.deposit(amount));
		
		
	}
	
	@Test
	@DisplayName("DisplayBalance")
	
	void DepositDisplayAmount() throws NegativeValueException, ExceedingMaximumException {
		int amount = 4000;
		
		assertEquals(34000, bank.deposit(amount));
	}
	
	
	@Test
	@DisplayName("WithdraLowAmount")
	void withdrawLowAmount()  {
		
	int amount = -600;
		
		
	assertThrows(ExceedingMaximumException.class,()-> bank.withDraw(amount));
		
		
	}
	
	
	@Test
	@DisplayName("WithdraMaxAmount")
	void withdrawMaxAmount()  {
		
	int amount = 50000;
		
		
	assertThrows(ExceedingMaximumException.class,()-> bank.withDraw(amount));
		
		
	}
	
	
	
	@Test
	@DisplayName("InsufficeintFunds")
	void withdrawAmount()  {
		
	int amount = 1000000;
	
		
		
	assertThrows(ExceedingMaximumException.class,()-> bank.withDraw(amount));
		
		
	}
	
	

	
	
	
	
	

}
