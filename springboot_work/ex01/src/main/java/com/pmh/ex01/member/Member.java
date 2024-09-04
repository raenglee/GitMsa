package com.pmh.ex01.member;


import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
//@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private int idx;
    private String name;
    private String email;
    private int age;
    private String password;
    private LocalDateTime regdate;
    private LocalDateTime mydate;

    @Override
    public String toString() {
        String temp = mydate==null? "" : DateTimeFormatter.ofPattern("yyyy/mm/dd").format(mydate);
        return "Member{" +
                "idx=" + idx +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", regdate=" + regdate +
                ", mydate=" + temp +
                '}';
    }
}
