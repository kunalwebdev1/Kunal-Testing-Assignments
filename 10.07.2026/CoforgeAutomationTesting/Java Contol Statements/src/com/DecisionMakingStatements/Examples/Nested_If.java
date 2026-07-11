package com.DecisionMakingStatements.Examples;

public class Nested_If {

	public static void main(String[] args) {
		String address = "Mathura, India";
		
		if(address.endsWith("India")) {
			if(address.contains("Meerut")) {
				System.out.println("Yout city is Meerut");
			} else if (address.contains("Noida")) {
				System.out.println("Your city is Noida");
			} else {
				System.out.println(address.split(",")[1]);
			}
		} else {
			System.out.println("You are not living in India");
		}

	}

}
