package org.example;

public class Ex04 {
    public static void main(String[] args) {

        //throws 예외 전달자
        //throw 예외 생성

        try {
            throw new MyException
                    (new ErrorCode("ID를 입력하세요",
                            "A101",
                            "ID는 영어로 입력하셔야 됩니다.")
                    );
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }

    }
}
