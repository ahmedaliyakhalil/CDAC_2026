/*4. Write a Java program to get the index of all the characters of the alphabet.  
Sample Output:
a  b c  d e  f  g h i  j                                                                                     
=========================                                                                                     
36 10 7 40 2 16 42 1 6 20                                                                                     
                                                                                                   
k  l  m  n  o  p q  r  s  t                                                                                   
===========================                                                                                   
8 35 22 14 12 23 4 11 24 31                                                                                   

u  v  w  x  y  z                                                                                              
================                                                                                              
5 27 13 18 38 37
Sample string of all alphabet: "The quick brown fox jumps over the lazy dog."
*/

package cdac;

public class question4 {

	public static void main(String[] args) {
		String str= "The quick brown fox jumps over the lazy dog.";
		
		for(char ch='a';ch<='j';ch++){
			System.out.print(ch+" ");
		}
		//System.out.println("\n");
		System.out.println("\n========================= ");
		for(char ch='a';ch<='j'; ch++) {
			System.out.print(str.indexOf(ch)+" ");
		}
		System.out.println("\n");
		for(char ch='k';ch<='t';ch++){
			System.out.print(ch+" ");
		}

		System.out.println("\n========================= ");
		for(char ch='k';ch<='t'; ch++) {
			System.out.print(str.indexOf(ch)+" ");
		}
		System.out.println("\n");

		//System.out.println("\n========================= ");
		
		for(char ch='u';ch<='z';ch++){
			System.out.print(ch+" ");
		}
		System.out.println("\n========================= ");
		for(char ch='u';ch<='z'; ch++) {
			System.out.print(str.indexOf(ch)+" ");
			
		}
	}

}
