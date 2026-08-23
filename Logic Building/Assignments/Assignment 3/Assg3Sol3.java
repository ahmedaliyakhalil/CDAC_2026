// Q3- print even numbers using loop 

class Numbers
{
	static void printEvenNumbers()
	{
		int num1 = 1;
		
		while(num1<=50)
		{
			if (num1%2==0)
			{
				System.out.print(num1+" " );
				
			}num1++;
			
			
		}		
	}
	public static void main(String args[])
	{
		Numbers.printEvenNumbers();
	}

}
