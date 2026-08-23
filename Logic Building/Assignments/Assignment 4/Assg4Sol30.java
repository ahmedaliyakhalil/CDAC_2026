// Question 30: String Pool with intern() Method

class Assg4Sol30
{
    public static void main(String[] args)
    {
        // Creates a String object in Heap memory
        String str1 = new String("hello");

        // Moves/fetches the string reference from the String Constant Pool (SCP)
        String str2 = str1.intern();

        // Points directly to the literal in the String Constant Pool (SCP)
        String str3 = "hello";

        // Checks if str2 and str3 point to the exact same reference in SCP
        boolean isSame = (str2 == str3);

        System.out.println("Is str2 and str3 pointing to the same object? " + isSame);
    }
}