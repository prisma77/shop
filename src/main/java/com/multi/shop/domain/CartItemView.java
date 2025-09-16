package com.multi.shop.domain;

import lombok.Data;

@Data
public class CartItemView {
    private Long id;
    private String sessionId;
    private Long productId;
    private Integer quantity;
    private Integer unitPrice;

    // product fields
    private String productName;
    private Integer productPrice; // = unitPrice와 동일하지만 안전하게 따로 둠
    private String description;

    public int getLineTotal() {
        return unitPrice * quantity;
    }
}

