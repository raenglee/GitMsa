package org.example;

public class Ex02 {

    public static void main(String[] args) {

        BoxFactory.peekBox6(new Box<>(new AA()));
        BoxFactory.peekBox7(new Box<>(new AA()));

        BB bb = BoxFactory.<BB>getMyBox((new Box<>(new BB())));
        AA aa = BoxFactory.<AA>getMyBox((new Box<>(new AA())));

        BB bb1 = BoxFactory.getMyBox((new Box<>(new BB())));
        AA aa1 = BoxFactory.getMyBox((new Box<>(new AA())));
    }
}
