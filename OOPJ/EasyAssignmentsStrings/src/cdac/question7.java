/*7. Write a Java program to reverse a string.
Sample Output:
The given string is: The quick brown fox jumps
The string in reverse order is:
spmuj xof nworb kciuq ehT

*/

package cdac;

public class question7 {
	public static void main(String[] args) {
		String str= "The quick brown fox jumps";
		System.out.println("The given string is: "+str);
		System.out.println("The string in reverse order is: "+str);
		for(int i = str.length()-1; i>=0;i--) {
			System.out.print(" "+str.charAt(i));
		}
		

	
	}

}
