package com.ecommerc.backend.dtos;

import java.util.List;

public record OrderShowDTO(
    OrderResponseDTO order,
    List<OrderItemResponseDTO> itens
) { }
