package com.ecommerc.backend.controllers;

import com.ecommerc.backend.dtos.product.ProductCreateDTO;
import com.ecommerc.backend.dtos.product.ProductReponseJsonDTO;
import com.ecommerc.backend.dtos.product.ProductJsonDTO;
import com.ecommerc.backend.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductReponseJsonDTO> createProduct(@RequestBody ProductCreateDTO productDTO) {

        return new ResponseEntity<>(new ProductReponseJsonDTO(productService.saveProduct(productDTO), "Produto criado com sucesso!"), HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<ProductJsonDTO> showProductsByCategory(){

        return new ResponseEntity<>(productService.showProductsByCategory(), HttpStatus.OK);

    }


}
