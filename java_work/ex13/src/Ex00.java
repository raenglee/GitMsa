import java.util.Scanner;

/*
10진수 입력받아 2진수 출력...
 */

class Exam {
    Scanner scan = new Scanner(System.in);

    public int inPutNumber() {
        System.out.println("숫자 입력");
        int intPutNumber = scan.nextInt();
        System.out.println("intPutNumber().intPutNumber = " + intPutNumber);
        return intPutNumber;

    }
}

public class Ex00 {

    public static void main(String[] args) {
        Exam exam = new Exam();
        int result = exam.inPutNumber();
        System.out.println("main.result = " + result);
        // 이 위로는 입력받는 함수
        //10/2    // 2로 나누고 몫과 나머지를 저장하는것
        int 몫, 나머지;
        몫 = result / 2;
        나머지 = result % 2;

        System.out.println("몫 = " + 몫);
        System.out.println("나머지 = " + 나머지);

        String 나머지들 = "" + 나머지;

        while (true) {
            나머지 = 몫 % 2;
            몫 = 몫 / 2;
            나머지들 = 나머지 + 나머지들;

            System.out.println("몫 = " + 몫);
            System.out.println("나머지 = " + 나머지);
            System.out.println("나머지들 = " + 나머지들);

            if (몫 < 2) {
                if (몫 != 0) {
                    나머지들 = 몫 + 나머지들;
                    System.out.println("나머지들 = " + 나머지들);
                }
                break;    //2보다 작은경우 그만하기
            }
        }
    }
}