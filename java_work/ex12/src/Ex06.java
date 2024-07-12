import java.util.Arrays;

class A {
    int a;
}

public class Ex06 {

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5};
        int br[] = ar;

        br[0] = 10;

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }
        System.out.println();

        for (int i = 0; i < br.length; i++) {
            System.out.println(br[i]);
        }

        A a = new A();
        A b = a;

        a.a = 10;
        System.out.println("a.a = " + a.a);
        System.out.println("b.a = " + b.a);
    }
}