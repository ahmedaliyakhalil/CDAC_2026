// Question 13: Check if an Array Contains a Specific Element

import java.util.Scanner;

class Assg4Sol13
{
   
    static void searchElement(int[] arr, int target)
    {
        boolean found = false;

        for (int num : arr) 
        {
            if (num == target)
            {
                found = true;
                break; 
            }
        }

        if (found)
        {
            System.out.println("Found");
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

        
        searchElement(numbers, target);
    }
}