package org.example;

public class BoxFactory {

    public static <T> void peekBox(Box<T> box) {
        System.out.println(box);
    }

    //와일드카드
    public static void peekBox2(Box<? extends Number> box){
        System.out.println(box);
    }

    public static void peekBox3(Box<Object> box){
        System.out.println(box);
    }

    // 상한 제한
    public static void peekBox4(Box<? extends AA> box){
        System.out.println(box);
    }

    // 하한 제한
    public static void peekBox5(Box<? super BB> box){
        System.out.println(box);
    }

    // AA만 제한해서 BB, CC는 안됨
    public static void peekBox6(Box<? extends AA> box){
        AA getbox = (AA) box.getT();
        System.out.println(getbox);
//        box.setT(new AA());
    }

    public static void peekBox7(Box<? super AA> box){
//        AA getbox = (AA) box.getT();
//        System.out.println(getbox);
        box.setT(new AA());
    }

    //T는 AA를 보낼수도있고 BB를 보낼 수도 있고 CC를 보낼 수도 있다는 것
    public static <T> T getMyBox(Box<? extends T> box) {
        return box.getT();
    }
}

