package ex05;

public class Ex06 {
	public static void main(String[] args) {
		// 3, 4의 최소공배수(3과 4로 나누었을때 0으로 떨어지는것)

		// break -> switch, while, for 구문 탈출

		for (int num = 1; num < 100; num++) {

			if (num % 3 == 0 && num % 4 == 0) {
				System.out.println("num = " + num);
				break; // 최소 하나만 나오게하려면 필요
			}
		}
	}
}
