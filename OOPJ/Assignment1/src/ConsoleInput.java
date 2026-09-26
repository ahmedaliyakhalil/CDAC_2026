import java.io.*;

public class ConsoleInput
{
    static BufferedReader br =
        new BufferedReader(new InputStreamReader(System.in));

    public static int getInt()
    {
        try
        {
            return Integer.parseInt(br.readLine());
        }
        catch(Exception e)
        {
            return 0;
        }
    }
}