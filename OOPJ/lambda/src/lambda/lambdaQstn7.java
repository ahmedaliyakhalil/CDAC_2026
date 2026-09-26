/*7. Lambda expression to evaluate if a number entered is a Prime number
*/
package lambda;

import java.util.Scanner;
import java.util.function.Predicate;

public class lambdaQstn7 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number : ");
		int number= sc.nextInt();
		
		Predicate<Integer> isPrime= n ->{
			if(n<2)
				return false;
			for(int i=2;i<n;i++) {
				if(n%i==0)
					return false;
			}
			return true;
		};
		if(isPrime.test(number))
			System.out.println(number +" is a prime number ");
		else
			System.out.println(number+" is not a prime number  ");
	}

}
