package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
Instant is1 = Instant.now();

        System.out.println("is1 = " + is1);

        List<String> list = Arrays.asList("11","22","33","44","55");
//        list.stream()
//                .forEach(System.out::println);
//향상된 for문으로 나타내는 법
        for(String temp:list){
            System.out.println(temp);
        }

        Instant is2 = Instant.now();
        System.out.println(is2);

        Duration dt = Duration.between(is1,is2);
        System.out.println(dt);
        System.out.println(dt.toMillis());
    }
}