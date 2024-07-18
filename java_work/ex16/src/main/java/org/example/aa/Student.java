package org.example.aa;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString    //ToString된것
@AllArgsConstructor
public class Student {


    //public static int NUM = 0;

    private String name;
    private int kor;
    private int eng;
    private int math;

//    public Student(String name,
//                   int kor,
//                   int eng,
//                   int math) {
//        this.name = name;
//        this.kor = kor;
//        this.eng = eng;
//        this.math = math;
//    }

    public float getAverage() {
//        System.out.println("평균= " + (kor + eng + math) / 3);
        return (kor+eng+math)/(float)3;
    }

    public int getTotal() {
//        System.out.println("총합= " + (kor + eng + math));
        return kor+eng+math;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                '}';
    }
}