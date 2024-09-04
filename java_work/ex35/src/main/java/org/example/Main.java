package org.example;

public class Main {
    public static void main(String[] args) {

        //메인 쓰레드이자 동기
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++)
                System.out.println(Thread.currentThread().getName() + " " + i);
        };

        for (int i = 0; i < 1000; i++) {
            Thread th1 = Thread.currentThread();
            System.out.println(th1.getName() + i);
        }

        //이 아래로는 비동기

        //쓰레드 0번
        Thread thread = new Thread(runnable);  //쓰레드 생성
        thread.start();  //쓰레드 시작

        //쓰레드 1번
        Thread thread2 = new Thread(runnable);
        thread2.start();

    }
}
