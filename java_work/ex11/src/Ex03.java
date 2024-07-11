public class Ex03 {
    public static void main(String[] args) {

        int a[] = new int[10]; // a는 int의 배열을 참조하는 참조변수
        int c[] = a;    // 참조변수
        int b[] = {1, 2, 3, 4};

        System.out.println("a.length = "+a.length);

        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println(a[2]);

        a[0] = 20;
        System.out.println(a[0]);

        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);
    }
}
