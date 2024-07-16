/*
3. 다음은 answer 배열 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 ‘*’을 찍어서
    그래프를 그리는 프로그램이다 에 알맞은 코드를 넣어서 완성하시오 .
    int[] answer = { 1,4,4,3,1,4,4,2,1,3,2}
    실행결과
    1***
    2**
    3**
    4****
 */

import java.util.Arrays;

public class Ex00 {

    Ex00() {
        int[] answer = {1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2};
        int[] counntNumber = {1, 2, 3, 4};
        int[] starNumber = new int[counntNumber.length];

        System.out.println(Arrays.toString(answer));
        doPrint(answer);

        for (int j = 0; j < counntNumber.length; j++) {
            for (int i = 0; i < answer.length; i++) {
                if(counntNumber[j]==answer[i]){
                        starNumber[j] = starNumber[j]+1;
                }
            }
        }
        System.out.println(Arrays.toString(starNumber));
        for (int i = 0; i < starNumber.length; i++) {
            System.out.print(i+" : ");
            for (int j = 0; j < starNumber[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void doPrint(int[] temp) {
        System.out.print("[");
        for (int i = 0; i < temp.length; i++) {
            if (temp.length == (i + 1)) {
                System.out.print(temp[i]);
            } else {
                System.out.print(temp[i] + ", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        new Ex00();
    }
}