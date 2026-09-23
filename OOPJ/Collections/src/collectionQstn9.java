import java.util.ArrayList;
import java.util.Collections;

/*9. Modify the above Java program to shuffle elements in a array list. (Hint : Use the class Collections)
*/
public class collectionQstn9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours before shuffle : "+colours);
		Collections.shuffle(colours);
		System.out.println("colours after shuffle : "+colours);

		
	}

}
