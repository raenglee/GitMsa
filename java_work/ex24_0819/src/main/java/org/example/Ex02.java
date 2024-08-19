package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex02 {

    public static void main(String[] args) {
        Person p1 = new Person("홍길동",20);
        Person p2 = new Person("홍길동", 30);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> plist = new ArrayList<>();
        plist.add(p1);
        plist.add(p2);

        Iterator<Person> iterator = plist.iterator();

        while(iterator.hasNext()){
            Person p = iterator.next();
            System.out.println(p);
            iterator.remove();
        }
        System.out.println(plist);
    }
}