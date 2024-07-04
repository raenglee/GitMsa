package ex06;

public class Ex02 {
	public static void main(String[] args) {
/*
 * i = 0 일때 j는 0~2까지 반복해라
 * i = 1 일때 j는 0~2까지 반복해라
 * i = 2 일때 j는 0~2까지 반복해라 
 */
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println("i = " + i +" j= "+j);
			}
		}
		
//		System.out.println("j = "+j); j는 중괄호로 묶여있어서 결과값이 나오지X i도 마찬가지
	}
}
