// Question 27: String Literal and Object Creation


class Assg4Sol27
{
    public static void main(String[] args)
    {
        String str1 = "hello";
        String str2 = "hello";

       
        boolean isSame = (str1 == str2);

        System.out.println("Both variables point to the same object: " + isSame);
    }
}