// Question 25: Count Vowels in a String

import java.util.Scanner;

class Assg4Sol25
{
    static void countVowels(String str)
    {
        int count = 0;
        String lowerStr = str.toLowerCase();

        for (int i = 0; i < lowerStr.length(); i++)
        {
            char ch = lowerStr.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                count++;
            }
        }

        System.out.println("The number of vowels in '" + str + "' is: " + count);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        countVowels(str);
    }
}