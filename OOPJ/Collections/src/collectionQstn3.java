import java.util.ArrayList;

/*3. Modify the above Java program to retrieve an element (at a specified index) from a given array list.
*/
public class collectionQstn3 {

	public static void main(String[] args) {
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours : "+colours);
		String colour= colours.get(1);
		System.out.println("elemet at index 2 is  : "+colour);

	}

}
