package aa;

public class TV {
    private String name;
    private int year;
    private int inch;

    public TV(String name, int year, int inch) {
        this.name = name;
        this.year = year;
        this.inch = inch;
    }    //알트+인서트단축키에서 컨스트럭터로 생성자도 만들수있음

    public void show() {
        System.out.println(name+"에서 만든 "+year+"년 "+inch+"인치");
    }    //알트엔터로 만든것

//    public void show(){    // 쇼도 직접적어도됨
//
//    }



//    public TV(String n, int y, int in){    //생성자 호출
//        name = n;
//        year = y;
//        inch = in;
//    }
}