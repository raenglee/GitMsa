package ex01;

public class Ex12 {

	public static void main(String[] args) {
		int a = 10;
		int b = 10;
		
		boolean result;
		result = ((a+=10)<0) && ((b+=10)>0);
		System.out.println(result);
		System.out.println(a);
		System.out.println(b);
		
		result = ((a+=10)<0) || ((b+=10)>0);
		System.out.println(result);
		System.out.println(a);
		System.out.println(b);
	}
}
