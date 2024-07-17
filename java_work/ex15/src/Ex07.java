public class Ex07 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("asdf");
        sb.append("asdf");

        System.out.println(sb);

        sb.delete(0, 2);
        System.out.println(sb);

        sb.replace(0, 5, "kkk");
        System.out.println(sb);

        sb.append("asdf");
        sb.reverse();
        System.out.println(sb
        );
    }
}