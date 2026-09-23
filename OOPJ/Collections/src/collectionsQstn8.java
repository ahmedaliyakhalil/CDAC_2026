import java.util.ArrayList;

import java.util.Collections;

/*8. Modify the above Java program to copy one array list into another. (Hint : Use the class Collections)
*/
public class collectionsQstn8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> colours= new ArrayList<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		
		System.out.println("colours : "+colours);
		
		ArrayList<String> newColours= new  ArrayList<String>();
		
		newColours.add("");
		newColours.add("");
		newColours.add("");
		newColours.add("");
		System.out.println("before copying  : "+newColours);
		Collections.copy(newColours, colours);
		System.out.println("After copying  : "+newColours);
	}

}
