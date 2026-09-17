package com.example.productlist.order;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService productService) {
        this.orderService = productService;
    }

    @GetMapping
    public List<OrderResponse> getOrder() {
        return orderService.findAll();
    }

}

