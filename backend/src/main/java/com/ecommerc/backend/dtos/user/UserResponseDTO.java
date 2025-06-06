package com.ecommerc.backend.dtos.user;

import com.ecommerc.backend.enuns.Roles;

public record UserResponseDTO(

        long id,
        String name,
        String email,
        String phone,
        Roles role

) { }
