/*
 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을때,
몇까지 더해야 총합이 100이상이 되는지 구하시오
 */

public class AA {
    public static void main(String[] args) {


        int sum = 0;
        for (int i = 0; i < 300; i++) {
            System.out.println("i=" + i);
            if (i % 2 == 0) {                 // 2로나눠서 0이면 = 짝수면
                sum = sum - i;               // 음수로
            } else {
                sum = sum + i;              // 2로나눠서 0이 아니라면 = 홀수면 양수로
            }
            System.out.println("중간 sum = " + sum);

            if(sum>100)
                break;                     // break -> while, for, switch 빠져나오기
        }                                  //for 구문은 중괄호를 만나면 조건(i<100;)끝나기까지 계속 for로 돌아감

        System.out.println(sum);
        }
    }