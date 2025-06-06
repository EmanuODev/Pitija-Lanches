package com.ecommerc.backend.dtos;

public record CartResponseDTO(
        long id,
        UserResponseDTO user,
        ProductResponseDTO item,
        int quantity,
        float subtotal
) { }
