package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.OrderResponse;
import com.green.orderservice.order.vo.OrderRequest;


public interface OrderService {
    OrderResponse join(OrderRequest orderRequest);
    OrderResponse login(String email, String password);
}
