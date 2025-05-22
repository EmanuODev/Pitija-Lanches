package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.OrderCreateDTO;
import com.ecommerc.backend.dtos.OrderResponseDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.Users;

public class OrderMapper {

    public static Orders toEntity(OrderCreateDTO orderDTO, Users user) {

        Orders order = new Orders();

        order.setUser(user);
        order.setPayment_method(orderDTO.payment_method());

        return order;

    }

    public static OrderResponseDTO toDTO(Orders order){

        return new OrderResponseDTO(order.getId(),
                                    UserMapper.toDTO(order.getUser()),
                                    order.getTotal_price(),
                                    order.getStatus(),
                                    order.getPayment_method(),
                                    order.getCreated_at(),
                                    order.getUpdated_at()
                                   );

    }


}
