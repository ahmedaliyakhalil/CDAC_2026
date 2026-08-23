import java.util.Scanner;

class checkAge
{
	
	public static void checkAgeCategory(int a)
	{
		if(a<18){
			System.out.println("Your are a minor");
		}
		else if(a>=18 && a<=60 ){
			System.out.println("Your are an adult");
		}
		else{
			System.out.println("Your are a senior citizen");
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your age = ");
		int age = sc.nextInt();
		
		checkAge.checkAgeCategory(age);
	}
	
	

}