public class Ex02 {

    public static void main(String[] args) {

        String a = "abcd";
        String b = "java";
        String c = "system";

        System.out.println(a.length());
        System.out.println(b.length());
        System.out.println(c.length());

        System.out.println("모든 문자열 길이 = " + (a.length() + b.length() + c.length()));    //길이의값 구하기

        //문자 배열
        char[] chars = new char[3];

        //문자열 배열
        String[] str = new String[3];    //배열로 구하기
        str[0] = "abcd";
        str[1] = "java";
        str[2] = "system";

        System.out.println(str[0].length() + str[1].length() + str[2].length());

        // 배열의 길이는 length
        // 스트링의 길이는 length(), charAt(0), split, subString, toCharArray()
        int count = 0;
        for (int i = 0; i < str.length; i++) {
            System.out.println(i);
            System.out.println(str[i]);
            System.out.println(str[i].length());
            count = count + str[1].length();
        }

        System.out.println("모든 문자열 길이는 "+count);
    }
}