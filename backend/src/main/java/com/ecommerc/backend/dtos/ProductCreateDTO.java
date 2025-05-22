package com.ecommerc.backend.dtos;

import com.ecommerc.backend.enuns.ProductCategory;

public record ProductCreateDTO(
        String name,
        String description,
        String image_url,
        ProductCategory category,
        float price,
        int stock
) { }
