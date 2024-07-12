import aa.Box;

public class Main {
    public static void main(String[] args) {

        // 인턴스 화, 메모리에 적재하는것
        Box abox = new Box("사과");    // 기본생성자
        Box bbox = new Box();    // 기본생성자
        Box cbox = new Box("바나나",10);

        System.out.println(abox);
        System.out.println(bbox);
        System.out.println(cbox);
    }
}
