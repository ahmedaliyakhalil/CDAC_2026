/*10. Modify exercise 2 to accept 2 different values in 2 different arrays and  find the common elements 
between two array*/

package arrays;

import java.util.Scanner;

public class arrayqst10 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First array
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] arr1 = new int[n1];

        System.out.println("Enter elements of first array:");

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Second array
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] arr2 = new int[n2];

        System.out.println("Enter elements of second array:");

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Common elements:");

        boolean found = false;

        for (int i = 0; i < n1; i++) {

            for (int j = 0; j < n2; j++) {

                if (arr1[i] == arr2[j]) {

                    System.out.print(arr1[i] + " ");
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No common elements.");
        }

    }
}