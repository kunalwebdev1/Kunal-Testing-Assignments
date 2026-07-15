package com.BankingApplication.Examples;

class Account {
	String accountHolder = "Kunal Maheshwari";
	double balance = 100000;
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Amount Deposited: " + amount);
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Amount Withdrawn: " + amount);
	}
	
	public void displayBalance() {
		System.out.println("Current Balance: " + balance);
	}
}

class SavingsAccount extends Account {
	public void calculateInterest() {
		double interest = balance * 5 / 100;
		System.out.println("Interest Earned: " + interest);
	}
}

public class BankTestDemo {
	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount();
		System.out.println("Account Holder: " + sa.accountHolder);
		sa.deposit(65000);
		sa.withdraw(5000);
		sa.displayBalance();
		sa.calculateInterest();
	}
}
