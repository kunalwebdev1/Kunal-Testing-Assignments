package com.contructors.Examples;

public class C_01_Constructor {
	// Constructor
	public C_01_Constructor() {
		System.out.println("This is the constructor block");
	}
	// Method
	public void method() {
		System.out.println("This is the method block");
	}

	public static void main(String[] args) {
		C_01_Constructor obj = new C_01_Constructor(); //Default Constructor
		// Constructor block will automatically invoked
		// Need to call explicitly for the method
		obj.method();

	}
}
