public class Ex04 {

    /*
    5! = 5*4!
    4! = 4*3!
    3! = 3*2!
    재귀 함수 = 자기자신의 함수를 추출하는 것
     */

    public static int fact(int num) {

        if (num > 0) {
            return num * fact(num - 1);
            // 5 * fact(4)
            // 5 * 4 * fact(3)
            // 5 * 4 * 3 * fact(2)
            // 5 * 4 * 3 * 2 * fact(1)
            // 5 * 4 * 3 * 2 * 1 * fact(0)
            // 5 * 4 * 3 * 2 * 1 * 1
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int result = fact(5);
        System.out.println(result);

//        String[] strary = {"aa", "bb", "cc"};
//        System.out.println("배열선언함");
//        main(strary);
    }
}