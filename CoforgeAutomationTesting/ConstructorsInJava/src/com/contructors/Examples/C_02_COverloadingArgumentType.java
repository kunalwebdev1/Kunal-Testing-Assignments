package com.contructors.Examples;

public class C_02_COverloadingArgumentType {
	//constructor1
	public C_02_COverloadingArgumentType(int a, int b) {
		int c = a + b;
		System.out.println("Summation is: " + c);
	}
	//constructor2
	public C_02_COverloadingArgumentType(double a, double b) {
		double c = a + b;
		System.out.println("Summation is: " + c);
	}
	//method
	public void display() {
		System.out.println("Constructor overloading is working successfully");
	}
	public static void main(String[] args) {
		C_02_COverloadingArgumentType obj1 = new C_02_COverloadingArgumentType(10, 20);
		obj1.display();
		C_02_COverloadingArgumentType obj2 = new C_02_COverloadingArgumentType(10.25, 20.362);
		obj2.display();
	}
}
