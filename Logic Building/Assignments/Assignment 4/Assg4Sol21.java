/*Question 21: Floyd's Triangle

1
2 3
4 5 6
7 8 9 10
11 12 13 14 15

*/

class Assg4Sol21
{
    static void printPattern()
    {
        int count = 1;

        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printPattern();
    }
}

