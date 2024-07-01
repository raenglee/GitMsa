package ex01;

public class Ex09 {

	public static void main(String[] args) {
		short num1 = 10;
		
		num1 = (short) (num1 + 87L);
		System.out.println(num1);
		
		num1 = 10;
		num1 += 87L;
		System.out.println(num1);
		
		int num2 = 3;
		
		num2 = (int) (num2*3.3);
		System.out.println(num2);
		num2 *=3.3;
		System.out.println(num2);
	}
}
