package com.example.productlist.product;

import jakarta.validation.constraints.Size;

public record ProductRequest(
        @Size(max = 250) String name
    ) {
}

