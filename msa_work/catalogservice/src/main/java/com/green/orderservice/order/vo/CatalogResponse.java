package com.green.orderservice.order.vo;

import lombok.Data;

@Data
public class CatalogResponse {

    private String accessToken;
    private String refreshToken;
    private String userId;
    private String email;

}
