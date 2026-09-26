/*4. Lambda expression to generate a 3 digit random number
*/
package lambda;

import java.util.Random;
import java.util.function.Supplier;

public class lambdaQstn4 {

	public static void main(String[] args) {
		Random random= new Random();
		Supplier<Integer> randomNumber=()-> 100+ random.nextInt(900);
        System.out.println("Random 3-digit number: " + randomNumber.get());
	}

}
