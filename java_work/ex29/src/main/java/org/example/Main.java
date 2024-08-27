package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1)
                sum += arr[i];
        }
        System.out.println(sum);

        sum = Arrays.stream(arr)
                .filter(n -> n % 2 == 1)
                .sum();
        System.out.println();
    }
}