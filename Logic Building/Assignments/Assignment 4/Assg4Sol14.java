// Question 14: Find the Index of an Element in an Array

import java.util.Arrays;
import java.util.Scanner;

class Assg4Sol14
{
    
    static void findIndex(int[] arr, int target)
    {
        
        Arrays.sort(arr);

       
        int index = Arrays.binarySearch(arr, target);

        if (index >= 0)
        {
            System.out.println("The number " + target + " is found at index " + index);
        }
        else
        {
            System.out.println("Not Found");
        }
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

        System.out.print("Enter the number to search: ");
        int target = sc.nextInt();

       
        findIndex(numbers, target);
    }
}