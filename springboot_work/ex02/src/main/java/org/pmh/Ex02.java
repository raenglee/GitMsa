package org.pmh;

//java -> 프레임워크, 개발패턴을 정하는 것(어떠한 개발방법론)

import org.pmh.components.CC;

public class Ex02 {

    //싱글톤
    public static void main(String[] args) {


        //CC cc = new CC(); 이것으로 생성하지말고

        //이것으로 생성하기
        CC cc1 = CC.getInstance();
        System.out.println(cc1);

        CC cc2 = CC.getInstance();
        System.out.println(cc2);

        CC cc3 = new CC();

        System.out.println(cc1==cc2);

        //객체 생성이 새로된거라서 다르다고 나오고 메모리 부하가 올라감
        System.out.println(cc1==cc3);

    }
}
