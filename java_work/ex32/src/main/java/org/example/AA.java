package org.example;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
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

}
