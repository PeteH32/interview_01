package com.example.productlist.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private CustomerOrderRepository customerOrderRepository;

    @Captor
    private ArgumentCaptor<Sort> sortCaptor;

    @Test
    void findAllRequestsOrdersInAscendingOrderIdOrder() {
        when(customerOrderRepository.findAll(any(Sort.class))).thenReturn(List.of());

        new OrderService(customerOrderRepository).findAll();

        verify(customerOrderRepository).findAll(sortCaptor.capture());
        assertThat(sortCaptor.getValue().getOrderFor("orderId").getDirection()).isEqualTo(Sort.Direction.ASC);
    }
}
