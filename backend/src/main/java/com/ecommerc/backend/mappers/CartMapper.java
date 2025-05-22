package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.CartCreateDTO;
import com.ecommerc.backend.dtos.CartResponseDTO;
import com.ecommerc.backend.dtos.CartShowDTO;
import com.ecommerc.backend.entites.Carts;
import com.ecommerc.backend.entites.Products;
import com.ecommerc.backend.entites.Users;

public class CartMapper {

    public static Carts toEntity(CartCreateDTO cartDTO, Users user, Products item){

        Carts cart = new Carts();

        cart.setUser(user);
        cart.setItem(item);
        cart.setQuantity(cartDTO.quantity());

        return cart;

    }

    public static CartResponseDTO toDTO(Carts cart){

        return new CartResponseDTO(
                cart.getId(),
                UserMapper.toDTO(cart.getUser()),
                ProductMapper.toDTO(cart.getItem()),
                cart.getQuantity(),
                cart.getSubtotal()
        );

    }

    public static CartShowDTO toShowDTO(Carts cart){

        return new CartShowDTO(
                cart.getId(),
                ProductMapper.toDTO(cart.getItem()),
                cart.getQuantity(),
                cart.getSubtotal()
        );

    }

}
