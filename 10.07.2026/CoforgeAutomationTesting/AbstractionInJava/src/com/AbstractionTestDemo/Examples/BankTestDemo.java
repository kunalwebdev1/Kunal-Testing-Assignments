package com.AbstractionTestDemo.Examples;


abstract class Bank {
	public void deposit() {
		System.out.println("Money Deposited");
	}
	public void withdraw() {
		System.out.println("Money Withdrawn");
	}
	abstract void calculateInterest();
}

class SBI extends Bank {
	@Override
	public void calculateInterest() {
		System.out.println("SBI Interest = 6.5%");
	}
}

class HDFC extends Bank {
	@Override
	public void calculateInterest() {
		System.out.println("HDFC Interest = 7%");
	}
}

class ICICI extends Bank {
	@Override
	public void calculateInterest() {
		System.out.println("ICICI Interest = 6.8%");
	}
}
public class BankTestDemo {
	public static void main(String[] args) {
		SBI sbi = new SBI();
		sbi.calculateInterest();
		sbi.deposit();
		
		
		HDFC hdfc = new HDFC();
		hdfc.calculateInterest();
		
		ICICI icici = new ICICI();
		icici.calculateInterest();
		icici.withdraw();
	}
}
