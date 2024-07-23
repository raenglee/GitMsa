package org.example;

import org.example.inter.Printable;
import org.example.print.LGPrinter;
import org.example.print.SamPrinter;

public class Ex00 {
    public static void main(String[] args) {
        System.out.println(Printable.HEIGHT);
        System.out.println(Printable.WIDTH);

        Printable prn = new LGPrinter();
        prn.print("내 문서");

        prn = new SamPrinter();
        prn.print("내 문서");

    }

}
