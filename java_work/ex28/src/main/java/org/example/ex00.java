package org.example;

public class ex00 {
    public static void main(String[] args) {
       Friend[] frns = new Friend[10];
       int cnt = 0;

       frns[cnt++] = new UnivFriend("LEE","Computer","010-555-333");
        frns[cnt++] = new CompFriend("YOON","R&D 1","053-555-333");
       frns[cnt++] = new UnivFriend("KIM","Electronics","010-555-333");
       frns[cnt++] = new CompFriend("PARK","R&D 2","02-555-333");

        for (int i = 0; i < cnt; i++) {
            frns[i].showInfo();
            System.out.println();
        }
    }
}