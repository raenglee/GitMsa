/*
2. Math.random을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하여라
(1)에 알맞은 코드를 넣으세요

다 풀면 문제를 함수로 바꿔보기
*/

public class HH {

    public static void main(String[] args) {

        int value = ((int) (Math.random() * 6)+1);

//            (double result = Math.random() * 6) + 1;
//            System.out.println((int)result);

        System.out.println("value = " + value);
    }
}


// 0 < value < 1
// 0.00000 < value < 6.666666
// 1.00000 < value < 7.666666

