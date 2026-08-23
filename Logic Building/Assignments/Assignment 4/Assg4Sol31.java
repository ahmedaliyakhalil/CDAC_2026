// Question 31: Multiple String Literals with Same Content

class Assg4Sol31
{
    public static void main(String[] args)
    {
        // Declaring three string literals with identical content
        String str1 = "java";
        String str2 = "java";
        String str3 = "java";

        // Checking if all three variables refer to the exact same object in memory
        boolean allSame = (str1 == str2) && (str2 == str3);

        System.out.println("All strings point to the same object: " + allSame);
    }
}