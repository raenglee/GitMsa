import java.util.Scanner;

// shift + delete 한줄 삭제
public class ex01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double daoubleValue = scan.nextDouble();
        int intValue = (int) (daoubleValue*100);
        System.out.println(intValue);
        System.out.println(intValue/(double)100);
    }
}
