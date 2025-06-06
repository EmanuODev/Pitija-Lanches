package com.ecommerc.backend.dtos.product;

import java.util.List;

public record ProductJsonDTO(

    List<ProductResponseDTO> hamburgers,
    List<ProductResponseDTO> salty,
    List<ProductResponseDTO> sugary,
    List<ProductResponseDTO> drinks,
    String message

) { }
