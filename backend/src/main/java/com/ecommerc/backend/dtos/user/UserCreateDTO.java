package com.ecommerc.backend.dtos;

public record UserCreateDTO(
        String name,
        String email,
        String password,
        String phone
) { }
