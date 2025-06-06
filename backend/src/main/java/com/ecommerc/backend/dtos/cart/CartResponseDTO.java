package com.ecommerc.backend.dtos.cart;

import com.ecommerc.backend.dtos.product.ProductResponseDTO;
import com.ecommerc.backend.dtos.user.UserResponseDTO;

public record CartResponseDTO(
        long id,
        UserResponseDTO user,
        ProductResponseDTO item,
        int quantity,
        float subtotal
) { }
