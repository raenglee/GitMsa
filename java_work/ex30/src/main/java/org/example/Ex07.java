package org.example;

import java.util.Optional;

public class Ex07 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("안녕하세요");


        // map함수, flatmap 함수 잘 쓰진 않음
        // Optional map 함수를 사용하면 Optional로 자동으로 감싸져서 나온다
        // flatmap 을 쓰면 Optional없이 그냥 반환된다. ?
        String str = os1
                .flatMap(s -> Optional.of("바뀌는 것은 Optional로 감싸기"))
                .orElse("EMPTY");

        System.out.println(str);
    }
}