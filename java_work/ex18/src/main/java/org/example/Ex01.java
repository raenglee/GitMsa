package org.example;

import java.util.Arrays;

public class Ex01 {

    public static void doA(int temp){
        temp += 5;
        System.out.println("do A temp "+temp);
    }

    public static void doA(int[] crr){
        for (int i = 0; i < crr.length; i++) {
            crr[i] +=5;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a = 10;
        doA(a);
        System.out.println(a);

        int arr[] = {1,2,3};
        doA(arr);
        System.out.println(Arrays.toString(arr));
    }
}