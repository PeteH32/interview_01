package com.example.productlist.order;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository productRepository;

    public OrderService(OrderRepository orderRepository) {
        this.productRepository = orderRepository;
    }

    public List<OrderResponse> findAll() {
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(OrderResponse::from)
                .toList();
    }

}

