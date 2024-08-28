package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Ex06 {
    public static void main(String[] args) {

        // stream filter map 떠올리면 좋음
        List<String> list = Arrays.asList("aaa", "bbbb", "ccccc", "dddddd");

        list.stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .map(s -> s.replace("aa","AA바꿈"))
                .forEach(System.out::println);
        System.out.println();

        list.stream()
                .map(s -> s.length())
                .forEach(System.out::println);
        System.out.println();


        // Optional 안에 있는 map함수의 특징
        // Optional map 메서드를 사용하게 되면 Optional<T> 객체 개체?형식으로 반환된다.
        // 안에 내용이 없을 때는 orElse를 사용해서 뭘 반환할지 작성할 수 있다.
        Optional<String> os1 = Optional.of("abCD efg");
        Optional<String> os2 = os1.map(s -> s.toUpperCase());  // 대문자로
        String result = os1.map(s -> s.toUpperCase()).orElse("Empty");  // 안에 내용이 없을 때 뭘 반환할지

        System.out.println(os2);
        System.out.println(os2.get());
        System.out.println();

        Optional<String> os3 = os1.map(s -> s.replace(" ", "_"))  // 공백을 언더바로
                .map(s -> s.toLowerCase());  // 소문자로

        System.out.println(os3);
        System.out.println(os3.get());  //get 사용 꼭 해줘야함 아니면 Optional이라서
        System.out.println();

        os3.ifPresent(System.out::println);  // get없이 바로 출력
        System.out.println();

        Optional<Integer> os4 = os1.map(s -> s.length());

        System.out.println(os4);
        System.out.println(os4.get());
    }
}
