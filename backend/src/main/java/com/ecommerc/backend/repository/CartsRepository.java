package com.ecommerc.backend.repository;

import com.ecommerc.backend.dtos.CartShowDTO;
import com.ecommerc.backend.entites.Carts;
import com.ecommerc.backend.entites.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartsRepository extends JpaRepository<Carts, Long> {

    @Query(value = ("SELECT * FROM carts WHERE user_id = :user_id"), nativeQuery = true)
    List<Carts> findAllCartsById(long user_id);

    @Transactional
    @Modifying
    @Query(value = ("DELETE FROM carts WHERE user_id = :user_id"), nativeQuery = true)
    void deleteAllById(long user_id);

}
