package org.example;

import java.util.function.Function;

public class Ex03 {

    public static void main(String[] args) {
//        Function<char[], String> function = chars -> new String(chars);
        Function<char[], String> function = String::new;
        String test = function.apply(new char[]{'a','b','c','d'});

        System.out.println(test);
    }
}
