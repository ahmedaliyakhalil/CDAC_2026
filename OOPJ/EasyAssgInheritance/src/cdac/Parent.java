/*1. Create a class with a method that prints "This is parent class" and its subclass 
with another method that prints "This is child class". Now, create an object for 
each of the class and call
1 - method of parent class by object of parent class
2 - method of child class by object of child class
3 - method of parent class by object of child class*/


package cdac;

class Parentd {
	void parentMethod() {
		System.out.println("this is a parent class");
	}
	
}
class Child extends Parentd{
	void childMethod() {
		System.out.println("this is a child class");
	}
}

public class Parent{
	public static void main(String[] args) {
		Parentd p = new Parentd();
		p.parentMethod();
		
		Child c=new Child();
		c.childMethod();
		
		c.parentMethod();
		
	}
}