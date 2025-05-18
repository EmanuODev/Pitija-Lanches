package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.PaymentMethod;
import com.ecommerc.backend.enuns.StatusOrders;

import java.time.LocalDateTime;

public record OrderResponseDTO(

        long id,
        UserResponseDTO user,
        float total_price,
        StatusOrders status,
        PaymentMethod payment_method,
        LocalDateTime created_at,
        LocalDateTime updated_at

) { }
