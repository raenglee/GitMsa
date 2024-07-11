public class Ex05 {

    public static void main(String[] args) {

        String str = "안녕하세요1hello1hi1";
        String[] tempstr = str.split("1");    // 1을 기준으로 자르는것

        for (int i = 0; i < tempstr.length; i++) {
            System.out.println(tempstr[i]);
        }

        String a = "abcdefgh";
        System.out.println(a.length());    // 길이가 8이라서 결과 8

        System.out.println(a.charAt(0));    //a
        System.out.println(a.charAt(1));    //b
        System.out.println(a.charAt(2));    //c
        System.out.println(a.charAt(3));    //d

        System.out.println(a.substring(2));    // 2번째부터 자르는것 cdefgh
        System.out.println(a.substring(2, 5));    // 2번째부터 5 전 까지 자르는것 cde
        System.out.println(a.toUpperCase());    // uppercase - 대문자로 lowcase - 소문자로
        System.out.println("cd를 포함하냐 = " + a.contains("cd"));   // 참거짓으로 결과가 나옴 ture

        //
        System.out.println("배열 출력 시작");
        char[] test = "테스트".toCharArray();
        for (int i = 0; i < test.length; i++) {
            System.out.println("test["+i+"]="+test[i]);
        }
        System.out.println("배열 출력 끝");

        test[2] = 'A';  // 문자열은"" 문자는 ''
        char asdf[] = {'A','B','C'};
        //위는 한 자씩 이므로 String 으로 바꾸고 싶은경우 String c = "ABC";

        String testStr = new String(asdf);
        System.out.println(testStr);    // 결과: ABC

        int[] b = new int[3];
        System.out.println(b.length);
    }
}
