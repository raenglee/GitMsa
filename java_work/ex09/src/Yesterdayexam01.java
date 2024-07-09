
/*
2*2*2*...
 */

import aa.bb.Fact;

import java.util.Scanner;

public class Yesterdayexam01 {
    public static void main(String[] args) {
        // 입력 받는 변수 선언
        Scanner scanner;
        scanner = new Scanner(System.in);
        Fact fact1;
        fact1 = new Fact();

        System.out.println("숫자 입력");
        int result = scanner.nextInt();

        int retValue = fact1.aa(result);

        System.out.println("result = " + result);
        System.out.println("retValue = " + retValue);
    }
}

