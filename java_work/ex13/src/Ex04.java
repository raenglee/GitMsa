public class Ex04 {

    public static void main(String[] args) {
        Circle circle1 = new Circle(3);  //다른생성자가 선언되어서 ()안을 채워야함 기본생성자 생략불가능이므로

        circle1.setRed(-10);
        System.out.println(circle1.getRad());

        System.out.println();
    }
}