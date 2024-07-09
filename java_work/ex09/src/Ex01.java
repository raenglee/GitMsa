// 클래스 정의...

class A {
    int num = 10;

    public void doA() {
        System.out.println("아뭇다나 만들기");
    }
}

public class Ex01 {
    public static void main(String[] args) {
        int num = 10; // 여러개 선언 가능하다
        int num2 = 20;
        int num3 = 30;

//선언하는 순간 메모리에 적재된다
        A a1 = new A();
        A a2 = new A();
        A a3 = new A();

        System.out.println(a1.num);
        a1.doA();
        a1.num = 30;
        System.out.println("a1.num = " + a1.num);

        System.out.println("a2.num = "+a2.num);
        a2.doA();
    }
}
