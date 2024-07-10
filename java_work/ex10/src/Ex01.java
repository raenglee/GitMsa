class A{}

public class Ex01 {
    public static void main(String[] args) {
        A a = new A();
        A b = a;

        System.out.println(a==b);

        //int double float
        //String 스트링은 클래스라서 대문자로 시작
        //String str1 = "happy"; 아래와 같음

        String str1 = new String("happy");
        String str2 = "happy";
        String str3 = "happy";

        System.out.println(str1 + " " + str2);
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }
}
