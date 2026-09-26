/*6. Lambda expression to print the current date
*/

package lambda;

import java.time.LocalDate;
import java.util.function.Supplier;

public class lambdaQstn6 {

	public static void main(String[] args) {
		Supplier<LocalDate> currentDate =()->LocalDate.now();
		System.out.println("Current Date: "+currentDate.get());

	}

}
