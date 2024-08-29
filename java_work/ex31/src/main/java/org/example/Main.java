package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //List 1, 2, 3, 4, 5, 6, 7, 8, 9 생성 해서 스트림으로 만들어 가지고
        // 1. 그냥 출력
        // 2. 홀수, 짝수 sum 총합 출력하기

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        list.stream()
                .forEach(System.out::println);
        int result = list.stream()
                .mapToInt(value -> value)
                .sum();
        
        System.out.println("result = " + result);
        
        result = list.stream()
                .reduce(0,(a, b) -> a+b);  // a, b는 변수명, a에 0을 넣고 b엔 1이 들어감
        //return 생략되어있음 원래는 (0, (a,b) -> { return a+b });

        // a = 0, b = 1
        // a = 1(a+b), b = 2 (다음 숫자)
        // a = 3(a+b), b = 3 (다음 숫자)
        // a = 6(a+b), b = 4 (다음 숫자)
        // a = 10, b = 5

        System.out.println("result = " + result);

        //홀수 짝수만 하려면 중간연산 추가
        result = list.stream()
                .filter(integer -> integer%2 == 0)  // 중간 연산, 짝수 찾는 것
                .reduce(0,(a, b) -> a+b);

        System.out.println("result 짝수 합 = " + result);

        result = list.stream()
                .filter(integer -> integer%2 == 1)  // 중간 연산, 홀수 찾기
                .reduce(0,(a, b) -> a+b);

        System.out.println("result 홀수 합 = " + result);
    }
}