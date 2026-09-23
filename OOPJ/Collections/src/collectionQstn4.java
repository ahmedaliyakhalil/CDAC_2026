import java.util.ArrayList;

/*4. Modify the above Java program to update specific array element by given element.
*/
public class collectionQstn4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours : "+colours);
		colours.set(3,"violet");
		System.out.println("the element updated on index 3 is : "+colours);
		
	}

}
