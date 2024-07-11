class Box {
    String conts;

//    Box(String cont){
//        this.conts =cont;
//    }
    // Alt + insert 키 생성자 자동생성
    //Alt + insert 키 toString 자동생성

    public Box(String conts) {
        this.conts = conts;
    }

    public String toString() {
        return "Box{ conts='" + conts + "'}";
    }
}

public class Ex04 {
    public static void main(String[] args) {
        Box[] boxes = new Box[5];
        boxes[0] = new Box("사과");
        for (int i = 0; i < boxes.length; i++) {
            System.out.println(boxes[i]);
        }
    }
}