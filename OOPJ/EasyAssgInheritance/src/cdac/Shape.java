/*
 * 4. Create a class named 'Shape' with a method to print "This is shape". Then create
two other classes named 'Rectangle', 'Circle' inheriting the Shape class, both having
a method to print "This is rectangular shape" and "This is circular shape"
respectively. Create a subclass 'Square' of 'Rectangle' having a method to print
"Square is a rectangle". Now call the method of 'Shape' and 'Rectangle' class by the
object of 'Square' class*/

package cdac;

class printShape {
	void displayShape() {
		System.out.println("This is a shape");
	}

}
class Rectangle1 extends printShape{
	void displayRectangle() 
	{
		System.out.println("This is a rectangle shape");
	}
}
class Circle extends printShape{
	void displayCircle() {
		System.out.println("This is a circle shape");
	}
}
class Square1 extends Rectangle1{
	void displaySquare() {
		System.out.println("Square is a rectangle");
	}
}
public class Shape{
	public static void main(String[]args) {
		Square1 sq=new Square1();
		sq.displayShape();
		sq.displayRectangle();
		sq.displaySquare();
	}
}
	
	
