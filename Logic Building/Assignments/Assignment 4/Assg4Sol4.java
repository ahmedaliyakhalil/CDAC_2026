//Question 4: Print Even Numbers from 1 to N

import java.util.Scanner;


class Assg4Sol4{

    static void printEvenNumbers(int n)
    {
        for (int i = 1; i <= n; i++)
        {
            if (i % 2 == 0)
            {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        // Calling the static method
        printEvenNumbers(n);
    }
}

