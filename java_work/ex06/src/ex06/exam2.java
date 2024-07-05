package ex06;

// 2. 1+(1+2)+(1+2+3+)+(1+2+3+4)...+(1+2+3+4+...+10)의 결과를 계산하시오
// i가 0일때 j가 1번, i가 1일때 j가 2번 i가 2일때 j가 3번... i가 9일때 j가 10번
public class exam2 {
	public static void main(String[] args) {
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "");
			for (int j = 1; j < 11; j++) {

				//				System.out.println(i + "+" + ++i + "+" + j);
			}
		}
	}
}