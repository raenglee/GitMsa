package org.example;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {
    public static void main(String[] args) {
        Path path = Paths.get("cc");

        //NIO java 기반
        try(OutputStream outputStream = Files.newOutputStream(path)) {
            outputStream.write(10);  // 10 유니코드 변환 시 줄바꿈
            outputStream.write(65);  // 65 유니코드 변환 시  A
            outputStream.write(10);
            outputStream.write(65);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // IO java 기반
//        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("aa")) {
//
//        } catch(Exception e){
//            e.printStackTrace();
//        }
    }
}
