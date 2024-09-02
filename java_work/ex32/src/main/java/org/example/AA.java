package org.example;

import lombok.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
//@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AA {

    private int idx;
    private String name;
    private String email;
    private int age;
    private String password;
    private LocalDateTime regdate;
    private LocalDateTime mydate;

    @Override
    public String toString() {
        String temp = mydate==null?"":DateTimeFormatter.ofPattern("yyyy/mm/dd").format(mydate);
        return "AA{" +
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
