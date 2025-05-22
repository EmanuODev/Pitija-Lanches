package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.UserCreateDTO;
import com.ecommerc.backend.dtos.UserResponseDTO;
import com.ecommerc.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userDTO) {

        return new ResponseEntity<>(userService.saveUser(userDTO), HttpStatus.CREATED);

    }

}
