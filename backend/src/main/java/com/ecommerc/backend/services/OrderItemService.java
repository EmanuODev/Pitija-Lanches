package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.order_item.OrderItemCreateDTO;
import com.ecommerc.backend.dtos.order_item.OrderItemResponseDTO;
import com.ecommerc.backend.dtos.order_item.OrderItensShowDTO;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.OrdersItens;
import com.ecommerc.backend.entites.Products;
import com.ecommerc.backend.exceptions.ResponseExceptionDTO;
import com.ecommerc.backend.mappers.OrderItemMapper;
import com.ecommerc.backend.repository.OrdersItensRepository;
import com.ecommerc.backend.repository.OrdersRepository;
import com.ecommerc.backend.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrdersItensRepository ordersItensRepository;
    private final OrdersRepository ordersRepository;
    private final ProductsRepository productsRepository;


    public OrderItemResponseDTO saveOrderItem(OrderItemCreateDTO orderItemDTO, long order_id, long product_id){

        Orders order = ordersRepository.findById(order_id).orElseThrow(() -> new ResponseExceptionDTO("Order not found"));
        Products product = productsRepository.findById(product_id).orElseThrow(() -> new ResponseExceptionDTO("Product not found"));

        float price_product = productsRepository.findPriceById(product_id).orElseThrow(() -> new ResponseExceptionDTO("Product not found"));

        OrdersItens orderItem = OrderItemMapper.toEntity(orderItemDTO, order, product);

        float subtotal =  price_product * orderItem.getQuantity();

        orderItem.setSubtotal(subtotal);

        return OrderItemMapper.toDTO(ordersItensRepository.save(orderItem));

    }

    public List<OrderItemResponseDTO> showOrderItensByOrder(long order_id) {

        return ordersItensRepository.findOrdersItensByOrder(order_id).stream().map(OrderItemMapper :: toDTO).toList();

    }



}
