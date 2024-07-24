package org.example;

public class Ex05 {

    public static int doA() {
        try {
            int a = 10;
            int b = 0;

            return a / b;
        } catch (Exception e) {
            System.out.println("예외 발생");
            return 0;
        } finally {
            System.out.println("무조건 여기로 온다");
        }
    }

    public static void main(String[] args) {
        System.out.println(doA());
    }
}