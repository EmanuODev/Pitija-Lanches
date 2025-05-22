package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.ProductCreateDTO;
import com.ecommerc.backend.dtos.ProductResponseDTO;
import com.ecommerc.backend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductCreateDTO productDTO) {

        return new ResponseEntity<>(productService.saveProduct(productDTO), HttpStatus.CREATED);

    }

}
