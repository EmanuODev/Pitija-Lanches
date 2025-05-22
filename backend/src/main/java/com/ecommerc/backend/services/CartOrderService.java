package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.*;
import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.enuns.PaymentMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartOrderService {

    private final CartService cartService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;

    public MessageDTO createOrderDeleteCart(long user_id, int payment_method_id){


        CartJsonDTO cartJson = cartService.showCartById(user_id);

        if(cartJson.cart().isEmpty())
            return new MessageDTO("O carrinho está vázio");

        PaymentMethod payment_method = payment_method_id == 0 ? PaymentMethod.PIX : payment_method_id == 1 ? PaymentMethod.DEBIT : PaymentMethod.CREDIT;

        OrderResponseDTO orderDTO = orderService.saveOrder(new OrderCreateDTO(user_id, payment_method));

        List<CartShowDTO> carts = cartJson.cart();

        for (CartShowDTO cart : carts) {

            orderItemService.saveOrderItem(new OrderItemCreateDTO(cart.quantity()),
                    orderDTO.id(),
                    cart.item().id());

        }

        cartService.emptyCart(user_id);

        return new MessageDTO("Pedido criado com sucesso!");

    }


}
