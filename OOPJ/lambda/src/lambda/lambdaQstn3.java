/*3. Lambda expression to find the smallest number in an integer array.
*/
package lambda;

import java.util.Arrays;
import java.util.function.Function;

public class lambdaQstn3 {

	public static void main(String[] args) {
		int[] numbers= {10,26,98,55,25};
		Function<int[],Integer> smallest=arr->{
			int min=arr[0];
			for(int i=1;i<arr.length;i++) {
				if(arr[i]<min) {
					min=arr[i];	
				}
			}
			return min;
			
		};
		System.out.println("array :  " +Arrays.toString(numbers));
		System.out.println("Smallest: " + smallest.apply(numbers));

	}

}
