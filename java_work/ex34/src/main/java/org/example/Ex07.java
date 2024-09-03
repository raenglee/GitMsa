package org.example;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex07 {

    public static void main(String[] args) throws IOException {

        // 파일생성 안됨...
        Path path = Paths.get("cc");

//        Files.createFile(path);


        // 10 유니코드로변환하면 줄바꿈 입니다.
        // 65 유니코드로변환하면 A입니다.

        // NIO java 기반
        try(DataOutputStream outputStream = new DataOutputStream(Files.newOutputStream(path))){
            outputStream.writeChar('A');
            outputStream.writeInt(65);
            outputStream.writeInt(10);
//            outputStream.write(10);
//            outputStream.write(65);
//            outputStream.write(10);
//            outputStream.write(65);
//            outputStream.write(65);
//            outputStream.write(65);
//            outputStream.write(65);
        }catch (Exception e){
            e.printStackTrace();
        }


//        // IO java 기반...
//        try(BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("aa"))){
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }


    }
}