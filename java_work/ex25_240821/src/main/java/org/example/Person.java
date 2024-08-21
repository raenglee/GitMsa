package org.example;

public class Person {

    private int age;
    private String name;

    public Person(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
