package com.ecommerc.backend.dtos.order;

import com.ecommerc.backend.dtos.order_item.OrderItemResponseDTO;

import java.util.List;

public record OrderShowDTO(
    OrderResponseDTO order,
    List<OrderItemResponseDTO> itens
) { }
