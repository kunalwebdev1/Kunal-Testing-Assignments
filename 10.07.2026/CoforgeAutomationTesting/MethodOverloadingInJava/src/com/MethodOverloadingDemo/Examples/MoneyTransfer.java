/* Example 1: Banking Application
Scenario:
A customer can transfer money in different ways:
Transfer only the amount
Transfer amount to another account
Transfer amount with remarks

*/

package com.MethodOverloadingDemo.Examples;

public class MoneyTransfer {
	public void transfer(double amount) {
		System.out.println("Transferred Amount: " + amount);
	}
	public void transfer(double amount, String accountNumber) {
		System.out.println("Transferred: " + amount + " to Account: " + accountNumber);
	}
	public void transfer(double amount, String accountNumber, String remarks) {
		System.out.println("Transferred: " + amount);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Remarks: " + remarks);
	}
	public static void main(String[] args) {
		MoneyTransfer mt = new MoneyTransfer();
		mt.transfer(10000);
		mt.transfer(5000, "CNRB0001526");
		mt.transfer(15000, "110015623", "Travelling");
	}
}
