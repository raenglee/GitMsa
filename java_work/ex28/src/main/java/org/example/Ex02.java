package org.example;

import java.util.Random;

interface RAN{
    int ran();
}

public class Ex02 {
    public static void main(String[] args) {
        RAN ran = () -> new Random().nextInt(50);
        for (int i = 0; i < 10; i++)
            System.out.println(ran.ran());
        System.out.println();
    }
}
