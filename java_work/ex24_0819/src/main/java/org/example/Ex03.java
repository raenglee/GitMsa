package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("TOY", "BOX", "ROBOT");

        list = new ArrayList<>(list);
        list.add("컬렉션 인스턴스");

        System.out.println(list);
    }
}