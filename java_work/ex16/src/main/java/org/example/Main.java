package org.example;

import org.example.aa.Student;

public class Main {

    Main(){
        Student student = new Student(    //Student클래스에서 public Student를 불러옴
                "홍길동",90,80,60);
        System.out.println(student);

        float result = student.getAverage();
        System.out.println(result);                 //두줄 출력도 가능
        System.out.println(student.getTotal());    //참조변수로 출력
    }

    public static void main(String[] args) {
        new Main();    //메인을 불렀으니 위에 있는 Main()을 호출함
    }
}