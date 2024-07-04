package ex06;


//int 는 변수. int ~ 변수명은 아무거나 가능 꼭 i가 아니어도 됨

public class Ex04 {
	public static void main(String[] args) {
		int k = 20;
		System.out.println("===프로그램 시작==="+k);
		hieveryone(12);
		hieveryone(13);
		System.out.println("===프로그램 끝===");
	}

	//crtl+1로 hieveryone 에서 자동완성함 직접쓰는 연습도 하기
	private static void hieveryone(int www) {
		System.out.println("여기온다"+www);

		if(www==12) {
			System.out.println("www = 12입니다");
		}
			for(int k =0; k<3;k++) {
				System.out.println("k="+k);
		}
	}
}