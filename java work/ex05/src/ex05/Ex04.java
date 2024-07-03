package ex05;

import javax.annotation.processing.SupportedSourceVersion;

public class Ex04 {
	public static void main(String[] args) {

		/*
		 * i == 0 일때 행해라
		 * i == 1 일때 행해라
		 * i == 2 일때 행해라
		 * i == 3 일때 행해라
		 * i == 4 일때 행해라
		 */
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("I love JAVA " + i);
//		}

		int i = 0;
		for (; i < 5; i+=2) {
			System.out.println("I love JAVA " + i);
		}
	//for 다음 i+=2 없으면 무한으로 재생됨 필요함
		System.out.println(i);

	}
}
