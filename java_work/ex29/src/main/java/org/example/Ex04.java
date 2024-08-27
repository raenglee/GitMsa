package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ex04 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6)
                .filter(n -> n % 2 == 1)
                .forEach(s -> System.out.println("숫자: " + s));

        List<Member> list = Arrays.asList(
                new Member(1, "홍길동", 20, "aaa@naver.com", "password"),
                new Member(2, "이길동", 30, "bbb@naver.com", "password"),
                new Member(3, "강길동", 40, "ccc@naver.com", "password")
        );

        //나이 총 합
        int result = 0;
        for (Member member : list) {
            result += member.getAge();
            System.out.println(member);
        }
        System.out.println("나이의 최종 합 = " + result);

        //스트림으로 나이 총 합
        result = list.stream()
                .mapToInt(s -> s.getAge())
                .sum();

        System.out.println("나이의 최종 합 = "+result);

        //30 이상인 사람 출력
        list.stream()
                .filter(member -> member.getAge() >= 30)
                .forEach(s -> {  // 2줄로 적을땐 {}중괄호 필요, 한줄이면 필요없음
                    System.out.print("내용: ");
                    System.out.println(s);
                });

        System.out.println();

        list.stream()
                .filter(m->m.getAge()>=30)
                .forEach(member-> System.out.println(member));

        System.out.println();
        //나이만 출력 mapToInt로 중간연산, forEach로 최종연산
        list.stream()
                .filter(m->m.getAge()>=30)
                .mapToInt(m->m.getAge())
                .forEach(age-> System.out.println(age));
    }
}
