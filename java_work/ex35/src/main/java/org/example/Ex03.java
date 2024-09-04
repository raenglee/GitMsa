package org.example;

class Counter {
    private int count = 0;

    public void increment() {
        count++;
    }

    synchronized public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}

public class Ex03 {
    public static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable run1 = () -> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getName()+" "+i);
                counter.increment();
            }
        };
        Runnable run2 = () -> {
            for (int i = 0; i < 1000; i++) {
//                System.out.println(Thread.currentThread().getName()+" "+i);
                counter.decrement();
            }
        };
        //위까진 동기, 스타트 하는 순간부터 비동기
        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);

        th1.start();
        th2.start();

        //join -> 쓰레드0번과 1번이 끝나고 메인 쓰레드를 동작하라는 것(다른 쓰레드와 섞여서 나오지않음)
        th1.join();
        th2.join();

//        for (int i = 0; i < 1000; i++) {
//            System.out.println(Thread.currentThread().getName()+" "+i);

        System.out.println(counter.getCount());
    }
}