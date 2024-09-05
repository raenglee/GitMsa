package org.pmh.components;

public class CC {
    private static CC cc = new CC();

    //모든 객체를 만들때마다 적어야한다는 점이 불편한 방법이라서 스프링부트가 나옴
    public static CC getInstance() {
        if (cc == null)
            cc = new CC();
        return cc;
    }
}
