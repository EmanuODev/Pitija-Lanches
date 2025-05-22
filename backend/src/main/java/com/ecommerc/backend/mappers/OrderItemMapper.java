package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.OrderItemCreateDTO;
import com.ecommerc.backend.dtos.OrderItemResponseDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.OrdersItens;
import com.ecommerc.backend.entites.Products;

public class OrderItemMapper {

    public static OrdersItens toEntity(OrderItemCreateDTO orderItemDTO, Orders order, Products item){

        OrdersItens orderItem = new OrdersItens();

        orderItem.setOrder(order);
        orderItem.setItem(item);
        orderItem.setQuantity(orderItemDTO.quantity());

        return orderItem;

    }

    public static OrderItemResponseDTO toDTO(OrdersItens orderItem){

        return new OrderItemResponseDTO(
                orderItem.getId(),
                OrderMapper.toDTO(orderItem.getOrder()),
                ProductMapper.toDTO(orderItem.getItem()),
                orderItem.getQuantity(),
                orderItem.getSubtotal()
        );

    }

}
