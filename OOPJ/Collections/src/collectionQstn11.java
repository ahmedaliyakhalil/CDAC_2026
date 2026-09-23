
import java.util.TreeSet;

/*11. Write a Java program to create a new tree set, add some colors (string) and print out the tree set. 
*/
public class collectionQstn11 {

	public static void main(String[] args) {
		TreeSet<String> colours= new TreeSet<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		colours.add("black");
		
		System.out.println("TreeSet : "+colours);

	}

}
