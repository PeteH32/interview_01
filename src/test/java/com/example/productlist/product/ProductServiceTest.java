package com.example.productlist.product;

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
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Captor
    private ArgumentCaptor<Sort> sortCaptor;

    @Test
    void findAllRequestsProductsInAscendingIdOrder() {
        Product first = new Product("First");
        Product second = new Product("Second");
        when(productRepository.findAll(any(Sort.class))).thenReturn(List.of(first, second));

        new ProductService(productRepository).findAll();

        verify(productRepository).findAll(sortCaptor.capture());
        assertThat(sortCaptor.getValue().getOrderFor("id").getDirection()).isEqualTo(Sort.Direction.ASC);
    }
}

