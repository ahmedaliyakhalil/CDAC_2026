/* Question 24: Reverse a String */ 

import java.util.Scanner;

class Assg4Sol24
{
    static void reverseString(String str)
    {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--)
        {
            reversed = reversed + str.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        reverseString(str);
    }
}