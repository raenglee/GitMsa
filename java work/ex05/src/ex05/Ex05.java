package ex05;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n = 0;

		//while(true) - 무한루프
		while(true) {
			n++;
			System.out.println("n="+n);
			if(n==3)
				//break;
				continue;
			
			int temp = scan.nextInt();
			System.out.println("temp = "+temp);
			
		}
		//System.out.println("종료됩니다"); //컨티뉴 사용시 도달할수없어서 에러남, 브레이크 사용시 가능
		//컨티뉴를 만나면 그다음 구문 행하지않고 조건으로 이동
	}
}
