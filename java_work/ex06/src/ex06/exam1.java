package ex06;

//1. 1부터 20까지의 정수 중에서 2와 3의 배수가 아닌 수의 총합을 구하시오

public class exam1 {
	public static void main(String[] args) {
		int i = 1;
		int sum = 0;
		while (i < 20) {
			i++;
			if ((i % 2) > 0 && (i % 3) > 0) { //아니다 -> != -> i%2!=0 이라고 해도 됨
				System.out.println("2또는 3의 배수가 아닌 수 " + i);
				sum = sum+i; // sum에 i값을 더해서 넣을거란 의미
			}
		}
		System.out.println("총 합은 " + sum);
	}
}
