package com.DecisionMakingControlStatement.Examples;

public class LoginValidation_AutomationTesting {
	public static void main(String[] args) {
		String username = "student";
        String password = "Password123";

        if (!username.isEmpty() && !password.isEmpty()) {
            System.out.println("Login Successful.");
        }
	}
}
