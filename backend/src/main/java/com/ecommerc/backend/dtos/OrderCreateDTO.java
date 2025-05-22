package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.PaymentMethod;
import com.ecommerc.backend.enuns.StatusOrders;

public record OrderCreateDTO(
        long user_id,
        PaymentMethod payment_method
) { }

