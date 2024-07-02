package ex04;

import java.util.Scanner;

public class Ex06 {
	
	// 숫자를 입력받아
	// 10 미만이면 10미만 출력
	// 10 이상이고 20이하이면 10이상20이하 출력
	// 10 <= num1 && num1 <=20
	// 20초과 이면 20초과 출력
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자 입력");
		int num1 = scan.nextInt();
		
		System.out.println(num1);
		
		if(num1 < 10) {
			System.out.println("10 미만 입니다.");
		} else if(10 <= num1 && num1 <= 20) {
			System.out.println("10이상이고 20이하입니다.");
		} else {
			System.out.println("20초과");
		}
			
	}
}
