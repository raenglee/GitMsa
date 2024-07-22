package org.example;

//자동완성 Ctrl+Space+Enter 2번 하고 Alt+enter로 오버라이드추가

public class LPrint implements Printable {
    @Override
    public void print(String doc) {
        System.out.println("LG프린터");
        System.out.println(doc);

    }

    @Override
    public void doA() {

    }
}
