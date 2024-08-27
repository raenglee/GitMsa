package org.example;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        double[] arr = {1.1, 2.2, 3.3, 4.4, 5.5};

        Arrays.stream(arr)
                .forEach(s -> System.out.println("요소 " + s));
    }

}
