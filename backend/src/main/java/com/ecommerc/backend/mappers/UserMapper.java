package com.ecommerc.backend.mappers;


import com.ecommerc.backend.dtos.UserCreateDTO;
import com.ecommerc.backend.dtos.UserResponseDTO;
import com.ecommerc.backend.entites.Users;

public class UserMapper {

    public static Users toEntity(UserCreateDTO userDTO) {

        Users user = new Users();

        user.setName(userDTO.name());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setPhone(userDTO.phone());

        return user;

    }

    public static UserResponseDTO toDTO(Users user) {

        return new UserResponseDTO(user.getId(), user.getName(), user.getEmail(), user.getPhone(), user.getRole());

    }

}
