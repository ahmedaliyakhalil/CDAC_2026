/* Question 18: Repeated Digits Grid

11111
22222
33333
44444
55555

*/

class Assg4Sol18
{
    static void printPattern()
    {
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 5; j++)
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