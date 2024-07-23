package org.example.print;

import org.example.inter.CMYKPrintable;

public class CMYKPrinter implements CMYKPrintable {
    @Override
    public void printCMYK(String doc) {
        System.out.println("컬러 프린터기");
        System.out.println(doc);
    }

    @Override
    public void print(String mydoc) {
        System.out.println("흑백 프린터기");
        System.out.println(mydoc);

    }
}
