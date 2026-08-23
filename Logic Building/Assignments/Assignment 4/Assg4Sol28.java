// Question 28: String Creation with new Keyword

class Assg4Sol28
{
    public static void main(String[] args)
    {
        String str1 = new String("hello");
        String str2 = new String("hello");

        // Checks reference equality
        System.out.println("Using == : " + (str1 == str2));

        // Checks content equality
        System.out.println("Using .equals(): " + str1.equals(str2));
    }
}