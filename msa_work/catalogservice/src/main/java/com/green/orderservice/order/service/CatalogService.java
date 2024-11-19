package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.CatalogResponse;
import com.green.orderservice.order.vo.CatalogRequest;


public interface CatalogService {
    CatalogResponse join(CatalogRequest catalogRequest);
    CatalogResponse login(String email, String password);
}
