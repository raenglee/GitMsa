package org.example.friend;

import lombok.ToString;

/*
배열에서
    클래스 다형성 문법으로
    Friend 클래스 배열로 친구관리를 할 수 있는 프로그램을 작성

    부모참조변수는 자식 인스턴스를 참조할 수 있다.
    모든 클래스는 부모클래스인 오브젝트 클래스를 상속받는다 다 된다
    Object obj = new String();
    Object aa = new A();

오버라이드
    @Override - 부모클래스에 있는 메서드를 재정의 할 때만 사용 가능 <생략 가능>
               존재하지 않는 메서드에 @Override적으면 에러
    toString 메서드

   firnal은 변수에 쓰면 상수
   메서드에서 쓰면 오버라이드 불가능하고
   클래스에 붙으면 상속 불가
 */

@ToString
public class Friend {  //extend Object가 생략되어있음
    String name;    // 투스트링 있어서 프라이빗지움, 프로텍티드는 생략
    String phone;

    public Friend(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public void showInfo() {
        System.out.println("이름 = " + name);
        System.out.println("연락처 = " + phone);
    }
}