/*
 * 3. Modify the exercise 2 and Write a Java program to sum values of an array
*/

package arrays;
import java.util.Scanner;


public class arrayqst3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }

        System.out.println("Sum of array elements = " + sum);

      
    }
}