// Question 29: String Concatenation and Object Creation

class Assg4Sol29

{
    public static void main(String[] args)
    {
        String str1 = "hello";
        String str2 = "world";
        
        // String concatenation creates a new String object in Heap memory
        String str3 = str1 + str2;

        // Checking if str3 points to the exact same reference as str1
        boolean isSame = (str3 == str1);

        System.out.println("Is str3 pointing to the same object as str1? " + isSame);
    }
}