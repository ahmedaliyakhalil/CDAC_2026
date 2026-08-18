class Sol1
{
	public static void main(String[]args)
	{
		int maths=80;
		int sci= 85;
		int hist= 90;
		
		int avg = (maths +sci+hist)/3;
		
		if(avg>=90){
			System.out.println("Grade A");
		}else if (avg >=70 && avg<=89)
		{
			System.out.println("Grade B");
		}else if(avg >= 50 && avg<= 69){
			System.out.println("Grade C");
		}else if(avg >=30 && avg<=49){
			System.out.println("Grade D");
		}
		else{
			System.out.println("fail");
		}
		
		System.out.println(avg);
		
	}
}