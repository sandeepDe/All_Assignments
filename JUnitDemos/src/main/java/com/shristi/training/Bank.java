package com.shristi.training;

import com.shristi.exceptions.ExceedingMaximumException;
import com.shristi.exceptions.NegativeValueException;

public class Bank {
	
	/*
	 * Bank double balance; // para constr double deposit(int amount){ return
	 * bal+amount} withdraw(int amount)
	 * 
	 * 
	 * // 2 exceptions //
	 */
	
	
	double balance ;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Bank(double balance) {
		super();
		this.balance = balance;
	}
	
	
	double deposit(int amount) throws NegativeValueException, ExceedingMaximumException {
		
		if(amount <0) {
			throw new NegativeValueException("Amount should not be less than 0") ;
		}
		
		if (amount > 20000) {
			throw new ExceedingMaximumException("Maximun Deposit Limit is 20000");
		}
		
		return balance + amount;
		
	}
	
	
	double withDraw(int amount) throws ExceedingMaximumException {
		if(amount > 10000) {
			throw new ExceedingMaximumException("Maximun amount to withDraw is 10k");
		}
		if(amount > balance) {
			throw new ExceedingMaximumException("Insufficient Funds");
		}
		
		if(amount < 500) {
			throw new ExceedingMaximumException("Minimun amount to withDraw is 500");
		}
		
		return balance-amount;
	}

}
