package org.example;

import java.util.Arrays;

public class Ex03 {

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int arr2[] = new int[arr1.length];

        System.arraycopy(arr1, 0, arr2, 0, arr1.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        if(arr1 == arr2){
           System.out.println("두 배열이 == 같다");
        }
        if(Arrays.equals(arr1, arr2)){
            System.out.println("Arrats.equals() 사용했을시에 같다");
        }
    }
}