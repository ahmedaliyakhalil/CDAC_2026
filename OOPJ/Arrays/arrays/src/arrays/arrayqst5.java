/*5.Modify exercise 2 Write a Java program to copy an array by itera ng the array
*/
package arrays;

import java.util.Scanner;

public class arrayqst5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] copy = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Copying elements one by one
        for (int i = 0; i < n; i++) {
            copy[i] = arr[i];
        }

        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Copied array:");
        for (int i = 0; i < n; i++) {
            System.out.print(copy[i] + " ");
        }

    }
}