/*5. Lambda expression that takes an integer array and returns the reverse integer array
*/

package lambda;

import java.util.Arrays;
import java.util.function.Function;

public class lambdaQstn5 {

	public static void main(String[] args) {
		int[] numbers= {10,20,30,40,50};
		Function<int[], int[]> reverse= arr->{
			int[]result= new int[arr.length];
			for(int i=0; i<arr.length;i++) {
				result[i]=arr[arr.length-1-i];
				
			}
			return result;
		};
		System.out.println("Original array: " + Arrays.toString(numbers));
		int[]reversed= reverse.apply(numbers);
		System.out.println("reversed array: " + Arrays.toString(reversed));
	}

}
