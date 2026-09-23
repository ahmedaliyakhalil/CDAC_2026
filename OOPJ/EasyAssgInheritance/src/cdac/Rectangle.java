/*3. Create a class named 'Rectangle' with two data members 'length' and 'breadth' and
two methods to print the area and perimeter of the rectangle respectively. Its
constructor having parameters for length and breadth is used to initialize length and
breadth of the rectangle. Let class 'Square' inherit the 'Rectangle' class with its
constructor having a parameter for its side. Print the area and perimeter of a rectangle
and a square*/


package cdac;

class RectangleClass {
	int length;
	int breadth;
	
	RectangleClass(int length,int breadth){
		this.length=length;
		this.breadth=breadth;
	}
	
	void area() {
		System.out.println("Reactagle area : "+(length*breadth));
		
	}
	void perimeter() {
		System.out.println("Reactagle perimeter : "+(2 *(length+breadth)));
	} 
	

}
class Square extends RectangleClass{
	int side;
	Square(int side){
		super(side,side);
		
	}
	
}
public class Rectangle{
	public static void main(String[]args) {
		RectangleClass r = new RectangleClass(10,5);
		r.area();
		r.perimeter();
		
		Square s = new Square(5);
		s.area();
		s.perimeter();
		
	}
}