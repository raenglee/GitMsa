package ex04;
//아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 456이라면 400이 되고 111이라면 100이 된다. (1)에 알맞은 코드를 넣으시오
public class Exec3_4 {
	public static void main(String[] args) {
		int num = 456;
		System.out.println(num/100*100);
		
	}
}
