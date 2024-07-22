package org.example;

public class SPrint implements Printable{
    @Override
    public void print(String doc) {
        System.out.println("삼성프린터기");
        System.out.println(doc);
    }

    @Override
    public void doA() {

    }
}
