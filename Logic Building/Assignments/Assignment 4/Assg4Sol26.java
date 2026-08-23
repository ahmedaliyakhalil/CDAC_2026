// Question 26: Check if a String is a Palindrome

import java.util.Scanner;

class Assg4Sol26
{
    static void checkPalindrome(String str)
    {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--)
        {
            reversed = reversed + str.charAt(i);
        }

        if (str.equalsIgnoreCase(reversed))
        {
            System.out.println("The string '" + str + "' is a palindrome.");
        }
        else
        {
            System.out.println("The string '" + str + "' is not a palindrome.");
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        checkPalindrome(str);
    }
}