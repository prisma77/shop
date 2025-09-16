package com.multi.shop.mapper;

import com.multi.shop.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<Product> findAll();
    Product findById(@Param("id") Long id);
    int decreaseStock(@Param("id") Long id, @Param("qty") int qty);
}

