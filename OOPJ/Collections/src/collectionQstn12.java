import java.util.TreeSet;

/*12. Modify the above Java program to add all the elements of a specified tree set to another tree set.  
*/
public class collectionQstn12 {

	public static void main(String[] args) {
		TreeSet<String> colours= new TreeSet<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		colours.add("black");
		
		System.out.println("TreeSet1 : "+colours);
		TreeSet<String> colours2= new TreeSet<String>();
		
		colours2.add("pink");
		colours2.add("violet");
		System.out.println("TreeSet 2 : "+colours2);
		
		colours2.addAll(colours);
		System.out.println("final TreeSet : "+colours2);

	}

}
