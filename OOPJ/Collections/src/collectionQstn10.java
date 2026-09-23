import java.util.ArrayList;
import java.util.Collections;

/*10. Modify the above Java program to reverse elements in a array list. (Hint : Use the class Collections)
*/
public class collectionQstn10 {

	public static void main(String[] args) {
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("original colours : "+colours);
		Collections.reverse(colours);
		System.out.println("reverse colours list : "+colours);
		

	}

}
