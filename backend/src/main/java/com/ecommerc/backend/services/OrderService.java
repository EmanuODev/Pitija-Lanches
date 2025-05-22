package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.OrderCreateDTO;
import com.ecommerc.backend.dtos.OrderResponseDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.Users;
import com.ecommerc.backend.enuns.StatusOrders;
import com.ecommerc.backend.mappers.OrderMapper;
import com.ecommerc.backend.repository.OrdersRepository;
import com.ecommerc.backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrdersRepository orderRepository;
    private final UsersRepository userRepository;

    public OrderResponseDTO saveOrder(OrderCreateDTO orderDTO) {

        Users user = userRepository.findById(orderDTO.user_id()).orElseThrow(() -> new RuntimeException("User not found"));

        Orders order = OrderMapper.toEntity(orderDTO, user);

        return OrderMapper.toDTO(orderRepository.save(order));

    }


}
