package ex01;

public class Ex11 {

	public static void main(String[] args) {
		
		int num1 = 11;
		int num2 = 22;	
		boolean result;
		
		result = 3 <= num1 && num1 <= 100;
		
		System.out.println(result);
		
		result = num1%3==0;
		System.out.println(result);
		
		result = num1%2==0;
		System.out.println(result);
		
		result = ((num1 % 3 == 0) && (num1 % 2 == 0)) || (num2 % 2) == 0;
		System.out.println(result);
	}
}
