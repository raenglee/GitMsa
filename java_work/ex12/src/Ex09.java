import java.util.Arrays;

public class Ex09 {

    public static void main(String[] args) {

        String str[] = {"aa", "bb", "cc"};      //문자
        for (String temp : str) {
            System.out.println(temp);
        }

        int ar[] = {1, 2, 3, 4, 5};

        //3가지 방법
        System.out.println(Arrays.toString(ar));    //1번

        for (int i = 0; i < ar.length; i++) {     //2번
            System.out.println(ar[i]);
        }

        System.out.println();

        for (int e : ar) {                 //3번
            System.out.println(e);
        }
    }
}