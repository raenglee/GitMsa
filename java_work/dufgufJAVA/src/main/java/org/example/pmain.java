package org.example;

public class pmain {
    public static void main(String[] args) {
        Person jung = new Person(335577, 112233);
        Person Kim = new Person(32353, 238023);

        Person hong = new Person(775544);

        jung.showPersonalInfo();
        hong.showPersonalInfo();
        Kim.showPersonalInfo();

    }
}