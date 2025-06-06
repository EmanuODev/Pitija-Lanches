package com.ecommerc.backend.dtos.order;

import com.ecommerc.backend.dtos.user.UserResponseDTO;
import com.ecommerc.backend.enuns.PaymentMethod;
import com.ecommerc.backend.enuns.StatusOrders;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public record OrderResponseDTO(

        long id,
        @JsonIgnore UserResponseDTO user,
        float total_price,
        StatusOrders status,
        PaymentMethod payment_method,
        LocalDateTime created_at,
        LocalDateTime updated_at

) { }
