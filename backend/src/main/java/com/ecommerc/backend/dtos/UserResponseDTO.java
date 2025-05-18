package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.Roles;

public record UserResponseDTO(

        long id,
        String name,
        String email,
        String phone,
        Roles role

) { }
