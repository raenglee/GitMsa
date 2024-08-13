package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex04 {

    public static <T> Box<T> makeBox(T t) {
        Box<T> box = new Box<>();
        box.setObj(t);
        return box;
    }

    public static void main(String[] args) {

        Box<String> box1 = makeBox("test");
        Box<Integer> box2 = makeBox(20);

        System.out.println(box1);
        System.out.println(box2);

        List<String> list = Arrays.asList("홍길동", "길동", "동");
        List<Integer> ilist = list
                .stream()
                // value는 변수명, 아무렇게나 지어도 됨
                .mapToInt(value -> value.length() )
                .boxed()
                .collect(Collectors.toList());

        System.out.println(list);
        System.out.println(ilist);
    }
}
