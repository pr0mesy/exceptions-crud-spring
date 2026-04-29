package com.proenca.exceptions.service;

import com.proenca.exceptions.dtos.ProductRequestDTO;
import com.proenca.exceptions.dtos.ProductResponseDTO;
import com.proenca.exceptions.entity.Product;
import com.proenca.exceptions.exceptions.ProductNotFoundException;
import com.proenca.exceptions.mapper.ProductMapper;
import com.proenca.exceptions.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public List<ProductResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public ProductResponseDTO findById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + id));
        return mapper.toDTO(product);
    }

    @Transactional
    public ProductResponseDTO create(@Valid ProductRequestDTO dto) {
        Product product = mapper.toEntity(dto);
        product = repository.save(product);
        return mapper.toDTO(product);
    }


    @Transactional
    public ProductResponseDTO update(Long id, @Valid ProductRequestDTO dto) {
        Product existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found: " + id));
        mapper.updateEntity(dto, existing);
        existing = repository.save(existing);
        return mapper.toDTO(existing);
    }

    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Product not found: " + id);
        }
        repository.deleteById(id);
    }
}
