//기본 생성자는 다른 생성자를 선언하게 되면 생략 불가

// 상송관계에선 부모 클래스 생성자가 무조건적으로 호출 되어야 한다. 이것이 기본 생성자이든 다른 생성자이든,

//상속관계에서는 부모클래스의 기본생성자를 호출하는것이 존재하나 생략되어져 있음.
//만약에 부모클래스에 기본 생성자가 선언되어 있지 않을 시 다른 생성자 호출을 통해 부모 클래스 생성자를 호출할 수 있다.

package org.example.aa;

public class FriendMan extends Man{
    private String place;

    public FriendMan(String name){
        super(name);    //Man class에서 기본생성자 호출하는게 있어서 생략 가능 (public Man(){})
    }
}