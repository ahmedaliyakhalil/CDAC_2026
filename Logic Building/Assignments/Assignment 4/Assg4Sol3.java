// Question 3: Calculate the Factorial of a Number

import java.util.Scanner;

class Assg4Sol3{
	static void CalculateFactorial(int n){
		long fac =1;
		for(int i=1; i<=n ; i++){
			
			fac = fac * i;
		}
		System.out.print("Factorail of "+n+" is : "+fac);
	}
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n= sc.nextInt();
		
		Assg4Sol3.CalculateFactorial(n);
	}
	
	
}