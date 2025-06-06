package com.ecommerc.backend.mappers;

import com.ecommerc.backend.dtos.product.ProductCreateDTO;
import com.ecommerc.backend.dtos.product.ProductResponseDTO;
import com.ecommerc.backend.entites.Products;

public class ProductMapper {

    public static Products toEntity(ProductCreateDTO productDTO) {

        Products product = new Products();

        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setImage_url(productDTO.image_url());
        product.setCategory(productDTO.category());
        product.setPrice(productDTO.price());
        product.setStock(productDTO.stock());

        return product;

    }

    public static ProductResponseDTO toDTO(Products product) {

        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getImage_url(),
                product.getCategory(),
                product.getPrice(),
                product.getStock()
        );

    }

}
