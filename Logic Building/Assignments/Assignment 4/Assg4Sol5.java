// Question 5: Sum of Odd Numbers between 1 and N

import java.util.Scanner;

class Assg4Sol5{
	
	static void calculateSumOfOddNumbers(int n){
		int sum = 0;
		for(int i=1; i<=n; i++){
			if (i %2 != 0 ){
				sum = sum +i;
			}
		}
		System.out.print("The sum of odd numbers from 1 to " + n + " is: " + sum);
	}
	public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        
        calculateSumOfOddNumbers(n);
    } 

}