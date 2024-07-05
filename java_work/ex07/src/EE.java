public class EE {

    public static void main(String[] args) {

        int i = 0;
        double j = 0;

        // for (; i < 10 && j < 5; ) {
        // i++ = i=i+1  // i=i+1, j++ 의 위치 어디든 상관없음

            while (i<10 && j<5){  // for 안에 조건만 있으면 조건만 있는건 while이므로 바꿔도 됨

            i = i + 1;
            j = j + 2;

            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }
    }
}
