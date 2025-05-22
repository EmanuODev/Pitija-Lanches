package com.ecommerc.backend.repository;

import com.ecommerc.backend.entites.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query(value = ("SELECT COUNT(*) as count_users FROM users"), nativeQuery = true)
    long countUsers();

}
