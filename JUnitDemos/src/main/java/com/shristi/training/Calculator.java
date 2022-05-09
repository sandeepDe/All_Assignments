package com.shristi.training;

public class Calculator {
	
	
	
	public int add(int a , int b) {
		System.out.println("In Add Method");
		
		return a+b;
		
	}
	
	
	public int product(int a ,int b) {
		return a*b;
	}
	
	public double difference (double a , double b) {
		return a-b;
	}
	
	public String greetUser(String name) {
		return "Welcome " + name.toUpperCase();
	}
	
	

}
