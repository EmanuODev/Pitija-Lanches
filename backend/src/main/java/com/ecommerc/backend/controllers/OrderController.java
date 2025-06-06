package com.ecommerc.backend.controllers;


import com.ecommerc.backend.dtos.order.OrderCreateDTO;
import com.ecommerc.backend.dtos.order.OrderJsonDTO;
import com.ecommerc.backend.dtos.order.OrderResponseDTO;
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

    @GetMapping("/all/{user_id}")
    public ResponseEntity<OrderJsonDTO> showOrdersByUserId(@PathVariable long user_id) {
        return new ResponseEntity<>(orderService.showOrderByUser(user_id), HttpStatus.OK);
    }

}
