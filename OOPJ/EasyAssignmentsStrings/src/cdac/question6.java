/*6. Write a Java program to convert all the characters in a string to uppercase. 
 Sample Output:
Original String: The Quick BroWn FoX!                                                                         
String in uppercase: THE QUICK BROWN FOX! 

*/

package cdac;

public class question6 {
	public static void main(String[]args) {
		String str= "The Quick BroWn FoX!";
		System.out.println("Original String : "+str);
		
		str= str.toUpperCase();
		System.out.println("String in uppercase : "+str);
		
	}

}
