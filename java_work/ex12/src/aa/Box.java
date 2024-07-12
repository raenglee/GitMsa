package aa;

//클래스 정의
public class Box {
    String name;
    int count;

    /*
    기본 생성자는 생략가능하지만
    다른 생성자를 선언할 시 기본생성자 생략 불가

    접근제어지시자
    public protexted default private

     */

    public Box() {    //접근 제어 지시자
        System.out.println("기본 생성자 호출");
    }

    public Box(String n) {    //다른 생성자 선언
        name = n;
        System.out.println("다른 생성자 호출");
    }

    public Box(String n, int c) {    //다른 생성자 선언
        name = n;
        count = c;
        System.out.println("n c 다른 생성자 호출");
    }

    //생략되어진거지만 프로그래머가 직접 적으면 내용이 바뀜
    // toStirng() 은 주소값 출력인데 아래는 인위적으로 내용을 바꾼것

    public String toString() {
        return "Box name = " + name+" count = "+count;
    }

    /*
    매서드 이름 같은수 없으나 파라메터(스트링a가 들어가면 괜찮아짐)
    ㄴ 위에 public Box(){}랑 Box(String n){} 을 같이 쓸 수 있는 이유
    */

    public void doA() {
    }

    public void doA(String a) {
    }
}