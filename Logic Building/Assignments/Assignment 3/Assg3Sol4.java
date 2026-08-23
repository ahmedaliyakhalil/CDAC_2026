//Problem 4: User Input for Positive Numbers (Using do-while Loop)

import java.util.Scanner;

class PositiveNum{
	public static void askForPositiveNumber(){
		int num;
		Scanner sc = new Scanner(System.in);
		
		do{
			System.out.print("Enter a positive number: ");
			num = sc.nextInt();
		}
		while(num<=0);
		System.out.print("You entered a positive number: "+num);
		
	}
	
	public static void main(String[] args){
		
		PositiveNum.askForPositiveNumber();
		
		
		
		
		
	}
	


}