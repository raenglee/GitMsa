class Circle {
    //private 변수는 setter getter로 참조 가능
    private int rad;
    private String name;

    //기본 생성자 생략가능
    //다른 생성자 선언시 기본 생성자 생략 불가..

    //alt+insert 키를 누르면 getter setter constructor 생성가능


    public Circle(int rad) {
        this.rad = rad;
    }   //다른생성자가 선언이 되어서 아래 43번 new Circle()에 괄호를 채워줘야함

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            this.name = name = "홍길동";
            return;
        }
        this.name = name;
    }

    //이 함수를 통해서만 반지름 넣는 것 해라
    public void setRed(int r) {
        if (r < 0) {
            rad = 0;
            return;
        }
        rad = r;
    }

    public int getRad() {    //private변수를 main에서 쓸수있도록 해줌
        return rad;
    }

    public double getArea(){
        return 3.14*rad*rad; // Ex05의 getArea();를 받는 것 이게 없으면 Ex05는 컴파일오류 발생
    }
}
