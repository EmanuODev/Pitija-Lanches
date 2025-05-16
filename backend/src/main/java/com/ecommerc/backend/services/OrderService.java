package com.ecommerc.backend.services;

import com.ecommerc.backend.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrdersRepository orderRepository;



}
