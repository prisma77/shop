package com.multi.shop.mapper;

import com.multi.shop.domain.CartItem;
import com.multi.shop.domain.CartItemView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartItemView> findBySession(@Param("sessionId") String sessionId);

    CartItem findOneBySessionAndProduct(@Param("sessionId") String sessionId,
                                        @Param("productId") Long productId);

    int insert(CartItem item);
    int updateQuantity(@Param("id") Long id, @Param("quantity") int quantity);
    int deleteById(@Param("id") Long id);
    int deleteBySession(@Param("sessionId") String sessionId);
}

