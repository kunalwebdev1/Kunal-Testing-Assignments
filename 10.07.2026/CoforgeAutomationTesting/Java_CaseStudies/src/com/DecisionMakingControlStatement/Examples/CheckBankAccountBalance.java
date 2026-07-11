package com.DecisionMakingControlStatement.Examples;

public class CheckBankAccountBalance {

	public static void main(String[] args) {
		
		double balance = 10000;
		int num = 1;
		switch(num) {
		case 1:
			System.out.println("Bank Balance is: "+balance);
			break;
		
		case 2:
			System.out.println("Withdrwal Not Allowed Low Balance error");
			break;
		
		default:
			System.out.println("Bye Bye");	
		}
		
		

	}

}
