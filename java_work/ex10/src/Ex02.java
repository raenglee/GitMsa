class B {
    //toString 생략, 개발자 임의로 적을 시 적은 내용 실행
    //생성자도 생략 가능

    int a = 10;

    //생성자
    public B() {
        System.out.println("생성자");
        a = 20;
    }


    //생략되어진 문법..
//    public String toString(){return"Asdfasdf}

}

public class Ex02 {

    public static void main(String[] args) {
        // 생성자는 함수랑 비슷한 모양이지만
        // 변환값을 적지 않는다.
        B b = new B();
        System.out.println(b.a);

    }
}
