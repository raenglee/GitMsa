package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex04 {
    public static void main(String[] args) {
        Runnable run1 = () -> {
            int n1 = 10;
            int n2 = 20;
            System.out.println(Thread.currentThread().getName() + " " + n1 + n2);
        };
//        ExecutorService exr = Executors.newSingleThreadExecutor();  //쓰레드 1개만 받을수 있음
        ExecutorService exr = Executors.newFixedThreadPool(3);  // 쓰레드 n개까지도 받음
        exr.submit(run1);
        exr.submit(run1);
        exr.submit(run1);
        exr.submit(run1);

        System.out.println("end" + Thread.currentThread().getName());
        exr.shutdown();
    }
}
