package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.*;
import com.ecommerc.backend.entites.Carts;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/{user_id}/{product_id}")
    public ResponseEntity<CartResponseDTO> createCart(@RequestBody CartCreateDTO cartDTO, @PathVariable long user_id, @PathVariable long product_id){

        return new ResponseEntity<>(cartService.saveCart(cartDTO, user_id, product_id), HttpStatus.CREATED);

    }

    @DeleteMapping("/empty/{user_id}")
    public ResponseEntity<MessageDTO> emptyCart(@PathVariable long user_id){

        cartService.emptyCart(user_id);

        return new ResponseEntity<>(new MessageDTO("Cart emptied successfully"), HttpStatus.OK);

    }

    @GetMapping("/all/{user_id}")
    public ResponseEntity<CartJsonDTO> showCartById(@PathVariable long user_id){
        return new ResponseEntity<>(cartService.showCartById(user_id), HttpStatus.OK);
    }

}
