package com.FileHandlingDemo.Examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) {
		try {
			File myObj = new File("K:/files/kunal.txt");
			Scanner sc = new Scanner(myObj);
			
			while (sc.hasNextLine()) {
				String data = sc.nextLine();
				System.out.println(data);
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred - File not Found");
			e.printStackTrace();
		}
	}
}
