package org.example.print;

import org.example.inter.Printable;

public class LGPrinter implements Printable {
    @Override
    public void print(String mydoc) {
        System.out.println("LG프린터 출력");
        System.out.println(mydoc);
    }
}
