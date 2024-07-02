package ex04;

public class Ex03 {
	public static void main(String[] args) {
		int num1 = 10;
		
		/*
		 * 브레이크포인트... 더블클릭
		 * 벌레모양 디버그 실행
		 * F6 - 한줄씩 진행
		 * F8 - 종료
		 */
		
		// ++가 뒤 = 출력후 1증가하고 대입, ++가 앞 = 1증가 후 대입하고 출력
		//num++, num = num+1, num += 1 다 같은 표현
		
		System.out.println(num1++);
		System.out.println(++num1);
		
		System.out.println(num1);
		
		
		// home 그 줄에서 제일 앞, end 그 줄에서 제일 뒤
		// ctrl + d 한줄 삭제
		
		System.out.println(num1--);
		System.out.println(--num1);
		
		System.out.println(num1);
	
		//for (int i = 0; i < 10; i++)
		//for (int i = 0; i < 10; i=i+1)
		//for (int i = 0; i < 10; i=i+3) 3씩증가
		
		for (int i = 0; i < 10; i+=1) {
		System.out.println(i);
		System.out.println("hhh");
		System.out.println(i+i);
		}
	}
}
