package aa;

import java.util.Scanner;

public class CalSecond {

    //초를 입력받는 함수
    public int inputNumber() {
        System.out.println("초입력 ");
        Scanner scanner = new Scanner(System.in);
        int result = scanner.nextInt();
        return result;
    }


    //void는 리턴값이없다 int 적으면 int를 리턴받는다

    //int를 넘겨주면 string을 반환하는 함수
    //216747 -> 6시간 27초
    public String calculate(int second) {
        int hour = second / 3600;
        int min = (second % 3600) / 60;
        int sec = (second % 3600) % 60;
        return hour + "시간" + min + "분" + sec + "초";
    }
    //1시간 3600초 60*60
    //1분 60초

//    toString은 생략되어있다
//    public  String toString(){
//        return "3b07329";
//    }

}
