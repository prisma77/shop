package com.multi.shop.domain;

import lombok.Data;

@Data
public class CartItem {
    private Long id;
    private String sessionId;
    private Long productId;
    private Integer quantity;
    private Integer unitPrice;
}

