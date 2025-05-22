package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.UserCreateDTO;
import com.ecommerc.backend.dtos.UserResponseDTO;
import com.ecommerc.backend.entites.Users;
import com.ecommerc.backend.enuns.Roles;
import com.ecommerc.backend.mappers.UserMapper;
import com.ecommerc.backend.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UsersRepository userRepository;

    public UserResponseDTO saveUser(UserCreateDTO userDTO) {

        Users user = UserMapper.toEntity(userDTO);

        if(userRepository.countUsers() == 0)
            user.setRole(Roles.ADMIN);
        else
            user.setRole(Roles.USER);

        return UserMapper.toDTO(userRepository.save(user));

    }

}
