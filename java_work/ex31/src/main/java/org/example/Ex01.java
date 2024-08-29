package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex01 {
    public static void main(String[] args) {
        Stream.of(11, 22, 33, 44, 55)
                .forEach(System.out::println);

        Stream.of("So simple", "So So", "11,22,33")
                .forEach(System.out::println);

        List<String> list1 = Arrays.asList("11", "22", "33", "44");
        List<String> list2 = Arrays.asList("11", "22", "33", "44");

        Stream.of(list1, list2)
                .forEach(System.out::println);

        Stream.of(list1, list2)
                .flatMapToInt( strings ->  // flatMapToInt 1:다수맵핑, Map은 1:1맵핑
                        strings.stream().mapToInt(s -> Integer.parseInt(s))
                                )
                                .forEach(System.out::println);

        int result = Stream.of(list1, list2)
                .flatMapToInt( strings ->
                        strings.stream().mapToInt(s -> Integer.parseInt(s))
                )
                .sum();

        System.out.println("result = " + result);
    }
}
