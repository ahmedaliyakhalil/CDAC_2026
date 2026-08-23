// Question 10: Find the Average of Elements in an Array

import java.util.Scanner;

class Assg4Sol10
{
   
    static void calculateArrayAverage(int[] arr)
    {
        int sum = 0;

        for (int num : arr) 
        {
            sum = sum + num;
        }

        
        double average = (double) sum / arr.length;

        System.out.println("The average of the numbers is: " + average);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5]; 

        System.out.print("Enter 5 integers: ");
        for (int i = 0; i < 5; i++)
        {
            numbers[i] = sc.nextInt();
        }

        
        calculateArrayAverage(numbers);
    }
}