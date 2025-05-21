package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.CartCreateDTO;
import com.ecommerc.backend.dtos.CartResponseDTO;
import com.ecommerc.backend.entites.Carts;
import com.ecommerc.backend.entites.Products;
import com.ecommerc.backend.entites.Users;
import com.ecommerc.backend.mappers.CartMapper;
import com.ecommerc.backend.repository.CartsRepository;
import com.ecommerc.backend.repository.ProductsRepository;
import com.ecommerc.backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartService {

    private final ProductsRepository productsRepository;
    private final UsersRepository usersRepository;
    private final CartsRepository cartsRepository;

    public CartResponseDTO saveCart(CartCreateDTO cartDTO, long user_id, long product_id){

        Users user = usersRepository.findById(user_id).orElseThrow(() -> new RuntimeException("User not found"));
        Products product = productsRepository.findById(product_id).orElseThrow(() -> new RuntimeException("Procuct not found"));

        float price = productsRepository.findPriceById(product_id).orElseThrow(() -> new RuntimeException("Product not found"));

        Carts cart = CartMapper.toEntity(cartDTO, user, product);

        float subtotal = price * cart.getQuantity();

        cart.setSubtotal(subtotal);

        return CartMapper.toDTO(cartsRepository.save(cart));

    }

}
