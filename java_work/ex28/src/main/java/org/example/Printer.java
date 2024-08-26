package org.example;

interface Printable {
    void print();
}

class Print1 implements Printable {
    @Override
    public void print() {
        System.out.println("class상속");
    }
}

public class Printer {

    public static void main(String[] args) {
        //1. class 상속받아서 하는 방법
        //2. 익명 인터페이스
        //3. 람다

        Printable print = new Printable() {
            @Override
            public void print() {
                System.out.println("익명 인터페이스");
            }
        };

        Printable printLamda = () -> System.out.println("람다");
        printLamda.print();
    }
}
