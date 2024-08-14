package org.example;

public class Main {
    public static void main(String[] args) {
        BoxFactory.<Integer>peekBox(new Box<>(10));
        BoxFactory.peekBox(new Box<>(20));
//        SteelBox<String> steelBox = new SteelBox<>();
//        steelBox.setT("test");
//
//        System.out.println(steelBox.getT());
//
    }
}