package org.example;

import java.io.IOException;
import java.nio.file.*;

public class Ex06 {

    public static void main(String[] args) throws IOException {
        Path src = Paths.get("myfile");
        Path target = Paths.get("targetfile");
//        Files.copy(src,target);
//        Files.copy(target, src);
        Files.move(src,target, StandardCopyOption.REPLACE_EXISTING);
    }
}
