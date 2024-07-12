import java.util.Arrays;

public class Ex05 {

    public static void main(String[] args) {
        int ar[] = new int[5];    //모든 배열의 값은 0으로 초기화되어있다

        //ar = {3,3,3,3,3,};

        Arrays.fill(ar, 3);

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

        Arrays.fill(ar, 0, 2, 10);

        for (int i = 0; i < ar.length; i++) {
            System.out.println(ar[i]);
        }

    }
}