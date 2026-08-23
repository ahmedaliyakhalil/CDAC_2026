/* Question 20: Number Triangle Pattern

1
12
123
1234
12345

*/

class Assg4Sol20
{
    
    static void printPattern()
    {

        for (int i = 1; i <= 5; i++)
        {
           
            for (int j = 1; j <= i; j++)
            {
                System.out.print(j);
            }
            System.out.println(); 
        }
    }

    public static void main(String[] args)
    {
        
        printPattern();
    }
}