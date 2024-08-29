package org.example;

import java.util.stream.Stream;

public class Ex06 {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6)
                .peek(System.out::println)
                .sorted((o1,o2) -> o2-o1)
                .forEach(System.out::println);

        int count = (int)Stream.of(10,20,5,8,9).count();
        System.out.println("count = " + count);

        Stream.of(10,20,5,8,9)
                .mapToInt(value -> Integer.valueOf(value))
                .max()
                .ifPresent(value -> System.out.println("max = " + value)); // 안에 값이 있으면 출력을 해달라는 문장
    }
}