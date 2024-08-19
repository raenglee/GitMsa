package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ex01 {
    public static void main(String[] args) {

        List<String> list = new ArrayList();
        // List -> ArrayList, LinkedList

        list.add("Toy");
        list.add("ROBOT");
        list.add("BOX");

        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        Person p1 = new Person("홍길동",20);
        Person p2 = new Person("홍길동", 30);

        System.out.println(p1);
        System.out.println(p2);

        List<Person> plist = new ArrayList<>();
        plist.add(p1);
        plist.add(p2);

        System.out.println(plist);
    }
}
