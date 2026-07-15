/* Example : E-Commerce Application
Customers can search products using different options. */

package com.MethodOverloadingDemo.Examples;

public class SearchProduct {
	public void search(String productName) {
		System.out.println("Searching by Product Name: " + productName);
	}
	
	public void search(String productName, String brand) {
		System.out.println("Search by Product: " + productName + " and Brand: " + brand);
	}
	
	public void search(String productName, String brand, int price) {
		System.out.println("Search by Product: " + productName + ", Brand: " + brand + " and Price: " + price);
	}
	
	public static void main(String[] args) {
		SearchProduct s = new SearchProduct();
		s.search("Laptop");
		s.search("Laptop", "MacBook Pro");
		s.search("Laptop", "Lenovo", 60000);
	}
}
