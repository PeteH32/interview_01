package com.example.productlist.order;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {

    @Override
    @EntityGraph(attributePaths = {"orderDetails", "orderDetails.product"})
    List<CustomerOrder> findAll(Sort sort);
}

