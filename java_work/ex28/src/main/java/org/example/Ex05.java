package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(11, 22, 33, 44, 55, 10, 20, 30, 40, 50);
        list = new ArrayList<>(list);

//                list.removeIf(integer -> integer%2 == 0);
//
//        System.out.println(list);

        List<Integer> indexs = new ArrayList<>();

        for (int i=0; i<list.size();i++) {
            int temp = list.get(i);
            System.out.println("temp ="+temp);
            if (temp % 2 == 0)
                indexs.add(i);
        }
        System.out.println(list);
        System.out.println(indexs);
    }
}
