// Question 9: Find the Largest Element in an Array


import java.util.Scanner;

class Assg4Sol9
{
   
    public static void findLargestElement(int[] arr)
    {
       
        int max = arr[0];

        for (int num : arr) 
        {
            if (num > max) 
            {
                max = num;
            }
        }

        System.out.println("The largest element is: " + max);
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

       
        findLargestElement(numbers);
    }
}