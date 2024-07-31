package org.example;

public class Person {
    private int regiNum;
    private int passNum;

    Person(int rnum, int pnum){
        regiNum = rnum;
        passNum = pnum;
    }
    Person(int rnum){
        this(rnum, 0);
    }

    void showPersonalInfo(){
        System.out.println(regiNum);
        System.out.println(passNum);
    }
}
