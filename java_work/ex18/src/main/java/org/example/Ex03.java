package org.example;

import org.example.friend.CompFriend;
import org.example.friend.UniFriend;

import java.util.Arrays;

public class Ex03 {

    public static void main(String[] args) {

        int ucnt = 0;
        int ccnt = 0;

        UniFriend uniFriend[] = new UniFriend[10];
        CompFriend compFriend[] = new CompFriend[10];

        uniFriend[ucnt++] = new UniFriend("홍길동",
                "010-0000-0000", "ㅎㅎ");

        System.out.println(Arrays.toString(uniFriend));
        System.out.println(Arrays.toString(compFriend));

        System.out.println("ucnt = " + ucnt);

        for (int i = 0; i < ucnt; i++) {
            uniFriend[i].showInfo();
        }
        for (int i = 0; i < ccnt; i++) {
            compFriend[i].showInfo();
        }
    }
}