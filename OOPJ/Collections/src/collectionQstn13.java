import java.util.TreeSet;

/*13. Modify the above Java program to create a reverse order view of the elements contained in a given tree set.
*/
public class collectionQstn13 {

	public static void main(String[] args) {
		TreeSet<String> colours= new TreeSet<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		colours.add("black");
		
		System.out.println("TreeSet1 : "+colours);// TODO Auto-generated method stub
		TreeSet<String> reverseColours=(TreeSet<String>) colours.descendingSet();
		System.out.println("Reverse TreeSet  : "+reverseColours);
	}

}
