public class CC {

    public static int add() {
        System.out.println("기본 add");
        return 10;
    }

    public static int add(int num) {               //같은 매서드 호출은 안되지만 int num 추가로 가능해짐
        System.out.println(num + " add");
        return 10;
    }

    public static void main(String[] args) {
//        int result = add();
//        System.out.println("result = " + result);

        System.out.println("result = " + add());       //보내는게 없으니까 add()로 출력
        System.out.println("result = " + add(5));     //5를 보내므로 add(int num)으로 출력
    }
}
