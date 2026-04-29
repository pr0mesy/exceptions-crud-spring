package com.proenca.exceptions.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        BigDecimal price
) {}
