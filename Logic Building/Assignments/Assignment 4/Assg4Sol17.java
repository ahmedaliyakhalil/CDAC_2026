/* Question 17: Odd Number Multiplication Pattern


1
1*3
1*3*5
1*3*5*7
1*3*5*7*9

*/

class Assg4Sol17
{
    static void printPattern()
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                int oddNumber = 2 * j - 1; 
                System.out.print(oddNumber + (j < i ? "*" : ""));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printPattern();
    }
}