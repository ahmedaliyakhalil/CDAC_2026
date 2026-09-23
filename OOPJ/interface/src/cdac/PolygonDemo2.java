

/*Write a Java 7-style application with the following requirements:

Create an interface called RegularPolygon with two abstract methods:
getNumSides()
getSideLength()
Create a class EquilateralTriangle that implements RegularPolygon.
getNumSides() should return 3.
getSideLength() should return the side length stored in an instance variable.
Initialize the side length using a constructor.
Create a class Square that implements RegularPolygon.
getNumSides() should return 4.
getSideLength() should return the side length stored in an instance variable.
Initialize the side length using a constructor.
Add a static method totalSides(RegularPolygon[]) to the interface.
It should return the total number of sides of all polygons in the array.
Add two default methods to the interface:
getPerimeter() → number of sides × side length
getInteriorAngle() → (n - 2) × π / n radians, where n is the number of sides.
In the main() method:
Create an EquilateralTriangle object.
Create a Square object.
Display their number of sides, side length, perimeter, and interior angle.
Store both objects in a RegularPolygon[].
Display the total number of sides using the static totalSides() method.*/


package cdac;

interface RegularPolygon{
	int getNumSides();
	double getSideLength();
	
	default double getPertimeter() {
		return getNumSides()*getSideLength();
	}
	
	default double getInteriorAngle() {
		int n= getNumSides();
		return ((n-2)* Math.PI)/n;
	}
	
	static int totalSides(RegularPolygon[]polygons) {
		int total=0;
		for(RegularPolygon p:polygons) {
			total=total+p.getNumSides();
		}
		return total;
	}
}
class EquilateralTriangle implements RegularPolygon
{
	private double sideLength;
	
	EquilateralTriangle(double sideLength){
		this.sideLength= sideLength;
	}
	public int getNumSides() {
		return 3;
	}
	public double getSideLength() {
		return sideLength;
	}
	
}

class Square implements RegularPolygon{
	private double sideLength;
	
	Square(double sideLength){
		this.sideLength= sideLength;
	}
	public int getNumSides() {
		return 4;
	}
	public double getSideLength() {
		return sideLength;
	}
}


public class PolygonDemo2 {

	public static void main(String[] args) {
		EquilateralTriangle triangle = new EquilateralTriangle(5);
		
		Square square= new Square(10);
		
		System.out.println("Triangle side: "+triangle.getNumSides());
		System.out.println("Triangle length: "+triangle.getSideLength());
		System.out.println("Triangle perimeter: "+triangle.getPertimeter());
		System.out.println("Triangle interior angle: "+triangle.getInteriorAngle());

		System.out.println("\n");
		System.out.println("Square side: "+square.getNumSides());
		System.out.println("Square length: "+square.getSideLength());
		System.out.println("Square perimeter: "+square.getPertimeter());
		System.out.println("Square interior angle: "+square.getInteriorAngle());
		System.out.println();
		
		RegularPolygon[] polygon= {triangle, square};
	
		System.out.println("Total side: "+RegularPolygon.totalSides(polygon));
		
	}

}
