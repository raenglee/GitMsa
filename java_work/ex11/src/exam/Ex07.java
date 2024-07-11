/*
1. 길이가 10인 배열을 선언하고 총 10개의 정수를 입력받아서,
홀수와 짝수를 구분 지어 출력하는 프로그램을 작성해 보자.
일단 홀수부터 출력하고 나서 짝수를 출력하도록 하자.
단, 10개의 정수는 main 함수 내에서 입력받도록 하고,
배열 내에 존재하는 홀수만 출력하는 함수와 배열 내에 존재하는 짝수만 출력하는 함수를 각각 정의해서
 이 두 함수를 호출하는 방식으로 프로그램을 완성하자.
 */
package exam;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        int a[] = new int[10];

        Scanner scanner = new Scanner(System.in);
        System.out.println("정수를 입력하시오.");
        int num = scanner.nextInt();

        for (int i = 1; i < a.length; i++) {
            int sum = num%2;
            if (sum != 0) {
                System.out.println(num+"은"+" 홀수입니다.");
            } else {
                System.out.println(num+"은"+" 짝수입니다.");
            }
        }
    }
}