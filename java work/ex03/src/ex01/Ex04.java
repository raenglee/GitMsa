package ex01;

public class Ex04 {
	
	public static void main(String[] args) {
		// 강제 형변환
		// int = 4byte, short = 2byte
		// 8bit = 1byte
		// 4byte = 2byte
		int num1 = 523443;
		
		// short 32000 이상 -> 데이터소실 있을때 적는거
		short num2 = (short) num1;
		
		// 자동 형변환
		// 반대 -> 자동형변환 데이터소실X 안적어도
		short num3 = 20;
		int num4 = num3;
			}
}
