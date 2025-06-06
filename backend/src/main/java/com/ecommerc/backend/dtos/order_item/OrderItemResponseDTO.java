package com.ecommerc.backend.dtos.order_item;

import com.ecommerc.backend.dtos.order.OrderResponseDTO;
import com.ecommerc.backend.dtos.product.ProductResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

public record OrderItemResponseDTO(
        long id,
        @JsonIgnore OrderResponseDTO order,
        ProductResponseDTO item,
        int quantity,
        float subtotal
) { }
