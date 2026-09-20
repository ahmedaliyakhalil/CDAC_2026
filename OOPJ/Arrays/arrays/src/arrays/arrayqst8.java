/*8.Modify exercise 2 Write a Java program to find the duplicate values of an array of integer values
*/

package arrays;

import java.util.Scanner;

public class arrayqst8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Duplicate values:");

        boolean found = false;

        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {

                    // Check if this duplicate was already printed
                    boolean alreadyPrinted = false;

                    for (int k = 0; k < i; k++) {
                        if (arr[k] == arr[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }

                    if (!alreadyPrinted) {
                        System.out.print(arr[i] + " ");
                        found = true;
                    }

                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No duplicate values found.");
        }

        sc.close();
    }
}
