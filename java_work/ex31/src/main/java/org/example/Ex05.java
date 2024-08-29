package org.example;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex05 {

    public static void main(String[] args) {
        Stream<Person> ss = Stream.of(new Person(100, 90, 80),
                new Person(90, 80, 70),
                new Person(60, 70, 80));

//        ss.forEach(System.out::println);

        //세 사람의 점수를 가져와서 총합과 평균을 구하여라 for문을 써도 되지만 stream으로
        //flatMap을 쓰면 Person이라는 클래스가 들어오는데, 이것을 Int로 바꿔주어 flatMapToInt
        IntStream is = ss
                .flatMapToInt(person ->
                        IntStream.of(person.getEng(), person.getKor(), person.getMath())
                );

        System.out.println("total = " + is.sum());

        //한번 출력하고나면 스트림 닫겨있어서 새로 생성해줘야함
        ss = Stream.of(new Person(100, 90, 80),
                new Person(90, 80, 70),
                new Person(60, 70, 80));

        is = ss
                .flatMapToInt(person ->
                        IntStream.of(person.getEng(), person.getKor(), person.getMath())
                );

        double avg = is.average().orElse(0);
        System.out.println("avg = " + avg);
    }
}
