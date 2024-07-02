package ex04;
//아래는 화씨(F)를 섭씨(C)로 변환하는 코드이다 변환공식이 'C = (F - 32) / 1.8' 라고 할때 (1)에 알맞은 코드를 넣으시오. 단, 변환 결과값은 소수점 셋째자리에서 버림해야 한다. (형변환 이용)
public class Exec3_7 {
	public static void main(String[] args) {
		int F = 100;
		float C = (float)((int)((float)((F-32)/1.8)*100))/100; 
		System.out.println("F = " + F);
		System.out.println("C = " + C);
	}

}
