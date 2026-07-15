package com.AccessModifiers.Examples;

public class C_03_Protected extends B{
	{
		C_03_Protected obj = new C_03_Protected();
		int output = obj.z;
		System.out.println("Value of z is: " + output);
		obj.ProtectedMethod();
	}
}
