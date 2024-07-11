import java.util.Scanner;

class Fact {
    public int fact(int num) {
        System.out.println("여기오나" + num);

        // 매서드는 반환값을 적게 되면 반환값이 무조건 있어야 한다. else 가 없으면 에러남

        if (num > 0) {
            return 2 * fact(num - 1);

            // 2 * fact(2)
            // 2 * 2 * fact(1)
            // 2 * 2 * 2 * fact(0)
            // 2 * 2 * 2 * 1 = 8 (else로 리턴되어  fact가 아닌 1이 반환)

        } else {
            return 1;
        }
    }
}

// 2*2*2 num 3
// 2*2*2* num 4
public class Ex00 {

    public static void main(String[] args) {

        //숫자 입력 받는 부분
        Scanner scanner = new Scanner(System.in);
        System.out.println("몇승 구할래?");

        String a = scanner.nextLine();   // 문자열은 스트링
        int num = Integer.parseInt(a);    // 숫자열은 int

        //클래스의 정의와 인스턴스화
        Fact fact = new Fact();
        int result = fact.fact(num);
        System.out.println("result = " + result);


    }
}

/*
int -> double 은 (int) 붙이기
double -> int 는 (double) 붙이기

String -> int 문자열을 숫자로 바꿀땐 Integer.pareInt
int -> String      10+"";
문자열 입력 scan.nextLine 숫자 입력 scan.nextInt

String a = scanner.nextLine();
int num = interger.parseInt(a);   <- 걍 외워야함
System.out.println(a);
System.out.println(num);
 */