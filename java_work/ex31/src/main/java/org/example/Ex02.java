package org.example;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        IntStream.of(11, 22, 33, 44)
                .forEach(s -> System.out.println());

        System.out.println();

        IntStream.range(5, 10)
                .forEach(System.out::println);

        System.out.println();

        IntStream.rangeClosed(5, 10)
                .forEach(System.out::println);
    }
}
