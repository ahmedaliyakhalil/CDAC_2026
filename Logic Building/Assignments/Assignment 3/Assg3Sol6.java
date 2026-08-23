// Problem 6: Calculate the Sum of Numbers from 1 to N (Using for Loop)


import java.util.Scanner;

class Sum{
	public static void calculateSum(int n){
		int sum=0;
		for(int i=1; i<=n; i++){
			sum= sum+i;
		}
		System.out.println("the sum of the numbers from 1 to "+n+" is: "+sum);
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter a number : ");
		int num = sc.nextInt();
		calculateSum(num);
		
	}



}