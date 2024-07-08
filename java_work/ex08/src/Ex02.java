//    import java.lang.Math;

import aa.bb.CC;

public class Ex02 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            CC.doA();
        }

        // 0<x<1
        // 0.00001<x<0.999999
        //(int) 붙이면 소수점 날아가서 0<= x <= 0
        // 6 하면 , 0.000006 <= x <= 5.444444?
        // 형변환하면 0 <= x <= 5
        // +1을 하면 1 <= x <= 6
        // 먼저 더한 후 형변환을 해야하므로 괄호 묶어주기
//        int value = (int) (Math.random()*6+1);
//        System.out.println("vlaue = " + value);

    }
}
