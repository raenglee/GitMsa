package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {

        String[]strArr = {"MY_AGE","YOU_LIFE"};

        //원래 for구문
        for(String str : strArr){
            String temp[] = str.split("_");
            for(String s :temp){
                System.out.println(s);
            }
        }

        System.out.println();

        Stream<String> ss1 = Stream.of("MY_AGE", "YOUR_LIFE");
        ss1.flatMap(s -> Arrays.stream(s.split("_")))
                .forEach(System.out::println);
        System.out.println();

        ss1 = Stream.of("MY_AGE", "YOUR_LIFE");
        ss1.map(s -> s.length())
                .forEach(System.out::println);
        System.out.println();

                ss1 = Stream.of("MY_AGE", "YOUR_LIFE");
        ss1.flatMap(s -> Stream.of(s.split("_")))
                .forEach(System.out::println);

    }
}