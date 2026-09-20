/*1. create a class called ComplexNumber having 2 data members as number1 and number2.  Create a pair
of ge er and se er for the above. Create a method called computeComplexNumber that will mul ply 
the values of the 2 data members and return it in the form of int. For the above create an array of 
ComplexNumber having 5 elements and in a loop ask the user to enter number1 and number2 5 mes 
each such that each object of the ComplexNumber hold appropriate values. Finally call the 
computeComplexNumber on each object of the array to display the result.*/



package arrays;

import java.util.Scanner;

class ComplexNumber {

    private int number1;
    private int number2;

    // Setter for number1
    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    // Getter for number1
    public int getNumber1() {
        return number1;
    }

    // Setter for number2
    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    // Getter for number2
    public int getNumber2() {
        return number2;
    }

    // Method to multiply two numbers
    public int computeComplexNumber() {
        return number1 * number2;
    }
}

public class arrayqst1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ComplexNumber[] numbers = new ComplexNumber[5];

        for (int i = 0; i < 5; i++) {

            numbers[i] = new ComplexNumber();

            System.out.println("Enter details for object " + (i + 1));

            System.out.print("Enter number1: ");
            int n1 = sc.nextInt();

            System.out.print("Enter number2: ");
            int n2 = sc.nextInt();

            numbers[i].setNumber1(n1);
            numbers[i].setNumber2(n2);
        }

        System.out.println("\nResults:");

        for (int i = 0; i < 5; i++) {

            int result = numbers[i].computeComplexNumber();

            System.out.println(
                numbers[i].getNumber1() + " * " +
                numbers[i].getNumber2() + " = " + result
            );
        }

        sc.close();
    }
}

