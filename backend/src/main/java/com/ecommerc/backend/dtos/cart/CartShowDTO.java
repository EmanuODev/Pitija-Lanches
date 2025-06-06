package com.ecommerc.backend.dtos;

import com.ecommerc.backend.entites.Products;

public record CartShowDTO(
    long id,
    ProductResponseDTO item,
    int quantity,
    float subtotal
) { }
