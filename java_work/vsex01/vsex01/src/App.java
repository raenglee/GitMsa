public class App {

    public static void doA() {
        int sum = 0;
        for (int i = 0; i <= 20; i++) {
            // 2와 3의 배수가 아닌 수
            if (i % 2 != 0 && i % 3 != 0) {
                System.out.println(i);
                sum += i;
           }
        }
        System.out.println("sum = " + sum);
    }

    public static void main(String[] args) throws Exception {
        doA();
    }
}