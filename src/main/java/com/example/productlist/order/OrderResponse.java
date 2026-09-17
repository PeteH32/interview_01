package com.example.productlist.order;

public record OrderResponse(
        Long id,
        String name
) {

    static OrderResponse from(Order product) {
        return new OrderResponse(product.getId(), product.getName());
    }
}

