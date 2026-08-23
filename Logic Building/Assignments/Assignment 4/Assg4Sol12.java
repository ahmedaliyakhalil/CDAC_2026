//Question 12: Sort an Array in Ascending Order

import java.util.Arrays;
import java.util.Scanner;

class Assg4Sol12
{
    
    static void sortAndPrintArray(int[] arr)
    {

        Arrays.sort(arr);

        System.out.print("Sorted array: ");
        for (int num : arr) 
        {
            System.out.print(num + " ");
        }
        System.out.println();
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

       
        sortAndPrintArray(numbers);
    }
}