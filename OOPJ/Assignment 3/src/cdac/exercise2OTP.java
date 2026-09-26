package cdac;
import java.util.Random;
import java.util.function.Supplier;

public class exercise2OTP
{
    public static void main(String[] args)
    {
        Random random = new Random();

        Supplier<String> otp = () ->
        {
            String vowels = "AEIOU";

            char firstChar = vowels.charAt(
                random.nextInt(vowels.length())
            );

            String result = "" + firstChar;

            for(int i = 1; i <= 4; i++)
            {
                result = result + random.nextInt(10);
            }

            return result;
        };

        System.out.println(otp.get());
    }
}