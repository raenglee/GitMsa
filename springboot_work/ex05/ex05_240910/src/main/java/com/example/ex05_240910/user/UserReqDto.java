package com.example.ex05_240910.user;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

//UserReqDto는 유효성을 검사, 밸리데이트

@Data
//프론트에서 오는 파라메타 검사
public class UserReqDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT 이거 설정해줘...
    private Long idx;

    @Length(min=2, max=100)
    private String name;

    @Min(0)@Max(130)
    private int age;

    @NotEmpty   //프론트로 데이터 넘길 때 값이 없으면 오류
    private String email;
    @NotEmpty
    private String password;

    private LocalDateTime wdate;

}
