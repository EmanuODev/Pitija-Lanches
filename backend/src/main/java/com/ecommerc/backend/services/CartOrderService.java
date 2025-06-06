package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.*;
import com.ecommerc.backend.dtos.cart.CartJsonDTO;
import com.ecommerc.backend.dtos.cart.CartShowDTO;
import com.ecommerc.backend.dtos.order.OrderCreateDTO;
import com.ecommerc.backend.dtos.order.OrderResponseDTO;
import com.ecommerc.backend.dtos.order_item.OrderItemCreateDTO;
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

        if(payment_method_id < 0 || payment_method_id > 2)
            return new MessageDTO("Payment_method_id está fora do range");

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
