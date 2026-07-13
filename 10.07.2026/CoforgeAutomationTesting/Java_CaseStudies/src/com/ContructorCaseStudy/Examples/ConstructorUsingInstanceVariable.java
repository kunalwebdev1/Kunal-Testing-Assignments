package com.ContructorCaseStudy.Examples;

public class ConstructorUsingInstanceVariable {
	
	String webName;
	int webAge;
	
	ConstructorUsingInstanceVariable(String name, int age) {
		this.webName = name;
		this.webAge = age;
	}
	

	public static void main(String[] args) {
		ConstructorUsingInstanceVariable obj1 = new ConstructorUsingInstanceVariable("Kunal", 20);
		ConstructorUsingInstanceVariable obj2 = new ConstructorUsingInstanceVariable("https://www.google.com/", 18);
		
		System.out.println(obj1.webName + " " + obj1.webAge);
		System.out.println(obj2.webName + " " + obj2.webAge);

	}

}
