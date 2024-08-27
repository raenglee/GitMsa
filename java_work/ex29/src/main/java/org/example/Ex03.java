package org.example;

import java.util.Arrays;
import java.util.stream.Stream;

public class Ex03 {
    public static void main(String[] args) {
        String[] arr = {"aa","bb","cc"};

        Stream<String> stringStream = Arrays.stream(arr);
        stringStream.forEach(s-> System.out.println("내용 = "+s));

    }
}
