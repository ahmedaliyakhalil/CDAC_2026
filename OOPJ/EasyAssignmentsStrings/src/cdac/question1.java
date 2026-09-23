/*1. Write a Java program to get the character at the given index within the String.  
Sample Output:
Original String = Java Exercises!                                                                             
The character at position 0 is J                                                                              
The character at position 10 is i
*/

package cdac;

public class question1 {
	public static void main(String [] args) {
		String str = "Java Exercises!";
		System.out.println("Original String = "+str);
		System.out.println("The character at position 0 is "+str.charAt(0));
		System.out.println("The character at position 10 is "+str.charAt(10));
	}

}
