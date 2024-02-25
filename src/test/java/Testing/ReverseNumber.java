package Testing;

public class ReverseNumber {
	
	public static void main(String[] args)   
	
	{	
	int number = 34768, reverse = 0;
	while(number!=0){
		int reminder = number%10;
		reverse = reverse*10 + reminder;
		number = number/10;
	}
	
	
	
	System.out.println("ReverseNumber of given number is " + reverse);
	
	}

}
