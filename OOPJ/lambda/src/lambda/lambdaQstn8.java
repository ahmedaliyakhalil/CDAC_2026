/*8. Lambda expression to accept 2 strings and return the concatenated value of the same
*/
package lambda;

import java.util.Scanner;
import java.util.function.BiFunction;

public class lambdaQstn8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first string: ");
		String str1 = sc.nextLine();
		
		System.out.println("Enter the second string: ");
		String str2 = sc.nextLine();
		
		
		BiFunction<String,String,String> concatenate = (a,b) ->a+b;
		
		String result= concatenate.apply(str1, str2);
		System.out.println(" Concatenated string: "+result);
		
	}

}
