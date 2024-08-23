package org.example;

//람다 -> 인터페이스 필요함
//interface는 꼭 한개의 메서드가 존재해야 한다. 두개는X 무엇을 재정의할지 구분을 못함
//default, static 예약어를 붙여주면 몸체를 가질수있어서 인터페이스안에 함수를 넣을수있다
//몸체없는 함수는 오로지 한개여야하는것이 람다의 규칙

interface AA {
    int doA();
    default void doB() {
        System.out.println("doB");
    }

    static void doC() {
        System.out.println("doC");
    }
}

public class Ex04 {

    public static void doMethod(AA aa) {
        aa.doA();
        aa.doB();
        AA.doC();
    }

    public static void main(String[] args) {
        AA aa = () -> 10; // 아래 모두 생략가능
//        {
//            System.out.println("doA 메서드 재정의");
//            return 10;
//        };
        int result = aa.doA();
        System.out.println(result);
////        aa.doA();
////
////        doMethod( () -> {
//            System.out.println("새로운 함수 정의");
//        });
    }
}