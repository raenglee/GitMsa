package com.green.userservice.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;

    private String email;

    private String userId;

    private String name;

    private String password;

    private List<OrderResponse> orderResponses;
}
