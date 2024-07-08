public class Ex05 {
    public static void main(String[] args) {
        Box a = new Box();
        Box b = new Box();

        System.out.println(a);
        System.out.println(b);

        a.setName("사과");
        System.out.println(a);
        System.out.println(b);

        b.setName("귤");
        System.out.println(a);
        System.out.println(b);

    }
}