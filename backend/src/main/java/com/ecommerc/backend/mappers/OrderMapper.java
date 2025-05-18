package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.OrderCreateDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.Users;

public class OrderMapper {

    public Orders toEntity(OrderCreateDTO orderDTO, Users user) {

        Orders order = new Orders();

        order.setUser(user);
        order.setTotal_price(orderDTO.total_price());
        order.setStatus(orderDTO.status());
        order.setPayment_method(orderDTO.payment_method());

        return order;

    }


}
