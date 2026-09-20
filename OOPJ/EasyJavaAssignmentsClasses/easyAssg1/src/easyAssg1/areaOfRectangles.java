/*3. Write a program to print the area of two rectangles having sides (4,5) and (5,8) 
respectively by creating a class named 'Rectangle' with a method named 'area' 
which returns the area and length and breadth passed as parameters to its 
constructor.*/



package easyAssg1;


class Rectangle {

    int length;
    int breadth;

    Rectangle(int l, int b) {
        length = l;
        breadth = b;
    }

    int area() {
        return length * breadth;
    }
}

public class areaOfRectangles {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(4, 5);
        Rectangle r2 = new Rectangle(5, 8);

        System.out.println("Area of first rectangle = " + r1.area());
        System.out.println("Area of second rectangle = " + r2.area());
    }
}
