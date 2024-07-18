package org.example.aa;

public class Man {

    private String name;

    public Man(){}    //기본생성자 호출

    public Man(String name){
        this.name = name;
    }

    public void  tellInfo(){
        System.out.println("name = " + name);
    }
}