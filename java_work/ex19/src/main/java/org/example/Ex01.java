package org.example;

import org.example.inter.CMYKPrintable;
import org.example.inter.Printable;
import org.example.print.CMYKPrinter;

public class Ex01 {
    public static void main(String[] args) {
        //2개의 변수 WIDTH, HEIGHT
        //2개의 메서드 print(), cmykpritn();
        System.out.println(Printable.WIDTH);
        System.out.println(CMYKPrintable.HEIGHT);

        CMYKPrintable prn = new CMYKPrinter();
        prn.print("옛날프린터기");
        prn.printCMYK("내문서");

        prn.clean();

        Printable.printLine();
    }
}
