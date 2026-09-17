package com.example.productlist.order;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final CustomerOrderRepository customerOrderRepository;

    public OrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return customerOrderRepository.findAll(Sort.by(Sort.Direction.ASC, "orderId"))
                .stream()
                .map(OrderResponse::from)
                .toList();
    }
}

