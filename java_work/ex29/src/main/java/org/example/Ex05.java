package org.example;

import java.util.Arrays;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("AA", "CCCC", "BBB", "DDDDD");

        String result = list.stream()
                .reduce("EEEEEE",
                        (a, b) -> {
                            if (a.length() > b.length()) return a;
                            else return b;
                        }
                );

        System.out.println(result);

        /*
       1. 생성
       2. 중간연산
           map, filter, sorted
       3. sum, foreach, reduce
        */


        //문자열 나열해서 출력
        result = list.stream().sorted((s1, s2)->s1.length()-s2.length()).reduce("", (a, b) -> a + b);
        System.out.println(result);
    }
}