package ex06;

public class Ex08 {
	public static void main(String[] args) {
		int result = doA(3);
		String temp = doB("안녕하세요");
		System.out.println(result);
		System.out.println(temp);
//위아래 똑같음
		System.out.println(doA(3));
		System.out.println(doB("안녕하세요"));
	
	}
	
	
	public static int doA(int num) {
		return num*num;
	}
	
	public static String doB(String str) {
		return str + str;
	}

}
