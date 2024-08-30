package org.example;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ex05 {
    public static void main(String[] args) {

        ZoneId.getAvailableZoneIds()
                .stream()
                .sorted();
//                .filter(s->s.contains("Europe"))
//                .forEach(System.out::println);

        //한국 시간 가져오기
        ZonedDateTime korea = ZonedDateTime.now();
        System.out.println(korea);

        ZonedDateTime paris = ZonedDateTime.of(
                korea.toLocalDateTime(),
                ZoneId.of("Europe/Paris")
        );
        System.out.println(paris);

        Duration 시차 = Duration.between(korea, paris);
        System.out.println(시차);
    }
}
