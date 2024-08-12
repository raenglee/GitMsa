package org.example;

public class Ex01 {

    public static void main(String[] args) {

        // primitive 기본형태이므로 함수가 없음
        int a = 10;
        // wrapper 클래스 이기 때문에 함수가 존재함
        Integer b = Integer.valueOf(20);

        System.out.println(a);
        System.out.println(b);

        // unboxing 래퍼클래스가 기본자료형 타입으로 자동 변환
        a = b.intValue();
    }
}