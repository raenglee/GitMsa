package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex06 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        //원래 now를 치면 길~게 나옴
        System.out.println(now);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh시 mm분 ss초");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy/MM/dd hh: mm: ss");
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println(dtf.format(now));
        System.out.println(dtf2.format(now));
        System.out.println(dtf3.format(now));

        String result = DateTimeFormatter.ofPattern("MM / dd").format(LocalDateTime.now());
        System.out.println("result = " + result);

        //추가해야하는 문장과 자바파일 있음

    }
}
