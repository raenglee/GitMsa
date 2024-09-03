package org.example;

import java.io.*;


//객체 저장 하려면 시리얼라이저블 상속받아야함
class MyObject implements Serializable {
    private String test = "aaa";

    public String getTest() {
        return test;
    }
    public void setTest(String test) {
        this.test = test;
    }
}

public class Ex01 {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream  //ObjectOutputStream, FileOutputStream 둘 다 예외 만들어줘야함
                oos = new ObjectOutputStream(new FileOutputStream("d:/a/obj"));

        oos.writeObject(new MyObject());
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("d:/a/ois"));

        Object aaa = ois.readObject();
        MyObject mo = (MyObject) aaa;

        System.out.println(mo.getTest());
    }
}
