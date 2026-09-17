package com.example.productlist.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public record OrderDetailResponse(
        @JsonProperty("order_id") Long orderId,
        @JsonProperty("product") OrderProductResponse product,
        @JsonProperty("item_price") BigDecimal itemPrice,
        @JsonProperty("item_quantity") Integer itemQuantity) {

    static OrderDetailResponse from(OrderDetail detail) {
        return new OrderDetailResponse(
                detail.getOrder().getOrderId(),
                OrderProductResponse.from(detail.getProduct()),
                detail.getItemPrice(),
                detail.getItemQuantity());
    }
}

