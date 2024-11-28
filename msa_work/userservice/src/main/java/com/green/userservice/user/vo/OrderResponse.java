package com.green.userservice.user.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderResponse {

    private String productId;
    private Integer qty;
    private Integer unitPrice;
    private Integer totalPrice;
    private String userId;
    private String orderId;
    private Date createdAt;

}
