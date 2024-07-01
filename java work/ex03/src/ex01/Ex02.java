package ex01;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		// 숫자를 입력받아 두수 합을 구하시오
		int a;
		int b;
		
		// 무엇인가를 입력받아서 사용할때 쓰는 문법
		// ctrl + space 자동완성으로 도와주는게 많다.
		Scanner scan = new Scanner(System.in);
	    System.out.println("숫자 입력");
	    
	    // a변수에 숫자 입력 받아 넣는 구문
		a = scan.nextInt();
		System.out.println("a = "+a);
		
		b = scan.nextInt();
		System.out.println("b = " + b);
		
	}
}