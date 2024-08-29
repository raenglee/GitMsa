package org.example;

import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("aa","bb");
        Stream<String> stream2 = Stream.of("cc","dd");

        Stream.concat(stream1, stream2)
                .forEach(System.out::println);
    }
}
