class InstClass{

    static int num = 0;
    InstClass(){

        num++;
        System.out.println(num);
    }
}

public class Ex04 {

    public static void main(String[] args) {
        System.out.println(InstClass.num);    //객체생성을 안했지만 num출력 가능(참조가능)
        InstClass in1 = new InstClass();    //객체생성한것 그러나 위의 방법이 더 좋음
        new InstClass();
        new InstClass();
        new InstClass();

        System.out.println(in1.num);
    }
}