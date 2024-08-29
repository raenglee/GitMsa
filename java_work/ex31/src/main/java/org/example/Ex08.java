package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Ex08 {

    public static void main(String[] args) {

        //1,3,5,7,9 홀수만 모으기
        List<Integer> oddlist = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 1)  // 걸러내고싶으면 필터
                .collect(  // 스트림으로 흘려보낸것을 콜렉트로 모으는것
                        () -> new ArrayList<Integer>()  // 어떤것으로 모아지게 하고싶은지 (ArraysList로 모으고싶은 것)
                        , (list, item) -> list.add(item)
                        , (integers, integers2) -> {
                        } // integers.addAll(integers2) 모양만 만든거고 없다고 봐도 무방
                );

        System.out.println("홀수 : " + oddlist);

        //2,4,6,8,10 짝수만 모으기
        List<Integer> evenlist = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> integer % 2 == 0)
                .collect(
                        () -> new ArrayList<Integer>()
                        , (list, item) -> list.add(item)
                        , (integers, integers2) -> {
                        }
                );

        System.out.println("짝수 : " + evenlist);


        //중복 제거 set
        Set<Integer> mset = Stream.of(0, 20, 30, 10, 40, 30)
                .collect(
                        () -> new HashSet<Integer>()
                        , (a, integer) -> a.add(integer)  // 변수명이라서 변경가능
                        , (integers, integers2) -> {
                        }
                );

        System.out.println("중복 제거 : " + mset);

    }
}
