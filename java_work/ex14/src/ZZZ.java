import aa.AAA;

public class ZZZ extends AAA {    //extends AAA 상속

    int zzz = 10;
    ZZZ(){
        System.out.println("여기에서 할거예요");
        System.out.println(zzz);
        System.out.println(aaa);    // AAA의 aaa에 protected를 붙여서 사용가능해짐

    }

    public static void main(String[] args) {
        ZZZ zzz = new ZZZ();
    }
}