package org.example;

class Task extends Thread {
    @Override  // Ctrl+O 런메소드 정의
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                if (i % 2 == 0)
                    System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Ex02 {

    public static void main(String[] args) {

        //메인 쓰레드를 사용하려면 위에서 try catch문을 가져와야함

        //쓰레드 0번
        Task task1 = new Task();
        task1.start();

        //쓰레드 1번
        Task task2 = new Task();
        task2.start();

        //쓰레드 2번
        Task task3 = new Task();
        task3.start();
    }
}
