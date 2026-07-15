package com.AccessModifiers.Examples;
class A {
	int x = 100;
}
public class C_01_Private {
	public static void main(String[] args) {
		A obj = new A();
		int output = obj.x;
		System.out.println("Output is: " + output);
	}
}
