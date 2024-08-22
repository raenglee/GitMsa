package org.example;

import java.util.*;

public class Ex01 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("BOX", "TOY", "ROBOT", "APPLE");
        list = new ArrayList<>(list);
        list.add("추가해요");

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        System.out.println();  //줄바꿈
        for(String temp:list){  //향상된 for문
            System.out.println(temp);
        }

        System.out.println();
        for(Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.println(itr.next());
        }
    }
}

