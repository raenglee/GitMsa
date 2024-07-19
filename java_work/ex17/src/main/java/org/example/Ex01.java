package org.example;

import org.example.phone.Mobilephone;
import org.example.phone.SmartPhone;

public class Ex01 {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("5.0", 12345678);
        smartPhone.show();

        Mobilephone mobilephone=
                new Mobilephone(123456);
        mobilephone.show();
    }
}