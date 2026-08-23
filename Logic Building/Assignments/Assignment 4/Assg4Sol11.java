// Question 11: Count Positive and Negative Numbers in an Array

import java.util.Scanner;

class Assg4Sol11
{
    
    static void countPositiveAndNegative(int[] arr)
    {
        int positiveCount = 0;
        int negativeCount = 0;

        for (int num : arr) 
        {
            if (num > 0)
            {
                positiveCount++; 
            }
            else if (num < 0)
            {
                negativeCount++; 
            }
        }

        System.out.println("Positive numbers: " + positiveCount);
        System.out.println("Negative numbers: " + negativeCount);
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

        countPositiveAndNegative(numbers);
    }
}