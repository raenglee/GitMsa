package com.green.catalogservice.catalog.vo;

import lombok.Data;

import java.util.Date;

@Data
public class CatalogResponse {

    private Long id;
    private String productId;
    private String productName;
    private int stock;
    private Date createdAt;

}
