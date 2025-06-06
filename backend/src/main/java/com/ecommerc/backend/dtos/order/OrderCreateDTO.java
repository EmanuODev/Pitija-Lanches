package com.ecommerc.backend.dtos.order;

import com.ecommerc.backend.enuns.PaymentMethod;

public record OrderCreateDTO(
        long user_id,
        PaymentMethod payment_method
) { }

