public class Ex04 {
// ㄴ 기본 생성자 toString() 생략돼있음


    Ex04() {
        int ar[] = {10, 20, 30, 40, 50};
        doA(ar);
        int br[] = makaary(10);
        System.out.println("br.length = " + br.length);
    }

    public void doA(int[] qw) {
        int sum = 0;
        for (int i = 0; i < qw.length; i++) {
            sum = sum + qw[i];
        }
        System.out.println(sum);
    }

    public int[] makaary(int len) {
        return new int[len];
    }

    public static void main(String[] args) {
        new Ex04();    // toString은 생략돼있고 기본생성자인 Ex04를 호출한것
    }
}