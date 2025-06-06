package com.ecommerc.backend.services;

import com.ecommerc.backend.dtos.product.ProductCreateDTO;
import com.ecommerc.backend.dtos.product.ProductJsonDTO;
import com.ecommerc.backend.dtos.product.ProductResponseDTO;
import com.ecommerc.backend.entites.Products;
import com.ecommerc.backend.enuns.ProductCategory;
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

    public ProductJsonDTO showProductsByCategory() {

        return new ProductJsonDTO(
                productsRepository.findProductsByCategory(ProductCategory.HAMBURGER).stream().map(ProductMapper :: toDTO).toList(),
                productsRepository.findProductsByCategory(ProductCategory.SALTY).stream().map(ProductMapper :: toDTO).toList(),
                productsRepository.findProductsByCategory(ProductCategory.SUGARY).stream().map(ProductMapper :: toDTO).toList(),
                productsRepository.findProductsByCategory(ProductCategory.DRINKS).stream().map(ProductMapper :: toDTO).toList(),
                ("Products searched successfully")
        );

    }


}
