

/*7.Modify exercise 2 Write a Java program to reverse an array of integer values
*/

package arrays;

import java.util.Scanner;

public class arrayqst7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] reverse = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int j = 0;

        for (int i = n - 1; i >= 0; i--) {
            reverse[j] = arr[i];
            j++;
        }

        System.out.println("Original array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        System.out.println("Reversed array:");
        for (int i = 0; i < n; i++) {
            System.out.print(reverse[i] + " ");
        }

        sc.close();
    }
}
