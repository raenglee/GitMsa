package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        Path fp = Paths.get("d:/a/b/asd");

        boolean test = Files.exists(fp);        System.out.println("파일 존재 유무" + test);

        //파일이 존재하면 creatFile 하면 안되고, 없으면 createFile
        if (test)
            fp = Files.createFile(fp);

        byte[] buf = {0x15, 0x16, 0x17};
        System.out.println(Arrays.toString(buf));

        Files.write(fp, buf, StandardOpenOption.CREATE, StandardOpenOption.APPEND); //어펜드 내용추가

        byte[] buf2 = Files.readAllBytes(fp);
        System.out.println(Arrays.toString(buf2));
    }
}
