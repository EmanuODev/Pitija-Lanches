package com.ecommerc.backend.controllers;


import com.ecommerc.backend.dtos.OrderCreateDTO;
import com.ecommerc.backend.dtos.OrderResponseDTO;
import com.ecommerc.backend.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderCreateDTO orderDTO){

        return new ResponseEntity<>(orderService.saveOrder(orderDTO), HttpStatus.CREATED);

    }

}
