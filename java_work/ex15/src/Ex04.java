public class Ex04 {

    public static void main(String[] args) {
        String str1 = "String";
        String str2 = "new String";

//        System.out.println(str1);
//        System.out.println(str1.length());
//        System.out.println();
//
//        System.out.println(str2);
//        System.out.println(str2.length());
//        System.out.println();
        showString(str1);
        showString(str2);
        showString("Funny String");
    }

    public static void showString(String str) {
        System.out.println(str);
        System.out.println(str.length());
        System.out.println();
    }
}