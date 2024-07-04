package ex06;

public class Ex06 {
	public static double aa() {
		System.out.println("aa");
		return 10; //10이 아래  int a = aa에 넣음 return 인데 void면 리턴이 안됨 int여야함.
	}
	
	public static void main(String[] args) {
	aa();
	int a = (int) aa();
	System.out.println(a);
	
	
	}
}

//더블로 하고싶으면 형변환 필수