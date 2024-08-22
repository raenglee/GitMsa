package org.example;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {

        String []arr = new String[]{"a", "b", "c"};

        showAll(arr);

    showAll("TEST");
    showAll("TEST", "AAA");
    showAll("TEST", "AAA", "BBB");
    }

    public static void showAll(String... args){   // ... <- 가변인자라는 표시
        System.out.println(Arrays.toString(args));
    }
}