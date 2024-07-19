package org.example;

import org.example.aa.KiaCar;
import org.example.aa.SamsungCar;

public class Ex00 {
    public static void main(String[] args) {

        SamsungCar samsungCar = new SamsungCar("XM3", "예쁨", "삼성");
        KiaCar kiaCar = new KiaCar();
        //생성자 선언

        System.out.println(samsungCar);
        System.out.println(kiaCar);
    }
}