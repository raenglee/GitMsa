package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(10,"홍길동");
        map.put(20,"박길동");
        map.put(30,"이길동");
        map.put(40,"이길동");

        System.out.println(map);

        System.out.println(map.get(20));

        Set<Integer> set = map.keySet();
        System.out.println(set);

        for(int key : set){
            System.out.println(map.get(key));
        }
    }
}