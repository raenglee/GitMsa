package com.pmh.ex03.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/*
@Configuration -> 객체 담는 통 정의
@Bean -> 객체
@Component -> 객체
@ComponentScan -> 패키지 내용 읽어서 객체 주입
@Autowired -> new 예약어 안쓰고 객체 할당
private final -> @RequiredArgsConstructor -> 객체 자동 할당

@Entity -> 테이블 할당
@Table -> 테이블 이름 변경
@Id -> Primary key 지정
*/

@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement 설정
    private Long idx;

    private String name;
    private int age;
    private String email;
    private String password;
    private LocalDateTime wdate;

    //JPA CLASS -> table CREATE가 됨.
}
