package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    @Query(value = ("SELECT * FROM orders WHERE user_id = :user_id"), nativeQuery = true)
    List<Orders> findOrdersByUserId(long user_id);

}
