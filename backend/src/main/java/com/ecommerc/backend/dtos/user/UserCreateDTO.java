package com.ecommerc.backend.dtos.user;

public record UserCreateDTO(
        String name,
        String email,
        String password,
        String phone
) { }
