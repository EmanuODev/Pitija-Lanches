package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.CreateOrderDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.Users;

public class OrderMapper {

    public Orders toEntity(CreateOrderDTO orderDTO) {

        Orders order = new Orders();

        order.setUser();

    }


}
