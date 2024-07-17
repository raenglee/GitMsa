import java.util.Arrays;

/*
"He11oWor1d"	"lloWorl"	2	"HelloWorld"
"Program29b8UYP"	"merS123"	7	"ProgrammerS123"

 */
public class Ex02 {

    Ex02() {
        System.out.println("이리로 옴");
        String result = solution("He11oWor1d", "lloWorl", 2);
        System.out.println(result);
    }

    public static String solution(String my_string, String overwrite_string, int s) {
        String answer = "";

        char[] c_my_string = my_string.toCharArray();
        char[] c_overwrite_string = overwrite_string.toCharArray();

        System.out.println(Arrays.toString(c_my_string));
        System.out.println(Arrays.toString(c_overwrite_string));

        System.arraycopy(c_overwrite_string, 0,    //배열 초기화 복사
                c_my_string, s, overwrite_string.length());
        answer = new String(c_my_string);
        return answer;
    }

    public static void main(String[] args) {
        new Ex02();
    }
}