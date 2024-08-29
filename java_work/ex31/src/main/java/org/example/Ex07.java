package org.example;

import java.util.stream.Stream;

public class Ex07 {
    public static void main(String[] args) {

        //모든 값이 짝수인지 확인
        boolean b = Stream.of(1, 2, 3, 4, 5, 6)
                .allMatch(integer -> integer % 2 == 0);  // 논매치 => 짝수가 아닌지~
        System.out.println("b = " + b);
    }
}
