import java.util.ArrayList;

/*2. Modify the above Java program to insert an element into the array list at the first position.
*/
public class collectionQst2 {

	public static void main(String[] args) {
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		System.out.println("colours : "+colours);
		colours.add(3,"pink");
		System.out.println("colours : "+colours);
		
		
		
	}

}
