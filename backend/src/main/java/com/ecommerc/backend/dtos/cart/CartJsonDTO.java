package com.ecommerc.backend.dtos;

import java.util.List;

public record CartJsonDTO(
        UserResponseDTO user,
        List<CartShowDTO> cart,
        String message
) { }
