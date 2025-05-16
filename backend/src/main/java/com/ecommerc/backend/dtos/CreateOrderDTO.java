package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.PaymentMethod;
import com.ecommerc.backend.enuns.StatusOrders;

public record CreateOrderDTO(
        long user_id,
        float total_price,
        StatusOrders status,
        PaymentMethod payment_method
) { }

