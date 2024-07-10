import aa.CalSecond;

/*
2. 프로그램 사용자로부터 초(second)를 입력받은 후에,
이를 [시, 분, 초]의 형태로 출력한느 프로그램을 작성해 보자.
 */

public class yesterDayExam {
    public static void main(String[] args) {
        CalSecond calSecond = new CalSecond();

        int retValue = calSecond.inputNumber();
        System.out.println(retValue);

        String resultValue = calSecond.calculate(retValue);
        System.out.println(resultValue);

//        System.out.println(calSecond.inputNumber());

//        CalSecond calSecond2 = new CalSecond();
//
//        System.out.println(calSecond);
//        System.out.println(calSecond2);
//    }
    }
}