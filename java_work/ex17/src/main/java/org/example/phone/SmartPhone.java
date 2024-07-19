package org.example.phone;

public class SmartPhone extends Mobilephone {

    private String androidVer;

    public SmartPhone(String aver, int number) {
        super(number);
        this.androidVer = aver;
    }
// 재정의 되었다. 아래가 없으면 버전없이 넘버만 두개 나옴
    @Override // 한것임 오버라이드=재정의 , 부모와 자식에게 둘다 있으면 오버라이드라함
    public void show(){
        super.show();    //부모것도 호출하고싶으면 슈퍼 추가
        System.out.println("androidVer = " + androidVer);
    }
}
