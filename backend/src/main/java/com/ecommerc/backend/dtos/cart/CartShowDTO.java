package com.ecommerc.backend.dtos.cart;

import com.ecommerc.backend.dtos.product.ProductResponseDTO;

public record CartShowDTO(
    long id,
    ProductResponseDTO item,
    int quantity,
    float subtotal
) { }
