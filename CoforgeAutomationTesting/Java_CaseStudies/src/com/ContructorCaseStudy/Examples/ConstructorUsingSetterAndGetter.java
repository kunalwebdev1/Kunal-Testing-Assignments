// Create java program using constructor setter and getter method for employee having id, name and salary

package com.ContructorCaseStudy.Examples;

class Employee {
	private int id;
	private String name;
	private float salary;
	private String ssn;
	
    public Employee(int id, String name, float salary, String ssn) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.ssn = ssn;
    }
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
public class ConstructorUsingSetterAndGetter {
	public static void main(String[] args) {
		Employee kunal = new Employee(22, "Kunal M", 1526140.909f, "56545646343");
		System.out.println("Employee ID:\t\t" + kunal.getId());
		System.out.println("Employee Name:\t\t" + kunal.getName());
		System.out.println("Employee Salary:\t\t" + kunal.getSalary());
		System.out.println("Employe SSN:\t\t" + kunal.getSsn());
	}
}
