/* Question 22: Hollow Rectangle Star Pattern


*******
*     *
*     *
*     *
*******

*/

class Assg4Sol22
{
    static void printPattern()
    {
        int rows = 5;
        int cols = 7;

        for (int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= cols; j++)
            {
                
                if (i == 1 || i == rows || j == 1 || j == cols)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        printPattern();
    }
}