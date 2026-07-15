package com.FileHandlingDemo.Examples;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
	public static void main(String[] args) {
		try {
			FileWriter myWriter = new FileWriter("K:/files/kunal.txt");
			myWriter.write("Welcome To Coforge Technologies! All the best for learning!");;
			myWriter.close();
			System.out.println("Successfully wrote to the file");
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
	}
}
