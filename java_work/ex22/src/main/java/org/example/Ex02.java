package org.example;

public class Ex02 {
    public static void main(String[] args) {

        DBox<String,Integer> box = new DBox();

        box.setA("홍길동");
        box.setB(20);

        System.out.println(box);

        Object obj = "스트링";
        String str = (String) obj;
   }
}
