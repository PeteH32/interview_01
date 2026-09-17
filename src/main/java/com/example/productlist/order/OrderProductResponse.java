package com.example.productlist.order;

import com.example.productlist.product.Product;

public record OrderProductResponse(Long id, String name) {

    static OrderProductResponse from(Product product) {
        return new OrderProductResponse(product.getId(), product.getName());
    }
}

