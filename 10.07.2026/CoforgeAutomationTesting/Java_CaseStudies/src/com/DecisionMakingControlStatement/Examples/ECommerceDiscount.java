package com.DecisionMakingControlStatement.Examples;

public class ECommerceDiscount {

	public static void main(String[] args) {
		double amount = 650;
		System.out.println("Amount without discount: " + amount);
		if(amount > 5000) {
			double discount = amount*0.25;
			amount = amount - discount;
			System.out.println("Congratulations! You got a discount of: "+ discount);
			System.out.println("New amount to be paid is: "+ amount);
		}
		else {
			System.out.println("Amount not eligible for discount");
		}

	}

}
