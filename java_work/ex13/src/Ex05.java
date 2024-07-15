public class Ex05 {

    public static void main(String[] args) {
        Circle circle = new Circle(5);    //F6로 class Circle 꺼냄

        //넓이를 구하는 함수 선언
        double area = circle.getArea();
        System.out.println("넓이는 = " + area);
    }
}