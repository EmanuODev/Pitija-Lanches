package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.CartCreateDTO;
import com.ecommerc.backend.dtos.CartResponseDTO;
import com.ecommerc.backend.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/{user_id}/{product_id}")
    public ResponseEntity<CartResponseDTO> createCart(@RequestBody CartCreateDTO cartDTO, @PathVariable long user_id, @PathVariable long product_id){
        return new ResponseEntity<>(cartService.saveCart(cartDTO, user_id, product_id), HttpStatus.CREATED);
    }

}
