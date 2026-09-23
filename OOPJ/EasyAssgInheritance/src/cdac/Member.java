/*. Create a class named 'Member' having the following members:
Data members
1 - Name
2 - Age
3 - Phone number
4 - Address
5 - Salary
It also has a method named 'printSalary' which prints the salary of the members.
Create an object of the above class and take input from the console for each of the 
fields and finally display the data.
Now create a class inherited from Members called PrimeMembers and add the 
properties
1. JoiningYear
2. JoiningFees
3. isActive
To the PrimeMembers add a method called display and display all the fields from 
the parent class and derived class. Each of the above classes should have their 
respective accessors and mutators.*/

package cdac;

import java.util.Scanner;

class Members {
	private String name;
	private int age;
	private String phoneNumber;
	private String address;
	private double salary;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void printSalary() {
		System.out.println("Salary : "+salary);
	}
	

}
class PrimeMembers extends Members{
	private int joinigYear;
	private double joiningFees;
	private boolean isActive;
	
	
	
	public int getJoinigYear() {
		return joinigYear;
	}

	public void setJoinigYear(int joinigYear) {
		this.joinigYear = joinigYear;
	}

	public double getJoiningFees() {
		return joiningFees;
	}

	public void setJoiningFees(double joiningFees) {
		this.joiningFees = joiningFees;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void display() {
		
		System.out.println("\n-------------Prime Member Details------------");
		System.out.println("Name: "+getName());
		System.out.println("Age: "+getAge());
		System.out.println("Address: "+getAddress());
		System.out.println("Phone number: "+getPhoneNumber());
		System.out.println("Salary: "+getSalary());
		
		System.out.println("Joining Year: "+getJoinigYear());
		System.out.println("Joining Fees: "+getJoiningFees());
		System.out.println("Active: "+isActive());
		
		
		
	}
	
}

public class Member{
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		PrimeMembers pm = new PrimeMembers();
		
		System.out.println("Enter Name: ");
		pm.setName(sc.nextLine());
		
		System.out.println("Age: ");
		pm.setAge(sc.nextInt());
		
		sc.nextLine();
		System.out.println("Phone number: ");
		pm.setPhoneNumber(sc.nextLine());
		
		System.out.println("Address: ");
		pm.setAddress(sc.nextLine());
		
		

		
		System.out.println("Salary: ");
		pm.setSalary(sc.nextDouble());
		
		System.out.println("Joining Year: ");
		pm.setJoinigYear(sc.nextInt());
		
		System.out.println("Joining Fees: ");
		pm.setJoiningFees(sc.nextDouble());
		
		System.out.println("Active: ");
		pm.setActive(sc.nextBoolean());
		
		pm.display();
		pm.printSalary();
		
	}
}