/*3. Write a Java program to check whether a given string ends with the contents of another string.  
Sample Output:
"Python Exercises" ends with "se"? false                                                                      
"Python Exercise" ends with "se"? true
*/

package cdac;

public class question3 {

	public static void main(String[] args) {
		String str1= "Python Exercises";
		String str2 = "se";
		System.out.println("\""+str1+" ends with "+"\""+str2+" ? "+str1.endsWith(str2));
		
		str1= "Python Exercise";
		System.out.println("\""+str1+" ends with "+"\""+str2+" ? "+str1.endsWith(str2));
	}

}
