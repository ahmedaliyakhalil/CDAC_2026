/*5. Write a Java program to replace each substring of a given string that matches the given regular expression with the given replacement.  
Sample string : "The quick brown fox jumps over the lazy dog."
In the above string replace all the fox with cat.
Sample Output:
Original string: The quick brown fox jumps over the lazy dog.                                                 
New String: The quick brown cat jumps over the lazy dog.
*/

package cdac;

public class question5 {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps over the lazy dog. ";
		System.out.println("Original String : "+str);
		
		String str2 = str.replaceAll("fox", "cat");
		System.out.println("New String: "+str2);
	}


}
