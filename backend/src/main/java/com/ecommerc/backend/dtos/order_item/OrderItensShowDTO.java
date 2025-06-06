package com.ecommerc.backend.dtos.order_item;

import com.ecommerc.backend.dtos.order.OrderResponseDTO;

import java.util.List;

public record OrderItensShowDTO(
    OrderResponseDTO order,
    List<OrderItemResponseDTO> itens,
    int qtd_itens
) { }
