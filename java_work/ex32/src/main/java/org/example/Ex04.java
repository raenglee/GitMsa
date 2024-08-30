package org.example;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Ex04 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime f1 = LocalDateTime.of(2025,1,25,11,20);
        LocalDateTime f2 = LocalDateTime.of(2025,1,30,8,20);

        //오늘과(2024-08-30) 1월25일 날짜 차이
        Period period = Period.between(localDateTime.toLocalDate(),f1.toLocalDate());
        System.out.println(period);

        //f1(01-25 11:20) f2(01-30 08:20) 시간 차이
        Duration duration = Duration.between(f1.toLocalTime(),f2.toLocalTime());
        System.out.println(duration);

    }
}
