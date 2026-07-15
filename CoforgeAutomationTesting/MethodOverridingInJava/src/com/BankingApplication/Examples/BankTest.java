/* Real-Time Explanation 
Every bank has an Interest Calculation feature.

However:

SBI calculates 6.5%
HDFC calculates 7%
ICICI calculates 6.8%
 */


package com.BankingApplication.Examples;

class Bank {
	public void calculateInterest() {
		System.out.println("General Interest Calculation");
	}
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
public class BankTest {
	public static void main(String[] args) {
		SBI sbi = new SBI();
		sbi.calculateInterest();
		
		HDFC hdfc = new HDFC();
		hdfc.calculateInterest();
		
		ICICI icici = new ICICI();
		icici.calculateInterest();
	}
}
