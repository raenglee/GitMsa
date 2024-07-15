import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        int num[][] = new int[4][3];

        System.out.println(num.length);
        System.out.println(num[0].length);
        System.out.println(num[1].length);
        System.out.println(num[2].length);
        System.out.println(num[3].length);
        //System.out.println(num[4].length);

//        num[0][0] = 1;
//        num[0][1] = 2;
//        num[0][2] = 3; 다 적을수 없으니 for구문으로 적기

        int a = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                num[i][j] = a++;    // 0부터 넣으려면 변수 int a = 0  해주기
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(num[0]));    //포구문 아니고 하나씩 출력하는법(외우는거)
        System.out.println(Arrays.toString(num[1]));
        System.out.println(Arrays.toString(num[2]));
        System.out.println(Arrays.toString(num[3]));

        Arrays.fill(num[0],20);
        System.out.println(Arrays.toString(num[0]));    //2차원 배열에선 num[0]아닐땐 오류남
        System.out.println(Arrays.toString(num[1]));    //1차원 배열에서만 사용 가능
        System.out.println(Arrays.toString(num[2]));
        System.out.println(Arrays.toString(num[3]));

    }
}