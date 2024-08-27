package org.example;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {

        String[] arr = {"YOON","PARK","ROBOT"};

        for(String temp:arr){
            System.out.println("내용 "+temp);
        }
        /*
        1. Stream 생성방법
        2. 중간연산 filter, map
        3. 최종연산 sum, foreach
        나머지는 기타등등
        */

        Arrays.stream(arr)
                .forEach(s -> System.out.println("내용 " + s));

    }
}