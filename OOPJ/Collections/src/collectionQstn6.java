import java.util.ArrayList;

/*6. Modify the above Java program to search an element in a array list
*/
public class collectionQstn6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours : "+colours);
		String search = "blue";
		if(colours.contains(search))
			System.out.println(search+ " is present in the ArrayList");
		else
			System.out.println(search+ " is not present in the ArrayList");
		
		
	}

}
