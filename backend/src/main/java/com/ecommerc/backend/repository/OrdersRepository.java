package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {



}
