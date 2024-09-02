package org.example;

import java.io.FileReader;

public class Ex03 {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("myfile");

        while (true){
            //한 문자 읽음
            int ch = fr.read();
            System.out.println(ch);  //한 문자의 허용범위
            System.out.println((char)ch);

            if(ch == -1)
                break;
        }

//        ch = fr.read();
//        System.out.println(ch);
//        System.out.println((char)ch);
    }
}
