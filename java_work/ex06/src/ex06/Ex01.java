package ex06;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int year = sc.nextInt(); //넥스트인트는 숫자를 받는것
		
		String age_type = sc.next(); //넥스트는 문자열을 받는것
		int answer = 0;
		
		// a == 10 숫자 비교
		// a.equals("10") 문자열 비교
		
		    if (age_type.equals("KOREA")) {
		    	answer = 2030-year+1;
		    }
		    else if (age_type.equals("Year")){
		    	     answer = 2030-year;
		    }
		    
		    // 연도 넣고, KOREA입력 혹은 Year 입력시 나이가 나오게 된다. 문자열 비교!
		    
		System.out.println("age_type = " + age_type);
		System.out.println("answer = " + answer);
		System.out.println("year = " + year);
		}
	}
