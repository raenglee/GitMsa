package ex06;

public class Ex05 {
	
	//보냈는 구구단 호출 하는 매서드 => 2 3
	public static void aa(int dan) {
		System.out.println("aa");
		for (int i = 1; i<10; i++) // 구구단 출력문 i는 1부터해서 10보다 작은것 = 1~9까지 구구단
			System.out.println(dan*i);
	}
	

	//두 수를 받아서 최소 공배수 출력하는 매서드
	//num1로 나누었을때 나머지가 0 그리고 num2로 나누었을때 나머지가 0 -> 이걸 if구문으로 적는것(20.단락 그대로 적은것)
	public static void bb(int num1, int num2) {
		System.out.println("bb");
		int num = 0;
		while(num<50) {
			num++;
			if(num%num1==0 && num%num2==0) {
			System.out.println("최소공배수는 = " + num);
			break;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		aa(7);
		bb(3, 5);
		System.out.println("프로그램 끝");
		
//		System.out.println(num1);  <- 불가능, 이유->41.단락
	}
}


//메인함수를 제일 먼저 시작하니까 aa();를 만나면 public 으로 올라가서 출력하고 다시 내려와서 bb를 만나면 올라가 bb를 출력하고 내려옴
//public static void __ () 는 __를 호출하는 것  ? . . . void는 값을 반환하지 않는것  int는 값을 반환하는것을 명령한다고함 ...
//변수 한개당 int 한개씩 써야함
// int dan과 int num1,2는 void aa,bb의 중괄호 안에서만 쓸수있으므로 메인으로 나와서 쓸수없음