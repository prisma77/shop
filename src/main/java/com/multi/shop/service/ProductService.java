package com.multi.shop.service;

import com.multi.shop.domain.Product;
import com.multi.shop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper productMapper;

    public List<Product> list() {
        return productMapper.findAll();
    }

    public Product get(Long id) {
        return productMapper.findById(id);
    }
}

