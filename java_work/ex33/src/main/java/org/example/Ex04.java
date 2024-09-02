package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex04 {

    public static void main(String[] args) throws Exception {

        BufferedWriter bw = new BufferedWriter(
                new FileWriter("myfile",true));
        //기본값은 false, true 추가하면 글자가 새로 추가됨, false는 파일 자체가 글자가 변경되는것

        bw.write("글자를 바꿈");
        bw.newLine();  // 줄바꿈
        bw.write("확인");
        bw.newLine();
        bw.write("글자추가");
        bw.close();

        BufferedReader fr = new BufferedReader(new FileReader("myfile"));

        while (true) {
            String str = fr.readLine();  // 한 줄을 읽는것
            System.out.println(str);

            if (str == null)
                break;
        }
        fr.close();
    }
}