package org.example;

import java.util.Arrays;

public class Ex05 {

    public static void main(String[] args) {

        Person p1 = new Person("홍길동", 40);
        Person p2 = new Person("김길동", 20);
        Person p3 = new Person("박길동", 50);

        // p1 == this
        // p2 == Object o
//        p1.compareTo(p2);

        Person parr[] = {p1,p2,p3};
        for (Person p : parr) {
            System.out.println(p);
        }

        Arrays.sort(parr);
        for (Person p  : parr){
            System.out.println(p);
        }

        int index = Arrays.binarySearch(parr,p1);
        System.out.println(index);
        System.out.println(parr[index]);
    }
}