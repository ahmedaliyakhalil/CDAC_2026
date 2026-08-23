// Question 7: Find the Sum of All Elements in an Array

import java.util.Scanner;

class Assg4Sol7
{
    
    static void calculateArraySum(int[] arr)
    {
        int sum = 0;

        for (int num : arr)
        {
            sum = sum + num;
        }

        System.out.println("The sum of all numbers is: " + sum);
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

        calculateArraySum(numbers);
    }
}