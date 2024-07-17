/*
1. "Hello.java" 문자열에서 파일명은 Hello와 확장자인 java를 분리시켜보자.

    입력 >>Hello.java
    출력
    파일명 Hello
    확장자 java

    ->언제쓰느냐? 파일 업로드시 exe파일을 올릴수 없도록 검사 할 때
 */


import java.util.Arrays;

public class Ex00 {
    public static void main(String[] args) {
        String str = "Hello.Java";
        String temp[] = str.split("\\.");

        System.out.println(temp[0]);
        System.out.println(temp[1]);

        str = "Hello.Java";
        temp = str.split("[A-Z]");

        System.out.println(Arrays.toString(temp));

        str = "안녕하세요1음...2특별히 만들3려는건...없어요..";
        temp = str.split("\\d");

        str = "안녕하세요1음...2특별히 만들3려는건...없어요..";
        temp = str.split("\\D");

        System.out.println(Arrays.toString(temp));


        if(temp[0].equals("exe"))
            return;
    }
}