import java.util.TreeSet;

/*15. Write a Java program to get the element in a tree set which is greater than or equal to the given element. (Hint : Use the ceiling method of the TreeSet)
*/
public class collectionQstn15 {

	public static void main(String[] args) {
		TreeSet<String> colours= new TreeSet<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		colours.add("black");
		
		System.out.println("TreeSet1 : "+colours);
		String element="blue";
		String result = colours.ceiling(element);
		System.out.println("element greater than or equal to  : "+element+": "+result);
	}

}
