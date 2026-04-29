package com.proenca.exceptions.mapper;

import com.proenca.exceptions.dtos.ProductRequestDTO;
import com.proenca.exceptions.dtos.ProductResponseDTO;
import com.proenca.exceptions.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductResponseDTO toDTO(Product product);

    Product toEntity(ProductRequestDTO dto);

    void updateEntity(ProductRequestDTO dto, @MappingTarget Product entity);
}
