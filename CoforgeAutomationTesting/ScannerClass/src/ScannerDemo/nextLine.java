package ScannerDemo;

import java.util.Scanner;

public class nextLine {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter your first name Initial");
		String firstInitial = sc.nextLine();
		
		System.out.println("Please enter your last name Initial");
		String lastName = sc.nextLine();
		
		System.out.println("Please enter your house number");
		String houseNumber = sc.nextLine();
		
		System.out.println("Please enter your street name");
		String streetName = sc.nextLine();
		
		System.out.println("Please enter your street type");
		String streetType = sc.nextLine();
		
		System.out.println("Please enter your city");
		String city = sc.nextLine();
		
		System.out.println(firstInitial + " " + lastName + " " + houseNumber + " ");
		System.out.println(streetName + " " + streetType + " " + city + " ");
	}
}
