import java.util.ArrayList;

/*5. Modify the above Java program to remove the third element from a array list.
*/
public class collectionQstn5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours : "+colours);
		colours.remove(3);
		System.out.println("colours after removing element 3 : "+colours);
		
		
	}

}
