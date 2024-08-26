package org.example;

import java.util.*;

class MyComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.length()-o2.length();
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ROBOT","BOX","LAMDA","AA","기역");
        list = new ArrayList<>(list);

        System.out.println(list);

        MyComparator myComparator = new MyComparator();
        Collections.sort(list,myComparator);

        //Collections.sort(list,(a,b)->a.length()-b.length());  //자료형 타입 적어도되고 안적어도되고

        System.out.println(list);

    }
}