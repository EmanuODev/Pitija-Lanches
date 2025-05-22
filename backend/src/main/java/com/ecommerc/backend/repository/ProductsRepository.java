package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query(value = ("SELECT price FROM products WHERE id = :product_id"), nativeQuery = true)
    Optional<Float> findPriceById(long product_id);

}
