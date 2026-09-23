import java.util.TreeSet;

/*14. Modify the above Java program to get the first and last elements in a tree set.  
*/
public class collectionQstn14 {

	public static void main(String[] args) {
		TreeSet<String> colours= new TreeSet<String>();
		
		colours.add("Red");
		colours.add("Yellow");
		colours.add("blue");
		colours.add("black");
		colours.add("black");
		
		System.out.println("TreeSet1 : "+colours);// TODO Auto-generated method stub
		System.out.println("TreeSet first element  : "+colours.first());
		System.out.println("TreeSet last element : "+colours.last());
	}

}
