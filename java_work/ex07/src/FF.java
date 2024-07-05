public class FF {

    public static void main(String[] args) {
        System.out.println();

        // 0 < result < 1
        // 0.0000001 <= resutl <= 0.99999
        // 0.0000100 <= result <= 99.99999
        // 3.00001 <=result <= 102.999999
        // int 형변환하면
        // 3 <= result <=120

        for (int i = 0; i < 7; i++) {
            double result = Math.random() * 100 + 3;      // 0.0~1.0 사이에서 값이 랜덤으로 나옴(다른자리수 만드려면 *1nn 해줘야함)

            System.out.println((int) result);       //int를 결과값에 붙여줘야지 소수점이 안나옴
        }
    }
}