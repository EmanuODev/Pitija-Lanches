package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.OrderItemCreateDTO;
import com.ecommerc.backend.dtos.OrderItemResponseDTO;
import com.ecommerc.backend.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order_item")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping("/{order_id}/{product_id}")
    public ResponseEntity<OrderItemResponseDTO> createOrderItem(@RequestBody OrderItemCreateDTO orderItemDTO, @PathVariable long order_id, @PathVariable long product_id){
        return new ResponseEntity<>(orderItemService.saveOrderItem(orderItemDTO, order_id, product_id), HttpStatus.CREATED);
    }

}
