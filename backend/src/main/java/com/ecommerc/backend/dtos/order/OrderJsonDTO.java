package com.ecommerc.backend.dtos.order;

import com.ecommerc.backend.dtos.MessageDTO;
import com.ecommerc.backend.dtos.order_item.OrderItensShowDTO;
import com.ecommerc.backend.dtos.user.UserResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public record OrderJsonDTO(
    UserResponseDTO user,
    List<OrderItensShowDTO> orders,
    String message
) { }
