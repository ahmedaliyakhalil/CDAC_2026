//Question 1: Print Numbers from 1 to N


import java.util.Scanner;

class Assg4Sol1{
	static void printNumber(int n){
		for(int i=1; i<=n; i++){
			System.out.print(i+" ");
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number= ");
		int n = sc.nextInt();
		
		Assg4Sol1.printNumber(n);
	}
	
}