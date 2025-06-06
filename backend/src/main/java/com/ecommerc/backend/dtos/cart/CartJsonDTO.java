package com.ecommerc.backend.dtos.cart;

import com.ecommerc.backend.dtos.user.UserResponseDTO;

import java.util.List;

public record CartJsonDTO(
        UserResponseDTO user,
        List<CartShowDTO> cart,
        String message
) { }
