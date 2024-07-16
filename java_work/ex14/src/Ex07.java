import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class AA {
    public static BB bb = new BB();
}

class BB {
    public void doA() {
        System.out.println("BB doA");
    }
}

public class Ex07 {

    public static void main(String[] args) {
//        AA.bb.doA();

        LocalDate localDate = LocalDate.now();    //now는 스태틱함수
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }
}
