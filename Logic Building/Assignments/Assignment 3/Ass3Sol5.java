// Problem 5: Print Multiplication Table (Using for Loop)
import java.util.Scanner;
class Table{
	public static void printMultiplicationTable(int num){
		for(int i=1; i<=10 ; i++){
			System.out.println(num+" x "+i+" = "+(num*i));
		}
		
	}
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		
		
		System.out.println("Enter a number = ");
		int num= sc.nextInt();
		printMultiplicationTable(num);
		
	}

}