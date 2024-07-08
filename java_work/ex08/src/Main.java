//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

   public static void doA() {

       int i = 0; // wihle 구문은 변수 괄호 밖에서 선언
        while (i < 10) {
            int j = 0;
            while (j <= i) {
                j++;
                System.out.print("*"); // 줄바꿈없이 * 출력
            }
            System.out.println(); // 줄바꿈
            i++;
        }
    }

    public static void main(String[] args) {
//        int i = 0; // wihle 구문은 변수 괄호 밖에서 선언
//        while (i < 10) {
//            i++;
//            int j = 0;
//            while (j <= i) {
//                j++;
//                System.out.print("*"); // 줄바꿈없이 * 출력
//            }
//            System.out.println(); // 줄바꿈

            doA();
//        }

    }
}

        /*
        i=0 일때 j가 0~ 0 이하 까지 => 1번
        i=1 일때 j가 0~ 1 이하 까지 => 2번
        i=2 일때 j가 0~ 2 이하 까지 => 3번
        i=3 일때 j가 0~ 3 이하 까지 => 0, 1, 2, 3 4번
        ...
         */

//        for (int i = 0; i < 10; i++) {
//            System.out.println();
//            for (int j = 0; j <= i; j++) {
//                System.out.print("*"); // 줄바꿈없이 * 출력
//            }
//            System.out.println(); // 줄바꿈 출력 sout 빈칸은 줄바꿈이네..