package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Carts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long> {


}
