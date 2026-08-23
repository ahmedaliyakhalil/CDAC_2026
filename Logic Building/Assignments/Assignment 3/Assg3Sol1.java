// Q1 - Sum of two Numbers (using a method)

import java.util.Scanner;

class Sum
{
	static int num1;
	static int num2;
	
	static void sumOfTwoNumbers()
	{
		int result= num1 + num2;
		System.out.println("sum of "+num1+" + "+ num2+ " = "+result+".");
		
	}
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);

		System.out.println("Enter num1 : ");
		num1= sc.nextInt();
	

		System.out.println("Enter num2 : ");
		num2= sc.nextInt();
		
		sumOfTwoNumbers();
	}

}