package org.example;

import org.example.inter.Printable;

public class Ex02 {
    public static void main(String[] args) {

        Printable prn = new Printable() {
            @Override
            public void print(String mydoc) {
                System.out.println("test: "+mydoc);
            }
        };

        prn.print("새로운 문서 출력");

        Printable prn2 = (mydoc) -> {
            System.out.println("람다로 문서 출력: "+mydoc);
        };

        prn2.print("람다아아");
    }
}
