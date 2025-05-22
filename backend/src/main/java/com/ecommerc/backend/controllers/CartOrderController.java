package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.MessageDTO;
import com.ecommerc.backend.services.CartOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart_order")
public class CartOrderController {

    private final CartOrderService cartOrderService;

    @PostMapping("/{user_id}/{payment_method}")
    public ResponseEntity<MessageDTO> createOrderDeleteCart(@PathVariable long user_id, @PathVariable int payment_method){
        return new ResponseEntity<>(cartOrderService.createOrderDeleteCart(user_id, payment_method), HttpStatus.CREATED);
    }


}
