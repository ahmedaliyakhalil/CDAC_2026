// Question 8: Print All Names in a String Array

import java.util.Scanner;

class Assg4Sol8
{
    
    static void printNames(String[] names)
    {
        for (String name : names) 
        {
            System.out.println(name);
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] names = new String[5]; 

        System.out.print("Enter 5 names: ");
        for (int i = 0; i < 5; i++)
        {
            names[i] = sc.next();
        }

        
        printNames(names);
    }
}