// Question 2: Print Multiples of 3 between 1 and N


import java.util.Scanner;

class Assg4Sol2{
	static void printMultiplesOfThree(int n){
		for(int i=1; i<=n ; i++){
			if(i%3==0){
				System.out.print(i+" ");
			}
		}
	}
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number = ");
		int n = sc.nextInt();
		printMultiplesOfThree(n);
	}
	
	

}