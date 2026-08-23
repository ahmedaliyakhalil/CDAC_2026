/* Question 19: Increasing Repeated Digits Pyramid


1
22
333
4444
55555

*/

class Assg4Sol19
{
    static void printPattern()
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printPattern();
    }
}