public class BB {

    //public static int doA() {             // 메인에서 int로 받으면 int
    public static String doA() {
        int a = 10;
        System.out.println("doA");
        System.out.println("a = " + a);

        return "a의 값은 = " + a;
    }

    public static void main(String[] args) {
        String a = doA();                 // String 이라서 위에서  String으로 받음 int면 위에도 int
        System.out.println("main a = " + a);
    }
}
