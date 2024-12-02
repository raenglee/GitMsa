package com.green.catalogservice.catalog.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
public class CatalogRequest {

    private Long id;
    private String productId;
    private String productName;
    private int stock;
    private Date createdAt;

}
