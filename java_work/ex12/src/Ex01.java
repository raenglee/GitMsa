import aa.Box;

public class Ex01 {
    public static void main(String[] args) {
        Box[] boxes = new Box[3];

        boxes[0] = new Box();
        boxes[1] = new Box("사과", 50);
        boxes[2] = new Box("바나나", 30);

        System.out.println(boxes[0]);
        System.out.println(boxes[1]);
        System.out.println(boxes[2]);

        Box abox = new Box();
        Box bbox;
        Box cbox;
    }
}
