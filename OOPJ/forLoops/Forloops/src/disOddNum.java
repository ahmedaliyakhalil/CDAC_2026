/*1. Using for loops write a Java Program to display all odd 
numbers from 1 to 1000*/


public class disOddNum{
//simple for loop - method 1 
	public static void main(String[] args)
	{
		int num=0;
		for(num=0 ; num<=1000 ;num++){
			if(num % 2 != 0)
				System.out.println("Odd numbers from 1 to 1000 are : "+num);
		}
	}
}

	
/*	// storing the output in arr[] - method 2 
	public static void main(String[] args) {
		int num=0;
		for(num=0 ; num<=1000 ;num++){
			if(num % 2 != 0)
				System.out.println("Odd numbers from 1 to 1000 are : "+num);
		}
	}
}
*/