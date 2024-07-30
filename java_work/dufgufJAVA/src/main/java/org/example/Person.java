package org.example;

public class Person {
    private int regiNum;
    private int passNum;

    Person(int rnum, int pnum){
        regiNum = rnum;
        passNum = pnum;
    }
    Person(int rnum){
        regiNum = rnum;
        passNum = 0;
    }

    void showPersonalInfo(){
    }

    public static void main(String[] args) {
        Person jung = new Person(335577, 112233);

        Person hong = new Person(775544);

        jung.showPersonalInfo();
        hong.showPersonalInfo();
    }
}
