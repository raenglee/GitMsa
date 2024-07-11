public class Ex06 {

    public static void main(String[] args) {

        /*
        주어진 과제
        String -> char[]
        char[] -> String
         */

        String str = "우리는 할 수 있다.";    //문자열
        char[] chars = str.toCharArray();    //문자배열

        System.out.println(chars[0]);
        System.out.println(chars[1]);
        System.out.println(chars[2]);
        System.out.println(chars[3]);
        System.out.println(chars[4]);
        System.out.println(chars[5]);
        System.out.println(chars[6]);
        System.out.println("\n\n\n");
        chars[4] = 'A';    // 4번째 글자를 A로 변경
        System.out.println(chars[4]);

        String aa = new String(chars);    //문자열로 다시 변경
        System.out.println(aa);
    }
}
