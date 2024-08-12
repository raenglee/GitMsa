package org.example;

import java.util.Arrays;

public class Ex04 {

    public static void main(String[] args) {
        int arr[] = {10, 2, 3, 5, 19, 4};

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 1 2 3 4 5 asc
        // 5 4 3 2 1 desc
        for(int a:arr){
            System.out.println(a);
        }
    }
}
