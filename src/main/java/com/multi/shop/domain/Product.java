package com.multi.shop.domain;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private String description;
}

