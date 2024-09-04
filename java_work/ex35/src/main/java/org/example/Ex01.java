package org.example;

public class Ex01 {

    public static void main(String[] args) {
        Runnable run1 = () -> {

            //쓰레드 0번
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100); //100 = 0.1초
                    if (i % 2 == 0)
                        System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread th1 = new Thread(run1);
        th1.start();  // 얘가 붙으면 메인쓰레드가 아니게 됨

        //쓰레드 1번
        Runnable run2 = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    Thread.sleep(100); //100 = 0.1초
                    if (i % 3 == 0)
                        System.out.println(Thread.currentThread().getName() + " " + i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread th2 = new Thread(run2);
        th2.start();

        //메인 쓰레드
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100); //100 = 0.1초
                if (i % 2 == 1)
                    System.out.println(Thread.currentThread().getName() + " " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//            Thread.sleep(3000);  // 밀리세컨드라 1000이 1초
//            System.out.println("3초 후 출력");