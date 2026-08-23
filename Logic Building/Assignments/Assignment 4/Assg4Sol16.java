/* Question 16: Sequential Multiplication Pattern

1
1*2
1*2*3
1*2*3*4
1*2*3*4*5

*/

class Assg4Sol16
{
    static void printPattern()
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j + (j < i ? "*" : ""));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printPattern();
    }
}