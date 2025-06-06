package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.order.OrderCreateDTO;
import com.ecommerc.backend.dtos.order.OrderJsonDTO;
import com.ecommerc.backend.dtos.order.OrderResponseDTO;
import com.ecommerc.backend.dtos.order_item.OrderItemResponseDTO;
import com.ecommerc.backend.dtos.order_item.OrderItensShowDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.OrdersItens;
import com.ecommerc.backend.entites.Users;
import com.ecommerc.backend.exceptions.ResponseExceptionDTO;
import com.ecommerc.backend.mappers.OrderMapper;
import com.ecommerc.backend.mappers.UserMapper;
import com.ecommerc.backend.repository.OrdersItensRepository;
import com.ecommerc.backend.repository.OrdersRepository;
import com.ecommerc.backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrdersRepository orderRepository;
    private final UsersRepository userRepository;
    private final OrderItemService orderItemService;
    private final OrdersItensRepository ordersItensRepository;

    public OrderResponseDTO saveOrder(OrderCreateDTO orderDTO) {

        Users user = userRepository.findById(orderDTO.user_id()).orElseThrow(() -> new ResponseExceptionDTO("User not found"));

        Orders order = OrderMapper.toEntity(orderDTO, user);

        return OrderMapper.toDTO(orderRepository.save(order));

    }

    public OrderJsonDTO showOrderByUser(long user_id) {

        Users user = userRepository.findById(user_id).orElseThrow(() -> new ResponseExceptionDTO("User not found"));

        List<OrderResponseDTO> orders = orderRepository.findOrdersByUserId(user_id).stream().map(OrderMapper :: toDTO).toList();

        List<OrderItensShowDTO> ordersResponse = new ArrayList<>();

        for ( OrderResponseDTO order : orders ) {

            List<OrderItemResponseDTO> orderItem = orderItemService.showOrderItensByOrder(order.id());

            ordersResponse.add(new OrderItensShowDTO(order, orderItem, ordersItensRepository.countOrdersItensByOrder(order.id())));

        }

        return new OrderJsonDTO(UserMapper.toDTO(user), ordersResponse, "Pedidos buscados com sucesso!");

    }


}
