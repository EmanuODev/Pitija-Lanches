package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Orders;
import com.ecommerc.backend.entites.OrdersItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersItensRepository extends JpaRepository<OrdersItens, Long> {

    @Query(value = ("SELECT * FROM orders_itens WHERE order_id = :order_id"), nativeQuery = true)
    List<OrdersItens> findOrdersItensByOrder(long order_id);

    @Query(value = ("SELECT COUNT(*) FROM orders_itens WHERE order_id = :order_id"), nativeQuery = true)
    int countOrdersItensByOrder(long order_id);

}