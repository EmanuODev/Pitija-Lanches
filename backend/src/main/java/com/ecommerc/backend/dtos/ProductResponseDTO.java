package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.ProductCategory;

public record ProductResponseDTO(
        long id,
        String name,
        String description,
        String image_url,
        ProductCategory category,
        float price,
        int stock
) { }
