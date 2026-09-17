package com.example.productlist.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public record OrderResponse(
        @JsonProperty("order_id") Long orderId,
        @JsonProperty("order_date") LocalDate orderDate,
        @JsonProperty("order_value") BigDecimal orderValue,
        @JsonProperty("order_details") List<OrderDetailResponse> orderDetails) {

    static OrderResponse from(CustomerOrder order) {
        List<OrderDetailResponse> details = order.getOrderDetails().stream()
                .sorted(Comparator.comparing(detail -> detail.getProduct().getId()))
                .map(OrderDetailResponse::from)
                .toList();
        return new OrderResponse(order.getOrderId(), order.getOrderDate(), order.getOrderValue(), details);
    }
}

