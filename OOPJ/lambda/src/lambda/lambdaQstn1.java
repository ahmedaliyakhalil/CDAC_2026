/* Using existing (pre-defined) Functional Interfaces in Java write,

1. Lambda expression to sort a string array in alphabetical order
*/
package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class lambdaQstn1 {

	public static void main(String[] args) {
		String[] names= {"Ravi", "Aliya","Abhay","Aditya","Aditi"};
		Comparator<String> sort= (a,b)->a.compareTo(b);
		
		Arrays.sort(names,sort);
		System.out.println(Arrays.toString(names));

	}

}
