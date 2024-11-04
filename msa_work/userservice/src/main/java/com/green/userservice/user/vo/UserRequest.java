package com.green.userservice.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequest {

    @Schema(hidden=true)
    private Long id;

    @NotNull(message = "Email cannot be null")
    @Email
    @Schema(example = "aaa@naver.com")
    private String email;

    @Schema(hidden=true)
    private String userId;

    @Schema(example = "홍길동")
    private String name;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "password must be greater than 8")
    @Schema(example = "abcd1234")
    private String password;
}
