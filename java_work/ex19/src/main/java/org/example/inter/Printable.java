package org.example.inter;

public interface Printable {

    //static final 변수는 대문자로 짓는것이 관례
    public static final int HEIGHT = 70; // 앞에 퍼블릭 스태틱 파이널 생략
    int WIDTH = 120;

    void print(String mydoc);

    default void clean(){
        System.out.println("청소 기능 추가");
    }

    static void printLine(){
        System.out.println("한줄출력할때 줄바꿈");
    }
}
