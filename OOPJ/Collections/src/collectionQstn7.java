import java.util.ArrayList;
import java.util.Collections;

/*7. Modify the above Java program to sort a given array list. (Hint : Use the class Collections)
*/
public class collectionQstn7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("before sorting  : "+colours);
		Collections.sort(colours);
		System.out.println("after sorting : "+colours);
	}

}
