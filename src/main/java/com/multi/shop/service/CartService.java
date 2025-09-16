package com.multi.shop.service;

import com.multi.shop.domain.CartItem;
import com.multi.shop.domain.CartItemView;
import com.multi.shop.domain.Product;
import com.multi.shop.mapper.CartMapper;
import com.multi.shop.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartMapper cartMapper;
    private final ProductMapper productMapper;

    public List<CartItemView> list(String sessionId) {
        return cartMapper.findBySession(sessionId);
    }

    @Transactional
    public void add(String sessionId, Long productId, int qty) {
        Product p = productMapper.findById(productId);
        if (p == null) throw new IllegalArgumentException("상품이 존재하지 않습니다.");
        if (qty <= 0) qty = 1;

        CartItem exist = cartMapper.findOneBySessionAndProduct(sessionId, productId);
        if (exist == null) {
            CartItem item = new CartItem();
            item.setSessionId(sessionId);
            item.setProductId(productId);
            item.setQuantity(qty);
            item.setUnitPrice(p.getPrice());
            cartMapper.insert(item);
        } else {
            cartMapper.updateQuantity(exist.getId(), exist.getQuantity() + qty);
        }
    }

    @Transactional
    public void updateQty(Long cartId, int qty) {
        if (qty <= 0) qty = 1;
        cartMapper.updateQuantity(cartId, qty);
    }

    @Transactional
    public void remove(Long cartId) {
        cartMapper.deleteById(cartId);
    }

    @Transactional
    public void clear(String sessionId) {
        cartMapper.deleteBySession(sessionId);
    }

    public int totalAmount(String sessionId) {
        return list(sessionId).stream().mapToInt(CartItemView::getLineTotal).sum();
    }
}

