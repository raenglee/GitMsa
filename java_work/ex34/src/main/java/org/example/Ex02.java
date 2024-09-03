package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:/a/obj");

        System.out.println(path);
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
        System.out.println(path.getFileName());

        Path pa1 = Paths.get("d:/a/b/c");

        Files.createDirectories(pa1);

    }
}
