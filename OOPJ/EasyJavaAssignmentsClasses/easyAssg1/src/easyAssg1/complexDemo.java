/*. Print the sum, difference and product of two complex numbers by creating a 
class named 'Complex' with separate methods for each operation whose real and 
imaginary parts are entered by user.*/


package easyAssg1;

import java.util.Scanner;

class Complex {

    int real;
    int imaginary;

    Complex(int r, int i) {
        real = r;
        imaginary = i;
    }

    void sum(Complex c) {

        int r = real + c.real;
        int i = imaginary + c.imaginary;

        System.out.println("Sum = " + r + " + " + i + "i");
    }

    void difference(Complex c) {

        int r = real - c.real;
        int i = imaginary - c.imaginary;

        System.out.println("Difference = " + r + " + " + i + "i");
    }

    void product(Complex c) {

        int r = (real * c.real) - (imaginary * c.imaginary);
        int i = (real * c.imaginary) + (imaginary * c.real);

        System.out.println("Product = " + r + " + " + i + "i");
    }
}

public class complexDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter real part of first number: ");
        int r1 = sc.nextInt();

        System.out.print("Enter imaginary part of first number: ");
        int i1 = sc.nextInt();

        System.out.print("Enter real part of second number: ");
        int r2 = sc.nextInt();

        System.out.print("Enter imaginary part of second number: ");
        int i2 = sc.nextInt();

        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        c1.sum(c2);
        c1.difference(c2);
        c1.product(c2);

        sc.close();
    }
}
