/*9.  Modify exercise 2 Write a Java program to find the duplicate values of an array
*/

package arrays;

import java.util.Scanner;

public class arrayqst9 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Duplicate values are:");

        boolean duplicateFound = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    // Check whether the value was already displayed
                    boolean alreadyFound = false;

                    for (int k = 0; k < i; k++) {

                        if (arr[k] == arr[i]) {
                            alreadyFound = true;
                            break;
                        }
                    }

                    if (!alreadyFound) {
                        System.out.print(arr[i] + " ");
                        duplicateFound = true;
                    }

                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicate values.");
        }

        sc.close();
    }
}