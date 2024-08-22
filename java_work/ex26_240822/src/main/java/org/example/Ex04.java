package org.example;

public class Ex04 {
    public static void main(String[] args) {
        who(Person.MAN);
//        who(Animal.DOG);  // 소스상 에러남
        System.out.println(Person.MAN);
    }

    public static void who(Person person){
        if(person==Person.MAN){
            System.out.println("남성 손님입니다");
        }else{
            System.out.println("여성 손님입니다");
        }
    }
}