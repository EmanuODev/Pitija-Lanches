package com.ecommerc.backend.dtos;

public record OrderItemResponseDTO(
        long id,
        OrderResponseDTO order,
        ProductResponseDTO item,
        int quantity,
        float subtotal
) { }
