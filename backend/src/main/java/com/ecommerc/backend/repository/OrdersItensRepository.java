package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.OrdersItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItensRepository extends JpaRepository<OrdersItens, Long> {



}