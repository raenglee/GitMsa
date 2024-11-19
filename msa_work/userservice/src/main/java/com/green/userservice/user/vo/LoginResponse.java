package com.green.userservice.user.vo;

import lombok.Data;

@Data
public class LoginResponse {

    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;

}
