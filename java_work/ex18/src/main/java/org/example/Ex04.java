package org.example;

import org.example.friend.CompFriend;
import org.example.friend.Friend;
import org.example.friend.UniFriend;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
        int cnt = 0;

        Friend friend[] = new Friend[10];

        friend[cnt++]
                = new UniFriend("홍길동","010-000-000","컴퓨터");
        friend[cnt++]
                = new CompFriend("홍길동","010-000-000","개발팀");

        System.out.println(Arrays.toString(friend));

        for (int i = 0; i < cnt; i++) {
            friend[i].showInfo();
            System.out.println();
        }
    }
}