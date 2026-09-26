/*2. Lambda expression to find the largest number in an integer array.
*/
package lambda;

import java.util.Arrays;
import java.util.function.Function;

public class lambdaQst2 {

	public static void main(String[] args) {
		int[] numbers= {10,26,98,55,25};
		Function<int[], Integer> largest= arr->{
			int max = arr[0];
			for(int i=1; i<arr.length;i++) {
				if(arr[i]>max) {
					max= arr[i];	
				}
			}
			return max;
		};
		System.out.println("array :  " +Arrays.toString(numbers));
		System.out.println("Largest: " + largest.apply(numbers));
	}

}
