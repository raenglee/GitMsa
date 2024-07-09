/*
1. 2의 n승을 구하는 함수를 재귀적으로 구현해 보자.
그리고 그에 따른 적절한 함수를 구현해 보자.
참고로 재귀 함수의 구현이 처음에는 어려운 편이기 때문에 여기서는 쉬운 문제를 제시하였다
*/

//문제 풀이 ex09에!

import java.util.Scanner;

public class Ex06exam1 {

    public static int fact(int num) {

        if (num == 2) {
            return num * fact(+ 2);
        } else {
            return 1;
        }
    }
    public static void main(String[] args) {
        int result = fact(2);
        System.out.println(result);
    }
}