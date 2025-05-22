package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.ProductCreateDTO;
import com.ecommerc.backend.dtos.ProductResponseDTO;
import com.ecommerc.backend.entites.Products;
import com.ecommerc.backend.mappers.ProductMapper;
import com.ecommerc.backend.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductsRepository productsRepository;

    public ProductResponseDTO saveProduct(ProductCreateDTO productDTO) {

        Products product = ProductMapper.toEntity(productDTO);

        return ProductMapper.toDTO(productsRepository.save(product));

    }


}
