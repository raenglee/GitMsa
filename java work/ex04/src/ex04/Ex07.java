package ex04;

public class Ex07 {
	
	public static void main(String[] args) {

		// 주석설정 및 해제 ctrl+/ , ctrl+shift+c
	
		// 삼항연산자
		
//		int a = 10;
//		int b = 20;
//		String result = a > b?"a는 b보다 큽니다.":"a는 b보다 작습니다.";
//		
//		System.out.println(result);

		
		//if
		
		int a = 10;
		int b = 20;
		String result = "";
		
		if(a > b) {
			result = "a는 b보다 큽니다";
		} else {
			result = "a는 b보다 작습니다";
		}
		
		System.out.println(result);
	}
}
