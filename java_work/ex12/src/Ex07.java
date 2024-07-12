import java.util.Arrays;

public class Ex07 {
    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5};
        int br[] = new int[10];

        System.arraycopy(ar, 3, br, 2, 2);

        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(br));
    }
}