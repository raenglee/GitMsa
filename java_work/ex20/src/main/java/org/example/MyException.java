package org.example;

public class MyException extends Exception{

    public MyException(ErrorCode errorCode)
    {
        super(errorCode.getMessage());
    }
}
