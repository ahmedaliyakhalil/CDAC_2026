/*2. Write a program to print the area and perimeter of a triangle having sides of 3, 4 
and 5 units by creating a class named 'Triangle' with constructor having the three 
sides as its parameters.*/


package easyAssg1;

class Triangle {

    int side1;
    int side2;
    int side3;

    Triangle(int a, int b, int c) {
        side1 = a;
        side2 = b;
        side3 = c;
    }

    double area() {

        double s = (side1 + side2 + side3) / 2.0;

        double result = Math.sqrt(
            s * (s - side1) * (s - side2) * (s - side3)
        );

        return result;
    }

    int perimeter() {
        return side1 + side2 + side3;
    }
}

public class triangleAreaPeri {

    public static void main(String[] args) {

        Triangle t = new Triangle(3, 4, 5);

        System.out.println("Area of triangle = " + t.area());
        System.out.println("Perimeter of triangle = " + t.perimeter());
    }
}

